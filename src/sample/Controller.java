package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * hier we are lernt, how to use property in Javafx;
 */
public class Controller implements Initializable {
   final MyNumber myNum = new MyNumber();

    @FXML
    private Label lblStatus;

    @FXML
    private ProgressBar pb;

    @FXML
    private ProgressIndicator pi;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myNum.setNumber(0);
        myNum.numberProperty().addListener((ChangeListener<Object>) (observableValue, o, t1) -> lblStatus.setText(Double.toString(myNum.getNumber())));
        pb.progressProperty().bind(myNum.numberProperty());//observable unidirectional binding in javafx
        pi.progressProperty().bind(myNum.numberProperty());
    }

    public void BtnClick(ActionEvent event) {
        myNum.setNumber(myNum.getNumber() + 0.1);
    }

    public void Btn2Click(ActionEvent actionEvent) {
        myNum.setNumber(myNum.getNumber() - 0.1);
    }
}
