/**
 * A Stack Abstract Data Type Representation (LIFO)
 *
 * @author Fahad Alshehri
 * 
 */
public class Stack {

    //Stack data members
    private Object[] myStackArray = new Object[1];
    private int size = 0;
    private int topOfTheStack = -1;


    /**
     * Pushing (adding) items to the Stack
     * pre-condition calling the method with an Object type
     * post-condition handles the invariants and push the item
     * to the Stack
     *
     * @param theObjectBeingAddedToTheStack
     */
    public void push(Object theObjectBeingAddedToTheStack) {

        //Checking invariant null
        if (theObjectBeingAddedToTheStack == null) {
            System.out.println("Invalid Object");
            return;
        }
        //if the array size is reached
        if (topOfTheStack == myStackArray.length - 1) {

            // creating a new array to expand the array size
            Object[] tempStackArray = new Object[myStackArray.length + 1];
            for (int i = 0; i < size; i++) {
                tempStackArray[i] = myStackArray[i];
            }
            // simply copies back from the temp array
            this.myStackArray = tempStackArray;
        }
        // incrementing when an object is pushed to the stack
        topOfTheStack++;
        size++;
        myStackArray[topOfTheStack] = theObjectBeingAddedToTheStack;
        System.out.println("Pushed "
                + theObjectBeingAddedToTheStack.toString());

    }

    /**
     * Pop: (removing) items to the Stack
     * pre-condition calling the method an instance of Stack
     * post-condition handles the invariants and removes the last element
     * on the Stack
     *
     * @return the last object on the stack
     */
    public Object pop() {
        if (size == 0) {
            System.out.println("the stack is empty");

            return null;
        } else {
            Object temporaryTop = myStackArray[topOfTheStack];
            myStackArray[topOfTheStack] = null;
            topOfTheStack--;
            size--;
            System.out.print("Pop: ");

            return temporaryTop;

        }
    }

    /**
     * A method to get the size of the stack
     * pre-condition calling the method on an instance of stack
     * post-condition returns the size of the stack (number of elements added)
     *
     * @return the number of elements pushed
     */
    public int size() {
        return this.size;
    }

    /**
     * This is intended to return a string representation of the object.
     * pre-condition called on an object when the stack has items
     * post-condition: concatenates the elements of the stack and returns it
     *
     * @return a string representation of the stack
     */
    public String toString() {
        if (this.size == 0) {
            return "Sorry the Stack is empty ";
        }

        String myStack = "";
        System.out.println();
        // loops through the array to add to the String
        //represented & printed like a stack of plates
        for (int i = this.size - 1; i >= 0; i--) {
            myStack += "\n " + myStackArray[i];
        }
        return myStack;
    }


    /**
     * To check if the stack has items
     * pre-condition calling it on an instance of Stack
     * post-condition returns true || false based on the items added
     *
     * @return a boolean value true or false based on the size
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Inherited from the Object class
     * compares the size and the elements of the stack
     * pre-condition calling it from the Driver to compare two objects
     * post-condition determined wether the object passed into
     * the parameter is the same as the current Object
     *
     * @param anotherObject
     * @return true || false based on the equality
     * Inspired by: https://stackoverflow.com/
     * questions/23166193/looping-through-two-arrays-to-check-if-equal
     */
    public boolean equals(Object anotherObject) {
        if (anotherObject instanceof Stack) {
            Stack stack = (Stack) anotherObject;
            if (stack.size() != this.size()) {
                return false;
            }

            for (int i = 0; i < this.size; i++) {

                // get is a helper method
                if (!this.myStackArray[i].equals(stack.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * A helper method to loop through the elements to compare
     * pre-condition: calling it when comparing elements
     * post-condition: finds the object with the specified index
     *
     * @param index of the object to get
     * @return an object with the specified index
     */
    private Object get(int index) {
        if (this.isEmpty()) {
            System.out.println("No objects inserted");
            return null;
        }
        if (index < 0 || index >= this.myStackArray.length) {
            System.out.println("Invalid index returning null");
            return null;
        } else {
            return myStackArray[index];
        }
    }

}
