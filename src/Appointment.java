public class Appointment {
    //  Attributes
    private String appointmentTime;
    private Doctor doctor;
    private Patient patient;


    //    Constructors
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

    //  Getters
    public String getAppointmentTime() {
        return appointmentTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    //    Setters
    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * @return String representing of Appointment
     **/
    @Override
    public String toString() {
        return "\nDate and Time: " + this.appointmentTime + "\n" + this.patient + "\n" + this.doctor;
    }
}

