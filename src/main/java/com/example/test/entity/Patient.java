package com.example.test.entity;

import com.example.test.entity.type.Bloodgroup;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.annotations.processing.Pattern;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "email"})
}, indexes = {

})
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String city;

    private String email;

    private Bloodgroup bloodgroup;

}
