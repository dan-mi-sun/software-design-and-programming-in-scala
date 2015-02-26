import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {
    @Override
    public void start(Stage primaryStage) {
        final Button btn = new Button();
        btn.setText("Hello");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//                            @Override
//                            public void handle(ActionEvent evt) {
//                                btn.setText("Goodbye");
//                            }
//                        }
//        );

        btn.setOnAction(evt -> btn.setText("Goodbye"));

        StackPane sp = new StackPane();
        sp.getChildren().add(btn);

        Scene scene = new Scene(sp, 500, 500);

        primaryStage.setTitle("Hello my app!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
