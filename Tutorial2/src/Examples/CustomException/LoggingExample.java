package Examples.CustomException;
import java.util.Set;
import java.util.logging.*;

public class LoggingExample {

    private static final Logger LOGGER = Logger.getLogger(LoggingExample.class.getName());

    public static void main(String[] args) {

        try {
            int a = 5 / 0;
        } catch (ArithmeticException e) {
            LOGGER.severe(e.getMessage());
        }
        catch (NullPointerException e){
            LOGGER.warning(e.getMessage());

        } catch (ArrayIndexOutOfBoundsException e) {
            LOGGER.info(e.getMessage());

        } catch (ArrayStoreException e) {
            LOGGER.fine("Everything is fine");

        }

    }
}
