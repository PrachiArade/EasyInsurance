package perscholas.mycasestudy.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories (basePackages = "perscholas.mycasestudy.database")
public class DatabaseConfig {



}
