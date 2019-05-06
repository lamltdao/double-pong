package program.ball;

import program.GameObject;
import program.Settings;
import program.Vector2D;
import program.goal.Goal;
import program.physics.BoxCollider;
import program.player.Player;
import program.renderer.SingleImageRenderer;

import static java.lang.StrictMath.abs;

public class Ball extends GameObject {
    public Ball() {

        renderer = new SingleImageRenderer("images/ball/1.png");
        position.set(Settings.GAME_WIDTH/2, Settings.GAME_HEIGHT/2);
        velocity.set(Settings.BALL_VELOCITY_X, 0);
        velocity.setAngle(Math.PI / 12);
        hitBox = new BoxCollider(this, Settings.BALL_WIDTH, Settings.BALL_HEIGHT);

    }


    public void run() {
        super.run();
        this.move();
        this.paddleIntersect();
       //this.intersectPlayer();
     //  this.Goal();
    }

//    private void intersectPlayer() {
//
//
//        Player player=GameObject.findIntersects(Player.class,this.hitBox);
//
//        if(player!=null)
//
//            this.reverseVelocityX();
//
//
//
//    }
    private void Goal() {
        Goal net=GameObject.findIntersects(Goal.class,this.hitBox);
        if(net!=null) //this.position.set(Settings.GAME_WIDTH/2, Settings.GAME_HEIGHT/2);
        //Game.restart();
            this.velocity.set(0,0);
    }

    public void move() {
        if(this.outBoundRight() && this.onGoingRight()) {
            this.reverseVelocityX();
           // this.reverseVelocity();
        }
        if(this.outBoundLeft() && this.onGoingLeft()) {
            this.reverseVelocityX();
           // this.reverseVelocity();
        }
        if(this.outBoundUp()&& this.onGoingTop())
            this.reverseVelocityY();
            //this.reverseVelocity();
        if(this.outBoundDown()&&this.onGoingDown())
            this.reverseVelocityY();
            //this.reverseVelocity();
    }


    private boolean outBoundUp() {
        return this.position.y<=this.anchor.y* Settings.BALL_HEIGHT+Settings.HORIWALL_HEIGHT;
    }
    private boolean outBoundDown() {
        return this.position.y>=Settings.GAME_HEIGHT-this.anchor.y*Settings.BALL_HEIGHT-Settings.HORIWALL_HEIGHT;
    }
    private boolean outBoundRight() {
        return this.position.x >= Settings.GAME_WIDTH
                - this.anchor.x * Settings.BALL_WIDTH-Settings.VERWALL_WIDTH;
    }

    private boolean outBoundLeft() {
        return this.position.x <= this.anchor.x * Settings.BALL_WIDTH+Settings.VERWALL_WIDTH;
    }

    private boolean onGoingTop() {
        return this.velocity.y<0;
    }
    private boolean onGoingDown() {
        return this.velocity.y>0;
    }
    private boolean onGoingRight() {
        return this.velocity.x > 0;
    }

    private boolean onGoingLeft() {
        return this.velocity.x < 0;
    }

    public void reverseVelocityX() {
        this.velocity.setX(-this.velocity.x);
    }
    public void reverseVelocityY() {
        this.velocity.setY(-this.velocity.y);
    }
    public void reverseVelocity(){this.velocity.set(-this.velocity.x,-this.velocity.y);}

    public void paddleIntersect(){
        Player player=GameObject.findIntersects(Player.class,this.hitBox);

        if(player!=null){


//            Vector2D dist2Center=new Vector2D(this.position.x-player.position.x,this.position.y-player.position.y);
//
//            this.velocity.setAngle(dist2Center.getAngle());
//           if(this.onGoingRight()||this.onGoingLeft())this.reverseVelocity();
            Vector2D anchorDistance = new Vector2D(this.position.x-player.position.x, this.position.y-player.position.y);
            velocity=anchorDistance;
            velocity.setLength(Settings.BALL_VELOCITY_X);

        }
    }

}
