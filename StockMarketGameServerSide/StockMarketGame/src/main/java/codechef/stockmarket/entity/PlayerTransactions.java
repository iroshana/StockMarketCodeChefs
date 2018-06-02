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
public class PlayerTransactions {

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
     * @return the Amount
     */
    public float getAmount() {
        return Amount;
    }

    /**
     * @param Amount the Amount to set
     */
    public void setAmount(float Amount) {
        this.Amount = Amount;
    }

    /**
     * @return the Time
     */
    public String getTime() {
        return Time;
    }

    /**
     * @param Time the Time to set
     */
    public void setTime(String Time) {
        this.Time = Time;
    }
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn (name="BankId")
    private Bank Bank;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn (name="RoundId")
    private Round Round;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn (name="GameId")
    private Game Game;
    
    @Column(name = "Amount")
    private float Amount;
     @Column(name = "Time")
    private String Time;
}
