package main;

import javafx.application.Application;
import javafx.stage.Stage;
import pojo.Category;
import scene.SceneCRUD;
import scene.WelcomeScene;
import table.CategoryTable;

import java.io.*;
import java.util.ArrayList;


public class StartMain extends Application {

    public static Stage mainStage;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;

        String fileName = "login.txt";
        String filePath = "src/fileIO/" + fileName;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String fileRead = reader.readLine();
            if (fileRead != null) {
                mainStage.setScene(new SceneCRUD());
            }else {
                mainStage.setScene(new WelcomeScene());
            }
        }catch (IOException ioException) {
            ioException.printStackTrace();
        }
        mainStage.setTitle(ScreenSize.title);
        mainStage.setResizable(false);
        mainStage.show();
        CategoryTable table = new CategoryTable();
        ArrayList<Category> coinsArrayList = table.getAllCategories();
        //db.addRecord();
    }
}