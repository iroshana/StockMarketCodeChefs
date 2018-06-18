/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javax.persistence.*;

/**
 *
 * @author thari
 */
@Entity
public class Playerpurchase {

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
    @JoinColumn (name="GamePlayerId")
    @JsonBackReference
    private GamePlayer GamePlayer;
    
    @Column(name = "NoOfShare")
    private int NoOfShare;
    
    @Column(name = "ShareValue")
    private double ShareValue;
    
    @Column(name = "IsSold")
    private boolean isSold;

    /**
     * @return the GamePlayer
     */
    public GamePlayer getGamePlayer() {
        return GamePlayer;
    }

    /**
     * @param GamePlayer the GamePlayer to set
     */
    public void setGamePlayer(GamePlayer GamePlayer) {
        this.GamePlayer = GamePlayer;
    }

    /**
     * @return the isSold
     */
    public boolean getIsSold() {
        return isSold;
    }

    /**
     * @param isSold the isSold to set
     */
    public void setIsSold(boolean isSold) {
        this.isSold = isSold;
    }

}
