package mindtro.helloworld.api;

import mindtro.helloworld.business.CustomerService;
import mindtro.helloworld.dataAccess.CustomerRepository;
import mindtro.helloworld.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Customer customer){
        return ResponseEntity.ok().body(customerService.add(customer));
    }
}
