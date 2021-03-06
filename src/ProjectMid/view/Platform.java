package ProjectMid.view;

import ProjectMid.controller.AllCustomHandler;
import ProjectMid.model.Character;
import ProjectMid.model.Keys;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.ArrayList;


public class Platform extends Pane {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 400;
    public final static int GROUND = 300;
    private Image platformImg;
    private ArrayList<Character> characterList;
    private Keys keys;
    private static TopPane topPane;
    private ArrayList<Score> scoreList;
    protected AllCustomHandler background;

    public Platform() {
        characterList = new ArrayList<>();
        scoreList = new ArrayList();
        keys = new Keys();
        topPane = new TopPane();
        background = new AllCustomHandler();
        System.out.println(background.getBackground());
        platformImg = new Image(getClass().getResourceAsStream(background.getBackground()));
        ImageView backgroundImg = new ImageView(platformImg);
        backgroundImg.setFitHeight(HEIGHT);
        backgroundImg.setFitWidth(WIDTH);
        characterList.add(new Character(30, 30,0,0, KeyCode.A,KeyCode.D,KeyCode.W, "/ProjectMid/assets/MarioSheet.png", 16, 32, 'A'));
        characterList.add(new Character(Platform.WIDTH, 30,0,0, KeyCode.A,KeyCode.D,KeyCode.W, "/ProjectMid/assets/wood.png", 64, 64, 'B'));
        getChildren().addAll(backgroundImg, topPane);
        scoreList.add(new Score(30,GROUND + 30));

        getChildren().addAll(characterList);
        getChildren().addAll(scoreList);
    }
    public ArrayList<Character> getCharacterList() {
        return characterList;
    }

    public Keys getKeys() { return keys; }
    public ArrayList<Score> getScoreList() {
        return scoreList;
    }
}