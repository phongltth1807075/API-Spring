package t1808a.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import t1808a.repository.RolesRepository;

@RestController
@RequestMapping(path = "/role")

public class RoleController {

    @Autowired
    private RolesRepository roleRepository;
}
