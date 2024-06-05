package com.example.merobank;

public class Model {
    private static Model instance;

    private final ViewFactory viewFactory;

    private Model(){
        this.viewFactory = new ViewFactory();
    };

    public static Model getInstance(){
        if(instance == null) {
            instance = new Model();
        }
        return instance;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }
}