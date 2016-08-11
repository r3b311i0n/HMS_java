package hms;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

import static hms.hmsMain.appName;

public class hmsLogin {
    public TextField logUname;
    public PasswordField logPword;
    public Button logIn;

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/hms";
    static final String dbUser = "root";
    static final String dbPass = "1000Truths";

    Connection conn = null;

    public void login() {
        String pword = String.valueOf(logPword.getText());
        String uname = String.valueOf(logUname.getText());

        String fname;
        String mname;
        String lname;
        String specialty;
        String nic;

        try {
            MessageDigest pw = MessageDigest.getInstance("SHA-256");
            byte[] hash = pw.digest(pword.getBytes("UTF-8"));
            String sha = DatatypeConverter.printHexBinary(hash);

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, dbUser, dbPass);

            PreparedStatement getusr = conn.prepareStatement("SELECT * FROM doctor WHERE uName = ? AND pw = ?;");
            getusr.setString(1, uname);
            getusr.setString(2, sha);
            ResultSet rs = getusr.executeQuery();

            if (rs.next()) {
                fname = rs.getString("fName");
                mname = rs.getString("mName");
                lname = rs.getString("lName");
                specialty = rs.getString("specialty");
                nic = rs.getString("nic");

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hmsMenu.fxml"));
                    Parent parent = fxmlLoader.load();
                    hmsMenu hmsInstance = fxmlLoader.getController();
                    hmsInstance.setMenuUname(uname);
                    hmsInstance.setMenuFname(fname);
                    hmsInstance.setMenuMname(mname);
                    hmsInstance.setMenuLname(lname);
                    hmsInstance.setMenuSpecialty(specialty);
                    hmsInstance.setMenuNic(nic);
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.initStyle(StageStyle.DECORATED);
                    stage.setResizable(false);
                    stage.setTitle(appName);
                    stage.setScene(new Scene(parent));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage close = (Stage) logIn.getScene().getWindow();
                rs.close();
                conn.close();
                close.close();
            } else {
                customNotify notify = new customNotify();
                notify.createNote("Invalid User!");
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void exit() {
        System.exit(0);
    }
}
