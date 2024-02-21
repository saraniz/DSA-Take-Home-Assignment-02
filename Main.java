import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String option; //option variable declare for get user input


        ParkingGarage newparkinggarage = new ParkingGarage(); //create new object for parkingGarage to call the methods inside that class
        Scanner scanner = new Scanner(System.in); //scanner object for get user inputs

    do { //use do while loop for store data that user enter

        //give some instructions to user to choose their option
        System.out.println("Enter 'a' for arrival and 'd' for departure.");
        System.out.println("Enter 'b' for Display Cars that park in Parking Garage");
        System.out.println("Enter 'c' for Find Your Car");
        System.out.println("Enter 'e' for exit program");
        System.out.println("Enter Your Option:");
        option = scanner.nextLine().toLowerCase();

        switch (option){ //use switch case for swap to each options

            case "a":
                System.out.println("Enter Your Car's License Plate Number"); //get licensePlate number for park the car
                String licensePlate = scanner.nextLine();
                newparkinggarage.arriveCar(licensePlate); //calling the arriveCar method

                break;

            case "d":
                System.out.println("Enter Your Car's License Plate Number");
                licensePlate = scanner.nextLine();
                newparkinggarage.departCar(licensePlate); //call the method to depart the car

                break;

            case "b":
                newparkinggarage.displaycars(); //Display the details about car

                break;

            case "c":
                System.out.println("Enter Your Car's License Plate Number");
                licensePlate = scanner.nextLine();
                newparkinggarage.findCarPosition(licensePlate); //use for find the position of the given car

                break;

            case "e":
                System.out.println("Successfully exit"); //exit from the do while loop
                break;

            default:
                System.out.println("Invalid Option!.Please try Again!");

                break;

        }

    } while (!option.equals("e")); //when option equals to 'e' program exit
}}