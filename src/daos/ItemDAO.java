package daos;

import pojo.Item;

import java.util.ArrayList;

public interface ItemDAO {
    public ArrayList<Item> getAllItems();
    public Item getItem(int itemID);
    public void deleteItem(int id);
    public void createItem(Item item);
}
