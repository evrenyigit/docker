package mindtro.helloworld.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "invoice_details")
public class InvoiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "unit")
    private Integer unit;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "tax_rate")
    private double taxRate;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "discount_rate")
    private double discountRate;

    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name="invoice_id")
    private Invoice invoice;

}
