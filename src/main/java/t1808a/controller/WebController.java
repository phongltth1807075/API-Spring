package t1808a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import t1808a.enitty.Product;
import t1808a.repository.ProductRepository;

@Controller
public class WebController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "T1808A");
        return "home";
    }

    @GetMapping("/product")
    public String openAddProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "home";
    }

    @GetMapping("/listproduct")
    public String getAllList(Model model) {
        model.addAttribute("product",productRepository.findAll());
        return "listProduct";
    }
}
