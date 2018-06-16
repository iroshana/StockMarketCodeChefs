/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author thari
 */
@Entity
public class GameRound {

    /**
     * @return the roundLeaderPoint
     */
    public int getRoundLeaderPoint() {
        return roundLeaderPoint;
    }

    /**
     * @param roundLeaderPoint the roundLeaderPoint to set
     */
    public void setRoundLeaderPoint(int roundLeaderPoint) {
        this.roundLeaderPoint = roundLeaderPoint;
    }

    /**
     * @return the roundLeaderId
     */
    public Long getRoundLeaderId() {
        return roundLeaderId;
    }

    /**
     * @param roundLeaderId the roundLeaderId to set
     */
    public void setRoundLeaderId(Long roundLeaderId) {
        this.roundLeaderId = roundLeaderId;
    }

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
    
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    @ManyToOne
    @JoinColumn (name="GameId")
    @JsonBackReference
    private Game Game;
    
    @ManyToOne
    @JoinColumn (name="RoundId")
    @JsonBackReference
    private Round Round;
    
    @Column(name = "RoundLeaderPoint",nullable = true)
    private int roundLeaderPoint;
    
    @Column(name = "RoundLeaderId",nullable = true)
    private Long roundLeaderId;
    
    @OneToMany(mappedBy = "GameRound")
    private Set<GameRoundPlayer> GameRoundPlayer = new HashSet<GameRoundPlayer>();
    
    @OneToMany(mappedBy = "GameRound")
    private Set<PlayerTransactions> PlayerTransactions = new HashSet<PlayerTransactions>();
    
    @OneToMany(mappedBy = "GameRound")
    private Set<GameRoundCompany> GameRoundCompany = new HashSet<GameRoundCompany>();
    /**
     * @return the GameRoundPlayer
     */
    public Set<GameRoundPlayer> getGameRoundPlayer() {
        return GameRoundPlayer;
    }

    /**
     * @param GameRoundPlayer the GameRoundPlayer to set
     */
    public void setGameRoundPlayer(Set<GameRoundPlayer> GameRoundPlayer) {
        this.GameRoundPlayer = GameRoundPlayer;
    }

    /**
     * @return the PlayerTransactions
     */
    public Set<PlayerTransactions> getPlayerTransactions() {
        return PlayerTransactions;
    }

    /**
     * @param PlayerTransactions the PlayerTransactions to set
     */
    public void setPlayerTransactions(Set<PlayerTransactions> PlayerTransactions) {
        this.PlayerTransactions = PlayerTransactions;
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
