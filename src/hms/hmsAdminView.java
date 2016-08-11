package hms;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static hms.hmsLogin.*;

public class hmsAdminView implements Initializable {
    public MenuBar daBar;
    public TableView<doctor> adminViewTable;
    public TableColumn<doctor, Integer> adminViewId;
    public TableColumn<doctor, String> adminViewUname;
    public TableColumn<doctor, String> adminViewFname;
    public TableColumn<doctor, String> adminViewMname;
    public TableColumn<doctor, String> adminViewLname;
    public TableColumn<doctor, String> adminViewTele;
    public TableColumn<doctor, String> adminViewNic;
    public TableColumn<doctor, String> adminViewSpec;
    public TableColumn<doctor, Integer> adminViewSal;

    Connection connection = null;
    Statement command = null;
    ObservableList<doctor> data = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String sql = "SELECT * FROM doctor;";


        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, dbUser, dbPass);

            command = connection.createStatement();
            ResultSet rs = command.executeQuery(sql);

            while (rs.next()) {
                data.add(new doctor(rs.getString("uName"), rs.getString("fName"), rs.getString("mName"), rs.getString("lName"), rs.getString("telephone"), rs.getString("nic"), rs.getString("specialty"), rs.getInt("salary"), rs.getInt("docId")));
            }
            rs.close();
            adminViewId.setCellValueFactory(new PropertyValueFactory<>("ID"));
            adminViewUname.setCellValueFactory(new PropertyValueFactory<>("uName"));
            adminViewFname.setCellValueFactory(new PropertyValueFactory<>("fName"));
            adminViewMname.setCellValueFactory(new PropertyValueFactory<>("mName"));
            adminViewLname.setCellValueFactory(new PropertyValueFactory<>("lName"));
            adminViewTele.setCellValueFactory(new PropertyValueFactory<>("telephone"));
            adminViewNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
            adminViewSpec.setCellValueFactory(new PropertyValueFactory<>("specialty"));
            adminViewSal.setCellValueFactory(new PropertyValueFactory<>("salary"));
            adminViewTable.setItems(data);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                command.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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


