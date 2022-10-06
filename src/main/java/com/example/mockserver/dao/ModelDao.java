package com.example.mockserver.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mockserver.entity.MockModel;
import com.example.mockserver.mapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @author WawaGuess
 * @project mockserver
 * @Date 2022/10/2
 * 【到下一行】shift + enter
 * 【定位到某一行】command + L
 * 【定位到行首/行尾】command + 方向键
 * 【在下一行插入一个空行】command + enter
 * 【构造方法/toString/override提示】control + enter
 */

@Component
@ConditionalOnProperty(prefix = "server", name = "model", havingValue = "sql")
public class ModelDao extends ServiceImpl<ModelMapper, MockModel> implements IService<MockModel> {
}
