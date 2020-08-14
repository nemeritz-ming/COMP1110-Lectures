package comp1110.lectures.X01;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JFXSquare extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Square");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);

        Rectangle r = new Rectangle(100, 100, 100, 100);
        r.setFill(Color.RED);

        root.getChildren().add(r);
        stage.show();
    }
}
