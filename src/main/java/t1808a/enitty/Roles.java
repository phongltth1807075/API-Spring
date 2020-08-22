package t1808a.enitty;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;
    private String role_Name;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_account",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id"))
    private Set<Accounts> accountsSet;

    public Roles(int role_id, String role_Name) {
        this.role_id = role_id;
        this.role_Name = role_Name;
    }

    public Roles() {
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_Name() {
        return role_Name;
    }

    public void setRole_Name(String role_Name) {
        this.role_Name = role_Name;
    }

    public Set<Accounts> getAccountsSet() {
        return accountsSet;
    }

    public void setAccountsSet(Set<Accounts> accountsSet) {
        this.accountsSet = accountsSet;
    }
}
