package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class AnimationManger extends Map {

    public void removeImageView(ImageView view, Rectangle r_view)
    {
        view.setX(-1000);
        view.setY(0);
        r_view.setX(-1000);
        r_view.setY(0);
    }
    public void stopAnima(AnimationTimer anima)
    {

        anima.stop();

    }
    public boolean Fire_colliBrick(Rectangle r_view)
    {
        boolean check=false;
        for(int i=0;i<r_Bricks.length;i++)
        {
            if (r_view.getBoundsInLocal().intersects(r_Bricks[i].getBoundsInLocal()))
            {
                //System.out.println(("brick "+ i+" x: "+r_Bricks[i].getX()+" y: "+r_Bricks[i].getY()));
                removeImageView(Bricks[i],r_Bricks[i]);

                check=true;

                break;
            }
        }
        return check;
    }
    public boolean colliBrick(Rectangle r_view)
    {
        boolean check=false;
        for(int i=0;i<r_Bricks.length;i++)
        {
            if (r_view.getBoundsInLocal().intersects(r_Bricks[i].getBoundsInLocal()))
            {
                //System.out.println(("brick "+ i+" x: "+r_Bricks[i].getX()+" y: "+r_Bricks[i].getY()));
                //removeImageView(Bricks[i],r_Bricks[i]);
                check=true;
                break;
            }
        }
        return check;
    }
    public boolean colliMetal(Rectangle r_view)
    {
        boolean check=false;
        for(int i=0;i<r_Blocks.length;i++)
        {
            if(r_view.getBoundsInLocal().intersects(r_Blocks[i].getBoundsInLocal()))
            {
                check=true;
                break;
            }
        }
        if(check==false)
            for(int i=0;i<r_Iron_Wall.length;i++)
            {
                if (r_view.getBoundsInLocal().intersects(r_Iron_Wall[i].getBoundsInLocal()))
                {
                    //removeImageView(Bricks[i]);
                    //System.out.println(("metal "+ i+" x: "+r_Iron_Wall[i].getX()+" y: "+r_Iron_Wall[i].getY()));


                    check=true;
                    break;
                }
            }
        return check;
    }
    public boolean colliBomb(Rectangle r_view)
    {
        boolean check=false,sameBomb=false;
        for(int i=0;i<r_Bombs1.length;i++)
        {
            if(r_view.getBoundsInLocal().intersects(r_Bombs1[i].getBoundsInLocal()))
            {
                //removeImageView(Bricks[i]);
                //System.out.println(("bomb " + i + " x: " + r_Bombs1[i].getX() + " y: " + r_Bombs1[i].getY()));
                //System.out.println("get1 "+r_view.getId()+" get2 "+r_Bombs1[i].getId());
                check=true;
                Bomb_checkHit[i/2]=1;
                break;
            }
        }
        return check;
    }
    public boolean Object_colliBomb(Rectangle r_view)
    {
        boolean check=false,sameBomb=false;
        for(int i=0;i<r_Bombs1.length;i++)
        {
            //!r_view.equals(r_Bombs1[i]
            if (r_view!=r_Bombs1[i])
            {
                if(r_view.getBoundsInLocal().intersects(r_Bombs1[i].getBoundsInLocal()))
                {
                    //removeImageView(Bricks[i]);
                    //System.out.println(("bomb " + i + " x: " + r_Bombs1[i].getX() + " y: " + r_Bombs1[i].getY()));
                    //System.out.println("get1 "+r_view.getId()+" get2 "+r_Bombs1[i].getId());
                    check=true;
                    break;
                }
            }
        }
        return check;
    }

    public boolean colliEnemy(Rectangle r_view)
    {
        boolean check=false,sameBomb=false;
        for(int i=0;i<r_Ghost1.length;i++)
        {
            if(r_view.getBoundsInLocal().intersects(r_Ghost1[i].getBoundsInLocal()))
            {
                //removeImageView(Bricks[i]);
                //System.out.println(("bomb " + i + " x: " + r_Bombs1[i].getX() + " y: " + r_Bombs1[i].getY()));
                //System.out.println("get1 "+r_view.getId()+" get2 "+r_Bombs1[i].getId());
                check=true;
                Ghost_checkHit[i]=1;
                break;
            }
        }
        for(int i=0;i<r_Bat.length;i++)
        {
            if(r_view.getBoundsInLocal().intersects(r_Bat[i].getBoundsInLocal()))
            {
                //removeImageView(Bricks[i]);
                //System.out.println(("bomb " + i + " x: " + r_Bombs1[i].getX() + " y: " + r_Bombs1[i].getY()));
                //System.out.println("get1 "+r_view.getId()+" get2 "+r_Bombs1[i].getId());
                check=true;
                Bat_checkHit[i]=1;
                break;
            }
        }
        for(int i=0;i<r_Vamp.length;i++)
        {
            if(r_view.getBoundsInLocal().intersects(r_Vamp[i].getBoundsInLocal()))
            {
                //removeImageView(Bricks[i]);
                //System.out.println(("bomb " + i + " x: " + r_Bombs1[i].getX() + " y: " + r_Bombs1[i].getY()));
                //System.out.println("get1 "+r_view.getId()+" get2 "+r_Bombs1[i].getId());
                check=true;
                Vamp_checkHit[i]=1;
                break;
            }
        }
        return check;
    }
}
