package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Registered extends AbstractEvent {

    private Long id;
    private String name;
    private String description;
    private Integer price;

    public Registered(Room aggregate) {
        super(aggregate);
    }

    public Registered() {
        super();
    }
}
//>>> DDD / Domain Event
