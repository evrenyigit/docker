package mindtro.helloworld.business;

import mindtro.helloworld.core.ubl.UblReader;
import mindtro.helloworld.dataAccess.InvoiceDetailRepository;
import mindtro.helloworld.dataAccess.InvoiceRepository;
import mindtro.helloworld.entity.Invoice;
import mindtro.helloworld.entity.InvoiceDetail;
import net.sf.saxon.s9api.SaxonApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    @Autowired
    private UblReader ublReader;

    public void totalAmountInvoice(Long invoiceId) throws JAXBException, SAXException, IOException {
        Invoice invoice = invoiceRepository.findById(invoiceId);

        if(invoice!=null){
            List<InvoiceDetail> invoiceDetailList = invoiceDetailRepository.findByInvoiceId(invoiceId);

            BigDecimal totalAmount = invoiceDetailList.stream().map(InvoiceDetail::getAmount).reduce(BigDecimal.ZERO,BigDecimal::add);

            invoice.setTotalAmount(totalAmount);

            try{
                ublReader.convertXml(invoice);
            }catch (JAXBException e){

            }catch (SaxonApiException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            invoiceRepository.save(invoice);
        }

    }

    public Invoice add(Invoice invoice){
        Date date = new Date();
        invoice.setInvoiceDate(date);
        return invoiceRepository.save(invoice);
    }
}
