package grapher.diagram;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.Node;
import javafx.scene.layout.Region;

public class Diagram extends Region {
    private final HashMap<Element, Node> elements = new HashMap<>();
    private final int spacing = 20;
    
    public void add(Element e) {
        Node node = e.createNode();
        elements.put(e, node);
        this.getChildren().add(node);
    }

    @Override
    public void layoutChildren() {
        double x = 0;
        for (Map.Entry<Element, Node> pair : elements.entrySet()) {
//            Element e = pair.getKey();
            Node node = pair.getValue();
            
            if (node.isResizable() && node.isManaged()) {
                node.autosize();
            }
            
            node.setLayoutX(x);
            x = node.getBoundsInParent().getMaxX() + spacing;
        }
    }
}
