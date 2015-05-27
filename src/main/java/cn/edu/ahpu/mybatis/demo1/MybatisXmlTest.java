package cn.edu.ahpu.mybatis.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MybatisXmlTest {//junit3 entends TestCase
	SqlSessionFactory factory = null;
	SqlSession session = null;
	InputStream in =  null;
	@Before
	public void setUp(){//junit3÷–Œ¿setUp
		 in = MybatisXmlTest.class.getClassLoader().getResourceAsStream("META-INF/spring/conf.xml");
		 factory = new SqlSessionFactoryBuilder().build(in);
		 session = factory.openSession();
	}
	
	@Test
	public void a_selectOne(){
		
		String statement = "cn.edu.ahpu.mybatis.demo1.UsersMapper.getUser";
		User user =session.selectOne(statement, 1);
		
		System.out.println(user.toString());
	}
	
	@Test
	public void b_addUser(){
		String statement = "cn.edu.ahpu.mybatis.demo1.UsersMapper.addUser";
		
		int insert  = session.insert(statement, new User(-1,"sequence",88,new Date()));
		session.commit();
		
		System.out.println("insert:"+insert);
	}
	
	
	@Test
	public void c_updateUser(){
		session = factory.openSession();
		String statement = "cn.edu.ahpu.mybatis.demo1.UsersMapper.updateUser";
		
		int update  = session.update(statement, new User(10,"sequence_update",100,new Date()));
		session.commit();
		
		System.out.println("update:"+update);
	}
	
	@Test
	public void d_deleteUser(){
		String statement = "cn.edu.ahpu.mybatis.demo1.UsersMapper.deleteUser";
		
		int delete  = session.delete(statement, 10);
		session.commit();
		System.out.println("delete:"+delete);
	}
	
	@Test
	public void e_queryUser(){
		String statement = "cn.edu.ahpu.mybatis.demo1.UsersMapper.queryUser";
		List<User> users =session.selectList(statement);
		if(users != null && users.size() > 0){
			for(User u : users){
				System.out.println(u.toString());
			}
		}
	}
	
	@After
	public void tearDown() throws IOException{
		session.close();
		in.close();
	}
}
