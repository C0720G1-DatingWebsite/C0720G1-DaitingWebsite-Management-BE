package c0720g1be.service.impl;

import c0720g1be.entity.Status;
import c0720g1be.repository.StatusUpdatePostRepository;
import c0720g1be.service.IStatusUpdatePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusUpdatePostServiceImpl implements IStatusUpdatePostService {

    @Autowired
    StatusUpdatePostRepository statusUpdatePostRepository;

    /**
     * Võ Thành Tín
     * Get All Status
     *
     */
    @Override
    public List<Status> getAllStatus() {
        return statusUpdatePostRepository.getAllStatus();
    }
}
