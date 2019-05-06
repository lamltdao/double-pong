package program.goal;

import program.GameObject;
import program.Settings;
import program.physics.BoxCollider;
import program.renderer.SingleImageRenderer;

public class Goal extends GameObject {
    public Goal(double x, double y){
        this.position.set(x,y);
        hitBox=new BoxCollider(this, Settings.NET_WIDTH-3,Settings.NET_HEIGHT-15);
        renderer=new SingleImageRenderer("images/goal/0.png");
    }
    public Goal(){}

//    @Override
//    public void render(Graphics g){
//        g.setColor(WHITE);
//        g.drawRect((int)(this.position.x-this.anchor.x*Settings.NET_WIDTH),(int)(this.position.y-this.anchor.y*Settings.NET_HEIGHT), Settings.NET_WIDTH,Settings.NET_HEIGHT);
//    }






}
