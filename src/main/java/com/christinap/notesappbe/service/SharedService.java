package com.christinap.notesappbe.service;

import com.christinap.notesappbe.entity.Note;
import com.christinap.notesappbe.entity.Shared;
import com.christinap.notesappbe.model.note.NoteDeleteRequest;
import com.christinap.notesappbe.model.shared.*;

import java.util.List;

public interface SharedService {
    SharedResponse addShared(SharedRequest request);
    List<Note> getSharedNotes(String query);
    AcceptResponse updateAcceptShared(AcceptRequest request);
    List<Note> getPendingSharedNotes(String query);
    List<Integer> deleteShared(NoteDeleteRequest request);
    List<Shared> getSharedByNoteId(Integer request);
}
