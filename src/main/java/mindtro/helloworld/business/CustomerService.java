package mindtro.helloworld.business;

import mindtro.helloworld.dataAccess.CustomerRepository;
import mindtro.helloworld.entity.Customer;
import mindtro.helloworld.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer add(Customer customer){
        return customerRepository.save(customer);
    }

}
