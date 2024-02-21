public class Queue { //Implement a queue class using Linked List

    Node front; //initialize to the front(head) of the queue
    Node rear; //reference to the rear(tail) f the queue
    int size; //initialize the current size of the queue
    static final int MAX_SIZE = 10; //Maximum capacity of the queue

    //Implement Queue class Constructor
    public Queue(){
        this.front = null;
        this.rear = null;
    }
    public boolean isEmpty(){ //Check if the queue is empty or not
        return front == null;
    }

    public boolean isFull(){ //check if the queue is full or not.In here it never becomes full.
        return false;
    }

    public int size() { //return the current size of the queue
        int count = 0;
        Node current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    //enqueue the car object in to the queue
    public void enqueue(Car car){
        Node newNode  = new Node(car);
        if (isEmpty()) {
            //if the queue is empty set both front and rear to the new node.
            front = newNode;
            rear = newNode;
        } else {
            //or add the new node to the rear and update the rear reference
            rear.next = newNode;
            rear = newNode;
        }
    }

    //dequeue the car from the queue
    public Car dequeue(){
        if (isEmpty()){
            //if the queue is empty, print the error message
            System.out.println("Queue is Empty.Cannot dequeue");
            return null;
        }
        //if the car is in the front,remove the front node and update front reference.
        Car removedCar = front.car;
        front = front.next;
        //if the queue becomes empty, update the rear reference to null.
        if(front == null){
            rear = null;
        }
        return removedCar;
    }

    // Peek and return the Car object at the front of the queue without removing it.
    public Car peek(){
        if (isEmpty()){
            //if the queue is empty,print the message and return null
            System.out.println("Queue is Empty.Cannot Peek.");
            return null;
        }
        //return the car at the front without deqeuing
        return front.car;
    }

    //select and return the car object at the specified index in the queue
    public Car selectItem(int index) {
        if (isEmpty()) {
            //if the queue is empty print the error message
            System.out.println("Queue is empty. Cannot select item.");
            return null; // Return a sentinel value or throw an exception in a real-world scenario
        }
        //Traverse the queue to the specified index and return the car
        Node current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.car;
    }

    //Display the details of the queue
    public void display() {
        if (isEmpty()) {
            //if the queue is empty,print the message
            System.out.println("Queue is empty.");
            return;
        }
        //Traverse the queue and print each car's details
        Node current = front;
        while (current != null) {
            System.out.print(current.car + " ");
            current = current.next;
        }
        System.out.println();
    }



}

