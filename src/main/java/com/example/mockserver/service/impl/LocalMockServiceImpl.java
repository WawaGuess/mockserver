package com.example.mockserver.service.impl;

import com.example.mockserver.entity.MockModel;
import com.example.mockserver.service.IMockService;
import com.example.mockserver.utils.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author WawaGuess
 * @project mockserver
 * @Date 2022/10/5
 * 【到下一行】shift + enter
 * 【定位到某一行】command + L
 * 【定位到行首/行尾】command + 方向键
 * 【在下一行插入一个空行】command + enter
 * 【构造方法/toString/override提示】control + enter
 */

@Service
@ConditionalOnProperty(prefix = "server", name = "model", havingValue = "local")
public class LocalMockServiceImpl implements IMockService {

    @Value("${server.mock.filePath}")
    private String filePath;

    @Override
    public Boolean registerModel(MockModel model) {

        String path = StringUtils.replace(model.getPath(), "/", "_");
        String fileName = "/" + model.getHttpMethod() + path + ".json";
        return FileUtils.object2WriteJsonFile(filePath + fileName, model);
    }

    @Override
    public ResponseEntity<Object> getMock(HttpServletRequest request) {
        return null;
    }

    @Override
    public Map<String, Object> getAllModels() {
        return null;
    }

    @Override
    public Boolean deleteModel(MockModel mockModel) {
        return null;
    }
}
