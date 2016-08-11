package hms;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static hms.hmsLogin.*;

public class hmsAdminUpdate {
    public TextField uNametxt;
    public TextField fNametxt;
    public TextField mNametxt;
    public TextField lNametxt;
    public TextField teletxt;
    public TextField nictxt;
    public TextField spectxt;
    public TextField saltxt;
    public MenuBar daBar;

    Connection conn = null;

    public void adminUpdate() throws SQLException {

        String uname = String.valueOf(uNametxt.getText());
        String fname = String.valueOf(fNametxt.getText());
        String mname = String.valueOf(mNametxt.getText());
        String lname = String.valueOf(lNametxt.getText());
        String telephone = String.valueOf(teletxt.getText());
        String nic = String.valueOf(nictxt.getText());
        String spec = String.valueOf(spectxt.getText());
        String sal = String.valueOf(saltxt.getText());


        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, dbUser, dbPass);

            PreparedStatement setusr = conn.prepareStatement("UPDATE doctor SET fName = ?, mName = ?, lName = ?, telephone = ?, nic = ?, specialty = ?, salary = ? WHERE uName = ?;");
            setusr.setString(1, fname);
            setusr.setString(2, mname);
            setusr.setString(3, lname);
            setusr.setString(4, telephone);
            setusr.setString(5, nic);
            setusr.setString(6, spec);
            setusr.setString(7, sal);
            setusr.setString(8, uname);

            setusr.executeUpdate();

            customNotify note = new customNotify();
            note.createNote("User Updated!");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    public void adminClear() {
        uNametxt.setText("");
        fNametxt.setText("");
        mNametxt.setText("");
        lNametxt.setText("");
        teletxt.setText("");
        nictxt.setText("");
        spectxt.setText("");
        saltxt.setText("");
    }

    public void menuViewAdmin() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hmsAdminView.fxml"));
            Parent parent = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("HMS View Admins");
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage close = (Stage) daBar.getScene().getWindow();
        close.close();
    }

    public void menuAddAdmin() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hmsAdminAdd.fxml"));
            Parent parent = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("HMS Add Admins");
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage close = (Stage) daBar.getScene().getWindow();
        close.close();
    }

    public void menuRemoveAdmin() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hmsAdminRemove.fxml"));
            Parent parent = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("HMS Remove Admins");
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage close = (Stage) daBar.getScene().getWindow();
        close.close();
    }

    public void menuViewPatient() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hmsPatientView.fxml"));
            Parent parent = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("HMS View Patients");
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage close = (Stage) daBar.getScene().getWindow();
        close.close();
    }

    public void menuAddPatient() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hmsPatientAdd.fxml"));
            Parent parent = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("HMS Add Patients");
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage close = (Stage) daBar.getScene().getWindow();
        close.close();
    }

    public void menuUpdatePatient() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hmsPatientUpdate.fxml"));
            Parent parent = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("HMS Update Patients");
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage close = (Stage) daBar.getScene().getWindow();
        close.close();
    }

    public void menuRemovePatient() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hmsPatientRemove.fxml"));
            Parent parent = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("HMS Remove Patients");
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage close = (Stage) daBar.getScene().getWindow();
        close.close();
    }

    public void menuViewPayment() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hmsPaymentView.fxml"));
            Parent parent = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("HMS View Payments");
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage close = (Stage) daBar.getScene().getWindow();
        close.close();
    }

    public void menuAddPaymentOut() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hmsPaymentAddOut.fxml"));
            Parent parent = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("HMS Add Payments For Outpatients");
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage close = (Stage) daBar.getScene().getWindow();
        close.close();
    }

    public void menuAddPaymentIn() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hmsPaymentAddIn.fxml"));
            Parent parent = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("HMS Add Payments For Inpatients");
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage close = (Stage) daBar.getScene().getWindow();
        close.close();
    }

    public void menuUpdatePayment() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hmsPaymentUpdate.fxml"));
            Parent parent = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("HMS Update Payments");
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage close = (Stage) daBar.getScene().getWindow();
        close.close();
    }

    public void menuRemovePayment() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hmsPaymentRemove.fxml"));
            Parent parent = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("HMS Remove Payments");
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage close = (Stage) daBar.getScene().getWindow();
        close.close();
    }

    public void menuViewReport() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hmsViewReport.fxml"));
            Parent parent = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("HMS View Reports");
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage close = (Stage) daBar.getScene().getWindow();
        close.close();
    }

    public void menuAddReport() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hmsReportAdd.fxml"));
            Parent parent = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("HMS Add Reports");
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage close = (Stage) daBar.getScene().getWindow();
        close.close();
    }

    public void menuUpdateReport() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hmsReportUpdate.fxml"));
            Parent parent = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("HMS Update Reports");
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage close = (Stage) daBar.getScene().getWindow();
        close.close();
    }

    public void menuRemoveReport() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hmsReportRemove.fxml"));
            Parent parent = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("HMS Remove Reports");
            stage.setScene(new Scene(parent));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage close = (Stage) daBar.getScene().getWindow();
        close.close();
    }

    public void menuClose() {
        System.exit(0);
    }
}

