package mindtro.helloworld.dataAccess;

import mindtro.helloworld.entity.Argument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArgumentRepository extends JpaRepository<Argument,Integer> {

}
