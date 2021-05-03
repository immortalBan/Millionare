package Millionare.Millionare.serviceImpl;

import Millionare.Millionare.entity.Question;
import Millionare.Millionare.repo.QuestionRepo;
import Millionare.Millionare.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public Question create(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public List<Question> readAll() {
        return questionRepo.findAll();
    }

    @Override
    public Question read(Long id) {
        return questionRepo.findById(id).orElse(null);
    }

    @Override
    public boolean update(Question question, Long id) {
        if (read(id) != null){
            Question newQuestion = new Question();
            newQuestion.setId(id);
            newQuestion.setLevel(question.getLevel());
            newQuestion.setText(question.getText());
            newQuestion.setFirstAnswer(question.getFirstAnswer());
            newQuestion.setSecondAnswer(question.getSecondAnswer());
            newQuestion.setThirdAnswer(question.getThirdAnswer());
            newQuestion.setFourthAnswer(question.getFourthAnswer());
            newQuestion.setCorrectAnswer(question.getCorrectAnswer());

            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        if (read(id) != null) {
            questionRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
