import java.util.ArrayList;

public class Tests {
    public static void main(String[] args) {

//      Hospital initialization

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

        System.out.println("\n----------------- Hospital toString test -----------------\n");
        System.out.println(hospital_1);

//      Doctor initialization

        Doctor doctor_1 = new Doctor("bob_123", "password123","Bob", 46, 10, Departments.get(2));
        Doctor doctor_2 = new Doctor("rob_123", "password123","ROb", 60, 29, Departments.get(6));

        System.out.println("\n----------------- Doctor toString test -----------------\n");

        System.out.println();
        System.out.println(doctor_1);


        System.out.println("\n----------------- Hospital hireDoctor test -----------------\n");
        hospital_1.hireDoctor(doctor_1);
        System.out.println();
        System.out.println(hospital_1);

//      Patient initialization

        Patient patient_1 = new Patient("clark_123", "password123", "Clark", 30, false);
        Patient patient_2 = new Patient("mark_123", "password123", "Mark", 32, true, "+3530749128627");

        System.out.println("\n-----------------Patient toString Test-----------------\n");
        System.out.println(patient_1);
        System.out.println(patient_2);

        System.out.println("\n-----------------Patient getters Test-----------------\n");

        System.out.println(patient_1.getName());
        System.out.println(patient_1.getAge());
        System.out.println(patient_1.getPhone());
        System.out.println(patient_1.getHas_medical_card());
        System.out.println(patient_1.getAppointments());


        System.out.println("\n-----------------Patient changePhoneNumber Test-----------------\n");
        System.out.println(patient_1.changePhoneNumber("+3530749128627"));


        System.out.println("\n-----------------Doctor addPatient Test-----------------\n");
        doctor_1.addPatient(patient_1);
        doctor_2.addPatient(patient_2);
        doctor_1.displayPatients();
        System.out.println();
        doctor_2.displayPatients();


        System.out.println("\n-----------------Doctor addAppointment Test-----------------\n");
        doctor_1.addAppointment("2004-01-08 04:05:06", patient_1);
        doctor_1.displayAppointments();


        System.out.println("\n-----------------Doctor deletePatient Test-----------------\n");
        System.out.println(doctor_1.getAppointments());
        doctor_1.deletePatient(patient_1);
        System.out.println(doctor_1.getAppointments());

        System.out.println("\n-----------------Doctor prescribe Test-----------------\n");
        ArrayList<String> prescription = new ArrayList<>();
        ArrayList<Double> dose = new ArrayList<>();
        ArrayList<String> info = new ArrayList<>();

        prescription.add("Paracetamol");
        dose.add(100.0);
        info.add("3 days");
        prescription.add("Ibuprofen");
        dose.add(150.3);
        info.add("5 days");
        prescription.add("Omeprazole");
        dose.add(180.1);
        info.add("30 days");
        prescription.add("Aspirin");
        dose.add(10.4);
        info.add("15 days");

        System.out.println(patient_2.getMedicalHistories());
        System.out.println(doctor_2.getPatients());
        doctor_2.addAppointment("2004-01-08 04:05:06", patient_2);

        doctor_2.prescribe(patient_2, "2004-01-08 04:05:06", prescription, dose, info);
        System.out.println(patient_2.getMedicalHistories());

        System.out.println("\n-----------------Patient displayMedicalHistory Test-----------------\n");
        patient_2.displayMedicalHistory();
        patient_2.displayAppointment();


        System.out.println("\n-----------------Patient cancelAppointment Test-----------------\n");

        doctor_2.addAppointment("2004-02-08 04:05:06", patient_2);
        System.out.println(patient_2.cancelAppointment(patient_2.getAppointments().get(1)));

        System.out.println("\n-----------------Hospital fireDoctor Test-----------------\n");
        hospital_1.fireDoctor(doctor_1);


        System.out.println("\n-----------------Hospital sortDoctors by name Test-----------------\n");
        hospital_1.sortDoctors("experience");
        System.out.println("\n-----------------Hospital sortDoctors by age Test-----------------\n");
        hospital_1.sortDoctors("age");
        System.out.println("\n-----------------Hospital sortDoctors by name Test-----------------\n");
        hospital_1.sortDoctors("name");


    }
}
