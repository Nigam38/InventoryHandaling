package table;

import daos.ItemDAO;
import database.DBTables;
import database.DatabaseConnection;
import javafx.scene.control.Alert;
import pojo.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemTable implements ItemDAO {
        DatabaseConnection db = DatabaseConnection.getInstance();
        ArrayList<Item> items;
    @Override
    public ArrayList<Item> getAllItems() {
//        String query = "SELECT * FROM " + DBTables.TABLE_ITEM;
//        items = new ArrayList<Item>();
//        try {
//            Statement getItems = db.getConnection().createStatement();
//            ResultSet data = getItems.executeQuery(query);
//            while(data.next()) {
//                items.add(new Item(data.getInt(DBTables.ITEM_ID),
//                        data.getInt(DBTables.ITEM_CAT_ID),
//                        data.getInt(DBTables.ITEM_NAME),
//                        data.getInt(DBTables.ITEM_PRICE)));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return items;
        return null;
    }

    @Override
    public Item getItem(int itemID) {
//        String query = "SELECT FROM " + DBTables.TABLE_ITEM + " WHERE " +
//                DBTables.ITEM_ID + " = " + itemID;
//        Item item = new Item();
//        try {
//            Statement getItem = db.getConnection().createStatement();
//            ResultSet data = getItem.executeQuery(query);
//            data.next();
//            items.add(new Item(data.getInt(DBTables.ITEM_ID),
//                    data.getInt(DBTables.ITEM_CAT_ID),
//                    data.getInt(DBTables.ITEM_NAME),
//                    data.getInt(DBTables.ITEM_PRICE)));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return item;
        return null;
    }

    @Override
    public void deleteItem(int id) {
//        String query  = "DELETE FROM " + DBTables.TABLE_ITEM + " WHERE " +
//                DBTables.ITEM_ID + " = " + id;
//        try {
//            db.getConnection().createStatement().execute(query);
//            System.out.println("Deleted record");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void createItem(Item item) {
        String query = "INSERT INTO " + DBTables.TABLE_ITEM +
                "(" + DBTables.ITEM_CAT_NAME + ", " +
                DBTables.ITEM_NAME + "," +
                DBTables.ITEM_PRICE + ") VALUES ('" +
                item.getCat_name() + "','" + item.getName() + "','" +
                item.getPrice() +
                "')";
        try {
            db.getConnection().createStatement().execute(query);
            Alert alert;
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText("");
            alert.setContentText("Data inserted");
            alert.show();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
