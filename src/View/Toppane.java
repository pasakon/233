package View;
import Controller.AllCustomHandler;
import Controller.Launcher;
import Item.BasedCharacter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;
import Item.BasedCharacter;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Toppane extends ScrollPane {
    //private static Stage primaryStage;

    //private  static  Popup popup;
    //private Button add;

    private Pane getDetailsPane() {
        Pane TopPane = new HBox(10);
        TopPane.setBorder(null);
        TopPane.setPadding(new Insets(50, 50, 50, 50));

        return TopPane;
    }
    public void drawPane() {
        Pane TopPane = getDetailsPane();
        this.setContent(TopPane);
    }



}
