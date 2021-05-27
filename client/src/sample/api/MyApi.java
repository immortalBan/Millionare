package sample.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import sample.model.Game;
import sample.model.GameQuestion;
import sample.model.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyApi {

    public List<Game> getGames(){
        List<Game> resultList = new ArrayList<>();


        String URL = "http://localhost:8080/games";
        String response = HttpRequest.sendGET(URL);
        System.out.println(response);
        if (response != null) {
            JsonArray jsonResult = JsonParser.parseString(response).getAsJsonArray();

                for (int i = 0; i < jsonResult.size(); i++) {
                    JsonObject currentGame = jsonResult.get(i).getAsJsonObject();

                    String id = currentGame.get("id").getAsString();
                    String points = currentGame.get("points").getAsString();

                    Game game = new Game(id, points);

                    resultList.add(game);

            }
        }
        return resultList;
    }

    public List<Question> getQuestions(){
        List<Question> resultList = new ArrayList<>();


        String URL = "http://localhost:8080/questions";
        String response = HttpRequest.sendGET(URL);

        if (response != null) {
            JsonArray jsonResult = JsonParser.parseString(response).getAsJsonArray();

                for (int i = 0; i < jsonResult.size(); i++) {
                    JsonObject currentGame = jsonResult.get(i).getAsJsonObject();

                    String id = currentGame.get("id").getAsString();
                    String level = currentGame.get("level").getAsString();
                    String text = currentGame.get("text").getAsString();
                    String firstAnswer = currentGame.get("firstAnswer").getAsString();
                    String secondAnswer = currentGame.get("secondAnswer").getAsString();
                    String thirdAnswer = currentGame.get("thirdAnswer").getAsString();
                    String fourthAnswer = currentGame.get("fourthAnswer").getAsString();
                    String correctAnswer = currentGame.get("correctAnswer").getAsString();

                    Question question = new Question(id, level, text, firstAnswer, secondAnswer, thirdAnswer, fourthAnswer, correctAnswer);

                    resultList.add(question);
                }

        }
        return resultList;
    }

    public List<GameQuestion> getGameQuestions(){
        List<GameQuestion> resultList = new ArrayList<>();


        String URL = "http://localhost:8080/game_questions";
        String response = HttpRequest.sendGET(URL);
        System.out.println(response);
        if (response != null) {
            JsonArray jsonResult = JsonParser.parseString(response).getAsJsonArray();

            for (int i = 0; i < jsonResult.size(); i++) {
                JsonObject currentGame = jsonResult.get(i).getAsJsonObject();

                String id = currentGame.get("id").getAsString();
                String gameId = currentGame.get("gameId").getAsString();
                String questionId = currentGame.get("questionId").getAsString();

                GameQuestion gameQuestion = new GameQuestion(id, gameId, questionId);

                resultList.add(gameQuestion);

            }
        }
        return resultList;
    }

    public List<GameQuestion> getGameQuestionsById(String gameId, String questionId){
        List<GameQuestion> resultList = new ArrayList<>();


        String URL = "http://localhost:8080/game_questions";
        String response = HttpRequest.sendGET(URL);
        System.out.println(response);
        if (response != null) {
            JsonArray jsonResult = JsonParser.parseString(response).getAsJsonArray();

            for (int i = 0; i < jsonResult.size(); i++) {
                JsonObject currentGame = jsonResult.get(i).getAsJsonObject();

                String id = currentGame.get("id").getAsString();
                String currentGameId = currentGame.get("gameId").getAsString();
                String currentQuestionId = currentGame.get("questionId").getAsString();
                if (currentGameId.equals(gameId) && currentQuestionId.equals(questionId)) {
                    GameQuestion gameQuestion = new GameQuestion(id, gameId, questionId);
                    resultList.add(gameQuestion);
                }
            }
        }
        return resultList;
    }

    public Game createGame(String points) {
        String URL = "http://localhost:8080/games";

        Map<String, String> params = new HashMap<>();
        params.put("points", points);

        String response = HttpRequest.sendPOST(URL, params);
        if (response != null) {
            JsonObject jsonResult = JsonParser.parseString(response).getAsJsonObject();
            String id = jsonResult.get("id").getAsString();
            String currentPoints = jsonResult.get("points").getAsString();

            Game game = new Game(id, currentPoints);
            return game;
        } else {
            return null;
        }
    }

    public void updateGame(Game game){
        String URL = "http://localhost:8080/games/" + game.getId();
        String response = HttpRequest.sendGET(URL);
        if (response != null) {
            JsonObject jsonResult = JsonParser.parseString(response).getAsJsonObject();

            jsonResult.addProperty("points", game.getPoints());

            System.out.println(jsonResult);

            String jsonString = jsonResult.toString();
            String newResponse = HttpRequest.sendPUT(URL, jsonString);

        }

    }
}
