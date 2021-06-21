package application;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class SavingsCalculatorApplication extends Application {
    
    @Override
    public void start(Stage window) {
        // main layout
        BorderPane layout = new BorderPane(); 
        layout.setPadding(new Insets(20, 20, 20, 20));
        
        // top box containing the two sliders
        VBox slidersLayout = new VBox(); 
        slidersLayout.setSpacing(10);
        layout.setTop(slidersLayout);
        
        // layout for the savings slider
        BorderPane savingsPane = new BorderPane();
        slidersLayout.getChildren().add(savingsPane);
        
        Label monthlySavings = new Label("Monthly savings");
        savingsPane.setLeft(monthlySavings);
        
        Slider savingsSlider = new Slider(25, 250, 50);
        savingsSlider.setShowTickLabels(true);
        savingsSlider.setShowTickMarks(true);
        savingsSlider.setMajorTickUnit(25);
        savingsSlider.setMinorTickCount(3);
        savingsSlider.setBlockIncrement(1);
        savingsPane.setCenter(savingsSlider);
        
        Label savingsLabel = new Label("" + savingsSlider.getValue());
        savingsPane.setRight(savingsLabel);                              
        
        // layout for the interest rate slider        
        BorderPane interestPane = new BorderPane();
        slidersLayout.getChildren().add(interestPane);
        
        Label interestLabel = new Label("Yearly interest rate");
        interestPane.setLeft(interestLabel);
        
        Slider interestRateSlider = new Slider(0, 10, 0);       
        interestRateSlider.setShowTickLabels(true);
        interestRateSlider.setShowTickMarks(true);
        interestRateSlider.setMajorTickUnit(10);
        interestPane.setCenter(interestRateSlider);
        
        Label interestValue = new Label("" + interestRateSlider.getValue());
        interestPane.setRight(interestValue);               
        
        // chart
        
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        yAxis.setTickUnit(4);
        
        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("Savings calculator");
        chart.setAnimated(false);
        layout.setCenter(chart);
        
        // lines
        
        XYChart.Series savingsLine = new XYChart.Series();
        savingsLine.setName("Savings");
        chart.getData().add(savingsLine);
        
        XYChart.Series savingsLineWithInterest = new XYChart.Series();
        savingsLineWithInterest.setName("Savings with interest");
        chart.getData().add(savingsLineWithInterest);
        
        // slider actions
        savingsSlider.valueProperty().addListener((
            ObservableValue<? extends Number> ov,
            Number old_val, Number new_val) -> {
                savingsLabel.setText(String.format("%.2f", new_val));
                
                Double interestRate = interestRateSlider.getValue();
                
                updateSavingsLine(savingsLine, savingsLineWithInterest,
                        new_val.doubleValue(), interestRateSlider.getValue());
        });
        
        interestRateSlider.valueProperty().addListener((
            ObservableValue<? extends Number> ov,
            Number old_val, Number new_val) -> {
                interestValue.setText(String.format("%.2f", new_val));
                
                updateSavingsLine(savingsLine, savingsLineWithInterest,
                        savingsSlider.getValue(), new_val.doubleValue());
        });
        
        // creating scene
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }
    
    public static void updateSavingsLine(XYChart.Series savingsLine,
            XYChart.Series savingsLineWithInterest,
            Double savings, Double interestRate) {
        savingsLine.getData().clear();
        savingsLineWithInterest.getData().clear();
        
        savingsLine.getData().add(new XYChart.Data(0, 0));
        savingsLineWithInterest.getData().add(new XYChart.Data(0, 0));
        
        Double savingsValue = 0.0;
        Double withInterest = 0.0;
        
        for (int i = 1; i <= 30; i++) {
            savingsValue += savings * 12;
            withInterest = (withInterest + savings * 12) * (1 + interestRate / 100);
            
            savingsLine.getData().add(new XYChart.Data(i, savingsValue));
            savingsLineWithInterest.getData().add(new XYChart.Data(i, withInterest));                        
        }
    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

}
