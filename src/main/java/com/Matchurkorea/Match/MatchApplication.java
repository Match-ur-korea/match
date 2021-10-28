package com.Matchurkorea.Match;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@SpringBootApplication
//@MapperScan(value = {"com.Matchurkorea.Match.mapper.characterMapper"})
//@MapperScan(value = {"com.Matchurkorea.Match.mapper.userMapper"})
public class MatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatchApplication.class, args);
	}

	// TODO SQLSessionFactory 설정
//	@Bean
//	public SqlSessionFactory sqlSessionFactory(DataSource dataSource)
//			throws Exception{
//
//		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//
//		sessionFactory.setDataSource(dataSource);
//
//		// classpath:mapper에는 자신의 mapper.xml이 있는 경로를 적어준다.
//		Resource[] arrResource = new PathMatchingResourcePatternResolver()
//				.getResources("classpath:mapper/**.xml");
//		sessionFactory.setMapperLocations(arrResource);
//		sessionFactory.getObject().getConfiguration()
//				.setMapUnderscoreToCamelCase(true);
//
//		return sessionFactory.getObject();
//
//	}

}
