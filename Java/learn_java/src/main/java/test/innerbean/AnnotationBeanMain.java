package test.innerbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by joshua on 17/4/13.
 */
public class AnnotationBeanMain {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpellCheckerConfig.class);
        SpellChecker spellChecker = context.getBean(SpellChecker.class);
        spellChecker.checkSpelling();
    }
}
