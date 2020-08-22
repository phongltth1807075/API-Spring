package t1808a.enitty.specification;

import org.springframework.data.jpa.domain.Specification;
import t1808a.enitty.Product;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProductSpecification implements Specification<Product> {
    private SearchCriteria searchCriteria;


    public ProductSpecification(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    //thuc thi tim kiem loc theo search criteria truyen vao
    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (this.searchCriteria.getOperation().equals("=")) {
            //tim kiem theo gia tri bang
            if (root.get(searchCriteria.getKey()).getJavaType() == String.class) {
                //search theo like neu la tim kiem theo String
                return criteriaBuilder.like(root.get(searchCriteria.getKey()), "%" + searchCriteria.getValue() + "%");
            }
            else {
                return criteriaBuilder.equal(
                        root.get(this.searchCriteria.getKey()),
                        this.searchCriteria.getValue().toString()
                );
            }
        } else if (this.searchCriteria.getOperation().equals(">")) {
            //tim theo gia tri >
            return criteriaBuilder.greaterThan(
                    root.get(this.searchCriteria.getKey()),
                    this.searchCriteria.getValue().toString()
            );
        } else if (this.searchCriteria.getOperation().equals(">=")) {
            //tim theo gia tri >=
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.get(this.searchCriteria.getKey()),
                    this.searchCriteria.getValue().toString()
            );
        } else if (this.searchCriteria.getOperation().equals("<")) {
            //tim theo gia tri <
            return criteriaBuilder.lessThan(
                    root.get(this.searchCriteria.getKey()),
                    this.searchCriteria.getValue().toString()
            );
        } else if (this.searchCriteria.getOperation().equals("<=")) {
            //tim theo gia tri <=
            return criteriaBuilder.lessThanOrEqualTo(
                    root.get(this.searchCriteria.getKey()),
                    this.searchCriteria.getValue().toString()
            );
        }
        return null;
    }
}
