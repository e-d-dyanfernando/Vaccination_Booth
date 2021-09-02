package com.company;

import java.io.*;
import java.util.Scanner;

public class Task_3_VacinationCenter {

    public static int totalVaccines = 150;
    private static String[] allCustomers = new String[150];
    private static String[] cusDataFromFile;
    private static Task_3_Booth[] ServiceCenter = new Task_3_Booth[6];
    private static String[] boothObjectsOrdered = new String[ServiceCenter.length];

    public static void main(String[] args) throws IOException {
        initialiseBooth();
        initialise();
        showMenu();
    }

    private static void initialiseBooth( ) {
        for (int x = 0; x < allCustomers.length; x++ ) {
            allCustomers[x] = "empty";
        }
        System.out.println( "initialised");
    }

    private static void initialise() {
        for (int x = 0; x < ServiceCenter.length; x++ ){
            ServiceCenter[x] = new Task_3_Booth("empty","empty","empty","empty","empty",0);
        }
        System.out.println( "initialised");
    }

    private static void viewAllVaccinationBooths() throws IOException {
        for (int x = 0; x < 6; x++ )
        {
            if(ServiceCenter[x].getFname() == "empty"){
                System.out.println("booth " + x + " is empty");
            }else{
                System.out.println("booth " + x + " occupied by " +ServiceCenter[x].getFname()+" "+ServiceCenter[x].getsName());
            }
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Enter any key to go back to main menu.");
        if(input.next() != null){
            showMenu();
        }
    }

    private static void viewAllEmptyBooths() throws IOException {
        for (int x = 0; x < 6; x++ )
        {
            if(ServiceCenter[x].getFname() == "empty"){
                System.out.println("booth " + x + " is empty");
            }
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Enter any key to go back to main menu.");
        if(input.next() != null){
            showMenu();
        }
    }

    private static void addPatientToBooth() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter customer First Name") ;
        String firstName = input.next();

        System.out.println("Enter customer Surname" ) ;
        String surname = input.next();

        System.out.println("Enter customer age" ) ;
        String age = input.next();

        System.out.println("Enter customer city" ) ;
        String city = input.next();

        System.out.println("Enter customer ID" ) ;
        String id = input.next();

        System.out.println("Enter Vaccination Requested (1 - AstraZeneca, 2 - Sinopharm, 3 - Pfizer)" ) ;
        int vacType = input.nextInt();

        if(vacType == 1){
            if(ServiceCenter[0].getFname() == "empty"){

                ServiceCenter[0].setFname(firstName);
                ServiceCenter[0].setsName(surname);
                ServiceCenter[0].setAge(age);
                ServiceCenter[0].setCity(city);
                ServiceCenter[0].setNic(id);

            }else if(ServiceCenter[1].getFname() == "empty"){
                ServiceCenter[1].setFname(firstName);
                ServiceCenter[1].setsName(surname);
                ServiceCenter[1].setAge(age);
                ServiceCenter[1].setCity(city);
                ServiceCenter[1].setNic(id);

            }else{
                System.out.println("All booths for the requested vaccine are occupied. Please try again ");
                addPatientToBooth();
            }

        }else if(vacType == 2){
            if(ServiceCenter[2].getFname() == "empty"){

                ServiceCenter[2].setFname(firstName);
                ServiceCenter[2].setsName(surname);
                ServiceCenter[2].setAge(age);
                ServiceCenter[2].setCity(city);
                ServiceCenter[2].setNic(id);

            }else if(ServiceCenter[3].getFname() == "empty"){

                ServiceCenter[3].setFname(firstName);
                ServiceCenter[3].setsName(surname);
                ServiceCenter[3].setAge(age);
                ServiceCenter[3].setCity(city);
                ServiceCenter[3].setNic(id);

            }else{
                System.out.println("All booths for the requested vaccine are occupied. Please try again ");
                addPatientToBooth();
            }
        }else if (vacType == 3){
            if(ServiceCenter[4].getsName() == "empty"){

                ServiceCenter[4].setFname(firstName);
                ServiceCenter[4].setsName(surname);
                ServiceCenter[4].setAge(age);
                ServiceCenter[4].setCity(city);
                ServiceCenter[4].setNic(id);

            }else if(ServiceCenter[5].getFname() == "empty"){

                ServiceCenter[5].setFname(firstName);
                ServiceCenter[5].setsName(surname);
                ServiceCenter[5].setAge(age);
                ServiceCenter[5].setCity(city);
                ServiceCenter[5].setNic(id);

            }else{
                System.out.println("All booths for the requested vaccine are occupied. Please try again ");
                addPatientToBooth();
            }
        }else{
            System.out.println("Wrong Vaccination Type. Try Again. ");
            addPatientToBooth();
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

    private static void removePatientFromBooth() throws IOException {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter booth number (0-5) or any other key to stop:" );
        int boothNum = input.nextInt();

        ServiceCenter[boothNum].setFname("empty");

        System.out.println("Enter any key to go back to main menu.");
        if(input.next() != null){
            showMenu();
        }
    }

    private static void viewPatientsSorted() throws IOException
    {
        for (int i = 0; i < ServiceCenter.length; i++){
            boothObjectsOrdered[i] = ServiceCenter[i].getFname();
        }

        for (int i = 0; i < boothObjectsOrdered.length; i++)
        {
            for (int j = i + 1; j < boothObjectsOrdered.length; j++)
            {
                if (boothObjectsOrdered[i].compareTo(boothObjectsOrdered[j]) > 0)
                {
                    String temp = boothObjectsOrdered[i];
                    boothObjectsOrdered[i] = boothObjectsOrdered[j];
                    boothObjectsOrdered[j] = temp;
                }
            }
        }

        System.out.println("Customers Sorted : ");

        for (int i = 0; i < boothObjectsOrdered.length; i++) {
            if(!(boothObjectsOrdered[i].equals("empty"))){
                System.out.println(boothObjectsOrdered[i]);
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
            outputWriter.write(ServiceCenter[i].getFname()+",");
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
            viewAllVaccinationBooths();
        }else if(menuOption.equals("101") || menuOption.equals("VEB")) {
            viewAllEmptyBooths();
        }else if(menuOption.equals("102") || menuOption.equals("APB")){
            addPatientToBooth();
        }else if(menuOption.equals("103") || menuOption.equals("RPB")){
            removePatientFromBooth();
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