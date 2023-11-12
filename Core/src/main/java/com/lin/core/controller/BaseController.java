package com.lin.core.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lin.core.entity.Users;
import com.lin.core.impl.BaseUserServiceImpl;
import com.lin.core.service.BaseService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

@RestController
@RequestMapping("base")
@RefreshScope //在控制器类加入@RefreshScope注解使当前类下的配置支持Nacos的动态刷新功能。
public class BaseController {

    @Autowired
    private BaseService baseService;

    @Autowired
    private BaseUserServiceImpl baseUserService;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    private DruidDataSource druidDataSource;

    @Value("${myFile.path}")
    private String myFilePath;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @PostMapping("test")
    public String test(@RequestBody Users u){
        return baseService.test(u);
    }

    @PostMapping("redisTest")
    public String redisTest(){
        redisTemplate.opsForValue().set("isOk?","666");
        return redisTemplate.opsForValue().get("name").toString();
    }

    @PostMapping("configTest")
    public String configTest(){
        return myFilePath;
    }

    @PostMapping("mybatisplustest")
    public String yasd(){
        LambdaQueryWrapper<Users> qw = new LambdaQueryWrapper<>();
        qw.like(Users::getUsername,"admin");
        baseUserService.getOne(qw);
        return "ok";
    }

    @GetMapping("testGet")
    public String testGet(String para){
        System.out.println("进来1");
        DruidPooledConnection connection = null;
        try {
            connection = druidDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SqlSession sqlSession = sqlSessionFactory.openSession(connection);
        Object o = sqlSession.selectOne("BaseUseraMapper.xxx");
        return para;
    }

    @PostMapping("just")
    public String just(){
        String temp="A1,B91060ED1822D0881B43875CE2F099FE|A2,55C4A6745468131F67098F1593CC96C7DFCE80C042ABBE7FCD436DB81344DABF|A3,06D005E28CF8839AA1927AEA20200137|A4,46D311417E56AEDF0EC09B9255D12D70|A13,994ADF1F6CA73C6BFC32DC403AD1F5BE|A8,ECB9C976F649F55F44AC8793BA2D497F|A10,B49FE0E5E9569196550846181DCAA13011F2C26CD54A327121336E5BD6EDD040|A11,DF716E4EC4037F1A57345E88357E8B69DD75C33A008842BE70BAEFB22E048DB9|A17,584E7AD77C2BCF4DF4589FEF7E3E60AE|A18,B3C9281818007B8F529F26C5A3EA02CF|A19,C96E1E12375673073B872BAC240B36F111F2C26CD54A327121336E5BD6EDD040";
        String s = "";
        try {
            s = URLEncoder.encode(temp, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(s);
        return s;
    }

    @PostMapping("bust")
    public void bust(){
    }

    @PostMapping("puretest")
    public void pure(String name, String age, @RequestBody Map<String,String> map){
        System.out.println(name+","+age);
        System.out.println("=========================");
        System.out.println(map.toString());
    }
}
