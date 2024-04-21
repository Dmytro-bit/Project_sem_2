import java.util.ArrayList;

public class MedicalHistory {
    //  Attributes
    private String time;
    private ArrayList<String> prescription;
    private ArrayList<Double> dose;
    private ArrayList<String> info;

    //  Constructor
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

    /**
     * @return String representing of MedicalHistory
     **/
    @Override
    public String toString() {
        String returnString = "Appointment time: " + time + "Prescription: ";

        for (String medication : prescription) {
            returnString += "\t" + medication + " " + dose.get(prescription.indexOf(medication)) + "mg " + info.get(prescription.indexOf(medication));
        }

        return returnString;
    }
}
