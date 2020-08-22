package t1808a.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import t1808a.enitty.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAllByName(String name);

    List<Product> findAllByNameOrPrice(String name, Double price);

    @Query("select p from Product p where p.price <=:price")
    List<Product> getProductByPrice(@Param("price") Double price);

}
