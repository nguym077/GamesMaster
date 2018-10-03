package Halloween;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameUI implements PublicVar {
    GameUI()
    {
        LoadBackGround();
        LoadWall();
        LoadBlocks();
        LoadBrick();
        LoadBomb();
        LoadFire();
        LoadGhoest();
        LoadBat();
        LoadVamp();
        LoadZombie();
        LoadMonster();
        LoadPlayer();
    }

    public void LoadBackGround() {
        String[] url = new String[3];
        url[0] = "Halloween/background_images/background.jpg";
        Image[] backgroundI = new Image[3];
        backgroundI[0] = new Image(url[0]);
        for (int i = 0; i < background.length; i++) {
            background[i] = new ImageView(backgroundI[0]);
            background[i].setX(-sizeX);
            background[i].setY(0);
        }
    }
    public void LoadBlocks() {
        String[] url = new String[1];
        url[0] = "Halloween/background_images/wall.PNG";
        Image[] blocksI = new Image[1];
        blocksI[0] = new Image(url[0]);
        for (int i = 0; i < Blocks.length; i++) {
            Blocks[i] = new ImageView(blocksI[0]);
            Blocks[i].setFitWidth(XY);
            Blocks[i].setFitHeight(XY);
            Blocks[i].setX(-1000);
            Blocks[i].setY(0);

            r_Blocks[i]=new Rectangle(20,20);
            r_Blocks[i].setX(-1000);
            r_Blocks[i].setY(0);
            r_Blocks[i].setVisible(false);
        }
    }
    public void LoadWall() {
        String[] url = new String[1];
        url[0] = "Halloween/background_images/wall5.PNG";
        Image[] wallI = new Image[1];
        wallI[0] = new Image(url[0]);
        for (int i = 0; i < Iron_Wall.length; i++) {
            Iron_Wall[i] = new ImageView(wallI[0]);
            Iron_Wall[i].setFitWidth(XY);
            Iron_Wall[i].setFitHeight(XY);
            Iron_Wall[i].setX(-1000);
            Iron_Wall[i].setY(0);

           // r_Iron_Wall[i]=new Rectangle(15, 25.0);
            //r_Iron_Wall[i].set
            r_Iron_Wall[i]=new Rectangle(20,20);
            r_Iron_Wall[i].setX(-1000);
            r_Iron_Wall[i].setY(0);
            r_Iron_Wall[i].setVisible(false);
        }
    }
    public void LoadBrick() {
        String[] url = new String[1];
        url[0] = "Halloween/background_images/wall3.png";
        Image[] wallI = new Image[1];
        wallI[0] = new Image(url[0]);
        for (int i = 0; i < Bricks.length; i++) {
            Bricks[i] = new ImageView(wallI[0]);
            Bricks[i].setFitWidth(XY);
            Bricks[i].setFitHeight(XY);
            Bricks[i].setX(-1000);
            Bricks[i].setY(0);

            r_Bricks[i]=new Rectangle(20,20);
            r_Bricks[i].setX(-1000);
            r_Bricks[i].setY(0);
            r_Bricks[i].setVisible(false);
        }
    }

    public void LoadBomb() {
        String[] url = new String[2];
        url[0] = "Halloween/background_images/bomb1.png";
        url[1] = "Halloween/background_images/bomb2.png";
        Image[] bombImage1 = new Image[2];
        bombImage1[0] = new Image(url[0]);
        bombImage1[1] = new Image(url[1]);
        for (int i = 0; i < Bombs1.length; i++) {
            if(i%2==0) {
                Bombs1[i] = new ImageView(bombImage1[0]);
                Bombs1[i].setFitWidth(20);
                Bombs1[i].setFitHeight(20);
                r_Bombs1[i]=new Rectangle(20,20);
                r_Bombs1[i].setWidth(20);
                r_Bombs1[i].setHeight(20);

            }
            else {
                Bombs1[i] = new ImageView(bombImage1[1]);
                Bombs1[i].setFitWidth(24);
                Bombs1[i].setFitHeight(20);
                r_Bombs1[i]=new Rectangle(20,20);
                r_Bombs1[i].setWidth(20);
                r_Bombs1[i].setHeight(20);

            }

            Bombs1[i].setX(-1000);
            Bombs1[i].setY(0);
            r_Bombs1[i].setX(-1000);
            r_Bombs1[i].setY(0);
            r_Bombs1[i].setVisible(false);
        }
    }
    public void LoadFire() {
        String[] url = new String[3];
        url[0] = "Halloween/background_images/fire1a.png";
        url[1] = "Halloween/background_images/fire2a.png";
        url[2] = "Halloween/background_images/fire3a.png";
        Image[] newImage1 = new Image[3];
        newImage1[0] = new Image(url[0]);
        newImage1[1] = new Image(url[1]);
        newImage1[2] = new Image(url[2]);
        for (int i = 0; i < Fire1.length; i++) {
            Fire1[i] = new ImageView(newImage1[0]);
            Fire1[i].setFitWidth(XY);
            Fire1[i].setFitHeight(XY);
            Fire1[i].setX(-1000);
            Fire1[i].setY(0);
            r_Fire1[i]=new Rectangle(20,20);
            r_Fire1[i].setX(-1000);
            r_Fire1[i].setY(0);
            r_Fire1[i].setVisible(false);
            
            Fire2[i] = new ImageView(newImage1[1]);
            Fire2[i].setFitWidth(XY);
            Fire2[i].setFitHeight(XY);
            Fire2[i].setX(-1000);
            Fire2[i].setY(0);
            r_Fire2[i]=new Rectangle(20,20);
            r_Fire2[i].setX(-1000);
            r_Fire2[i].setY(0);
            r_Fire2[i].setVisible(false);
            
            Fire3[i] = new ImageView(newImage1[2]);
            Fire3[i].setFitWidth(XY);
            Fire3[i].setFitHeight(XY);
            Fire3[i].setX(-1000);
            Fire3[i].setY(0);
            r_Fire3[i]=new Rectangle(20,20);
            r_Fire3[i].setX(-1000);
            r_Fire3[i].setY(0);
            r_Fire3[i].setVisible(false);
        }
    }

    public void LoadGhoest() {
        String[] url = new String[1];
        url[0] = "Halloween/enemy_images/ghost1.png";
        Image[] newImage = new Image[1];
        newImage[0] = new Image(url[0]);
        for (int i = 0; i < Ghost1.length; i++) {
            Ghost1[i] = new ImageView(newImage[0]);
            Ghost1[i].setFitWidth(XY-10);
            Ghost1[i].setFitHeight(XY);
            Ghost1[i].setX(-1000);
            Ghost1[i].setY(0);

            r_Ghost1[i]=new Rectangle(20,20);
            r_Ghost1[i].setX(-1000);
            r_Ghost1[i].setY(0);
            r_Ghost1[i].setVisible(false);
        }
    }
    public void LoadBat() {
        String[] url = new String[3];
        url[0] = "Halloween/enemy_images/bat1.png";
        url[1] = "Halloween/enemy_images/bat2.png";
        url[2] = "Halloween/enemy_images/bat3.png";
        Image[] newImage = new Image[3];
        newImage[0] = new Image(url[0]);
        newImage[1] = new Image(url[1]);
        newImage[2] = new Image(url[2]);
        for (int i = 0; i < Bat1.length; i=i+3) {
            //System.out.println("bat i "+i);
            Bat1[i] = new ImageView(newImage[0]);
            Bat1[i].setFitWidth(XY);
            Bat1[i].setFitHeight(XY);
            Bat1[i].setX(-1000);
            Bat1[i].setY(0);

            Bat1[i+1] = new ImageView(newImage[1]);
            Bat1[i+1].setFitWidth(XY);
            Bat1[i+1].setFitHeight(XY);
            Bat1[i+1].setX(-1000);
            Bat1[i+1].setY(0);

            Bat1[i+2] = new ImageView(newImage[2]);
            Bat1[i+2].setFitWidth(XY);
            Bat1[i+2].setFitHeight(XY);
            Bat1[i+2].setX(-1000);
            Bat1[i+2].setY(0);
        }
        for(int i=0;i<r_Bat.length;i++)
        {
            r_Bat[i]=new Rectangle(20,20);
            r_Bat[i].setX(-1000);
            r_Bat[i].setY(0);
            r_Bat[i].setVisible(false);
        }
    }

    public void LoadVamp() {
        String[] url = new String[4];
        url[0] = "Halloween/enemy_images/vamp1.png";
        url[1] = "Halloween/enemy_images/vamp2.png";
        url[2] = "Halloween/enemy_images/vamp3.png";
        url[3] = "Halloween/enemy_images/vamp4.png";
        Image[] newImage = new Image[4];
        newImage[0] = new Image(url[0]);
        newImage[1] = new Image(url[1]);
        newImage[2] = new Image(url[2]);
        newImage[3] = new Image(url[3]);
        for (int i = 0; i < Vamp1.length; i=i+4) {
            //System.out.println("bat i "+i);
            Vamp1[i] = new ImageView(newImage[0]);
            Vamp1[i].setFitWidth(XY);
            Vamp1[i].setFitHeight(XY);
            Vamp1[i].setX(-1000);
            Vamp1[i].setY(0);

            Vamp1[i+1] = new ImageView(newImage[1]);
            Vamp1[i+1].setFitWidth(XY);
            Vamp1[i+1].setFitHeight(XY);
            Vamp1[i+1].setX(-1000);
            Vamp1[i+1].setY(0);

            Vamp1[i+2] = new ImageView(newImage[2]);
            Vamp1[i+2].setFitWidth(XY);
            Vamp1[i+2].setFitHeight(XY);
            Vamp1[i+2].setX(-1000);
            Vamp1[i+2].setY(0);

            Vamp1[i+3] = new ImageView(newImage[3]);
            Vamp1[i+3].setFitWidth(XY);
            Vamp1[i+3].setFitHeight(XY);
            Vamp1[i+3].setX(-1000);
            Vamp1[i+3].setY(0);
        }
        for(int i=0;i<r_Vamp.length;i++)
        {
            r_Vamp[i]=new Rectangle(20,20);
            r_Vamp[i].setX(-1000);
            r_Vamp[i].setY(0);
            r_Vamp[i].setVisible(false);
        }
    }
    public void LoadZombie() {
        String[] url = new String[4];
        url[0] = "Halloween/enemy_images/Zombie1.png";
        url[1] = "Halloween/enemy_images/Zombie2.png";
        url[2] = "Halloween/enemy_images/Zombie3.png";
        url[3] = "Halloween/enemy_images/Zombie4.png";
        Image[] newImage = new Image[4];
        newImage[0] = new Image(url[0]);
        newImage[1] = new Image(url[1]);
        newImage[2] = new Image(url[2]);
        newImage[3] = new Image(url[3]);
        for (int i = 0; i < Zombie1.length; i=i+4) {
            //System.out.println("bat i "+i);
            Zombie1[i] = new ImageView(newImage[0]);
            Zombie1[i].setFitWidth(XY);
            Zombie1[i].setFitHeight(XY);
            Zombie1[i].setX(-1000);
            Zombie1[i].setY(0);

            Zombie1[i+1] = new ImageView(newImage[1]);
            Zombie1[i+1].setFitWidth(XY);
            Zombie1[i+1].setFitHeight(XY);
            Zombie1[i+1].setX(-1000);
            Zombie1[i+1].setY(0);

            Zombie1[i+2] = new ImageView(newImage[2]);
            Zombie1[i+2].setFitWidth(XY);
            Zombie1[i+2].setFitHeight(XY);
            Zombie1[i+2].setX(-1000);
            Zombie1[i+2].setY(0);

            Zombie1[i+3] = new ImageView(newImage[3]);
            Zombie1[i+3].setFitWidth(XY);
            Zombie1[i+3].setFitHeight(XY);
            Zombie1[i+3].setX(-1000);
            Zombie1[i+3].setY(0);
        }
        for(int i=0;i<r_Zombie.length;i++)
        {
            r_Zombie[i]=new Rectangle(20,20);
            r_Zombie[i].setX(-1000);
            r_Zombie[i].setY(0);
            r_Zombie[i].setVisible(false);
        }
    }

    public void LoadMonster() {
        int eachNumber=16;
        String front = "Halloween/enemy_images/monster/head_";
        String back_L = "_L.png", back_R = "_R.png";
        int xl=0,xr=0,yl=0,yr=0;
        System.out.println("check load");
        String[] url_L = new String[eachNumber];
        String[] url_R = new String[eachNumber];

        for(int i=0;i<eachNumber;i++)
        {
            url_L[i] = front+String.valueOf(i+1)+back_L;
            url_R[i] = front+String.valueOf(i+1)+back_R;
            //url[i] = "Image/Fish_2/move/Fish_move_2_000.png";
            //System.out.println( url[i] );
        }

        Image[] newImage_L = new Image[eachNumber];
        Image[] newImage_R = new Image[eachNumber];
        for(int i=0;i<eachNumber;i++)
        {
            newImage_L[i] = new Image(url_L[i]);
            newImage_R[i] = new Image(url_R[i]);
            //System.out.println("i "+i);
        }
        int Scale=1;
        double actualWidth=newImage_L[0].getWidth(),actualHeight=newImage_L[0].getHeight();
        double idleX=actualWidth*Scale,idleY=actualHeight*Scale;
        //System.out.println("idley "+idleY);
        ImageView[] view_L=Monster1_L;
        ImageView[] view_R=Monster1_R;
        for (int i = 0; i <Monster1_L.length; i=i+eachNumber) {


            for(int j=0;j<eachNumber;j++)
            {
                int index=i+j;
                view_L[index] = new ImageView(newImage_L[j]);
                //System.out.println("check laod image "+c1_idle_L[index].getId());
                view_L[index].setPreserveRatio(true);

                view_L[index].setFitWidth(idleX);
                //fish_2_move_L[index].setFitWidth(actualHeight*Scale);
                //c1_idle_L[i + j].setFitHeight(Y);
                view_L[index].setX(0);
                view_L[index].setY(0);

                view_L[index].setTranslateX(xl*Scale);
                view_L[index].setTranslateY(0-idleY+yl*Scale);
                //view_L[index].setTranslateY(actualHeight-2*(actualHeight));
                //view_L[index].setId(String.valueOf(index));

                //Color(c1_idle_L[index],HUE[id][0]);

                view_R[index] =new ImageView(newImage_R[j]);
                //System.out.println("check laod image "+c1_idle_L[index].getId());
                view_R[index].setPreserveRatio(true);

                view_R[index].setFitWidth(idleX);
                //fish_2_move_R[index].setFitWidth(actualHeight*Scale);
                //c1_idle_L[i + j].setFitHeight(Y);
                view_R[index].setX(0);
                view_R[index].setY(0);

                //view_R[index].getTransforms().add(new Rotate(30,Y));
                view_R[index].setTranslateX((0-xr)*Scale);
                view_R[index].setTranslateY(0-idleY+yr*Scale);
                //view_L[index].setTranslateY(actualHeight-2*(actualHeight));
                //System.out.println("trnasX "+fish_2_move_R[index].getTranslateY());
                //view_R[index].setId(String.valueOf(index));


            }

        }
        for(int i=0;i<r_Monster1.length;i++)
        {
            r_Monster1[i]=new Rectangle(20,20);
            r_Monster1[i].setX(-1000);
            r_Monster1[i].setY(0);
            r_Monster1[i].setVisible(false);
        }
    }

    public void LoadPlayer() {
        int eachNumber=3;
        String front = "Halloween/enemy_images/character/p1_";
        String back_L = ".png", back_R = "_R.png";
        int xl=0,xr=0,yl=0,yr=0;
        System.out.println("check load");
        String[] url_L = new String[eachNumber];
        //String[] url_R = new String[eachNumber];

        for(int i=0;i<eachNumber;i++)
        {
            url_L[i] = front+String.valueOf(i+1)+back_L;
            //url_R[i] = front+String.valueOf(i+1)+back_R;
            //url[i] = "Image/Fish_2/move/Fish_move_2_000.png";
            //System.out.println( url[i] );
        }

        Image[] newImage_L = new Image[eachNumber];
        //Image[] newImage_R = new Image[eachNumber];
        for(int i=0;i<eachNumber;i++)
        {
            newImage_L[i] = new Image(url_L[i]);
            //newImage_R[i] = new Image(url_R[i]);
            //System.out.println("i "+i);
        }
        int Scale=1;
        double actualWidth=newImage_L[0].getWidth(),actualHeight=newImage_L[0].getHeight();
        double idleX=actualWidth*Scale,idleY=actualHeight*Scale;
        //System.out.println("idley "+idleY);
        ImageView[] view_L=player_L;
       // ImageView[] view_R=player_R;
        for (int i = 0; i <player_L.length; i=i+eachNumber) {

            for(int j=0;j<eachNumber;j++)
            {
                int index=i+j;
                view_L[index] = new ImageView(newImage_L[j]);
                //System.out.println("check laod image "+c1_idle_L[index].getId());
                view_L[index].setPreserveRatio(true);

                view_L[index].setFitWidth(idleX);
                //fish_2_move_L[index].setFitWidth(actualHeight*Scale);
                //c1_idle_L[i + j].setFitHeight(Y);
                view_L[index].setX(-100);
                view_L[index].setY(0);

               // view_L[index].setTranslateX(xl*Scale);
               // view_L[index].setTranslateY(0-idleY+yl*Scale);
                //view_L[index].setTranslateY(actualHeight-2*(actualHeight));
                //view_L[index].setId(String.valueOf(index));

                //Color(c1_idle_L[index],HUE[id][0]);

                //view_R[index] =new ImageView(newImage_R[j]);
                //System.out.println("check laod image "+c1_idle_L[index].getId());
                //view_R[index].setPreserveRatio(true);

                //view_R[index].setFitWidth(idleX);
                //fish_2_move_R[index].setFitWidth(actualHeight*Scale);
                //c1_idle_L[i + j].setFitHeight(Y);
                //view_R[index].setX(0);
                //view_R[index].setY(0);

                //view_R[index].getTransforms().add(new Rotate(30,Y));
                //view_R[index].setTranslateX((0-xr)*Scale);
                //view_R[index].setTranslateY(0-idleY+yr*Scale);
                //view_L[index].setTranslateY(actualHeight-2*(actualHeight));
                //System.out.println("trnasX "+fish_2_move_R[index].getTranslateY());
                //view_R[index].setId(String.valueOf(index));


            }

        }
        for(int i=0;i<r_player.length;i++)
        {
            r_player[i]=new Rectangle(15,15);
            r_player[i].setX(charX[i]);
            r_player[i].setY(charY[i]);
           // r_player[i].setStroke(Color.red);
            r_player[i].setVisible(false);

        }
    }

    public void create_imageview()
    {



    }
}