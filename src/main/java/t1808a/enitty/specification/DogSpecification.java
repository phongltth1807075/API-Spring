package t1808a.enitty.specification;

import org.springframework.data.jpa.domain.Specification;
import t1808a.enitty.Dog;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class DogSpecification implements Specification<Dog> {


    private SearchCriteria searchCriteria;

    public DogSpecification(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Dog> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
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
