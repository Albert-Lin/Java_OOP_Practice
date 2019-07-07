package com.semanticlab.implementation.modelExample;

import com.semanticlab.implementation.modelExample.BaseModel;
import com.semanticlab.implementation.modelExample.IModelAction;

public class User extends BaseModel implements IModelAction {
    private static String tableName = "user";
    private String name;
    private String email;
    private String phone;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void insert() {
        System.out.println("模擬加入使用者: " + this.email);
    }

    public void delete() {
        System.out.println("模擬刪除使用者: " + this.email);
    }

    public void update() {
        System.out.println("模擬更新使用者: " + this.email);
    }
}
