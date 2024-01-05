package mindtro.helloworld.business;

import mindtro.helloworld.core.utilities.Result;
import mindtro.helloworld.core.utilities.SuccessResult;
import mindtro.helloworld.dataAccess.InvoiceDetailRepository;
import mindtro.helloworld.dataAccess.InvoiceRepository;
import mindtro.helloworld.entity.Invoice;
import mindtro.helloworld.entity.InvoiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceDetailService {

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    public Result add(InvoiceDetail invoiceDetail){
        invoiceDetailRepository.save(invoiceDetail);
        return new SuccessResult("Basarili");
    }

}
