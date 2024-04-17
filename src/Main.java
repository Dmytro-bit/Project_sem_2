import com.sun.source.doctree.DocCommentTree;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Patients
        Patient p1 = new Patient("John Doe", 35, true, "085-456-7890");
        Patient p2 = new Patient("Jane Smith", 28, false, "086-654-3210");
        Patient p3 = new Patient("Alice Johnson", 42, true, "086-555-5555");
        Patient p4 = new Patient("Bob Brown", 50, false, "087-222-3333");
        Patient p5 = new Patient("Emily Davis", 20, true, "085-444-4444");

        ArrayList<Patient> patients1 = new ArrayList<>();
        patients1.add(p1);
        patients1.add(p3);
        patients1.add(p4);

        ArrayList<Patient> patients2 = new ArrayList<>();
        patients2.add(p2);
        patients2.add(p5);

        //Doctors
        Doctor d1 = new Doctor("Roland Smith", 45, 15, patients1, "Cardiology");
        Doctor d2 = new Doctor("Phillip Johnson", 38, 10, patients2, "Neurology");

        ArrayList<Doctor> doctors1 = new ArrayList<>();
        doctors1.add(d1);
        doctors1.add(d2);

        //Hospitals
        ArrayList<String> departments1 = new ArrayList<>();
        departments1.add("Cardiology");
        departments1.add("Neurology");
        departments1.add("Ophthalmology");

        Hospital h1 = new Hospital("St James's Hospital", doctors1, departments1);

        drawMenu();
    }

    public static void drawMenu()
    {
        int option = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("What is your access level: ");
        System.out.println("1. Patient");
        System.out.println("2. Doctor");
        System.out.println("3. Hospital Administration");
        System.out.println("---------------------------------");
        System.out.println("4. Exit");
        option = input.nextInt();

        while(option <= 0 || option > 4)
        {
            System.out.println("Invalid Value");
            option = input.nextInt();
        }

        while(option != 4)
        {
            if(option == 1)
            {

            }
            else if(option == 2)
            {

            }
            else if(option == 3)
            {

            }
        }



    }

}