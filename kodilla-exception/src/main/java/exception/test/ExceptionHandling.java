package exception.test;


import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionHandling {
    private static final Logger LOGGER = Logger.getLogger(ExceptionHandling.class.toString());

    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            secondChallenge.probablyIWillThrowException(3, 3);


        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception", e);
        } finally {
            System.out.println("Program finished work");
        }
    }
}
