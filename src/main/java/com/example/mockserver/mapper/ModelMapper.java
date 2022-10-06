package com.example.mockserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mockserver.entity.MockModel;
import org.apache.ibatis.annotations.Mapper;

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
@Mapper
public interface ModelMapper extends BaseMapper<MockModel> {
}
