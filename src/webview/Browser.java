package webview;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * Author: Kirill Bogdanov
 * Created on 10.10.2016.
 */
public class Browser extends Region {
    private HBox toolBar;

    private static String[] imageFiles = new String[]{
            "add-button.png"
    };
    private static String[] captions = new String[]{
            "Add"
    };

    final Hyperlink[] hpls = new Hyperlink[captions.length];
    final Image[] images = new Image[imageFiles.length];
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();

    public Browser() {
        //apply the styles
        //getStyleClass().add("browser");

        final Hyperlink hpl = hpls[0] = new Hyperlink("Add");
        Image image = images[0] = new Image(getClass().getResourceAsStream(imageFiles[0]));
        hpl.setGraphic(new ImageView(image));

        //hpl.setOnAction(e -> webEngine.executeScript("add()"));

        // load the web page
        String url = WebViewSample.class.getResource("/webview/pages/flowchart.html").toExternalForm();
        webEngine.load(url);

        // create the toolbar
        toolBar = new HBox();
        //toolBar.getStyleClass().add("browser-toolbar");
        toolBar.getChildren().addAll(hpls);

        //add the web view to the scene
        getChildren().add(toolBar);
        getChildren().add(browser);
    }

    private Node createSpacer() {
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        return spacer;
    }

    @Override
    protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        double tbHeight = toolBar.prefHeight(w);
        layoutInArea(browser, 0, 0, w, h - tbHeight, 0, HPos.CENTER, VPos.CENTER);
        layoutInArea(toolBar, 0, h - tbHeight, w, tbHeight, 0, HPos.CENTER, VPos.CENTER);
    }

    @Override
    protected double computePrefWidth(double height) {
        return 750;
    }

    @Override
    protected double computePrefHeight(double width) {
        return 500;
    }
}
