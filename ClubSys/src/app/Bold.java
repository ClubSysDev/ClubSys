package app;
/**
 * @author ArneK
 */
import java.awt.*;

public class  Bold implements Runnable, Konstanter
{
  double x, y, fartx, farty;
  int d;
  Color c;
  Graphics g;
  public Bold(Graphics g1, int x1, int y1,Color c, int d1)
  { 
	g = g1; x = x1; y = y1; this.c = c; d = d1;
   	this.fartx = 1 * Math.random();
   	this.farty = 1 * Math.random();

    Thread t = new Thread(this);
    t.start();
  }
    
  public void run() 
  { 
    while (true)  //  repeat forever
    {
      // Slet bold: Tegn bolden over med hvid pÃ¥ den gamle position
      g.setColor(Color.WHITE);
      g.fillOval((int) x, (int) y, d, d);
//      g.drawOval((int) x, (int) y, d, d);

      // Opdater positionen med farten
      x = x + fartx;
      y = y + farty;
//
      // Tegn bolden pÃ¥ den nye position
     g.setColor(c);
      g.fillOval((int) x, (int) y, d, d);
//      g.drawOval((int) x, (int) y, d, d);
      
      // Ã¦ndr boldens hastighed lidt nedad
      farty = farty + gravity;
//
      // Hvis bolden er uden for det tilladte omrÃ¥de skal den
      // rettes hen mod omrÃ¥det
      if (x   < 0)    fartx =  Math.abs(fartx);
      if (x+d > sizeJFrameX) fartx = -Math.abs(fartx);
      if (y   < 0)    farty =  Math.abs(farty);
      if (y+d >sizeJFrameY)  farty = -Math.abs(farty);

      // Vent lidt
      try { Thread.sleep(50); } catch (Exception e) {};
    }
    
    } 
}

