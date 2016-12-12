import exception.FormatException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class CalculatorView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Please change the title into "Lucky Number Calculator"
        primaryStage.setTitle("Lucky Number Calculator");

        // Label Setting
        Label labelFirstName = new Label("First Name");
        Label labelLastName = new Label("Last Name");
        Label labelYear = new Label("Year");
        Label labelMonth = new Label("Month");
        Label labelDay = new Label("Day");
        Label labelResult = new Label("");

        // Input Setting
        TextField textFirstName = new TextField();
        textFirstName.setPromptText("Enter your first name");
        TextField textLastName = new TextField();
        textLastName.setPromptText("Enter your last name");

        TextField textYear = new TextField();
        textYear.setPromptText("Enter your birth year");
        TextField textMonth = new TextField();
        textMonth.setPromptText("Enter your birth month");
        TextField textDay = new TextField();
        textDay.setPromptText("Enter your birth day");

        // Button Setting
        Button btnCalculate = new Button();
        btnCalculate.setText("Show My Lucky Number!");


        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(5);
        pane.setVgap(5);

        pane.setConstraints(labelFirstName, 0, 0);
        pane.getChildren().add(labelFirstName);
        pane.setConstraints(labelLastName, 0, 1);
        pane.getChildren().add(labelLastName);

        pane.setConstraints(textFirstName, 1, 0);
        pane.getChildren().add(textFirstName);
        pane.setConstraints(textLastName, 1, 1);
        pane.getChildren().add(textLastName);

        pane.setConstraints(labelYear, 0, 2);
        pane.getChildren().add(labelYear);
        pane.setConstraints(textYear, 1, 2);
        pane.getChildren().add(textYear);

        pane.setConstraints(labelMonth, 0, 3);
        pane.getChildren().add(labelMonth);
        pane.setConstraints(textMonth, 1, 3);
        pane.getChildren().add(textMonth);

        pane.setConstraints(labelDay, 0, 4);
        pane.getChildren().add(labelDay);
        pane.setConstraints(textDay, 1, 4);
        pane.getChildren().add(textDay);

        pane.setConstraints(btnCalculate, 0, 6);
        pane.getChildren().add(btnCalculate);

        pane.setConstraints(labelResult, 0, 7);
        pane.getChildren().add(labelResult);

        btnCalculate.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String firstName = textFirstName.getText();
                String lastName = textLastName.getText();
                String year = textYear.getText();
                String month = textMonth.getText();
                String day = textDay.getText();
                String result;

                Controller controller = new Controller(firstName, lastName, year, month, day);

                try {
                    controller.validate();
                    controller.initialize();
                    result = controller.calculate();
                } catch (FormatException e) {
                    e.printStackTrace();
                    result = e.getMessage();
                }

                System.out.println(result);
                labelResult.setText(result);
            }
        });
        primaryStage.setScene(new Scene(pane, 420, 280));
        primaryStage.show();
    }
}