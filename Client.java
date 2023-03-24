package proj4;
/**
 * The Client class contains main() method, which creates a new Converter object that
 * transforms an input txt file of infix notation to postfix.
 * It outputs the infix and the postfix for that expression
 *
 * @author Aavasna Rupakheti
 * @version 02/27/2023
 */

public class Client
{
    public static void main(String[] args)
    {
        Converter converter = new Converter("proj4_input.txt");
        converter.convert();
    }
}
