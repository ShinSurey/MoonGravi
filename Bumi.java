import greenfoot.*;


public class Bumi  extends Actor
{
    public double m=80; 
    private int n=360;
    private GreenfootImage image=new GreenfootImage("Earth.png");
    private GreenfootImage bola=new GreenfootImage(image.getWidth(),image.getHeight());
    private GreenfootImage image2=new GreenfootImage("Earth2.png");
    private GreenfootImage shade=new GreenfootImage("Shadow.png");
    private GreenfootImage image3=null;
    
    public void addedToWorld(World Latar)
    {
        bola.setColor(Color.RED);
        bola.fillOval(0,0,image.getWidth()-1,image.getHeight()-1);
        image3=new GreenfootImage(3*image2.getWidth(),image2.getHeight());
        image3.drawImage(image2,0,0);
        image3.drawImage(image2,image2.getWidth()-1,0);
        image3.drawImage(image2,2*image2.getWidth()-1,0);
        shade.setTransparency(180);
        act();
    }
    
    public void act()
    {
        GreenfootImage imageo=new GreenfootImage(image.getWidth(),image.getHeight());
        for(int i=0;i<bola.getWidth();i++){
            for(int j=0;j<bola.getHeight();j++){
                Color warna=bola.getColorAt(i,j);
                if(warna.equals(Color.RED)){
                    imageo.setColorAt(i,j,image3.getColorAt(2*image.getWidth()+(int)(1.0*n*image2.getWidth()/360)+i,j));
                }
            }
        }
        imageo.drawImage(shade,0,0);
        setImage(imageo);
        n-=2;
        if(n==0)n=360;
    }
}
