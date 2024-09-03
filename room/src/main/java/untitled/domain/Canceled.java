package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

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
}
