package webModule;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.springframework.*;
@SpringBootApplication
public class Application {
private static final Logger log = LoggerFactory.getLogger(Application.class);
public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner demo(UserRepository repository) {
		
      return (args) -> {
           // save a couple of users
    	  
    	  		
            UserModel user = new UserModel("john","hello");
            AccountModel account1=new AccountModel(user, 1001, "savings", 580.12);
            AccountModel account2=new AccountModel(user, 1002, "chequing", 20);

            user.addAccount(account1);
            user.addAccount(account2);
            repository.save(user);
        };
    }}
    
