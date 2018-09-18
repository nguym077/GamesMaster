package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.lang.reflect.Array;
import java.util.Random;

public class Bomb extends Map {
    public int BombID=1;
    public double ExpTime=5;
    public int Fire1ID=0;
    public int Fire2ID=0;
    public int Fire3ID=0;
    public int [][] bombXY=new int[((int)sizeX-50)/25][((int)sizeY-50)/25];
    Bomb() {

        System.out.println("bomb");

        /*
        for (int i = 0; i < 10; i++) {
            setBomb();
        }
        */
        int bx=225,by=225;
       // setBomb(bx,by,10);
       // setBomb(bx,by,5);
       // setBomb(bx,by,7);
        setBomb(325,75,12);
        //System.out.println("time "+(time2-time1));
        //setBomb();
    }


    public void setBomb(int bx,int by,double time) {
        int bx1=bx/100*100,bx2=bx%100;
        System.out.println("check bx1 "+bx1+" check bx2 "+bx2);
        if(bx2<25&&bx2>=0){bx=bx1;}
        if(bx2<50&&bx2>=25){bx=bx1+25;}
        if(bx2<75&&bx2>=50){bx=bx1+50;}
        if(bx2<100&&bx2>=75){bx=bx1+75;}

        int by1=by/100*100,by2=by%100;
        System.out.println("check by2 "+by2);
        if(by2<25&&by2>=0){by=by1;}
        if(by2<50&&by2>=25){by=by1+25;}
        if(by2<75&&by2>=50){by=by1+50;}
        if(by2<100&&by2>=75){by=by1+75;}

        if(BombID==49)
            BombID=2;
        else
            BombID++;
        r_Bombs1[BombID*2].setX(bx+2+2.5);
        r_Bombs1[BombID*2].setY(by+2+2.5);
        boolean ck=colliBomb(r_Bombs1[BombID*2]);
        if(ck){
            System.out.println("colis ");
            removeImageView(Bombs1[BombID*2],r_Bombs1[BombID*2]);
        }
        else
        {
            System.out.println("id "+BombID);
            Bombs1[BombID*2].setX(bx + 2);
            Bombs1[BombID*2].setY(by + 2);
           // r_Bombs1[BombID*2].setX(bx + 2+2.5);
           // r_Bombs1[BombID*2].setY(by+2+2.5);

            Bombs1[BombID*2+1].setVisible(false);
            Bombs1[BombID*2+1].setVisible(false);
            Bombs1[BombID*2+1].setX(bx);
            Bombs1[BombID*2+1].setY(by+2);
            r_Bombs1[BombID*2+1].setX(bx+2.5);
            r_Bombs1[BombID*2+1].setY(by+2+2.5);
            int power=5;
            BombAnima(BombID,power,bx,by,time);
        }

    }
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
    public void BombAnima(int ID,int power,int bx,int by,double stime)
    {
        checkHit[ID]=0;
        bombAnima[ID]=new AnimationTimer()
        {

            Random r=new Random();

           // if (frogDown[10].getBoundsInLocal().intersects(playerTank[0].getBoundsInLocal())||
           // frogDown[10].getBoundsInLocal().intersects(playerTank[1].getBoundsInLocal()))

          //  double lastTime2=System.nanoTime();
            double time1=System.currentTimeMillis();
            double time2=0;
            double count=0;
            boolean Stop=false;
            int Fire1ID=ID*10,Fire2ID=ID*10,Fire3ID=ID*10;
            int Final=ID*10;
            double stoptime=stime;

            public void handle(long now)
            {

                if(Stop&&count==50)
                {
                    removeImageView(Fire3[Final],r_Fire3[Final]);
                    for(int i=0;i<power;i++)
                    {

                        //System.out.println("remove id "+ID+" final "+Final);
                        removeImageView(Fire1[Final],r_Fire1[Final]);
                        removeImageView(Fire2[Final],r_Fire2[Final]);
                        Final++;
                        removeImageView(Fire1[Final],r_Fire1[Final]);
                        removeImageView(Fire2[Final],r_Fire2[Final]);
                        Final++;
                    }
                    stopAnima(bombAnima[ID]);

                    //System.out.println("ck stop "+ID);
                }


                time2=System.currentTimeMillis();
                //System.out.println("time " + time2);
                if(time2-time1>stoptime*1000&&Stop==false) {
                    //System.out.println("time " + time2);
                    time2=0;
                    removeImageView(Bombs1[ID*2],r_Bombs1[ID*2]);
                    removeImageView(Bombs1[ID*2+1],r_Bombs1[ID*2+1]);
                    Fire3[Fire3ID].setX(bx);
                    Fire3[Fire3ID].setY(by);
                    r_Fire3[Fire3ID].setX(bx+2.5);
                    r_Fire3[Fire3ID].setY(by+2.5);
                    colliBrick(r_Fire3[Fire3ID]);
                    //System.out.println("fire id3 "+ID+ " "+Fire3ID);

                    boolean colli1=false,colli2=false,colli3=false,colli4=false;
                    for(int i=0;i<power;i++)
                    {
                        if(colli1==false)
                        {
                            r_Fire1[Fire1ID].setX(bx+2.5);
                            r_Fire1[Fire1ID].setY(by-25-i*25+2.5);
                            //System.out.println("fire id1 "+ID+ " "+Fire1ID);
                            colli1=colliMetal(r_Fire1[Fire1ID]);
                            if(colli1==false) {
                                Fire1[Fire1ID].setX(bx);
                                Fire1[Fire1ID].setY(by-25-i*25);
                                if(colliBomb(r_Fire1[Fire1ID])||colliBrick(r_Fire1[Fire1ID]))
                                colli1 =true;
                            }

                        }
                        Fire1ID++;

                        if(colli2==false) {
                            r_Fire1[Fire1ID].setX(bx+2.5);
                            r_Fire1[Fire1ID].setY(by + 25 + i * 25+2.5);
                            colli2=colliMetal(r_Fire1[Fire1ID]);
                            if(colli2==false) {
                                Fire1[Fire1ID].setX(bx);
                                Fire1[Fire1ID].setY(by + 25 + i * 25);
                                if(colliBomb(r_Fire1[Fire1ID])||colliBrick(r_Fire1[Fire1ID]))
                                colli2 = true;
                            }

                        }
                        Fire1ID++;

                    }
                    for(int i=0;i<power;i++)
                    {
                        if(colli3==false)
                        {

                            r_Fire2[Fire2ID].setX(bx-i*25-25+2.5);
                            r_Fire2[Fire2ID].setY(by+2.5);
                            colli3=colliMetal(r_Fire2[Fire2ID]);
                            if(colli3==false) {
                                Fire2[Fire2ID].setX(bx-i*25-25);
                                Fire2[Fire2ID].setY(by);
                                if(colliBomb(r_Fire2[Fire2ID])||colliBrick(r_Fire2[Fire2ID]))
                                colli3 = true;
                            }

                        }
                        Fire2ID++;
                        if(colli4==false)
                        {

                            r_Fire2[Fire2ID].setX(bx+i*25+25+2.5);
                            r_Fire2[Fire2ID].setY(by+2.5);

                            colli4=colliMetal(r_Fire2[Fire2ID]);
                            if(colli4==false) {
                                Fire2[Fire2ID].setX(bx+i*25+25);
                                Fire2[Fire2ID].setY(by);
                                if(colliBomb(r_Fire2[Fire2ID])||colliBrick(r_Fire2[Fire2ID]))
                                colli4 = true;
                            }

                        }
                        Fire2ID++;
                    }
                    Stop=true;
                    count=0;
                  //  System.out.println("stop id "+ ID +" count "+count);
                    //Bombs1[ID*2].setVisible(true);
                    //Bombs1[ID*2].setVisible(true);

                }
                else
                {
                    if(count>=30&&count<60&&Stop==false)
                    {
                        Bombs1[ID*2].setVisible(false);
                        Bombs1[ID*2+1].setVisible(true);
                    }
                    else if(count>=60&&Stop==false){
                        Bombs1[ID*2+1].setVisible(false);
                        Bombs1[ID*2].setVisible(true);
                        count=0;
                    }
                    if(checkHit[ID]==1)
                        stoptime=0;
                    count++;
                }

                    //System.out.println(count);

            }

        };bombAnima[ID].start();
    }
    public boolean colliBrick(Rectangle r_view)
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
            //!r_view.equals(r_Bombs1[i]
            if (r_view!=r_Bombs1[i])
            {
                if(r_view.getBoundsInLocal().intersects(r_Bombs1[i].getBoundsInLocal()))
                {
                    //removeImageView(Bricks[i]);
                    //System.out.println(("bomb " + i + " x: " + r_Bombs1[i].getX() + " y: " + r_Bombs1[i].getY()));
                    //System.out.println("get1 "+r_view.getId()+" get2 "+r_Bombs1[i].getId());
                    check=true;
                    checkHit[i/2]=1;
                    break;
                }
            }
        }
        return check;
    }
}
