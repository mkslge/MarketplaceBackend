package org.example.marketplacebackend.Repositories;

import org.example.marketplacebackend.Models.Account;
import org.example.marketplacebackend.Models.SessionID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

    @Query("{'sessionID.hashedSessionID': ?0}")
    boolean existsBySessionID(String hashedSessionID);

    @Query("{'sessionID.hashedSessionID': ?0, 'sessionID.expiryTime': {$gt: ?1}}")
    boolean existsBySessionIDAndNotExpired(String hashedSessionID, Date now);

    Account findByEmail(String email);
}
