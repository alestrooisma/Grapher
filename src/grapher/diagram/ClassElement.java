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
        
        // Add class name
        Text classNameText = new Text(me.getName());
        classNameText.setStyle("-fx-font-weight: bold"); //TODO obtain font from diagram properties
        StackPane classNameContainer = new StackPane();
        classNameContainer.setPadding(new Insets(5)); //TODO obtain from diagram properties
        classNameContainer.getChildren().add(classNameText);
        
        root.getChildren().add(classNameContainer);
        
        return root;
    }
}
