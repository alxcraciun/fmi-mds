package com.oportune.oportune;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="bookmark")
public class Bookmark {
    @Id
    @SequenceGenerator(
            name="bookmark_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "bookmark_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private int id;
    @MapsId("classroomId")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @MapsId("teacherId")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Opportunity opportunity;


}
