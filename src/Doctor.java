import java.util.ArrayList;

public class Doctor {
    //Attributes
    private String name;
    private int age;
    private int experience_years;
    private String department;
    private ArrayList<Patient> patients;
    private ArrayList<Appointment> appointments;

    //Constructors
    public Doctor(String name, int age, int experience_years, String department, ArrayList<Patient> patients) {
        this.name = name;
        this.age = age;
        this.experience_years = experience_years;
        this.patients = patients;
        this.department = department;
    }

    public Doctor() {
        this.name = "";
        this.age = 0;
        this.experience_years = 0;
        this.department = "";
        this.patients = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    //Getters

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getExperience_years() {
        return experience_years;
    }

    public String getDepartment() {
        return department;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setExperience_years(int experience_years) {
        this.experience_years = experience_years;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Doctor:\nname: " + this.name +
                "\nage: " + this.age +
                "\nYears of Practice: " + this.experience_years;
    }

    public void displayPatients() {
        int total = 0;
        for (Patient i : patients) {
            System.out.println(i);
            total++;
        }
        System.out.println("Total number of patients: " + total);
    }

    public void addAppointment(Appointment a) {
        appointments.add(a);
    }

    public void addAppointment(String time, Doctor d, Patient p) {
        Appointment a = new Appointment(time, d, p);
        appointments.add(a);
    }

    public void displayAppointments() {
        int total = 0;
        for (int i = 0; i <= appointments.size(); i++) {
            total++;
            System.out.println(appointments.get(i));
        }
        System.out.println("Total amount of appointments: " + total);
    }

    public void addPatient(Patient p) {
        if (!patients.contains(p)) {
            patients.add(p);
            System.out.println("Patient " + p.getName() + "has been put on record to Dr. " + this.getName());
        } else
            System.out.println("This patient is already registered with Dr. " + this.getName());
    }

    public void addPatient(String name, int age, boolean mc) {
        Patient p = new Patient(name, age, mc);
        if (!patients.contains(p)) {
            patients.add(p);
            System.out.println("Patient " + p.getName() + "has been put on record to Dr. " + this.getName());
        } else
            System.out.println("This patient is already registered with Dr. " + this.getName());
    }

    public void deletePatient(Patient p) {
        if (patients.contains(p)) {
            patients.remove(p);
            System.out.println("Patient " + p.getName() + "has been deleted from Dr. " + this.getName() + "'s register");
        } else
            System.out.println("This patient is not in the Dr. " + this.getName() + "'s register");
    }

    public void removeAppointment(Appointment a) {
        this.appointments.remove(a);
    }
}