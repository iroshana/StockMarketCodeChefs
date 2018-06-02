/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

/**
 *
 * @author thari
 */
@Entity
@Table(name = "Company")
public class Company {

    /**
     * @return the Sector
     */
    public Sector getSector() {
        return Sector;
    }

    /**
     * @param Sector the Sector to set
     */
    public void setSector(Sector Sector) {
        this.Sector = Sector;
    }
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    @Column(name = "Name")
    private String Name;
    
    @Column(name = "Grade")
    private int Grade;
    
    @Column(name = "NoOfShares")
    private int NoOfShares;
    
    @Column(name = "ShareValue")
    private double ShareValue;

    @ManyToOne
    @JoinColumn (name="SectorId")
    @JsonBackReference
    private Sector Sector;
    
    @OneToOne(mappedBy="Company")
    private GameCompany GameCompany;
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
     * @return the Grade
     */
    public int getGrade() {
        return Grade;
    }

    /**
     * @param Grade the Grade to set
     */
    public void setGrade(int Grade) {
        this.Grade = Grade;
    }

    /**
     * @return the NoOfShares
     */
    public int getNoOfShares() {
        return NoOfShares;
    }

    /**
     * @param NoOfShares the NoOfShares to set
     */
    public void setNoOfShares(int NoOfShares) {
        this.NoOfShares = NoOfShares;
    }

    /**
     * @return the ShareValue
     */
    public double getShareValue() {
        return ShareValue;
    }

    /**
     * @param ShareValue the ShareValue to set
     */
    public void setShareValue(double ShareValue) {
        this.ShareValue = ShareValue;
    }

    /**
     * @return the GameCompany
     */
    public GameCompany getGameCompany() {
        return GameCompany;
    }

    /**
     * @param GameCompany the GameCompany to set
     */
    public void setGameCompany(GameCompany GameCompany) {
        this.GameCompany = GameCompany;
    }
    
}
