package t1808a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import t1808a.enitty.Orders;
import t1808a.enitty.Product;
import t1808a.enitty.specification.ProductSpecification;
import t1808a.enitty.specification.SearchCriteria;
import t1808a.repository.ProductPaginationRepository;
import t1808a.repository.ProductRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductPaginationRepository productPaginationRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Product> getList() {
        return productRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/specification")
    public Iterable<Product> getPagination(@RequestParam(defaultValue = "") String name, Optional<Double> price) {
        Specification specification = Specification.where(null);
        if (name != null && name.length() > 0) {
            specification = specification.and(new ProductSpecification(new SearchCriteria("name", "=", name)));
        }
        if (price.isPresent() && price.get() != 0) {
            specification = specification.and(new ProductSpecification(new SearchCriteria("price", "=", price.get())));
        }
        return productPaginationRepository.findAll(specification);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/paginate")
    public ResponseEntity<Iterable<Product>> getPagination(
            @RequestParam(name = "page") int page,
            @RequestParam(name = "limit") int limit) {
        Page<Product> productPage = productPaginationRepository.findAll(PageRequest.of(page - 1, limit, Sort.by(Sort.Direction.DESC, "price")));
        return new ResponseEntity<>(productPage.getContent(), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/findByPriceQuery")
    public Iterable<Product> getProductByPriceQuery(Double price) {
        return productRepository.getProductByPrice(price);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/findByName")
    public Iterable<Product> getListByName(String name) {
        return productRepository.findAllByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/findByNameOrPrice")
    public Iterable<Product> getListByNameOrPrice(String name, Double price) {
        return productRepository.findAllByNameOrPrice(name, price);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Product getDetail(@PathVariable int id) {
//        Optional<Product> optionalProduct = productRepository.findById(id);
//        optionalProduct.orElse(null);
        return productRepository.findById(id).orElse(null);
//        return list.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product create(@RequestBody Product product) {
        Product savedProduct = productRepository.save(product);
//        list.add(product);
        return savedProduct;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public String update(@PathVariable int id, @RequestBody Product product) {

        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product existProduct = optionalProduct.get();
            existProduct.setName(product.getName());
            existProduct.setPrice(product.getPrice());
            productRepository.save(existProduct);
            return "Update Success!";
        }
        return "Product not found or has been deleted!";
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public String delete(@PathVariable int id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            productRepository.deleteById(id);
            return "Delete Success!";
        }
        return "Product not found or has been deleted!";
    }

}
