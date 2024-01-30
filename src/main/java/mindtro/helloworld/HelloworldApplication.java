package mindtro.helloworld;

import mindtro.helloworld.business.MyService;
import mindtro.helloworld.core.ubl.SchematronValidator;
import mindtro.helloworld.core.ubl.XmlToJsonConverter;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class HelloworldApplication {

	public static void main(String[] args) throws SaxonApiException {
		MyService myService = new MyService();
		SpringApplication.run(HelloworldApplication.class, args);

//		Processor processor = new Processor(false);
//
//		XmlToJsonConverter xmlToJsonConverter = new XmlToJsonConverter();
//
//		File xmlFile = new File("invoice.xml");
//		File schematronFile = new File("schematron.sch");
//
//		SchematronValidator schematronValidator = new SchematronValidator();
//
//		boolean isValid = schematronValidator.validateWithSchematron(xmlFile,schematronFile);
//
//		if(isValid) {
//			System.out.println("XML dosyası Schematron kurallarına uygun.");
//		} else {
//			System.out.println("XML dosyası Schematron kurallarına uygun değil.");
//		}

	}

}
