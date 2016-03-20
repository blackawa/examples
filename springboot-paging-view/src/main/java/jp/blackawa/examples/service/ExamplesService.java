package jp.blackawa.examples.service;

import jp.blackawa.examples.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExamplesService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Member> find(int page, int recordPerPage) {
        int offset = (page - 1) * recordPerPage + 1;
        int require = page * recordPerPage;
        Map<String, Integer> conds = new HashMap<String, Integer>() {{
            put("offset", offset);
            put("require", require);
        }};
        return namedParameterJdbcTemplate.query(
                "SELECT MEMBER_ID, MEMBER_NAME FROM (SELECT M.*, ROWNUM AS R FROM MEMBER M) WHERE R BETWEEN :offset AND :require",
                conds,
                (rs, i) -> new Member(rs.getLong(1), rs.getString(2))
        );
    }

    public int count() {
        return namedParameterJdbcTemplate.query(
                "SELECT COUNT(*) FROM MEMBER",
                (rs, i) -> rs.getInt(1)
        ).get(0);
    }
}
