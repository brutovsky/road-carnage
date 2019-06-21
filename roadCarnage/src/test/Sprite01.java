//34567890123456789012345678901234567890123456789012345678
//======================================================//
/*Sprite01.java
Copyright 2013, R.G.Baldwin

An object of this class can be manipulated as a sprite
in a Slick2D program.

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

public class Sprite01{
  Image image = null;//The sprite wears this image
  float X = 0f;//X-Position of the sprite
  float Y = 0f;//Y-Position of the sprite
  float width = 0f;//Width of the sprite
  float height = 0f;//Height of the sprite
  float xStep = 1f;//Incremental step size in pixels - X
  float yStep = 1f;//Incremental step size in pixels - Y
  float scale = 1f;//Scale factor for draw method
  Color colorFilter = null;//Color filter for draw method
  
  float xDirection = 1.0f;//Move to right for positive
  float yDirection = 1.0f;//Move down for positive
  
  int life = 1;//Used to control life or death of sprite
  
  boolean exposed = false;//Used in the contagion program
  
  //Constructor
  public Sprite01(Image image,//Sprite wears this image
                  float X,//Initial position
                  float Y,//Initial position
                  float xDirection,//Initial direction
                  float yDirection,//Initial direction
                  float xStep,//Initial step size
                  float yStep,//Initial step size
                  float scale,//Scale factor for drawing
                  Color colorFilter)
                    throws SlickException {

      //Save incoming parameter values
      this.image = image;
      this.X = X;
      this.Y = Y;
      this.xDirection = xDirection;
      this.yDirection = yDirection;
      this.xStep = xStep;
      this.yStep = yStep;
      this.scale = scale;
      this.colorFilter = colorFilter;
      
      //Compute and save width and height of image
      width = image.getWidth();
      height = image.getHeight();

  }//end constructor
  //----------------------------------------------------//
  //The following accessor methods make many of the
  // important attributes accessible to the using
  // program.
  //----------------------------------------------------//
  
  public Image getImage(){
    return image;
  }//end getSprite
  //----------------------------------------------------//
  
  public void setImage(Image image) throws SlickException{
    this.image = image;
    width = image.getWidth();
    height = image.getHeight();
  }//end setImage
  //----------------------------------------------------//
  
  public float getWidth(){
    return width;
  }//end getWidth
  //----------------------------------------------------//

  public float getHeight(){
    return height;
  }//end getWidth
  //----------------------------------------------------//
  
  public float getX(){
    return X;
  }//end getX
  //----------------------------------------------------//
  
  public void setX(float X){
    this.X = X;
  }//end setX
  //----------------------------------------------------//
  public float getY(){
    return Y;
  }//end getY
  //----------------------------------------------------//

  public void setY(float Y){
    this.Y = Y;
  }//end setY
  //----------------------------------------------------//
  
  public float getXDirection(){
    return xDirection;
  }// end getXDirection
  //----------------------------------------------------//
  
  public void setXDirection(float xDirection){
    this.xDirection = xDirection;
  }//end setXDirection
  //----------------------------------------------------//
  
  public float getYDirection(){
    return yDirection;
  }//end getYDirection
  //----------------------------------------------------//
  
  public void setYDirection(float yDirection){
    this.yDirection = yDirection;
  }//setYDirection
  //----------------------------------------------------//
  
  public float getXStep(){
    return xStep;
  }//end getXStep
  //----------------------------------------------------//
  
  public void setXStep(float xStep){
    this.xStep = xStep;
  }//end setXStep
  //----------------------------------------------------//
  
  public float getYStep(){
    return yStep;
  }//end getYStep
  //----------------------------------------------------//

  public void setYStep(float yStep){
    this.yStep = yStep;
  }//end setYStep
  //----------------------------------------------------//
  
  public float getScale(){
    return scale;
  }//end getScale
  //----------------------------------------------------//

  public void setScale(float scale){
    this.scale = scale;
  }//end setScale
  //----------------------------------------------------//
  
  public Color getColorFilter(){
    return colorFilter;
  }//end getColorFilter
  //----------------------------------------------------//
  
  public void setColorFilter(
                        float red,float green,float blue){
    colorFilter = new Color(red,green,blue);
  }//end setColorFilter
  //----------------------------------------------------//
 
  public int getLife(){
    return life;
  }//end getLife
  //----------------------------------------------------//
  
  public void setLife(int life){
    this.life = life;
  }//end setLife
  //----------------------------------------------------//
  
  public boolean getExposed(){
    return exposed;
  }//end getExposed
  //----------------------------------------------------//
  
  public void setExposed(boolean exposed){
    this.exposed = exposed;
  }//end setExposed
  //----------------------------------------------------//
  
  //This method causes the sprite to be drawn each time
  // it is called.
  public void draw(){
    image.draw(X,Y,scale,colorFilter);
  }//end draw
  //----------------------------------------------------//
  
  //This method detects collisions between this 
  // rectangular sprite object and another rectangular
  // sprite object by testing four cases where a
  // collision could not possibly occur and assuming that
  // a collision has occurred if none of those cases
  // are true.
  public boolean isCollision(Sprite01 other){
    //Create variable with meaningful names make the
    // algorithm easier to understand. Can be eliminated
    // to make the algorithm more efficient.
    float thisTop = Y;
    float thisBottom = thisTop + height*scale;
    float thisLeft = X;
    float thisRight = thisLeft + width*scale;
    
    float otherTop = other.getY();
    float otherBottom = otherTop + other.getHeight()*other.getScale();
    float otherLeft = other.getX();
    float otherRight = otherLeft + other.getWidth()*other.getScale();

    if (thisBottom < otherTop) return(false);
    if (thisTop > otherBottom) return(false);
  
    if (thisRight < otherLeft) return(false);
    if (thisLeft > otherRight) return(false);
  
    return(true);

  }//end isCollision
  //----------------------------------------------------//
  
  public void move(){
    X += xDirection*xStep;
    Y += yDirection*yStep;
  }//end move
  //----------------------------------------------------//
  
  public void edgeBounce(float winWidth,float winHeight){
    //Test for a collision with one of the edges and
    // cause to sprite to bounce off the edge if a
    // collision has occurred.
    if(X + width*scale >= winWidth){
      //A collision has occurred.
      xDirection = -1.0f;//reverse direction
      //Set the position to the right edge less the
      // width of the sprite.
      X = winWidth - width*scale;
    }//end if
    
    //Continue testing for collisions with the edges
    // and take appropriate action.
    if(X <= 0){
      xDirection = 1.0f;
      X = 0;
    }//end if
    
    if(Y + height*scale >= winHeight){
      yDirection = -1.0f;
      Y = winHeight - height*scale;
    }//end if
    
    if(Y <= 0){
      yDirection = 1.0f;
      Y = 0;
    }//end if
  }//end edgeBounce
  //----------------------------------------------------//

}//end class Sprite01
