package database;

public class DBTables {

    //CATEGORY TABLE
    public static final String TABLE_CATEGORY = "category";
    public static final String CATEGORY_ID = "id";
    public static final String CATEGORY_NAME = "name";

    //BEVERAGE TABLE
    public static final String TABLE_BEVERAGE = "beverage";
    public static final String BEVERAGE_ID = "id";
    public static final String BEVERAGE_NAME = "name";
    public static final String BEVERAGE_DESCRIPTION = "description";
    public static final String BEVERAGE_PRICE = "price";

    //DAIRY_ITEM TABLE
    public static final String TABLE_DAIRY_ITEM = "beverage";
    public static final String DAIRY_ITEM_ID = "id";
    public static final String DAIRY_ITEM_NAME = "name";
    public static final String DAIRY_ITEM_DESCRIPTION = "description";
    public static final String DAIRY_ITEM_PRICE = "price";

    //VEGETABLE TABLE
    public static final String TABLE_VEGETABLE = "beverage";
    public static final String VEGETABLE_ID = "id";
    public static final String VEGETABLE_NAME = "name";
    public static final String VEGETABLE_DESCRIPTION = "description";
    public static final String VEGETABLE_PRICE = "price";

    //CRUD
    public static final String CREATE_TABLE_CATEGORY =
            "CREATE TABLE " + TABLE_CATEGORY + "(" +
                    CATEGORY_ID + " int NOT NULL AUTO_INCREMENT, " +
                    CATEGORY_NAME + " VARCHAR(25), " +
                    "PRIMARY KEY(" + CATEGORY_ID + ")" +
                    ")";


}
