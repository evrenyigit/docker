package mindtro.helloworld.api;

import mindtro.helloworld.business.InvoiceService;
import mindtro.helloworld.entity.Customer;
import mindtro.helloworld.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Invoice invoice){
        return ResponseEntity.ok().body(invoiceService.add(invoice));
    }
}
