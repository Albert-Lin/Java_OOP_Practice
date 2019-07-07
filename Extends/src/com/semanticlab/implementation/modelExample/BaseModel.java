package com.semanticlab.implementation.modelExample;

import java.util.Date;

/*
 * 所有可以被繼承的資料或是方法，其"權限"必須是"public"或是"protected"
 * 其中，"protected"代表的是，原本是私用(即其他程式不能使用)，但為了被繼承，
 * 所以只限定，繼承的類別 & 物件可以使用。
 */

public class BaseModel {
    protected static String tableName;
    protected int id;
    protected Date createAt;
    protected Date modifyAt;
    protected Date deleteAt;

    public int getId() {
        return this.id;
    }

    public Date getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getModifyAt() {
        return this.modifyAt;
    }

    public void setModifyAt(Date modifyAt) {
        this.modifyAt = modifyAt;
    }

    public Date getDeleteAt() {
        return this.deleteAt;
    }

    public void setDeleteAt(Date deleteAt) {
        this.deleteAt = deleteAt;
    }

    public static void deleteById(int id) {

    }

    public static BaseModel searchById(int id) {
        return null;
    }
}
