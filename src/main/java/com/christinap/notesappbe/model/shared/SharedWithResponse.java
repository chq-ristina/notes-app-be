package com.christinap.notesappbe.model.shared;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SharedWithResponse {
    private List<String> usernames;
    private List<Boolean> accepted;
}
