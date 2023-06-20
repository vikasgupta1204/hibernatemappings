package com.sprngmpg.onetoone.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="instructor_detail")
@Data
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="youtube_channel")
    private String youtubeChannel;
    @Column(name="hobby")
    private String hobby;

    //add New field for instructor to implement bi-directional mapping
    @OneToOne(mappedBy = "instructorDetail",cascade = {CascadeType.DETACH,CascadeType.MERGE,
    CascadeType.PERSIST,CascadeType.REFRESH})
    private Instructor instructor;
}
