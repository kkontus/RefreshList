package com.kkontus.refreshlist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] values = new String[]{"Android", "iPhone", "WindowsMobile",
            "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
            "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
            "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
            "Android", "iPhone", "WindowsMobile"};

    String[] valuesAndroid = new String[]{"Samsung S4", "Samsung S5", "Samsung S6"};
    String[] valuesIos = new String[]{"iPhone 5", "iPhone 6", "iPhone 7"};

    ArrayList<ListItems> list;
    ListItemsHandler listItemsHandler;
    ListView listview;
    //StableArrayAdapter adapter;
    StableBaseAdapter adapter;
    int currentLevelId = 0;
    int currentLevelParentId = 0;
    int levelCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItemsHandler = new ListItemsHandler(getApplicationContext());
        DatabaseManager.initializeInstance(listItemsHandler);
        SQLiteDatabase database = DatabaseManager.getInstance().openDatabase();

        //just for testing
        listItemsHandler.deleteAllListItems(database);
        listItemsHandler.addImageUploadStatus(database, null);

        ArrayList<ListItems> list = listItemsHandler.getAllImageUploadStatusItems(database, null, "0", null);
        DatabaseManager.getInstance().closeDatabase();


        listview = (ListView) findViewById(R.id.listview);
        adapter = new StableBaseAdapter(this, list);
        listview.setAdapter(adapter);
        final Context context = this;

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                ListItems item = (ListItems) parent.getItemAtPosition(position);
                populateListView(String.valueOf(item.getId()), String.valueOf(item.getParentId()), context, false);

//                view.animate().setDuration(2000).alpha(0).withEndAction(new Runnable() {
//                    @Override
//                    public void run() {
//                        list.remove(item);
//                        adapter.notifyDataSetChanged();
//                        view.setAlpha(1);
//                    }
//                });
            }

        });
    }

    private void populateListView(String id, String parentId, Context context, boolean isBackPress) {
        ArrayList<ListItems> listSublist = new ArrayList<ListItems>();

        listItemsHandler = new ListItemsHandler(getApplicationContext());
        DatabaseManager.initializeInstance(listItemsHandler);
        SQLiteDatabase database = DatabaseManager.getInstance().openDatabase();

        if (isBackPress) {
            listSublist = listItemsHandler.getAllImageUploadStatusItems(database, id, null, null);
        } else {
            listSublist = listItemsHandler.getAllImageUploadStatusItems(database, null, id, null);
        }

        DatabaseManager.getInstance().closeDatabase();

        if (listSublist.size() == 0) return;

        levelCount++;
        if (id != null) {
            currentLevelId = Integer.valueOf(id);
        }
        if (parentId != null) {
            currentLevelParentId = Integer.valueOf(parentId);
        }

        adapter.setListData(listSublist);
        adapter.notifyDataSetChanged();
        listview.setAdapter(adapter);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        levelCount = levelCount - 2;

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0 && currentLevelParentId != 0) {
            if (levelCount == 0) {
                populateListView("0", "0", this, false);
            } else {
                populateListView(String.valueOf(currentLevelParentId), String.valueOf(currentLevelId), this, true);
            }
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    private class StableBaseAdapter extends BaseAdapter {
        private List<ListItems> mObjects;
        private LayoutInflater layoutInflater;


        public StableBaseAdapter(Context context, List<ListItems> objects) {
            this.mObjects = objects;
            layoutInflater = LayoutInflater.from(context);
        }

        public void setListData(List<ListItems> objects) {
            this.mObjects = objects;
        }

        @Override
        public int getCount() {
            return mObjects.size();
        }

        @Override
        public Object getItem(int position) {
            return mObjects.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                //convertView = layoutInflater.inflate(android.R.layout.simple_list_item_1, null);
                convertView = layoutInflater.inflate(R.layout.item_row, null);
                holder = new ViewHolder();
                //holder.elementView = (TextView) convertView.findViewById(android.R.id.text1);
                holder.elementView = (TextView) convertView.findViewById(R.id.listItemName);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            currentLevelId = mObjects.get(position).getId();
            currentLevelParentId = mObjects.get(position).getParentId();

            holder.elementView.setText(mObjects.get(position).getName().toString());

            return convertView;
        }

        class ViewHolder {
            TextView elementView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}