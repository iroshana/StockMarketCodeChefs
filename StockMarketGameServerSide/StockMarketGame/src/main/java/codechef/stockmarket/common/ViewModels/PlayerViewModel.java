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
public class PlayerViewModel {
    private Long id;
    
    private String name;  
    
    private int rating;
    
    private String email;
    
    private String password;
    private String userName;
    /**
     * @return the Id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Long Id) {
        this.id = Id;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.name = Name;
    }

    /**
     * @return the Rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param Rating the Rating to set
     */
    public void setRating(int Rating) {
        this.rating = Rating;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.email = Email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
