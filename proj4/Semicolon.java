package proj4;
/**
 * The Semicolon class implements Token Interface.
 * The Semicolon object can be processed through its handle() method, and
 * it can be printed through its toString() method.
 *
 * @author Aavasna Rupakheti
 * @version version 02/26/2022
 */
public class Semicolon implements Token{


    /**
     * Get printable String of Semicolon Object.
     * @return String representation
     */
    public String toString() {
        return ";";
    }

    /**
     * Processing the current Semicolon object, i.e.
     * Pop all remaining operators in stack
     * and appended to the postfix string.
     *
     * @param s the Stack the token uses, if necessary, when processing itself.
     * @return String to be added to output.
     */
    public String handle(Stack<Token> s)
    {
        String toReturn = "";
        while (!s.isEmpty()){                   // pop all remaining operators and append
            toReturn += s.pop().toString();     // to the postfix string
        }
        return toReturn;
    }
}
