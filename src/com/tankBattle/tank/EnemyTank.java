package com.tankBattle.tank;


import com.tankBattle.game.GameFrame;
import com.tankBattle.util.Constant;
import com.tankBattle.util.MyUtil;

import java.awt.*;

/**
 * @Author: zqiusen@qq.com
 * @Date: 2022/3/17 15:21
 */
public class EnemyTank extends Tank{

    //坦克的图片数组
    private static Image[] enemyImg;

    //静态代码块中对它进行初始化
    static {
        enemyImg = new Image[4];
        enemyImg[0] = Toolkit.getDefaultToolkit().createImage("res/images/enemy/enemy1U.gif");
        enemyImg[1] = Toolkit.getDefaultToolkit().createImage("res/images/enemy/enemy1D.gif");
        enemyImg[2] = Toolkit.getDefaultToolkit().createImage("res/images/enemy/enemy1L.gif");
        enemyImg[3] = Toolkit.getDefaultToolkit().createImage("res/images/enemy/enemy1R.gif");

    }
    public EnemyTank(int x, int y, int dir) {
        super(x, y, dir);
    }

    @Override
    public void drawImgTank(Graphics g) {
            g.drawImage(enemyImg[getDir()], getX() - (Constant.TANK_IMG_SIZE / 2), getY() - (Constant.TANK_IMG_SIZE/2), null );
    }
    //用于创建一个敌人的坦克
    public static EnemyTank createEnemy(){
        int x = MyUtil.getRandomNumber(0,2) == 0 ? RADIUS : Constant.FRAME_WIdTH - RADIUS;
        int y = GameFrame.titleBarH + RADIUS;
        int dir = DIR_DOwN;
        EnemyTank enemy = new EnemyTank(x,y,dir);
        enemy.setEnemy(true);
        //TODO
        enemy.setState(STATE_MOVE);
        return  enemy;
    }
}
