package com.christinap.notesappbe.model.note;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoteRequest {
    private String username;
    private String title;
    private String text;
}
