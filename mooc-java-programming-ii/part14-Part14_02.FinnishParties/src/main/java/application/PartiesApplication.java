package application;

import java.util.Scanner;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class PartiesApplication extends Application {

    @Override
    public void start(Stage window) {
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);
        
        xAxis.setLabel("Year");
        yAxis.setLabel("Support");
        
        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("Relative support of the parties");
        
        Map<String, Map<Integer, Double>> data = readFile("partiesdata.tsv");                
        
        data.keySet().stream().forEach(party -> {
            XYChart.Series partyData = new XYChart.Series();
            partyData.setName(party);
            
            data.get(party).entrySet().stream().forEach(pair -> {
                partyData.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });
            
            chart.getData().add(partyData);
        });
        
        Scene view = new Scene(chart);
        
        window.setScene(view);
        window.show();
    }
    
    public static Map<String, Map<Integer, Double>> readFile(String file) {
        Map<String, Map<Integer, Double>> values = new HashMap<>();
        List<Integer> years = new ArrayList<>();
        
        try (Scanner reader = new Scanner(Paths.get(file))) {
            String firstRow = reader.nextLine();
            String[] firstRowParts = firstRow.split("\t");
            for (int i = 1; i < firstRowParts.length; i++) {
                years.add(Integer.parseInt(firstRowParts[i]));
            }
            
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                String[] parts = row.split("\t");                
                
                Map<Integer, Double> scores = new HashMap<>();
                
                for (int i = 1; i < parts.length; i++) {
                    if (!parts[i].equals("-")) {
                        scores.put(years.get(i - 1), Double.parseDouble(parts[i]));
                    }
                }
                
                values.put(parts[0], scores);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return values;
    }
    
    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

}
