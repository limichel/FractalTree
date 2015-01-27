import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class FractalTree extends PApplet {

private double fractionLength = .8f; 
private int smallestBranch = 10; 
private double branchAngle = .3f; 
public void setup() 
{   
	size(640,480);    
	noLoop(); 
} 
public void draw() 
{   
	background(255);   
 	stroke(137, 116, 96, 100);
 	strokeWeight(5);
	line(320, 480, 320, 380);  
	drawBranches(320, 380, 100, 3*Math.PI/2, 5);  //will add later 
} 
public void drawBranches(int x,int y, double branchLength, double angle, float branchWidth) 
{   
	if(branchLength <= smallestBranch)
	{

	}
	else
	{
		if(branchLength <= 50)
		{
			stroke(255, 154, 154, 150);
		}
		else
		{
			stroke(137, 116, 96, 100);
		}
		strokeWeight(branchWidth);
		double angle1 = angle + branchAngle;
		double angle2 = angle - branchAngle;
		int endX1 = (int)(fractionLength*branchLength*Math.cos(angle1) + x);
		int endY1 = (int)(fractionLength*branchLength*Math.sin(angle1) + y);
		int endX2 = (int)(fractionLength*branchLength*Math.cos(angle2) + x);
		int endY2 = (int)(fractionLength*branchLength*Math.sin(angle2) + y);
		line(x, y, endX1, endY1);
		line(x, y, endX2, endY2);
		drawBranches(endX1, endY1, branchLength*fractionLength, angle1, branchWidth-.5f);
		drawBranches(endX2, endY2, branchLength*fractionLength, angle2, branchWidth-.5f);
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "FractalTree" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
