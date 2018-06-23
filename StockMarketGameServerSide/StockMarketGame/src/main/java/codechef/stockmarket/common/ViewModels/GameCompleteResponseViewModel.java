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
public class GameCompleteResponseViewModel {
    private Long gameId;
    private Long gameRoundId;
    private Long gamePlayerId;
    private Long gameRoundPlayerId;
    private Long roundId;
    private int roundNo;
    private String gameLeaderName;
    private double gameHighScore;
    private double myRoundScore;
    private boolean isGameWinner;
    private boolean isRoundWinner;

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
     * @return the gameLeaderName
     */
    public String getGameLeaderName() {
        return gameLeaderName;
    }

    /**
     * @param gameLeaderName the gameLeaderName to set
     */
    public void setGameLeaderName(String gameLeaderName) {
        this.gameLeaderName = gameLeaderName;
    }

    /**
     * @return the gameHighScore
     */
    public double getGameHighScore() {
        return gameHighScore;
    }

    /**
     * @param gameHighScore the gameHighScore to set
     */
    public void setGameHighScore(double gameHighScore) {
        this.gameHighScore = gameHighScore;
    }

    /**
     * @return the myRoundScore
     */
    public double getMyRoundScore() {
        return myRoundScore;
    }

    /**
     * @param myRoundScore the myRoundScore to set
     */
    public void setMyRoundScore(double myRoundScore) {
        this.myRoundScore = myRoundScore;
    }

    /**
     * @return the isGameWinner
     */
    public boolean isIsGameWinner() {
        return isGameWinner;
    }

    /**
     * @param isGameWinner the isGameWinner to set
     */
    public void setIsGameWinner(boolean isGameWinner) {
        this.isGameWinner = isGameWinner;
    }

    /**
     * @return the isRoundWinner
     */
    public boolean isIsRoundWinner() {
        return isRoundWinner;
    }

    /**
     * @param isRoundWinner the isRoundWinner to set
     */
    public void setIsRoundWinner(boolean isRoundWinner) {
        this.isRoundWinner = isRoundWinner;
    }
}
