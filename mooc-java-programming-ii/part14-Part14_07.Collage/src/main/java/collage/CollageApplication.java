package collage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage window) {
        Image imageFile = new Image("file:monalisa.png");
        
        PixelReader pixels = imageFile.getPixelReader();
        
        int width = (int) imageFile.getWidth();
        int height = (int) imageFile.getHeight();
        
        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter writer = targetImage.getPixelWriter();
        
        for (int y = 0; y * 2 < height; y++) {
            for (int x = 0; x * 2 < width; x++) {
                
                Color originalPixel = pixels.getColor(x * 2, y * 2);
                
                double red = 1.0 - originalPixel.getRed();
                double green = 1.0 - originalPixel.getGreen();
                double blue = 1.0 - originalPixel.getBlue();
                double opacity = originalPixel.getOpacity();
                
                Color newPixel = new Color(red, green, blue, opacity);
                
                writer.setColor(x, y, newPixel);
                writer.setColor(x + width / 2, y, newPixel);
                writer.setColor(x, y + height / 2, newPixel);
                writer.setColor(x + width / 2, y + height / 2, newPixel);                
            }
        }
        
        ImageView image = new ImageView(targetImage);                
        
        Pane frame = new Pane();
        frame.getChildren().add(image);
        
        Scene scene = new Scene(frame);
        
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(CollageApplication.class);
    }

}
