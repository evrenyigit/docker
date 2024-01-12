package mindtro.helloworld.core.ubl;

import mindtro.helloworld.entity.Invoice;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class UblReader extends Exception{

    public void convertXml(Invoice invoice) throws JAXBException {

        //Invoice dosyamızı XML'e dönüştürmek istedim ve xml dosyasında çıktı aldım.
        JAXBContext context = JAXBContext.newInstance(Invoice.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(invoice, new File("invoice.xml"));
    }

//    try
//
//    {
//
//        Date date = new Date();
//        Invoice invoice = new Invoice();
//        invoice.setInvoiceDate(date);
//        invoice.setTotalAmount(BigDecimal.valueOf(100));
//
//        JAXBContext jaxbContext = JAXBContext.newInstance(Invoice.class);
//        Marshaller marshaller = jaxbContext.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//        marshaller.marshal(invoice, new FileWriter("UBLFile.xml"));
//
//        System.out.println("UBL dosyası başarıyla oluşturuldu.");
//
//    } catch(JAXBException | IOException e)
//
//    {
//        e.printStackTrace();
//    }

}