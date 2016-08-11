package hms;

import javafx.scene.Scene;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class customNotify {

    public void createNote(String note) {
        Label alert = new Label(note);
        DialogPane dialogPane = new DialogPane();
        dialogPane.setPrefWidth(300);
        dialogPane.setPrefHeight(50);
        dialogPane.setContent(alert);
        Scene scene = new Scene(dialogPane);
        Stage stage = new Stage();
        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> stage.close());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
