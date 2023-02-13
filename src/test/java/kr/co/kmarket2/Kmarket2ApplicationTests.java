package kr.co.kmarket2;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class Kmarket2ApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Autowired
	private DataSource ds;
	
	@Test
	public void testConnection() {
		try {
			Connection con = ds.getConnection();
			log.info("testCon : "+con);
		}catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	@Autowired
	private SqlSessionFactory sessionFactory;


	@Test
	public void testSessionFactory() {

		log.info("\n Session Factory : " + sessionFactory);

	}

	

	@Test
	public void testSqlSession() {

		try (SqlSession session = sessionFactory.openSession()){

			log.info("\n Sql Session : " + session);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
