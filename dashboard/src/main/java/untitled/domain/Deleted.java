package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import untitled.infra.AbstractEvent;

@Data
public class Deleted extends AbstractEvent {

    private Long id;
    private String hostName;
    private String hostNumber;
    private String Status;
}
