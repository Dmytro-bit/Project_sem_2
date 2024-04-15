import java.util.ArrayList;

public class Appointment {
    private String appointmentTime;
    private Doctor doctor;
    private Patient patient;
    public Appointment(String appointmentTime, Doctor doctor, Patient patient) {
        this.appointmentTime = appointmentTime;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Appointment() {
        this.appointmentTime = "";
        this.doctor = new Doctor();
        this.patient = new Patient();
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Date and Time: " + this.appointmentTime + "\n" + this.patient + "\n" + this.doctor;
    }
}

