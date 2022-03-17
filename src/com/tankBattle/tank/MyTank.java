package com.tankBattle.tank;

import com.tankBattle.util.Constant;

import java.awt.*;

/**
 * @Author: zqiusen@qq.com
 * @Date: 2022/3/17 15:19
 */
public class MyTank extends Tank{
    //坦克的图片数组
    private static Image[] tankImg;
    //静态代码块中对它进行初始化
    static {
        tankImg = new Image[4];
        tankImg[0] = Toolkit.getDefaultToolkit().createImage("res/images/player1/p1tankU.gif");
        tankImg[1] = Toolkit.getDefaultToolkit().createImage("res/images/player1/p1tankD.gif");
        tankImg[2] = Toolkit.getDefaultToolkit().createImage("res/images/player1/p1tankL.gif");
        tankImg[3] = Toolkit.getDefaultToolkit().createImage("res/images/player1/p1tankR.gif");
    }



    public MyTank(int x, int y, int dir) {
        super(x, y, dir);
    }

    @Override
    public void drawImgTank(Graphics g) {
        g.drawImage(tankImg[getDir()], getX() - (Constant.TANK_IMG_SIZE / 2), getY() - (Constant.TANK_IMG_SIZE/2), null );
    }


}
