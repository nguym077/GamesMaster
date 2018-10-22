package Halloween;

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
    public void removeImageViewOnly(ImageView view)
    {
        view.setX(-1000);
        view.setY(0);
    }
    public void stopAnima(int ID,AnimationTimer anima)
    {
        if(whoSetBomb[ID]==0)
        bomb_numbers[0]=bomb_numbers[0]+1;
        else if(whoSetBomb[ID]==1)
        bomb_numbers[1]=bomb_numbers[1]+1;

        whoSetBomb[ID]=-1;
        anima.stop();


    }
    public boolean Fire_colliBrick(Rectangle r_view)
    {
        boolean check=false;
        for(int i=0;i<r_Bricks.length;i++)
        {
            if(activeB[i])
            {
                if (r_view.getBoundsInLocal().intersects(r_Bricks[i].getBoundsInLocal()))
                {
                    //System.out.println(("brick "+ i+" x: "+r_Bricks[i].getX()+" y: "+r_Bricks[i].getY()));
                    removeImageView(Bricks[i],r_Bricks[i]);
                    activeB[i]=false;
                    check=true;

                    break;
                }
            }

        }
        return check;
    }
    public boolean colliBrick(Rectangle r_view)
    {
        boolean check=false;
        for(int i=0;i<r_Bricks.length;i++)
        {
            if(activeB[i])
            {
                if (r_view.getBoundsInLocal().intersects(r_Bricks[i].getBoundsInLocal()))
                {
                    //System.out.println(("brick "+ i+" x: "+r_Bricks[i].getX()+" y: "+r_Bricks[i].getY()));
                    //removeImageView(Bricks[i],r_Bricks[i]);
                    check=true;
                    break;
                }
            }

        }
        return check;
    }
    public boolean ColliBrickAndDestroy(Rectangle r_view)
    {
        boolean check=false;
        for(int i=0;i<r_Bricks.length;i++)
        {
            if(activeB[i])
            {
                if (r_view.getBoundsInLocal().intersects(r_Bricks[i].getBoundsInLocal()))
                {
                    System.out.println(("brick "+ i+" x: "+r_Bricks[i].getX()+" y: "+r_Bricks[i].getY()));
                    removeImageView(Bricks[i],r_Bricks[i]);

                    check=true;

                    break;
                }
            }

        }
        return check;
    }
    public int colliDropItem(int ID,Rectangle r_view)
    {
        int item=0;
        for(int i=0;i<r_Bricks.length;i++)
        {
            if (r_view.getBoundsInLocal().intersects(r_icon_bomb[10].getBoundsInLocal()))
            {
                item=2;
                if( bomb_numbers[ID]!=5)
                    bomb_numbers[ID]=bomb_numbers[ID]+1;
                removeImageView(icon_bomb[10],r_icon_bomb[10]);

                break;
            }
            else if(r_view.getBoundsInLocal().intersects(r_icon_health[10].getBoundsInLocal()))
            {
                item=1;
                if( health[ID]!=5)
                health[ID]=health[ID]+1;
                removeImageView(icon_health[10],r_icon_health[10]);
                break;
            }
            else if(r_view.getBoundsInLocal().intersects(r_icon_speed[10].getBoundsInLocal()))
            {
                item=4;
                if( player_speed[ID]!=8)
                player_speed[ID]=player_speed[ID]+1;
                removeImageView(icon_speed[10],r_icon_speed[10]);
                break;
            }
            else if(r_view.getBoundsInLocal().intersects(r_icon_power[10].getBoundsInLocal()))
            {
                item=3;
                if( bomb_power[ID]!=5)
                    bomb_power[ID]=bomb_power[ID]+1;
                removeImageView(icon_power[10],r_icon_power[10]);
                break;
            }
            else if(r_view.getBoundsInLocal().intersects(r_icon_noHurt[10].getBoundsInLocal()))
            {
                item=4;
                noHurt[ID]=1000;
                removeImageView(icon_power[10],r_icon_noHurt[10]);
                break;
            }
            else if(r_view.getBoundsInLocal().intersects(r_icon_throughWall[10].getBoundsInLocal()))
            {
                item=5;
                throughWall[ID]=600;
                removeImageView(icon_power[10],r_icon_throughWall[10]);
                break;
            }
            else if(r_view.getBoundsInLocal().intersects(r_icon_addLife[10].getBoundsInLocal()))
            {
                item=6;
                if(life[ID]!=5)
                life[ID]=life[ID]+1;
                removeImageView(icon_power[10],r_icon_addLife[10]);
                break;
            }

        }
        return item;
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
        /*
        for(int i=0;i<r_Ghost1.length;i++)
        {
            if(r_view.getBoundsInLocal().intersects(r_Ghost1[i].getBoundsInLocal()))
            {
                //removeImageView(Bricks[i]);
                //System.out.println(("bomb " + i + " x: " + r_Bombs1[i].getX() + " y: " + r_Bombs1[i].getY()));
                //System.out.println("get1 "+r_view.getId()+" get2 "+r_Bombs1[i].getId());
                check=true;
                Ghost_checkHit[i]=1;

            }
        }*/

//        for(int i=0;i<r_Bat.length;i++)
//        {
//            if(r_view.getBoundsInLocal().intersects(r_Bat[i].getBoundsInLocal()))
//            {
//                //removeImageView(Bricks[i]);
//                //System.out.println(("bomb " + i + " x: " + r_Bombs1[i].getX() + " y: " + r_Bombs1[i].getY()));
//                //System.out.println("get1 "+r_view.getId()+" get2 "+r_Bombs1[i].getId());
//                check=true;
//                Bat_checkHit[i]=1;
//
//            }
//        }
//        for(int i=0;i<r_Vamp.length;i++)
//        {
//            if(r_view.getBoundsInLocal().intersects(r_Vamp[i].getBoundsInLocal()))
//            {
//                //removeImageView(Bricks[i]);
//                //System.out.println(("bomb " + i + " x: " + r_Bombs1[i].getX() + " y: " + r_Bombs1[i].getY()));
//                //System.out.println("get1 "+r_view.getId()+" get2 "+r_Bombs1[i].getId());
//                check=true;
//                Vamp_checkHit[i]=1;
//
//            }
//        }

        for(int i=0;i<r_Zombie.length;i++)
        {
            if(r_view.getBoundsInLocal().intersects(r_Zombie[i].getBoundsInLocal()))
            {
                //removeImageView(Bricks[i]);
                //System.out.println(("bomb " + i + " x: " + r_Bombs1[i].getX() + " y: " + r_Bombs1[i].getY()));
                //System.out.println("get1 "+r_view.getId()+" get2 "+r_Bombs1[i].getId());
                check=true;
                Zombie_checkHit[i]=1;
            }
        }
        for(int i=0;i<r_player.length;i++)
        {
            if(r_view.getBoundsInLocal().intersects(r_player[i].getBoundsInLocal()))
            {
                if(noHurt[i]<=0) {
                    check = true;
                    health[i] = health[i] - 1;
                    noHurt[i] = 100;

                }
            }
        }
        return check;
    }
    public boolean HeroColliEnemy(Rectangle r_view)
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
                //Ghost_checkHit[i]=1;
                break;
            }
        }

