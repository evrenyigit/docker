package mindtro.helloworld.dataAccess;

import mindtro.helloworld.entity.OperationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationLogRepository extends JpaRepository<OperationLog,Integer> {

}
