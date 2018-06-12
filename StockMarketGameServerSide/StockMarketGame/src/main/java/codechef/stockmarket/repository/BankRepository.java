/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.repository;

import codechef.stockmarket.entity.Bank;
import codechef.stockmarket.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author thari
 */
public interface BankRepository  extends JpaRepository<Bank, Long>{
    
}
