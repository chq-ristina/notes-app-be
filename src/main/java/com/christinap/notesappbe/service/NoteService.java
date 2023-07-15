package com.christinap.notesappbe.service;

import com.christinap.notesappbe.entity.Note;
import com.christinap.notesappbe.model.note.*;

import java.util.List;

public interface NoteService {
    NoteResponse createNote(NoteRequest request);

    List<Note> findNoteByUserId(String query);

    List<Note> findNoteById(String query);

    Note findOneNoteById(Integer id);

    NoteDeleteResponse deleteNote(NoteDeleteRequest request);
    UpdateNoteResponse updateNoteById(UpdateNoteRequest request);
}
