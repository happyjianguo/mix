package test.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by joshua on 16/12/3.
 */
public class CommonLogging {

    public static void main(String[] args){
        Log log = LogFactory.getLog(CommonLogging.class);
        log.debug("Debug info.");
        log.info("Info info");
        log.warn("Warn info");
        log.error("Error info");
        log.fatal("Fatal info");
    }
}
