package com.company;

import java.io.*;
import java.util.Scanner;

public class Task_3_ServiceCenterExample {
    public static int totalVaccines = 150;
    public static String[] allCustomers = new String[150];
    public static String[] cusDataFromFile;
    static String[] ServiceCenter = new String[6];
    public static String fname;
    public static String patient;

    public static void main(String[] args) throws IOException {
        initialiseBooths(ServiceCenter);
        initialiseCustomers(allCustomers);
        showMenu();
    }

    private static void initialiseCustomers( String hotelRef[] ) {
        for (int x = 0; x < hotelRef.length; x++ )
            hotelRef[x] = "empty";
        System.out.println( "initialised");
    }

    private static void initialiseBooths( String hotelRef[] ) {
        for (int x = 0; x < hotelRef.length; x++ ){
            hotelRef[x] = "empty";
        }
        System.out.println( "initialised");
    }

    private static void viewAllVaccinationBooths( String hotelRef[] ) throws IOException {
        for (int x = 0; x < 6; x++ )
        {
            if(ServiceCenter[x] == "empty"){
                System.out.println("booth " + x + " is empty");
            }else{
                System.out.println("booth " + x + " occupied by " +allCustomers[x]);
            }
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Enter any key to go back to main menu.");
        if(input.next() != null){
            showMenu();
        }
    }

    private static void viewAllEmptyBooths( String hotelRef[] ) throws IOException {
        for (int x = 0; x < 6; x++ )
        {
            if(ServiceCenter[x] == "empty"){
                System.out.println("booth " + x + " is empty");
            }
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Enter any key to go back to main menu.");
        if(input.next() != null){
            showMenu();
        }
    }

    private static void addPatientToBooth( String hotelRef[] ) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter customer First Name") ;
        String firstName = input.next();

        System.out.println("Enter customer Surname" ) ;
        String surname = input.next();

        System.out.println("Enter customer Age" ) ;
        String age = input.next();

        System.out.println("Enter customer NIC or Passport number") ;
        String nic = input.next();

        System.out.println("Enter customer City" ) ;
        String city = input.next();

        System.out.println("Enter Vaccination Requested (1 - AstraZeneca, 2 - Sinopharm, 3 - Pfizer)" ) ;
        int vacType = input.nextInt();

        if(vacType == 1){

            if(ServiceCenter[0] == "empty"){
                ServiceCenter[0] = firstName;
                allCustomers[0] = firstName + " " + surname;
            }else if(ServiceCenter[1] == "empty"){
                ServiceCenter[1] = firstName;
                allCustomers[1] = firstName + " " + surname;
            }else{
                System.out.println("All booths for the requested vaccine are occupied. Please try again ");
                addPatientToBooth(ServiceCenter);
            }
        }else if(vacType == 2){

            if(ServiceCenter[2] == "empty"){
                ServiceCenter[2] = firstName;
                allCustomers[2] = firstName + " " + surname;
            }else if(ServiceCenter[3] == "empty"){
                ServiceCenter[3] = firstName;
                allCustomers[3] = firstName + " " + surname;
            }else{
                System.out.println("All booths for the requested vaccine are occupied. Please try again ");
                addPatientToBooth(ServiceCenter);
            }
        }else if (vacType == 3){

            if(ServiceCenter[4] == "empty"){
                ServiceCenter[4] = firstName;
                allCustomers[4] = firstName + " " + surname;
            }else if(ServiceCenter[5] == "empty"){
                ServiceCenter[5] = firstName;
                allCustomers[5] = firstName + " " + surname;
            }else{
                System.out.println("All booths for the requested vaccine are occupied. Please try again ");
                addPatientToBooth(ServiceCenter);
            }

        }else{
            System.out.println("Wrong Vaccination Type. Try Again. ");
            addPatientToBooth(ServiceCenter);
        }

        totalVaccines--;
        if(totalVaccines <= 20 ){
            System.out.println(" Warning : Total vaccines are less than 20." );
        }

        System.out.println("Enter any key to go back to main menu.");
        if(input.next() != null){
            showMenu();
        }
    }

    private static void removePatientFromBooth( String hotelRef[] ) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter booth number (0-5) or any other key to stop:" );
        int boothNum = input.nextInt();
        ServiceCenter[boothNum] = "empty";

        System.out.println("Enter any key to go back to main menu.");
        if(input.next() != null){
            showMenu();
        }
    }

