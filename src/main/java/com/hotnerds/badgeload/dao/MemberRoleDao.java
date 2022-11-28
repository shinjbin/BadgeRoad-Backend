package com.hotnerds.badgeload.dao;

import com.hotnerds.badgeload.dto.MemberRole;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberRoleDao {
    private NamedParameterJdbcTemplate jdbc;
    // BeanPropertyRowMapper는 Role클래스의 프로퍼티를 보고 자동으로 칼럼과 맵핑해주는 RowMapper객체를 생성합니다.
    // roleId 프로퍼티는 role_id 칼럼과 맵핑이 됩니다.
    private RowMapper<MemberRole> rowMapper = BeanPropertyRowMapper.newInstance(MemberRole.class);

    public MemberRoleDao(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<MemberRole> getRolesByEmail(String email){
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);

        return jdbc.query(MemberRoleDaoSqls.SELECT_ALL_BY_EMAIL, map, rowMapper);
    }
}
