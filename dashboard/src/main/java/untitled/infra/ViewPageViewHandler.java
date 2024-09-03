package untitled.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import untitled.config.kafka.KafkaProcessor;
import untitled.domain.*;

@Service
public class ViewPageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private ViewPageRepository viewPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRegistered_then_CREATE_1(@Payload Registered registered) {
        try {
            if (!registered.validate()) return;

            // view 객체 생성
            ViewPage viewPage = new ViewPage();
            // view 객체에 이벤트의 Value 를 set 함
            viewPage.setId(registered.getId());
            viewPage.setName(registered.getName());
            viewPage.setRoomStatus(active);
            viewPage.setDescription(registered.getDescription());
            viewPage.setPrice(registered.getPrice());
            // view 레파지 토리에 save
            viewPageRepository.save(viewPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenUpdated_then_UPDATE_1(@Payload Updated updated) {
        try {
            if (!updated.validate()) return;
            // view 객체 조회
            Optional<ViewPage> viewPageOptional = viewPageRepository.findById(
                updated.getId()
            );

            if (viewPageOptional.isPresent()) {
                ViewPage viewPage = viewPageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                viewPage.setName(updated.getName());
                viewPage.setDescription(updated.getDescription());
                viewPage.setPrice(updated.getPrice());
                // view 레파지 토리에 save
                viewPageRepository.save(viewPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeleted_then_UPDATE_2(@Payload Deleted deleted) {
        try {
            if (!deleted.validate()) return;
            // view 객체 조회
            Optional<ViewPage> viewPageOptional = viewPageRepository.findById(
                deleted.getId()
            );

            if (viewPageOptional.isPresent()) {
                ViewPage viewPage = viewPageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                viewPage.setRoomStatus(deleted);
                // view 레파지 토리에 save
                viewPageRepository.save(viewPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_UPDATE_3(@Payload Reserved reserved) {
        try {
            if (!reserved.validate()) return;
            // view 객체 조회
            Optional<ViewPage> viewPageOptional = viewPageRepository.findById(
                reserved.getRoomId()
            );

            if (viewPageOptional.isPresent()) {
                ViewPage viewPage = viewPageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                viewPage.setReservationStatus(reserved);
                // view 레파지 토리에 save
                viewPageRepository.save(viewPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCanceled_then_UPDATE_4(@Payload Canceled canceled) {
        try {
            if (!canceled.validate()) return;
            // view 객체 조회
            Optional<ViewPage> viewPageOptional = viewPageRepository.findById(
                canceled.getRoomId()
            );

            if (viewPageOptional.isPresent()) {
                ViewPage viewPage = viewPageOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                viewPage.setReservationStatus(canceled);
                // view 레파지 토리에 save
                viewPageRepository.save(viewPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
