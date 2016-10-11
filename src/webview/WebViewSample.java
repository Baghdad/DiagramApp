package webview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Author: Kirill Bogdanov
 * Created on 10.10.2016.
 */
public class WebViewSample extends Application {
    private Scene scene;

    @Override
    public void start(Stage stage) {
        // create the scene
        stage.setTitle("Web View");
        Browser browser = new Browser();
        scene = new Scene(browser, 750, 500, Color.web("#666970"));
        stage.setScene(scene);
        //scene.getStylesheets().add("webviewsample/BrowserToolbar.css");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
