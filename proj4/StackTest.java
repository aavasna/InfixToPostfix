package proj4;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * 
 * This class tests the Stack Object
 * 
 * @author Aavasna Rupakheti
 * @version 02/22/2023
 *
 */
public class StackTest {

	@Rule
    public Timeout timeout = Timeout.millis(100);
	
    private Stack<String> stack;
    
    @Before
    public void setUp() throws Exception {
        stack = new Stack<String>();
    }

    @After
    public void tearDown() throws Exception {
        stack = null;
    }

    @Test
    public void testStackConstructor_toString () {
        assertEquals ("An empty stack. (> indicates the top of the stack)", "{>}", stack.toString());
    }
    
    @Test
    public void testStackPushOneOntoEmptyStack () {
        stack.push("A");
        assertEquals ("Pushing A onto an empty stack.", "{>A}", stack.toString().replaceAll("[ ]+", ""));
    }
    
    @Test
    public void testStackPushTwoOntoEmptyStack () {
        stack.push("A");
        stack.push("B");
        assertEquals ("Pushing first A and then B onto an empty stack.", "{>B,A}", stack.toString().replaceAll("[ ]+", ""));
    }
    
    @Test
    public void testStackPushThreeOntoEmptyStack () {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals ("Pushing first A, then B, then C onto an empty stack.", "{>C,B,A}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testIsEmptyWithEmptyStack () {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsEmptyWithNonEmptyStack () {
        stack.push("A");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testSizeEmptyStack () {
        assertEquals(0, stack.size());
    }

    @Test
    public void testSizeNonEmptyStack () {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals(3, stack.size());
    }

    @Test
    public void testSizeWithStackThatWentOverInitCapacity () {
        for (int i = 0; i<15; i++){
            stack.push("A");
        }
        assertEquals(15, stack.size());
    }

    @Test
    public void testGetCapacityNewStack () {
        assertEquals(10, stack.getCapacity());
    }

    @Test
    public void testGetCapacityNonEmptyStack () {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals(10, stack.getCapacity());
    }

    @Test
    public void testGetCapacityWithStackThatWentOverInitCapacity () {
        for (int i = 0; i<15; i++){
            stack.push("A");
        }
        assertEquals(15, stack.getCapacity());
    }

    @Test
    public void testPopEmptyStack () {
        assertEquals(null, stack.pop());
    }

    @Test
    public void testPopNonEmptyStack () {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
        assertEquals(0,stack.size());
    }

    @Test
    public void testPeekEmptyStack () {
        assertEquals(null, stack.peek());
    }

    @Test
    public void testPeekNonEmptyStack () {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals("C", stack.peek());
        assertEquals("C", stack.pop());
        assertEquals("B", stack.peek());

        assertEquals(2,stack.size());
    }
}