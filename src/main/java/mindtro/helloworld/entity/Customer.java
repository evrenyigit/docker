package mindtro.helloworld.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","invoceList"})
@Entity
@Data
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Email
    @Column(name="email")
    private String email;

//  @OneToMany(mappedBy = "customer")
//  private List<Invoice> invoiceList;


}
