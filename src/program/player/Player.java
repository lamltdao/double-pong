package program.player;

import program.GameObject;
import program.Settings;
import program.physics.BoxCollider;
import program.renderer.SingleImageRenderer;
import tklibs.Mathx;

import java.awt.*;

public class Player extends GameObject {



    public Player(double x,String filepath) {

       // program.renderer = new SingleImageRenderer("");

        position.setX(x);
        position.setY(Settings.GAME_HEIGHT/2);
        renderer=new SingleImageRenderer(filepath);
        hitBox= new BoxCollider(this,Settings.PLAYER_WIDTH,Settings.PLAYER_HEIGHT);

    }

    public Player(){}

//    @Override
//    public void render(Graphics g){
//        g.setColor(this.color);
//        g.fillRect((int)(this.position.x-this.anchor.x*Settings.PLAYER_WIDTH),(int)(this.position.y-this.anchor.y*Settings.PLAYER_HEIGHT),Settings.PLAYER_WIDTH,Settings.PLAYER_HEIGHT);
//    }


    public void run() {
        super.run(); // position.add(velocity)
        this.move();
       this.limitPosition();


    }



    public void move() {

    }

    public void limitPosition() {
        double minX=Settings.PLAYER_WIDTH/2+Settings.VERWALL_WIDTH+5;
        double minY=Settings.PLAYER_HEIGHT/2+Settings.HORIWALL_HEIGHT+2;
        double maxX=Settings.GAME_WIDTH -Settings.PLAYER_WIDTH/2-Settings.VERWALL_WIDTH-5;
        double maxY=Settings.GAME_HEIGHT-Settings.PLAYER_HEIGHT/2 -Settings.HORIWALL_HEIGHT-2;
        position.setX(Mathx.clamp(position.x, minX, maxX));
        position.setY(Mathx.clamp(position.y, minY, maxY));
    }



}
