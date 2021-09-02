package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task_1_ServiceCenterExample {

    public static int totalVaccines = 150;
    public static String[] allCustomers = new String[150];
    public static String[] cusDataFromFile;
    static String[] ServiceCenter = new String[6];
    public static void main(String[] args) throws IOException {
        initialise(ServiceCenter);
        initialise(allCustomers);
        showMenu();
    }

    private static void initialise(String[] hotelRef) {
        for (int x = 0; x < hotelRef.length; x++ ) hotelRef[x] = "empty";
        System.out.println( "initialized");
    }

    private static void viewAllVaccinationBooths(String[] ServiceCenter) throws IOException {
        for (int x = 0; x < 6; x++ )
        {
            if(ServiceCenter[x] == "empty"){
                System.out.println("booth " + x + " is empty");
            }else{
                System.out.println("booth " + x + " occupied by " +ServiceCenter[x]);
            }
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Enter any key to go back to main menu.");
        if(input.next() != null){
            showMenu();
        }
    }

    private static void viewAllEmptyBooths(String[] ServiceCenter) throws IOException {
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

    private static void addPatientToBooth(String[] ServiceCenter) throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter booth number (0-5) or any other key to stop:" );
        int boothNum = input.nextInt();

        if ((boothNum <= 5) && (boothNum >= 0)) {
            System.out.println("\nYou will added to the booth number " + boothNum + "\n");
        } else {
            return;
        }

        System.out.println("Enter customer name for booth " + boothNum + " :" ) ;
        String customerName = input.next();
        ServiceCenter[boothNum] = customerName ;

        for (int i = 0; i < allCustomers.length; i++) {
            if(allCustomers[i]=="empty"){
                allCustomers[i] = customerName;
                break;
            }
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

    private static void removePatientFromBooth(String[] ServiceCenter) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter booth number (0-5) or any other key to stop:");
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
            showMenu();
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