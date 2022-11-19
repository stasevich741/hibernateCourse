package dmdev.lesson.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class User {

    @Id
    String username;
    String firstname;
    String lastname;
    @Column(name = "birth_date")
    LocalDate birthDate;
    Integer age;
    @Enumerated(EnumType.STRING)
    Role role;
}

