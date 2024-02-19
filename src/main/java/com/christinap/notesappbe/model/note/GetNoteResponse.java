package com.christinap.notesappbe.model.note;
import com.christinap.notesappbe.entity.Note;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetNoteResponse {
    private Note note;
    private String author;
}
