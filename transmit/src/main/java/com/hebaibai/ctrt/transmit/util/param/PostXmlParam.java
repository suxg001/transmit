package com.hebaibai.ctrt.transmit.util.param;

import com.hebaibai.ctrt.convert.reader.DataReader;
import com.hebaibai.ctrt.convert.reader.XmlDataReader;
import com.hebaibai.ctrt.transmit.DataType;
import com.hebaibai.ctrt.transmit.RouterVo;
import com.hebaibai.ctrt.transmit.util.Param;
import io.vertx.core.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

public class PostXmlParam implements Param {

    @Override
    public boolean support(HttpMethod method, DataType dataType) {
        return method == HttpMethod.POST && dataType == DataType.XML;
    }

    @Override
    public Map<String, Object> params(RouterVo routerVo) {
        XmlDataReader dataReader = new XmlDataReader();
        String requestBody = routerVo.getBody();
        dataReader.read(requestBody);
        return dataReader.getRequestData();
    }

}
