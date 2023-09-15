/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animacion;

import java.io.FileInputStream;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Personaje {

    ImageView imageView = new ImageView();
    int frame = 1;

    public ImageView getPersonaje() {
        Duration duration = Duration.millis(100); // Intervalo de 111 milisegundos

        KeyFrame keyFrame = new KeyFrame(duration, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // Cargamos una nueva imagen para el personaje
                if (frame < 10) {
                    try {
                        // Cambia la ruta de la imagen según tu estructura de archivos
                        //String imagePath = "src/personaje/niño" + frame + ".png";
                        FileInputStream path = new FileInputStream("src/personaje/niño" + frame + ".png");
                        Image image = new Image(path, 250, 250, true, false);
                        imageView.setImage(image);
                        
                         imageView.setTranslateY(80);
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                    frame++;
                } else {
                    frame = 1;
                }
            }
        });

        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE); // Se ejecuta indefinidamente

        // Iniciar la línea de tiempo
        timeline.play();

        return imageView;
    }
}