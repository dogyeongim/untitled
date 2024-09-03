package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentApproved extends AbstractEvent {

    private Long id;
    private Long reservationId;
    private String customerId;
    private Integer price;

    public PaymentApproved(Payment aggregate) {
        super(aggregate);
    }

    public PaymentApproved() {
        super();
    }
}
//>>> DDD / Domain Event
