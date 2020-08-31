
package ptplatform3;

public class PtScheduleConfirmed extends AbstractEvent {

    private Long id;
    private Long PtOrderId;
    private Long PtManagerId;
    private String Status;
    private String PtResult;
    private String PtClassDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getPtOrderId() {
        return PtOrderId;
    }

    public void setPtOrderId(Long PtOrderId) {
        this.PtOrderId = PtOrderId;
    }
    public Long getPtManagerId() {
        return PtManagerId;
    }

    public void setPtManagerId(Long PtManagerId) {
        this.PtManagerId = PtManagerId;
    }
    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    public String getPtResult() {
        return PtResult;
    }

    public void setPtResult(String PtResult) {
        this.PtResult = PtResult;
    }
    public String getPtClassDate() {
        return PtClassDate;
    }

    public void setPtClassDate(String PtClassDate) {
        this.PtClassDate = PtClassDate;
    }
}
