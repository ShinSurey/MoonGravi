import greenfoot.*;
import java.util.List;

public class Bulan extends Actor
{
    private double  x,y;
    private double vx=0,vy=0.375,R;//0.375
    private double m=1;
    private double G=1,dt=5;
    public void addedToWorld(World Space)
    {
        x=getX();
        y=getY();
    }
    
    public void act()
    {
        List<Bumi> bumis=getWorld().getObjects(Bumi.class);
        Bumi bumi=bumis.get(0);
        double rx=bumi.getX()-getX();
        double ry=bumi.getY()-getY();
        R=Math.sqrt(rx*rx+ry*ry);
        double theta=Math.atan2(ry,rx);
        double a=G*bumi.m/(R*R);
        double ax=a*Math.cos(theta);
        double ay=a*Math.sin(theta);
        
        /*****************************************************************
         * buat kecepatan bulan agar kembali ke posisi semula. di saat ini saya sadar code yang saya buat terlalu rumis, yakin ada cara yang lebih gampang dan sedikit bruhhhh
         * *****************************************************/
         
         double vox=vx;
         double voy=vy;
         
         x+=vx*dt+0.5*ax*dt*dt;
         y+=vy*dt+0.5*ay*dt*dt;
         
         setLocation((int)x,(int)y);
         
         vx+=ax*dt;vy+=ay*dt;
         
         /********************************/
         vx=0.5*(vx+vox);
         vy=0.5*(vy+voy);
         /*******************************/
        }
    }
    