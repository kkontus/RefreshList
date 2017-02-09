package com.kkontus.refreshlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by kristijan on 09/02/2017.
 */

public class ListItemsHandler extends SQLiteOpenHelper {

    public static final String DB_PATH = "/data/data/com.exads.mobile.refreshlist/databases/";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Ebill";

    private static final String TABLE_LIST_ITEMS = "ListItems";
    private static final String KEY_ID = "_id";
    private static final String KEY_CATALOG_ID = "catalogId";
    private static final String KEY_PRICE = "price";
    private static final String KEY_PRICE_WITH_TAX = "priceWithTax";
    private static final String KEY_TAX = "tax";
    private static final String KEY_PARENT_ID = "parentId";
    private static final String KEY_TYPE = "type";
    private static final String KEY_STATUS = "status";
    private static final String KEY_DATE_MODEFIED = "dateModified";
    private static final String KEY_NAME = "name";


    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE "
            + TABLE_LIST_ITEMS
            + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            + KEY_CATALOG_ID + " INTEGER,"
            + KEY_PRICE + " INTEGER,"
            + KEY_PRICE_WITH_TAX + " INTEGER,"
            + KEY_TAX + " INTEGER,"
            + KEY_PARENT_ID + " INTEGER,"
            + KEY_TYPE + " VARCHAR(100) DEFAULT NULL,"
            + KEY_STATUS + " INTEGER,"
            + KEY_DATE_MODEFIED + " INTEGER,"
            + KEY_NAME + " VARCHAR(100) DEFAULT NULL"
            + ");";

    private static final String SQL_DELETE_ENTRIES = "DELETE FROM " + TABLE_LIST_ITEMS + ";";
    private static final String SQL_TRUNCATE_ENTRIES = "TRUNCATE " + TABLE_LIST_ITEMS + ";";

    public ListItemsHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy
        // is to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void addImageUploadStatus(SQLiteDatabase database, ListItems listItem) {

        //SQLiteDatabase database = DatabaseManager.getInstance().openDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CATALOG_ID, 1);
        values.put(KEY_PRICE, 1);
        values.put(KEY_PRICE_WITH_TAX, 1);
        values.put(KEY_TAX, 1);
        values.put(KEY_PARENT_ID, 0);
        values.put(KEY_TYPE, "Category");
        values.put(KEY_STATUS, 1);
        values.put(KEY_DATE_MODEFIED, 1);
        values.put(KEY_NAME, "Android");
        database.insert(TABLE_LIST_ITEMS, null, values);


        ContentValues values1 = new ContentValues();
        values1.put(KEY_CATALOG_ID, 1);
        values1.put(KEY_PRICE, 1);
        values1.put(KEY_PRICE_WITH_TAX, 1);
        values1.put(KEY_TAX, 1);
        values1.put(KEY_PARENT_ID, 0);
        values1.put(KEY_TYPE, "Category");
        values1.put(KEY_STATUS, 1);
        values1.put(KEY_DATE_MODEFIED, 1);
        values1.put(KEY_NAME, "iPhone");
        database.insert(TABLE_LIST_ITEMS, null, values1);


        ContentValues values2 = new ContentValues();
        values2.put(KEY_CATALOG_ID, 1);
        values2.put(KEY_PRICE, 1);
        values2.put(KEY_PRICE_WITH_TAX, 1);
        values2.put(KEY_TAX, 1);
        values2.put(KEY_PARENT_ID, 1);
        values2.put(KEY_TYPE, "Category");
        values2.put(KEY_STATUS, 1);
        values2.put(KEY_DATE_MODEFIED, 1);
        values2.put(KEY_NAME, "Samsung S5");
        database.insert(TABLE_LIST_ITEMS, null, values2);


        ContentValues values4 = new ContentValues();
        values4.put(KEY_CATALOG_ID, 1);
        values4.put(KEY_PRICE, 1);
        values4.put(KEY_PRICE_WITH_TAX, 1);
        values4.put(KEY_TAX, 1);
        values4.put(KEY_PARENT_ID, 3);
        values4.put(KEY_TYPE, "Item");
        values4.put(KEY_STATUS, 1);
        values4.put(KEY_DATE_MODEFIED, 1);
        values4.put(KEY_NAME, "Samsung S5 mini");
        database.insert(TABLE_LIST_ITEMS, null, values4);

        ContentValues values5 = new ContentValues();
        values5.put(KEY_CATALOG_ID, 1);
        values5.put(KEY_PRICE, 1);
        values5.put(KEY_PRICE_WITH_TAX, 1);
        values5.put(KEY_TAX, 1);
        values5.put(KEY_PARENT_ID, 3);
        values5.put(KEY_TYPE, "Item");
        values5.put(KEY_STATUS, 1);
        values5.put(KEY_DATE_MODEFIED, 1);
        values5.put(KEY_NAME, "Samsung S5 core");
        database.insert(TABLE_LIST_ITEMS, null, values5);


