package net.will.ebook.user.persistence;

import net.will.ebook.user.domain.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}