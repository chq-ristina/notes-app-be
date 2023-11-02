package com.christinap.notesappbe.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="shared")
public class Shared {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "note_id")
    private Integer noteId;
    @Column(name = "source_user")
    private Integer sourceUser;
    @Column(name = "target_user")
    private Integer targetUser;
    private Boolean accepted;
}
