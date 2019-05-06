package program.player;

import program.GameWindow;
import program.Settings;

public class Player4 extends Player{
    public Player4(double x){
        super(x,"images/paddle/blue.png");
    }
    @Override
    public void move(){
        double spd = Settings.PLAYER_SPEED;
        double vx = 0;
        double vy = 0;
        //Player1
        if(GameWindow.isUpPress4) {
            vy -= spd;
        }

        if(GameWindow.isDownPress4) {
            vy += spd;
        }



        velocity.set(vx, vy);
    }
}
