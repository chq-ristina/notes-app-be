package com.christinap.notesappbe.controller;

import com.christinap.notesappbe.entity.Note;
import com.christinap.notesappbe.model.shared.AcceptRequest;
import com.christinap.notesappbe.model.shared.AcceptResponse;
import com.christinap.notesappbe.model.shared.SharedRequest;
import com.christinap.notesappbe.model.shared.SharedResponse;
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
    public ResponseEntity<List<Note>> getPendingSharedNotes(
            @RequestParam("query") String query
    ){
        return ResponseEntity.ok(sharedService.getPendingSharedNotes(query));
    }

}
