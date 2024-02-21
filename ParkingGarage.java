public class ParkingGarage {
    final static int Max_Size = 10; //Maximum capacity of the parking garage
    Queue waitinglist; //queue for cars waiting to enter the garage
    Queue parkinglist; //queue for cars currently parked in the garage

    //Initialize the constructor for parking garage class
    public ParkingGarage() {
         waitinglist = new Queue();
         parkinglist = new Queue();
    }

    //arrival of a new car to the garage
    public void arriveCar(String licensePlate){
        Car newcar = new Car(licensePlate);
        //check if the parking garage is not full
        if(!parkinglist.isFull()){
            System.out.println(newcar.licensePlate + "Car arrives and parks it in Parking Garage immediately!.");
            parkinglist.enqueue(newcar);
        } else {
            System.out.println(newcar.licensePlate + "Car arrives and waits.Parking Garage is Full!.");
        }
    }

    //method to depart the car from parking garage
    public void departCar(String licensePlate){
        Car departcar = new Car(licensePlate);
        //check the parking garage is not empty
        if (parkinglist.isEmpty()){
            System.out.println("Error!." + licensePlate + "Car is not found in Parking Garage.");
            return;
        }
        //check if the departing car is at the front of the parking queue
        if (departcar.equals(parkinglist.peek())){
            Car car = parkinglist.dequeue();
            System.out.println(departcar.licensePlate + "Car departs.It moves:" + departcar.movesCount + "times." );
            shiftCarsSouth(); //shift waiting cars to the parking garage.
        } else {
            //if the departing car is not at the front, move other cars to find the matching car.
            int movesCount = moveCarsForDeparture(departcar);
            System.out.println(departcar.licensePlate + "Car departs.It moves:" + departcar.movesCount + "times.");
            shiftCarsSouth();
        }
    }

    //to find the position of the car from parking garage
    public int findCarPosition(String licensePlate) {
        // Check if the input license plate is null or empty
        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            System.out.println("Invalid license plate input.");
            return -1; // Return -1 to indicate an invalid input
        }

        // Get the size of the queue
        int size = parkinglist.size();

        // Iterate through the collection using a traditional for loop
        for (int i = 0; i < size; i++) {
            Car car = parkinglist.selectItem(i);

            // Use case-insensitive comparison for license plates
            if (car.licensePlate.equalsIgnoreCase(licensePlate)) {
                System.out.println("Car found successfully at position: " + i);
                return i; // Return the index of the found car
            }
        }

        // If car is not found, return -1
        System.out.println("Car not found.");
        return -1;
    }

    //method to moves the car when car departs
    private int moveCarsForDeparture(Car departcar) {
        int movesCount = 0;
        Queue tempQueue = new Queue();
        //iterate through the parking queue
        while (!parkinglist.isEmpty()){
            Car car = parkinglist.dequeue();
            //check if the current car matches to the departing car
            if (car.equals(departcar)){
                departcar.incrementMoves();
                movesCount++;
            } else {
                tempQueue.enqueue(car);
                car.incrementMoves();
                movesCount++;
            }
        }
        //Move cars back to the parking garage from the temporary queue
        while (!tempQueue.isEmpty()){
            parkinglist.enqueue(tempQueue.dequeue());
        }
        return movesCount;
    }

    //shift cars from the waiting queue to the parking list
    private void shiftCarsSouth() {
        while (!waitinglist.isEmpty() && parkinglist.size() < 10){
            Car car = waitinglist.dequeue();
            System.out.println(car.licensePlate + "Car moves from waiting to parking");
            parkinglist.enqueue(car);
        }
    }

    //display the cars that currently parked in the garage
    public void displaycars(){
        parkinglist.display();
    }
}
