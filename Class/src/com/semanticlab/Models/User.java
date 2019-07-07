package com.semanticlab.Models;

import java.util.HashMap;
import java.util.Map;

public class User {
    public int id;
    public String name;
    public String phoneNumber;
    public String email;
    public String address;
    public String image;

    private Object dbExecuteQuery (String query) {
        // 執行 query ...
        return new Object();
    }

    /**
     * 將資料存入 user 資料表
     */
    public void insert() {
        // 組出 SQL 語法:
        String insertQueryString = "INSERT INTO `user` (`name`, `phone_number`, `email`, `address`, `image`) VALUES ('%s', '%s', '%s', '%s', '%s')";
        String query = String.format(insertQueryString, id, name, phoneNumber, email, address, image);
        // 執行 SQL 語法:
        dbExecuteQuery(query);
    }

    /**
     * 以人員編號刪除資料
     */
    public void delete() {
        // 組出 SQL 語法:
        String deleteQueryString = "DELETE FROM `user` WHERE `id` = '%d'";
        String query = String.format(deleteQueryString, id);
        // 執行 SQL 語法:
        dbExecuteQuery(query);
    }

    /**
     * 修改人員資料
     */
    public void update() {
        // 組出 SQL 語法:
        String updateQueryString = "UPDATE `user` SET" +
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

    /**
     * 以單一欄位查詢人員資料
     */
    public void select(String key, Object value) {
        // 組出 SQL 語法:
        String selectQueryString = "SELECT * FROM `user` WHERE %s = '%s'";
        String query = String.format(selectQueryString, key, value.toString());
        // 執行 SQL 語法:
        Map<String, Object> selectResult = (HashMap)dbExecuteQuery(query);
        // 將結果綁定至資料中:
        id = (int)selectResult.get("id");
        name = selectResult.get("name").toString();
        phoneNumber = selectResult.get("phoneNumber").toString();
        email = selectResult.get("email").toString();
        address = selectResult.get("address").toString();
        image = selectResult.get("image").toString();
    }
}
