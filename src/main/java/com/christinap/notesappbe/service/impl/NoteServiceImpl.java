package com.christinap.notesappbe.service.impl;

import com.christinap.notesappbe.entity.Note;
import com.christinap.notesappbe.model.note.*;
import com.christinap.notesappbe.repository.NoteRepository;
import com.christinap.notesappbe.service.NoteService;
import com.christinap.notesappbe.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService{
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    @Override
    public NoteResponse createNote(NoteRequest request) {
        var user = userRepository.findByUserName(request.getUsername()).orElseThrow();

        var note = Note.builder()
                .user_id(user.getId())
                .title(request.getTitle())
                .text(request.getText())
                .build();

        noteRepository.save(note);

       return NoteResponse.builder()
               .id(note.getId())
               .user_id(user.getId())
               .title(note.getTitle())
               .text(note.getText())
               .authorUsername(user.getUserName())
               .dateUpdated(note.getDateUpdated())
               .build();
    }

    @Override
    public List<GetNoteResponse> findNoteByUserId(String query)
    {
        List<GetNoteResponse> response = new ArrayList<>();
        List<Note> notes = noteRepository.findNoteByUserId(query);

        for (Note note: notes
             ) {
            var user = userRepository.findById(note.getUser_id()).orElseThrow();
            GetNoteResponse noteResponse = new GetNoteResponse();
            noteResponse.setNote(note);
            noteResponse.setAuthor(user.getUserName());

            response.add(noteResponse);
        }
//        return noteRepository.findNoteByUserId(query);
        return response;
    }

    @Override
    public List<Note> findNoteById(String query) {
        return noteRepository.findNoteById(query);
    }

    @Override
    public Note findOneNoteById(Integer id) {
        return noteRepository.findOneNoteById(id).orElseThrow();
    }

    @Override
    public NoteDeleteResponse deleteNote(NoteDeleteRequest request) {
        var note = noteRepository.findOneNoteById(request.getId()).orElseThrow();
        noteRepository.delete(note);
        return NoteDeleteResponse.builder()
                .id(note.getId())
                .build();
    }

    @Override
    public UpdateNoteResponse updateNoteById(UpdateNoteRequest request) {
        var note = noteRepository.findOneNoteById(request.getId()).orElseThrow();
        if(request.getUpdateTitle() != null){
            note.setTitle(request.getUpdateTitle());
        }
        if (request.getUpdateText() != null){
            note.setText(request.getUpdateText());
        }
        if (request.getModifiedBy() != null){
            note.setModifiedBy(request.getModifiedBy());
        }

        noteRepository.save(note);

        return UpdateNoteResponse.builder()
                .id(note.getId())
                .build();
    }
}
