package database;

public class DBTables {

    //LOGIN TABLE
    public static final String TABLE_LOGIN = "java_login";
    public static final String LOGIN_USER = "user";
    public static final String LOGIN_PASSWORD = "password";

    //CATEGORY TABLE
    public static final String TABLE_CATEGORY = "java_category";
    public static final String CATEGORY_ID = "id";
    public static final String CATEGORY_NAME = "name";

    //ITEM_NAME TABLE
    public static final String TABLE_ITEM_NAME = "java_item_name";
    public static final String ITEM_NAME_ID = "id";
    public static final String ITEM_NAME_NAME = "name";

    //ITEMS TABLE
    public static final String TABLE_ITEM = "java_items";
    public static final String ITEM_ID = "id";
    public static final String ITEM_CAT_NAME = "cat_name";
    public static final String ITEM_NAME = "name";
    public static final String ITEM_PRICE = "price";



    //CRUD
    public static final String CREATE_TABLE_LOGIN =
            "CREATE TABLE " + TABLE_LOGIN + "(" +
                    LOGIN_USER + " VARCHAR(30), " +
                    LOGIN_PASSWORD + " VARCHAR(10), " +
                    "PRIMARY KEY(" + LOGIN_USER + ")" +
                    ")";

    public static final String CREATE_TABLE_CATEGORY =
            "CREATE TABLE " + TABLE_CATEGORY + "(" +
                    CATEGORY_ID + " int NOT NULL AUTO_INCREMENT, " +
                    CATEGORY_NAME + " VARCHAR(25), " +
                    "PRIMARY KEY(" + CATEGORY_ID + ")" +
                    ")";

    public static final String CREATE_TABLE_ITEM_NAME =
            "CREATE TABLE " + TABLE_ITEM_NAME + "(" +
                    ITEM_NAME_ID + " int NOT NULL AUTO_INCREMENT, " +
                    ITEM_NAME_NAME + " VARCHAR(25), " +
                    "PRIMARY KEY(" + ITEM_NAME_ID + ")" +
                    ")";

    public static final String CREATE_TABLE_ITEM =
            "CREATE TABLE " + TABLE_ITEM + "("+
                    ITEM_ID + " int NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
<<<<<<< HEAD
                    ITEM_CAT_NAME + " int NOT NULL, " +
                    ITEM_NAME + " int NOT NULL, " +
                    ITEM_PRICE + " int(2) NOT NULL, " +
                    "FOREIGN KEY (" + ITEM_NAME + ")" +
                    " REFERENCES " + TABLE_ITEM_NAME + "(" + ITEM_NAME_ID + "),"+
                    "FOREIGN KEY (" + ITEM_CAT_NAME + ")" +
                    " REFERENCES " + TABLE_CATEGORY + "(" + CATEGORY_ID + "))";
=======
                    ITEM_CAT_ID + " int NOT NULL, " +
                    ITEM_NAME + " VARCHAR(20) NOT NULL, " +
                    ITEM_PRICE + " decimal(4,2) NOT NULL, " +
                    "FOREIGN KEY (" + ITEM_CAT_ID + ")" + " REFERENCES " + TABLE_CATEGORY + "(" + CATEGORY_ID + "))";



>>>>>>> fffb1f6ab7893a2ae17c140f1a855bf61b45be3f

}
