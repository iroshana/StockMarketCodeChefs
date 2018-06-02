/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.entity;

import javax.persistence.*;

/**
 *
 * @author thari
 */

@Entity
public class GamePlayer {

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
        return HighScore;
    }

    /**
     * @param HighScore the HighScore to set
     */
    public void setHighScore(double HighScore) {
        this.HighScore = HighScore;
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
    private Long Id;
   
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn (name="GameId")
    private Game Game;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn (name="PlayerId")
    private Player Player;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn (name="BankId")
    private Bank Bank;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn (name="BrokerId")
    private Broker Broker;
    
    @Column(name = "Bankbalance")
    private double BankBalance;
    
    @Column(name = "HighScore")
    private double HighScore;
    
    @Column(name = "TotalPurchase")
    private double TotalPurchase;
    
    @Column(name = "TotalSales")
    private double TotalSales;
    
}
