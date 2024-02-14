package com.example.decorator_programmingtechnology.service;

import com.example.decorator_programmingtechnology.models.Decorator;
import com.example.decorator_programmingtechnology.models.IChristmasTree;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class Podarki extends Decorator {
    private final ArrayList<Color> colors = new ArrayList<>() {{
        add(Color.PINK);
        add(Color.YELLOW);
        add(Color.PURPLE);
        add(Color.RED);
        add(Color.DEEPSKYBLUE);
        add(Color.ORANGE);
    }};
    private final Random random = new Random();
    private final ArrayList<Shape> shapes = new ArrayList<>();

    public Podarki(IChristmasTree tree) {
        super(tree);
        for (int i = 0; i < 200; i += 40){
            int size = this.random.nextInt(20,40);
            this.shapes.addAll(createPresent(i,260-size, size));
        }
    }

    @Override
    public void draw(Pane pane){
        super.draw(pane);
        this.drawPresents(pane);
    }

    private Collection<Shape> createPresent(int posX, int posY, int size) {
        var presentBox = new Rectangle(posX, posY, size, size);
        presentBox.setFill(colors.get(random.nextInt(0, colors.size() - 1)));

        var width = (int)(size / 8.0);
        var presentPackage = new Path() {{
            setFill(colors.get(random.nextInt(0, colors.size() - 1)));
            setFillRule(FillRule.EVEN_ODD);
            setStroke(Color.TRANSPARENT);
            getElements().addAll(
                    new MoveTo(posX + (int)(size / 2.0) - width, posY),
                    new LineTo(posX + (int)(size / 2.0) - width, posY + (int)(size / 2.0) - width),
                    new LineTo(posX, posY + (int)(size / 2.0) - width),
                    new LineTo(posX, posY + (int)(size / 2.0) + width),
                    new LineTo(posX + (int)(size / 2.0) - width, posY + (int)(size / 2.0) + width),
                    new LineTo(posX + (int)(size / 2.0) - width, posY + size),
                    new LineTo(posX + (int)(size / 2.0) + width, posY + size),
                    new LineTo(posX + (int)(size / 2.0) + width, posY + (int)(size / 2.0) + width),
                    new LineTo(posX + size, posY + (int)(size / 2.0) + width),
                    new LineTo(posX + size, posY + (int)(size / 2.0) - width),
                    new LineTo(posX + (int)(size / 2.0) + width, posY + (int)(size / 2.0) - width),
                    new LineTo(posX + (int)(size / 2.0) + width, posY),
                    new ClosePath()
            );
        }};
        return Arrays.stream(new Shape[] { presentBox, presentPackage }).toList();
    }

    private void drawPresents(Pane panePresent) {
        for (var item : this.shapes) panePresent.getChildren().addAll(item);
    }
}


