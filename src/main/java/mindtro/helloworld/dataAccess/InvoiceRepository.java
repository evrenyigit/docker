package mindtro.helloworld.dataAccess;

import mindtro.helloworld.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {

    Invoice findById(Long id);

}
