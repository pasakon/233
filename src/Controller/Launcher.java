package Controller;

import Item.BasedCharacter;
import Item.listCharacter;
import View.EquipPane;
import View.InventoryPane;
import View.Toppane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.ArrayList;
public class Launcher extends Application {

    private static Scene mainScene;
    private static ArrayList<BasedCharacter> allEquipments = null;
    private static listCharacter equipmentArmor = null;
    private static EquipPane equipPane = null;
    private static InventoryPane inventoryPane = null;
    private static Toppane topPane = null;
    private  static  Pane mainPane;
    private  static Popup popup;

    //private static Stage primaryStage;

    public static void setEquippedArmor(listCharacter retrievedEquipment) {
        equipmentArmor = retrievedEquipment;
    }

    public static void setAllEquipments(ArrayList<BasedCharacter> allEquipments) {
        Launcher.allEquipments = allEquipments;
    }

    public static ArrayList<BasedCharacter> getBasedCharacter() {
        return allEquipments;
    }

    public static BasedCharacter getEquippedArmor() {
        return equipmentArmor;
    }

    public static Popup getpopup() {
        Label label = new Label("This is a Popup");
        popup = new Popup();
        label.setStyle(" -fx-background-color: green;");
        label.setMinWidth(80);
        label.setMinHeight(50);
        popup.getContent().add(label);

        System.out.println("lol");
        return popup;

    }



    @Override
    public void start(Stage primaryStage) throws Exception {
       primaryStage.setTitle("Intro to RPG");
        primaryStage.setResizable(false);
        allEquipments = GenItemList.setUpIList();
        mainPane = getMainPane();
        getpopup().show(primaryStage);
        mainScene = new Scene(mainPane);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public Pane getMainPane() {
        BorderPane mainPane = new BorderPane();
        equipPane = new EquipPane();
        inventoryPane = new InventoryPane();
        topPane = new Toppane();

        mainPane.setLeft(equipPane);
        mainPane.setCenter(inventoryPane);
        mainPane.setBottom(topPane);
        refreshPane();
        return mainPane;
    }

    public static void refreshPane() {
        equipPane.drawPane(equipmentArmor);
        inventoryPane.drawPane(allEquipments);
        topPane.drawPane();


    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
