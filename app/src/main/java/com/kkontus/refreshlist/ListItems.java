package com.kkontus.refreshlist;

import android.database.Cursor;

/**
 * Created by kristijan on 09/02/2017.
 */

public class ListItems extends Entity {

    //private static final long serialVersionUID = 1L;
    protected int catalogId = 0;
    protected float price = 0.0f;
    protected float priceWithTax = 0.0f;
    protected float tax = 0.0f;
    protected int parentId = 0;
    protected ListItems parent = null;
    protected String type = "";
    protected String name = "";

    //virtual fields
    //protected ArrayList<ListItems> children = null;

    public ListItems(int id, int status, int dateModified, int catalogId, float price, float priceWithTax, float tax, ListItems parent, String type, String name) throws Exception {
        super(id, status);

        this.setCatalogId(catalogId);
        this.setPrice(price);
        this.setPriceWithTax(priceWithTax);
        this.setTax(tax);
        this.setParent(parent);
        this.setType(type);
        this.setName(name);
    }

    public ListItems(int catalogId, float price, float priceWithTax, float tax, ListItems parent, String type, String name) throws Exception {
        super();

        this.setCatalogId(catalogId);
        this.setPrice(price);
        this.setPriceWithTax(priceWithTax);
        this.setTax(tax);
        this.setParent(parent);
        this.setType(type);
        this.setName(name);
    }

    public ListItems(Cursor cursor) throws Exception {
        super(cursor);

        this.setCatalogId(cursor.getInt(cursor.getColumnIndex("catalogId")));
        this.setPrice(cursor.getFloat(cursor.getColumnIndex("price")));
        this.setPriceWithTax(cursor.getFloat(cursor.getColumnIndex("priceWithTax")));
        this.setTax(cursor.getFloat(cursor.getColumnIndex("tax")));
        this.setParentId(cursor.getInt(cursor.getColumnIndex("parentId")));
        this.setType(cursor.getString(cursor.getColumnIndex("type")));
        this.setName(cursor.getString(cursor.getColumnIndex("name")));
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public float getPriceWithTax() {
        return priceWithTax;
    }

    public void setPriceWithTax(float priceWithTax) {
        this.priceWithTax = priceWithTax;
    }


    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }


    public ListItems getParent() {
        return parent;
    }

    public void setParent(ListItems parent) {
        this.parent = parent;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}