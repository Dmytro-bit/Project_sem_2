import java.util.ArrayList;

public class Hospital {
    //Attributes
    private String name;

    private ArrayList<String> departments;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    private ArrayList<String> adminPasswords, adminLogIns;

    private String defaultPassword;

    //Constructor
    public Hospital(String name, ArrayList<Doctor> doctors, ArrayList<String> departments) {
        this.name = name;
        this.departments = departments;
        this.doctors = doctors;
        patients = new ArrayList<>();
        adminPasswords = new ArrayList<>();
        adminLogIns = new ArrayList<>();
        defaultPassword = "qwerty123";
        adminPasswords.add(defaultPassword);
        adminPasswords.add("123456t");
        adminLogIns.add("AdamSmith68");
        adminLogIns.add("MarySue70");
    }

    public Hospital(String name, ArrayList<Doctor> doctors, ArrayList<String> departments, ArrayList<Patient> patients) {
        this.name = name;
        this.departments = departments;
        this.doctors = doctors;
        this.patients = patients;
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

    public ArrayList<Patient> getPatients(){
        return this.patients;
    }
    public ArrayList<String > getAdminLogIns() {
        return this.adminLogIns;
    }

    public ArrayList<String> getAdminPasswords() {
        return this.adminPasswords;
    }
    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPatients(ArrayList<Patient> patients){
        this.patients = patients;
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

    public void hireDoctor(String log_in, String password, String name, int age, int exp_years, String department, ArrayList<Patient> p) { // Require Bugfix
        Doctor d = new Doctor(log_in, password, name, age, exp_years, p, department);
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

        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            if (doctor.getName().equals(doctorToFire)) {
                doctors.remove(doctor);
                System.out.println("Dr. " + doctor.getName() + " was fired");
            }
        }
        System.out.println("Dr. " + doctorToFire + " has not been founded. Ensure that entered name is correct and person you want to fire exists.");
    }

    public void sortDoctors(String sortingAttribute) {
        ArrayList<Doctor> sortedDoctors = new ArrayList<>(doctors);
        if (sortingAttribute.equalsIgnoreCase("experience")) {
            for (int i = 0; i < doctors.size(); i++) {
                for (int j = doctors.size() - 1; j >= i; j--) {
                    if (sortedDoctors.get(i).getExperience_years() > sortedDoctors.get(j).getExperience_years()) {
                        Doctor temp = sortedDoctors.get(i);
                        sortedDoctors.set(i, sortedDoctors.get(j));
                        sortedDoctors.set(j, temp);
                    }
                }
            }
            System.out.println("Sorted doctors list: \n" + sortedDoctors);
        } else if (sortingAttribute.equalsIgnoreCase("age")) {
            for (int i = 0; i < doctors.size(); i++) {
                for (int j = doctors.size() - 1; j >= i; j--) {
                    if (sortedDoctors.get(i).getAge() > sortedDoctors.get(j).getAge()) {
                        Doctor temp = sortedDoctors.get(i);
                        sortedDoctors.set(i, sortedDoctors.get(j));
                        sortedDoctors.set(j, temp);
                    }
                }
            }
            System.out.println("Sorted doctors list: \n" + sortedDoctors);
        } else if (sortingAttribute.equalsIgnoreCase("name")) {
            for (int i = 0; i < doctors.size(); i++) {
                for (int j = doctors.size() - 1; j >= i; j--) {
                    if (sortedDoctors.get(i).getName().charAt(0) > sortedDoctors.get(j).getName().charAt(0)) {
                        Doctor temp = sortedDoctors.get(i);
                        sortedDoctors.set(i, sortedDoctors.get(j));
                        sortedDoctors.set(j, temp);
                    }
                }
            }
            System.out.println("Sorted doctors list: \n" + sortedDoctors);
        }
    }

    public void addDepartment(String nameOfNewDepartment) {
        departments.add(nameOfNewDepartment);
        System.out.println(departments);
    }

    public void removeDepartment(String nameOfFormerDepartment) {
        departments.remove(nameOfFormerDepartment);
        System.out.println(departments);
    }

    public void addPatientsToDB(ArrayList<Patient> newPatients){
        patients.addAll(newPatients);
    }

    public void addNewPatient(Patient newPatient) {
        patients.add(newPatient);
    }

    public void deletePatientFromDB(String patientToDelete) {

        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            if (patient.getName().equals(patientToDelete)) {
                patients.remove(patient);
                System.out.println("Patient " + patient.getName() + " was deleted");
            }
        }
        System.out.println("Patient " + patientToDelete + " has not been founded. Ensure that entered name is correct and person you want to delete exists.");
    }

}
