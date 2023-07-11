package sg.edu.nus.iss.paf27_boardgame_sql.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.paf27_boardgame_sql.model.Game;
import sg.edu.nus.iss.paf27_boardgame_sql.model.GameDetail;
import sg.edu.nus.iss.paf27_boardgame_sql.model.SearchResult;
import sg.edu.nus.iss.paf27_boardgame_sql.service.GameService;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    
    @GetMapping(path = "/games")
    public ResponseEntity<SearchResult> getGamesByName(
            @RequestParam String name, 
            @RequestParam(defaultValue = "25") int limit, 
            @RequestParam(defaultValue = "0") int offset) {

        List<GameDetail> gameDetails = gameService.findGameByName(name, limit, offset);
        
        if (gameDetails.isEmpty()) 
            return ResponseEntity.notFound().build();

        SearchResult result = new SearchResult(
                gameDetails,
                offset,
                limit,
                gameDetails.size(),
                new Date()
        );
        
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(path = "/games/rank")
    public ResponseEntity<SearchResult> getGamesByRank(
            @RequestParam(defaultValue = "25") int limit, 
            @RequestParam(defaultValue = "0") int offset) {
        
        List<GameDetail> gameDetails = gameService.findGameByRank(limit, offset);
        
        if (gameDetails.isEmpty())
            return ResponseEntity.internalServerError().build();
        
        SearchResult result = new SearchResult(
                gameDetails, 
                offset, 
                limit, 
                gameDetails.size(), 
                new Date());
        
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(path = "/game/{gameId}")
    public ResponseEntity<Game> getGameById(@PathVariable int gameId) {

        List<Game> games = gameService.findGameById(gameId);

        if (games.isEmpty())
            return ResponseEntity.notFound().build();

        Game game = games.get(0);
        game.setTimestamp(new Date());

        return ResponseEntity.ok().body(game);
    }
}
