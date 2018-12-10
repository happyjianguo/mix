package test.testdrools.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.testdrools.model.Fare;
import test.testdrools.model.TaxiRide;
import test.testdrools.service.TaxiFareCalculatorService;
import test.testdrools.service.TaxiFareConfiguration;

/**
 * @author chuanshi - 2018-12-10 19:26
 */
public class ApplicationRunner {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TaxiFareConfiguration.class);
        TaxiFareCalculatorService taxiFareCalculatorService = (TaxiFareCalculatorService) context.getBean(TaxiFareCalculatorService.class);
        TaxiRide taxiRide = new TaxiRide();
        taxiRide.setIsNightSurcharge(true);
        taxiRide.setDistanceInMile(190L);
        Fare rideFare = new Fare();
        taxiFareCalculatorService.calculateFare(taxiRide, rideFare);
    }

}
