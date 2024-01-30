package mindtro.helloworld.core.ubl;

import com.helger.commons.error.list.IErrorList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.mock.CommonsTestHelper;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.schematron.ISchematronResource;
import com.helger.schematron.SchematronHelper;
import com.helger.schematron.pure.SchematronResourcePure;
import com.helger.ubl21.UBL21Marshaller;
import com.helger.ubltr.UBLTRMarshaller;
import com.helger.xml.serialize.read.DOMReader;
import com.helger.xml.serialize.read.DOMReaderSettings;
import mindtro.helloworld.core.utilities.ErrorResult;
import mindtro.helloworld.core.utilities.Result;
import mindtro.helloworld.core.utilities.SuccessResult;
import mindtro.helloworld.entity.Invoice;
import net.sf.saxon.lib.StandardErrorListener;
import net.sf.saxon.s9api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import tr.gov.efatura.useraccount.ProcessUserAccountType;

import javax.annotation.Nonnull;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;


@Component
public class UblReader extends Exception{

    public String schematronPath = "src/main/resources/deneme.sch";
   // public String ublDocumentPath = "invoice.xml";

    @Autowired
    private SchematronValidator schematronValidator;

    public Result convertXml(Invoice invoice) throws Exception {

        //Invoice dosyamızı XML'e dönüştürmek istedim ve xml dosyasında çıktı aldım.
        JAXBContext context = JAXBContext.newInstance(Invoice.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(invoice, new File("invoice.xml"));

        //schematronValidator.validateWithSchematron("target/invoice.xml","src/main/resources/deneme.sch");
//        String invoiceFilePath = "target/invoice.xml";
//        Document document = DOMReader.readXMLDOM(new ClassPathResource(invoiceFilePath),new DOMReaderSettings());
//
//        ProcessUserAccountType processUserAccountType = UBLTRMarshaller.processUserAccount().read(document);
//
//        IErrorList errors = UBLTRMarshaller.cancelUserAccount().


        return new SuccessResult("okki");

               // .validateWithSchematron("invoice.xml","deneme.sch");


//            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//            Schema schema = schemaFactory.newSchema(getClass().getClassLoader().getResource("schema-definition.xsd"));
//
//            Validator xsDvalidator = schema.newValidator();
//            xsDvalidator.validate(new StreamSource(new File("invoice.xml")));

        }

    }