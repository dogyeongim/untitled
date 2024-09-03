package untitled.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.ReviewApplication;
import untitled.domain.ReviewCreated;

@Entity
@Table(name = "Review_table")
@Data
//<<< DDD / Aggregate Root
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long roomId;

    private Long customerId;

    private String content;

    @PostPersist
    public void onPostPersist() {
        ReviewCreated reviewCreated = new ReviewCreated(this);
        reviewCreated.publishAfterCommit();
    }

    public static ReviewRepository repository() {
        ReviewRepository reviewRepository = ReviewApplication.applicationContext.getBean(
            ReviewRepository.class
        );
        return reviewRepository;
    }
}
//>>> DDD / Aggregate Root
