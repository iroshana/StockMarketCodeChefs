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
public class RoundViewModel {
    private Long Id;
    private int No;
    private Long leaderId;
    private int leaderpoint;
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
     * @return the No
     */
    public int getNo() {
        return No;
    }

    /**
     * @param No the No to set
     */
    public void setNo(int No) {
        this.No = No;
    }

    /**
     * @return the leaderId
     */
    public Long getLeaderId() {
        return leaderId;
    }

    /**
     * @param leaderId the leaderId to set
     */
    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    /**
     * @return the leaderpoint
     */
    public int getLeaderpoint() {
        return leaderpoint;
    }

    /**
     * @param leaderpoint the leaderpoint to set
     */
    public void setLeaderpoint(int leaderpoint) {
        this.leaderpoint = leaderpoint;
    }
}
