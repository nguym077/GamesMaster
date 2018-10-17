package Halloween;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.util.Random;
public class Map extends GameUI {

    Map()
    {
        //setBackGround();
        setIronWall();
        setBlocks();
        setBrick();
        setGravestone();
        //Bomb newBomb=new Bomb();
    }

    public void setBackGround()
    {
        for(int i=0;i<background.length;i++)
        {
           // background[i]=new ImageView(background[0]);
            background[i].setFitWidth(sizeX);
            background[i].setFitHeight(sizeY);
            //removeImage(backGround[i]);
        }
    }
    public void setIronWall()
    {
        double x=0;
        double y=50;
        for(int i=0;i<Iron_Wall.length;i++)
        {
            if(x<sizeX-75)
            {
                Iron_Wall[i].setX(x=x+50);
                Iron_Wall[i].setY(y);
                r_Iron_Wall[i].setX(x+2.5);
                r_Iron_Wall[i].setY(y+2.5);
            }
            else if(y<sizeY-75)
            {
                x=0;
                y=y+50;
            }
        }
    }
    public void setBlocks()
    {
        int index=0;
        for(int i=0;i<sizeX/25;i++)
        {
            Blocks[index].setX(i*25);
            Blocks[index].setY(0);
            r_Blocks[index].setX(i*25+2.5);
            r_Blocks[index].setY(0+2.5);
            index++;
            Blocks[index].setX(i*25);
            Blocks[index].setY(sizeY-25);
            r_Blocks[index].setX(i*25+2.5);
            r_Blocks[index].setY(sizeY-25+2.5);
            index++;
        }

        for(int j=0;j<sizeY/25;j++)
        {
            Blocks[index].setX(0);
            Blocks[index].setY(j*25);
            r_Blocks[index].setX(0+2.5);
            r_Blocks[index].setY(j*25+2.5);
            index++;
            Blocks[index].setX(sizeX-25);
            Blocks[index].setY(j*25);
            r_Blocks[index].setX(sizeX-25+2.5);
            r_Blocks[index].setY(j*25+2.5);
            index++;
        }

    }
    public void setBrick( )
    {
        /*
        Bricks[0].setX(25);
        Bricks[0].setY(25);
        Bricks[1].setX(sizeX-50);
        Bricks[1].setY(sizeY-50);
        */
        int Bindex=0;
        Random rand = new Random();
        for(int i=0;i<sizeX/25;i++)
        {
            for(int j=0;j<sizeY/25;j++) {

                // Generate random integers in range 0 to 1
                int ranN = rand.nextInt(2);
                if( !(i==0 && j==0) && !(i==0 && j==1) && !(i==1 && j==0)
                        && !(i==43 && j==0) && !(i==44 && j==0) && !(i==44 && j==1)
                        && !(i==0 && j==21) && !(i==0 && j==22) && !(i==1 && j==22)
                        && !(i==43 && j==22) && !(i==44 && j==22) && !(i== 44 && j==21)
                        && !(i==10 && j==7) && !(i==10 && j==19)
                        && !(i==30 && j==7) && !(i==30 && j==19)) {
                    if ((i % 2 == 0) && (i * 25 < sizeX - 50) && (j * 25 < sizeY - 50))  //even number
                    {
                        if (ranN == 0) {
                            Bricks[Bindex].setX(i * 25 + 25);
                            Bricks[Bindex].setY(j * 25 + 25);
                            r_Bricks[Bindex].setX(i * 25 + 25 + 2.5);
                            r_Bricks[Bindex].setY(j * 25 + 25 + 2.5);
                            Bindex++;
                        }
                    } else if ((i * 25 < sizeX - 50) && (j * 25 < sizeY - 50)) {
                        if (j % 2 == 0) {
                            if (ranN == 0) {
                                Bricks[Bindex].setX(i * 25 + 25);
                                Bricks[Bindex].setY(j * 25 + 25);
                                r_Bricks[Bindex].setX(i * 25 + 25 + 2.5);
                                r_Bricks[Bindex].setY(j * 25 + 25 + 2.5);
                                Bindex++;
                            }
                        }
                    }
                }
            }
        }
    }
    public void setGravestone() {
        Gravestones[1].setX(10 * 25 + 25);
        Gravestones[1].setY(7 * 25 + 25);
        r_Gravestones[1].setX(10 * 25 + 25 + 2.5);
        r_Gravestones[1].setY(7 * 25 + 25 + 2.5);

        Gravestones[2].setX(10 * 25 + 25);
        Gravestones[2].setY(19 * 25 + 25);
        r_Gravestones[2].setX(10 * 25 + 25 + 2.5);
        r_Gravestones[2].setY(19 * 25 + 25 + 2.5);

        Gravestones[3].setX(30 * 25 + 25);
        Gravestones[3].setY(7 * 25 + 25);
        r_Gravestones[3].setX(30 * 25 + 25 + 2.5);
        r_Gravestones[3].setY(7 * 25 + 25 + 2.5);

        Gravestones[4].setX(30 * 25 + 25);
        Gravestones[4].setY(19 * 25 + 25);
        r_Gravestones[4].setX(30 * 25 + 25 + 2.5);
        r_Gravestones[4].setY(19 * 25 + 25 + 2.5);
    }
}
