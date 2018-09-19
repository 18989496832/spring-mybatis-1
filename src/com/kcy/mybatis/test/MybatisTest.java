package com.kcy.mybatis.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.kcy.mybatis.Dao.EmployeeMapper;
import com.kcy.mybatis.Dao.EmployeeMapperAnnotation;
import com.kcy.mybatis.bean.Employee;

public class MybatisTest {
	private static Logger logger = Logger.getLogger(MybatisTest.class);
	
	public SqlSessionFactory getSqlSessionFactory() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
	/***
	 * �ӿ�ӳ��ķ�ʽ����ȡ����
	 * �ӿں�xml��
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception{
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			//ͨ���������������getEmployeeById
			Employee employee= employeeMapper.getEmployeeById(2);
			System.out.println(employee.toString());
		}finally {
			session.close();
		}
	}
	/***
	 * ����ע�ⷽʽ
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception{
		SqlSession session = getSqlSessionFactory().openSession();
		try {
			EmployeeMapperAnnotation employeeMapper = session.getMapper(EmployeeMapperAnnotation.class);
			//ͨ���������������getEmployeeById
			Employee employee= employeeMapper.getEmployeeById(2);
			System.out.println(employee.toString());
		}finally {
			session.close();
		}
	}
}
