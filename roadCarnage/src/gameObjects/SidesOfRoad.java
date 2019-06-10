package gameObjects;

import org.newdawn.slick.Image;

public class SidesOfRoad extends StaticObject {

        private int id;
        Image backSide, secondBackSide;
        float x, y, yS;
        MovingObject player;


        public SidesOfRoad(Image image, float scale, int x, int y, MovingObject player) {
            super(image, scale, x, y, player);
            this.backSide = image;
            this.secondBackSide = image;
            this.x = 0;
            this.y = 0;
            this.player = player;
            yS = -backSide.getHeight();


        }

        @Override
        public void update() {
            y += player.speed * 0.5f;
            yS += player.speed* 0.5f;
            if (y > 800) {
                backSide.draw(x, -850);
                y = -850;
            }
            if (yS > 800) {
                secondBackSide.draw(x, -850);
                yS = -850;
            }
        }


        @Override
        public void draw() {
            backSide.draw(x, y);
            secondBackSide.draw(x, yS);
        }



}
