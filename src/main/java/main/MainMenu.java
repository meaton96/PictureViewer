package main;


import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu {

    private final Stage primaryStage;
    private final Scene mainMenuScene;

    public MainMenu(Stage primaryStage) {
        this.primaryStage = primaryStage;

        VBox menuBox = new VBox(20);
        mainMenuScene = new Scene(menuBox);
        primaryStage.setScene(mainMenuScene);
        primaryStage.show();
    }




}
