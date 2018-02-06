/**
 * An ArrayList Abstract Data Type Representation.
 * @author Fahad Alshehri
 */
public class ArrayList {

    //The arrayList data members
    private int size;
    private Object[] array;
    //constant for the array capacity
    private static final int INITIAL_CAPACITY = 10;

    /**
     * A default constructor
     * pre-condition: creating an arrayList using the default constructor
     * post-condition: initializes the data members
     */
    public ArrayList() {
        array = new Object[INITIAL_CAPACITY];
        // The size is how many element got added to the array
        this.size = 0;
    }

    /**
     * A helper method to help in adding elements to the arrayList
     * pre-condition: calling the method from the insert method to help
     * in adding elements
     * post-condition: adds an object to the next available slot.
     *
     * @param object to be added
     */
    private void add(Object object) {
        if (object == null) {
            System.out.println("Invalid object");
            return;
        }

        if (this.size == this.array.length) {
            expandArray();
        }

        array[size++] = object;
    }

    /**
     * A helper method to expand the arrayList if needed
     * pre-condition if the INITIAL_CAPACITY is reached
     * post-condition expanding the array and coping back to current array
     */
    private void expandArray() {
        Object[] tempArray = new Object[array.length + INITIAL_CAPACITY];

        for (int i = 0; i < array.length; i++) {
            tempArray[i] = this.array[i];
        }
        this.array = tempArray;
    }

    /**
     * A private getter of the Arraylists size
     * pre-condition: calling it on an instance of ArrayList
     * post-condition: returns the size of the current ArrayLists
     *
     * @return the current size
     */
    private int getSize() {
        return size;
    }

    /**
     * pre-condition: calling it on instance of ArrayList
     * post-condition: removes the object with the specified index
     *
     * @param index the index of the object to remove
     * @return the object if found, null if not
     * Note: Followed Savitch's description 14.1
     */
    public Object remove(int index) {
        // check if negative
        if (index < 0) {
            System.out.println("Cannot have a negative index returning null");
            return null;
        }
        // check if we remove empty ArrayList
        if (size == 0) {
            System.out.println("The arraylist is empty. " +
                    "Cannot remove anything. returning null");
            return null;
        }

        // check for invalid cases
        if (index >= this.size) {
            System.out.println("Invalid index buddy returning null");
            return null;
        }

        //adding if valid
        Object returningValue = array[index];

        // looping to shift elements
        //write start at index go until the size
        // copy it one by one(Shift left).
        for (int i = index; i < this.size; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        this.size--;
        return returningValue;
    }

    /**
     * This method adds a specified Object at a specified index
     * pre-condition: calling it on an instance of ArrayList
     * post-condition: adds the object of the index & object are valid
     * handles the invariants if needed
     *
     * @param object   an object to be added
     * @param index the index to of the object to add
     */
    public void insert(Object object, int index) {
        if (object == null) {
            System.out.println("Invalid object");
            return;
        }
        if (index < 0) {
            System.out.println("invalid index");
            return;
        }

        //if the index is greater than the size,
        // the object will be added to the end of the ArrayList
        if (index >= this.size) {

            add(object);
            return;

        }
        // if size reached the array length -> expand
        if (this.size == this.array.length) {
            expandArray();
        }
        //shifting..
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = object;
        size++;
    }

    /**
     * This is intended to return a string representation of the object.
     * pre-condition called on an object when the ArrayList
     * post-condition: concatenates the elements of the ArrayList and returns it
     *
     * @return a string representation of the ArrayList
     */
    public String toString() {

        // checking for an invariant empty
        if (isEmpty()) {

            return "The arraylist is empty";
        }
        String representationOfArrayList = "";
        // loops through the elements of the arrayList
        for (int i = 0; i < size - 1; i++) {
            if (array[i] != null) {
                //concatenates the String values to be printed
                representationOfArrayList += array[i] + ",";
            }
        }
        // to avoid printing null values and comma @ the end.
        if (array[size - 1] != null) {
            representationOfArrayList += array[size - 1];
        }
        return representationOfArrayList;
    }


    /**
     * To check if the ArrayList has items
     * pre-condition calling it on an instance of ArrayList
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
     * A method to get the size of the ArrayList
     * pre-condition calling the method on an instance of ArrayList
     * post-condition returns (number of elements added)
     *
     * @return the number of elements pushed
     */
    public int size() {
        return size;
    }

    /**
     * Find the index of a specified Object
     * pre-condition: calling the method on instance of ArrayList
     * post-condition: find the index if valid return -1 if not.
     *
     * @param anotherObject to find the indexOf
     * @return index of the object if found  -1 if not found.
     */
    public int indexOf(Object anotherObject) {
        if (anotherObject == null) {
            System.out.println("Invalid object returning -1");
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            //todo .equals or ==
            if (array[i] == anotherObject) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Inherited from the Object class
     * compares the size and the elements of the arraylist
     * pre-condition calling it from the Driver to compare two objects
     * post-condition determined wether the object passed into
     * the parameter is the same as the current Object
     *
     * @param anotherObject
     * @return true || false based on the equality
     * inspired by https://stackoverflow.com/
     * questions/23166193/looping-through-two-arrays-to-check-if-equal
     */
    public boolean equals(Object anotherObject) {
        // checking if of the same type
        if (anotherObject instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) anotherObject;
            if (arrayList.size() != this.size()) {
                return false;
            }
            // looping to check the elements of the two arrayLists
            for (int i = 0; i < this.size; i++) {
                //comparing by the use of a helper method get
                if (!this.array[i].equals(arrayList.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * A method to get the object based on index
     * pre-condition: called on an object of Arraylist
     * post-condition: returns the object if valid, null if not.
     *
     * @param index an index of the object in an Arraylist
     * @return the Object with the specified index
     */
    public Object get(int index) {
        if (this.isEmpty()) {
            System.out.println("No objects inserted");
            return null;
        }

        if (index < 0 || index >= this.array.length) {
            System.out.println("Invalid index returning null");
            return null;
        } else {
            return array[index];
        }
    }
}

