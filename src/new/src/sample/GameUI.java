package sample;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    }

    public void LoadBackGround() {
        String[] url = new String[3];
        url[0] = "image/background.jpg";
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
        url[0] = "image/wall.png";
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
        url[0] = "image/wall5.png";
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
        url[0] = "image/wall3.png";
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
        url[0] = "image/bomb1.png";
        url[1] = "image/bomb2.png";
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
        url[0] = "image/fire1a.png";
        url[1] = "image/fire2a.png";
        url[2] = "image/fire3a.png";
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
        url[0] = "enemy/ghost1.png";
        Image[] newImage = new Image[1];
        newImage[0] = new Image(url[0]);
        for (int i = 0; i < Ghost1.length; i++) {
            Ghost1[i] = new ImageView(newImage[0]);
            Ghost1[i].setFitWidth(XY-10);
            Ghost1[i].setFitHeight(XY);
            Ghost1[i].setX(-1000);
            Ghost1[i].setY(0);

            r_Ghost1[i]=new Rectangle(24,24);
            r_Ghost1[i].setX(-1000);
            r_Ghost1[i].setY(0);
            r_Ghost1[i].setVisible(false);
        }
    }
}