package t1808a.enitty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int account_id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "accountsSet")
    private Set<Roles> rolesSet;


    public Accounts(int account_id, String name) {
        this.account_id = account_id;
        this.name = name;
    }

    public Accounts() {
    }


    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Roles> getRolesSet() {
        return rolesSet;
    }

    public void setRolesSet(Set<Roles> rolesSet) {
        this.rolesSet = rolesSet;
    }
}
