/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.entity;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author thari
 */
@Entity
public class Round {

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
        return roundNo;
    }

    /**
     * @param RoundNo the RoundNo to set
     */
    public void setRoundNo(int RoundNo) {
        this.roundNo = RoundNo;
    }

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "RoundNo")
    private int roundNo;

    @OneToMany(mappedBy = "Round")
    private Set<GameRound> GameRound = new HashSet<GameRound>();
    

    /**
     * @return the GameRound
     */
    public Set<GameRound> getGameRound() {
        return GameRound;
    }

    /**
     * @param GameRound the GameRound to set
     */
    public void setGameRound(Set<GameRound> GameRound) {
        this.GameRound = GameRound;
    }
}
