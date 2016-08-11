package hms;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class report {
    private final SimpleIntegerProperty reportId;
    private final SimpleIntegerProperty patientId;
    private final SimpleStringProperty contents;

    public report(int reportId, int patientId, String contents) {
        this.reportId = new SimpleIntegerProperty(reportId);
        this.patientId = new SimpleIntegerProperty(patientId);
        this.contents = new SimpleStringProperty(contents);
    }

    public int getReportId() {
        return reportId.get();
    }

    public SimpleIntegerProperty reportIdProperty() {
        return reportId;
    }

    public int getpatientId() {
        return patientId.get();
    }

    public SimpleIntegerProperty patientIdProperty() {
        return patientId;
    }

    public String getContents() {
        return contents.get();
    }

    public SimpleStringProperty contentsProperty() {
        return contents;
    }
}
