package com.christinap.notesappbe.repository;

import com.christinap.notesappbe.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    @Query(value = "SELECT * FROM notes n" +
            " WHERE n.user_id = :query", nativeQuery = true)
    List<Note> findNoteByUserId(String query);

    @Query(value = "SELECT * FROM notes n" +
            " WHERE n.id = :query", nativeQuery = true)
    List<Note> findNoteById(String query);

    Optional<Note> findOneNoteById(Integer id);


    //https://stackoverflow.com/questions/444251/how-to-store-a-list-in-a-db-column
    //https://stackoverflow.com/questions/3070384/how-to-store-a-list-in-a-column-of-a-database-table
}
