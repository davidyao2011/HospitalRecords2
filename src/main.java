/*
 * The program implements to keep track of the hospital patients.
 * It has a record of the current hospital patients,
 * It allows to search of patients by patient ID,
 * It allows to delete a patient's record.
 *
 */


import java.util.*;
import java.io.*;


/**
 * @author David Yao
 */

public class main {

    public static void main(String[] args) {

        ArrayList<Patient> records = new ArrayList<>();


        System.out.println("**Patient records have been recorded successfully**");

        String path = "/Users/davidyao/Desktop/HospitalRecords/ListOfPatients.txt";
//Use path to the ListOfPatients.txt here
        LineNumberReader lr = null;

//allows to read information from the file line by line
        String[] oneRecord = new String[4];

//an array to store info about one patient

        try {
            //using try-catch for exception handling to catch
//possible errors with i/o operations
            FileReader inputStream = new FileReader(path);
//FileReader reads the file’s contents
            lr = new LineNumberReader(inputStream);
            String str;
            while ((str = lr.readLine()) != null) {
//while the next line exists
                oneRecord = str.split(",");
//dividing one file line by commas and assigning to array
                Patient pat = new Patient(oneRecord[0], oneRecord[1],
                        oneRecord[2], oneRecord[3]);


                records.add(pat);

                //adding patient to the ArrayList
            }
        } catch (IOException ioe) {

            System.out.println("IOExcception occured");
        }

        //obtaining user input
        System.out.println("Press S for search, Press E for exit");

        Scanner sc = new Scanner(System.in);

        while (true) {

            String input = sc.nextLine();

            if (input.equals("E")) {

                System.out.println("Exit the program. Bye...");
                System.exit(0);
            } else if (input.equals("S")) {

                System.out.println("Enter Patient ID to search");
            }

            for (int i = 0; i < records.size(); i++)
                if (records.get(i).patientID.equals(input)) {
                    System.out.println(records.get(i));
                    System.out.println("Would you like to remove the patient's record(s)?");
                    System.out.println("Y or N?");

                    String input2 = sc.next();
                    if (input2.equals("Y")) {
                        records.remove(i);
                        System.out.println("Record(s) removed Successfully!");
                        System.out.println("Press S for search, Press E for exit.");

                    } else if (input2.equals("N")) {
                        System.out.println("No records removed!");
                    } else {
                        System.out.println("No record search found on matching");
                    }

                }

            //display hospital patient's records
            System.out.println("The hospital records size is: " + records.size());


        }


    }
}
