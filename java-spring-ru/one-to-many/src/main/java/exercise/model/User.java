package exercise.model;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "guests")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @NotBlank
    private String name;

    @Email
    @Column(unique = true)
    private String email;

    @CreatedDate
    private LocalDate createdAt;

    @NotNull
    private String assignee;



    // BEGIN
    @OneToMany(mappedBy = "assignee", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();
    // END
}
