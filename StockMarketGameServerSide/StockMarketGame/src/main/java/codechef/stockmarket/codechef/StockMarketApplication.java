package codechef.stockmarket.codechef;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "codechef.stockmarket.*")
@ComponentScan(basePackages = "codechef.stockmarket.*")
@EntityScan(basePackages = "codechef.stockmarket.*")
public class StockMarketApplication {
    public static void main(String[] args) {
        SpringApplication.run(StockMarketApplication.class, args);
    }
}
