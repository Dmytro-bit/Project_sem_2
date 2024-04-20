import com.sun.net.httpserver.Authenticator;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Patient> patients1 = new ArrayList<>();
    public static ArrayList<Patient> patients2 = new ArrayList<>();
    public static ArrayList<Doctor> doctors1 = new ArrayList<>();
    public static ArrayList<String> departments1 = new ArrayList<>();
    public static Patient currentPatient;
    public static Doctor currentDoctor;

    public static Hospital h1 = new Hospital("St James's Hospital","08:00-20:00", doctors1, departments1);

    public static void main(String[] args) {
        //Patients
        Patient p1 = new Patient("john_123", "password1", "John Doe", 35, true, "085-456-7890", true);
        Patient p2 = new Patient("jane_123", "password2", "Jane Smith", 28, false, "086-654-3210", true);
        Patient p3 = new Patient("alice_123", "password3", "Alice Johnson", 42, true, "086-555-5555", true);
        Patient p4 = new Patient("bob_123", "password4", "Bob Brown", 50, false, "087-222-3333", true);
        Patient p5 = new Patient("Emily_123", "password5", "Emily Davis", 20, true, "085-444-4444", true);


        patients1.add(p1);
        patients1.add(p3);
        patients1.add(p4);


        patients2.add(p2);
        patients2.add(p5);
        h1.addPatientsToDB(patients1);
        h1.addPatientsToDB(patients2);
        //Doctors
        Doctor d1 = new Doctor("Roland_123", "password1", "Roland Smith", 45, 15, patients1, "Cardiology");
        Doctor d2 = new Doctor("Phillip_123", "password2", "Phillip Johnson", 38, 10, patients2, "Neurology");


        doctors1.add(d1);
        doctors1.add(d2);

        //Departments

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
                if(authorization(patientsLogins, patientsPasswords, "patient")){
                    drawPatientOptions(currentPatient);
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
                if(authorization(doctorsLogins, doctorsPasswords, "doctor")){
                    drawDoctorOptions(currentDoctor);
                } else {drawMenu();}
                break;
            case 3:
                ArrayList<String> adminLogins = h1.getAdminLogIns();
                ArrayList<String> adminPasswords = h1.getAdminPasswords();
                if(authorization(adminLogins, adminPasswords, "administrator")){
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

    public static void drawPatientOptions(Patient p) {
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


        switch(option)
        {
            case 1:
                System.out.println("\n\n\n"+currentPatient+"\n\n\n");
                drawPatientOptions(currentPatient);
                break;
            case 2:
                String phone;
                System.out.println("Please note, the phone number should begin with '+', be no shorter then 7 and no longer then 15");
                System.out.println("\nPlease, enter a new phone number");
                input.nextLine();
                phone = input.nextLine();
                currentPatient.changePhoneNumber(phone);
                while(!currentPatient.changePhoneNumber(phone).equals("Success"))
                {
                    System.out.println("\nInvalid Phone Number.\nPlease, ensure you have followed the rules noted above and try again: ");
                    System.out.println("\nPlease, enter a new phone number");
                    phone = input.nextLine();
                    currentPatient.changePhoneNumber(phone);
                }
                System.out.println("\n"+currentPatient.changePhoneNumber(phone)+"\n");
                drawPatientOptions(currentPatient);
                break;
            case 3:
                currentPatient.displayAppointment();
                System.out.println();
                drawPatientOptions(currentPatient);
                break;
            case 4:
                if(currentPatient.getIsRegistered())
                {

                    input.nextLine();
                    int chooseDoctor;
                    Doctor d;
                    String date;
                    String time;
                    String datetime;
                    System.out.println("Please, use the following date and time format: Date: YYYY-MM-DD Time: HH:MM");
                    System.out.println("Ensure, you scheduling appointment within hospitals working hours: "+h1.getWorkingHours());
                    System.out.println("\nEnter the date of your appointment: ");
                    date = input.nextLine();
                    System.out.println("\nEnter the time of your appointment: ");
                    time = input.nextLine();

                    datetime = date+" "+time;

                    while(!datetimeValidation(datetime))
                    {
                        System.out.println("\nInvalid Date or Time.\nPlease, try again and make sure you have used the correct date and time format");
                        System.out.println("\nEnter the date of your appointment: ");
                        date = input.nextLine();
                        System.out.println("\nEnter the time of your appointment: ");
                        time = input.nextLine();

                        datetime = date+" "+time;
                    }

                    System.out.println("\nPlease, choose your doctor from the list: ");
                    h1.displayDoctors();
                    chooseDoctor = input.nextInt();

                    while(chooseDoctor < 1 || chooseDoctor > h1.getDoctors().size())
                    {
                        System.out.println("\nInvalid Option");
                        System.out.println("Please, choose your doctor from the list: ");
                        h1.displayDoctors();
                        chooseDoctor = input.nextInt();
                    }

                    d = h1.getDoctors().get(chooseDoctor-1);
                    Appointment a = new Appointment(datetime, d, currentPatient);
                    currentPatient.addAppointment(d, a);
                    drawPatientOptions(currentPatient);
                }
                else
                {
                    System.out.println("You are not registered with any doctor");
                }
                break;
            case 5:
                int chooseAppointment;
                System.out.println("Please, choose the appointment you would like to cancel from the list below: ");
                currentPatient.displayAppointment();
                chooseAppointment = input.nextInt();

                while(chooseAppointment < 1 || chooseAppointment > currentPatient.getAppointments().size())
                {
                    System.out.println("\nInvalid Option");
                    System.out.println("Please, choose the appointment you would like to cancel from the list below: ");
                    chooseAppointment = input.nextInt();
                }

                Appointment appointment = currentPatient.getAppointments().get(chooseAppointment-1);
                currentPatient.cancelAppointment(appointment);
                System.out.println();
                drawPatientOptions(currentPatient);
                break;
            case 6:
                drawMenu();
                break;
            case 7:
                break;
            default:
                System.out.println("Invalid Value");
                drawPatientOptions(currentPatient);

        }
    }

    public static void drawDoctorOptions(Doctor d) {
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
        System.out.println("9. <<< Back");
        System.out.println("---------------------------------");
        System.out.println("10. Exit");
        option = input.nextInt();

        switch(option)
        {
            case 1:
                System.out.println("\n\n\n"+currentDoctor+"\n\n\n");
                drawDoctorOptions(currentDoctor);
                break;
            case 2:
                System.out.println();
                currentDoctor.displayPatients();
                System.out.println();
                drawDoctorOptions(currentDoctor);
                break;
            case 3:
                System.out.println();
                currentDoctor.displayAppointments();
                System.out.println();
                drawDoctorOptions(currentDoctor);
                break;
            case 4:
                break;
            case 5:
                if(currentDoctor.getAppointments().size() > 0)
                {

                    int chooseAppointment;
                    System.out.println("Please, choose an appointment you want to cancel");
                    currentDoctor.displayAppointments();
                    chooseAppointment = input.nextInt();

                    while(chooseAppointment < 1 || chooseAppointment > currentDoctor.getAppointments().size())
                    {
                        System.out.println("\nInvalid Option");
                        System.out.println("Please, choose an appointment you want to cancel");
                        chooseAppointment = input.nextInt();
                    }
                    System.out.println();
                    Appointment a = currentPatient.getAppointments().get(chooseAppointment-1);
                    System.out.println();
                    currentDoctor.removeAppointment(a);
                    System.out.println();
                    drawDoctorOptions(currentDoctor);
                }
                else
                {
                    System.out.println("\nNo appointments scheduled\n");
                    drawDoctorOptions(currentDoctor);
                }
                break;
            case 6:
                input.nextLine();
                String name;
                boolean added = false;
                System.out.println("Please, enter the name of the patient you want to add to your register: ");
                name = input.nextLine();

                for(Patient patient : h1.getPatients())
                {
                    if(patient.getName().equals(name) && !patient.getIsRegistered())
                    {
                        currentDoctor.addPatient(patient);
                        patient.setIsRegistered(true);
                        added = true;
                        System.out.println("Patient "+patient.getName()+" has been successfully added to your patient list\n");
                        break;
                    }
                }

                if(!added)
                    System.out.println("This patient is not registered in this clinic or is on record with another doctor\n");

                drawDoctorOptions(currentDoctor);
                break;
            case 7:
                int patientOption;
                System.out.println("Please, select patient to be removed from your record");
                System.out.println(currentDoctor.getPatients());
                patientOption = input.nextInt();

                while(patientOption < 1 || patientOption > currentDoctor.getPatients().size())
                {
                    System.out.println("\nInvalid Option");
                    System.out.println("\nPlease, select patient to be removed from your record");
                    System.out.println(currentDoctor.getPatients());
                    patientOption = input.nextInt();
                }

                Patient p1 = currentDoctor.getPatients().get(patientOption-1);
                currentDoctor.deletePatient(p1);

                System.out.println();
                drawDoctorOptions(currentDoctor);
                break;
            case 8:
                break;
            case 9:
                drawMenu();
                break;
            case 10:
                break;
            default:
                System.out.println("Invalid Value");
                drawDoctorOptions(currentDoctor);

        }
    }

    public static void drawAdminOptions() {
        int option = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Choose Option: ");
        System.out.println("1. Manage doctors ");
        System.out.println("2. Manage patients ");
        System.out.println("3. Manage departments ");
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
        System.out.println("Manage doctors");
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
                editDoctorsDetails();

                break;

            case 3:
                System.out.println("Please enter an information about a doctor you want to remove: ");

                System.out.print("Full name: ");
                scanner.nextLine();
                String doctorToFire = scanner.nextLine();
                h1.fireDoctor(doctorToFire);
                manageDoctors();
                break;

            case 4:
                System.out.println("Do you want to sort doctors by 'experience', 'age' or 'name'? Enter 'none' to show unsorted list. ");
                scanner.nextLine();
                String typeOfSorting = scanner.nextLine();
                h1.sortDoctors(typeOfSorting);
                manageDoctors();
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
        int option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Manage patients");
        System.out.println("Choose Option: ");
        System.out.println("1. Add patient");
        System.out.println("2. Edit patient details ");
        System.out.println("3. Remove patient ");
        System.out.println("4. View all patients");
        System.out.println("5. Log out ");
        System.out.println("---------------------------------");
        System.out.println("6. Exit ");
        option = scanner.nextInt();

        switch (option){
            case 1:
                addPatientByAdmin();
                System.out.println("1. Add next patient. \n2.Return to Manage Patients menu.");
                option = scanner.nextInt();
                while (option < 1 || option > 2){

                    System.out.println("Invalid value.");
                    System.out.println("1. Add next patient. \n2.Return to Manage Patients menu.");
                    option = scanner.nextInt();
                }
                while (option == 1){
                    addPatientByAdmin();
                    System.out.println("1. Add next patient. \n2.Return to Manage Patients menu.");
                    option = scanner.nextInt();
                }
                if (option == 2) {
                    managePatients();
                }
                break;

            case 2:
                editPatientsDetails();
                break;

            case 3:
                System.out.println("Please enter an information about a patient you want to remove: ");

                System.out.print("Full name: ");
                scanner.nextLine();
                String patientToDelete = scanner.nextLine();
                h1.deletePatientFromDB(patientToDelete);
                managePatients();

                break;

            case 4:
                System.out.println(h1.getPatients());
                managePatients();
                break;

            case 5:
                drawMenu();
                break;

            case 6:
                break;


        }
    }

    public static void manageDepartments() {
        int option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Manage departments");
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
                editDepartments();
                break;

            case 3:
                System.out.println("Enter a name of a former Department: ");
                scanner.nextLine();
                String nameOfFormerDepartment = scanner.nextLine();
                h1.removeDepartment(nameOfFormerDepartment);
                manageDepartments();
                break;

            case 4:
                System.out.println(h1.getDepartments());
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
        System.out.println("Manage appointments");
        System.out.println("Choose Option: ");
        System.out.println("1. Schedule appointment");
        System.out.println("2. Reschedule appointment");
        System.out.println("3. Cancel appointment");
        System.out.println("4. View all appointments");
        System.out.println("5. Log out");
        System.out.println("---------------------------------");
        System.out.println("6. Exit");


    }

    public static boolean authorization(ArrayList<String> listOfLogins, ArrayList<String> listOfPasswords, String object) {
        System.out.println("Login and password are case-sensible and can contain both letters and digits");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login: ");
        String login = scanner.nextLine();

        System.out.println("Password: ");
        String password = scanner.nextLine();
        return validation(login, password, listOfLogins, listOfPasswords, object);
    }
    public static boolean validation(String login, String password, ArrayList<String> listOfLogins, ArrayList<String> listOfPasswords, String object) {
        int loginIndex = listOfLogins.indexOf(login);

        if(listOfLogins.contains(login) && listOfPasswords.contains(password) &&  listOfPasswords.get(loginIndex).equals(password)) {
            switch (object)
            {
                case "patient":
                    for(Patient p: h1.getPatients())
                    {
                        if(p.getLog_in().equals(login) && p.getPassword().equals(password))
                        {
                            currentPatient = p;
                            System.out.println("Welcome, "+p.getName());
                        }
                    }
                    break;
                case "doctor":
                    for(Doctor d: h1.getDoctors())
                    {
                        if(d.getLog_in().equals(login) && d.getPassword().equals(password))
                        {
                            currentDoctor = d;
                            System.out.println("Welcome, "+d.getName());
                        }
                    }
                    break;
                case "administrator":
                    break;
            }
            return  true;
        } else {
            System.out.println("Invalid login or password");
            return false;
        }


    }

    public static boolean datetimeValidation(String datetime)
    {
        if(datetime.length() == 16)
        {
            //date validation
            String date = datetime.substring(0,10);
            if(Integer.parseInt(date.substring(0,4)) >= 2024 && Integer.parseInt(date.substring(5,7))>0 && Integer.parseInt(date.substring(5,7))<=12
                    && Integer.parseInt(date.substring(8,10))>0 && Integer.parseInt(date.substring(8,10))<=31 && datetime.charAt(4) == '-' && datetime.charAt(7) == '-')
            {
                //time validation
                int openTime = Integer.parseInt(h1.getWorkingHours().substring(0,2));
                int closeTime = Integer.parseInt(h1.getWorkingHours().substring(6,8));
                String time = datetime.substring(11);
                return Integer.parseInt(time.substring(0, 2)) >= openTime && Integer.parseInt(time.substring(0, 2)) <= closeTime
                        && Integer.parseInt(time.substring(3)) >= 0 && Integer.parseInt(time.substring(3)) < 60 &&
                        time.charAt(2) == ':';
            }
        }
        return false;
    }


    public static  void addPatientByAdmin(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input patient data");
        System.out.println("Login: ");
        String login = scanner.nextLine();

        System.out.println("Password: ");
        String password = scanner.next();
        scanner.nextLine();

        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Age: ");
        int age = scanner.nextInt();

        System.out.println("Medical card(yes/no): ");
        String medCard = scanner.next();
        scanner.nextLine();
        boolean medicalCard = false;
        if(medCard.equalsIgnoreCase("yes")){
            medicalCard = true;
        } else if (medCard.equalsIgnoreCase("no")) {
            medicalCard = false;
        } else {
            System.out.println("Invalid answer. Enter 'yes' or 'no':");
            medCard = scanner.next();
        }

        System.out.println("Phone: ");
        String phone = scanner.nextLine();

        h1.addNewPatient(new Patient(login, password, name, age, medicalCard, phone));

    }

    public static void editDoctorsDetails(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Doctor> doctors = h1.getDoctors();
        Doctor doctorToEdit = new Doctor();
        System.out.println("Enter a login of doctor whose details you need to change");

        String input = scanner.next();
        scanner.nextLine();
        boolean contains = false;
        for (Doctor doctor: doctors) {
            if (input.equals(doctor.getLog_in())) {
                contains = true;
                doctorToEdit = doctor;
                break;
            }
        }
        if(contains){

            System.out.println(doctorToEdit);
            System.out.println("You can change next details: ");
            System.out.println("1. Name ");
            System.out.println("2. Age ");
            System.out.println("3. Years of practice ");
            System.out.println("4. Back to manage doctors menu");

            System.out.println("Enter your  choice below: ");
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    System.out.println("Enter new name");
                    scanner.nextLine();
                    String newName = scanner.nextLine();
                    doctorToEdit.setName(newName);
                    editDoctorsDetails();
                    break;
                case 2:
                    System.out.println("Enter new age");
                    int newAge = scanner.nextInt();
                    doctorToEdit.setAge(newAge);
                    editDoctorsDetails();
                    break;
                case 3:
                    System.out.println("Enter new experience years");
                    int newExp = scanner.nextInt();
                    doctorToEdit.setExperience_years(newExp);
                    editDoctorsDetails();
                    break;
                case 4:
                    manageDoctors();
                    break;
                default :
                    System.out.println("Unexpected value " + option);
                    editDoctorsDetails();
                break;
            }


        }else{
            System.out.println("Invalid login. Try again: ");
            editDoctorsDetails();
        }
    }

    public static void editPatientsDetails(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Patient> patients = h1.getPatients();
        Patient patientToEdit = new Patient();
        System.out.println("Enter a login of patient whose details you need to change");

        String input = scanner.next();
        scanner.nextLine();
        boolean contains = false;
        for (Patient patient: patients) {
            if (input.equals(patient.getLog_in())) {
                contains = true;
                patientToEdit = patient;
                break;
            }
        }
        if(contains){

            System.out.println(patientToEdit);
            System.out.println("You can change next details: ");
            System.out.println("1. Name ");
            System.out.println("2. Age ");
            System.out.println("3. Has medical card ");
            System.out.println("4. Phone ");
            System.out.println("5. Back to manage doctors menu");

            System.out.println("Enter your  choice below: ");
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    System.out.println("Enter new name");
                    scanner.nextLine();
                    String newName = scanner.nextLine();
                    patientToEdit.setName(newName);
                    editPatientsDetails();
                    break;
                case 2:
                    System.out.println("Enter new age");
                    int newAge = scanner.nextInt();
                    patientToEdit.setAge(newAge);
                    editPatientsDetails();
                    break;
                case 3:
                    System.out.println("Does patient have a medical card? Enter true/false");
                    boolean medcard = scanner.nextBoolean();
                    patientToEdit.setHas_medical_card(medcard);
                    editPatientsDetails();
                    break;

                case 4:
                    System.out.println("Enter a new phone number ");
                    scanner.nextLine();
                    String newNumber = scanner.nextLine();
                    patientToEdit.setPhone(newNumber);
                    editPatientsDetails();
                    break;

                case 5:
                    managePatients();
                    break;
                default :
                    System.out.println("Unexpected value " + option);
                    editPatientsDetails();
                    break;
            }


        }else{
            System.out.println("Invalid login. Try again: ");
            editPatientsDetails();
        }
    }
    public static void editDepartments(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> departments = h1.getDepartments();
        System.out.println(departments);
        System.out.println("Enter name of department to  edit or input 'back' to open previous menu");
        String oldDepartment = scanner.nextLine();
        if(departments.contains(oldDepartment)){
            String newDepartment = scanner.nextLine();
            h1.renameDepartment(newDepartment, oldDepartment);
            editDepartments();
        } else if (oldDepartment.equalsIgnoreCase("back")) {
            manageDepartments();
        } else {
            while (!departments.contains(oldDepartment)){
                System.out.println("Invalid department name");
                editDepartments();
            }
        }

    }
}