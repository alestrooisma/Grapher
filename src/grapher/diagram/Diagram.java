package grapher.diagram;

import java.util.LinkedList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class Diagram {
    private final LinkedList<Element> elements = new LinkedList<>();
    private final int spacing = 0;

    public boolean add(Element e) {
        return elements.add(e);
    }

    public void renderOn(Pane pane) {
        double x = 0;
        for (Element e : elements) {
            Node node = e.render();
            pane.getChildren().add(node);
            node.setLayoutX(x);
            System.out.println(node.getLayoutBounds());
            System.out.println(node.getBoundsInLocal());
            System.out.println(node.getBoundsInParent());
            x = node.getBoundsInParent().getMaxX() + spacing;
        }
    }
}
