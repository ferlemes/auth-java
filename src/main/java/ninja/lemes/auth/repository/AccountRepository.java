package ninja.lemes.auth.repository;

import ninja.lemes.auth.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    public Optional<Account> findByLogin(final String login);

}



