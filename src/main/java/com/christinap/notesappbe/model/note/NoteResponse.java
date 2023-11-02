package com.christinap.notesappbe.model.note;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoteResponse {
    private Integer id;
    private Integer user_id;
    private String title;
    private String text;
    private String authorUsername;
    private LocalDateTime dateUpdated;
}
