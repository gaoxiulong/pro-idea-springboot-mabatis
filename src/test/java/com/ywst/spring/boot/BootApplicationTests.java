package com.ywst.spring.boot;

import com.ywst.spring.boot.entity.Emp;
import com.ywst.spring.boot.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private DataSource dataSource;

	@Autowired
	private EmpService empService;

	@Test
	public  void testCon() throws SQLException{
		Connection connection = dataSource.getConnection();
		System.out.print(connection);
	}

	@Test
	public void testService(){
		List<Emp> list = empService.getAll();
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}

}
