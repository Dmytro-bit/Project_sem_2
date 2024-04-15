import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> Departments = new ArrayList<>();
        Departments.add("Emergency Medicine Department");
        Departments.add("Pediatrics Department");
        Departments.add("Obstetrics and Gynecology Department");
        Departments.add("Surgery Department");
        Departments.add("Internal Medicine Department");
        Departments.add("Radiology Department");
        Departments.add("Oncology Department");
        Departments.add("Cardiology Department");
        Departments.add("Neurology Department");
        Departments.add("Orthopedics Department");

        Hospital hospital_1 = new Hospital("Hospital #1", new ArrayList<>(), Departments);
        System.out.println(hospital_1);


        Doctor doctor_1 = new Doctor("Bob", 46, 10, Departments.get(2));
        System.out.println();
        System.out.println(doctor_1);

        hospital_1.hireDoctor(doctor_1);

        System.out.println();
        System.out.println(hospital_1);



//        ArrayList<Doctor> doctors;
    }
}