package com.blog.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangshaonan on 17/8/29.
 */
public class StringUtil {
    public static int MOBILE_LEN = 13;

    /**
     * 验证移动号码
     * @param str
     * @return
     */
    public static boolean isMobile(String str){
        if(str.length() != MOBILE_LEN)
            return false;
        Pattern pattern = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    /**
     * 验证电话号码
     * @param str
     * @return
     */
   public static boolean isPhone(String str){
        Pattern pattern = Pattern.compile("^[0-9]{4}-[0-9]{6}");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
   }


}
