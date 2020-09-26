package com.analyticTool;

import com.analyticTool.service.MainService;

public class App {

    private  final MainService mainService;


    public App() {
        mainService = new MainService();
    }

    private void run() {
        mainService.doAnalytics();
    }

    public static void main(String[] args) {
        App app =new App();
        app.run();
    }

}
