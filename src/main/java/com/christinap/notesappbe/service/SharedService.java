package com.christinap.notesappbe.service;

import com.christinap.notesappbe.entity.Note;
import com.christinap.notesappbe.model.note.NoteDeleteRequest;
import com.christinap.notesappbe.model.shared.AcceptRequest;
import com.christinap.notesappbe.model.shared.AcceptResponse;
import com.christinap.notesappbe.model.shared.SharedRequest;
import com.christinap.notesappbe.model.shared.SharedResponse;

import java.util.List;

public interface SharedService {
    SharedResponse addShared(SharedRequest request);
    List<Note> getSharedNotes(String query);
    AcceptResponse updateAcceptShared(AcceptRequest request);
    List<Note> getPendingSharedNotes(String query);
    SharedResponse deleteShared(NoteDeleteRequest request);
}
