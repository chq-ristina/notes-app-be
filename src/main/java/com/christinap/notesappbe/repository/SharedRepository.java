package com.christinap.notesappbe.repository;

import com.christinap.notesappbe.entity.Shared;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SharedRepository extends JpaRepository<Shared, Integer> {
    @Query(value = "SELECT s.note_id FROM shared s" +
            " WHERE s.target_user = :query" +
            " AND s.accepted = true", nativeQuery = true)
    List<Integer> getSharedByTargetId(String query);

    Optional<Shared> getSharedById(Integer id);

    @Query(value = "SELECT s.note_id FROM shared s" +
            " WHERE s.target_user = :query" +
            " AND s.accepted IS NULL", nativeQuery = true)
    List<Integer> getPendingSharedByTargetId(String query);

    @Query(value = "SELECT * FROM shared s" +
            " WHERE s.note_id = :id", nativeQuery = true)
    List<Shared> getSharedByNoteIdQuery(Integer id);

    Optional<Shared> getSharedByNoteId(Integer id);

    @Query(value = "SELECT s.accepted FROM shared s" +
            "WHERE s.noted_id = :id" +
            "AND s.target_id = :username", nativeQuery = true)
    List<Boolean> getAcceptedByNoteIdUsername(Integer id, String username);
}
