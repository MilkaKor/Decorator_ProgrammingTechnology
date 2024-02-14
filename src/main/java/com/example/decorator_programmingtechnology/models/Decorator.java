package com.example.decorator_programmingtechnology.models;

import javafx.scene.layout.Pane;

public abstract class Decorator implements IChristmasTree {
    private IChristmasTree tree;
    public Decorator(IChristmasTree tree) {
        this.tree = tree;
    }
    public void draw(Pane pane){
        tree.draw(pane);
    }
}

