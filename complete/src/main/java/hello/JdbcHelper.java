package hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class JdbcHelper {

	private static JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	static {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(oracle.jdbc.driver.OracleDriver.class);
		dataSource.setUrl("jdbc:oracle:thin:@192.168.1.100:1521:orcl");
		dataSource.setUsername("scott");
		dataSource.setPassword("tiger");
		
		//JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
	}
	
	public static List<Department> getDeptById(long id) {
		List<Department> list = new ArrayList<Department>();
		
		jdbcTemplate.query("SELECT * FROM DEPT WHERE DEPTNO = ?", new Object[] {id}, 
				(rs, rowNum) -> new Department(rs.getLong("DEPTNO"), rs.getString("DNAME"), rs.getString("LOC"))	
				).forEach(department -> list.add(department));
		
		return list;
	}
	
	public static List<Department> getDeptByName(String name) {
		List<Department> list = new ArrayList<Department>();
		
		jdbcTemplate.query("SELECT * FROM DEPT WHERE DNAME = ?", new Object[] {name}, 
				(rs, rowNum) -> new Department(rs.getLong("DEPTNO"), rs.getString("DNAME"), rs.getString("LOC"))	
				).forEach(department -> list.add(department));
		
		return list;
	}
}
