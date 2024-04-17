import java.util.ArrayList;

public class Patient {
    private String name;
    private Integer age;
    private boolean has_medical_card;
    private String phone;

    private ArrayList<MedicalHistory> medicalHistories;

    private ArrayList<Appointment> appointments;

    public Patient(String name, Integer age, boolean has_medical_card) {
        this.name = name;
        this.age = age;
        this.has_medical_card = has_medical_card;
        this.appointments = new ArrayList<>();
        this.medicalHistories = new ArrayList<>();

    }

    public Patient(String name, Integer age, boolean has_medical_card, String phone) {
        this.name = name;
        this.age = age;
        this.has_medical_card = has_medical_card;
        this.phone = phone;
        this.appointments = new ArrayList<>();
        this.medicalHistories = new ArrayList<>();
    }

    public Patient() {
        this.name = "";
        this.age = 0;
        this.has_medical_card = false;
        this.phone = "";
        this.medicalHistories = new ArrayList<>();
    }

    // Getters

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public boolean getHas_medical_card() {
        return has_medical_card;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public ArrayList<MedicalHistory> getMedicalHistories() {
        return medicalHistories;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setHas_medical_card(boolean has_medical_card) {
        this.has_medical_card = has_medical_card;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    // ToString
    @Override
    public String toString() {
        return "Patient name: " + name + "\tAge: " + age + "\tHas Medical Card: " + has_medical_card;
    }

    public void displayMedicalHistory()
    {
        System.out.println(this.medicalHistories);
    }

    public void displayAppointment()
    {
        System.out.println(this.appointments);
    }


    public String changePhoneNumber(String phone) {
        if (phone.indexOf("+") == 1) {
            if (phone.length() > 7 && phone.length() < 15) {
                return "Success";
            }
        }
        return "Invalid Phone Number";
    }

    public String addAppointment(Doctor doctor, Appointment a) {
        if (doctor.getPatients().contains(this)) {
            this.appointments.add(a);
            return "Success";
        }
        return "Error";
    }
    public void addAppointment(Appointment a) {
        this.appointments.add(a);
    }

    public void cancelAppointment(Appointment appointment) {  // Make this function
        if (this.appointments.contains(appointment)) {
            this.appointments.remove(appointment);
            Doctor doctor = appointment.getDoctor();
            doctor.removeAppointment(appointment);
        }
    }
}
