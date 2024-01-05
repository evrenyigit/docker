package mindtro.helloworld.business;

import mindtro.helloworld.dataAccess.InvoiceRepository;
import mindtro.helloworld.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice add(Invoice invoice){
        Date date = new Date();
        invoice.setInvoiceDate(date);
        return invoiceRepository.save(invoice);
    }
}
