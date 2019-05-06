package program.player;

import program.GameWindow;
import program.Settings;
import tklibs.Mathx;

public class Player3 extends Player {
    public Player3(double x){
        super(x,"images/paddle/blue.png");
    }
    @Override
    public void move(){
        double spd = Settings.PLAYER_SPEED;
        double vx = 0;
        double vy = 0;

        if(GameWindow.isUpPress3) {
            vy -= spd;
        }
        if(GameWindow.isRightPress3) {
            vx += spd;
        }
        if(GameWindow.isDownPress3) {
            vy += spd;
        }
        if(GameWindow.isLeftPress3) {
            vx -= spd;
        }

        if(vx != 0 && vy != 0) {
            double v = spd / Math.sqrt(2);
            vx = Math.signum(vx) * v; // 1 * 5 * sqrt(2)
            vy = Math.signum(vy) * v; // -1 * 5 * sqrt(2)
        }

//        position.add(vx, vy);
        velocity.set(vx, vy);
    }

//    @Override
//    public void limitPosition() {
//        double minX=Settings.PLAYER_WIDTH/2+Settings.VERWALL_WIDTH+5+Settings.GAME_WIDTH/2;
//        double minY=Settings.PLAYER_HEIGHT/2+Settings.HORIWALL_HEIGHT+2;
//        double maxX=Settings.GAME_WIDTH -Settings.PLAYER_WIDTH/2-Settings.VERWALL_WIDTH-5-50;
//        double maxY=Settings.GAME_HEIGHT-Settings.PLAYER_HEIGHT/2 -Settings.HORIWALL_HEIGHT-2;
//        position.setX(Mathx.clamp(position.x, minX, maxX));
//        position.setY(Mathx.clamp(position.y, minY, maxY));
//    }
}
