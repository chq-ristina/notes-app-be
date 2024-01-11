package com.christinap.notesappbe.controller;

import com.christinap.notesappbe.entity.Note;
import com.christinap.notesappbe.entity.Shared;
import com.christinap.notesappbe.model.note.NoteDeleteRequest;
import com.christinap.notesappbe.model.shared.*;
import com.christinap.notesappbe.service.SharedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shared")
@RequiredArgsConstructor
@CrossOrigin
public class SharedController {
    private final SharedService sharedService;

    @PostMapping("/add")
    public ResponseEntity<SharedResponse> addShared(
            @RequestBody SharedRequest request
            ){
        return ResponseEntity.ok(sharedService.addShared(request));
    }

    @GetMapping("/get-shared")
    public ResponseEntity<List<Note>> getSharedNotes(
            @RequestParam("query") String query
    ){
        return ResponseEntity.ok(sharedService.getSharedNotes(query));
    }

    @PutMapping("/accept")
    public ResponseEntity<AcceptResponse> updateAcceptShared(
            @RequestBody AcceptRequest request
            ){
        return ResponseEntity.ok(sharedService.updateAcceptShared(request));
    }

    @GetMapping("/get-pending")
    public ResponseEntity<List<PendingSharedResponse>> getPendingSharedNotes(
            @RequestParam("query") String query
    ){
        return ResponseEntity.ok(sharedService.getPendingSharedNotes(query));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<List<Integer>> deleteSharedByNoteId(
            @RequestBody NoteDeleteRequest request
            ){
        return ResponseEntity.ok(sharedService.deleteShared(request));
    }

    @GetMapping("/get-shared-by-note-id")
    public ResponseEntity<List<Shared>> getSharedWith(
            @RequestParam("id") Integer request
    ){
        return ResponseEntity.ok(sharedService.getSharedByNoteId(request));
    }

}
