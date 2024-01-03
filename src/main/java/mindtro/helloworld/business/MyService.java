package mindtro.helloworld.business;

import lombok.NoArgsConstructor;
import mindtro.helloworld.core.LogAspect;
import mindtro.helloworld.dataAccess.OperationLogRepository;
import mindtro.helloworld.entity.OperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class MyService {

    //interceptor - web filter
    private OperationLogRepository operationLogRepository;

    @Autowired
    public MyService(OperationLogRepository operationLogRepository){
        this.operationLogRepository = operationLogRepository;
    }

    public String doSomething(String param){
        System.out.println("doing something...   " + param );
        return param;
    }

    public OperationLog add(OperationLog operationLog){
        return operationLogRepository.save(operationLog);
    }

    public List<OperationLog> getAllOperations(){
        return operationLogRepository.findAll();
    }
}

