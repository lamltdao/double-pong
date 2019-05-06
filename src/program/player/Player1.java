package program.player;

import program.GameWindow;
import program.Settings;

public class Player1 extends Player {
    public Player1(double x) {

        // program.renderer = new SingleImageRenderer("");
        super(x,"images/paddle/red.png");
//        position.setX(x);
//        position.setY(Settings.GAME_HEIGHT/2);
//        this.color=color;
//        hitBox= new BoxCollider(this,Settings.PLAYER_WIDTH,Settings.PLAYER_HEIGHT);

    }

    @Override
    public void move(){
        double spd = Settings.PLAYER_SPEED;
        double vx = 0;
        double vy = 0;
        //Player1
        if(GameWindow.isUpPress1) {
            vy -= spd;
        }

        if(GameWindow.isDownPress1) {
            vy += spd;
        }



        velocity.set(vx, vy);
    }
}
