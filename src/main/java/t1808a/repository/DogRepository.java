package t1808a.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import t1808a.enitty.Dog;
import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Integer>, JpaSpecificationExecutor<Dog> {

    List<Dog> findAll(Specification specification);

}
