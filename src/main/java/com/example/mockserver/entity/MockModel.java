package com.example.mockserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

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
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@TableName("mock_server")
public class MockModel {

    @TableId(value = "id", type = IdType.AUTO)
    @JsonProperty("id")
    private Integer id;

    @TableField("path")
    @JsonProperty("path")
    @NotNull
    private String path;

    @TableField("http_method")
    @JsonProperty("http_method")
    @NotNull
    private String httpMethod;

    @TableField("headers")
    @JsonProperty("headers")
    private Map<String, String> headers;

    @TableField("request_body")
    @JsonProperty("request_body")
    private String requestBody;

    @TableField("response_status")
    @JsonProperty("response_status")
    @NotNull
    private Integer responseStatus;

    @TableField("response_body")
    @JsonProperty("response_body")
    @NotNull
    private String responseBody;

    @Override
    public String toString() {
        return "{" +
                "id=" + id + ", \n" +
                "path='" + path + '\'' + ", \n" +
                "httpMethod='" + httpMethod + '\'' + ", \n" +
                "headers='" + headers + '\'' + ",\n" +
                "requestBody='" + requestBody + '\'' + ",\n" +
                "responseStatus='" + responseStatus + '\'' + ",\n" +
                "responseBody='" + responseBody + '\'' + "\n" +
                '}';
    }
}
