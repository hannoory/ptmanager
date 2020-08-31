
package ptplatform3;

public class PtCancelOrdered extends AbstractEvent {

    private Long id;
    private Long PtManagerId;
    private Long PtTrainerId;
    private String Status;
    private Long PtClassId;
    private String PtClassName;
    private Long CustomerId;
    private String CustomerName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getPtManagerId() {
        return PtManagerId;
    }

    public void setPtManagerId(Long PtManagerId) {
        this.PtManagerId = PtManagerId;
    }
    public Long getPtTrainerId() {
        return PtTrainerId;
    }

    public void setPtTrainerId(Long PtTrainerId) {
        this.PtTrainerId = PtTrainerId;
    }
    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    public Long getPtClassId() {
        return PtClassId;
    }

    public void setPtClassId(Long PtClassId) {
        this.PtClassId = PtClassId;
    }
    public String getPtClassName() {
        return PtClassName;
    }

    public void setPtClassName(String PtClassName) {
        this.PtClassName = PtClassName;
    }
    public Long getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(Long CustomerId) {
        this.CustomerId = CustomerId;
    }
    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }
}
