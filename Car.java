public class Car {
    String licensePlate; //License Plate number of the car
    int movesCount; //The number of times car has been moved within in the garage

    //declare car class's constructor
    Car(String licensePlate){
        this.licensePlate =  licensePlate; //assign provide license plate number to the car
    }

    //increment the moves count for car
    public void incrementMoves(){
        this.movesCount++;
    }

    // Override the toString method to provide a custom string representation of the car.
    @Override
    public  String toString(){
       return "car number : " +licensePlate+"\n";
    }
}
