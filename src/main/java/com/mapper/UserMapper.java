package com.mapper;

import com.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author setusb
 * @version 1.0
 * @date 2021/3/15 15:18
 */
public interface UserMapper {
    /**
     * 查询数据库所有user信息
     * 作者: 程志豪
     *
     * @return 返回list数组
     */
    List<User> findByAllCzh();

    /**
     * 依据ID查询user信息
     * 作者: 程志豪
     *
     * @param id 传入int编号
     * @return 返回user实体类
     */
    List<User> findByIdCzh(@Param("id") Integer id);

    /**
     * 插入一条user数据到user表中
     * 作者: 程志豪
     *
     * @param user 传入user实体类
     * @return 返回是否插入成功
     */
    int insertCzh(User user);

    /**
     * 依据ID更新一条数据替换user表的内容
     * 作者: 程志豪
     *
     * @param updated 要修改的user实体类
     * @param id      需要修改的ID
     * @return 返回是否修改成功
     */
    int updateByIdCzh(@Param("updated") User updated, @Param("id") Integer id);

    /**
     * 依据ID删除user表中的用户信息
     * 作者: 程志豪
     *
     * @param id 需要删除的ID
     * @return 返回是否删除成功
     */
    int deleteByIdCzh(@Param("id") Integer id);
}