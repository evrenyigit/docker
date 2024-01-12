package mindtro.helloworld.dataAccess;

import mindtro.helloworld.entity.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail,Integer> {

    List<InvoiceDetail> findByInvoiceId(Long invoiceId);

}
