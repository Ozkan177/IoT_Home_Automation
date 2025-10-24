package main.frontend;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import main.backend.devices.*;
import main.backend.commands.*;
import main.backend.mediator.SmartHomeHub;

public class MainUI extends Application {

    @Override
    public void start(Stage stage) {
        SmartHomeHub hub = SmartHomeHub.getInstance();

        Light light = new Light("Living Room");
        Thermostat thermostat = new Thermostat("Bedroom");
        Camera camera = new Camera("Garden");

        hub.registerDevice(light);
        hub.registerDevice(thermostat);
        hub.registerDevice(camera);

        // === UI ===
        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #dbe6f6, #c5796d);");

        // Light button
        Button lightBtn = new Button("💡 Light");
        lightBtn.setLayoutX(60);
        lightBtn.setLayoutY(100);
        lightBtn.setOnAction(e -> hub.executeCommand(new TurnOnCommand(light)));

        // Camera button
        Button camBtn = new Button("📷 Camera");
        camBtn.setLayoutX(200);
        camBtn.setLayoutY(100);
        camBtn.setOnAction(e -> hub.executeCommand(new TurnOnCommand(camera)));

        // Thermostat button
        Button tempBtn = new Button("🌡️ Thermostat");
        tempBtn.setLayoutX(340);
        tempBtn.setLayoutY(100);
        tempBtn.setOnAction(e -> hub.executeCommand(new SetTemperatureCommand(thermostat, 24)));

        root.getChildren().addAll(lightBtn, camBtn, tempBtn);

        Scene scene = new Scene(root, 500, 300);
        stage.setScene(scene);
        stage.setTitle("Smart Home Control Panel 🏠");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
