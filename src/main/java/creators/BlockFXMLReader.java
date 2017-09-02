package creators;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

/**
 * Created by Никита on 16.08.2017.
 */
public class BlockFXMLReader {
    public static void main(String[] args) throws IOException {
        BlockFXMLReader reader = new BlockFXMLReader();
        reader.init();
    }

    public void init() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/shema6.fxml"));
        Pane group = (Pane) fxmlLoader.load();

        String nodeToString = "new String[]{\"";
        for (Node node : group.getChildren()) {
            Rectangle rectangle = (Rectangle) node;
            String color = "";

            if (rectangle.getFill() == Color.BLACK) {
                color = "s";
            } else if (rectangle.getFill() == Color.WHITE) {
                color = "b";
            } else if (rectangle.getFill() == Color.RED) {
                color = "d";
            }

            nodeToString += rectangle.getLayoutX() + "_" + rectangle.getLayoutY() + "_" + rectangle.getWidth() + "_" + rectangle.getHeight() + "_" + color + "\",\"";
        }
        nodeToString = nodeToString.substring(0, nodeToString.length() - 2) + "};";

        System.out.println(nodeToString);
    }
}
