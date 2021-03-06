package com.tankBattle.util;

import java.awt.*;

/**
 * @Author: zqiusen@qq.com
 * @Date: 2022/3/10 15:42
 */
public class MyUtil {
    private MyUtil(){

    }

    /**
     * 得到指定区间的随机数
     * @param min 区间最小值,包含
     * @param max 区间最大值,不包含
     * @return 随机数
     */
    public static final int getRandomNumber(int min, int max){
        return (int)(Math.random()*(max - min) + min);
    }

    /**
     * 得到随机的颜色
     * @return 颜色
     */
    public static final Color getRandomColor(){
        int red = getRandomNumber(0, 256);
        int blue = getRandomNumber(0, 256);
        int green = getRandomNumber(0, 256);
        return new Color(red, blue, green);
    }
}
