/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.common.ViewModels;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author thari
 */
public class GameViewModel {
    private Long id;
    
    private int noOfPlayers;
    
    private int noOfRounds;
    
    private int currentRounds;
    
    private double gameLeaderPoint;
    
    private Long gameLeaderId;
    
    private Set<CompanyViewModel> gameCompany;
    
    private Set<RoundViewModel> gameRound;
    
    private Set<PlayerViewModel> gamePlayer;
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the noOfPlayers
     */
    public int getNoOfPlayers() {
        return noOfPlayers;
    }

    /**
     * @param noOfPlayers the noOfPlayers to set
     */
    public void setNoOfPlayers(int noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
    }

    /**
     * @return the noOfRounds
     */
    public int getNoOfRounds() {
        return noOfRounds;
    }

    /**
     * @param noOfRounds the noOfRounds to set
     */
    public void setNoOfRounds(int noOfRounds) {
        this.noOfRounds = noOfRounds;
    }

    /**
     * @return the currentRounds
     */
    public int getCurrentRounds() {
        return currentRounds;
    }

    /**
     * @param currentRounds the currentRounds to set
     */
    public void setCurrentRounds(int currentRounds) {
        this.currentRounds = currentRounds;
    }

    /**
     * @return the gameLeaderPoint
     */
    public Double getGameLeaderPoint() {
        return gameLeaderPoint;
    }

    /**
     * @param gameLeaderPoint the gameLeaderPoint to set
     */
    public void setGameLeaderPoint(Double gameLeaderPoint) {
        this.gameLeaderPoint = gameLeaderPoint;
    }

    /**
     * @return the gameLeaderId
     */
    public Long getGameLeaderId() {
        return gameLeaderId;
    }

    /**
     * @param gameLeaderId the gameLeaderId to set
     */
    public void setGameLeaderId(Long gameLeaderId) {
        this.gameLeaderId = gameLeaderId;
    }

    /**
     * @return the gameCompany
     */
    public Set<CompanyViewModel> getGameCompany() {
        return gameCompany;
    }

    /**
     * @param gameCompany the gameCompany to set
     */
    public void setGameCompany(Set<CompanyViewModel> gameCompany) {
        this.gameCompany = gameCompany;
    }

    /**
     * @return the gameRound
     */
    public Set<RoundViewModel> getGameRound() {
        return gameRound;
    }

    /**
     * @param gameRound the gameRound to set
     */
    public void setGameRound(Set<RoundViewModel> gameRound) {
        this.gameRound = gameRound;
    }

    /**
     * @return the gamePlayer
     */
    public Set<PlayerViewModel> getGamePlayer() {
        return gamePlayer;
    }

    /**
     * @param gamePlayer the gamePlayer to set
     */
    public void setGamePlayer(Set<PlayerViewModel> gamePlayer) {
        this.gamePlayer = gamePlayer;
    }
}
