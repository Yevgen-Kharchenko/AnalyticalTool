package com.analyticTool;

import com.analyticTool.controller.MainController;

public class App {

    private final MainController mainController;


    public App() {
        mainController = new MainController();
    }

    private void run() {
        mainController.doAnalytics();
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

}
