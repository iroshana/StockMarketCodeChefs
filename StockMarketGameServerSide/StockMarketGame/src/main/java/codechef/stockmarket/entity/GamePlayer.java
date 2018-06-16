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
public class GamePlayer {

    /**
     * @return the WatchList
     */
    public Set<WatchList> getWatchList() {
        return WatchList;
    }

    /**
     * @param WatchList the WatchList to set
     */
    public void setWatchList(Set<WatchList> WatchList) {
        this.WatchList = WatchList;
    }

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
     * @return the Bank
     */
    public Bank getBank() {
        return Bank;
    }

    /**
     * @param Bank the Bank to set
     */
    public void setBank(Bank Bank) {
        this.Bank = Bank;
    }

    /**
     * @return the Broker
     */
    public Broker getBroker() {
        return Broker;
    }

    /**
     * @param Broker the Broker to set
     */
    public void setBroker(Broker Broker) {
        this.Broker = Broker;
    }

    /**
     * @return the BankBalance
     */
    public double getBankBalance() {
        return BankBalance;
    }

    /**
     * @param BankBalance the BankBalance to set
     */
    public void setBankBalance(double BankBalance) {
        this.BankBalance = BankBalance;
    }

    /**
     * @return the HighScore
     */
    public double getHighScore() {
        return getScore();
    }

    /**
     * @param HighScore the HighScore to set
     */
    public void setHighScore(double HighScore) {
        this.setScore(HighScore);
    }

    /**
     * @return the TotalPurchase
     */
    public double getTotalPurchase() {
        return TotalPurchase;
    }

    /**
     * @param TotalPurchase the TotalPurchase to set
     */
    public void setTotalPurchase(double TotalPurchase) {
        this.TotalPurchase = TotalPurchase;
    }

    /**
     * @return the TotalSales
     */
    public double getTotalSales() {
        return TotalSales;
    }

    /**
     * @param TotalSales the TotalSales to set
     */
    public void setTotalSales(double TotalSales) {
        this.TotalSales = TotalSales;
    }
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   
    @ManyToOne
    @JoinColumn (name="GameId")
    @JsonBackReference
    private Game Game;
    
    @ManyToOne
    @JoinColumn (name="PlayerId")
    @JsonBackReference
    private Player Player;
    
    @ManyToOne
    @JoinColumn (name="BankId")
    @JsonBackReference
    private Bank Bank;
    
    @ManyToOne
    @JoinColumn (name="BrokerId")
    @JsonBackReference
    private Broker Broker;
    
    @Column(name = "Bankbalance")
    private double BankBalance;
    
    @Column(name = "Score")
    private double Score;
    
    
    @Column(name = "TotalPurchase")
    private double TotalPurchase;
    
    @Column(name = "TotalSales")
    private double TotalSales;
    
    @OneToMany(mappedBy = "GamePlayer")
    private Set<PlayerPurchase> PlayerPurchase = new HashSet<PlayerPurchase>();

    @OneToMany(mappedBy = "GamePlayer")
    private Set<WatchList> WatchList = new HashSet<WatchList>();
    
    
    @OneToMany(mappedBy = "GamePlayer")
    private Set<PlayerTransactions> PlayerTransactions = new HashSet<PlayerTransactions>();
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
    
}
