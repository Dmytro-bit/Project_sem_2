import java.util.ArrayList;

public class Patient {
    private String log_in;
    private String password;
    private String name;
    private Integer age;
    private boolean has_medical_card;
    private String phone;

    private ArrayList<MedicalHistory> medicalHistories;

    private ArrayList<Appointment> appointments;

    public Patient(String log_in, String password, String name, Integer age, boolean has_medical_card, String phone) {
        this.log_in = log_in;
        this.password = password;
        this.name = name;
        this.age = age;
        this.has_medical_card = has_medical_card;
        this.phone = phone;
        this.appointments = new ArrayList<>();
        this.medicalHistories = new ArrayList<>();
    }

    public Patient(String log_in, String password, String name, Integer age, boolean has_medical_card) {
        this.log_in = log_in;
        this.password = password;
        this.name = name;
        this.age = age;
        this.has_medical_card = has_medical_card;
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
    public String getLog_in() {
        return log_in;
    }

    public String getPassword() {
        return password;
    }

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
    public void setLog_in(String log_in) {
        this.log_in = log_in;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
        return "Patient \n\t-Name: " + name + "\n\t-Age: " + age + "\n\t-Has Medical Card: " + has_medical_card + "\n\t-Phone: " + phone + "\n";
    }

    public void displayMedicalHistory() {
        System.out.println(this.medicalHistories);
    }

    public void displayAppointment() {
        if(appointments.size() > 0)
            System.out.println(this.appointments);
        else
            System.out.println("No appointments scheduled");
    }


    public String changePhoneNumber(String phone) {
        if (phone.indexOf("+") == 0) {
            if (phone.length() > 7 && phone.length() < 15) {
                this.phone = phone;
                return "Success";
            }
        }
        return "Invalid Phone Number";
    }

    public String addAppointment(Doctor doctor, Appointment a) {
        if (doctor.getPatients().contains(this)) {
            this.appointments.add(a);
            doctor.getAppointments().add(a);
            System.out.println("You have successfully scheduled an appointment with Dr. "+doctor.getName()+"\n");
            return "Success";
        }
        System.out.println("You are not registered with this doctor");
        return "Error";
    }

    public void addAppointment(Appointment a) {

        this.appointments.add(a);
    }

    public String cancelAppointment(Appointment appointment) {  // Make this function
        if(appointments.size() > 1)
        {
            if (this.appointments.contains(appointment)) {
                this.appointments.remove(appointment);
                Doctor doctor = appointment.getDoctor();
                doctor.removeAppointment(appointment);
                return "Success";
            }
        }
        else
            System.out.println("You do not have any appointments scheduled");
        return "Error";
    }

    public void changePassword() {

    }
}
