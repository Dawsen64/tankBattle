package com.tank.game;

import com.tank.util.Constant;

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
     * 绘制菜单状态下的内容
     * @param g 画笔对象,系统提供的,直接用,老师等下说明
     */
    private void drawMenu(Graphics g){

    }
}
