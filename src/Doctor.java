import java.util.ArrayList;

public class Doctor {
    //Attributes
    private String name;
    private int age;
    private int experience_years;
    private ArrayList<Patient> patients = new ArrayList<>();
//    private ArrayList<Patient> appointments = new ArrayList<>();  //Requires a separate class

    //Constructors
    public Doctor(String name, int age, int experience_years, ArrayList<Patient> patients) {
        this.name = name;
        this.age = age;
        this.experience_years = experience_years;
        this.patients = patients;
    }

    public Doctor() {
        this.name = "";
        this.age = 0;
        this.experience_years = 0;
        this.patients = new ArrayList<>();
    }

    //Getters/Setters

    public String getName() {
        return name;
    };

    public int getAge() {
        return age;
    };

    public int getExperience_years() {
        return experience_years;
    };

    public ArrayList<Patient> getPatients() { return patients; };

    public void setName(String name) {
        this.name = name;
    };

    public void setAge(int age) {
        this.age = age;
    };

    public void setExperience_years(int experience_years) {
        this.experience_years = experience_years;
    };

    public void setPatients(ArrayList<Patient> patients) { this.patients = patients; };

    @Override
    public String toString() {
        return "Doctor:\nname: " + this.name +
                "\nage: " + this.age +
                "\nYears of Practice: " + this.experience_years;
    }

    public void displayPatients()
    {
        int total = 0;
        for (Patient i : patients)
        {
            System.out.println(i);
            total++;
        }
        System.out.println("Total number of patients: "+total);
    }

}
