package com.hotnerds.badgeload.dao;

import com.hotnerds.badgeload.config.ApplicationConfig;
import com.hotnerds.badgeload.dto.Member;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import java.sql.Connection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class MemberDaoTest {
    @Autowired
    DataSource dataSource;

    @Autowired
    MemberDao memberDao;

    @Autowired
    MemberRoleDao memberRoleDao;

    @Test
    public void configTest() throws Exception{
    }

    @Test
    public void connectionTest() throws Exception {
        Connection connection = dataSource.getConnection();
        Assert.assertNotNull(connection);
    }

    @Test
    public void getUser() throws Exception {
        Member member = memberDao.getMemberByEmail("test@test.com");
        Assert.assertNotNull(member);
        Assert.assertEquals("테스트", member.getName());
    }
}