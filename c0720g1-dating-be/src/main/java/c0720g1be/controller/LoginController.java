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
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PhuocTC
 **/

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

    /**
     * PhuocTC
     **/
    @PostMapping("/login")
    public ResponseEntity<?>authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
        System.out.println(RandomString.make(64));
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
                        account.getEnable(),
                        roleList),
                HttpStatus.OK);
    }


    /**
     * PhuocTC
     **/
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
                        account.getEnable(),
                        roleList),
                HttpStatus.OK);
    }


    /**
     * PhuocTC
     **/
    @PostMapping("/login-google")
    public ResponseEntity<?>authenticateForGoogle(@RequestBody Account accountTemp) {

        if (accountService.findByUsername(accountTemp.getUserName()) == null) {
            accountTemp.setEnable(true);
            accountTemp.setPassword("");
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
                        account.getEnable(),
                        roleList),
                HttpStatus.OK);
    }


    /**
     * PhuocTC
     **/
    @GetMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestParam String username) throws UnsupportedEncodingException, MessagingException {
        Account account = accountService.findByEmail(username);

        if (account != null) {

            String code = RandomString.make(64);

            while (accountService.findByVetifyCode(code) != null) {
                code = RandomString.make(64);
            }

            account.setVetifyCode(code);
            accountService.registerAccount(account);

            accountService.sendMailForgotPassword(account);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * PhuocTC
     **/
    @GetMapping("/changed-password")
    public ResponseEntity<?> changedPassword(@RequestParam String newPassword,
                                             @RequestParam String vetifyCode) {
        Account account = accountService.findByVetifyCode(vetifyCode);

        if (account != null) {
            account.setPassword(newPassword);
            accountService.registerAccount(account);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/check-vetify-password")
    public ResponseEntity<?> checkChangedPassword(@RequestParam String vetifyCode) {
        if (accountService.findByVetifyCode(vetifyCode) != null) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
