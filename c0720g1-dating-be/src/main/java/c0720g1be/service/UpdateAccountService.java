package c0720g1be.service;

import c0720g1be.dto.AccountWallDTO;
import c0720g1be.entity.City;
import c0720g1be.entity.Country;
import c0720g1be.entity.Job;
import c0720g1be.entity.MaritalStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UpdateAccountService {
    List<City> listCity();

    List<Country> listCountry();

    List<Job> listJob();

    List<MaritalStatus> listMaritalStatus();

    void updateInformation(AccountWallDTO accountWallDTO);
}
