package cn.edu.ahpu.mybatis.demo2;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import cn.edu.ahpu.mybatis.demo1.User;

public interface IUserMapper {
	
	@SelectKey(before = true,keyProperty="sid",resultType=Integer.class,statement="select usersPkSequence.nextval from dual")
	@Insert("insert into users(sid,sname,age,birth) values(#{sid},#{sname},#{age},#{birth})")
	public void add(User user);

	@Delete("delete from users where sid=#{sid}")
	public void deleteByid(int sid);

	@Update("update users set sname=#{sname},age=#{age} where sid=#{sid}")
	public void update(User user);

	@Select("select * from users where sid = #{sid}")
	public User getById(int sid);

	@Select("select * from users where 1=1")
	public List<User> getAllUser();
}
