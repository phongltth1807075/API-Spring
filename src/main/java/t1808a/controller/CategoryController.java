//package t1808a.controller;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import t1808a.enitty.Category;
//import t1808a.enitty.Product;
//import t1808a.repository.CategoryRepository;

import java.util.ArrayList;
//
//@RestController
//@RequestMapping(path = "/categories")
//public class CategoryController {
//        @Autowired
//        CategoryRepository categoryRepository;
//
//        @RequestMapping(method = RequestMethod.POST)
//    public Category create(@RequestBody Category category)
//    {
//       Category savedCategory = categoryRepository.save(category);
//        return savedCategory;
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public Iterable<Category> getList()
//    {
//        return categoryRepository.findAll();
//    }
//
//    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
//    public Category getDetail(@PathVariable int id)
//    {
//      return categoryRepository.findById(id).orElse(null);
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
//    public String update(@PathVariable int id, @RequestBody Category category)
//    {
//        Category existCate = list.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
//        if (existCate == null)
//        {
//            return "Category is deleted or not found!";
//        }
//        existCate.setName(category.getName());
//        return "Update Category Success!";
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
//    public String delete(@PathVariable int id)
//    {
//        return list.removeIf(c -> c.getId() == id) ? "Delete Success!" : "Delete Fails!";
//    }
//
//















//
//    private static ArrayList<Category> list = new ArrayList<>();
//
//    @RequestMapping(method = RequestMethod.POST)
//    public Category create(@RequestBody Category category)
//    {
//        list.add(category);
//        return category;
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public ArrayList<Category>getList()
//    {
//        return list;
//    }
//
//    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
//    public Category getDetail(@PathVariable int id)
//    {
//        return list.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
//    public String update(@PathVariable int id, @RequestBody Category category)
//    {
//        Category existCate = list.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
//        if (existCate == null)
//        {
//            return "Category is deleted or not found!";
//        }
//        existCate.setName(category.getName());
//        return "Update Category Success!";
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
//    public String delete(@PathVariable int id)
//    {
//        return list.removeIf(c -> c.getId() == id) ? "Delete Success!" : "Delete Fails!";
//    }
//}
