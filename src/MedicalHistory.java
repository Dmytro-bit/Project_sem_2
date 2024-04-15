import java.util.ArrayList;

public class MedicalHistory {
    private String time;
    private ArrayList<String> prescription;
    private ArrayList<Double> dose;
    private ArrayList<String> info;

    public MedicalHistory() {
        this.time = null;
        this.prescription = null;
        this.dose = null;
        this.info = null;
    }

    public MedicalHistory(String time, ArrayList<String> prescription, ArrayList<Double> dose, ArrayList<String> info) {
        this.time = time;
        this.prescription = prescription;
        this.dose = dose;
        this.info = info;
    }

    // Getters
    public String getTime() {
        return time;
    }

    public ArrayList<String> getPrescription() {
        return prescription;
    }

    public ArrayList<Double> getDose() {
        return dose;
    }

    public ArrayList<String> getInfo() {
        return info;
    }

    // Setters
    public void setTime(String time) {
        this.time = time;
    }

    public void setPrescription(ArrayList<String> prescription) {
        this.prescription = prescription;
    }

    public void setDose(ArrayList<Double> dose) {
        this.dose = dose;
    }

    public void setInfo(ArrayList<String> info) {
        this.info = info;
    }

    @Override
    public String toString() {
        String returnString = "Appointment time: " + time + "\nPrescription: ";

        for (String medication : prescription) {
            returnString += "\t" + medication + " " + dose.get(prescription.indexOf(medication)) + " Info: "+ info.get(prescription.indexOf(medication));
        }

        return returnString;
    }
}
