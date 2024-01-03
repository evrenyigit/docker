package mindtro.helloworld.api;

import jakarta.servlet.http.HttpServletRequest;
import mindtro.helloworld.business.MyService;
import mindtro.helloworld.core.LogAspect;
import mindtro.helloworld.entity.OperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ServiceController {

    @Autowired
    private MyService myService;
    @Autowired
    private HttpServletRequest request;

    @LogAspect
    @PostMapping("/log-istek")
    //@LogAspect(parameter = true)
    public ResponseEntity<?> method(@RequestBody String message){
        return ResponseEntity.ok(myService.doSomething(message));
    }

//    @LogAspect
//    @GetMapping("/client-api")
//    public String method2(){
//        String clientIp = request.getRemoteAddr();
//        return "Client IP " + clientIp;
//    }

    @LogAspect
    @GetMapping("/getall")
    public List<OperationLog> getAllOperationLogs(){
        return myService.getAllOperations();
    }
}
