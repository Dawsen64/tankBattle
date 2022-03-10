package com.tank.game;

import com.tank.util.Constant;
import sun.security.mscapi.CPublicKey;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author: zqiusen@qq.com
 * @Date: 2022/3/9 19:15
 */

/**
 * 游戏的主窗口类，即顶层窗口类
 * 所以的游戏展示的内容都要再此类内实现
 */
public class GameFrame extends Frame {
    //表示游戏状态
    public static int gameState;

    /**
     * 一个方法尽量不要超过50行
     * 对窗口进行初始化
     * @throws HeadlessException
     */
    public GameFrame() throws HeadlessException {
        initFrame();
        initEventListener();
    }
    private void initGame(){

    }


    /**
     * 属性进行初始化
     */
    private void initFrame(){
        setTitle(Constant.GAME_TITLE);
        //设置窗口大小
        setSize(Constant.FRAME_WIdTH,Constant.FRAME_HEIGHT);

        //设置窗口左上角的坐标
        setLocation(Constant.FRAME_X, Constant.FRAME_Y);

        //设置窗口大小不可改变
        setResizable(false);

        //设置窗口可见
        setVisible(true);
    }

    /**
     * 初始化事件的监听
     */
    private void initEventListener(){
        //注册监听事件
        addWindowListener(new WindowAdapter() {
            /**
             * 点击关闭按钮的时候，方法会被自动调用
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 是Frame类的方法,继承下来的方法,
     * 该方法负责了所有的绘制的内容,所有需要在屏幕中显示的内容,都要在
     * 该方法内调用. 该方法不能主动调用. 必须通过调用repaint():去回
     * 调该方法
     * @param g
     */
    @Override
    public void update(Graphics g) {
        switch (gameState){
            case Constant.STAtE_MENU:
                drawMenu(g);
                break;
            case Constant.STAtE_HELP:
                break;
            case Constant.STAtE_ABOUT:

                break;
            case Constant.STAtE_RUN:

                break;
            case Constant.STAtE_OVER:
                break;
        }
    }

    /**
     * 绘制菜单状态下的内容
     * @param g 画笔对象,系统提供的,直接用,老师等下说明
     */
    private void drawMenu(Graphics g){
        //绘制黑色的背景

        //拿一个黑色的画笔
        g.setColor(Color.BLACK);
        //用画笔涂黑的区域
        g.fillRect(0,0, Constant.FRAME_WIdTH, Constant.FRAME_HEIGHT);
        // 把画笔换成白色 写字
        g.setColor(Color.WHITE);
        //估计字符串在屏幕上的宽度是50像素, 可以精确的求但是比较麻烦
        final int STR_WIDTH = 50;
        int x = Constant.FRAME_WIdTH - STR_WIDTH >> 1;
        //从1/3处高度开始绘制
        int y = Constant.FRAME_HEIGHT / 3;
        //行间距
        final int DIS = 30;
        //以上的常量只在这个方法中使用,故不放入Constant
        for (int i = 0; i < Constant.MENUS.length; i++) {
            g.drawString(Constant.MENUS[i], x,y + DIS * i);
        }
    }
}
