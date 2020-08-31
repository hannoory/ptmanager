package ptplatform3;

import ptplatform3.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//HNR-START
import java.util.List;
import java.util.Optional;
//HNR--END-

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    //HNR-START
    @Autowired
    PtmanagerRepository ptmanagerRepository;
    //HNR--END-

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPtOrdered_PtOrderRequest(@Payload PtOrdered ptOrdered){

        // 고객이 수강신청시 강사 배정 및 수강신청 허용 상태(ORDER_ACCEPTED) 저장
        if(ptOrdered.isMe()){
            System.out.println("##### listener PtOrderRequest : " + ptOrdered.toJson());
            //HNR-START
            Ptmanager ptmanager = new Ptmanager();
            ptmanager.setPtOrderId(ptOrdered.getId());
            ptmanager.setStatus("ORDER_ACCEPTED");
            ptmanager.setTrainerId(ptOrdered.getId() + 2000);
            ptmanager.setTrainerName("Good_Trainer_" + ptOrdered.getId());
            ptmanagerRepository.save(ptmanager);
            //HNR--END-
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPtScheduleConfirmed_PtScheduleConfirmationNotify(@Payload PtScheduleConfirmed ptScheduleConfirmed){

        // PT수업 스케줄 확정시 해당 수강신청 확정 상태(ORDER_CONFIRMED) 저장
        if(ptScheduleConfirmed.isMe()){
            //HNR-START
            try {
                System.out.println("##### listener PtScheduleConfirmationNotify : " + ptScheduleConfirmed.toJson());
                ptmanagerRepository.findById(ptScheduleConfirmed.getPtOrderId())
                        .ifPresent(
                                ptmanager -> {
                                    ptmanager.setStatus("ORDER_CONFIRMED");
                                    ptmanager.setPtTrainerId(ptScheduleConfirmed.getId());
                                    ptmanagerRepository.save(ptmanager);
                                }
                        );
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Ptmanager ptmanager = new Ptmanager();
            //ptmanager.setStatus("ORDER_CONFIRMED");
            //ptmanager.setPtTrainerId(ptScheduleConfirmed.getId());

            //HNR--END-
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPtCancelOrdered_PtCancelOrderRequest(@Payload PtCancelOrdered ptCancelOrdered){

        //PT수강신청 취소 요청 허용(ORDER_CANCEL_ACCEPTED) 상태 저장
        if(ptCancelOrdered.isMe()){
            try {
                System.out.println("##### listener PtCancelOrderRequest : " + ptCancelOrdered.toJson());

                Optional<Ptmanager> pm = ptmanagerRepository.findById(ptCancelOrdered.getId());
                pm.get().setStatus("ORDER_CANCEL_ACCEPTED");
                ptmanagerRepository.save(pm.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
