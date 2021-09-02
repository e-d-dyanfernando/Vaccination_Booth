package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField TF_FIRST_NAME;

    @FXML
    private TextField TF_SURNAME;

    @FXML
    private TextField TF_AGE;

    @FXML
    private TextField TF_CITY;

    @FXML
    private TextField TF_NIC_or_PASSPORT;

    @FXML
    private ChoiceBox<String> TF_CHOICE_BOX;                  //Array to the choice box
    private String[] Vaccination = {"AstraZeneca", "Sinopharm", "Pfizer"};

    @FXML
    private TextField TF_BOOTH;

    @FXML
    private Button B_GENERATE_RECEIPT;

    @FXML
    public void ACTION_GENERATE() {
        try {                                            //This will load the receipt
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Receipt.fxml"));
            Parent root = loader.load();

            Controller_receipt controlling_reciept = loader.getController();
            controlling_reciept.FN(TF_FIRST_NAME.getText());
            controlling_reciept.SN(TF_SURNAME.getText());
            controlling_reciept.A(TF_AGE.getText().toString());
            controlling_reciept.C(TF_CITY.getText());
            controlling_reciept.ID(TF_NIC_or_PASSPORT.getText());
            controlling_reciept.VR(TF_CHOICE_BOX.getValue());
            controlling_reciept.B(TF_BOOTH.getText().toString());

            Stage stage = (Stage) B_GENERATE_RECEIPT.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Vaccination Center");

            primaryStage.show();

        }catch (IOException ex){
            System.err.println(ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TF_CHOICE_BOX.getItems().addAll(Vaccination);
    }
}