package de.rauldev.springbootjenkinsawsdemo;
import de.rauldev.springbootjenkinsawsdemo.entities.ProductEntity;
import de.rauldev.springbootjenkinsawsdemo.repository.IProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootJenkinsAwsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJenkinsAwsDemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner generateSampleData(IProductRepository productRepository){
		return (args -> {
			productRepository.save(new ProductEntity("MackBook Pro M1 13 8GB Ram",799.0));
			productRepository.save(new ProductEntity("Apple Watch 6",450.60));
			productRepository.save(new ProductEntity("Magic Mouse",77.40));
			productRepository.save(new ProductEntity("IMac 27 64 ram R RXT3000",10800.56));
		});
	}
}
