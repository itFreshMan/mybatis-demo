package cn.edu.ahpu.mybatis.demo2;

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

import cn.edu.ahpu.mybatis.demo1.User;

public class MybatisAnnotationTest {//junit3 entends TestCase
	SqlSessionFactory factory = null;
	SqlSession session = null;
	InputStream in =  null;
	IUserMapper mapper = null;
	@Before
	public void setUp(){//junit3÷–Œ¿setUp
		 in = MybatisAnnotationTest.class.getClassLoader().getResourceAsStream("META-INF/spring/conf.xml");
		 factory = new SqlSessionFactoryBuilder().build(in);
		 session = factory.openSession();
		 mapper =session.getMapper(IUserMapper.class);
	}
	
	@Test
	public void a2_selectOne(){
		User user = mapper.getById(1);
		System.out.println("a2_selectOne:"+user.toString());
	}
	
	@Test
	public void b2_addUser(){
		mapper.add(new User(-1,"annotation_sequence",88,new Date()));
		session.commit();
		
	}
	
	
	@Test
	public void c2_updateUser(){
		mapper.update(new User(13,"annotation_update",100,new Date()));
		session.commit();
	}
	
	@Test
	public void d2_deleteUser(){
		mapper.deleteByid(13);
		session.commit();
	}
	
	@Test
	public void e2_queryUser(){
		List<User> users =mapper.getAllUser();
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
