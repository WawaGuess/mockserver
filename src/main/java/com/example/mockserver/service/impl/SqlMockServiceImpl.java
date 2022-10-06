package com.example.mockserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.mockserver.dao.ModelDao;
import com.example.mockserver.entity.MockModel;
import com.example.mockserver.service.IMockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@Service
@ConditionalOnProperty(prefix = "server", name = "model", havingValue = "sql")
public class SqlMockServiceImpl implements IMockService {

    @Autowired
    private ModelDao modelDao;

    @Override
    public Boolean registerModel(MockModel model) {
        return modelDao.saveOrUpdate(model, buildWrapper(model));
    }

    @Override
    public ResponseEntity<Object> getMock(HttpServletRequest request) {

        QueryWrapper<MockModel> wrapper = new QueryWrapper<MockModel>()
                .eq("path", request.getRequestURI())
                .eq("http_method", request.getMethod());

        MockModel one = modelDao.getOne(wrapper, true);
        return new ResponseEntity(one.getResponseBody(), HttpStatus.valueOf(one.getResponseStatus()));
    }

    @Override
    public Map<String, Object> getAllModels() {

        List<MockModel> allModels = modelDao.list();
        HashMap<String, Object> results = new HashMap<>();
        if (!allModels.isEmpty()) {
            results.put("nums", allModels.size());
            results.put("models", allModels);
        }
        return results;
    }

    @Override
    public Boolean deleteModel(MockModel mockModel) {
        return modelDao.remove(buildWrapper(mockModel));
    }


    private UpdateWrapper<MockModel> buildWrapper(MockModel model) {
        return new UpdateWrapper<MockModel>()
                .eq("path", model.getPath())
                .eq("http_method", model.getHttpMethod())
                .eq("response_status", model.getResponseStatus())
                .eq("response_body", model.getResponseBody());
    }
}
