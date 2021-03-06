/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author thari
 */
@Entity
public class GameRoundPlayer {

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
     * @return the Player
     */
    public Player getPlayer() {
        return Player;
    }

    /**
     * @param Player the Player to set
     */
    public void setPlayer(Player Player) {
        this.Player = Player;
    }

    /**
     * @return the Score
     */
    public double getScore() {
        return Score;
    }

    /**
     * @param Score the Score to set
     */
    public void setScore(double Score) {
        this.Score = Score;
    }
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne
    @JoinColumn (name="GameRoundId")
    @JsonBackReference
    private GameRound GameRound;
    
    @ManyToOne
    @JoinColumn (name="PlayerId")
    @JsonBackReference
    private Player Player;
    
    @Column(name = "Score")
    private double Score;
    
}
