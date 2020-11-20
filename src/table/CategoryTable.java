package table;

import daos.CategoryDAO;
import database.DBTables;
import database.DatabaseConnection;
import pojo.Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryTable implements CategoryDAO {

    DatabaseConnection db = DatabaseConnection.getInstance();
    ArrayList<Category> categories;

    @Override
    public ArrayList<Category> getAllCategories() {
        String query = "SELECT * FROM " + DBTables.TABLE_CATEGORY;
        categories = new ArrayList<>();
        try {
            Statement getCategories =
                    db.getConnection().createStatement();
            ResultSet data = getCategories.executeQuery(query);

            while (data.next()){
                categories.add(
                        new Category(data.getInt(DBTables.CATEGORY_ID),
                                data.getString(DBTables.CATEGORY_NAME)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return categories;
    }


    @Override
    public Category getCategory(int id) {
        String query = "SELECT * FROM " + DBTables.TABLE_CATEGORY+
                " WHERE " + DBTables.CATEGORY_ID + " = " + id;
        try{
            Statement getCategories =
                    db.getConnection().createStatement();
            ResultSet data = getCategories.executeQuery(query);
            if(data.next()){
                Category category =
                        new Category(data.getInt(DBTables.CATEGORY_ID),
                                data.getString(DBTables.CATEGORY_NAME));
                return category;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
