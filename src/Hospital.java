import javax.print.Doc;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Hospital {
    //Attributes
    private String name;
    private ArrayList<Doctor> doctors;

    //Constructor
    public Hospital(String name, ArrayList<Doctor> doctors)
    {
        this.name = name;
        this.doctors = doctors;
    }

    public Hospital()
    {
        this.name = "";
        this.doctors = new ArrayList<>();
    }

    //Getters
    public String getName() { return this.name; };
    public ArrayList<Doctor> getDoctors() { return this.doctors; };

    //Setters
    public void setName(String name) { this.name = name; };
    public void setDoctors(ArrayList<Doctor> doctors) { this.doctors = doctors; };

    @Override
    public String toString() {
        return "Hospital:\nName: "+this.name+"Doctors: "+this.doctors;
    }

    //Methods
    public void hireDoctor(Doctor d)
    {
        doctors.add(d);
        System.out.println("Dr. "+d.getName()+" was hired");
    }

    public void hireDoctor(String name, int age, int exp_years, ArrayList<Patient> p)
    {
        Doctor d = new Doctor(name, age, exp_years, p);
        doctors.add(d);
        System.out.println("Dr. "+d.getName()+" was hired");
    }

    public void fireDoctor(Doctor d)
    {
        if(doctors.contains(d))
        {
            doctors.remove(d);
            System.out.println("Dr. "+d.getName()+" was fired");
        }
    }
}
