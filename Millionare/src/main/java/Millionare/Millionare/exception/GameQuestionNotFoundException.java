package Millionare.Millionare.exception;

public class GameQuestionNotFoundException extends RuntimeException{
    public GameQuestionNotFoundException(Long id){
        super("Could not find game question " + id);
    }
}
