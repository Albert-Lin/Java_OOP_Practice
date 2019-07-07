# Class 類別
類別可以說是一種設計稿，我們在設計稿裡面定義了各種"資料"和"功能"，
而這些資料與功能，都繞著一個特定的核心或是議題。
當我們有了設計稿之後，我們會再用這個設計稿去建立出完全符合設計稿的實體物件。
然而這些時做出來的實體物件，彼此之間是互相獨立，彼此沒有直接關係。

## Class - Object: 設計稿 - 實際物件
以程式設計最經典的例子"汽車"為例:
車廠在開發一款新的汽車時，一定會先定義:
1. 車架的外型
2. 左駕/右駕
3. 引擎
4. 輪胎
5. 座椅數量
6. 車子的電子配備
7. 啟動功能
8. 加速功能
9. 減速功能
10. 油量顯示功能
11. 目前時速顯示功能

上述這些資料(data, 01 - 06)以及功能(function, 07 - 11)，都是設計告內所擁有並明確定義好的，
接著進入量產的時候，在生產線中，車廠一定會按照上述的設計稿開發生產，
這一部部量產出來的實體汽車，就是我們所謂的物件(Object)。

## 實際案例
接著我們再以實際開發"人員管理系統"為案例:
人員管理系統是針對"人員"進行新增、修改、刪除、查詢和儲存個人檔案等動作。

針對"人員"，我們可以將所有與"人員"這個的資料(data)定義在一起如下:
* 人員:
    * 編號
    * 姓名
    * 手機
    * email
    * 地址
    * 頭像照片
    
從上述的定義，我們整合與羅列出所有和"人員"有關的資料，
仔細看我們所整合的資料，其實就與 DB schema 相同，
進一步將上述的"人員"資訊轉換成 code 就會如下面表示:

```java
class User {
    public int id;
    public String name;
    public String phoneNumber;
    public String email;
    public String address;
    public String image;
}
```
    
接下來如開頭所描述，類別除了資料還包括動作(功能)，
因此想像一下，因為所有的人員資料都存在資料庫，
為了能存取、查詢、人員資料，我們可以將所有與"人員"
相關的 DB 功能，一併整理至"人員"這個抽象概念:
* 人員:
    * 新增
    * 修改
    * 刪除
    * 依單一欄位查詢
    
同樣的，我們將上述的功能描述轉換為 code 就會如下面表示:
```java
class User {
    private Object dbExecuteQuery (String query) {
        // 執行 query
        return new Object();
    }
    
    /**
     * 將資料存入 user 資料表
     */
    public void insert() {
        String insertQueryString = "INSERT INTO `user` (`id`, `name`, `phone_number`, `email`, `address`, `image`) VALUES ('%d', '%s', '%s', '%s', '%s', '%s')";
        String query = String.format(insertQueryString, id, name, phoneNumber, email, address, image);
        dbExecuteQuery(query);
    }
    
    /**
     * 以人員編號刪除資料
     */
    public void delete() {
        String deleteQueryString = "DELETE FROM `user` WHERE `id` = '%d'";
        String query = String.format(deleteQueryString, id);
        dbExecuteQuery(query);
    }
    
    /**
     * 修改人員資料
     */
    public void update() {
        // ...
    }
    
    /**
     * 以單一欄位查詢人員資料
     */
    public void select(String key, Object value) {
        // ...
    }
}
```

那進一步整合上述"資料"與"動作"後即為:
```java
class User {
    public int id;
    public String name;
    public String phoneNumber;
    public String email;
    public String address;
    public String image;
    
    private Object dbExecuteQuery (String query) {
        // 執行 query
        return new Object();
    }
    
    /**
     * 將資料存入 user 資料表
     */
    public void insert() {
        String insertQueryString = "INSERT INTO `user` (`id`, `name`, `phone_number`, `email`, `address`, `image`) VALUES ('%d', '%s', '%s', '%s', '%s', '%s')";
        String query = String.format(insertQueryString, id, name, phoneNumber, email, address, image);
        dbExecuteQuery(query);
    }
    
    /**
     * 以人員編號刪除資料
     */
    public void delete() {
        String deleteQueryString = "DELETE FROM `user` WHERE `id` = '%d'";
        String query = String.format(deleteQueryString, id);
        dbExecuteQuery(query);
    }
    
    /**
     * 修改人員資料
     */
    public void update() {
        // ...
    }
    
    /**
     * 以單一欄位查詢人員資料
     */
    public void select(String key, Object value) {
        // ...
    }
}
```

至此，我們便將"人員"這個概念抽象化，並轉換為 code

## 資料與方法的"權限"
在 class 中，資料與方法分為下列三種權限:
* public: 公用，代表這些資料和方法，是可以被其他外部程式所使用
* protected: 保護，之後會在說明
* private: 私用，只有設計稿內所定義的其他功能和方法可以使用，外部程式不能使用

## "靜態"資料與方法 (static)
靜態資料與方法，的概念比較特別，所謂的靜態資料與方法，是指這些特定的資料與方法，是跟著設計稿走。
在資料方面，在整個系統裡面只有一份，一個地方更動了，就整個系統的這個資料會跟著改變。
在方法方面，方法裡面所用到的資料，都跟物件本身沒有關係。

靜態資料，我們以"人員"類別為例子，甚麼東西是跟人員有關，卻又是所有物件都會是相同值的資料?
答案: 人員的資料表名稱 `user`。假設我們把資料表名稱設為公用(public)，如果有個地方將"人員的資料表名稱"改掉，
則整個程式系統的"人員的資料表名稱"就不會是`user`了。

靜態方法，我們以"汽車"為例，在整部汽車當中有些電子系統，是跟整部汽車的運作完全無關，
其中一個是"導航系統"，任何一個導航系統的資料，都是來自"汽車公司(導航公司)"，而且導航系統的運作，
與汽車運行沒有直接關連，然而導航系統又確實屬於(存在)於"汽車"這個設計當中。
