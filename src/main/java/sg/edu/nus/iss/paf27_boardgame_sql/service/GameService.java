package sg.edu.nus.iss.paf27_boardgame_sql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf27_boardgame_sql.model.Game;
import sg.edu.nus.iss.paf27_boardgame_sql.model.GameDetail;
import sg.edu.nus.iss.paf27_boardgame_sql.repository.GameRepository;

@Service
public class GameService {
    
    private GameRepository gameRepo;

    public GameService(GameRepository gameRepo) {
        this.gameRepo = gameRepo;
    }

    public List<GameDetail> findGameByName(String name, int limit, int offset) {
        return gameRepo.findGameByName(name, limit, offset);
    }

    public List<GameDetail> findGameByRank(int limit, int offset) {
        return gameRepo.findGameByRank(limit, offset);
    }

    public List<Game> findGameById(int gameid) {
        return gameRepo.findGameById(gameid);
    }
}
