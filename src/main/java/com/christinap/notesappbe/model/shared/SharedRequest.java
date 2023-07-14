package com.christinap.notesappbe.model.shared;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SharedRequest {
    private Integer noteId;
    private String sourceUsername;
    private String targetUsername;
}
