package t1808a.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import t1808a.enitty.Accounts;

public interface AccountRepository extends JpaRepository<Accounts, Integer>, JpaSpecificationExecutor<Accounts> {
}
