package Pyro.TextLib.Text;

import java.util.HashMap;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PVector;

public class VisibleText
{
  
  public static void text(PApplet applet, String str, int x, int y, int strokeWeight, int textSize)
  {
    
    HashMap<PVector, ColorManager> txtPixels = new HashMap<PVector, ColorManager>();
    
    PGraphics gr = applet.createGraphics(applet.width, applet.height);
    
    gr.beginDraw();
    gr.background(255);
    gr.strokeWeight(strokeWeight);
    if (textSize > 0) gr.textSize(textSize);
    gr.fill(0);
    gr.text(str, x, y);
    
    gr.endDraw();
    
    gr.loadPixels();
    
    for (int gy = 0; gy < applet.width; gy++)
    {
      
      for (int gx = 0; gx < applet.height; gx++)
      {
        
        int color = gr.pixels[(gy * applet.width) + gx];
        
        ColorManager cm = new ColorManager(color);
        
        if (cm.red() + cm.green() + cm.blue() < 765)
        {
          
          txtPixels.put(new PVector(gx, gy), cm);
          
        }
        
      }
      
    }
    
    applet.loadPixels();
    
    txtPixels.forEach( (pos, col) -> 
    {
      
      ColorManager opAppCol = ColorManager.getOpposite(new ColorManager(applet.get((int)pos.x, (int)pos.y)));
      
      //if (pos.x % 160 == 0 && pos.y % 16 == 0) opAppCol.printColor();
      
      if (opAppCol.isDark()) opAppCol.addColor(col);
      if (opAppCol.isLight()) opAppCol = ColorManager.getOpposite(col);
      
      applet.pixels[(int)((pos.y * applet.width) + pos.x)] = opAppCol.color();
      
    });
    
    applet.updatePixels();
    
  }
  
  public static void text(PApplet applet, String str, int x, int y)
  {
    
    text(applet, str, x, y, 1, 0);
    
  }

}
