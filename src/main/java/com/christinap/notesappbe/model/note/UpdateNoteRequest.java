package com.christinap.notesappbe.model.note;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateNoteRequest {
    private Integer id;
    private String updateTitle;
    private String updateText;
    private String modifiedBy;
}
