/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package animacion;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Alan
 */
public class Animacion extends Application {
    
    Fondo fondo;
    Personaje personaje;
    
    double displayWidht;
    double displayHeight;

    public Animacion() {
        displayWidht = 600;
        displayHeight = 490;
    }
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        fondo = new Fondo(displayWidht, displayHeight);
        personaje = new Personaje();
        
        HBox terreno = fondo.getFondoTerreno();
        HBox cielo = fondo.getFondoCielo();
        ImageView person = personaje.getPersonaje();
   
        StackPane stackPane = new StackPane(cielo,terreno, person);
        //stackPane.setStyle("-fx-background-color: #A7735D");
        
        Scene scene = new Scene(stackPane, displayWidht-10, displayHeight-15);
        

        
        primaryStage.setTitle("Animación!");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
