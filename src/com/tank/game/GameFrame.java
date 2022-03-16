package com.tank.game;

import com.tank.util.Constant;
import sun.security.mscapi.CPublicKey;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

/**
 * @Author: zqiusen@qq.com
 * @Date: 2022/3/9 19:15
 */

/**
 * 游戏的主窗口类，即顶层窗口类
 * 所以的游戏展示的内容都要再此类内实现
 */
public class GameFrame extends Frame implements Runnable{
    // 定义一张和屏幕大小一致的图片
    private BufferedImage bufImg = new BufferedImage(Constant.FRAME_WIdTH, Constant.FRAME_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);

    //表示游戏状态
    public static int gameState;
    //菜单指向
    private int menuIndex;
    //标题栏的高度
    public static int titleBarH;
    public static int frameBottom;
    public static int frameLeft;
    public static int frameRight;

    //定义坦克对象
    private Tank myTank;
    /**
     * 一个方法尽量不要超过50行
     * 对窗口进行初始化
     * @throws HeadlessException
     */
    public GameFrame() throws HeadlessException {
        initFrame();
        initEventListener();
        //启动用于刷新窗口的线程
        new Thread(this).start();
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
//        //调用画笔
//        repaint();
        //求窗口四周的隐藏边框大小，用于防止坦克的一部分被遮住看不见，
        //在老师的视频中没有表现出来，可能是操作系统版本不同
        //求标题栏的高度
        titleBarH =  getInsets().top;
        frameBottom = getInsets().bottom;
        frameLeft = getInsets().left;
        frameRight = getInsets().right;
    }

    /**
     * 是Frame类的方法,继承下来的方法,
     * 该方法负责了所有的绘制的内容,所有需要在屏幕中显示的内容,都要在
     * 该方法内调用. 该方法不能主动调用. 必须通过调用repaint():去回
     * 调该方法
     * @param g1
     */
    @Override
    public void update(Graphics g1) {
        //2:得到图片的画笔,之前一直在窗口上直接绘制,现在在图片上绘制
        Graphics g = bufImg.getGraphics();
        //3:使用图片画笔将所有的内容绘制到图片中
        //设置字体
        g.setFont(Constant.GAME_FONT);
        switch (gameState){
            case Constant.STAtE_MENU:
                drawMenu(g);
                break;
            case Constant.STAtE_HELP:
                drawHelp(g);
                break;
            case Constant.STAtE_ABOUT:
                drawAbout(g);
                break;
            case Constant.STAtE_RUN:
                drawRun(g);
                break;
            case Constant.STAtE_OVER:
                drawOver(g);
                break;
        }
        //4:使用系统画笔,将图片绘制到frame上来
        g1.drawImage(bufImg,0,0, null);
    }


    private void drawHelp(Graphics g) {
    }
    private void drawAbout(Graphics g) {
    }
    private void drawRun(Graphics g) {
        //绘制黑色的背景
        //拿一个黑色的画笔
        g.setColor(Color.BLACK);
        //用画笔涂黑的区域
        g.fillRect(0,0, Constant.FRAME_WIdTH, Constant.FRAME_HEIGHT);

        myTank.draw(g);
    }
    private void drawOver(Graphics g) {
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
        final int STR_WIDTH = 76;
        int x = Constant.FRAME_WIdTH - STR_WIDTH >> 1;
        //从1/3处高度开始绘制
        int y = Constant.FRAME_HEIGHT / 3;
        //行间距
        final int DIS = 50;
        //以上的常量只在这个方法中使用,故不放入Constant
        for (int i = 0; i < Constant.MENUS.length; i++) {
            //选中的菜单项设置为红色，其他的为白色
            if(i == menuIndex){
                g.setColor(Color.RED);
            }
            else g.setColor(Color.WHITE);
            g.drawString(Constant.MENUS[i], x,y + DIS * i);
        }
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
        addKeyListener(new KeyAdapter() {
            //按键被按下的时候被回调的方法
            @Override
            public void keyPressed(KeyEvent e) {
                //获得被按下键的键值
                int keyCode = e.getKeyCode();
                //不同的游戏状态，给出不同的处理的方法
                switch (gameState){
                    case Constant.STAtE_MENU:
                        keyPressedEventMenu(keyCode);
                        break;
                    case Constant.STAtE_HELP:
                        keyPressedEventHelp(keyCode);
                        break;
                    case Constant.STAtE_ABOUT:
                        keyPressedEventAbout(keyCode);
                        break;
                    case Constant.STAtE_RUN:
                        keyPressedEventRun(keyCode);
                        break;
                    case Constant.STAtE_OVER:
                        keyPressedEventOver(keyCode);
                        break;
                }
            }


            //按键松开的时候回调的内容
            @Override
            public void keyReleased(KeyEvent e) {
                //获得被松开键的键值
                int keyCode = e.getKeyCode();
                //不同的游戏状态，给出不同的处理的方法
                if(gameState == Constant.STAtE_RUN){
                    keyReleasedEventRun(keyCode);
                }
            }
        });
    }

    /**
     * 按键松开的时候，游戏中的处理方法
     * @param keyCode
     */
    private void keyReleasedEventRun(int keyCode) {
        switch (keyCode){
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                myTank.setState(Tank.STATE_STAND);
                break;

        }
    }

    private void keyPressedEventOver(int keyCode) {
    }

    private void keyPressedEventRun(int keyCode) {
        switch (keyCode){
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                myTank.setDir(Tank.DIR_UP);
                myTank.setState(Tank.STATE_MOVE);
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                myTank.setDir(Tank.DIR_DOwN);
                myTank.setState(Tank.STATE_MOVE);
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                myTank.setDir(Tank.DIR_LEFT);
                myTank.setState(Tank.STATE_MOVE);
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                myTank.setDir(Tank.DiR_RIGHT);
                myTank.setState(Tank.STATE_MOVE);
                break;
            case KeyEvent.VK_SPACE:
                myTank.fire();
                break;

        }
    }

    private void keyPressedEventAbout(int keyCode) {
    }

    private void keyPressedEventHelp(int keyCode) {
    }
    //菜单状态下的按键的处理
    private void keyPressedEventMenu(int keyCode) {
        switch (keyCode){
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                if(--menuIndex < 0) {
                    menuIndex = Constant.MENUS.length - 1;
                }
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                if(++menuIndex > Constant.MENUS.length - 1){
                    menuIndex = 0;
                }
                break;
            case KeyEvent.VK_ENTER:
                //TODO
                newGame();
                break;

        }
    }

    /**
     * 开始新游戏的方法
     */
    private void newGame() {
        gameState = Constant.STAtE_RUN;
        myTank = new Tank(400,200, Tank.DIR_DOwN);
    }

    @Override
    public void run() {
        /**
         * 在此调用repaint,回调update
         */
        while(true){
            repaint();
            try {
                Thread.sleep(Constant.REPAINT_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
