/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.common.ViewModels;

/**
 *
 * @author thari
 */
public class GameStartViewModel {
    private Long id;
    
    private Long bankId;
    
    private Long brokerId;
    
    private Long playerId;
    
    private Double bankBalance;

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
     * @return the bankId
     */
    public Long getBankId() {
        return bankId;
    }

    /**
     * @param bankId the bankId to set
     */
    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    /**
     * @return the brokerId
     */
    public Long getBrokerId() {
        return brokerId;
    }

    /**
     * @param brokerId the brokerId to set
     */
    public void setBrokerId(Long brokerId) {
        this.brokerId = brokerId;
    }

    /**
     * @return the playerId
     */
    public Long getPlayerId() {
        return playerId;
    }

    /**
     * @param playerId the playerId to set
     */
    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    /**
     * @return the bankBalance
     */
    public Double getBankBalance() {
        return bankBalance;
    }

    /**
     * @param bankBalance the bankBalance to set
     */
    public void setBankBalance(Double bankBalance) {
        this.bankBalance = bankBalance;
    }
}
