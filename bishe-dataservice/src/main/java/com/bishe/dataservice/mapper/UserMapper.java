package com.bishe.dataservice.mapper;

import com.bishe.api.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByPhone(@Param("phone") String phone);
    /*登录*/
    User selectLogin(@Param("phone") String phone, @Param("loginPassword") String Password);
}
