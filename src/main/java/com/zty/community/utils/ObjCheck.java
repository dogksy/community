package com.zty.community.utils;

import java.lang.reflect.Field;

/**
 * @author zty
 * @date 2021/06/22
 */
public class ObjCheck {
    /**
     * 判断对象中每一个属性是否为空
     *
     * @param object
     * @return
     */
    public static boolean objCheckNull(Object object) {
        // 得到类对象
        Class clazz = object.getClass();
        // 得到所有属性
        Field[] fields = clazz.getDeclaredFields();
        //定义返回结果，默认为true,默认为空
        boolean flag = true;
        for (Field field : fields) {
            field.setAccessible(true);
            Object fieldValue = null;
            try {
                //得到属性值
                fieldValue = field.get(object);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (!field.getName().equals("serialVersionUID") && fieldValue != null) {
                flag = false;
                break;
            } else {
                flag = true;
            }
        }
        return flag;
    }
}
