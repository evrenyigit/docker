package mindtro.helloworld;

import mindtro.helloworld.business.MyService;
import mindtro.helloworld.core.ubl.XmlToJsonConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloworldApplication {

	public static void main(String[] args) {
		MyService myService = new MyService();
		SpringApplication.run(HelloworldApplication.class, args);

		XmlToJsonConverter xmlToJsonConverter = new XmlToJsonConverter();

	}

}
