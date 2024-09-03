package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import untitled.infra.AbstractEvent;

@Data
public class Reserved extends AbstractEvent {

    private Long id;
    private Long roomId;
    private String customerName;
    private String customerNumber;
    private String customerId;
    private Date date;
}
