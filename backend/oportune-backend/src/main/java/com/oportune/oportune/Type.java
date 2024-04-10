package com.oportune.oportune;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="type")
public class Type {
    @Id
    @SequenceGenerator(
            name="type_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "type_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private int id;

    @Column(nullable = true)
    private String description;

    @ManyToOne
    private Opportunity opportunity;
}
