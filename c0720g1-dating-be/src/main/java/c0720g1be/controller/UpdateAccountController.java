package c0720g1be.controller;

import c0720g1be.dto.AccountWallDTO;
import c0720g1be.entity.*;
import c0720g1be.service.AccountService;
import c0720g1be.service.UpdateAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UpdateAccountController {
    @Autowired
    UpdateAccountService updateAccountService;
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public ResponseEntity<List<City>> listCity() {
        List<City> cityList = updateAccountService.listCity();
        if (cityList.isEmpty()) {
            return new ResponseEntity<List<City>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<City>>(cityList, HttpStatus.OK);
    }

    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public ResponseEntity<List<Country>> listCountry() {
        List<Country> countryList = updateAccountService.listCountry();
        if (countryList.isEmpty()) {
            return new ResponseEntity<List<Country>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Country>>(countryList, HttpStatus.OK);
    }

    @RequestMapping(value = "/job", method = RequestMethod.GET)
    public ResponseEntity<List<Job>> listJob() {
        List<Job> jobList = updateAccountService.listJob();
        if (jobList.isEmpty()) {
            return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Job>>(jobList, HttpStatus.OK);
    }
    @RequestMapping(value = "/marital-status", method = RequestMethod.GET)
    public ResponseEntity<List<MaritalStatus>> listMaritalStatus() {
        List<MaritalStatus> maritalStatusList = updateAccountService.listMaritalStatus();
        if (maritalStatusList.isEmpty()) {
            return new ResponseEntity<List<MaritalStatus>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<MaritalStatus>>(maritalStatusList, HttpStatus.OK);
    }

    @RequestMapping(value = "/update-account/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Account> updateAccount(@PathVariable("id") Integer id, @RequestBody AccountWallDTO accountWallDTO) {
        Account currentComment = accountService.findById(id);
        if (currentComment == null) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
        updateAccountService.updateInformation(accountWallDTO);
        return new ResponseEntity<Account>(currentComment, HttpStatus.OK);
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> findAccountById(@PathVariable("id") Integer id) {
        Account account = accountService.findById(id);
        if (account == null) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }
}
