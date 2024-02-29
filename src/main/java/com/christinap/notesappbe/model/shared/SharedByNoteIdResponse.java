package com.christinap.notesappbe.model.shared;
import com.christinap.notesappbe.entity.Shared;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SharedByNoteIdResponse {
    public Shared shared;
    public String targetUsername;
}
