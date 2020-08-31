package ptplatform3.external;

public class Pttrainer {

    private Long id;
    private Long ptOrderId;
    private Long ptManagerId;
    private String status;
    private String ptResult;
    private String ptClassDate;
    private Long ptTrainerId4Cancel;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getPtOrderId() {
        return ptOrderId;
    }
    public void setPtOrderId(Long ptOrderId) {
        this.ptOrderId = ptOrderId;
    }
    public Long getPtManagerId() {
        return ptManagerId;
    }
    public void setPtManagerId(Long ptManagerId) {
        this.ptManagerId = ptManagerId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getPtResult() {
        return ptResult;
    }
    public void setPtResult(String ptResult) {
        this.ptResult = ptResult;
    }
    public String getPtClassDate() {
        return ptClassDate;
    }
    public void setPtClassDate(String ptClassDate) {
        this.ptClassDate = ptClassDate;
    }
    public Long getPtTrainerId4Cancel() {
        return ptTrainerId4Cancel;
    }

    public void setPtTrainerId4Cancel(Long ptTrainerId4Cancel) {
        this.ptTrainerId4Cancel = ptTrainerId4Cancel;
    }
}
