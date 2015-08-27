/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khserver.fxcli;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Vladimir
 */
public class FXCli extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/FXMLDocument.fxml"));
        
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Scene scene = new Scene(root);
        SplitPane mainSplitPane = (SplitPane) scene.lookup("#MainSplitPane");
        mainSplitPane.setPrefSize(bounds.getWidth() * 0.8, bounds.getHeight() * 0.8);
        AnchorPane mainAreaNode = (AnchorPane) scene.lookup("#MainSplitLeftAnchorPane");
        setMainBorderPaneCenterDefault(mainAreaNode);
        
        stage.setScene(scene);
        stage.setTitle("FXCli");
        stage.show();
    }

    public void setMainBorderPaneCenterDefault(AnchorPane node) throws IOException {
        setMainBorderPaneCenterBrowser(node);
    }

    public void setMainBorderPaneCenterBrowser(AnchorPane node) throws IOException {
        setMainBorderPaneCenter(node, "Browser");
    }

    public void setMainBorderPaneCenter(AnchorPane node, String name) throws IOException {
        URL location = getClass().getResource("view/FXML" + name + ".fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Node fxmlNode;
        fxmlNode = (Node) fxmlLoader.load();
        return;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
