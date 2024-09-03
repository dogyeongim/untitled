package untitled.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.RoomApplication;
import untitled.domain.Deleted;
import untitled.domain.Registered;
import untitled.domain.Updated;

@Entity
@Table(name = "Room_table")
@Data
//<<< DDD / Aggregate Root
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Integer price;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Registered registered = new Registered(this);
        registered.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        Updated updated = new Updated(this);
        updated.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        Deleted deleted = new Deleted(this);
        deleted.publishAfterCommit();
    }

    public static RoomRepository repository() {
        RoomRepository roomRepository = RoomApplication.applicationContext.getBean(
            RoomRepository.class
        );
        return roomRepository;
    }
}
//>>> DDD / Aggregate Root
