package com.example.dewioktaviani.explorepos.Data.common;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Dewi Oktaviani on 12/14/2017.
 */
@DatabaseTable
public class clsItem implements Serializable {
    @DatabaseField(id = true, columnName = "itemId")
    private int itemId;
    @DatabaseField (columnName = "txtItemCode")
    private String txtItemCode;
    @DatabaseField (columnName = "txtItemName")
    private String txtItemName;
    @DatabaseField (columnName = "txtPrice")
    private String txtPrice;
    @DatabaseField (columnName = "txtCategory")
    private String txtCategory;
    @DatabaseField (columnName = "txtStock")
    private String txtStock;
    @DatabaseField (columnName = "txtVarian")
    private String txtVarian;
    @DatabaseField (columnName = "bitActive")
    private int bitActive;
    @DatabaseField (columnName = "txtInsertedBy")
    private String txtInsertedBy;
    @DatabaseField (columnName = "txtUpdatedBy")
    private String txtUpdatedBy;
    @DatabaseField (columnName = "txtInserted")
    private String txtInserted;
    @DatabaseField (columnName = "txtUpdated")
    private String txtUpdated;

    public clsItem(){}
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getTxtItemCode() {
        return txtItemCode;
    }

    public void setTxtItemCode(String txtItemCode) {
        this.txtItemCode = txtItemCode;
    }

    public String getTxtItemName() {
        return txtItemName;
    }

    public void setTxtItemName(String txtItemName) {
        this.txtItemName = txtItemName;
    }

    public String getTxtPrice() {
        return txtPrice;
    }

    public void setTxtPrice(String txtPrice) {
        this.txtPrice = txtPrice;
    }

    public String getTxtCategory() {
        return txtCategory;
    }

    public void setTxtCategory(String txtCategory) {
        this.txtCategory = txtCategory;
    }

    public String getTxtStock() {
        return txtStock;
    }

    public void setTxtStock(String txtStock) {
        this.txtStock = txtStock;
    }

    public String getTxtVarian() {
        return txtVarian;
    }

    public void setTxtVarian(String txtVarian) {
        this.txtVarian = txtVarian;
    }

    public int getBitActive() {
        return bitActive;
    }

    public void setBitActive(int bitActive) {
        this.bitActive = bitActive;
    }

    public String getTxtInsertedBy() {
        return txtInsertedBy;
    }

    public void setTxtInsertedBy(String txtInsertedBy) {
        this.txtInsertedBy = txtInsertedBy;
    }

    public String getTxtUpdatedBy() {
        return txtUpdatedBy;
    }

    public void setTxtUpdatedBy(String txtUpdatedBy) {
        this.txtUpdatedBy = txtUpdatedBy;
    }

    public String getTxtInserted() {
        return txtInserted;
    }

    public void setTxtInserted(String txtInserted) {
        this.txtInserted = txtInserted;
    }

    public String getTxtUpdated() {
        return txtUpdated;
    }

    public void setTxtUpdated(String txtUpdated) {
        this.txtUpdated = txtUpdated;
    }
}
