/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.restcontroller;

import codechef.stockmarket.common.ViewModels.*;
import codechef.stockmarket.entity.*;
import codechef.stockmarket.repository.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thari
 */
@RestController
@RequestMapping("/Broker")
public class BrokerController {
    
    @Autowired
    BrokerRepository brokerepository = null;
    
    @GetMapping("/GetAllBrokers/")
    public List<BrokerViewModel> getNoteById() {
         List<BrokerViewModel> bankList = new ArrayList<>();
         List<Broker> banks = brokerepository.findAll();
         banks.stream().map((bank) -> {
             BrokerViewModel bankView = new BrokerViewModel();
             bankView.setId(bank.getId());
             bankView.setName(bank.getName());
             bankView.setRating(bank.getRating());
            return bankView;
        }).forEachOrdered((bankView) -> {
            bankList.add(bankView);
        });
         return bankList;
    }
}
