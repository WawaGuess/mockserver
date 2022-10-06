package com.example.mockserver.utils;

import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.regex.Pattern;

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
public class FileUtils {

    public static final String FILE_PATH_REGX = "[0-9A-Za-z_.\\-/\\\\:]{1,256}";

    private static final Pattern FILE_PATH_PATTERN = Pattern.compile(FILE_PATH_REGX);

    private static final String BAD_PATH = "../";

    public static boolean isFilePathValid(String filePath) {
        if (isDangerousPath(filePath)) {
            return false;
        }
        return FILE_PATH_PATTERN.matcher(filePath).matches();
    }

    public static boolean isDangerousPath(String filePath) {
        if (!StringUtils.hasText(filePath)) {
            return true;
        }
        return filePath.contains(BAD_PATH);
    }

    /**
     * 读取文件中的数据，加载喂String类型
     *
     * @param path 文件路径
     * @return 返回读取的字符串
     */
    public static String readJsonFile(String path) {
        if (!isFilePathValid(path)) {
            return null;
        }
        String jsonStr = "";
        try {
            File jsonFile = new File(path);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 将Object类数据写入到文件中
     *
     * @param finalPath 要写入的文件路径
     * @param object    要写入的数据
     */
    public static Boolean object2WriteJsonFile(String finalPath, Object object) {
        if (!isFilePathValid(finalPath) || Objects.isNull(object)){
            return false;
        }
        OutputStreamWriter osw = null;
        try {
            osw = new OutputStreamWriter(new FileOutputStream(finalPath), StandardCharsets.UTF_8);
            osw.write(JsonUtils.object2String(object));
            osw.flush();
            osw.close();
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
        return true;
    }
}
