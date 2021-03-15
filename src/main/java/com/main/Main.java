package com.main;

import com.domain.User;
import com.mapper.UserMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author setusb
 * @version 1.0
 * @date 2021/3/15 20:53
 */
public class Main {
    private static final UserMapper MAPPER;

    static {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(Main.class.getClassLoader().getResourceAsStream("MapperConfiguration.xml"));
        MAPPER = builder.getConfiguration().getMapper(UserMapper.class, builder.openSession(true));
        initialData();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("---======【欢迎访问Mybatis】======---" +
                    "\n你可以输入相应的数字实现想要的功能！" +
                    "\n输入1【查询所有用户】" +
                    "\n输入2【ID查询用户】" +
                    "\n输入3【创建新用户】" +
                    "\n输入4【ID更新用户】" +
                    "\n输入5【ID删除用户】" +
                    "\n输入0【退出】");
            int num = new Scanner(System.in).nextInt();
            if (num == 1) {
                s1();
            }
            if (num == 2) {
                s2();
            }
            if (num == 3) {
                s3();
            }
            if (num == 4) {
                s4();
            }
            if (num == 5) {
                s5();
            }
            if (num == 0) {
                System.out.println("欢迎您的使用!" +
                        "\n作者：程志豪");
                break;
            }
        }
    }

    private static void initialData() {
        if (MAPPER.findByIdCzh(1).isEmpty()) {
            String username = "程志豪";
            String sex = "男";
            int iphone = 1234567890;
            String address = "中国湖北";
            if (MAPPER.insertCzh(new User(username,sex,new Date(),iphone,address)) == 1) {
                System.out.println("初始化数据库成功，添加初始数据一条！");
            } else {
                System.out.println("初始化数据库失败！");
            }
        } else {
            System.out.println("使用云数据库，无需初始化！");
        }
    }

    private static void s1() {
        List<User> list = MAPPER.findByAllCzh();
        for (User u : list) {
            System.out.println(u.toString());
        }
        System.out.println("\n\n\n");
    }

    private static void s2() {
        System.out.println("请输入ID:");
        List<User> list = MAPPER.findByIdCzh(new Scanner(System.in).nextInt());
        if (list.isEmpty()) {
            System.out.println("没有此ID的信息\n\n\n");
        } else {
            System.out.println(list.toString() + "\n\n\n");
        }
    }

    private static void s3() {
        if (MAPPER.insertCzh(userInput()) == 1) {
            System.out.println("操作成功！");
        } else {
            System.out.println("操作失败！");
        }
    }

    private static void s4() {
        System.out.println("请输入要修改的ID:");
        int id = new Scanner(System.in).nextInt();
        List<User> list = MAPPER.findByIdCzh(id);
        if (list.isEmpty()) {
            System.out.println("无法修改此ID，因为数据库中没有！");
        } else {
            while (true) {
                System.out.println("请选择你要修改的信息:" +
                        "\n输入1【修改姓名】" +
                        "\n输入2【修改性别】" +
                        "\n输入3【修改电话】" +
                        "\n输入4【修改地址】" +
                        "\n输入5【全部修改】" +
                        "\n输入0【退出修改】");
                int updateNum = new Scanner(System.in).nextInt();
                if (updateNum == 1) {
                    System.out.println("请输入姓名:");
                    String name = new Scanner(System.in).next();
                    User user = list.get(0);
                    user.setUsername(name);
                    if (MAPPER.updateByIdCzh(user, id) == 1) {
                        System.out.println("更新姓名成功！");
                        break;
                    } else {
                        System.out.println("更新姓名失败！");
                    }
                }
                if (updateNum == 2) {
                    String sex = compareSex();
                    User user = list.get(0);
                    user.setSex(sex);
                    if (MAPPER.updateByIdCzh(user, id) == 1) {
                        System.out.println("更新性别成功！");
                        break;
                    } else {
                        System.out.println("更新性别失败！");
                    }
                }
                if (updateNum == 3) {
                    String iphone = compareIphone();
                    User user = list.get(0);
                    user.setIphone(Integer.valueOf(iphone));
                    if (MAPPER.updateByIdCzh(user, id) == 1) {
                        System.out.println("更新电话成功！");
                        break;
                    } else {
                        System.out.println("更新电话失败！");
                    }
                }
                if (updateNum == 4) {
                    System.out.println("请输入你的地址:");
                    String address = new Scanner(System.in).next();
                    User user = list.get(0);
                    user.setAddress(address);
                    if (MAPPER.updateByIdCzh(user, id) == 1) {
                        System.out.println("更新地址成功！");
                        break;
                    } else {
                        System.out.println("更新地址失败！");
                    }
                }
                if (updateNum == 5) {
                    if (MAPPER.updateByIdCzh(userInput(), id) == 1) {
                        System.out.println("全部修改成功！");
                        break;
                    } else {
                        System.out.println("全部修改失败！");
                    }
                }
                if (updateNum == 0) {
                    System.out.println("更新已退出\n\n\n");
                    break;
                }
            }
        }
    }

    private static void s5() {
        System.out.println("请输入删除用户的ID:");
        int id = new Scanner(System.in).nextInt();
        if (id == 1) {
            System.out.println("你无法删除初始用户数据！");
        } else if (id > 1) {
            if (MAPPER.deleteByIdCzh(id) == 1) {
                System.out.println("删除成功！");
            } else {
                System.out.println("删除失败！");
            }
        }
    }

    private static String compareSex() {
        String sex;
        while (true) {
            System.out.println("请输入性别:");
            sex = new Scanner(System.in).next();
            if ("男".equals(sex)) {
                break;
            } else if ("女".equals(sex)) {
                break;
            } else {
                System.out.println("性别指定错误，请重新指定!");
            }
        }
        return sex;
    }

    private static String compareIphone() {
        String iphone;
        while (true) {
            System.out.println("请输入电话号码:");
            iphone = new Scanner(System.in).next();
            if (iphone.length() <= 10) {
                break;
            } else {
                System.out.println("长度限制【10位以内】，请重新输入！");
            }
        }
        return iphone;
    }

    private static User userInput() {
        System.out.println("请输入姓名:");
        String name = new Scanner(System.in).next();
        String sex = compareSex();
        String iphone = compareIphone();
        System.out.println("请输入你的地址:");
        String address = new Scanner(System.in).next();
        int iphoneInt = Integer.parseInt(iphone);
        return new User(name, sex, new Date(), iphoneInt, address);
    }
}
