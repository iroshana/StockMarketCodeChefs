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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author thari
 */
@Entity
public class GameCompany {

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
     * @return the Game
     */
    public Game getGame() {
        return Game;
    }

    /**
     * @param Game the Game to set
     */
    public void setGame(Game Game) {
        this.Game = Game;
    }

    /**
     * @return the Company
     */
    public Company getCompany() {
        return Company;
    }

    /**
     * @param Company the Company to set
     */
    public void setCompany(Company Company) {
        this.Company = Company;
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

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    @ManyToOne
    @JoinColumn (name="GameId")
    @JsonBackReference
    private Game Game;
    
    @ManyToOne
    @JoinColumn (name="CompanyId")
    @JsonBackReference
    private Company Company;
    
    @Column(name = "NoOfShares")
    private int NoOfShares;
    
    @Column(name = "ShareValue")
    private double ShareValue;
    
    @OneToMany(mappedBy = "GameCompany")
    private Set<PlayerPurchase> PlayerPurchase = new HashSet<PlayerPurchase>();

    @OneToMany(mappedBy = "GameCompany")
    private Set<GameRoundCompany> GameRoundCompany = new HashSet<GameRoundCompany>();
    /**
     * @return the PlayerPurchase
     */
    public Set<PlayerPurchase> getPlayerPurchase() {
        return PlayerPurchase;
    }

    /**
     * @param PlayerPurchase the PlayerPurchase to set
     */
    public void setPlayerPurchase(Set<PlayerPurchase> PlayerPurchase) {
        this.PlayerPurchase = PlayerPurchase;
    }

    /**
     * @return the GameRoundCompany
     */
    public Set<GameRoundCompany> getGameRoundCompany() {
        return GameRoundCompany;
    }

    /**
     * @param GameRoundCompany the GameRoundCompany to set
     */
    public void setGameRoundCompany(Set<GameRoundCompany> GameRoundCompany) {
        this.GameRoundCompany = GameRoundCompany;
    }
}
