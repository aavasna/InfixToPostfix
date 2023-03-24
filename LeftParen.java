package proj4;

/**
 * The LeftParen object implements Token Interface.
 * It can be processed through its handle() method, and
 * it can be printed through its toString() method.
 *
 * @author Aavasna Rupakheti
 * @version 02/26/2023
 */
public class LeftParen implements Token{

    /**
     * Get printable String of LeftParen Object.
     * @return String as representation
     */
    public String toString() {
        return "(";
    }

    /**
     * Processing the current LeftParen object, i.e. push it onto the stack
     * @param s the Stack the token uses, if necessary, when processing itself.
     * @return String to be added to output.
     */
    public String handle(Stack<Token> s)
    {
        s.push(this);
        return "";
    }
}