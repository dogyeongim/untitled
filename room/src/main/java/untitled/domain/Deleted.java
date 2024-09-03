package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Deleted extends AbstractEvent {

    private Long id;
    private String hostName;
    private String hostNumber;
    private String status;

    public Deleted(Room aggregate) {
        super(aggregate);
    }

    public Deleted() {
        super();
    }
}
//>>> DDD / Domain Event
