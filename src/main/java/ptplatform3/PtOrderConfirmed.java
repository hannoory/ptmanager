
package ptplatform3;

public class PtOrderConfirmed extends AbstractEvent {

    private Long id;
    private Long PtOrderId;
    private Long PtTrainerId;
    private String Status;
    private Long TrainerId;
    private String TrainerName;

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
    public Long getTrainerId() {
        return TrainerId;
    }

    public void setTrainerId(Long TrainerId) {
        this.TrainerId = TrainerId;
    }
    public String getTrainerName() {
        return TrainerName;
    }

    public void setTrainerName(String TrainerName) {
        this.TrainerName = TrainerName;
    }
}
