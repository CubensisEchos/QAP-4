import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do
        {
            System.out.println("==========Menu==========");
            System.out.println("1. Save drug to file");
            System.out.println("2. Read drugs from file");
            System.out.println("3. Save patient to database");
            System.out.println("4. Read patients from database");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

            try
            {
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice)
            {
                case 1:
                    Drug d = inputDrug(scanner);
                    DrugDataManager.saveDrugToFile(d);
                    System.out.println("Drug saved to file: " + d);
                    break;
                case 2:
                    ArrayList<Drug> drugs = DrugDataManager.readDrugsFromFile();
                    for (Drug drug : drugs)
                    {
                        System.out.println(drug);
                    }
                    break;
                case 3:
                    Patient p = inputPatient(scanner);
                    PatientDataManager.savePatientToDataBase(p);
                    System.out.println("Patient saved to database: " + p);
                    break;
                case 4:
                    ArrayList<Patient> patients = PatientDataManager.readPatientsFromDataBase();
                    for (Patient patient : patients)
                    {
                        System.out.println(patient);
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        while (choice != 5);

        scanner.close();
    }

    //helper method - drug
    private static Drug inputDrug(Scanner scanner)
    {
        System.out.println("Enter Drug ID: ");
        int drugId = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Drug Name: ");
        String drugName = scanner.nextLine();

        System.out.println("Enter Drug Cost: ");
        double drugCost = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter Dosage: ");
        String dosage = scanner.nextLine();

        return new Drug(drugId, drugName, drugCost, dosage);
    }

    //helper method - patient
    private static Patient inputPatient(Scanner scanner)
    {
        System.out.println("Enter Patient ID: ");
        int patientId = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter Patient DOB (YYYY-MM-DD): ");
        String patientDOB = scanner.nextLine();

        return new Patient(patientId, firstName, lastName, patientDOB);
    }
}