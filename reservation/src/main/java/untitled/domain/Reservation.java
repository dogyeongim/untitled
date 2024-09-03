package untitled.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.ReservationApplication;
import untitled.domain.Canceled;
import untitled.domain.Reserved;

@Entity
@Table(name = "Reservation_table")
@Data
//<<< DDD / Aggregate Root
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private Long roomId;

    private Date date;

    private Integer price;

    @PostPersist
    public void onPostPersist() {
        Reserved reserved = new Reserved(this);
        reserved.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        Canceled canceled = new Canceled(this);
        canceled.publishAfterCommit();
    }

    public static ReservationRepository repository() {
        ReservationRepository reservationRepository = ReservationApplication.applicationContext.getBean(
            ReservationRepository.class
        );
        return reservationRepository;
    }
}
//>>> DDD / Aggregate Root
