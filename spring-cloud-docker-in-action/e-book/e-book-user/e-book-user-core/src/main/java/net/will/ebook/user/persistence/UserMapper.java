package net.will.ebook.user.persistence;

import net.will.ebook.user.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);
    
    int insert(User record);
    
    int insertSelective(User record);
    
    User selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKeySelective(User record);
    
    int updateByPrimaryKey(User record);
    
    public Integer login(@Param("username") String username,@Param("password") String password);
}