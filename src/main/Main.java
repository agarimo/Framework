package main;

import ctrl.Nav;
import ctrl.MainC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.layout.StackPane;
import org.controlsfx.control.HiddenSidesPane;

/**
 * Main application class.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Vista Viewer");
        stage.setScene(createScene(getPanel(stage)));

        stage.show();
    }

    /**
     * Loads the main fxml layout.
     * Sets up the vista switching VistaNavigator.
     * Loads the first vista into the fxml layout.
     *
     * @return the loaded pane.
     * @throws IOException if the pane could not be loaded.
     */
    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(getClass().getResourceAsStream(Nav.MAIN));

        MainC mainController = loader.getController();

        Nav.setMainController(mainController);
        Nav.loadVista(Nav.WIN);

        return mainPane;
    }
    
    private Pane loadPane(String pane) throws IOException{
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(getClass().getResourceAsStream(pane));

        return mainPane;
    }

    /**
     * Creates the main application scene.
     *
     * @param mainPane the main application layout.
     *
     * @return the created scene.
     */
    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(mainPane);
        scene.getStylesheets().setAll(getClass().getResource("/css/vista.css").toExternalForm());

        return scene;
    }
    
    public StackPane getPanel(Stage stage) throws IOException {
        StackPane stackPane = new StackPane();
//        stackPane.setStyle("-fx-padding: 30");
 
        HiddenSidesPane pane = new HiddenSidesPane();
 
//        Label content = new Label("Content Node");
//        content.setStyle("-fx-background-color: white; -fx-border-color: black;");
//        content.setAlignment(Pos.CENTER);
//        content.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Pane content = loadMainPane();
//        content.setAlignment(Pos.CENTER);
//        content.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//        
 
        pane.setContent(content);
 
//        SideNode top = new SideNode("Top", Side.TOP, pane);
//        top.setStyle("-fx-background-color: rgba(0,255,0,.25);");
//        pane.setTop(top);
// 
//        SideNode right = new SideNode("Right", Side.RIGHT, pane);
//        right.setStyle("-fx-background-color: rgba(0,0, 255,.25);");
//        pane.setRight(right);
// 
//        SideNode bottom = new SideNode("Bottom", Side.BOTTOM, pane);
//        bottom.setStyle("-fx-background-color: rgba(255,255,0,.25);");
//        pane.setBottom(bottom);
 
//        SideNode left = new SideNode("Left", Side.LEFT, pane);
//        left.setStyle("-fx-background-color: rgba(255,0,0,.75);");
        Pane left = loadPane("/view/Config.fxml");
        
        pane.setLeft(left);
 
        stackPane.getChildren().add(pane);
 
        return stackPane;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
