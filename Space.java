import greenfoot.*;

public class Space extends World
{
    private int n=0;
    private GreenfootImage image=null,imageo=null,image2=null;
    
    public Space()
    {
        super(600, 400, 1,false);
        addObject(new Bumi(),300,200);
        addObject(new Bulan(),100,200);
        image=getBackground();
        imageo=new GreenfootImage(3*image.getWidth(),getHeight());
        imageo.drawImage(image,0,0);
        imageo.drawImage(image,image.getWidth()-1,0);
        imageo.drawImage(image,2*image.getWidth()-1,0);
    }
    
    public void act()
    {
        image2=new GreenfootImage(image);
        image2.drawImage(imageo,-2*image.getWidth()+(int)(1.0*n*image.getWidth()/(5*360))-1,0);
        n++;
        if(n==(5*360)) n=0;
        setBackground(image2);
    }
}