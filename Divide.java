package proj4;

/**
 * Divide object implements Token and Operators interfaces.
 * A Divide object, hence, can be processed using its handle() method,
 * is printable using its toString() method
 * and its precedence can be obtained using its getPrecedence() method.
 *
 * @author Aavasna Rupakheti
 * @version 02/25/2023
 */
public class Divide implements Token, Operators{
    /**
     * Get printable String of Divide Object.
     * @return String as representation
     */
    public String toString() {
        return "/";
    }

    /**
     * The handle method processes the object.
     * pop and append to the postfix string every operator on the
     * stack until one of the following conditions occurs:
     * 1. the stack is empty
     * 2. the top of the stack is a left parenthesis (which stays on the stack)
     * 3. the operator on top of the stack has a lower precedence than the current operator
     * Then push the current operator onto the stack.
     *
     * @param s the Stack the token uses, if necessary, when processing itself.
     * @return String to be added to output.
     */
    public String handle(Stack<Token> s)
    {
        String toReturn = "";
        Token topOfStack = s.peek();

        while (!s.isEmpty()     // while stack is not empty
                && !topOfStack.toString().equals("(")   // and top of stack is not left parenthesis
                && !(((Operators)topOfStack).getPrecedence()    // and precedence of top of stack is not
                < ((Operators)this).getPrecedence())){          // less than current operator's precedence.
            toReturn += s.pop().toString();     // pop and append token to postfix string
            topOfStack = s.peek();  // update topOpStack to new token
        }
        s.push(this);       // push this token to stack after popping and
        return toReturn;           // appending other tokens to postfix string
    }

    /**
     * Get the precedence of Divide object
     * @return integer as precedence
     */
    public int getPrecedence(){
        return 2;
    }
}
