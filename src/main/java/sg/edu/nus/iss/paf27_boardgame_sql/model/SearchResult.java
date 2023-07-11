package sg.edu.nus.iss.paf27_boardgame_sql.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResult {
    
    private List<GameDetail> gameDetail;

    private int offset;

    private int limit;

    private int total;

    private Date timestamp;
}
