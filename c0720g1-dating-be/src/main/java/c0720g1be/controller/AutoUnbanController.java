package c0720g1be.controller;

import c0720g1be.service.MemberReportManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class AutoUnbanController {
    @Autowired
    private MemberReportManagementService memberReportManagementService;
    @Autowired
    private JavaMailSender emailSender;
    @Scheduled(cron = "0 00 00 * * ?")
    public void autoUnban(){
        memberReportManagementService.unlockAccount();
    }
}
