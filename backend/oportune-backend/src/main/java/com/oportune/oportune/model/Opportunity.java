package com.oportune.oportune.model;

import com.oportune.oportune.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="opportunity")
public class Opportunity {
    @Id
    @SequenceGenerator(
            name="opportunity_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "opportunity_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private int id;
    private String name;
    private String description;
    private String link;
    private String location;
    private Date start_date;
    private Date end_date;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Type type;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Organizer organizer;

}
