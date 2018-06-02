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
    private Long Id;
    
    @Column(name = "NoOfPlayers")
    private int NoOfPlayers;
    
    @Column(name = "NoOfRounds")
    private int NoOfRounds;
    
    @Column(name = "CurrentRounds")
    private int CurrentRounds;
    
    @Column(name = "GameLeaderPoint")
    private int GameLeaderPoint;
    @Column(name = "GameLeaderId")
    private int GameLeaderId;
    
    @OneToOne(mappedBy="Game")
    private GamePlayer GamePlayer;
    
    @OneToOne(mappedBy="Game")
    private PlayerTransactions PlayerTransactions;
    
    @OneToOne(mappedBy="Game")
    private GameRound GameRound;
    
    @OneToOne(mappedBy="Game")
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
    public int getGameLeaderId() {
        return GameLeaderId;
    }

    /**
     * @param GameLeaderId the GameLeaderId to set
     */
    public void setGameLeaderId(int GameLeaderId) {
        this.GameLeaderId = GameLeaderId;
    }

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
     * @return the PlayerTransactions
     */
    public PlayerTransactions getPlayerTransactions() {
        return PlayerTransactions;
    }

    /**
     * @param PlayerTransactions the PlayerTransactions to set
     */
    public void setPlayerTransactions(PlayerTransactions PlayerTransactions) {
        this.PlayerTransactions = PlayerTransactions;
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
    public void setGameCompany(GameCompany GameCompany) {
        this.GameCompany = GameCompany;
    }

}
