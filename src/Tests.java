import java.util.ArrayList;

public class Tests {
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

        // Doctor test

        Doctor doctor_1 = new Doctor("Bob", 46, 10, Departments.get(2));
        Doctor doctor_2 = new Doctor("ROb", 60, 29, Departments.get(6));
        System.out.println();
        System.out.println(doctor_1);

        hospital_1.hireDoctor(doctor_1);

        System.out.println();
        System.out.println(hospital_1);

        // Patient test

        Patient patient_1  = new Patient("Clark", 30, false);
        Patient patient_2  = new Patient("Mark", 32, true, "+3530749128627");

        System.out.println("\n-----------------Patient Test-----------------\n");
        System.out.println(patient_1);
        System.out.println(patient_2);

        System.out.println("\n-----------------Patient getters Test-----------------\n");

        System.out.println(patient_1.getName());
        System.out.println(patient_1.getAge());
        System.out.println(patient_1.getPhone());
        System.out.println(patient_1.getHas_medical_card());
        System.out.println(patient_1.getAppointments());

        System.out.println(patient_1.changePhoneNumber("+3530749128627"));

        // Doctor addPatient test
        doctor_1.addPatient(patient_1);
        doctor_2.addPatient(patient_2);
        System.out.println("\n-----------------Doctor add patient Test-----------------\n");
        doctor_1.displayPatients();
        System.out.println();
        doctor_2.displayPatients();






//        ArrayList<Doctor> doctors;

    }
}
