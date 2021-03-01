package c0720g1be.dto;

public class ReportMemberDTO {
    String dateReport;
    String reportContent;
    String accountVictim;
    String accountTarget;

    public ReportMemberDTO() {
    }

    public String getDateReport() {
        return dateReport;
    }

    public void setDateReport(String dateReport) {
        this.dateReport = dateReport;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public String getAccountVictim() {
        return accountVictim;
    }

    public void setAccountVictim(String accountVictim) {
        this.accountVictim = accountVictim;
    }

    public String getAccountTarget() {
        return accountTarget;
    }

    public void setAccountTarget(String accountTarget) {
        this.accountTarget = accountTarget;
    }
}
