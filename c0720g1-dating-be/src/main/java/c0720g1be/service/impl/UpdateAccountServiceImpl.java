package c0720g1be.service.impl;

import c0720g1be.dto.AccountWallDTO;
import c0720g1be.entity.City;
import c0720g1be.entity.Country;
import c0720g1be.entity.Job;
import c0720g1be.entity.MaritalStatus;
import c0720g1be.repository.*;
import c0720g1be.service.UpdateAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UpdateAccountServiceImpl implements UpdateAccountService {

    @Autowired
    CityRepository cityRepository;
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    JobRepository jobRepository;
    @Autowired
    MaritalStatusRepository maritalStatusRepository;
    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<City> listCity() {
        return cityRepository.listCity();
    }

    @Override
    public List<Country> listCountry() {
        return countryRepository.listCountry();
    }

    @Override
    public List<Job> listJob() {
        return jobRepository.listJob();
    }

    @Override
    public List<MaritalStatus> listMaritalStatus() {
        return maritalStatusRepository.listMaritalStatus();
    }

    @Override
    public void updateInformation(AccountWallDTO accountWallDTO) {
        accountRepository.updateAccount(
                accountWallDTO.getAccountDescribe(),
                accountWallDTO.getAddress(), accountWallDTO.getFullName(),
                accountWallDTO.getDateOfBirth(),accountWallDTO.getGender(),
                accountWallDTO.getCityId(), accountWallDTO.getCountryId(),
                accountWallDTO.getJobId(), accountWallDTO.getMaritalStatusId(),
                accountWallDTO.getEmail(), accountWallDTO.getAudience() ,accountWallDTO.getId());
    }
}
