/**
 * A class that tests methods, creates objects
 * and executes the necessary code.
 *
 * @author Fahad Alshehri
 * 
 */

public class ArrayBasedDataStructuresDriver {

    /**
     * An entry point of the program
     *
     * @param args arguments that can be passes in to the method
     *             when it's executed
     *             pre-condition: Running the program
     *  post-condition: executes the flow of the code starting from main.
     */
    public static void main(String[] args) {
        //calling the separate testing methods

        stackTests();
         queueTests();
        arrayListTests();
    }

    /**
     * Testing the implemented arrayList
     * pre-condition: calling the method
     * post-condition:  tests the arrayList methods
     */
    private static void arrayListTests() {
        System.out.println("-- Welcome to ArrayList Testing -- \n");
        //todo: make more tests here
        ArrayList a = new ArrayList();

        // creating a new instance of arrayList
        ArrayList phones = new ArrayList();

        //before adding object (true)
        System.out.println("Test isEmpty when " + phones.isEmpty());
        //inserting
        phones.insert("Iphone ", 0);

        //testing indexOf Iphone -> 0
        System.out.println("The index of Iphone is "
                +phones.indexOf("Iphone "));


        // testing the current size - > 1
        System.out.println("The current size of the arrayList is "
                +phones.size());



        //after adding objects (false)
        System.out.println("Test isEmpty when " + phones.isEmpty());


        //adding more phone objects
        phones.insert("Galaxy ", 1);
        phones.insert("HTC ", 2);
        //test shifting
        phones.insert("Pixel ", 0);

        // printing toString
        System.out.println(phones.toString());

        // compare objects by equals
        ArrayList otherPhones = new ArrayList();
        otherPhones.insert("Iphone ", 0);
        otherPhones.insert("Galaxy ", 1);
        otherPhones.insert("HTC ", 2);
        otherPhones.insert("Pixel ", 0);

        System.out.println("Testing equals " + phones.equals(otherPhones));
        System.out.println();
        // testing equals with a bad phones arrayList
        ArrayList badPhones = new ArrayList();
        badPhones.insert("badPhone", 0);
        System.out.println("Comparing while not equal "
                + phones.equals(badPhones));

        // testing the remove method -> Pixel
        System.out.println(phones.remove(0));

        //testing printing after removing Pixel
        System.out.println(phones.toString());

        // removing an item in the middle to test shifting
        phones.remove(1);
        System.out.println(phones.toString());

        //test getting the 0th index
        System.out.println("Testing get " + phones.get(0));

        //negative conditions -> invalid index
        phones.insert("newPhone", -99);

        //testing an invalid Object which-> returns -1
        System.out.println("Test indexOf invalid value "
                + phones.indexOf("ElementNoThere"));

        //testing invalid remove -> negative index
        phones.remove(-1);


        System.out.println("testing the given code ");
        a.insert('B', 0);
        a.insert('a', 0);
        a.insert('t', 1);

        System.out.println(a.toString());

        // will remove items until isEmpty is true
        while (a.isEmpty() == false) {
            System.out.println(a.remove(0));
        }

    }

    /**
     * Testing the implemented Queue
     * pre-condition: calling the method
     * post-condition:  tests the Queue methods
     */
    private static void queueTests() {
        System.out.println("-- Welcome to Queue Testing -- \n");
        // Queue of people at the bank
        Queue bankQueue = new Queue();

        //Testing isEmpty when true
        System.out.println("Testing isEmpty " + bankQueue.isEmpty());

        bankQueue.enqueue("firstCustomer ");
        bankQueue.enqueue("secondCustomer ");
        bankQueue.enqueue("thirdCustomer ");
        System.out.println("Testing the Queue size " + bankQueue.size());
        System.out.println(bankQueue.toString());
        //Testing isEmpty when false
        System.out.println("Testing isEmpty" + bankQueue.isEmpty());


        //Testing the equals method with another Queue
        Queue anotherBankQueue = new Queue();
        anotherBankQueue.enqueue("firstCustomer ");
        anotherBankQueue.enqueue("secondCustomer ");
        anotherBankQueue.enqueue("thirdCustomer ");
        System.out.println("Testing equals "
                + bankQueue.equals(anotherBankQueue));

        //testing dequeue
        System.out.println(bankQueue.dequeue());
        // removed the 1st customer
        System.out.println(bankQueue.toString());


        //negative testing
        Queue testQueue = new Queue();
        //Testing equals -> false
        System.out.println("Testing equals " + bankQueue.equals(testQueue));

        System.out.println("Testing the given code");
        Queue a = new Queue();

        a.enqueue('B');
        a.enqueue('a');
        a.enqueue('t');

        System.out.println(a.toString());
        // will dequeue items until isEmpty is true
        while (a.isEmpty() == false) {
            System.out.println(a.dequeue());
        }

    }

    private static void stackTests() {
        System.out.println("-- Welcome to Stack Testing -- \n");

        Stack stackOfPlates = new Stack();

        //Testing when empty -> true
        System.out.println("Testing empty " + stackOfPlates.isEmpty());

        // attempting to print when empty
        System.out.println(stackOfPlates.toString());

        //attempting to pop an empty stack
        System.out.println(stackOfPlates.pop());

        // adding plates
        stackOfPlates.push("plateOne");
        stackOfPlates.push("plateTwo");
        System.out.println("Testing the Stack size " + stackOfPlates.size());
        // prints the stack naturally as a stack of plates
        System.out.println(stackOfPlates.toString());
        // for spacing
        System.out.println();

        //Testing when empty -> false
        System.out.println("Testing empty " + stackOfPlates.isEmpty());

        //comparing two stacks
        Stack anotherStack = new Stack();
        anotherStack.push("plateOne");
        anotherStack.push("plateTwo");
        //equals when true
        System.out.println("Testing equals "
                + stackOfPlates.equals(anotherStack));

        //reducing the number of plates to compare
        System.out.println(stackOfPlates.pop());
        //equals when false
        System.out.println("Testing equals "
                + stackOfPlates.equals(anotherStack));


        System.out.println("-- Testing the given code --- ");
        Stack a = new Stack();

        a.push('B');
        a.push('a');
        a.push('t');

        System.out.println(a.toString());

        // will pop items until isEmpty is true
        while (a.isEmpty() == false) {
            //pop (LIFO)
            System.out.println(a.pop());
        }

    }

}


