package com.hvkcoder.mybatis;

import com.hvkcoder.mybatis.mapper.DepartmentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @author h-vk
 * @date 2019-12-19
 * @since V1.0
 */
public class MybatisDemo {
	public static void main(String[] args) throws Exception {
		SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis/MybatisConfig.xml"));
		SqlSession sqlSession = null;
		try{
			sqlSession = build.openSession();
			DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
			mapper.selectDepartment().stream().forEach(System.out::println);
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}finally {
			if (sqlSession != null){
				sqlSession.close();
			}
		}



	}
}
