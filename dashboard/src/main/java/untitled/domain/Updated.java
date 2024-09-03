package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import untitled.infra.AbstractEvent;

@Data
public class Updated extends AbstractEvent {

    private Long id;
    private String name;
    private String description;
    private Integer price;
    private String status;
}
