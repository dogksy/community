package com.zty.community;

import com.zty.community.modular.dao.UserMapper;
import com.zty.community.modular.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@SpringBootTest
class CommunityApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    private void seleceINfo() {
        List<Map<String, Object>> mapList = userMapper.selectMaps();
        mapList.forEach(item->System.out.println(item));
    }
}
