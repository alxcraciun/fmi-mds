package com.oportune.oportune;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oportune.oportune.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.util.Date;
import java.util.List;

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
    private Status status;

    @OneToMany(mappedBy = "opportunity", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Type> type;

    @OneToMany(mappedBy = "opportunity", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Category> category;

    @OneToMany(mappedBy = "organizer", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Organizer> organizer;
}
