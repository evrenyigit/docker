package mindtro.helloworld;

import mindtro.helloworld.business.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloworldApplication {

	public static void main(String[] args) {
		//System.out.println("hello world");
		MyService myService = new MyService();
		SpringApplication.run(HelloworldApplication.class, args);
	}

}
