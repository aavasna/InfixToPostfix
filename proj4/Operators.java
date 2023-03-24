package proj4;

/**
 * Describes the methods for an Object to be defined as an Operator.
 * The Object must have a value for its precedence (getPrecedence)
 * and must be printable (toString)
 */
public interface Operators {
    /**
     * Returns the precedence of the operator as an integer
     * The larger the integer, the higher the precedence of an operator during an operation
     * For example: "*" is prioritized to execute before "+".
     * So, "*" has a higher precedence than "+"
     * "+" has precedence 1
     * "*" has precedence 2
     *
     * @return int as precedence of this operator
     */
    public int getPrecedence();

    /**
     * Returns the operator as a printable String
     *
     * @return String version of an operator e.g. "+" for Plus operator
     */
    public String toString();
}
