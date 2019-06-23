# 環境設定

## Java Development Kit
Java 官方基礎開發的函式庫(功能套件包)
1. 請擇一下載並安裝
    * [Java SE](https://www.oracle.com/technetwork/java/javase/downloads/index.html): 標準 Java 應用開發的函式庫
    * [Java EE](https://www.oracle.com/technetwork/java/javaee/downloads/index.html): 商用 Java 應用開發的函式庫

2. 將安裝路經加入系統環境變數
    * 找到安裝路徑: 例如: C:\Program Files\Java\jdk-12.0.1\bin (注意! 複製的路徑要到 bin 資料夾)
    * 開啟 "控制台\系統及安全性\系統"
    * 點選 "進階系統設定/環境變數"
    * 雙點擊 "系統變數/Path"
    * 點選 "新增"
    * 貼上複製的安裝路徑

3. 檢查是否安裝成功
    * 開啟終端機 (cmd / terminal): (開啟任一資料夾，在資料夾路徑上打 "cmd" 並按下 enter)
    * 輸入: java -version
    * 若顯示正確版本號代表安裝成功

## IDE (編輯器)
請擇一下載安裝:
1. [IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=windows): Community 版本
2. [Eclipse](https://www.eclipse.org/downloads/)
3. [NetBeans](https://netbeans.org/)

## [Java API](https://docs.oracle.com/javase/8/docs/api/)
Java 運作原理是在 JVM (Java 虛擬環境) 上進行編譯，
由於虛擬環境是 Java 自己設計的，透過此方式，忽略各種不同 OS 的差異。
在安裝完 JDK(Java Development Kit) 之後，代表可以使用 Java 的基礎函式與功能。
這些基礎的函示與功能可透過[官方文件](https://docs.oracle.com/javase/8/docs/api/)查詢其定義。

