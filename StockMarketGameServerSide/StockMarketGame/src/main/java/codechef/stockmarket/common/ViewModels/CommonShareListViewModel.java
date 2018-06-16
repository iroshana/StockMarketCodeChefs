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
public class CommonShareListViewModel {
    private Long companyId;
    private Long Id;
    private String name;
    private double shareValue;
    private int noOFShares;

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
     * @return the companyId
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId the companyId to set
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

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
}
