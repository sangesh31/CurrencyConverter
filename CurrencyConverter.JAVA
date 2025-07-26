
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CurrencyConverter extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Currency Converter");

        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

       
        Label amountLabel = new Label("Amount (INR):");
        TextField amountField = new TextField();
        grid.add(amountLabel, 0, 0);
        grid.add(amountField, 1, 0);

        
        Label currencyLabel = new Label("Convert to:");
        ComboBox<String> currencyBox = new ComboBox<>();
        currencyBox.getItems().addAll("USD", "EUR", "GBP");
        currencyBox.setValue("USD");
        grid.add(currencyLabel, 0, 1);
        grid.add(currencyBox, 1, 1);

        
        Button convertButton = new Button("Convert");
        grid.add(convertButton, 1, 2);

        
        Label resultLabel = new Label("Converted Amount: ");
        grid.add(resultLabel, 1, 3);

       
        convertButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String currency = currencyBox.getValue();
                double rate = 0;

                switch (currency) {
                    case "USD": rate = 0.012; break; // Example: 1 INR = 0.012 USD
                    case "EUR": rate = 0.011; break;
                    case "GBP": rate = 0.0095; break;
                }

                double converted = amount * rate;
                resultLabel.setText("Converted Amount: " + String.format("%.2f", converted) + " " + currency);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number.");
            }
        });

        Scene scene = new Scene(grid, 350, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
