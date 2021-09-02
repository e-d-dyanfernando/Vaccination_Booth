package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Controller_receipt {

    @FXML
    private Label L_FIRST_NAME;

    @FXML
    private Label L_SURNAME;

    @FXML
    private Label L_AGE;

    @FXML
    private Label L_CITY;

    @FXML
    private Label L_NIC_or_PASSPORT;

    @FXML
    private Label L_VACCINE;

    @FXML
    private Label L_BOOTH;

    @FXML
    private Label L_DATE_and_TIME;

    public void FN(String TF_FirstName) {
        L_FIRST_NAME.setText(TF_FirstName);
    }

    @FXML
    public void SN(String TF_Surname) {
        L_SURNAME.setText(TF_Surname);
    }

    @FXML
    public void A(String TF_Age) {
        L_AGE.setText(TF_Age);
    }

    @FXML
    public void C(String TF_City) {
        L_CITY.setText(TF_City);
    }

    @FXML
    public void ID(String TF_ID) {
        L_NIC_or_PASSPORT.setText(TF_ID);
    }

    @FXML
    public void VR(String TF_Vaccination) {
        L_VACCINE.setText(TF_Vaccination);
    }

    @FXML
    public void B(String TF_BoothNumber) {
        L_BOOTH.setText(TF_BoothNumber);
    }

    @FXML
    public void initialize(){
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd  hh:mm:ss").format(Calendar.getInstance().getTime());
        L_DATE_and_TIME.setText(timeStamp );
    }
}