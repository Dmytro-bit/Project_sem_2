import java.util.ArrayList;

public class Patient {
    private String name;
    private Integer age;
    private boolean has_medical_card;
    private String phone;

    private ArrayList<MedicalHistory> medicalHistories;

    public Patient(String name, Integer age, boolean has_medical_card) {
        this.name = name;
        this.age = age;
        this.has_medical_card = has_medical_card;

    }

    public Patient(String name, Integer age, boolean has_medical_card, String phone) {
        this.name = name;
        this.age = age;
        this.has_medical_card = has_medical_card;
        this.phone = phone;
    }

    public Patient() {
        this.name = "";
        this.age = 0;
        this.has_medical_card = false;
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

    // ToString
    @Override
    public String toString() {
        return "Patient:\n\tName: " + name + "\n\tAge: " + age + "\n\tHas Medical Card: " + has_medical_card;
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
            doctor.addAppointment(a);
            return "Success";
        }
        return "Error";
    }

    public String cancelAppointment(Doctor doctor, String time) {  // Make this function
        return null;
    }
}
