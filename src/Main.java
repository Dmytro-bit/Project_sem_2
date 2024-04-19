import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Patient> patients1 = new ArrayList<>();
    public static ArrayList<Patient> patients2 = new ArrayList<>();
    public static ArrayList<Doctor> doctors1 = new ArrayList<>();
    public static ArrayList<String> departments1 = new ArrayList<>();

    static  ArrayList<String> patientPasswords, patientLogins, doctorsPasswords, doctorsLogins = new ArrayList<>();

    public static Hospital h1 = new Hospital("St James's Hospital", doctors1, departments1);

    public static void main(String[] args) {
        //Patients
        Patient p1 = new Patient("john_123", "password123", "John Doe", 35, true, "085-456-7890");
        Patient p2 = new Patient("jane_123", "password123", "Jane Smith", 28, false, "086-654-3210");
        Patient p3 = new Patient("alice_123", "password123", "Alice Johnson", 42, true, "086-555-5555");
        Patient p4 = new Patient("bob_123", "password123", "Bob Brown", 50, false, "087-222-3333");
        Patient p5 = new Patient("Emily_123", "password123", "Emily Davis", 20, true, "085-444-4444");


        patients1.add(p1);
        patients1.add(p3);
        patients1.add(p4);


        patients2.add(p2);
        patients2.add(p5);
        h1.addPatientsToDB(patients1);
        h1.addPatientsToDB(patients2);
        //Doctors
        Doctor d1 = new Doctor("Roland_123", "password123", "Roland Smith", 45, 15, patients1, "Cardiology");
        Doctor d2 = new Doctor("Roland_123", "password123", "Phillip Johnson", 38, 10, patients2, "Neurology");


        doctors1.add(d1);
        doctors1.add(d2);

        //Hospitals

        departments1.add("Cardiology");
        departments1.add("Neurology");
        departments1.add("Ophthalmology");

        drawMenu();
    }

    public static void drawMenu() {
        int option = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("What is your access level: ");
        System.out.println("1. Patient");
        System.out.println("2. Doctor");
        System.out.println("3. Hospital Administration");
        System.out.println("---------------------------------");
        System.out.println("4. Exit");
        option = input.nextInt();

        switch (option)
        {
            case 1:
                ArrayList<String> patientsLogins = new ArrayList<>();
                ArrayList<String> patientsPasswords = new ArrayList<>();

                for (Patient patient: h1.getPatients()){
                    patientsLogins.add(patient.getLog_in());
                }
                for (Patient patient: h1.getPatients()){
                    patientsPasswords.add(patient.getPassword());
                }
                if(authorization(patientsLogins, patientsPasswords)){
                    drawPatientOptions();
                } else {drawMenu();}
                break;
            case 2:
                ArrayList<String> doctorsLogins = new ArrayList<>();
                ArrayList<String> doctorsPasswords = new ArrayList<>();
                for (Doctor doctor: h1.getDoctors()){
                    doctorsLogins.add(doctor.getLog_in());
                }
                for (Doctor doctor: h1.getDoctors()){
                    doctorsPasswords.add(doctor.getPassword());
                }
                if(authorization(doctorsLogins, doctorsPasswords)){
                    drawDoctorOptions();
                } else {drawMenu();}
                break;
            case 3:
                ArrayList<String> adminLogins = h1.getAdminLogIns();
                ArrayList<String> adminPasswords = h1.getAdminPasswords();
                if(authorization(adminLogins, adminPasswords)){
                    drawAdminOptions();
                } else {drawMenu();}
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid Value");
                drawMenu();

        }

    }

    public static void drawPatientOptions() {
        int option = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Choose Option: ");
        System.out.println("1. Display Patient");
        System.out.println("2. Change Phone Number");
        System.out.println("3. Display Appointments");
        System.out.println("4. Add Appointments");
        System.out.println("5. Cancel Appointments");
        System.out.println("6. <<< Back");
        System.out.println("---------------------------------");
        System.out.println("7. Exit");
        option = input.nextInt();

//        while (option <= 0 || option > 7) {
//            System.out.println("Invalid Value");
//            option = input.nextInt();
//        }
//
//        while (option != 7) {
//            if (option == 1) {
//
//            } else if (option == 2) {
//
//            } else if (option == 3) {
//
//            } else if (option == 4) {
//
//            } else if (option == 5) {
//
//            } else if (option == 6) {
//                drawMenu();
//                break;
//            }
//        }

        switch(option)
        {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                drawMenu();
                break;
            case 7:
                break;
            default:
                System.out.println("Invalid Value");
                drawPatientOptions();

        }
    }

    public static void drawDoctorOptions() {
        int option = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Choose Option: ");
        System.out.println("1. Display Doctor");
        System.out.println("2. Display Patients");
        System.out.println("3. Display Appointments");
        System.out.println("4. Add Appointments");
        System.out.println("5. Cancel Appointment");
        System.out.println("6. Add Patient");
        System.out.println("7. Remove Patient");
        System.out.println("8. Prescribe");
        System.out.println("---------------------------------");
        System.out.println("9. Exit");
        option = input.nextInt();
    }

    public static void drawAdminOptions() {
        int option = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Choose Option: ");
        System.out.println("1. Manage doctors ");
        System.out.println("2. Manage patients ");
        System.out.println("3. Manage hospitals ");
        System.out.println("4. Appointments Management ");
        System.out.println("5. Log out ");
        System.out.println("---------------------------------");
        System.out.println("6. Exit ");

        option = input.nextInt();

        switch (option) {
            case 1:
                manageDoctors();
                break;

            case 2:
                managePatients();
                break;

            case 3:
                manageDepartments();
                break;

            case 4:
                manageAppointments();
                break;

            case 5:
                drawMenu();
                break;

            case 6:
                break;

            default:
                System.out.println("Invalid Value");
                drawAdminOptions();
        }
    }

    public static void manageDoctors() {
        int option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Option: ");
        System.out.println("1. Add doctor");
        System.out.println("2. Edit doctor's details ");
        System.out.println("3. Remove doctor ");
        System.out.println("4. View all doctors ");
        System.out.println("5. Log out ");
        System.out.println("---------------------------------");
        System.out.println("6. Exit ");
        option = scanner.nextInt();
        switch (option) {
            case 1:

                System.out.println("Please enter an information about a new doctor: ");


                System.out.print("Full name: ");

                scanner.nextLine();

                String name = scanner.nextLine();

                System.out.println("Log In");
                String log_in = scanner.nextLine();

                System.out.println("Password");
                String password = scanner.nextLine();


                System.out.print("Age: ");
                int age = scanner.nextInt();

                System.out.print("Years of experience: ");
                int exp_years = scanner.nextInt();

                scanner.nextLine();

                System.out.print("Name of Department ");
                String department = scanner.nextLine();

                while (!departments1.contains(department)) {
                    System.out.println("Invalid department. Input a correct department name or check a list of existent departments");
                    department = scanner.nextLine();
                }
                ArrayList<Patient> newDoctorsPatients = new ArrayList<>();
                h1.hireDoctor(log_in, password, name, age, exp_years, department, newDoctorsPatients);
                manageDoctors();
                break;

            case 2:

                break;

            case 3:
                System.out.println("Please enter an information about a new doctor: ");

                System.out.print("Full name: ");
                scanner.nextLine();
                String doctorToFire = scanner.nextLine();
                h1.fireDoctor(doctorToFire);
                manageDoctors();
                break;

            case 4:
                System.out.println("Do you want to sort by Experience, Age or Name? ");
                scanner.nextLine();
                String typeOfSorting = scanner.nextLine();
                h1.sortDoctors(typeOfSorting);
                break;

            case 5:
                drawMenu();
                break;

            case 6:

                break;

            default:
                System.out.println("Invalid Value");
                manageDoctors();

        }

    }

    public static void managePatients() {

    }

    public static void manageDepartments() {
        int option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Option: ");
        System.out.println("1. Add department");
        System.out.println("2. Edit department details ");
        System.out.println("3. Remove department ");
        System.out.println("4. View all departments");
        System.out.println("5. Log out ");
        System.out.println("---------------------------------");
        System.out.println("6. Exit ");
        option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("Enter a name of new Department: ");
                scanner.nextLine();
                String nameOfNewDepartment = scanner.nextLine();
                h1.addDepartment(nameOfNewDepartment);
                manageDepartments();
                break;

            case 2:
                ;
                break;

            case 3:
                System.out.println("Enter a name of a former Department: ");
                scanner.nextLine();
                String nameOfFormerDepartment = scanner.nextLine();
                h1.removeDepartment(nameOfFormerDepartment);
                manageDepartments();
                break;

            case 4:
                manageAppointments();
                break;

            case 5:
                drawMenu();
                break;

            case 6:
                break;

            default:
                System.out.println("Invalid Value");
                drawAdminOptions();
        }
    }

    public static void manageAppointments() {

    }

    public static boolean authorization(ArrayList<String> listOfLogins, ArrayList<String> listOfPasswords) {
        System.out.println("Login and password are case-sensible and can contain both letters and digits");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login: ");
        String login = scanner.nextLine();

        System.out.println("Password: ");
        String password = scanner.nextLine();
        return validation(login, password, listOfLogins, listOfPasswords);
    }
    public static boolean validation(String login, String password, ArrayList<String> listOfLogins, ArrayList<String> listOfPasswords) {
        int loginIndex = listOfLogins.indexOf(login);

        if(listOfLogins.contains(login) && listOfPasswords.contains(password) &&  listOfPasswords.get(loginIndex).equals(password)) {
            return  true;
        } else {
            System.out.println("Invalid login or password");
            return false;
        }


    }

}