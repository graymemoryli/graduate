package com.hwadee.train.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//String 转换的类型
//date转换成的类型
public class MyDateConverter implements Converter<String, Date> {

    public Date convert(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return null;
    }
}
