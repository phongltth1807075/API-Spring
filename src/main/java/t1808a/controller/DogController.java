package t1808a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import t1808a.enitty.Dog;
import t1808a.enitty.specification.ProductSpecification;
import t1808a.enitty.specification.SearchCriteria;
import t1808a.repository.DogRepository;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(path = "/dog")
public class DogController {

    @Autowired
    private DogRepository dogRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/filter")
    public ResponseEntity<Iterable<Dog>> getlistfilter(@RequestParam(name = "page") int page,
                                                       @RequestParam(name = "limit") int limit, @RequestParam(defaultValue = "") String breedName, @RequestParam(defaultValue = "") String color, Optional<Integer> gender) {
        Specification specification = Specification.where(null);
        if (breedName != null && breedName.length() > 0) {
            specification = specification.and(new ProductSpecification(new SearchCriteria("breedName", "=", breedName)));
        }
        if (color != null && color.length() > 0) {
            specification = specification.and(new ProductSpecification(new SearchCriteria("color", "=", color)));
        }
        if (gender.isPresent()) {
            specification = specification.and(new ProductSpecification(new SearchCriteria("gender", "=", gender.get())));
        }
        Page<Dog> dogPage = dogRepository.findAll(specification, PageRequest.of(page - 1, limit, Sort.by(Sort.Direction.DESC, "gender")));
        return new ResponseEntity<>(dogPage.getContent(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Dog>> getlist() {
        return new ResponseEntity<>(dogRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Dog> detail(@PathVariable int id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            return new ResponseEntity<>(dog, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Dog> create(@RequestBody Dog dog) {
        Dog saveDog = dogRepository.save(dog);
        if (saveDog != null){
            return new ResponseEntity<>(saveDog, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            dogRepository.deleteById(id);
            Date currentDate = new Date();
            return new ResponseEntity<>("Delete Success" + currentDate.getTime() / 1000, HttpStatus.OK);
        }
        return new ResponseEntity<>("Dog is not found", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Dog dog) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            Dog dog1 = optionalDog.get();
            dog1.setName(dog.getName());
            dog1.setBirthday(dog.getBirthday());
            dog1.setBreedName(dog.getBreedName());
            dog1.setColor(dog.getColor());
            dog1.setGender(dog.getGender());
            dog1.setStatus(dog.getStatus());
            dogRepository.save(dog1);
            return new ResponseEntity<>("Update Success", HttpStatus.OK);
        }
        return new ResponseEntity<>("Dog is not found", HttpStatus.NOT_FOUND);
    }
}
