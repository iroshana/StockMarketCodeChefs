/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author thari
 */
@Entity
public class WatchList {

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
    private GameRoundPlayer GamePlayer;

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
     * @return the GamePlayer
     */
    public GameRoundPlayer getGamePlayer() {
        return GamePlayer;
    }

    /**
     * @param GamePlayer the GamePlayer to set
     */
    public void setGamePlayer(GameRoundPlayer GamePlayer) {
        this.GamePlayer = GamePlayer;
    }
}
