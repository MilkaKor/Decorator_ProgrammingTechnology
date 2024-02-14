package com.example.decorator_programmingtechnology;

import com.example.decorator_programmingtechnology.models.ChristmasTree;
import com.example.decorator_programmingtechnology.models.IChristmasTree;
import com.example.decorator_programmingtechnology.service.Garland;
import com.example.decorator_programmingtechnology.service.Podarki;
import com.example.decorator_programmingtechnology.service.Star;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Label stateLabel;
    @FXML
    private Pane paneTree;

    private IChristmasTree tree = new ChristmasTree();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.paneTree.toFront();
        this.tree.draw(this.paneTree);
    }

    public void addGarlandButton(ActionEvent actionEvent) {
        new Garland(tree).draw(paneTree);
    }

    public void addStarButton(ActionEvent actionEvent) {
        new Star(tree).draw(paneTree);
    }

    public void addPresentButton(ActionEvent actionEvent) {
        new Podarki(tree).draw(paneTree);
    }

    public void addAllButton(ActionEvent actionEvent) { tree = new Podarki(tree); tree = new Star(tree); tree= new Garland(tree); tree.draw(paneTree);}

    public void clearDecorated(ActionEvent actionEvent) {
        this.paneTree.getChildren().clear();
        tree = new ChristmasTree();
        this.tree.draw(this.paneTree);
    }

}