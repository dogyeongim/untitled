package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import untitled.infra.AbstractEvent;

@Data
public class Canceled extends AbstractEvent {

    private Long id;
    private Long roomId;
    private String customerName;
    private String customerNumber;
    private String status;
    private String customerId;
    private Date date;
}
