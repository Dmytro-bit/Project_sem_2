import java.util.ArrayList;

public class MedicalHistory {
    private String time;
    private ArrayList<String> prescription;
    private ArrayList<Double> dose;

    public MedicalHistory() {

    }

    public MedicalHistory(String time, ArrayList<String> prescription, ArrayList<Double> dose) {
        this.time = time;
        this.prescription = prescription;
        this.dose = dose;
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

    @Override
    public String toString() {
        String returnString = "Appointment time: " + time + "\nPrescription: ";

        for (String medication : prescription) {
            returnString += "\t" + medication + " " + dose.get(prescription.indexOf(medication));
        }

        return returnString;
    }
}
