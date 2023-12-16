package com.christinap.notesappbe.service.impl;

import com.christinap.notesappbe.entity.Note;
import com.christinap.notesappbe.entity.Shared;
import com.christinap.notesappbe.model.note.NoteDeleteRequest;
import com.christinap.notesappbe.model.shared.*;
import com.christinap.notesappbe.repository.NoteRepository;
import com.christinap.notesappbe.repository.SharedRepository;
import com.christinap.notesappbe.service.SharedService;
import com.christinap.notesappbe.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLNonTransientException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SharedServiceImpl implements SharedService {
    private final SharedRepository sharedRepository;
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    @Override
    public SharedResponse addShared(SharedRequest request) {
        var sourceUser = userRepository.findByUserName(request.getSourceUsername()).orElseThrow();
        var sourceId = sourceUser.getId();

        try {
            var targetUser = userRepository.findByUserName(request.getTargetUsername()).orElseThrow();
            var targetId = targetUser.getId();

            var shared = Shared.builder()
                    .noteId(request.getNoteId())
                    .sourceUser(sourceId)
                    .targetUser(targetId)
                    .build();

            try{
                sharedRepository.save(shared);
            }
            catch(DataIntegrityViolationException Exception){
                String errorMessage = "You have already shared or requested to share with "
                        + request.getTargetUsername() ;
                return SharedResponse.builder()
                        .id(null)
                        .noteId(null)
                        .sourceId(null)
                        .targetId(null)
                        .error(true)
                        .errorMessage(errorMessage)
                        .build();
            }

            return SharedResponse.builder()
                    .id(shared.getId())
                    .noteId(shared.getNoteId())
                    .sourceId(shared.getSourceUser())
                    .targetId(shared.getTargetUser())
                    .error(false)
                    .errorMessage(null)
                    .build();
        }
        catch(NoSuchElementException exception){
            String errorMessage = request.getTargetUsername() + " could not be found";
            return SharedResponse.builder()
                    .id(null)
                    .noteId(null)
                    .sourceId(null)
                    .targetId(null)
                    .error(true)
                    .errorMessage(errorMessage)
                    .build();
        }
    }

    @Override
    public List<Note> getSharedNotes(String query) {
        List<Integer> noteIds = sharedRepository.getSharedByTargetId(query);

        List<Note> notes = new ArrayList<>();

        for(Integer noteId : noteIds){
            var note = noteRepository.findOneNoteById(noteId).orElseThrow();
            notes.add(note);
        }

        return notes;
    }

    @Override
    public AcceptResponse updateAcceptShared(AcceptRequest request) {
        var shared = sharedRepository.getSharedById(request.getId()).orElseThrow();
        shared.setAccepted(request.getAccepted());
        sharedRepository.save(shared);

        return AcceptResponse.builder()
                .id(shared.getId())
                .build();
    }

    @Override
    public List<Note> getPendingSharedNotes(String query) {
        List<Integer> noteIds = sharedRepository.getPendingSharedByTargetId(query);

        List<Note> notes = new ArrayList<>();

        for(Integer noteId : noteIds){
            var note = noteRepository.findOneNoteById(noteId).orElseThrow();
            notes.add(note);
        }

        return notes;
    }

    @Override
    public List<Integer> deleteShared(NoteDeleteRequest request) {
        List<Shared> sharedList = sharedRepository.getSharedByNoteIdQuery(request.getId());
        List<Integer> deletedShared = new ArrayList<>();
        if (sharedList.size() != 0) {
            for (Shared shared : sharedList) {
                deletedShared.add(shared.getId());
                sharedRepository.delete(shared);
            }
        }
        return deletedShared;
    }

    @Override
    public List<Shared> getSharedByNoteId(Integer request)
    {
        return sharedRepository.getSharedByNoteIdQuery(request);
    }
}