    private static void viewPatientsSorted() throws IOException {


        for (int i = 0; i < allCustomers.length-1; i++)
        {
            for (int j = i + 1; j < allCustomers.length-1; j++)
            {
                if (allCustomers[i].compareTo(allCustomers[j]) > 0)
                {
                    String temp = allCustomers[i];
                    allCustomers[i] = allCustomers[j];
                    allCustomers[j] = temp;
                }
            }
        }

        System.out.println("Customers Sorted : ");
        for (int i = 0; i < allCustomers.length; i++) {
            if(allCustomers[i] != "empty"){
                System.out.println(allCustomers[i]);
            }
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Enter any key to go back to main menu.");
        if(input.next() != null){
            showMenu();
        }
    }

    public static void storeProgramDataToFile() throws IOException {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter("data.txt"));
        for (int i = 0; i < ServiceCenter.length; i++) {
            outputWriter.write(ServiceCenter[i]+",");
        }
        outputWriter.flush();
        outputWriter.close();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter any key to go back to main menu.");
        if(input.next() != null){
            showMenu();
        }
    }

    public static void loadProgramDataFromFile() throws IOException {
        Scanner lines = new Scanner(new File("data.txt"));

        StringBuilder sb = new StringBuilder();
        while(lines.hasNext()) {
            sb.append(lines.nextLine());
        }

        //if an array is needed.
        cusDataFromFile = sb.toString().split(",");

        System.out.println(sb.toString());
        Scanner input = new Scanner(System.in);
        System.out.println("Enter any key to go back to main menu.");
        if(input.next() != null){
            showMenu();
        }
    }

    public static void viewRemainingVaccinations() throws IOException {
        System.out.println("A total of "+ totalVaccines + " vaccines are remaining.");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter any key to go back to main menu.");
        if(input.next() != null){
            showMenu();
        }
    }

    public static void addVaccinationsToStock() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of new Vaccines :" );
        int newVac = input.nextInt();
        totalVaccines = totalVaccines + newVac;
        System.out.println(newVac + " new Vaccines have been added. " );

        System.out.println("Enter any key to go back to main menu.");
        if(input.next() != null){
            showMenu();
        }
    }

    public static void exit(){
        System.exit(0);
    }

    public static void showMenu() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------");
        System.out.println("-Console Menu List-");
        System.out.println("-------------------");
        System.out.println("Enter the code or number corresponding to the menu option below.");
        System.out.println("----------------------------------------------------------------");
        System.out.println("100 or VVB: View all Vaccination Booths\n" +
                "101 or VEB: View all Empty Booths\n" +
                "102 or APB: Add Patient to a Booth\n" +
                "103 or RPB: Remove Patient from a Booth\n" +
                "104 or VPS: View Patients Sorted in alphabetical order (Do not use library sort routine)\n" +
                "105 or SPD: Store Program Data into file\n" +
                "106 or LPD: Load Program Data from file\n" +
                "107 or VRV: View Remaining Vaccinations\n" +
                "108 or AVS: Add Vaccinations to the Stock\n" +
                "999 or EXT: Exit the Program\n" +
                "--------------------------------------------------------------------------------------------\n" +
                "Enter the Code : ");
        String menuOption =  input.next();

        if (menuOption.equals("100") || menuOption.equals("VVB")){
            viewAllVaccinationBooths(ServiceCenter);
        }else if(menuOption.equals("101") || menuOption.equals("VEB")) {
            viewAllEmptyBooths(ServiceCenter);
        }else if(menuOption.equals("102") || menuOption.equals("APB")){
            addPatientToBooth(ServiceCenter);
        }else if(menuOption.equals("103") || menuOption.equals("RPB")){
            removePatientFromBooth(ServiceCenter);
        }else if(menuOption.equals("104") || menuOption.equals("VPS")){
            viewPatientsSorted();
        }else if(menuOption.equals("105") || menuOption.equals("SPD")){
            storeProgramDataToFile();
        }else if(menuOption.equals("106") || menuOption.equals("LPD")){
            loadProgramDataFromFile();
        }else if(menuOption.equals("107") || menuOption.equals("VRV")){
            viewRemainingVaccinations();
        }else if(menuOption.equals("108") || menuOption.equals("AVS")){
            addVaccinationsToStock();
        }else if(menuOption.equals("999") || menuOption.equals("EXT")){
            exit();
        }else{
            System.out.println("Incorrect option please try again.");
            showMenu();
        }
    }
}