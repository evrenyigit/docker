package mindtro.helloworld.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "invoice_date")
    private Date invoiceDate;

    @Column(name = "type_of_invoice")
    private String typeOfInvoice;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

//    @OneToMany(mappedBy = "invoice")
//    List<InvoiceDetail> invoiceDetailList;

}
