package com.riazulislam.uttorappbackend.repositories;

import com.riazulislam.uttorappbackend.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
//    @Query(nativeQuery = true, value = "SELECT DISTINCT q.*" +
//            "FROM question q" +
//            "LEFT JOIN question_topic qt ON q.id = qt.question_id" +
//            "LEFT JOIN topic t ON qt.topic_id = t.id" +
//            "WHERE (:text IS NULL OR q.text LIKE %:text%" +
//            "AND (:tag IS NULL OR t.name IN :tag))")
//    List<Question> searchQuestion(@Param("text") String text, @Param("tag") List<String> tag);
//
//    List<Question> findQuestionByTitle(String text);
//
//    @Query(nativeQuery = true, value = "SELECT DISTINCT q.*" +
//            "FROM question q" +
//            "LEFT JOIN question_topic qt ON q.id = qt.question_id" +
//            "LEFT JOIN topic t ON qt.topic_id = t.id" +
//            "WHERE (:tag IS NULL OR t.name IN :tag))")
//    List<Question> findQuestionByTag(List<String> tag);

    List<Question> findByTitleContainingIgnoreCase(String text);

    List<Question> findByTopicsNameIn(List<String> tag);

    List<Question> findByTitleContainingIgnoreCaseAndTopicsNameIn(String text, List<String> tag);
}
