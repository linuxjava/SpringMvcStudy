package cn.itcast.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        if(source == null){
            throw new RuntimeException("数据不能为NULL");
        }
        SimpleDateFormat simpleDateFormat;
        if(source.contains("-")) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        }else {
            simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        }
        try {
            return simpleDateFormat.parse(source);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换出现错误");
        }
    }
}
