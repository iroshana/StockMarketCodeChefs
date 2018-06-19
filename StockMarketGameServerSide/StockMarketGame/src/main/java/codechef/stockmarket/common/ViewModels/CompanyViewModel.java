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
public class CompanyViewModel {
    private Long companyId;
    private String name;
    private double shareValue;
    private int noOFShares;
    private Long gamePlayerId;
    /**
     * @return the Id
     */
    public Long getId() {
        return companyId;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Long Id) {
        this.companyId = Id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the shareValue
     */
    public double getShareValue() {
        return shareValue;
    }

    /**
     * @param shareValue the shareValue to set
     */
    public void setShareValue(double shareValue) {
        this.shareValue = shareValue;
    }

    /**
     * @return the noOFShares
     */
    public int getNoOFShares() {
        return noOFShares;
    }

    /**
     * @param noOFShares the noOFShares to set
     */
    public void setNoOFShares(int noOFShares) {
        this.noOFShares = noOFShares;
    }

    /**
     * @return the gamePlayerId
     */
    public Long getGamePlayerId() {
        return gamePlayerId;
    }

    /**
     * @param gamePlayerId the gamePlayerId to set
     */
    public void setGamePlayerId(Long gamePlayerId) {
        this.gamePlayerId = gamePlayerId;
    }
}
