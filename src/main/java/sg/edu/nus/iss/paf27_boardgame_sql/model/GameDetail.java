package sg.edu.nus.iss.paf27_boardgame_sql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDetail {
    
    private int gid;

    private String name;
}
