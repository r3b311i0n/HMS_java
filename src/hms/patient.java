package hms;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class patient {
    private final SimpleIntegerProperty patientId;
    private final SimpleStringProperty type;
    private final SimpleStringProperty fName;
    private final SimpleStringProperty mName;
    private final SimpleStringProperty lName;
    private final SimpleStringProperty telephone;
    private final SimpleStringProperty nic;
    private final SimpleIntegerProperty age;
    private final SimpleStringProperty prognosis;
    private final SimpleStringProperty diagnosis;
    private final SimpleStringProperty symptoms;
    private final SimpleStringProperty comments;

    public patient(int patientId, String fName, String mName, String lName, String telephone, String nic, int age, String prognosis, String diagnosis, String symptoms, String comments, String type) {
        this.type = new SimpleStringProperty(type);
        this.patientId = new SimpleIntegerProperty(patientId);
        this.fName = new SimpleStringProperty(fName);
        this.mName = new SimpleStringProperty(mName);
        this.lName = new SimpleStringProperty(lName);
        this.telephone = new SimpleStringProperty(telephone);
        this.nic = new SimpleStringProperty(nic);
        this.age = new SimpleIntegerProperty(age);
        this.prognosis = new SimpleStringProperty(prognosis);
        this.diagnosis = new SimpleStringProperty(diagnosis);
        this.symptoms = new SimpleStringProperty(symptoms);
        this.comments = new SimpleStringProperty(comments);
    }

    public String getComments() {
        return comments.get();
    }

    public SimpleStringProperty commentsProperty() {
        return comments;
    }

    public String getPrognosis() {
        return prognosis.get();
    }

    public SimpleStringProperty prognosisProperty() {
        return prognosis;
    }

    public String getDiagnosis() {
        return diagnosis.get();
    }

    public SimpleStringProperty diagnosisProperty() {
        return diagnosis;
    }

    public String getSymptoms() {
        return symptoms.get();
    }

    public SimpleStringProperty symptomsProperty() {
        return symptoms;
    }

    public int getpatientId() {
        return patientId.get();
    }

    public SimpleIntegerProperty patientIdProperty() {
        return patientId;
    }

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

    public int getAge() {
        return age.get();
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }
}
