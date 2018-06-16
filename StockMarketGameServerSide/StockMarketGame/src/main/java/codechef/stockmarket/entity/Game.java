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
public class Game {
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "NoOfPlayers")
    private int NoOfPlayers;
    
    @Column(name = "NoOfRounds")
    private int NoOfRounds;
    
    @Column(name = "CurrentRounds")
    private int CurrentRounds;
    
    @Column(name = "GameLeaderPoint")
    private int GameLeaderPoint;
    @Column(name = "GameLeaderId",nullable = true)
    private Long GameLeaderId;
    
    @OneToMany(mappedBy = "Game")
    private Set<GamePlayer> GamePlayers = new HashSet<GamePlayer>();
    
    @OneToMany(mappedBy = "Game")
    private Set<PlayerTransactions> PlayerTransactions = new HashSet<PlayerTransactions>();
    
    @OneToMany(mappedBy = "Game")
    private Set<GameRound> GameRounds = new HashSet<GameRound>();
    
    @OneToMany(mappedBy = "Game")
    private Set<GameCompany> GameCompany = new HashSet<GameCompany>();
    /**
     * @return the Id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Long Id) {
        this.id = Id;
    }

    /**
     * @return the NoOfPlayers
     */
    public int getNoOfPlayers() {
        return NoOfPlayers;
    }

    /**
     * @param NoOfPlayers the NoOfPlayers to set
     */
    public void setNoOfPlayers(int NoOfPlayers) {
        this.NoOfPlayers = NoOfPlayers;
    }

    /**
     * @return the NoOfRounds
     */
    public int getNoOfRounds() {
        return NoOfRounds;
    }

    /**
     * @param NoOfRounds the NoOfRounds to set
     */
    public void setNoOfRounds(int NoOfRounds) {
        this.NoOfRounds = NoOfRounds;
    }

    /**
     * @return the CurrentRounds
     */
    public int getCurrentRounds() {
        return CurrentRounds;
    }

    /**
     * @param CurrentRounds the CurrentRounds to set
     */
    public void setCurrentRounds(int CurrentRounds) {
        this.CurrentRounds = CurrentRounds;
    }

    /**
     * @return the GameLeaderPoint
     */
    public int getGameLeaderPoint() {
        return GameLeaderPoint;
    }

    /**
     * @param GameLeaderPoint the GameLeaderPoint to set
     */
    public void setGameLeaderPoint(int GameLeaderPoint) {
        this.GameLeaderPoint = GameLeaderPoint;
    }

    /**
     * @return the GameLeaderId
     */
    public Long getGameLeaderId() {
        return GameLeaderId;
    }

    /**
     * @param GameLeaderId the GameLeaderId to set
     */
    public void setGameLeaderId(Long GameLeaderId) {
        this.GameLeaderId = GameLeaderId;
    }

    /**
     * @return the GamePlayers
     */
    public Set<GamePlayer> getGamePlayers() {
        return GamePlayers;
    }

    /**
     * @param GamePlayers the GamePlayers to set
     */
    public void setGamePlayers(Set<GamePlayer> GamePlayers) {
        this.GamePlayers = GamePlayers;
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
     * @return the GameRounds
     */
    public Set<GameRound> getGameRounds() {
        return GameRounds;
    }

    /**
     * @param GameRounds the GameRounds to set
     */
    public void setGameRounds(Set<GameRound> GameRounds) {
        this.GameRounds = GameRounds;
    }

    /**
     * @return the GameCompany
     */
    public Set<GameCompany> getGameCompany() {
        return GameCompany;
    }

    /**
     * @param GameCompany the GameCompany to set
     */
    public void setGameCompany(Set<GameCompany> GameCompany) {
        this.GameCompany = GameCompany;
    }

}
