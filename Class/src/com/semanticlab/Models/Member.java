package com.semanticlab.Models;

import java.util.HashMap;
import java.util.Map;

public class Member {
    // [data]
    // =======================================================
    // 為了避免被其他惡意程式直接修改資料，
    // 我們會將資料的全線改為私用 (private)，
    // 也就是只有 Member 裡面定義的 function 才可以使用
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String image;
    // =======================================================


    // [constructor]
    // =======================================================
    /**
     * 初始 Member 物件的方法，我們稱為"建構子"
     * @param name - 姓名
     * @param phoneNumber - 手機
     * @param email - email
     * @param address - 地址
     * @param image - 頭像照片
     */
    public Member (int id, String name, String phoneNumber, String email, String address, String image) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.image = image;
    }
    // =======================================================


    // [function]
    // =======================================================
    // 因為物件的資料全線都設定為 private，因此我們會針對資料設計若干可以存取物件資料的方法
    // id (只允許讀取):
    public int getID () {
        return id;
    }

    // name:
    public String getFullName() {
        return name;
    }

    public String getFirstName() {
        return name.split(" ")[0];
    }

    public String getLastName() {
        return name.split(" ")[1];
    }

    public void setName(String name) {
        this.name = name;
    }

    // phoneNumber:
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // email (只允許讀取):
    public String getEmail() {
        return email;
    }

    // address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // image
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    // =======================================================



    // [function]
    // =======================================================
    private Object dbExecuteQuery (String query) {
        // 執行 query ...
        return new Object();
    }

    /**
     * 將資料存入 member 資料表
     */
    public void insert() {
        // 組出 SQL 語法:
        String insertQueryString = "INSERT INTO `member` (`name`, `phone_number`, `email`, `address`, `image`) VALUES ('%s', '%s', '%s', '%s', '%s')";
        String query = String.format(insertQueryString, id, name, phoneNumber, email, address, image);
        // 執行 SQL 語法:
        dbExecuteQuery(query);
    }

    /**
     * 以人員編號刪除資料
     */
    public void delete() {
        // 組出 SQL 語法:
        String deleteQueryString = "DELETE FROM `member` WHERE `id` = '%d'";
        String query = String.format(deleteQueryString, id);
        // 執行 SQL 語法:
        dbExecuteQuery(query);
    }

    /**
     * 修改人員資料
     */
    public void update() {
        // 組出 SQL 語法:
        String updateQueryString = "UPDATE `member` SET" +
                "`id` = '%d'," +
                "`name` = '%s'," +
                "`phoneNumber` = '%s'," +
                "`email` = '%s'," +
                "`address` = '%s'," +
                "`image` = '%s'" +
                "WHERE `id` = '%d'";
        String query = String.format(updateQueryString, id, name, phoneNumber, email, address, image, id);
        // 執行 SQL 語法:
        dbExecuteQuery(query);
    }
    // =======================================================

    

    // [static]
    // =======================================================
    private static Object dbStaticExecuteQuery (String query) {
        // 執行 query ...
        return new Object();
    }
    // 因為通常我們希望查詢完 DB 資料之後，直接生成一個"人員"物件，
    // 因此我們會將此方法設計為"靜態方法"
    // 而靜態方法代表的是，此方法內沒有用到"實體物件"中的其他資料或方法，
    // 然而他又與此類別(概念)有關
    /**
     * 以單一欄位查詢人員資料
     * @param key - 欄位名稱
     * @param value - 欄位資料
     * @return - 人員物件
     */
    public static Member select(String key, Object value) {
        // 組出 SQL 語法:
        String selectQueryString = "SELECT * FROM `member` WHERE %s = '%s'";
        String query = String.format(selectQueryString, key, value.toString());
        // 執行 SQL 語法:
        Map<String, Object> selectResult = (HashMap)Member.dbStaticExecuteQuery(query);

        // 取出查詢結果的資料:
        int id = (int)selectResult.get("id");
        String name = selectResult.get("name").toString();
        String phoneNumber = selectResult.get("phoneNumber").toString();
        String email = selectResult.get("email").toString();
        String address = selectResult.get("address").toString();
        String image = selectResult.get("image").toString();

        // 產生新的 Member 物件
        Member memberInstance = new Member(id, name, phoneNumber, email, address, image);

        // 回傳 Member 物件
        return memberInstance;
    }

    public static void deleteUserById(int userId) {
        // 組出 SQL 語法:
        String deleteQueryString = "DELETE FROM `member` WHERE `id` = '%d'";
        String query = String.format(deleteQueryString, userId);
        Member.dbStaticExecuteQuery(query);
    }
}
