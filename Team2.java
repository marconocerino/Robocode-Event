package Team2;

import robocode.*;
import java.awt.Color;
import java.util.Random;

public class Team2 extends Robot {

    private final Color BODY_COLOR = new Color(199, 76, 252);
    private final Color GUN_COLOR = new Color(252, 86, 61);
    private final Color RADAR_COLOR = new Color(0, 100, 100);
    private final Color BULLET_COLOR = new Color(255, 255, 100);
    private final Color SCAN_COLOR = new Color(255, 200, 200);

    private Random rand = new Random();

    public void run() {
        setColors(BODY_COLOR, GUN_COLOR, RADAR_COLOR, BULLET_COLOR, SCAN_COLOR);

        while (true) {
            int randNum1 = rand.nextInt(2);
            if (randNum1 == 0) {
                moveRandomly(50, 300);
            } else {
                moveRandomly(150, 400);
            }
        }
    }

    private void moveRandomly(int minDistance, int maxDistance) {
        int distance = rand.nextInt(maxDistance - minDistance + 1) + minDistance;
        ahead(distance);
        turnGunRight(360);
        turnRight(35);
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        fire(2);
    }

    public void onHitByBullet(HitByBulletEvent e) {
        turnLeft(90);
        ahead(rand.nextInt(250) + 150);
    }

    public void onHitWall(HitWallEvent e) {
        turnRight(90);
        ahead(rand.nextInt(200) + 100);
    }
}
