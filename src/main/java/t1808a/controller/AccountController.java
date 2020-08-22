package t1808a.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import t1808a.enitty.Accounts;
import t1808a.repository.AccountRepository;

import javax.xml.ws.Response;

@RestController
@RequestMapping(path = "/account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping
    public ResponseEntity<Accounts> create(@RequestBody Accounts accounts){
        Accounts accounts1=accountRepository.save(accounts);
        return new ResponseEntity<>(accounts1, HttpStatus.OK);
    }

}
