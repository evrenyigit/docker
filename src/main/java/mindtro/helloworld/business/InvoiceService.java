package mindtro.helloworld.business;

import mindtro.helloworld.dataAccess.InvoiceDetailRepository;
import mindtro.helloworld.dataAccess.InvoiceRepository;
import mindtro.helloworld.entity.Invoice;
import mindtro.helloworld.entity.InvoiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    public void totalAmountInvoice(Long invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId);

        if(invoice!=null){
            List<InvoiceDetail> invoiceDetailList = invoiceDetailRepository.findByInvoiceId(invoiceId);

            BigDecimal totalAmount = invoiceDetailList.stream().map(InvoiceDetail::getAmount).reduce(BigDecimal.ZERO,BigDecimal::add);

            invoice.setTotalAmount(totalAmount);

            invoiceRepository.save(invoice);
        }

    }

    public Invoice add(Invoice invoice){
        Date date = new Date();
        invoice.setInvoiceDate(date);
        return invoiceRepository.save(invoice);
    }
}
