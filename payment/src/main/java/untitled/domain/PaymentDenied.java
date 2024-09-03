package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentDenied extends AbstractEvent {

    private Long id;
    private Long reservationId;
    private String customerId;
    private Integer price;

    public PaymentDenied(Payment aggregate) {
        super(aggregate);
    }

    public PaymentDenied() {
        super();
    }
}
//>>> DDD / Domain Event
