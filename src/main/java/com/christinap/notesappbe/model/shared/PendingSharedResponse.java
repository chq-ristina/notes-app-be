package com.christinap.notesappbe.model.shared;
import com.christinap.notesappbe.entity.Note;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PendingSharedResponse {
    private Integer shareId;
    private Note note;
    private String noteAuthor;
}
