package c0720g1be.service.impl;

import c0720g1be.entity.AccountGroup;
import c0720g1be.repository.AccountGroupRepository;
import c0720g1be.service.AccountGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountGroupImpl implements AccountGroupService {

    @Autowired
    private AccountGroupRepository accountGroupRepository;


    @Override
    public void save(int idUser, int idGroup) {
        this.accountGroupRepository.joinGroup(idUser, idGroup, 2);
    }
}