//        for(int i=0;i<r_Bat.length;i++)
//        {
//            if(r_view.getBoundsInLocal().intersects(r_Bat[i].getBoundsInLocal()))
//            {
//                //removeImageView(Bricks[i]);
//                //System.out.println(("bomb " + i + " x: " + r_Bombs1[i].getX() + " y: " + r_Bombs1[i].getY()));
//                //System.out.println("get1 "+r_view.getId()+" get2 "+r_Bombs1[i].getId());
//                check=true;
//                //Bat_checkHit[i]=1;
//                break;
//            }
//        }

//        for(int i=0;i<r_Vamp.length;i++)
//        {
//            if(r_view.getBoundsInLocal().intersects(r_Vamp[i].getBoundsInLocal()))
//            {
//                //removeImageView(Bricks[i]);
//                //System.out.println(("bomb " + i + " x: " + r_Bombs1[i].getX() + " y: " + r_Bombs1[i].getY()));
//                //System.out.println("get1 "+r_view.getId()+" get2 "+r_Bombs1[i].getId());
//                check=true;
//                //Vamp_checkHit[i]=1;
//                break;
//            }
//        }

        for(int i=0;i<r_Zombie.length;i++)
        {
            if(r_view.getBoundsInLocal().intersects(r_Zombie[i].getBoundsInLocal()))
            {
                //removeImageView(Bricks[i]);
                //System.out.println(("bomb " + i + " x: " + r_Bombs1[i].getX() + " y: " + r_Bombs1[i].getY()));
                //System.out.println("get1 "+r_view.getId()+" get2 "+r_Bombs1[i].getId());
                check=true;
                //Zombie_checkHit[i]=1;
                break;
            }
        }
        return check;
    }
}
