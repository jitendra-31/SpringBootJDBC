package com.spring.boot.jdbc.SpringBootJDBC.Repository;

import com.spring.boot.jdbc.SpringBootJDBC.Entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PlayerDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Player> getAllPlayer(){
        String getPlayerQuery = "SELECT * FROM Player";

        return jdbcTemplate.query(getPlayerQuery, new BeanPropertyRowMapper<Player>(Player.class));
        //or
        //return jdbcTemplate.query(getPlayerQuery, new PlayerMapper(),);
    }

    //READ (Get by ID)
    public Player getPlayerById(int id){
        String getPlayerByIdQuery = "SELECT Name, DOB FROM Player WHERE ID = ?";

        //JDBCTEMPLATE => Query => ID is being substituted as a Primary KEY => Database => Result Set => Row Mapped
        return jdbcTemplate.queryForObject(getPlayerByIdQuery, new BeanPropertyRowMapper<Player>(Player.class), new Object[]{id});
    }

    //INSERTING a new ROW
    public int insertPlayer(Player player){
        String insertPlayerQuery = "INSERT INTO Player VALUES(?, ?, ?, ?, ?, ?)";

        //will return 1 after success
        return jdbcTemplate.update(insertPlayerQuery, new PlayerMapper(), new Object[]{player.getId(), player.getName(), player.getAge(),
                player.getNationality(), new Timestamp(player.getDob().getTime()), player.getDesignation()});
    }

    //UPDATING A ROW
    public int updatePlayerInfo(Player player){
        String updateQuery = "UPDATE Player " + "SET Name = ?,  Age = ?,  Nationality = ?,  DOB = ?,  Designation = ? "+
                "WHERE ID = ?";

        return jdbcTemplate.update(updateQuery, new PlayerMapper(), new Object[]{player.getName(), player.getAge(),
                player.getNationality(), new Timestamp(player.getDob().getTime()), player.getDesignation(), player.getId()});
    }

    //DELETING A ROW
    public int deletePlayer(int id){
        String deleteQuery = "DELETE FROM Player " + "WHERE ID = ?";

        return jdbcTemplate.update(deleteQuery, new Object[]{id});
    }

    //************USING ROW MAPPER INSTEAD OF BEANPROPERTYMAPPER**************
    private static final class PlayerMapper implements RowMapper {

        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            Player player = new Player();

            player.setId(rs.getInt("ID"));
            player.setName(rs.getString("Name"));
            player.setAge(rs.getInt("Age"));
            player.setNationality(rs.getString("Nationality"));
            player.setDob(rs.getDate("DOB"));
            player.setDesignation(rs.getInt("Designation"));

            return player;
        }
    }
}
