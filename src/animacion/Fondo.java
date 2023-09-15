/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animacion;

import java.io.FileInputStream;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Fondo implements Runnable{

    double displayWidht;
    double displayHeight;

    public Fondo(double displayWidht, double displayHeight) {
        this.displayWidht = displayWidht;
        this.displayHeight = displayHeight;
    }
    
    int repeat = 4;

    public Fondo() {

    }

    public HBox getFondoTerreno() {

        ImageView imageView = null;

        try {
            FileInputStream inputStream = new FileInputStream("src/img/fondo-suelo2.png");
            Image image = new Image(inputStream, displayWidht * 4, displayHeight, false, true);

            imageView = new ImageView(image);

        } catch (Exception e) {

            System.out.println(e.toString());

        }

        imageView.setTranslateX(900);

        HBox hBox = new HBox(imageView);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(20), hBox);
        translateTransition.setByX(-(displayWidht * 3));
        translateTransition.setCycleCount(repeat);

        translateTransition.play();

        return hBox;
    }

    public HBox getFondoCielo() {

        ImageView imageView = null;

        try {
            FileInputStream inputStream = new FileInputStream("src/img/fondo-nubes.png");
            Image image = new Image(inputStream, displayWidht * 4, displayHeight, false, true);

            imageView = new ImageView(image);

        } catch (Exception e) {

            System.out.println(e.toString());

        }

        imageView.setTranslateX(200);

        HBox hBox = new HBox(imageView);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(20), hBox);
        translateTransition.setByX((displayWidht * 0.8));
        translateTransition.setCycleCount(repeat);

        translateTransition.play();

        return hBox;
    }

    @Override
    public void run() {
       getFondoCielo();
    }

}
