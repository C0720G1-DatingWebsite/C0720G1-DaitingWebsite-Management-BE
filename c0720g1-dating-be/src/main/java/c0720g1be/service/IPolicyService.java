package c0720g1be.service;

import c0720g1be.dto.IPolicyDTO;
import c0720g1be.entity.Policy;
import c0720g1be.entity.Status;

import java.util.List;

public interface IPolicyService {

    /**
     * Võ Thành Tín
     * Get All Policy
     *
     */
    List<IPolicyDTO> getAllPolicy();
}
