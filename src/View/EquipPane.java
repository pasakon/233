package View;


import Controller.AllCustomHandler;
import Item.listCharacter;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
//import model.Item.Weapon;

import static Controller.AllCustomHandler.onDragDropped;
import static Controller.AllCustomHandler.onDragOver;

public class EquipPane extends ScrollPane {
    private listCharacter equippedlistCharacter;

    public EquipPane() { }

    public void drawPane( listCharacter equippedlistCharacter) {
        this.equippedlistCharacter = equippedlistCharacter;
        Pane equipmentInfo = getDetailsPane();
        this.setContent(equipmentInfo);
    }

    private Pane getDetailsPane() {
        Pane equipmentInfoPane = new VBox(10);
        equipmentInfoPane.setBorder(null);
        ((VBox) equipmentInfoPane).setAlignment(Pos.CENTER);
        equipmentInfoPane.setPadding(new Insets(50, 50, 50, 50));
        Label  armorLbl;

        StackPane armorImgGroup = new StackPane();

        ImageView bg2 = new ImageView();

        ImageView armorImg = new ImageView();

        bg2.setImage(new Image(getClass().getClassLoader().getResource("assets/blank.png").toString()));

        armorImgGroup.getChildren().add(bg2);


        if (equippedlistCharacter != null) {
            armorLbl = new Label("listCharacter: \n" + equippedlistCharacter.getName());
            armorImg.setImage(new Image(getClass().getClassLoader().getResource(equippedlistCharacter.getImagepath()).toString()));
            armorImgGroup.getChildren().add(armorImg);
        } else {
            armorLbl = new Label("listCharacter:");
            armorImg.setImage(new Image(getClass().getClassLoader().getResource("assets/blank.png").toString()));
        }



        armorImgGroup.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent e) {
                onDragOver(e, "listCharacter");
            }
        });



        armorImgGroup.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent e) {
                onDragDropped(e, armorLbl, armorImgGroup);
            }
        });

        Button unequip = new Button();
        unequip.setText("unequip");
        unequip.setOnAction(new AllCustomHandler.Unequip());
        equipmentInfoPane.getChildren().addAll(  armorLbl, armorImgGroup,unequip );
        return equipmentInfoPane;
    }


}
