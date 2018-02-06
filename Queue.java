/**
 * An Queue Abstract Data Type Representation. (FIFO)
 * @author Fahad Alshehri
 * 
 */
public class Queue {

    // The Queue data members
    private Object[] queue;
    private int frontOfTheQ;
    private int size;

    /**
     * A default constructor
     * pre-condition: creating a Queue
     * post-condition: initializes the data members
     */
    public Queue() {
        queue = new Object[1];
        this.frontOfTheQ = 0;
        this.size = 0;
    }

    /**
     *
     * pre-condition calling it on an instance of Queue
     * post-condition adds elements to the Queue if valid
     * @param anotherObject to enqueue -> add
     */

    public void enqueue(Object anotherObject) {
        // checking for invalid cases
        if (anotherObject == null) {
            System.out.println("Invalid Object");
            return;
        }

        //  expandQ will be called if the size is reached
        if (size == queue.length) {
            Object[] expandedQ = new Object[this.queue.length * 2];
            expandQueue(expandedQ);
        }

        // adding if valid
        queue[size++] = anotherObject;
    }


    /**
     * A helper method to expand the Queue if needed
     * pre-condition if the the Queue size is reached
     * post-condition expanding the Queue and coping back to current array
     */
    private void expandQueue(Object[] tempQueue) {

        for (int i = 0; i < size; i++) {
            tempQueue[i] = this.queue[i];
        }
        this.queue = tempQueue;
    }

    /**
     * To remove items from the Queue on a FIFO nature
     * pre-condition calling it on an instance of Queue
     * post-condition removing object if found
     * @return the object, return null if not found.
     */
    public Object dequeue() {
        // checking for an invariant
        if (size == 0) {
            System.out.println("The Queue is empty returning null");
            return null;
        }

        Object objectToReturn = this.queue[frontOfTheQ];
        this.queue[frontOfTheQ] = null;
        this.frontOfTheQ++;
        this.size--;
        return objectToReturn;
    }

    /**
     * A method to get the size of the Queue
     * pre-condition calling the method on an instance of Queue
     * post-condition returns (number of elements added)
     * @return the number of elements enqueued
     */
    public int size() {
        return this.size;
    }


    @Override
    /**
     * This is intended to return a string representation of the object.
     * pre-condition called on an object an instance of Queue.
     * post-condition: concatenates the elements of the Queue and returns it
     * @return a string representation of the Queue
     */
    public String toString() {

        if (isEmpty()) {

            return "The Queue is empty";
        }
        String print = "";
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] != null) {
                print += queue[i] + ",";
            }
        }

        return print;
    }


    /**
     *To check if the Queue has items
     * pre-condition calling it on an instance of Queue
     * post-condition returns true || false based on the items added
     * @return a boolean value true or false based on the size
     */
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    /**
     * Inherited from the Object class
     * pre-condition calling it from the Driver to compare two objects
     * post-condition determined wether the object passed into
     * the parameter is the same as the current Object
     * @param anotherObject to compare equals with
     * @return true || false based on the equality
     * Inspired by: https://stackoverflow.com/
     * questions/23166193/looping-through-two-arrays-to-check-if-equal
     */
    public boolean equals(Object theOtherQueue) {

        if (theOtherQueue instanceof Queue) {
            Queue queue = (Queue) theOtherQueue;
            if (queue.size() != this.size()) {
                return false;
            }
            int count = 0;
            //looping the the Queue
            for (int i = 0; i < this.size; i++) {

                if (this.queue[i] == ((Queue) theOtherQueue).queue[i]) {
                    count++;
                }
            }
            if(count == this.size){
                return true;
            }
            else{
                return false;
            }
        }
        return true;
    }


    /**
     * A helper method to compare the object in the Queue based on the index
     * pre-condition: calling it on instance of Queue
     * post-condition: returns the object if the index is valid
     * @param index of an object in the Queue
     * @return an object in the Queue
     */
    private Object get(int index) {
        if (this.isEmpty()) {
            System.out.println("No objects inserted");
            return null;
        }

        if (index < 0 || index >= this.queue.length) {
            System.out.println("Invalid index returning null");
            return null;
        } else {
            return queue[index];
        }
    }

}

