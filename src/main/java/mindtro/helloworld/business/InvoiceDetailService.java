package mindtro.helloworld.business;

import mindtro.helloworld.core.utilities.Result;
import mindtro.helloworld.core.utilities.SuccessResult;
import mindtro.helloworld.dataAccess.InvoiceDetailRepository;
import mindtro.helloworld.dataAccess.InvoiceRepository;
import mindtro.helloworld.entity.Invoice;
import mindtro.helloworld.entity.InvoiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;

@Service
public class InvoiceDetailService {

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    @Autowired
    private InvoiceService invoiceService;

    public Result add(InvoiceDetail invoiceDetail) throws JAXBException, SAXException, IOException {
        if(invoiceDetail.getDiscount()!=null)
            invoiceDetail.setDiscountRate(invoiceDetail.getDiscount().multiply(BigDecimal.valueOf(100)).divide(invoiceDetail.getUnitPrice()));
        else if (invoiceDetail.getDiscount()==null && invoiceDetail.getDiscountRate()!=null)
            invoiceDetail.setDiscount(invoiceDetail.getUnitPrice().multiply(invoiceDetail.getDiscountRate()).divide(BigDecimal.valueOf(100)));
        invoiceDetail.setAmount(calculateAmount(invoiceDetail));
        invoiceDetailRepository.save(invoiceDetail);
        invoiceService.totalAmountInvoice(invoiceDetail.getInvoice().getId());
        return new SuccessResult("Basarili");
    }

    public BigDecimal calculateAmount(InvoiceDetail invoiceDetail){
        BigDecimal bigDecimal = (invoiceDetail.getUnitPrice().subtract(invoiceDetail.getDiscount())).
                multiply((BigDecimal.valueOf(100).add(invoiceDetail.getTaxRate())).divide(BigDecimal.valueOf(100))).
                multiply(BigDecimal.valueOf(invoiceDetail.getQuantity()));
        return bigDecimal;
    }

}
