package sample;

import javafx.animation.AnimationTimer;

import java.util.Random;

public class Bomb extends AnimationManger {
    public int BombID=0;
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
        setBomb(325,75,5);
        setBomb(325,175,3);
        //System.out.println("time "+(time2-time1));
        //setBomb();
    }


    public void setBomb(int bx,int by,double time) {
        int bx1=bx/100*100,bx2=bx%100;
        //.out.println("check bx1 "+bx1+" check bx2 "+bx2);
        if(bx2<25&&bx2>=0){bx=bx1;}
        if(bx2<50&&bx2>=25){bx=bx1+25;}
        if(bx2<75&&bx2>=50){bx=bx1+50;}
        if(bx2<100&&bx2>=75){bx=bx1+75;}

        int by1=by/100*100,by2=by%100;
        //System.out.println("check by2 "+by2);
        if(by2<25&&by2>=0){by=by1;}
        if(by2<50&&by2>=25){by=by1+25;}
        if(by2<75&&by2>=50){by=by1+50;}
        if(by2<100&&by2>=75){by=by1+75;}

        if(BombID==49)
            BombID=1;
        else
            BombID++;
        r_Bombs1[BombID*2].setX(bx+2+2.5);
        r_Bombs1[BombID*2].setY(by+2+2.5);
        ;
        if(Object_colliBomb(r_Bombs1[BombID*2])||colliMetal(r_Bombs1[BombID*2])){
            //System.out.println("colis ");
            removeImageView(Bombs1[BombID*2],r_Bombs1[BombID*2]);
            BombID--;
        }
        else
        {
            //System.out.println("id "+BombID);
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
            int power=2;
            BombAnima(BombID,power,bx,by,time);
        }

    }

    public void BombAnima(int ID,int power,int bx,int by,double stime)
    {
        Bomb_checkHit[ID]=0;
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
            boolean colli1=false,colli2=false,colli3=false,colli4=false;
            public void handle(long now)
            {

                if(Stop&&count==20)
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
                    Fire_colliBrick(r_Fire3[Fire3ID]);
                    //System.out.println("fire id3 "+ID+ " "+Fire3ID);

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
                                if(colliBomb(r_Fire1[Fire1ID])||Fire_colliBrick(r_Fire1[Fire1ID]))
                                colli1 =true;
                                if(colliEnemy(r_Fire1[Fire1ID]));
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
                                if(colliBomb(r_Fire1[Fire1ID])||Fire_colliBrick(r_Fire1[Fire1ID]))
                                colli2 = true;
                                if(colliEnemy(r_Fire1[Fire1ID]));
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
                                if(colliBomb(r_Fire2[Fire2ID])||Fire_colliBrick(r_Fire2[Fire2ID]))
                                colli3 = true;
                                if(colliEnemy(r_Fire2[Fire2ID]));
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
                                if(colliBomb(r_Fire2[Fire2ID])||Fire_colliBrick(r_Fire2[Fire2ID]))
                                colli4 = true;
                                if(colliEnemy(r_Fire2[Fire2ID]));
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
                    if(Bomb_checkHit[ID]==1)
                        stoptime=0;
                    count++;
                }

                    //System.out.println(count);

            }

        };bombAnima[ID].start();
    }

}
