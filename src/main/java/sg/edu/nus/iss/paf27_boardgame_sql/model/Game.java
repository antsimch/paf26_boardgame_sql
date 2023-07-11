package sg.edu.nus.iss.paf27_boardgame_sql.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    private int gid;
    
    private String name;

    private int year;

    private int ranking;

    private int usersRated;

    private String url;

    private String image;

    private Date timestamp;
}
