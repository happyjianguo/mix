package test.testlog4j;

import org.apache.log4j.Logger;

/**
 * Created by joshua on 17/4/18.
 */
public class Log4jExample {

    static Logger logger = Logger.getLogger(Log4jExample.class.getName());

    public static void main(String[] args) {
        logger.debug("This is a debug message");
        logger.debug("This is an info message");
        logger.error("This is an error message");
    }
}
