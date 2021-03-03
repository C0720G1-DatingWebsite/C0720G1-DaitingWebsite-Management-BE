package c0720g1be.service.impl;

import c0720g1be.entity.Policy;
import c0720g1be.repository.PolicyRepository;
import c0720g1be.dto.IPolicyDTO;
import c0720g1be.repository.PolicyRepository2;
import c0720g1be.service.IPolicyService;
import c0720g1be.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements IPolicyService, PolicyService {

    @Autowired
    PolicyRepository policyRepository;

    @Autowired
    PolicyRepository2 policyRepository2;

    /**
     * Võ Thành Tín
     * Get All Status
     *
     */
    @Override
    public List<IPolicyDTO> getAllPolicy() {
        return policyRepository.getAllPolicy();
    }

    @Override
    public List<Policy> findAllPolicy() {
        return policyRepository2.findAll();
    }
}
