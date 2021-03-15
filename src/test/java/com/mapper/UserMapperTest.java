package com.mapper;

import com.domain.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @author setusb
 * @version 1.0
 * @date 2021/3/15 15:20
 */
public class UserMapperTest {
    private static UserMapper mapper;

    @BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(UserMapperTest.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/UserMapperTestConfiguration.xml"));
        mapper = builder.getConfiguration().getMapper(UserMapper.class, builder.openSession(true));
    }

    /**
     * 测试查询全部用户能否使用
     * 测试时间: 2021.3.15 15:55
     * 通过人: 程志豪
     */
    @Test
    public void testFindByAllCzh() {
        List<User> list = mapper.findByAllCzh();
        for (User u : list) {
            System.out.println(u.toString());
        }
    }

    /**
     * 测试依据ID查询单个用户能否使用
     * 测试时间: 2021.3.15 15:58
     * 通过人: 程志豪
     */
    @Test
    public void testFindByIdCzh() {
        List<User> list = mapper.findByIdCzh(6);
        for (User u : list) {
            System.out.println(u.toString());
        }
    }

    /**
     * 插入user实体类到user表
     * 测试时间: 2021.3.15 16:05
     * 通过人: 程志豪
     */
    @Test
    public void testInsertCzh() {
        if (mapper.insertCzh(new User("程志豪", "男", new Date(), 1234567890, "中国湖北")) == 1) {
            System.out.println("插入成功！");
        } else {
            System.out.println("插入失败！");
        }
    }

    /**
     * 依据ID更新user表
     * 测试时间: 2021.3.15 16:33
     * 通过人: 程志豪
     */
    @Test
    public void testUpdateByIdCzh() {
        if (mapper.updateByIdCzh(new User("程志豪", "男", new Date(), 1234567890, "中国湖北"), 2) == 1) {
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败！");
        }
    }

    /**
     * 依据ID删除user表中的信息
     * 测试时: 2021.3.15 16:39
     * 通过人: 程志豪
     */
    @Test
    public void testDeleteByIdCzh() {
        if (mapper.deleteByIdCzh(2) == 1) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }
}
