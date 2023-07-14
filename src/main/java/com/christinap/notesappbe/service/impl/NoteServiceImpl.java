package com.christinap.notesappbe.service.impl;

import com.christinap.notesappbe.entity.Note;
import com.christinap.notesappbe.model.note.NoteRequest;
import com.christinap.notesappbe.model.note.NoteResponse;
import com.christinap.notesappbe.repository.NoteRepository;
import com.christinap.notesappbe.service.NoteService;
import com.christinap.notesappbe.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
                .text(request.getText())
                .build();

        noteRepository.save(note);

       return NoteResponse.builder()
               .user_id(user.getId())
               .text(note.getText())
               .authorUsername(user.getUsername())
               .build();
    }

    @Override
    public List<Note> findNoteByUserId(String query) {
        return noteRepository.findNoteByUserId(query);
    }

    @Override
    public List<Note> findNoteById(String query) {
        return noteRepository.findNoteById(query);
    }

    @Override
    public Note findOneNoteById(Integer id) {
        return noteRepository.findOneNoteById(id).orElseThrow();
    }
}
