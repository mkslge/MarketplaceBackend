package org.example.marketplacebackend.Repositories;

import org.example.marketplacebackend.Models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
    // Optional: add custom query methods here
    // Example:
    Account findByEmail(String email);
}
