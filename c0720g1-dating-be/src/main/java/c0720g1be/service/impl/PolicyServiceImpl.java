package c0720g1be.service.impl;

import c0720g1be.entity.Policy;
import c0720g1be.repository.PolicyRepository;
import c0720g1be.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {
    @Autowired
    private PolicyRepository policyRepository;
    @Override
    public List<Policy> findAllPolicy() {
        return policyRepository.findAll();
    }
}
