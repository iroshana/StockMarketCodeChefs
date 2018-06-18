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
public class PurchaseViewModel {
    private Long gameCompanyId;
    private Long gamePlayerId;
    private Long bankId;
    private Long gameRoundId;
    private double shareValue;
    private int noOFShares;

    /**
     * @return the gameCompanyId
     */
    public Long getGameCompanyId() {
        return gameCompanyId;
    }

    /**
     * @param gameCompanyId the gameCompanyId to set
     */
    public void setGameCompanyId(Long gameCompanyId) {
        this.gameCompanyId = gameCompanyId;
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
     * @return the gameRoundId
     */
    public Long getGameRoundId() {
        return gameRoundId;
    }

    /**
     * @param gameRoundId the gameRoundId to set
     */
    public void setGameRoundId(Long gameRoundId) {
        this.gameRoundId = gameRoundId;
    }
}
