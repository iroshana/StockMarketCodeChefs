/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    
    @ManyToOne
    @JoinColumn (name="BankId")
    @JsonBackReference
    private Bank Bank;
    
    @ManyToOne
    @JoinColumn (name="GameRoundId")
    @JsonBackReference
    private GameRound GameRound;
    
    @ManyToOne
    @JoinColumn (name="GamePlayerId")
    @JsonBackReference
    private GamePlayer GamePlayer;
    
    @Column(name = "Amount")
    private float Amount;
    @Column(name = "Time")
    private String Time;

    @Column(name = "TransactionNo")
    private String TransactionNo;
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
     * @return the TransactionNo
     */
    public String getTransactionNo() {
        return TransactionNo;
    }

    /**
     * @param TransactionNo the TransactionNo to set
     */
    public void setTransactionNo(String TransactionNo) {
        this.TransactionNo = TransactionNo;
    }
}
