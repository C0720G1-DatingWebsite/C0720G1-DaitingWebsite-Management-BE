package c0720g1be.controller;

import c0720g1be.dto.JwtRequest;
import c0720g1be.dto.JwtResponse;
import c0720g1be.entity.Account;
import c0720g1be.entity.AccountRole;
import c0720g1be.entity.Role;
import c0720g1be.jwt.JwtUtility;
import c0720g1be.service.AccountRoleService;
import c0720g1be.service.AccountService;
import c0720g1be.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRoleService accountRoleService;

    @PostMapping("/login")
    public ResponseEntity<?>authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        Account account = accountService.findByUsername(jwtRequest.getUsername());

        if (!account.getEnable()) {
            return new ResponseEntity<>("Tài khoản của bạn đã bị khóa", HttpStatus.OK);
        }

        List<AccountRole> accountRoleList = accountRoleService.findAllByAccount(account);

        Map<Integer, String> roleList = new HashMap<>();
        for (AccountRole accountRole : accountRoleList) {
            roleList.put(accountRole.getRole().getId(), accountRole.getRole().getName());
        }


        final String token = jwtUtility.generateToken(userService.loadUserByUsername(jwtRequest.getUsername()));

        return new ResponseEntity<>(
                new JwtResponse(
                        token,
                        account.getId(),
                        account.getUserName(),
                        account.getAvatar(),
                        roleList),
                HttpStatus.OK);
    }

    @PostMapping("/login-facebook")
    public ResponseEntity<?>authenticateForFacebook(@RequestBody Account accountTemp) {

        if (accountService.findByUsername(accountTemp.getUserName()) == null) {
            accountTemp.setEnable(true);
            accountTemp = accountService.registerAccount(accountTemp);

            Role role = new Role();
            role.setId(2);
            role.setName("ROLE_USER");

            AccountRole accountRole = new AccountRole();
            accountRole.setAccount(accountTemp);
            accountRole.setRole(role);

            accountRoleService.addRoleForAccount(accountRole);
        }

        Account account = accountService.findByUsername(accountTemp.getUserName());

        if (!account.getEnable()) {
            return new ResponseEntity<>("Tài khoản của bạn đã bị khóa", HttpStatus.OK);
        }

        List<AccountRole> accountRoleList = accountRoleService.findAllByAccount(account);

        Map<Integer, String> roleList = new HashMap<>();
        for (AccountRole accountRole : accountRoleList) {
            roleList.put(accountRole.getRole().getId(), accountRole.getRole().getName());
        }


        final String token = jwtUtility.generateToken(userService.loadUserByUsername(accountTemp.getUserName()));

        return new ResponseEntity<>(
                new JwtResponse(
                        token,
                        account.getId(),
                        account.getUserName(),
                        account.getAvatar(),
                        roleList),
                HttpStatus.OK);
    }

    @PostMapping("/login-google")
    public ResponseEntity<?>authenticateForGoogle(@RequestBody Account accountTemp) {

        if (accountService.findByUsername(accountTemp.getUserName()) == null) {
            accountTemp.setEnable(true);
            accountTemp = accountService.registerAccount(accountTemp);

            Role role = new Role();
            role.setId(2);
            role.setName("ROLE_USER");

            AccountRole accountRole = new AccountRole();
            accountRole.setAccount(accountTemp);
            accountRole.setRole(role);

            accountRoleService.addRoleForAccount(accountRole);
        }


        Account account = accountService.findByUsername(accountTemp.getUserName());

        if (!account.getEnable()) {
            return new ResponseEntity<>("Tài khoản của bạn đã bị khóa", HttpStatus.OK);
        }

        List<AccountRole> accountRoleList = accountRoleService.findAllByAccount(account);

        Map<Integer, String> roleList = new HashMap<>();
        for (AccountRole accountRole : accountRoleList) {
            roleList.put(accountRole.getRole().getId(), accountRole.getRole().getName());
        }


        final String token = jwtUtility.generateToken(userService.loadUserByUsername(accountTemp.getUserName()));

        return new ResponseEntity<>(
                new JwtResponse(
                        token,
                        account.getId(),
                        account.getUserName(),
                        account.getAvatar(),
                        roleList),
                HttpStatus.OK);
    }
}
