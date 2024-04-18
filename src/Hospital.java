import java.util.ArrayList;
import java.util.Collections;

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
        return "Hospital:\nName: " + this.name + " Departments: " + this.departments + " Doctors: " + this.doctors;
    }

    //Methods
    public void hireDoctor(Doctor d) {
        doctors.add(d);
        System.out.println("Dr. " + d.getName() + " was hired");
    }

    public void hireDoctor(String name, int age, int exp_years, String department, ArrayList<Patient> p) { // Require Bugfix
        Doctor d = new Doctor(name, age, exp_years, p, department);
        doctors.add(d);
        System.out.println("Dr. " + d.getName() + " was hired");
    }

    public void fireDoctor(Doctor d) {
        if (doctors.contains(d)) {
            doctors.remove(d);
            System.out.println("Dr. " + d.getName() + " was fired");
        }
    }

    public void fireDoctor(String doctorToFire) {

        for (int i = 0; i<doctors.size(); i++ ) {
            Doctor doctor = doctors.get(i);
            if(doctor.getName().equals(doctorToFire)){
                doctors.remove(doctor);
                System.out.println("Dr. " + doctor.getName() + " was fired");
            }
        }
        System.out.println("Dr. " + doctorToFire + " has not been founded. Ensure that entered name is correct and person you want to fire exists.");
    }
    public void sortDoctors(String sortingAttribute){
        ArrayList<Doctor> sortedDoctors = new ArrayList<>(doctors);
        if(sortingAttribute.equalsIgnoreCase("experience")) {
            for(int i = 0; i < doctors.size(); i++){
                for(int j = doctors.size() - 1; j>=i; j--){
                    if(sortedDoctors.get(i).getExperience_years()>sortedDoctors.get(j).getExperience_years()){
                        Doctor temp = sortedDoctors.get(i);
                        sortedDoctors.set(i, sortedDoctors.get(j));
                        sortedDoctors.set(j, temp);
                    }
                }
            }
            System.out.println("Sorted doctors list: \n" + sortedDoctors);
        } else if (sortingAttribute.equalsIgnoreCase("age")) {
            for(int i = 0; i < doctors.size(); i++){
                for(int j = doctors.size() - 1; j>=i; j--){
                    if(sortedDoctors.get(i).getAge()>sortedDoctors.get(j).getAge()){
                        Doctor temp = sortedDoctors.get(i);
                        sortedDoctors.set(i, sortedDoctors.get(j));
                        sortedDoctors.set(j, temp);
                    }
                }
            }
            System.out.println("Sorted doctors list: \n" + sortedDoctors);
        } else if (sortingAttribute.equalsIgnoreCase("name")) {
            for(int i = 0; i < doctors.size(); i++){
                for(int j = doctors.size() - 1; j>=i; j--){
                    if(sortedDoctors.get(i).getName().charAt(0)>sortedDoctors.get(j).getName().charAt(0)){
                        Doctor temp = sortedDoctors.get(i);
                        sortedDoctors.set(i, sortedDoctors.get(j));
                        sortedDoctors.set(j, temp);
                    }
                }
            }
            System.out.println("Sorted doctors list: \n" + sortedDoctors);
        }
    }

    public void addDepartment(String nameOfNewDepartment){
        departments.add(nameOfNewDepartment);
        System.out.println(departments);
    }
    public void removeDepartment(String nameOfFormerDepartment){
        departments.remove(nameOfFormerDepartment);
        System.out.println(departments);
    }
}
