package proj4;

/**
 * The RightParen object implements Token Interface.
 * It can be processed through its handle() method, and
 * it can be printed through its toString() method.
 *
 * @author Aavasna Rupakheti
 * @version 02/26/2023
 */
public class RightParen implements Token {
    /**
     * Get printable String of RightParen Object.
     * @return String representation
     */
    public String toString() {
        return ")";
    }

    /**
     * Processing the current RightParen object
     * i.e. pop and append to the postfix string all operators
     * on the stack down to the most recently scanned left parenthesis.
     * Then discard left parenthesis on top of stack.
     *
     * @param s the Stack the token uses, if necessary, when processing itself.
     * @return String to be added to output.
     */
    public String handle(Stack<Token> s)
    {
        String toReturn = "";
        while (!((s.peek().toString()).equals("("))){     // while top of stack is not "("
            toReturn += s.pop().toString();             // pop tokens and append to postfix string
        }
        s.pop();        // discard the left parenthesis on top of the stack
        return toReturn;
    }
}
