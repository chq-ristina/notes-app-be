package com.christinap.notesappbe.controller;

import com.christinap.notesappbe.entity.Note;
import com.christinap.notesappbe.model.note.NoteRequest;
import com.christinap.notesappbe.model.note.NoteResponse;
import com.christinap.notesappbe.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/note")
@RequiredArgsConstructor
@CrossOrigin
public class NoteController {
    private final NoteService noteService;

    @PostMapping("/add")
    public ResponseEntity<NoteResponse> add(
            @RequestBody NoteRequest request
            ){
        return ResponseEntity.ok(noteService.createNote(request));
    }

    @GetMapping("/find-note/user-id")
    public ResponseEntity<List<Note>> findNoteByUserId(
            @RequestParam("query") String query
    ){
        return ResponseEntity.ok(noteService.findNoteByUserId(query));
    }

    @GetMapping("/find-note/id")
    public ResponseEntity<List<Note>> findNoteById(
            @RequestParam("query") String query
    ){
        return ResponseEntity.ok(noteService.findNoteById(query));
    }


    //issue with this one
    @GetMapping("/find-note/one-id")
    public ResponseEntity<Note> findOneNoteById(
            @RequestParam("query") Integer id
    ){
        return ResponseEntity.ok(noteService.findOneNoteById(id));
    }
}