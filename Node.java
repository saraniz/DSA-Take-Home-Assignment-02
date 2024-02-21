public class Node { //Node class represent a node in a linked list
    Car car; //Car object associated with this node
    Node next; //Reference to the next node in the linked list

    //Initialize the Node class constructor
    Node(Car car){
        this.car = car; //assign the provided car object to the current node
        this.next = null; //initialize the next reference as null.end of the linked list
    }
}
