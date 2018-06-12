/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.restcontroller;

import codechef.stockmarket.entity.Bank;
import codechef.stockmarket.entity.Company;
import codechef.stockmarket.entity.Test;
import codechef.stockmarket.repository.BankRepository;
import codechef.stockmarket.repository.TestRepositoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thari
 */
@RestController
@RequestMapping("/Bank")
public class BankController {
    
    @Autowired
    BankRepository BankRepository = null;
    
    @GetMapping("/Banks/")
    public List<Bank> getNoteById() {
        
        return BankRepository.findAll();
    }
}
