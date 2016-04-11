/**
 * 
 */
package com.alpha.puyinapp.util;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * @author Simon
 */
public class JudgePhoneNumber {
    /**
     * 判断手机号码是否合理
     * 
     * @param phoneNum
     */
    public static boolean judgePhoneNums(Context context, String phoneNum) {
        if (isMatchLength(phoneNum, 11) && isMobileNO(phoneNum)) {
            return true;
        }
        Toast.makeText(context, "手机号码输入有误！", Toast.LENGTH_SHORT).show();
        return false;
    }

    public static boolean judgePhoneNums(String phoneNum) {
        if (isMatchLength(phoneNum, 11) && isMobileNO(phoneNum)) {
            return true;
        }
        return false;
    }

    /**
     * 判断一个字符串的位数
     * 
     * @param str
     * @param length
     * @return
     */
    public static boolean isMatchLength(String str, int length) {
        if (str.isEmpty()) {
            return false;
        } else {
            return str.length() == length ? true : false;
        }
    }

    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobileNum) {
        /*
         * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
         * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通）
         * 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
         */
        String telRegex = "[1][358]\\d{9}";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobileNum))
            return false;
        else
            return mobileNum.matches(telRegex);
    }
}
