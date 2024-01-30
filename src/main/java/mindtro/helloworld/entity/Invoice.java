package mindtro.helloworld.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "invoices")
@XmlRootElement(name = "Invoice")
@XmlAccessorType(XmlAccessType.FIELD)
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

    /*
    bu kısım olmalı mı ?

    private Long faturaNo;

    private String scenerio;

    irsaliye varsa ? yukardakileri notnull yapıp bunu null yapabilirsin




     */

//    @OneToMany(mappedBy = "invoice")
//    List<InvoiceDetail> invoiceDetailList;

}
