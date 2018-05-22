package codechef.stockmarket.entity;

import javax.persistence.*;

@Entity
public class Test {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "UserName")
    private String userNAme;

    @Column(name = "Password")
    private String password;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUserNAme() {
        return userNAme;
    }

    public void setUserNAme(String userNAme) {
        this.userNAme = userNAme;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
