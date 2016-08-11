package hms;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class doctor {
    private final SimpleStringProperty uName;
    private final SimpleStringProperty fName;
    private final SimpleStringProperty mName;
    private final SimpleStringProperty lName;
    private final SimpleStringProperty telephone;
    private final SimpleStringProperty nic;
    private final SimpleStringProperty specialty;
    private final SimpleIntegerProperty salary;
    private final SimpleIntegerProperty ID;

    public String getfName() {
        return fName.get();
    }

    public SimpleStringProperty fNameProperty() {
        return fName;
    }

    public String getmName() {
        return mName.get();
    }

    public SimpleStringProperty mNameProperty() {
        return mName;
    }

    public String getlName() {
        return lName.get();
    }

    public SimpleStringProperty lNameProperty() {
        return lName;
    }

    public String getTelephone() {
        return telephone.get();
    }

    public SimpleStringProperty telephoneProperty() {
        return telephone;
    }

    public String getNic() {
        return nic.get();
    }

    public SimpleStringProperty nicProperty() {
        return nic;
    }

    public String getSpecialty() {
        return specialty.get();
    }

    public SimpleStringProperty specialtyProperty() {
        return specialty;
    }

    public int getSalary() {
        return salary.get();
    }

    public SimpleIntegerProperty salaryProperty() {
        return salary;
    }

    public int getID() {
        return ID.get();
    }

    public SimpleIntegerProperty IDProperty() {
        return ID;
    }

    public String getuName() {
        return uName.get();
    }

    public SimpleStringProperty uNameProperty() {
        return uName;
    }

    public doctor(String uName, String fName, String mName, String lName, String telephone, String nic, String specialty, int salary, int id) {
        this.uName = new SimpleStringProperty(uName);
        this.fName = new SimpleStringProperty(fName);
        this.mName = new SimpleStringProperty(mName);
        this.lName = new SimpleStringProperty(lName);
        this.telephone = new SimpleStringProperty(telephone);
        this.nic = new SimpleStringProperty(nic);
        this.specialty = new SimpleStringProperty(specialty);
        this.salary = new SimpleIntegerProperty(salary);
        this.ID = new SimpleIntegerProperty(id);
    }


}
