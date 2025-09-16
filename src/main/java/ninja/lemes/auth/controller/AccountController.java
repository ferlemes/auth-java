package ninja.lemes.auth.controller;

import ninja.lemes.auth.exception.InvalidAccountException;
import ninja.lemes.auth.model.Account;
import ninja.lemes.auth.repository.AccountRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountRepository repository;

    public AccountController(final AccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Account> list() {
        return repository.findAll();
    }

    @PostMapping
    public Account create(@RequestBody final Account account) {
        if (account.getLogin() != null && repository.findByLogin(account.getLogin()).isPresent()) {
            throw new InvalidAccountException("Login already exists.");
        }
        try {
            return repository.save(account);
        } catch (DataIntegrityViolationException e) {
            throw new InvalidAccountException("Error creating account.");
        }
    }

    @GetMapping("/{id}")
    public Account retrieve(@PathVariable final String id) {
        return repository.findById(UUID.fromString(id)).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final String id) {
        repository.deleteById(UUID.fromString(id));
    }

}
