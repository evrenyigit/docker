package mindtro.helloworld.api;

import mindtro.helloworld.business.InvoiceDetailService;
import mindtro.helloworld.core.utilities.Result;
import mindtro.helloworld.entity.InvoiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@RestController
@RequestMapping("/invoice_detail")
public class InvoiceDetailController {

    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @PostMapping("/add")
    public Result add(@RequestBody InvoiceDetail invoiceDetail) throws JAXBException, SAXException, IOException {
        return this.invoiceDetailService.add(invoiceDetail);
       // return ResponseEntity.ok().body(invoiceDetailService.add(invoiceDetail));
    }
}
