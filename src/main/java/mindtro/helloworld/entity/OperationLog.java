package mindtro.helloworld.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name ="operation_logs")
public class OperationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "package_name")
    private String packageName;
    @Column(name = "method_name")
    private String methodName;
    @Column(name = "date")
    private Date date;
    @Column(name = "client_IP")
    private String clientIP;
    @Column(name = "client_browser")
    private String clientBrowser;
    @Column(name = "operating_system")
    private String operatingSystem;
}
