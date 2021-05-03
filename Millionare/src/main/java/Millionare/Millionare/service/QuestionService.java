package Millionare.Millionare.service;

import Millionare.Millionare.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {

    Question create(Question question);

    List<Question> readAll();

    Question read(Long id);

    boolean update(Question question, Long id);

    boolean delete(Long id);
}
