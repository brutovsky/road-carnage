//34567890123456789012345678901234567890123456789012345678
//======================================================//
/*Slick0210.java
Copyright 2013, R.G.Baldwin

A baseball coach is attached by a swarm of fierce green
flying insects. Fortunately, a red predator insect comes 
along and attacks the green insects just in time to save
the coach.

There are two scenarios that can be exercised by setting
dieOnCollision to true or false. In one scenario,
the green insects become harmless blue insects when they 
collide with the red insect. In the other case, they are 
consumed by the red insect upon contact and removed from 
the population.

In both scenarios, contact between a green insect and the 
red insect causes the red insect to increase in size.

If you allow the program to run long enough, the 
probability is high that all of the green insects will
have collided with the red insect and will either have 
turned blue or have been consumed.

Tested using JDK 1.7 under WinXP
*********************************************************/
package test;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Color;
import org.newdawn.slick.Sound;

import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;

public class Slick0210 extends BasicGame{
  
  //Set the value of this variable to true to cause the
  // sprites to die on collision and to be removed from
  // the population.
  boolean dieOnCollision = false;
  
  //Store references to Sprite01 objects here.
  ArrayList <Sprite01> sprites = 
                                new ArrayList<Sprite01>();
  
  //Change this value and recompile to change the number
  // of sprites.
  int numberSprites = 2000;

  //Populate these variables with references to Image
  // objects later.
  Image redBallImage;
  Image greenBallImage;
  Image blueBallImage;
  
  //Populate this variable with a reference to a Sound
  // object later.
  Sound blaster;
  
  //Populate these variables with information about the
  // background image later.
  Image background = null;
  float backgroundWidth;
  float backgroundHeight;
  
  //This object is used to produce values for a variety
  // of purposes.
  Random random = new Random();
  
  //Frame rate we would like to see and maximum frame
  // rate we will allow.
  int targetFPS = 60;
  //----------------------------------------------------//

  public Slick0210(){//constructor
    //Set the title
    super("Slick0210, baldwin");
  }//end constructor
  //----------------------------------------------------//

  public static void main(String[] args)
                                    throws SlickException{
    AppGameContainer app = new AppGameContainer(
                          new Slick0210(),414,307,false);
    app.start();
  }//end main
  //----------------------------------------------------//

  @Override
  public void init(GameContainer gc)
                                   throws SlickException {

    //Create Image objects that will be used to visually
    // represent the sprites.
    redBallImage = new Image("redball.png");
    greenBallImage = new Image("greenball.png");
    blueBallImage = new Image("blueball.png");
    
    //Create a Sound object.
    blaster = new Sound("Blaster.wav");

    //Create a background image and save information
    // about it.
    background = new Image("background.jpg");
    backgroundWidth = background.getWidth();
    backgroundHeight = background.getHeight();
    
    //Add a sprite dressed with redBallImage to the
    // beginning of the ArrayList object. Put it in the
    // center of the game window. Make the direction of
    // motion random. Make the speed of motion
    // (step size)random. Make the size random. Specify
    // a white (do nothing)color filter.
    sprites.add(new Sprite01(
       redBallImage,//image
       backgroundWidth/2.0f,//initial position
       backgroundHeight/2.0f,//initial position
       (random.nextFloat() > 0.5) ? 1f : -1f,//direction
       (random.nextFloat() > 0.5) ? 1f : -1f,//direction
       0.1f+random.nextFloat()*2.0f,//step size
       0.1f+random.nextFloat()*2.0f,//step size
       0.5f+random.nextFloat()*1.5f,//scale
       new Color(1.0f,1.0f,1.0f)));//color filter


    //Populate the ArrayList object with sprites. Dress
    // them with a greenBallImage. Make the initial
    // position random. Make the initial direction of
    // motion random. Make the speed (step size) random.
    // Make the size (scale) random. Make the color filter
    // white (do nothing).
    for(int cnt = 0;cnt < numberSprites;cnt++){
      sprites.add(new Sprite01(
         greenBallImage,//image
         backgroundWidth*random.nextFloat(),//position
         backgroundHeight*random.nextFloat(),//position
         (random.nextFloat() > 0.5) ? 1f : -1f,//direction
         (random.nextFloat() > 0.5) ? 1f : -1f,//direction
         0.1f+random.nextFloat()*2.0f,//step size
         0.1f+random.nextFloat()*2.0f,//step size
         random.nextFloat()*1.0f,//scale
         new Color(1.0f,1.0f,1.0f)));//color filter 
    }//end for loop

    gc.setTargetFrameRate(targetFPS);//set frame rate

  }//end init
  //----------------------------------------------------//

