package table;

import daos.ItemDAO;
import database.DBTables;
import database.DatabaseConnection;
import javafx.scene.control.Alert;
import pojo.DisplayItem;
import pojo.Item;

import java.sql.PreparedStatement;
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
        String query = "SELECT * FROM " + DBTables.TABLE_ITEM;
        items = new ArrayList<Item>();
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                items.add(new Item(data.getInt(DBTables.ITEM_ID),
                        data.getInt(DBTables.ITEM_NAME),
                        data.getInt(DBTables.ITEM_CAT_NAME),
                        data.getInt(DBTables.ITEM_PRICE)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item getItem(int itemID) {
        String query = "SELECT FROM " + DBTables.TABLE_ITEM + " WHERE " +
                DBTables.ITEM_ID + " = " + itemID;
        Item item = new Item();
        try {
            Statement getItem = db.getConnection().createStatement();
            ResultSet data = getItem.executeQuery(query);
            data.next();
            items.add(new Item(data.getInt(DBTables.ITEM_ID),
                    data.getInt(DBTables.ITEM_NAME),
                    data.getInt(DBTables.ITEM_CAT_NAME),
                    data.getInt(DBTables.ITEM_PRICE)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void deleteItem(int id) {
        String query  = "DELETE FROM " + DBTables.TABLE_ITEM + " WHERE " +
                DBTables.ITEM_ID + " = " + id;
        try {
            db.getConnection().createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<DisplayItem> getPrettyItems(){
        ArrayList<DisplayItem> items = new ArrayList<DisplayItem>();
        String query = "SELECT java_items.id, java_category.name AS item_category, " +
                " java_item_name.name as item_name, java_items.price" +
                " from java_items " +
                "JOIN java_category on java_items.cat_name = java_category.id " +
                "JOIN java_item_name on java_items.name = java_item_name.id " +
                "ORDER BY java_items.id ASC";
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                items.add(new DisplayItem(data.getInt("id"),
                        data.getString("item_name"),
                        data.getString("item_category"),
                        data.getString("price")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return items;

    }

    public int getItemCount(int coin) {
        int count = -1;
        try {
            PreparedStatement getCount = db.getConnection()
                    .prepareStatement("SELECT * FROM " + DBTables.TABLE_ITEM + " WHERE "
                                    + DBTables.ITEM_NAME + " = '" + coin + "'", ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
            ResultSet data = getCount.executeQuery();
            data.last();
            count = data.getRow();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
