//Page 391 in the JavaFX Textbook
package spherejavafx;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Random;


public class SphereJavaFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Random random = new Random();
        int AxisChooser = random.nextInt((3-1)+1)+1;
       
        StackPane root = new StackPane();
        
        //root.getChildren().add(btn);
        Scene scene = new Scene(root, 600, 600);
        PerspectiveCamera camera = new PerspectiveCamera(false);
        
        //Backs the camera away from the scene by 1000 units
        camera.setTranslateZ(-1000);
        
        //This is the range of which the camera will render objects
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);
        
        //The default field of view for the scene is 30 but change to suit
        camera.setFieldOfView(27);
        scene.setCamera(camera);
        
        //This sets up my sphere
        Sphere mysphere = new Sphere(350);
        mysphere.setTranslateX(-180);
        mysphere.setTranslateY(-100);
        mysphere.setTranslateZ(100);
        root.getChildren().add(mysphere);
        
        //This sets up the image of the earth to wrap around my sphere
        Image earthImage = new Image("file:earth.jpg");
        PhongMaterial earthPhong = new PhongMaterial();
        earthPhong.setDiffuseMap(earthImage);
        mysphere.setMaterial(earthPhong);
        
        //This rotates my sphere
        RotateTransition rotate = new RotateTransition();
        if (AxisChooser == 1) {
            rotate.setAxis(Rotate.X_AXIS);       
        }
        if (AxisChooser == 2) {
            rotate.setAxis(Rotate.Y_AXIS);       
        }
        if (AxisChooser == 3) {
            rotate.setAxis(Rotate.Z_AXIS);       
        }
        rotate.setNode(mysphere);
        rotate.setDuration(Duration.millis((random.nextInt(7000-3000)+1)+3000));
        rotate.setByAngle(720);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.EASE_BOTH);
        rotate.play();
        
        Sphere mysphere2 = new Sphere(random.nextInt((350-150)+1)+150);
        mysphere2.setTranslateX(random.nextInt((180-0)+1)+0);
        mysphere2.setTranslateY(-1*(random.nextInt((180-0)+1)+0));
        mysphere2.setTranslateZ(random.nextInt((90-0)+1)+0);
        root.getChildren().add(mysphere2);
        
        Image earthImage2 = new Image("file:earth.jpg");
        PhongMaterial earthPhong2 = new PhongMaterial();
        earthPhong2.setDiffuseMap(earthImage2);
        mysphere2.setMaterial(earthPhong2);
        
        RotateTransition rotate2 = new RotateTransition();
        if (AxisChooser == 1) {
            rotate2.setAxis(Rotate.Z_AXIS);       
        }
        if (AxisChooser == 2) {
            rotate2.setAxis(Rotate.X_AXIS);       
        }
        if (AxisChooser == 3) {
            rotate2.setAxis(Rotate.Y_AXIS);       
        }
        
        rotate2.setNode(mysphere2);
        rotate2.setDuration(Duration.millis((random.nextInt(10000-5000)+1)+5000));
        rotate2.setByAngle(1440);
        rotate2.setCycleCount(Animation.INDEFINITE);
        rotate2.setInterpolator(Interpolator.LINEAR);
        rotate2.play();
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