  @Override
  public void update(GameContainer gc, int delta)
                                    throws SlickException{

    //Aaccess to the first sprite in the ArrayList object.
    Sprite01 redBallSprite = sprites.get(0);

    //Do the following for every sprite in the ArrayList
    // object
    for(int cnt = 0;cnt < sprites.size();cnt++){
      //Get a reference to the Sprite01 object.
      Sprite01 thisSprite = sprites.get(cnt);
      
      //Ask the sprite to move according to its properties
      thisSprite.move();

      //Ask the sprite to bounce off the edge if it is at
      // an edge.
      thisSprite.edgeBounce(
                        backgroundWidth,backgroundHeight);
      
      //Test for a collision between this sprite and the
      // sprite that is dressed in the redBallImage.
      boolean collision = 
                   thisSprite.isCollision(redBallSprite);

      //Process a collision if it has occurred. Exclude
      // collisions between the redBallSprite and itself.
      // Also exclude collisions between sprites dressed
      // in a blueBallImage and the redBallSprite.
      if((collision == true)&&
         (! thisSprite.getImage().equals(redBallImage)) &&
         (! thisSprite.getImage().equals(blueBallImage))){

        //A collision has occured, change the color of
        // this sprite to blue and maybe cause it to
        // die and be removed from the population.
        thisSprite.setImage(blueBallImage);
        if(dieOnCollision){
          thisSprite.setLife(0);
        }//end if
        
        //Cause the redBallSprite to change direction on
        // a random basis.
        redBallSprite.setXDirection(
                   (random.nextFloat() > 0.5) ? 1f : -1f);
        redBallSprite.setYDirection(
                   (random.nextFloat() > 0.5) ? 1f : -1f);
        
        //Cause the redBallSprite to change stepsize on a
        // random basis.
        redBallSprite.xStep = 
                             0.1f+random.nextFloat()*2.0f;
        redBallSprite.yStep = 
                             0.1f+random.nextFloat()*2.0f;
        
        //Cause the redBallSprite to grow larger
        redBallSprite.setScale(redBallSprite.getScale() +
                     (redBallSprite.getScale()) * 0.001f);

        //Play a sound to indicate that a collision has
        // occurred.
        blaster.play();
      }//end if

    }//end for loop
    
    //Remove dead objects from the ArrayList object
    Iterator <Sprite01> iter = sprites.iterator();

    while(iter.hasNext()){
      Sprite01 theSprite = iter.next();
      if(theSprite.getLife() <= 0){
        iter.remove();
      }//end if
    }//end while loop

  }//end update
  //----------------------------------------------------//

  public void render(GameContainer gc, Graphics g)
                                    throws SlickException{

    //set the drawing mode to honor transparent pixels
    g.setDrawMode(g.MODE_NORMAL);

    //Draw the background to erase the previous picture.
    background.draw(0,0);

    //Draw every sprite in the ArrayList object.
    for(int cnt = 0;cnt < sprites.size();cnt++){
      sprites.get(cnt).draw();
    }//end for loop
    
    //Display the remaining number of sprites.
    g.drawString(
       "Sprites remaining: " + (sprites.size()),100f,10f);
    //Signal when all sprites have been eaten.
    if(sprites.size() == 1){
      g.drawString("Burp!",100f,25f);
    }//end if
  }//end render

}//end class Slick0210
//======================================================//