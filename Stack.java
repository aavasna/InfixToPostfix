package proj4;

/**
 * The Stack class implements the generic Stack ADT.
 * Elements in a Stack ADT can only be added and removed
 * from one end of the stack i.e. the top of the stack.
 * Stack is a LIFO (last in first out) data structure.
 *
 * Invariants:
 * 1. int size stores the number of elements in the stack
 * i.e. size = 0 in an empty stack
 *
 * 2. int capacity represents the capacity (max number of elements current stack can hold)
 * i.e. capacity = size when stack is full
 *
 * 3. Object[] contents is the array that stores the elements of the stack.
 * The first element in array is the element at bottom of the stack.
 * The top element of the stack is stored at the (size-1)th index of the array.
 * We don't care about the elements from size index to end of array.
 * the default capacity of this array is 20
 *
 * @author Aavasna Rupakheti
 * @version 02/23/2023
 */
public class Stack<T>
{
    public static final int DEFAULT_CAPACITY = 20;
    public static final int DEFAULT_INCREMENT_CAPACITY = 10;
    private int size;
    private int capacity;
    private Object[] items;

    /**
     * Default Constructor. Newly created Stack has no elements.
     */
    public Stack() {
        size = 0;
        capacity = DEFAULT_CAPACITY;
        items = new Object[capacity];
    }

    /**
     * Check if stack is empty or not
     * @return boolean true if empty, else false
     */
    public boolean isEmpty() {  
    	return (size==0);
    }

    /**
     * Add element T to top of stack
     * if the stack is full, increases the size of the stack
     *
     * @param toPush element to be added to stack
     */
    public void push(T toPush) {
        if (size() == getCapacity()){
            increaseCapacity(DEFAULT_INCREMENT_CAPACITY);
        }
        items[size++] = toPush;
    }

    /**
     * Pop element T from top of stack (removing from stack and return)
     *
     * @return the element to be removed
     */
    public T pop() {
        if (isEmpty()){
            return null;
        }
        else{
            return (T)items[--size];
        }
    }

    /**
     * peek at element T on top of stack, without popping it (removing it).
     * The element should still stay on top of stack.
     *
     * @return the element T on top of Stack
     */
    public T peek() {
        if (isEmpty()){
            return null;
        }
        else{
            return (T)items[size-1];
        }
    }

    /**
     * get the number of elements in this stack
     *
     * @return integer as number of elements
     */
    public int size() {
    	return size;    //erase this line
    }

    /**
     * Get capacity of the stack i.e. the number of elements it can store
     * @return integer as current capacity
     */
    public int getCapacity(){
        return capacity;
    }

    /**
     * Increment the capacity of the stack. The new stack should have the same number
     * of elements, in the same order with previous stack,
     * but with new capacity as given input.
     */
    public void increaseCapacity(int incrementCapacity){
        Object[] newItems = new Object[this.getCapacity()+ incrementCapacity];
        for (int i=0; i < this.size(); i++){
            newItems[i] = items[i];
        }
        items = newItems;
    }

    /**
     * String representation of this stack with format {>C, B, A}
     * where C is the element at the top of the stack
     * @return String representation of the stack
     */
    public String toString() {
        String toReturn = "{>";
        if(!isEmpty()){
            for (int i=size()-1;i>0;i--){
                toReturn += items[i].toString() + ", ";
            }
            toReturn += items[0].toString();
        }
        toReturn += "}";
        return toReturn;
    }
    
} 
   

