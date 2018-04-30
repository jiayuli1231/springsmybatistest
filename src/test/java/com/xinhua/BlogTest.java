package com.xinhua;

import com.xinhua.entities.Blog;
import com.xinhua.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
/**
 * Created by wenli on 2018/4/29.
 */

public class BlogTest {

    private InputStream inputStream;
    private SqlSessionFactory factory;
    private BlogMapper blogMapper;

    @Before
    public void init() throws Exception{
        inputStream= Resources.getResourceAsStream("mybatis-config.xml");
        factory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    @Test
    public void getBlogTest(){
        SqlSession session=factory.openSession();
        blogMapper=session.getMapper(BlogMapper.class);
        Blog blog=blogMapper.getBlog(1);
        System.out.println(blog);

    }
}
