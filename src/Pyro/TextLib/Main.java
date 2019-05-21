package Pyro.TextLib;

import Pyro.TextLib.Text.VisibleText;
import processing.core.PApplet;

public class Main extends PApplet
{

  public static void main(String[] args)
  {
    
    PApplet.main(Main.class.toString().substring(6));
    
  }
  
  public void settings()
  {
    
    size(400, 400);
    
  }
  
  public void setup()
  {
    
    
    
  }
  
  public void draw()
  {
    
    background(255);
    
    noStroke();
    
    fill(0);
    
    this.ellipse(200, 200, 200, 200);
    
    fill(255);
    
    this.ellipse(200, 200, 100, 100);
    
    fill(0);
    
    this.ellipse(200, 200, 50, 50);
    
    textSize(48);
    
    VisibleText.text(this, "Hello World!", 0 + (int)((400 - textWidth("Hello World!")) / 2), 0 + (400 + 24) / 2, 2, 48);
    
  }
  
}
