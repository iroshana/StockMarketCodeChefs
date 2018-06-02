/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author thari
 */
@Entity
public class Player {

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
     * @return the Round
     */
    public Round getRound() {
        return Round;
    }

    /**
     * @param Round the Round to set
     */
    public void setRound(Round Round) {
        this.Round = Round;
    }

    /**
     * @return the GameRoundPlayer
     */
    public GameRoundPlayer getGameRoundPlayer() {
        return GameRoundPlayer;
    }

    /**
     * @param GameRoundPlayer the GameRoundPlayer to set
     */
    public void setGameRoundPlayer(GameRoundPlayer GameRoundPlayer) {
        this.GameRoundPlayer = GameRoundPlayer;
    }
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    @Column(name = "Name")
    private String Name;  
    
    @Column(name = "Rating")
    private int Rating;
    
    @Column(name = "Email")
    private String Email;
    
    @OneToOne(mappedBy="Player")
    private GamePlayer GamePlayer;
    
    @OneToOne(mappedBy="Player")
    private Round Round;
    
    @OneToOne(mappedBy="Player")
    private GameRoundPlayer GameRoundPlayer;
    
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
     * @return the Rating
     */
    public int getRating() {
        return Rating;
    }

    /**
     * @param Rating the Rating to set
     */
    public void setRating(int Rating) {
        this.Rating = Rating;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

}
