***********项目说明文件**********
1:对游戏的窗口进行初始化，设置标题，大小，坐标，窗口的事件的监听

2:游戏菜单的显示，以及游戏菜单的按键的控制
  游戏被分成了若干个游戏的状态:
    游戏菜单 *
    游戏的帮助
    游戏的关于
    游戏中 //最复杂
    游戏结束
  **在不同的状态下，绘制不同的内容，按键有不同的处理的方式

3:调整整个游戏窗口的重绘机制.
FPS: frame per second
要每秒固定的刷新我们的整个窗口，fps = 33
每隔30ms刷新一次(对整个窗口进行重绘), repaint()
    单独启动一个*线程*, 用于窗口的重绘
4:坦克类的定义,和绘制

5:坦克的四方向行走,以及边界的控制

6:坦克发射子弹

7：坦克的绘制使用图片

8:解决屏幕闪烁的问题  双缓冲解决

9:子弹的效率问题:
解决方案: 使用对象池来解决: 提前创建好若干个子弹对象,放到一个容器中,
    需要的时候从对象池中拿一个出来使用,当子弹需要被销毁的时候,放回到原来的对象池中.

10:敌人坦克的控制
    1: 随机的在屏幕的左上角和右上角产生敌人的坦克
    2: 坦克相关的类: 父类:Tank 子类: MyTank EnemyTank
