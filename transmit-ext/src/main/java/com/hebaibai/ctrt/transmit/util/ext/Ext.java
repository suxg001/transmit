package com.hebaibai.ctrt.transmit.util.ext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 插件
 *
 * @author hjx
 */
public interface Ext {

    /**
     * 插件. 可扩展
     */
    List<? extends Ext> EXT_LIST = new ArrayList();

    /**
     * @param extCode
     * @return
     */
    boolean support(String extCode);

    /**
     * 获取插件编号
     *
     * @return
     */
    String getCode();


    /**
     * 转发接口的配置参数
     *
     * @param transmitJson
     */
    void setConfig(Map<String, Object> transmitJson);


    /**
     * 获取请求体后
     * 转换参数格式前
     *
     * @param value    请求体中的数据
     * @param valueMap 原始数据(放进freemarker的数据)
     * @return
     */
    void beforRequestConvert(String value, Map<String, Object> valueMap) throws Exception;

    /**
     * 在api请求前前执行
     *
     * @param value    使用模板转换后的数据
     * @param valueMap 原始数据(放进freemarker的数据)
     * @return 插件处理后的数据
     */
    String beforRequest(String value, Map<String, Object> valueMap) throws Exception;

    /**
     * 在api响应后执行
     *
     * @param value    使用模板转换后的数据
     * @param valueMap 原始数据(放进freemarker的数据)
     * @return
     */
    void afterResponse(String value, Map<String, Object> valueMap) throws Exception;

    /**
     * 获取特定的请求头
     *
     * @param value
     * @return
     */
    Map<String, String> requestHeaders(String value) throws Exception;
}
