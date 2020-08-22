package t1808a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import t1808a.enitty.Orders;
import t1808a.enitty.specification.OrderSpecification;
import t1808a.enitty.specification.SearchCriteria;
import t1808a.repository.OrdersRepository;


@RestController
@RequestMapping(path = "/orders")
public class OrderController {


    @Autowired
    private OrdersRepository ordersRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Orders> getlist(String create_at, String update_at) {
        Specification specification = Specification.where(null);
        if (create_at != null && create_at.length() > 0) {
            specification = specification.and(new OrderSpecification(new SearchCriteria("create_at", "=>", create_at)));
        }
        if (update_at != null && update_at.length() > 0) {
            specification = specification.and(new OrderSpecification(new SearchCriteria("update_at", "<=", update_at)));
        }
        return ordersRepository.findAll(specification);
    }

}
