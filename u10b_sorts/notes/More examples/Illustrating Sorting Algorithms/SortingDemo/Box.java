// Box.java
// Draws a (possibly titled) box around a component.
// This class was only modified slightly.  It came primarily from:
//   Graphic Java 1.2 - Mastering the JFC, 3rd edition
//   David M. Geary
//   (c) 1999 Sun Microsystems, Inc.
import java.awt.*;

class Box extends Panel
{
   public static final int LEFT = 0, CENTER = 1;
   String title;
   int alignment;

   public Box(Component c, String title, int alignment)
   {
      this.title = title;
      this.alignment = alignment;
      setLayout(new BorderLayout());
      add(c, "Center");
   }

   public Insets getInsets()
   {
      Graphics g = getGraphics();
      if (g != null)
      {
         FontMetrics fm = g.getFontMetrics();
         g.dispose();
         return new Insets(fm.getHeight(), 2, 2, 2);
      }
      return new Insets(2, 2, 2, 2);
   }

   public void paint(Graphics g)
   {
      Dimension sz = getSize();
      FontMetrics fm = g.getFontMetrics();
      int h = fm.getHeight();

      g.setColor(SystemColor.controlShadow);
      g.drawRect(0, h/2, sz.width - 2, sz.height - 2 - h/2);
      g.setColor(SystemColor.controlLtHighlight);
      g.drawRect(1, h/2 + 1, sz.width - 2, sz.height - 2 - h/2);

      if (this.title != null)
      {
         int beginWhere;
         g.setColor(getBackground());
         if (alignment == 0)
            beginWhere = 8;
         else
            beginWhere = (sz.width - fm.stringWidth(title))/2 - 2;
         g.clearRect(beginWhere, 0, fm.stringWidth(title) + 4, fm.getHeight());
         g.setColor(getForeground());
         g.drawString(title, beginWhere + 2, fm.getAscent());
      }
   }

}
