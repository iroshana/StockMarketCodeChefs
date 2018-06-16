/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author thari
 */
@Entity
public class GameRoundCompany {
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    @ManyToOne
    @JoinColumn (name="GameRoundId")
    @JsonBackReference
    private GameRound GameRound;
    
    @ManyToOne
    @JoinColumn (name="GameCompanyId")
    @JsonBackReference
    private GameCompany GameCompany;
    
    @Column(name = "ShareValue")
    private double shareValue;

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
     * @return the GameRound
     */
    public GameRound getGameRound() {
        return GameRound;
    }

    /**
     * @param GameRound the GameRound to set
     */
    public void setGameRound(GameRound GameRound) {
        this.GameRound = GameRound;
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
    public void setGameCompany(GameCompany gameCompany) {
        this.GameCompany = gameCompany;
    }

    /**
     * @return the ShareValue
     */
    public double getShareValue() {
        return shareValue;
    }

    /**
     * @param ShareValue the ShareValue to set
     */
    public void setShareValue(double ShareValue) {
        this.shareValue = ShareValue;
    }
    
}
