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
    private Integer note_id;
    @Column(name = "source_user")
    private Integer source_user;
    @Column(name = "target_user")
    private Integer target_user;
    private Boolean accepted;
}
