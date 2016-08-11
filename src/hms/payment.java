package hms;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class payment {
    private final SimpleIntegerProperty payId;
    private final SimpleIntegerProperty patientId;
    private final SimpleIntegerProperty amount;
    private final SimpleStringProperty date;
    private final SimpleStringProperty method;

    public payment(int payId, int patientId, int amount, String date, String method) {
        this.payId = new SimpleIntegerProperty(payId);
        this.patientId = new SimpleIntegerProperty(patientId);
        this.amount = new SimpleIntegerProperty(amount);
        this.date = new SimpleStringProperty(date);
        this.method = new SimpleStringProperty(method);
    }

    public int getPayId() {
        return payId.get();
    }

    public SimpleIntegerProperty payIdProperty() {
        return payId;
    }

    public int getPatientId() {
        return patientId.get();
    }

    public SimpleIntegerProperty patientIdProperty() {
        return patientId;
    }

    public int getAmount() {
        return amount.get();
    }

    public SimpleIntegerProperty amountProperty() {
        return amount;
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public String getMethod() {
        return method.get();
    }

    public SimpleStringProperty methodProperty() {
        return method;
    }
}
