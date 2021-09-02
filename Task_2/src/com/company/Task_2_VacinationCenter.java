package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task_2_VacinationCenter {

    private static int totalVaccines = 150;
    private static Task_2_Booth[] allCustomers = new Task_2_Booth[150];
    private static String[] cusDataFromFile;
    private static Task_2_Booth[] ServiceCenter = new Task_2_Booth[7];
    private static String customerName;
    private static Task_2_Booth[] boothObjects = new Task_2_Booth[6];
    private static String[] boothObjectsOrdered = new String[boothObjects.length];

    public static void main(String[] args) throws IOException {

        initialiseBooths();
        initialiseCustomers();
        showMenu();
    }

    private static void initialiseCustomers() {

        for (int x = 0; x < allCustomers.length; x++ ) {
            Task_2_Booth booth = new Task_2_Booth("empty");
            allCustomers[x] = booth;
        }
        System.out.println( "initialised");
    }

    private static void initialiseBooths() {
        for (int x = 0; x < boothObjects.length; x++ ){
            Task_2_Booth booth = new Task_2_Booth("empty");
            boothObjects[x] = booth;
        }
        System.out.println( "initialised");
    }

    private static void viewAllVaccinationBooths() throws IOException {
        for (int x = 0; x < 6; x++ )
        {
            if(boothObjects[x].getCustomerName() == "empty"){
                System.out.println("booth " + x + " is empty");
            }else{
                System.out.println("booth " + x + " occupied by " +boothObjects[x].getCustomerName());
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
            if(boothObjects[x].getCustomerName() == "empty"){
                System.out.println("booth " + x + " is empty");
            }
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Enter any key to go back to main menu.");
        if(input.next() != null){
            showMenu();
        }
    }

    private static void addPatientToBooth() throws IOException
    {
        Scanner input = new Scanner(System.in);
        int boothNum;

        System.out.println("Enter booth number (0-5) or any other key to stop:");
        boothNum = input.nextInt();

        if ((boothNum <= 5) && (boothNum >= 0)) {
            System.out.println("\nYou will added to the booth number " + boothNum + "\n");
        } else {
            return;
        }

        System.out.println("Enter customer name for booth " + boothNum + " :");
        customerName = input.next();

        boothObjects[boothNum].setCustomerName(customerName);
        totalVaccines--;

        for (int i = 0; i < allCustomers.length; i++) {
            if (allCustomers[i].getCustomerName() == "empty") {
                allCustomers[i].setCustomerName(customerName);
                break;
            }
        }

        if (totalVaccines <= 20) {
            System.out.println(" Warning : Total vaccines are less than 20.");
        }

        System.out.println("Enter any key to go back to main menu.");
        if (input.next() != null) {
            showMenu();
        }
    }

    private static void removePatientFromBooth() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter booth number (0-5) or any other key to stop:" );
        int boothNum = input.nextInt();
        boothObjects[boothNum].setCustomerName("empty");

        System.out.println("Enter any key to go back to main menu.");
        if(input.next() != null){
            showMenu();
        }
    }

    private static void viewPatientsSorted() throws IOException
    {
        for (int i = 0; i < boothObjects.length; i++){
            boothObjectsOrdered[i] = boothObjects[i].getCustomerName();
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
        for (int i = 0; i < boothObjects.length; i++) {
            outputWriter.write(boothObjects[i].getCustomerName()+",");
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
        cusDataFromFile = sb.toString().split("\n");

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
            showMenu();
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