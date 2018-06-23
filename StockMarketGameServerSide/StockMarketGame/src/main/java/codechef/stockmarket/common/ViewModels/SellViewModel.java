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
public class SellViewModel {
    private Long id;
    
    private int gameCompanyId;

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
     * @return the gameCompanyId
     */
    public int getGameCompanyId() {
        return gameCompanyId;
    }

    /**
     * @param gameCompanyId the gameCompanyId to set
     */
    public void setGameCompanyId(int gameCompanyId) {
        this.gameCompanyId = gameCompanyId;
    }
}
