package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ReviewCreated extends AbstractEvent {

    private Long id;
    private Long roomId;
    private Long customerId;
    private String content;

    public ReviewCreated(Review aggregate) {
        super(aggregate);
    }

    public ReviewCreated() {
        super();
    }
}
//>>> DDD / Domain Event
