package mindtro.helloworld.api;

import mindtro.helloworld.business.CustomerService;
import mindtro.helloworld.core.exceptions.MyException;
import mindtro.helloworld.core.utilities.DataResult;
import mindtro.helloworld.core.utilities.Result;
import mindtro.helloworld.core.utilities.SuccessResult;
import mindtro.helloworld.dataAccess.CustomerRepository;
import mindtro.helloworld.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Customer customer){
        return ResponseEntity.ok().body(customerService.add(customer));
    }

    @GetMapping("/findById")
    public Result findById(@RequestParam("id") Integer id) throws MyException {
        return customerService.findById(id);
    }
}
