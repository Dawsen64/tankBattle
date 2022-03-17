package com.tank.game;

/**
 * @Author: zqiusen@qq.com
 * @Date: 2022/3/12 14:31
 */

import com.tank.util.Constant;

import java.awt.*;

/**
 * 子弹类
 */
public class Bullet {
    //子弹的默认的速度为坦克速度的2倍
    public static final int DEFAULT_SPEED = Tank.DEFAUlT_SPEED << 1;
    // 炮弹的半径
    public static final int RADIUS = 4;
    private int x, y;
    private int speed = DEFAULT_SPEED;
    private int dir;
    private int atk;
    private Color color;
    //子弹是否可见
    private boolean visible = true;

    public Bullet(int x, int y, int dir, int atk, Color color) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.atk = atk;
        this.color = color;
    }
    //给对象池使用的, 所有的属性都是默认值
    public Bullet() {

    }

    /**
     * 炮弹的自身的绘制的方法
     * @param g
     */
    public void draw(Graphics g){
        if (!visible)
            return;
        logic();
        g.setColor(color);
        g.fillOval(x-RADIUS, y-RADIUS, RADIUS<<1,RADIUS<<1);
    }

    /**
     * 子弹的逻辑
     */
    private void logic(){
        move();
    }
    //子弹的移动
    private  void move(){
        switch (dir){
            case Tank.DIR_UP:
                y -= speed;
                if (y <= 0)
                    visible = false;
                break;
            case Tank.DIR_DOwN:
                y += speed;
                if (y > Constant.FRAME_HEIGHT)
                    visible = false;
                break;
            case Tank.DIR_LEFT:
                x -= speed;
                if(x < 0)
                    visible = false;
                break;
            case Tank.DiR_RIGHT:
                x += speed;
                if(x > Constant.FRAME_WIdTH)
                    visible = false;
                break;
        }
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

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
