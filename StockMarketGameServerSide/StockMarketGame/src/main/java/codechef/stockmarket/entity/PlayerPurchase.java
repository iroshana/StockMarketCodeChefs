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
public class PlayerPurchase {

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
     * @return the NoOfShare
     */
    public int getNoOfShare() {
        return NoOfShare;
    }

    /**
     * @param NoOfShare the NoOfShare to set
     */
    public void setNoOfShare(int NoOfShare) {
        this.NoOfShare = NoOfShare;
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
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    @ManyToOne
    @JoinColumn (name="CompanyId")
    @JsonBackReference
    private GameCompany GameCompany;
    
    @ManyToOne
    @JoinColumn (name="GameRoundId")
    @JsonBackReference
    private GameRound GameRound;
    
    @Column(name = "NoOfShare")
    private int NoOfShare;
    
    @Column(name = "ShareValue")
    private double ShareValue;
}
