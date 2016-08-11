package hms;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
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

public class hmsPatientUpdate {
    public MenuBar daBar;
    public TextField pidtxt;
    public TextField typetxt;
    public TextField fNametxt;
    public TextField mNametxt;
    public TextField lNametxt;
    public TextField teletxt;
    public TextField nictxt;
    public TextField agetxt;
    public TextField progtxt;
    public TextField diagtxt;
    public TextField symptxt;
    public TextArea commentstxt;

    Connection conn = null;

    public void patientUpdate() throws SQLException {

        int pid = Integer.parseInt(pidtxt.getText());
        String type = String.valueOf(typetxt.getText());
        String fname = String.valueOf(fNametxt.getText());
        String mname = String.valueOf(mNametxt.getText());
        String lname = String.valueOf(lNametxt.getText());
        String telephone = String.valueOf(teletxt.getText());
        String nic = String.valueOf(nictxt.getText());
        int age = Integer.parseInt(agetxt.getText());
        String prog = String.valueOf(progtxt.getText());
        String diag = String.valueOf(diagtxt.getText());
        String symp = String.valueOf(symptxt.getText());
        String comments = String.valueOf(commentstxt.getText());


        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, dbUser, dbPass);

            PreparedStatement setPatient = conn.prepareStatement("UPDATE patient SET type = ?, fName = ?, mName = ?, lName = ?, telephone = ?, nic = ?, age = ?, prognosis = ?, diagnosis = ?, symptoms = ?, comments = ? WHERE patientId = ?;");
            setPatient.setString(1, type);
            setPatient.setString(2, fname);
            setPatient.setString(3, mname);
            setPatient.setString(4, lname);
            setPatient.setString(5, telephone);
            setPatient.setString(6, nic);
            setPatient.setInt(7, age);
            setPatient.setString(8, prog);
            setPatient.setString(9, diag);
            setPatient.setString(10, symp);
            setPatient.setString(11, comments);
            setPatient.setInt(12, pid);

            setPatient.executeUpdate();

            adminClear();

            customNotify note = new customNotify();
            note.createNote("Patient Updated!");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    public void adminClear() {
        pidtxt.setText("");
        typetxt.setText("");
        fNametxt.setText("");
        mNametxt.setText("");
        lNametxt.setText("");
        teletxt.setText("");
        nictxt.setText("");
        agetxt.setText("");
        symptxt.setText("");
        diagtxt.setText("");
        commentstxt.setText("");
        progtxt.setText("");
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
