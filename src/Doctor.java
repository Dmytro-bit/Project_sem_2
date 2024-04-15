import java.util.ArrayList;

public class Doctor {
    //Attributes
    private String name;
    private int age;
    private int experience_years;
    private String department;
    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<Patient> appointments = new ArrayList<>();
    private ArrayList<String> appointment_time = new ArrayList<>();
    private ArrayList<String> appointment_date = new ArrayList<>();

    //Constructors
    public Doctor(String name, int age, int experience_years, String department, ArrayList<Patient> patients, ArrayList<Patient> appointments, ArrayList<String> appointment_time, ArrayList<String> appointment_date) {
        this.name = name;
        this.age = age;
        this.experience_years = experience_years;
        this.patients = patients;
        this.appointments = appointments;
        this.appointment_time = appointment_time;
        this.appointment_date = appointment_date;
        this.department = department;
    }

    public Doctor(String name, int age, int experience_years, String department, ArrayList<Patient> patients) {
        this.name = name;
        this.age = age;
        this.experience_years = experience_years;
        this.department = department;
        this.patients = patients;
        this.appointments = new ArrayList<>();
        this.appointment_time = new ArrayList<>();
        this.appointment_date = new ArrayList<>();
    }

    public Doctor() {
        this.name = "";
        this.age = 0;
        this.experience_years = 0;
        this.department = "";
        this.patients = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.appointment_time = new ArrayList<>();
        this.appointment_date = new ArrayList<>();
    }

    //Getters/Setters

    public String getName() {
        return name;
    }

    ;

    public int getAge() {
        return age;
    }

    ;

    public int getExperience_years() {
        return experience_years;
    }

    ;

    public String getDepartment() {
        return department;
    }

    ;

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    ;

    public ArrayList<Patient> getAppointments() {
        return appointments;
    }

    ;

    public ArrayList<String> getAppointment_time() {
        return appointment_time;
    }

    ;

    public ArrayList<String> getAppointment_date() {
        return appointment_date;
    }

    ;

    public void setName(String name) {
        this.name = name;
    }

    ;

    public void setAge(int age) {
        this.age = age;
    }

    ;

    public void setExperience_years(int experience_years) {
        this.experience_years = experience_years;
    }

    ;

    public void setDepartment(String department) {
        this.department = department;
    }

    ;

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    ;

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

    public void displayAppointments() {
        int total = 0;
        System.out.println("\bTime\t\bName\t\bAge\t\bHas Medical Card");
        for (int i = 0; i <= appointments.size(); i++) {
            total++;
            System.out.println(appointment_time.get(i) + "\t" + patients.get(i).getName() +
                    "\t" + patients.get(i).getAge() + "\t" + patients.get(i).getHas_medical_card() + "\t");
        }
        System.out.println("Total amount of appointments: " + total);
    }

    public void addAppointment(Patient p, String time) {
        this.appointments.add(p);
        this.appointment_time.add(time);
    }

    public void cancelAppointment(Patient p) {
        if (appointments.contains(p)) {
            appointments.remove(p);
            appointment_time.remove(appointments.indexOf(p));
            appointment_date.remove(appointments.indexOf(p));
        } else {
            System.out.println("There is no appointment scheduled for this person");
        }
        System.out.println("The appointment was successfully canceled");
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

}
