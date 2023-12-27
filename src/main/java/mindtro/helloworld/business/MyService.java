package mindtro.helloworld.business;

import lombok.extern.java.Log;
import mindtro.helloworld.core.LogAspect;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @LogAspect
    public String doSomething(String param){
        System.out.println("doing something..." + param );
        return param;
    }
}
