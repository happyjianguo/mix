package test.innerbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by joshua on 17/4/13.
 */
@Configuration
public class SpellCheckerConfig {

    @Bean
    public SpellChecker sc() {
        return new SpellChecker();
    }
}
