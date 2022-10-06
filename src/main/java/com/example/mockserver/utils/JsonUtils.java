package com.example.mockserver.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Objects;

/**
 * @author WawaGuess
 * @project codeExample
 * @Date 2022/10/1
 * 【到下一行】shift + enter
 * 【定位到某一行】command + L
 * 【定位到行首/行尾】command + 方向键
 * 【在下一行插入一个空行】command + enter
 * 【构造方法/toString/override提示】control + enter
 */
public class JsonUtils {

    public static final ObjectMapper mapper = new ObjectMapper();

    /**
     * 将对象转换成json String类型
     *
     * @param object 传入的object
     * @return json数据类型
     */
    public static String object2String(Object object) {
        String result = null;
        if (Objects.nonNull(object)) {
            try {
                result = mapper.writeValueAsString(object);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    /**
     * 将json数据转换成对应的实体类
     *
     * @param str   传入的String数据
     * @param clazz 要转换成的实体类
     * @param <T>   实体类的类型
     * @return 数据转换后的实体类
     */
    public static <T> T string2Object(String str, Class<T> clazz) {
        T result = null;
        try {
            result = mapper.readValue(str, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
