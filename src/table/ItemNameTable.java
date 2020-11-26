package table;

import daos.ItemNameDAO;
import database.DBTables;
import database.DatabaseConnection;
import pojo.ItemName;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemNameTable implements ItemNameDAO {

    DatabaseConnection db = DatabaseConnection.getInstance();
    ArrayList<ItemName> itemName;

    @Override
    public ArrayList<ItemName> getAllItemName() {
        String query = "SELECT * FROM " + DBTables.TABLE_ITEM_NAME;
        itemName = new ArrayList<>();
        try {
            Statement getItemName =
                    db.getConnection().createStatement();
            ResultSet data = getItemName.executeQuery(query);

            while (data.next()){
                itemName.add(
                        new ItemName(data.getInt(DBTables.ITEM_NAME_ID),
                                data.getString(DBTables.ITEM_NAME_NAME)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return itemName;
    }

    @Override
    public ItemName getItemName(int id) {
        String query = "SELECT * FROM " + DBTables.TABLE_ITEM_NAME+
                " WHERE " + DBTables.ITEM_NAME_ID + " = " + id;
        try{
            Statement getItemName =
                    db.getConnection().createStatement();
            ResultSet data = getItemName.executeQuery(query);
            if(data.next()){
                ItemName itemName1 =
                        new ItemName(data.getInt(DBTables.ITEM_NAME_ID),
                                data.getString(DBTables.ITEM_NAME_NAME));
                return itemName1;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
