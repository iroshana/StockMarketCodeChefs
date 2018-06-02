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
public class Round {

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
     * @return the RoundLeaderPoint
     */
    public int getRoundLeaderPoint() {
        return RoundLeaderPoint;
    }

    /**
     * @param RoundLeaderPoint the RoundLeaderPoint to set
     */
    public void setRoundLeaderPoint(int RoundLeaderPoint) {
        this.RoundLeaderPoint = RoundLeaderPoint;
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
     * @return the RoundNo
     */
    public int getRoundNo() {
        return RoundNo;
    }

    /**
     * @param RoundNo the RoundNo to set
     */
    public void setRoundNo(int RoundNo) {
        this.RoundNo = RoundNo;
    }

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "RoundNo")
    private int RoundNo;

    @OneToOne(mappedBy="Round")
    private GameRound GameRound;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn (name="LeaderId")
    private Player Player;
    
    @Column(name = "RoundLeaderPoint")
    private int RoundLeaderPoint;
}
