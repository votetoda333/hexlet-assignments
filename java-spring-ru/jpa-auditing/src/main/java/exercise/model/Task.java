package exercise.model;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

// BEGIN
@Entity
@Table(name = "tasks")
@Getter
@Setter
@EqualsAndHashCode()
@EntityListeners(AuditingEntityListener.class)
public class Task {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String title;
    private String description;
    @LastModifiedDate
    @GeneratedValue
    private LocalDate updatedAt;
    @CreatedDate
    @GeneratedValue
    private LocalDate createdAt;

}
// END
