package com.christinap.notesappbe.model.shared;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SharedResponse {
    private Integer id;
    private Integer noteId;
    private Integer sourceId;
    private Integer targetId;
}
