package Controller;

import Item.BasedCharacter;
import Item.listCharacter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;

import java.util.ArrayList;


public class AllCustomHandler {


    public static class GenHeroHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

            Launcher.refreshPane();
        }
    }

    public static class Unequip implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {


            if (Launcher.getEquippedArmor() != null) {
                Launcher.setEquippedArmor(null);
                Launcher.setAllEquipments(GenItemList.setUpIList());
            }

            Launcher.refreshPane();
        }
    }
    public static void onDragDetected(MouseEvent event, BasedCharacter equipment, ImageView imgView) {
        Dragboard db = imgView.startDragAndDrop(TransferMode.ANY);
        db.setDragView(imgView.getImage());
        ClipboardContent content = new ClipboardContent();
        content.put(equipment.DATA_FORMAT, equipment);
        db.setContent(content);
        event.consume();
    }

    public static void onDragOver(DragEvent event, String type) {
        Dragboard dragboard = event.getDragboard();
        BasedCharacter retrievedEquipment = (BasedCharacter) dragboard.getContent(BasedCharacter.DATA_FORMAT);
        if (dragboard.hasContent(BasedCharacter.DATA_FORMAT) && retrievedEquipment.getClass().getSimpleName().equals(type))
            event.acceptTransferModes(TransferMode.MOVE);
    }

    public static void onDragDropped(DragEvent event, Label lbl, StackPane imgGroup) {
        boolean dragCompleted = false;
        Dragboard dragboard = event.getDragboard();
        ArrayList<BasedCharacter> allEquipments = Launcher.getBasedCharacter();
        if (dragboard.hasContent(BasedCharacter.DATA_FORMAT)) {
            BasedCharacter retrievedEquipment = (BasedCharacter) dragboard.getContent(BasedCharacter.DATA_FORMAT);
            //ArrayList<BasedCharacter> character = Launcher.getMainCharacter();

            if (retrievedEquipment.getClass().getSimpleName().equals("listCharacter")) {
                if (Launcher.getEquippedArmor() != null) {
                    allEquipments.add(Launcher.getEquippedArmor());
                }
                Launcher.setEquippedArmor((listCharacter) retrievedEquipment);

            }

            Launcher.setAllEquipments(allEquipments);
            Launcher.refreshPane();
            ImageView imgView = new ImageView();
            if (imgGroup.getChildren().size() != 1) {
                imgGroup.getChildren().remove(1);
                Launcher.refreshPane();
            }
            lbl.setText(retrievedEquipment.getClass().getSimpleName() + ":\n" + retrievedEquipment.getName());
            imgView.setImage(new Image(AllCustomHandler.class.getClassLoader().getResource(retrievedEquipment.getImagepath()).toString()));
            imgGroup.getChildren().add(imgView);
            dragCompleted = true;
        }
        event.setDropCompleted(dragCompleted);
    }

    public static void onEquipDone(DragEvent event) {
        Dragboard dragboard = event.getDragboard();
        ArrayList<BasedCharacter> allEquipments = Launcher.getBasedCharacter();
        BasedCharacter retrievedEquipment = (BasedCharacter) dragboard.getContent(
                BasedCharacter.DATA_FORMAT);
        int pos = -1;
        for (int i = 0; i < allEquipments.size(); i++) {
            if (allEquipments.get(i).getName().equals(retrievedEquipment.getName())) {
                pos = i;
            }
        }
        if (pos != -1) {
            allEquipments.remove(pos);
        }
        Launcher.setAllEquipments(allEquipments);
        Launcher.refreshPane();
    }


}
