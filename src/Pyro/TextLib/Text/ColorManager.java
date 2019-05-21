package Pyro.TextLib.Text;

public class ColorManager
{
  
  private int red;
  private int green;
  private int blue;
  
  private int alpha;

  public ColorManager(int col)
  {
    
    this.setColor(col);
    
  }
  
  public ColorManager(int r, int g, int b, int a)
  {
    
    this.setColor(r, g, b, a);
    
  }
  
  public ColorManager(int r, int g, int b)
  {
    
    this.setColor(r, g, b);
    
  }
  
  public void setColor(int col)
  {
    
    this.red = col >> 16 & 0xFF;
    this.green = col >> 8 & 0xFF;
    this.blue = col & 0xFF;
    
    this.alpha = col >> 24 & 0xFF;
    
  }
  
  public void setColor(int r, int g, int b, int a)
  {
    
    this.red = r > 255 ? 255 : r;
    this.green = g > 255 ? 255 : g;
    this.blue = b > 255 ? 255 : b;
    
    this.alpha = a > 255 ? 255 : a;
    
  }
  
  public void setColor(int r, int g, int b)
  {
    
    this.setColor(r, g, b, 255);
    
  }
  
  public ColorManager addColor(ColorManager col)
  {
    
    this.setColor(this.red + col.red, this.green + col.green, this.blue + col.blue, this.alpha + col.alpha);
    
    return this;
    
  }
  
  public ColorManager subColor(ColorManager col)
  {
    
    this.setColor(this.red - col.red, this.green - col.green, this.blue - col.blue, this.alpha - col.alpha);
    
    return this;
    
  }
  
  public void printColor()
  {
    
    System.out.println("r: " + String.valueOf(this.red) + 
                       " g: " + String.valueOf(this.green) + 
                       " b: " + String.valueOf(this.blue) +
                       " a: " + String.valueOf(this.alpha)
                       );
    
  }
  
  public boolean isLight()
  {
    
    return this.red + this.green + this.blue == 765 ? true : false;
    
  }
  
  public boolean isDark()
  {
    
    return !isLight();
    
  }
  
  public int red()
  {
    
    return this.red;
    
  }
  
  public int green()
  {
    
    return this.green;
    
  }
  
  public int blue()
  {
    
    return this.blue;
    
  }
  
  public int alpha()
  {
    
    return this.alpha;
    
  }
  
  public int color()
  {
    
    return (this.alpha << 24) + (this.red << 16) + (this.green << 8) + this.blue;
    
  }
  
  public static ColorManager getOpposite(ColorManager col)
  {
    
    return new ColorManager(255 - col.red, 255 - col.green, 255 - col.blue);
    
  }
  
}
