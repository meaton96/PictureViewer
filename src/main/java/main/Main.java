package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {

    Connection connect = null;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Picture Viewer");
        MainMenu mainMenu = new MainMenu(primaryStage);

    }

    @Override
    public void init() throws Exception {

        try {
            connect = DriverManager.getConnection("jdbc:derby:ImageDatabase; create=true");
            System.out.println("Connected to database.");
            Statement state = connect.createStatement();
            System.out.println("Statement created.");
            DatabaseMetaData dbm = connect.getMetaData();
            System.out.println("MetaData created.");
            ResultSet result = dbm.getTables(null, null, "IMAGE_INFO", null);
            System.out.println("ResultSet created.");
            if (result.next()) {
                System.out.println("NPC Info exists");
            } else {
                state.execute("create table image_info(name varchar(100), type varchar(100)");
                System.out.println("NPC Info created");
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }



        super.init();
    }
}
