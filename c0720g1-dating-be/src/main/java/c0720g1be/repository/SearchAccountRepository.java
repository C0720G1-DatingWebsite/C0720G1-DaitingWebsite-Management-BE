package c0720g1be.repository;


import c0720g1be.dto.SearchAccountDTO;
import c0720g1be.entity.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SearchAccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List searchCustomMembers (String query) {
        Query q = entityManager.createNativeQuery(query);
        return q.getResultList();
    }
}
