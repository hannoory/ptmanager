package ptplatform3;

import javax.persistence.*;

import org.springframework.beans.BeanUtils;
import ptplatform3.external.PttrainerService;


import java.util.List;

@Entity
@Table(name="Ptmanager_table")
public class Ptmanager {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long ptOrderId;
    private Long ptTrainerId;
    private String status;
    private Long trainerId;
    private String trainerName;

    @PostPersist
    public void onPostPersist(){
        if(this.getStatus().equals("ORDER_ACCEPTED")){
            System.out.println("[HNR_DEBUG] ##################################");
            System.out.println("[HNR_DEBUG] ######### ORDER_ACCEPTED #########");
            System.out.println("[HNR_DEBUG] ##################################");
            PtOrderAccepted ptOrderAccepted = new PtOrderAccepted();
            BeanUtils.copyProperties(this, ptOrderAccepted);
            ptOrderAccepted.publishAfterCommit();
        }
    }

    @PostUpdate
    public void onPostUpdate(){
        try {
            if(this.getStatus().equals("ORDER_CONFIRMED")) {
                System.out.println("[HNR_DEBUG] ###################################");
                System.out.println("[HNR_DEBUG] ######### ORDER_CONFIRMED #########");
                System.out.println("[HNR_DEBUG] ###################################");
                PtOrderConfirmed ptOrderConfirmed = new PtOrderConfirmed();
                BeanUtils.copyProperties(this, ptOrderConfirmed);
                ptOrderConfirmed.publishAfterCommit();
            } else if(this.getStatus().equals("ORDER_CANCEL_ACCEPTED")) {
                // PUB-SUB 수강취소됨 (ORDER_CANCELED)
                System.out.println("[HNR_DEBUG] ###################################################");
                System.out.println("[HNR_DEBUG] ######### ORDER_CANCEL_ACCEPTED (PUB/SUB) #########");
                System.out.println("[HNR_DEBUG] ###################################################");
                PtOrderCancelAccepted ptOrderCancelAccepted = new PtOrderCancelAccepted();
                BeanUtils.copyProperties(this, ptOrderCancelAccepted);
                ptOrderCancelAccepted.publishAfterCommit();

                // REQ-RES 강사스케줄 취소
                System.out.println("[HNR_DEBUG] ###################################################");
                System.out.println("[HNR_DEBUG] ######### ORDER_CANCEL_ACCEPTED (REQ/RES) #########");
                System.out.println("[HNR_DEBUG] ###################################################");
    //            //Following code causes dependency to external APIs
    //            // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.
    //            ptplatform3.external.Pttrainer pttrainer = new ptplatform3.external.Pttrainer();
    //            // mappings goes here
    //            PtmanagerApplication.applicationContext.getBean(ptplatform3.external.PttrainerService.class)
    //                    .ptScheduleCancellation(pttrainer);
                System.out.println("[HNR_DEBUG] getPtOrderId() : " + getPtOrderId());
                PttrainerService pttrainerService = PtmanagerApplication.applicationContext.getBean(PttrainerService.class);
                pttrainerService.ptScheduleCancellation(getPtOrderId(), "SCHEDULE_CANCELED");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


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
    public Long getPtTrainerId() {
        return ptTrainerId;
    }

    public void setPtTrainerId(Long ptTrainerId) {
        this.ptTrainerId = ptTrainerId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }
    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }




}
