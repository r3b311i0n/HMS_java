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

public class hmsPatientRemove {
    public MenuBar daBar;
    public TextField pidtxt;

    Connection conn = null;

    public void patientRemove() throws SQLException {

        String rmPid = String.valueOf(pidtxt.getText());

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, dbUser, dbPass);
            int success;

            PreparedStatement rmusr = conn.prepareStatement("DELETE FROM patient WHERE patientId = ?;");
            rmusr.setString(1, rmPid);

            success = rmusr.executeUpdate();
            System.out.println(success);

            if (success > 0) {
                customNotify sNote = new customNotify();
                sNote.createNote("Patient Deleted!");

            } else {
                customNotify fNote = new customNotify();
                fNote.createNote("Patient Not Found!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
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

    public void menuUpdateAdmin() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hmsAdminUpdate.fxml"));
            Parent parent = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("HMS Update Admins");
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

