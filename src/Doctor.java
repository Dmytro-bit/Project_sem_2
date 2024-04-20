import java.util.ArrayList;

public class Doctor {
    //Attributes
    private String log_in;
    private String password;
    private String name;
    private int age;
    private int experience_years;
    private String department;
    private ArrayList<Patient> patients;
    private ArrayList<Appointment> appointments;

    //Constructors
    public Doctor(String log_in, String password, String name, int age, int experience_years, String department) {
        this.log_in = log_in;
        this.password = password;
        this.name = name;
        this.age = age;
        this.experience_years = experience_years;
        this.patients = new ArrayList<>();
        this.department = department;
        this.appointments = new ArrayList<>();
    }

    public Doctor(String log_in, String password, String name, int age, int experience_years, ArrayList<Patient> patients, String department) {
        this.log_in = log_in;
        this.password = password;
        this.name = name;
        this.age = age;
        this.experience_years = experience_years;
        this.patients = patients;
        this.department = department;
        this.appointments = new ArrayList<>();
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
    public String getLog_in() {
        return log_in;
    }

    public String getPassword() {
        return password;
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



    public void setLog_in(String log_in) {
        this.log_in = log_in;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Doctor:\n\t-Name: " + this.name +
                "\n\t-Age: " + this.age +
                "\n\t-Years of Practice: " + this.experience_years;
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

    public void addAppointment(String time, Patient p) {
        Appointment a = new Appointment(time, this, p);
        p.addAppointment(a);
        appointments.add(a);
    }

    public void displayAppointments() {
        int total = 0;
        if(appointments.size() > 0)
        {
            for (Appointment appointment : appointments) {
                total++;
                System.out.println(appointment);
            }
            System.out.println("Total amount of appointments: " + total);
        }
        else {
            System.out.println("No appointments scheduled");
        }
    }

    public void addPatient(Patient p) {
        if (!patients.contains(p)) {
            patients.add(p);
            System.out.println("Patient " + p.getName() + "has been put on record to Dr. " + this.getName());
        } else
            System.out.println("This patient is already registered with Dr. " + this.getName());
    }

    public void addPatient(String log_in, String password, String name, int age, boolean mc) {
        Patient p = new Patient(log_in, password, name, age, mc);
        if (!patients.contains(p)) {
            patients.add(p);
            System.out.println("Patient " + p.getName() + "has been put on record to Dr. " + this.getName());
        } else
            System.out.println("This patient is already registered with Dr. " + this.getName());
    }

    public void deletePatient(Patient p) {
        if (patients.contains(p)) {
            for (int i = 0; i < this.appointments.size(); i++) {
                if (appointments.get(i).getDoctor() == this && appointments.get(i).getPatient() == p) {
                    appointments.remove(i);
                }
            }
            patients.remove(p);
            System.out.println("Patient " + p.getName() + " has been deleted from Dr. " + this.getName() + "'s register");
        } else
            System.out.println("This patient is not in the Dr. " + this.getName() + "'s register");
    }

    public void removeAppointment(Appointment a) {
        if(appointments.size() > 0)
            this.appointments.remove(a);
        else
            System.out.println("No appointments scheduled");
    }

    public void prescribe(Patient p, MedicalHistory mh) {
        if (patients.contains(p)) {
            for (Appointment a : p.getAppointments()) {
                if (a.getAppointmentTime().equals(mh.getTime())) {
                    p.getMedicalHistories().add(mh);
                    break;
                }
            }
        }
    }

    public void prescribe(Patient p, String time, ArrayList<String> prescription, ArrayList<Double> dose, ArrayList<String> info) {
        if (patients.contains(p)) {
            for (Appointment a : p.getAppointments()) {
                if (a.getAppointmentTime().equals(time)) {
                    MedicalHistory mh = new MedicalHistory(time, prescription, dose, info);
                    p.getMedicalHistories().add(mh);
                    break;
                }
            }
        }
    }


}