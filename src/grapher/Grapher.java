/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grapher;

import grapher.diagram.ClassElement;
import grapher.diagram.Diagram;
import grapher.model.ClassME;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author ale
 */
public class Grapher extends Application {
    private Pane root;
    
    @Override
    public void start(Stage stage) throws Exception {
        // Create model & diagram
        ClassME myClass = new ClassME("MyClass");
        ClassME otherClass = new ClassME("OtherClass");
        Diagram diagram = new Diagram();
        diagram.add(new ClassElement(myClass));
        diagram.add(new ClassElement(otherClass));
        
        // Create UI
        root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        // Render the diagram
        diagram.renderOn(root);
        
        // Final UI setup & reveal
        Scene scene = new Scene(root);
        stage.setTitle("Grapher");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
