/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
/**
 *
 * @author thari
 */
@Entity
public class Sector {
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    @Column(name = "Name")
    private String Name; 
    
    @OneToMany(mappedBy = "Sector")
    private Set<Company> Company = new HashSet<Company>();
    
    
    
    /**
     * @return the Id
     */
    public Long getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Long Id) {
        this.Id = Id;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Company
     */
    public Set<Company> getCompany() {
        return Company;
    }

    /**
     * @param Company the Company to set
     */
    public void setCompany(Set<Company> Company) {
        this.Company = Company;
    }
}
