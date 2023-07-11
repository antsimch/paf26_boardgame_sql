package sg.edu.nus.iss.paf27_boardgame_sql.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf27_boardgame_sql.model.Game;
import sg.edu.nus.iss.paf27_boardgame_sql.model.GameDetail;

@Repository
public class GameRepository {

    private JdbcTemplate template;

    public GameRepository(JdbcTemplate template) {
        this.template = template;
    }
    
    private final String SQL_FIND_BY_NAME =
            "select gid, name from game where name = ? limit ? offset ?";

    private final String SQL_FIND_BY_RANK =
            "select gid, name, ranking from game order by ranking asc limit ? offset ? ";

    private final String SQL_FIND_BY_ID =
            "select * from game where gid = ?";

    public List<GameDetail> findGameByName(String name, int limit, int offset) {
        return template.query(
                SQL_FIND_BY_NAME, 
                BeanPropertyRowMapper
                .newInstance(GameDetail.class), 
                name,
                limit,
                offset);
    }

    public List<GameDetail> findGameByRank(int limit, int offset) {
        return template.query(
                SQL_FIND_BY_RANK,
                BeanPropertyRowMapper
                .newInstance(GameDetail.class),
                limit,
                offset
        );
    }

    public List<Game> findGameById(int gameid) {
        return template.query(
                SQL_FIND_BY_ID, 
                BeanPropertyRowMapper
                .newInstance(Game.class), 
                gameid);
    }
}
