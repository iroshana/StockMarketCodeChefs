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
public class GameRound {

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

    /**
     * @return the GameRoundPlayer
     */
    public GameRoundPlayer getGameRoundPlayer() {
        return GameRoundPlayer;
    }

    /**
     * @param GameRoundPlayer the GameRoundPlayer to set
     */
    public void setGameRoundPlayer(GameRoundPlayer GameRoundPlayer) {
        this.GameRoundPlayer = GameRoundPlayer;
    }

    /**
     * @return the PlayerPurchase
     */
    public PlayerPurchase getPlayerPurchase() {
        return PlayerPurchase;
    }

    /**
     * @param PlayerPurchase the PlayerPurchase to set
     */
    public void setPlayerPurchase(PlayerPurchase PlayerPurchase) {
        this.PlayerPurchase = PlayerPurchase;
    }
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn (name="GameId")
    private Game Game;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn (name="RoundId")
    private Round Round;
    
    @OneToOne(mappedBy="GameRound")
    private GameRoundPlayer GameRoundPlayer;
    
    @OneToOne(mappedBy="GameRound")
    private PlayerPurchase PlayerPurchase;
}
