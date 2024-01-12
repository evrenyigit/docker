package mindtro.helloworld.business;

import mindtro.helloworld.core.exceptions.MyException;
import mindtro.helloworld.core.utilities.DataResult;
import mindtro.helloworld.core.utilities.Result;
import mindtro.helloworld.core.utilities.SuccessDataResult;
import mindtro.helloworld.core.utilities.SuccessResult;
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

    public DataResult<Customer> findById(Integer id) throws MyException{
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new MyException());
        return new SuccessDataResult("Data listelendi");
    }

}
