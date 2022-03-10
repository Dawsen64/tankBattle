package com.tank.game;

/**
 * @Author: zqiusen@qq.com
 * @Date: 2022/3/10 15:23
 */

import com.tank.util.MyUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 坦克类
 */
public class Tank {
    //四个方向
    public static final int DIR_UP = 0;
    public static final int DIR_DOwN = 1;
    public static final int DIR_LEFT = 2;
    public static final int DiR_RIGHT = 3;
    //坦克大小，圆形的半径
    public static final int RADIUS = 16;
    //默认速度 每帧的像素 一帧30ms跑四个像素
    public static final int DEFAUlT_SPEED = 4;
    //坦克的状态
    public static final int STATE_STAND = 0;
    public static final int STATE_MOVE = 1;
    public static final int STATE_DIE = 2;//die
    //坦克的初始生命
    public static final int DEFAULT_HP = 1000;
    //坐标
    private int x, y;

    private int hp;
    private int atk;
    private int speed;
    //方向
    private int dir;
    //坦克的状态
    private int state = STATE_STAND;
    //颜色
    private Color color;
    //TODO 炮弹
    //容器用于管理炮弹,相当与弹夹
    private List bullets = new ArrayList();

    public Tank(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        //随机颜色
        this.color = MyUtil.getRandomColor();
    }

    /**
     * 绘制坦克
     * @param g
     */
    public void draw(Graphics g){

    }
}
