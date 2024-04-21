import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hospital {
    //Attributes
    private String name;
    private String workingHours;
    private ArrayList<String> departments;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    private ArrayList<String> adminPasswords, adminLogIns;
    private ArrayList<Appointment> appointments;
    private String defaultPassword;

    //Constructor
    public Hospital(String name, String workingHours, ArrayList<Doctor> doctors, ArrayList<String> departments) {
        this.name = name;
        this.workingHours = workingHours;
        this.departments = departments;
        this.doctors = doctors;
        patients = new ArrayList<>();
        appointments = new ArrayList<>();
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

    public ArrayList<Appointment> getAppointments(){
        return this.appointments;
    }
    public String getWorkingHours() {
        return workingHours;
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

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public void setPatients(ArrayList<Patient> patients){
        this.patients = patients;
    }

    public void setDepartments(ArrayList<String> departments) {
        this.departments = departments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Hospital:\n\t-Name: " + this.name + "\n\t-Departments: " + this.departments + "\n\t-Doctors: " + this.doctors;
    }

    //Methods
    public void displayDoctors()
    {
        int counter = 0;
        for(Doctor d : doctors){
            counter++;
            System.out.println(counter+" "+d);
        }
    }

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

    /*public void sortDoctors(String sortingAttribute) {
        ArrayList<Doctor> unsortedDoctors = new ArrayList<>(doctors);
        if (sortingAttribute.equalsIgnoreCase("experience")) {
            ArrayList<Integer> experience_list = new ArrayList<>();
            ArrayList<Integer> unsortedIndexes = new ArrayList<>();
            for (Doctor doctor: unsortedDoctors) {
                experience_list.add(doctor.getExperience_years());
                unsortedIndexes.add(unsortedDoctors.indexOf(doctor));
            }
            ArrayList<Integer> backup = new ArrayList<>(experience_list);
            ArrayList<Integer> sortedIndexes = new ArrayList<>();

            Collections.sort(experience_list);
            for (Integer exp_index: experience_list) {
                sortedIndexes.add(backup.indexOf(exp_index));
            }
            System.out.println("Unsorted indexes: " + unsortedIndexes);
            System.out.println("sorted indexes: " + sortedIndexes);
            System.out.println("Unsorted doctors: " + unsortedDoctors);
            ArrayList<Doctor> sortedDoctors = new ArrayList<>();

            for (int i = 0; i < unsortedDoctors.size(); i++) {
                int sorted_index = sortedIndexes.get(i);
                sortedDoctors.add(unsortedDoctors.get(sorted_index));
            }

            System.out.println("Sorted doctors list: \n" + sortedDoctors);
        } else if (sortingAttribute.equalsIgnoreCase("age")) {
            ArrayList<Integer> age_list = new ArrayList<>();
            ArrayList<Integer> unsortedIndexes = new ArrayList<>();
            for (Doctor doctor: unsortedDoctors) {
                age_list.add(doctor.getAge());
                unsortedIndexes.add(unsortedDoctors.indexOf(doctor));
            }
            ArrayList<Integer> backup = new ArrayList<>(age_list);
            ArrayList<Integer> sortedIndexes = new ArrayList<>();

            Collections.sort(age_list);
            for (Integer age_index: age_list) {
                sortedIndexes.add(backup.indexOf(age_index));
            }
            System.out.println("Unsorted indexes: " + unsortedIndexes);
            System.out.println("sorted indexes: " + sortedIndexes);
            System.out.println("Unsorted doctors: " + unsortedDoctors);
            ArrayList<Doctor> sortedDoctors = new ArrayList<>();

            for (int i = 0; i < unsortedDoctors.size(); i++) {
                int sorted_index = sortedIndexes.get(i);
                sortedDoctors.add(unsortedDoctors.get(sorted_index));
            }
            System.out.println("Sorted doctors list: \n" + sortedDoctors );
        } else if (sortingAttribute.equalsIgnoreCase("name")) {
            ArrayList<String> name_list = new ArrayList<>();
            ArrayList<Integer> unsortedIndexes = new ArrayList<>();
            for (Doctor doctor: unsortedDoctors) {
                name_list.add(doctor.getName());
                unsortedIndexes.add(unsortedDoctors.indexOf(doctor));
            }
            ArrayList<String> backup = new ArrayList<>(name_list);
            ArrayList<Integer> sortedIndexes = new ArrayList<>();

            Collections.sort(name_list);
            for (String name_index: name_list) {
                sortedIndexes.add(backup.indexOf(name_index));
            }
            System.out.println("Unsorted indexes: " + unsortedIndexes);
            System.out.println("sorted indexes: " + sortedIndexes);
            System.out.println("Unsorted doctors: " + unsortedDoctors);
            ArrayList<Doctor> sortedDoctors = new ArrayList<>();

            for (int i = 0; i < unsortedDoctors.size(); i++) {
                int sorted_index = sortedIndexes.get(i);
                sortedDoctors.add(unsortedDoctors.get(sorted_index));
            }
            System.out.println("Sorted doctors list: \n" + sortedDoctors);
        }
    } */

    public void sortDoctors(String sortBy) {
        ArrayList<Doctor> sortedDoctors = new ArrayList<>(doctors);
        switch (sortBy.toLowerCase()) {
            case "experience":
                Collections.sort(sortedDoctors, new Comparator<Doctor>() {
                    @Override
                    public int compare(Doctor o1, Doctor o2) {
                        return Integer.compare(o1.getExperience_years(), o2.getExperience_years());
                    }
                });
                break;
            case "name":
                Collections.sort(sortedDoctors, new Comparator<Doctor>() {
                    @Override
                    public int compare(Doctor o1, Doctor o2) {
                        return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
                    }
                });
                break;
            case "age":
                Collections.sort(sortedDoctors, new Comparator<Doctor>() {
                    @Override
                    public int compare(Doctor o1, Doctor o2) {
                        return Integer.compare(o1.getAge(), o2.getAge());
                    }
                });
                break;
            case "none":
                break;
            default:
                System.out.println("Invalid sorting parameter. Please enter 'name', 'age', 'experience' or 'none'");
                break;
        }
        System.out.println("List of Doctors: " + sortedDoctors);


    }
    public void addDepartment(String nameOfNewDepartment) {
        departments.add(nameOfNewDepartment);
        System.out.println(departments);
    }

    public void removeDepartment(String nameOfFormerDepartment) {
        departments.remove(nameOfFormerDepartment);
        System.out.println(departments);
    }

    public Doctor getDocByName(String docName){

        for (Doctor doc: doctors) {
            if(doc.getName().equalsIgnoreCase(docName)){
                return doc;

            }
        }
        return null;
    }
    public Patient getPatByName(String patName){

        for (Patient pat: patients) {
            if(pat.getName().equalsIgnoreCase(patName)){
                return pat;
            }
        }
        return null;
    }
    public void addAppointment(String time, String docName, String patName){
        Doctor doctor = getDocByName(docName);
        Patient patient = getPatByName(patName);
        if(patient == null){
            System.out.println("Patient's name has not been found");
            Main.manageAppointments();
        }else if (doctor == null){
            System.out.println("Doctor's name has not been found");
            Main.manageAppointments();
        }else {
            appointments.add(new Appointment(time, doctor, patient));
        }

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

    public void displayAppointments(){
        for (Appointment appointment: appointments) {
            System.out.println(appointment);
        }
    }
    public void renameDepartment(String newDepartment, String oldDepartment){

        for (int i = 0; i < departments.size(); i++) {
            if (departments.get(i).equalsIgnoreCase(oldDepartment)) {
                departments.set(i, newDepartment);
                break;
            }
        }
    }

    public Appointment findAppByNames(String docName, String patName) {
        Doctor doctor = getDocByName(docName);
        Patient patient = getPatByName(patName);
        if(patient == null) {
            System.out.println("Patient's name has not been found");
            Main.manageAppointments();
        } else if (doctor == null) {
            System.out.println("Doctor's name has not been found");
            Main.manageAppointments();
        } else {
            for (Appointment app: appointments) {
                if(app.getPatient() == patient && app.getDoctor() == doctor) {
                    return app;
                }
            }
        }
        return null;
    }
    public void removeAppointment(String docName, String patName ) {
        Appointment appointmentToRemove = findAppByNames(docName, patName);
        if(appointmentToRemove != null) {
            appointments.remove(appointmentToRemove);
        } else {
            System.out.println("Unexpected error.");
            Main.manageAppointments();
        }

    }

}
