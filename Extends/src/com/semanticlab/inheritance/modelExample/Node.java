package com.semanticlab.inheritance.modelExample;

public class Node extends BaseModel {
    private static String tableName = "node";
    private int parentId = 0;
    private String title;
    private String description;
    private boolean hidden;

    public int getParentId() {
        return this.parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getHidden() {
        return this.hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public void insert() {
        System.out.println("模擬加入節點: " + this.title);
    }

    public void delete() {
        System.out.println("模擬刪除節點: " + this.title);
    }

    public void update() {
        System.out.println("模擬更新節點: " + this.title);
    }
}
