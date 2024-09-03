package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Canceled extends AbstractEvent {

    private Long id;
    private Long roomId;
    private String customerName;
    private String customerNumber;
    private String status;
    private String customerId;
    private Date date;

    public Canceled(Reservation aggregate) {
        super(aggregate);
    }

    public Canceled() {
        super();
    }
}
//>>> DDD / Domain Event
