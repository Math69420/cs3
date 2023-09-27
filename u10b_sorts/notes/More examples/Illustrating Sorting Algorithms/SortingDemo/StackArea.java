// StackArea.java
import java.awt.*;

public class StackArea extends Canvas
{
   private Stack stack = null;
   private Font font = new Font("Monospaced", Font.PLAIN, 12);
   private int max, width, height;
   private ScrollPane stackPane;
   private Image offscreenImage;

   public StackArea(){}

   public void setPane(ScrollPane _stackPane)
   {
      stackPane = _stackPane;
   }

   public void setData(Stack _stack)
   {
      stack = _stack;
      max = findMaxSize() + 10;
      setSize(getPreferredSize());
      stackPane.doLayout();
      repaint();
   }

   private int findMaxSize()
   {
      Node p = stack.top;
      int max = Integer.MAX_VALUE * -1;
      while (p != null)
      {
         int length = getFontMetrics(font).stringWidth(p.data);
         if (length > max)
           max = length;
         p = p.next;
      }
      return max;
   }

   public Dimension getPreferredSize()
   {
      if (stack == null) 
        return new Dimension(0, 0);
      else
        return new Dimension(max * stack.numOfNodes + 25, 76);
   }
 
   public void clear()
   {
      stack = null;
      setSize(getPreferredSize());
      stackPane.doLayout();
      repaint();
   }

   public void update(Graphics g)
   {
      width = this.getSize().width;
      height = this.getSize().height;
      if ((offscreenImage == null) ||
          ((!(offscreenImage.getWidth(this) == width) && (offscreenImage.getHeight(this) == height))))
        offscreenImage = this.createImage(width, height);
      Graphics gr = offscreenImage.getGraphics();
      paint(gr);
      g.drawImage(offscreenImage, 0, 0, this);
   }

   public void paint(Graphics g)
   {
      g.clearRect(0, 0, width, height);
      g.setFont(font);     
      int startCoord = (this.getSize().height - 70) / 2;
      g.drawRect(10, startCoord, 10, 70);
      g.setColor(new Color(100, 75, 57));
      g.fillRect(11, startCoord + 1, 9, 69);
      g.setColor(Color.white);
      startCoord += 15;
      g.drawString("S", 12, startCoord);
      g.drawString("T", 12, startCoord + 12);
      g.drawString("A", 12, startCoord + 24);
      g.drawString("C", 12, startCoord + 36);
      g.drawString("K", 12, startCoord + 48);
      g.setColor(Color.black);
      if (stack != null)
        if (!stack.isEmpty())
        {
           Node p = stack.bottom;
           int nodeNum = 0;
           startCoord = (this.getSize().height - 20) / 2;
           while (p != null)
           {
              nodeNum += 1;
              int coord = (nodeNum - 1) * max + 21;
              int length = getFontMetrics(font).stringWidth(p.data);
              g.drawRect(coord, startCoord, max, 20);
              g.setColor(Color.lightGray);
              g.fillRect(coord + 1, startCoord + 1, max - 1, 19);
              g.setColor(Color.black);
              g.drawString(p.data, coord + (max - length) / 2, startCoord + 15);
              p = p.prev;
           }
        }
   }

}
