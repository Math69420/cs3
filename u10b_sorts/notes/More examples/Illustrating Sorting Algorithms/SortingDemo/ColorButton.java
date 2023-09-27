// ColorButton.java
import java.awt.*;

public class ColorButton extends Canvas
{ 
   private Color color = null;

   public ColorButton(Color _color)
   {
      super(); 
      color = _color;
   }

   public Dimension getPreferredSize()
   {
      return new Dimension(11, 11);
   }

   public Color getColor()
   {  
      return color;
   }

   public void paint(Graphics g)
   {  
      g.setColor(color);
      g.fill3DRect(0, 0, getSize().width, getSize().height, false);
   }

}
