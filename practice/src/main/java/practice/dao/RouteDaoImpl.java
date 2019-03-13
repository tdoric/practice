package practice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import practice.model.Location;

@Repository
public class RouteDaoImpl implements RouteDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Location> getRoute() {
		
		return jdbcTemplate.query(Statements.Route.SELECT_ROUTE ,new Object[] {1},
				new BeanPropertyRowMapper<Location>(Location.class));
	}

	@Override
	public void insertLogLocation(Location location) {
		jdbcTemplate.update(Statements.Log.INSERT, new Object[] {location.toString()});
		
	}

	@Override
	public Location getLocation(int idLocation) {
		return jdbcTemplate.queryForObject(Statements.Route.SELECT_LOCATION,new Object[] {idLocation} ,
				new BeanPropertyRowMapper<Location>(Location.class));
	}

}
