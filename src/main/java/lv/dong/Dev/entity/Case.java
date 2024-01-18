package lv.dong.Dev.entity;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

/**
 * @author Donglee
 * @version 1.0
 * @description: TODO
 * @date 2023/12/18 14:29
 */
@Data
public class Case {
    @Alias("请求路径")
    private String apiurl;
    @Alias("描述")
    private String userstory;
    @Alias("请求报文")
    private String requestbody;
    private String reault;
}
