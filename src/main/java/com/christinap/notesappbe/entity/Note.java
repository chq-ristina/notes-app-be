package com.christinap.notesappbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "user_id")
    private Integer user_id;
    private String title;
    @Column(length = 3000)
    private String text;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime dateUpdated;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Shared.class)
    @JoinColumn(name = "note_id")
    private List<Shared> noteIds;

}
