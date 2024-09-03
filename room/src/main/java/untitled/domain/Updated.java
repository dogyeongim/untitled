package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Updated extends AbstractEvent {

    private Long id;
    private String name;
    private String description;
    private Integer price;
    private String status;

    public Updated(Room aggregate) {
        super(aggregate);
    }

    public Updated() {
        super();
    }
}
//>>> DDD / Domain Event
