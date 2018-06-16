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
public class ResponseViewModel {
    private Long gameId;
    
    private Long gameRoundId;
    private Long gamePlayerId;
    private Long gameRoundPlayerId;
    private Long roundId;
    
    private int roundNo;
    /**
     * @return the gameId
     */
    public Long getGameId() {
        return gameId;
    }

    /**
     * @param gameId the gameId to set
     */
    public void setGameId(Long gameId) {
        this.gameId = gameId;
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

    /**
     * @return the roundId
     */
    public Long getRoundId() {
        return roundId;
    }

    /**
     * @param roundId the roundId to set
     */
    public void setRoundId(Long roundId) {
        this.roundId = roundId;
    }

    /**
     * @return the roundNo
     */
    public int getRoundNo() {
        return roundNo;
    }

    /**
     * @param roundNo the roundNo to set
     */
    public void setRoundNo(int roundNo) {
        this.roundNo = roundNo;
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
     * @return the gameRoundPlayerId
     */
    public Long getGameRoundPlayerId() {
        return gameRoundPlayerId;
    }

    /**
     * @param gameRoundPlayerId the gameRoundPlayerId to set
     */
    public void setGameRoundPlayerId(Long gameRoundPlayerId) {
        this.gameRoundPlayerId = gameRoundPlayerId;
    }
}
