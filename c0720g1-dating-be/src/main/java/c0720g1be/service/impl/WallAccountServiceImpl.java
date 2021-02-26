package c0720g1be.service.impl;

import c0720g1be.entity.Account;
import c0720g1be.repository.WallAccountRepository;
import c0720g1be.service.WallAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WallAccountServiceImpl implements WallAccountService {
    @Autowired
    WallAccountRepository wallAccountRepository;
    @Override
    public Account findByIdAccount(Integer id) {
        return wallAccountRepository.findByIdAccount(id);
    }
}
