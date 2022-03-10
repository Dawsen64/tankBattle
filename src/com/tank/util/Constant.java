package com.tank.util;

/**
 * @Author: zqiusen@qq.com
 * @Date: 2022/3/9 19:25
 */

import java.awt.*;

/**
 * 用一个类来维护所有的常量
 * 游戏中的常量都在该类中维护，方便后期的管理
 */
public class Constant {
    /*******************游戏窗口相关*************************/
    public static final String GAME_TITLE = "坦克大战";

    public static final int FRAME_WIdTH = 900;
    public static final int FRAME_HEIGHT = 700;

    //获得当前屏幕的宽度，
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int screenWidth = (int)screenSize.getWidth();
    public static int screenHeight = (int)screenSize.getHeight();
    public static final int FRAME_X = (screenWidth - FRAME_WIdTH) >> 1;
    public static final int FRAME_Y = (screenHeight - FRAME_HEIGHT) >> 1;

    /***********************游戏菜单相关*******************/
    public static final int STAtE_MENU = 0;
    public static final int STAtE_HELP = 1;
    public static final int STAtE_ABOUT = 2;
    public static final int STAtE_RUN = 3;
    public static final int STAtE_OVER = 4;
    // 菜单界面显示的汉字按钮
    public static final String[] MENUS = {
        "开始游戏",
        "继续游戏",
        "游戏帮助",
        "关于游戏",
        "退出游戏"
    };



    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(screenSize);
        System.out.println(FRAME_X);
        System.out.println(FRAME_Y);
        System.out.println((1080-700)/2);
    }
    //字体设置
    public static final Font GAME_FONT = new Font("宋体", Font.BOLD, 24);
    public static final int REPAINT_INTERVAL = 30;
}
