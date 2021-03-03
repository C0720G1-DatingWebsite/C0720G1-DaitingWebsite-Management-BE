package c0720g1be.service.impl;

import c0720g1be.dto.IPolicyDTO;
import c0720g1be.entity.Policy;
import c0720g1be.entity.Status;
import c0720g1be.repository.PolicyRepository;
import c0720g1be.service.IPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements IPolicyService {

    @Autowired
    PolicyRepository policyRepository;

    /**
     * Võ Thành Tín
     * Get All Status
     *
     */
    @Override
    public List<IPolicyDTO> getAllPolicy() {
        return policyRepository.getAllPolicy();
    }
}
