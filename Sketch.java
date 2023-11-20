import processing.core.PApplet;
import processing.core.PImage;

/**
 * Shows an airplane crashing into a bomb and it explodes 
 * @author Michael Liang
 *
 */

public class Sketch extends PApplet {

  
  // image variables
  PImage ImgGordan;
  PImage ImgAirplane;
  PImage ImgBomb;
  PImage ImgExplode;
  PImage ImgBird;
 
  // Create where it spawns in
  float floatAirplaneX = 0;
  float floatAirplaneY = -100;
  float floatSpeedX = 5;
  float floatSpeedY = 0;
  float floatspeed = (float) 1.5;

  // Bomb Dropping Speed
  float floatdropSpeedx = 0;
  float floatdropSpeedy =0;
  float floatDropAcceleration = (float) 1;

  //Ball
  float floatX2; 
  float floatY2; 
  float circleRadius = 100; //Circle motion
  float angle = 0; // Angle of the second mall

  
  public void settings() {
	// put your size call here
    size(950, 950);
  }

 
  public void setup() {
    ImgGordan = loadImage("/Users/michael/github-classroom/SACHSTech/processing-task-7-images-and-animation-Michael10203/ImgGordan.png");
    ImgGordan.resize(ImgGordan.width/2, ImgGordan.height/2);

    ImgAirplane  = loadImage("/Users/michael/github-classroom/SACHSTech/processing-task-7-images-and-animation-Michael10203/ImgAirplane.png");
    ImgAirplane.resize(ImgAirplane.width/2,ImgAirplane.height/2);

    ImgBomb = loadImage("/Users/michael/github-classroom/SACHSTech/processing-task-7-images-and-animation-Michael10203/ImgBomb.png");

    ImgExplode = loadImage("/Users/michael/github-classroom/SACHSTech/processing-task-7-images-and-animation-Michael10203/ImgExplode.jpg");
    ImgExplode.resize(ImgExplode.width *2, ImgAirplane.height *7);

    ImgBird = loadImage("/Users/michael/github-classroom/SACHSTech/processing-task-7-images-and-animation-Michael10203/ImgBird.png");
    floatX2 = width / 2; 
    floatY2 = height / 2; 
  }

 public void draw() {
    image(ImgGordan, 0, 0);
    image(ImgAirplane, floatAirplaneX, 500);

    floatAirplaneX = floatAirplaneX + floatSpeedX;

 //When the Airplane hits the sides
    if (floatAirplaneX < 0) {
      floatSpeedX = abs(floatSpeedX);
    } else if (floatAirplaneX > width - 500) {
      floatSpeedX = -abs(floatSpeedX * floatspeed);
    }
    image(ImgBird, floatX2-400, floatY2-400);
    floatX2 = width / 2 + cos(angle) * circleRadius; //ps. Googled how to use Cos and sin to make the image go in circles
    floatY2 = height / 2 + sin(angle) * circleRadius;
    angle += 0.02; // Adjust the angle


    if (floatdropSpeedy<450) {
      // Draw the bomb at its current position
      image(ImgBomb, floatdropSpeedx +550, floatdropSpeedy);

      // make the bomb drop
      floatdropSpeedy += floatDropAcceleration;
    } else {
      //  make everything go kaboom
      image(ImgExplode, 0, 0);
    }

  }
}