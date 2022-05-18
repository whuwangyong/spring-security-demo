package cn.whu.wy.usermanager.mapper;

import cn.whu.wy.usermanager.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface IUserMapper extends BaseMapper<User> {

    @Select("select * from user where name=#{name}")
    User selectByName(@Param("name") String name);

}
