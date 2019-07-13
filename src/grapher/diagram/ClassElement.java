package grapher.diagram;

import grapher.model.ClassME;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ClassElement implements Element {
    private final ClassME me;

    public ClassElement(ClassME me) {
        this.me = me;
    }

    @Override
    public Node createNode() {
        // VBox as root container
        VBox root = new VBox();
        
        // Draw border of 'class' //TODO obtain from diagram properties
        root.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        
        // Add contents
        root.getChildren().addAll(createClassName(), createAttributes(), createOperations());
        
        return root;
    }

    private Node createClassName() {
        Text classNameText = new Text(me.getName());
        classNameText.setStyle("-fx-font-weight: bold"); //TODO obtain font from diagram properties
        
        StackPane classNameContainer = new StackPane();
        classNameContainer.setPadding(new Insets(5)); //TODO obtain from diagram properties
        
        classNameContainer.getChildren().add(classNameText);
        
        return classNameContainer;
    }
    
    private Node createAttributes() {
        // Dummy attribute
        Text attribute = new Text("- attribute : Type");
        
        VBox attributeBox = new VBox();
        attributeBox.setPadding(new Insets(3));
        attributeBox.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1, 0, 0, 0)))); //TODO obtain from diagram properties
        
        attributeBox.getChildren().add(attribute);
        
        return attributeBox;
    }
    
    private Node createOperations() {
        // Dummy attribute
        Text operation1 = new Text("+ getAttr() : Type");
        Text operation2 = new Text("+ setAttr(attr : Type) : void");
        
        VBox operationBox = new VBox();
        operationBox.setPadding(new Insets(3));
        operationBox.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1, 0, 0, 0)))); //TODO obtain from diagram properties
        
        operationBox.getChildren().addAll(operation1, operation2);
        
        return operationBox;
    }
}
