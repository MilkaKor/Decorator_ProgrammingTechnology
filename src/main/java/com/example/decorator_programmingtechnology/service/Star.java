package com.example.decorator_programmingtechnology.service;

import com.example.decorator_programmingtechnology.models.Decorator;
import com.example.decorator_programmingtechnology.models.IChristmasTree;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Star extends Decorator {
    public Star(IChristmasTree tree) {
        super(tree);
    }

    @Override
    public void draw(Pane paneStar) {
        super.draw(paneStar);
        this.drawStar(paneStar);
    }

    private void drawStar(Pane paneStar) {
        var path = new Path() {{
            setFill(Color.GOLD);
            setFillRule(FillRule.EVEN_ODD);
            setStroke(Color.YELLOW);
        }};
        path.getElements().addAll(
                new MoveTo(100, 0),
                new LineTo(108, 20),
                new LineTo(125, 20),
                new LineTo(114, 34),
                new LineTo(118, 50),
                new LineTo(100, 40),
                new LineTo(82, 50),
                new LineTo(86, 34),
                new LineTo(75, 20),
                new LineTo(92, 20),
                new ClosePath()
        );
        paneStar.getChildren().addAll(path);
    }
}

