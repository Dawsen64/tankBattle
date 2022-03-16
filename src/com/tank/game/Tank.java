package com.tank.game;

/**
 * @Author: zqiusen@qq.com
 * @Date: 2022/3/10 15:23
 */

import com.tank.util.Constant;
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
    public static final int RADIUS = 20;
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
    private List<Bullet> bullets = new ArrayList<>();

    public Tank(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        //随机颜色
        this.color = MyUtil.getRandomColor();
        this.speed = DEFAUlT_SPEED;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    /**
     * 绘制坦克
     * @param g
     */
    public void draw(Graphics g){
        logic();

        drawTank(g);

        drawBullets(g);
        //
    }

    /**
     * 画坦克和炮筒
     * @param g
     */
    private void drawTank(Graphics g){
        g.setColor(color);
        //绘制坦克的圆
        g.fillOval(x-RADIUS, y-RADIUS, RADIUS<<1,RADIUS<<1);
        int endX = x;
        int endY = y;
        switch (dir){
            case DIR_UP:
                endY = y - RADIUS*2;
                //使线拉粗
                g.drawLine(x-1, y, endX-1, endY);
                g.drawLine(x+1, y, endX+1, endY);
                break;
            case DIR_DOwN:
                endY = y + RADIUS*2;
                g.drawLine(x-1, y, endX-1, endY);
                g.drawLine(x+1, y, endX+1, endY);
                break;
            case DIR_LEFT:
                endX = x - RADIUS*2;
                g.drawLine(x, y-1, endX, endY-1);
                g.drawLine(x, y, endX+1, endY+1);
                break;
            case DiR_RIGHT:
                endX = x + RADIUS*2;
                g.drawLine(x, y-1, endX, endY-1);
                g.drawLine(x, y+1, endX, endY+1);
                break;
        }
        g.drawLine(x, y, endX, endY);
    }

    /**
     * 坦克的逻辑处理
     */
    private void logic(){
        switch (state){
            case STATE_STAND:
                break;
            case STATE_MOVE:
                move();
                break;
            case STATE_DIE:
                break;
        }
    }
    //坦克的移动的功能
    private void move(){
        switch (dir){
            case DIR_UP:
                y -= speed;
                if (y < RADIUS + GameFrame.titleBarH){
                    y = RADIUS + GameFrame.titleBarH;
                }
                break;
            case DIR_DOwN:
                y += speed;
                if (y > Constant.FRAME_HEIGHT - RADIUS - GameFrame.frameBottom){
                    y = Constant.FRAME_HEIGHT - RADIUS - GameFrame.frameBottom;
                }
                break;
            case DIR_LEFT:
                x -= speed;
                if(x < RADIUS + GameFrame.frameLeft){
                    x = RADIUS + GameFrame.frameLeft;
                }
                break;
            case DiR_RIGHT:
                x += speed;
                if(x > Constant.FRAME_WIdTH - RADIUS - GameFrame.frameRight){
                    x = Constant.FRAME_WIdTH - RADIUS - GameFrame.frameRight;
                }
                break;
        }


    }

    /**
     * 坦克发射炮弹的功能
     *  创建了一个子弹对象, 子弹的对象的属性信息通过坦克的信息获得
     *  然后将创建的子弹添加到坦克的管理的容器中
     */
    public void fire(){
        int bulletX = x;
        int bulletY = y;
        switch (dir){
            case DIR_UP:
                bulletY -= 2*RADIUS;
                break;
            case DIR_DOwN:
                bulletY += 2*RADIUS;
                break;
            case DIR_LEFT:
                bulletX -= 2*RADIUS;
                break;
            case DiR_RIGHT:
                bulletX += 2*RADIUS;
                break;

        }
        Bullet bullet = new Bullet(bulletX, bulletY, dir, atk, color);
        bullets.add(bullet);

    }
    /**
     * 将当前坦克发射的所有的子弹绘制出来
     * @param g
     */
    private void drawBullets(Graphics g){
        for (Bullet bullet : bullets){
            bullet.draw(g);
        }
    }
}