        ContentValues values3 = new ContentValues();
        values3.put(KEY_CATALOG_ID, 1);
        values3.put(KEY_PRICE, 1);
        values3.put(KEY_PRICE_WITH_TAX, 1);
        values3.put(KEY_TAX, 1);
        values3.put(KEY_PARENT_ID, 2);
        values3.put(KEY_TYPE, "Item");
        values3.put(KEY_STATUS, 1);
        values3.put(KEY_DATE_MODEFIED, 1);
        values3.put(KEY_NAME, "iPhone 5");
        database.insert(TABLE_LIST_ITEMS, null, values3);

        ContentValues values6 = new ContentValues();
        values6.put(KEY_CATALOG_ID, 1);
        values6.put(KEY_PRICE, 1);
        values6.put(KEY_PRICE_WITH_TAX, 1);
        values6.put(KEY_TAX, 1);
        values6.put(KEY_PARENT_ID, 6);
        values6.put(KEY_TYPE, "Item");
        values6.put(KEY_STATUS, 1);
        values6.put(KEY_DATE_MODEFIED, 1);
        values6.put(KEY_NAME, "iPhone 5C");
        database.insert(TABLE_LIST_ITEMS, null, values6);

        ContentValues values7 = new ContentValues();
        values7.put(KEY_CATALOG_ID, 1);
        values7.put(KEY_PRICE, 1);
        values7.put(KEY_PRICE_WITH_TAX, 1);
        values7.put(KEY_TAX, 1);
        values7.put(KEY_PARENT_ID, 6);
        values7.put(KEY_TYPE, "Item");
        values7.put(KEY_STATUS, 1);
        values7.put(KEY_DATE_MODEFIED, 1);
        values7.put(KEY_NAME, "iPhone 5S");
        database.insert(TABLE_LIST_ITEMS, null, values7);


        ContentValues values8 = new ContentValues();
        values8.put(KEY_CATALOG_ID, 1);
        values8.put(KEY_PRICE, 1);
        values8.put(KEY_PRICE_WITH_TAX, 1);
        values8.put(KEY_TAX, 1);
        values8.put(KEY_PARENT_ID, 6);
        values8.put(KEY_TYPE, "Item");
        values8.put(KEY_STATUS, 1);
        values8.put(KEY_DATE_MODEFIED, 1);
        values8.put(KEY_NAME, "iPhone 5S Plus");
        database.insert(TABLE_LIST_ITEMS, null, values8);

        //DatabaseManager.getInstance().closeDatabase();
    }

    public ArrayList<ListItems> getAllImageUploadStatusItems(SQLiteDatabase database, String id, String parentId, String name) {

        //SQLiteDatabase database = DatabaseManager.getInstance().openDatabase();

        String countQuery;
        if (id != null && parentId != null && name != null) {
            countQuery = "SELECT * FROM " + TABLE_LIST_ITEMS + " WHERE " + KEY_ID + "='" + id + "' AND " + KEY_PARENT_ID + "='" + parentId + "' AND " + KEY_NAME + "='" + name + "'";
        } else if (id != null) {
            countQuery = "SELECT * FROM " + TABLE_LIST_ITEMS + " WHERE " + KEY_ID + "='" + id + "'";
        } else if (parentId != null) {
            countQuery = "SELECT * FROM " + TABLE_LIST_ITEMS + " WHERE " + KEY_PARENT_ID + "='" + parentId + "'";
        } else if (name != null) {
            countQuery = "SELECT * FROM " + TABLE_LIST_ITEMS + " WHERE " + KEY_NAME + "='" + name + "'";
        } else {
            countQuery = "SELECT * FROM " + TABLE_LIST_ITEMS;
        }

        Cursor cursor = database.rawQuery(countQuery, null);

        ArrayList<ListItems> listItemses = new ArrayList<ListItems>();
        while (cursor.moveToNext()) {
            ListItems listItems = null;
            try {
                listItems = new ListItems(cursor);
            } catch (Exception e) {
                e.printStackTrace();
            }
            listItemses.add(listItems);
        }

        cursor.close();
        //DatabaseManager.getInstance().closeDatabase();

        return listItemses;
    }

    public void deleteAllListItemsByName(SQLiteDatabase database, String name) {
        database.delete(TABLE_LIST_ITEMS, KEY_NAME + " = ?", new String[]{name});
    }

    public void deleteAllListItems(SQLiteDatabase database) {
        //String deleteQuery = "DELETE FROM " + TABLE_LIST_ITEMS;
        String deleteQuery = SQL_DELETE_ENTRIES;
        database.execSQL(deleteQuery);

        String deleteQueryReset = "DELETE FROM SQLITE_SEQUENCE WHERE name='" + TABLE_LIST_ITEMS + "'";
        database.execSQL(deleteQueryReset);

//        String deleteQueryVacum = "VACUUM;";
//        database.execSQL(deleteQueryVacum);
    }

    public void truncateAllListItems(SQLiteDatabase database) {
        //String deleteQuery = "TRUNCATE " + TABLE_LIST_ITEMS;
        String deleteQuery = SQL_TRUNCATE_ENTRIES;
        database.execSQL(deleteQuery);
    }

}