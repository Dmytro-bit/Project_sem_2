import java.util.ArrayList;

public class Hospital {
    //Attributes
    private String name;

    private ArrayList<String> departments;
    private ArrayList<Doctor> doctors;

    //Constructor
    public Hospital(String name, ArrayList<Doctor> doctors, ArrayList<String> departments) {
        this.name = name;
        this.departments = departments;
        this.doctors = doctors;
    }

    public Hospital() {
        this.name = "";
        this.doctors = new ArrayList<>();
        this.departments = new ArrayList<>();
    }

    //Getters
    public String getName() {
        return this.name;
    }

    public ArrayList<String> getDepartments() {
        return this.departments;
    }

    public ArrayList<Doctor> getDoctors() {
        return this.doctors;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartments(ArrayList<String> departments) {
        this.departments = departments;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Hospital:\nName: " + this.name + "Doctors: " + this.doctors;
    }

    //Methods
    public void hireDoctor(Doctor d) {
        doctors.add(d);
        System.out.println("Dr. " + d.getName() + " was hired");
    }

    public void hireDoctor(String name, int age, int exp_years, String department, ArrayList<Patient> p) {
        Doctor d = new Doctor(name, age, exp_years, department, p);
        doctors.add(d);
        System.out.println("Dr. " + d.getName() + " was hired");
    }

    public void fireDoctor(Doctor d) {
        if (doctors.contains(d)) {
            doctors.remove(d);
            System.out.println("Dr. " + d.getName() + " was fired");
        }
    }
}
