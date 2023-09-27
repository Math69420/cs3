// ProgramCanvas.java
import java.awt.*;

public class ProgramCanvas extends Canvas
{  
   private static final int OFFSET = 6, LINE_HEIGHT = 15;
   private int selectedLine = -1, prevSelectedLine = -1, 
               selectedLine2 = -1, prevSelectedLine2 = -1,
               selectedLine3 = -1, prevSelectedLine3 = -1,
               lineLength, width, height;
   private String[] algCode;
   private Font font = new Font("Monospaced", Font.PLAIN, 12);
   private Image offscreenImage;
   
   public ProgramCanvas(String[] _algCode)
   {
      super();
      algCode = new String[_algCode.length];
      for(int i = 0; i < _algCode.length; i++)
        algCode[i] = _algCode[i];
      lineLength = maxLineLength();
      setBackground(Color.white);
      setSize(lineLength, algCode.length * 15 + 5);
      width = this.getSize().width;
      height = this.getSize().height;
   }

   private int maxLineLength()
   {
      int max = Integer.MAX_VALUE * -1, maxPos = 0;
      for(int i = 0; i < algCode.length; i++)
        if (algCode[i].length() > max)
        {
           max = algCode[i].length();
           maxPos = i;
        }
      return getFontMetrics(font).stringWidth(algCode[maxPos]) + 10;
   }

   public void clear()
   {
      selectLines(-1, -1, -1);
   }

   public void selectLine(int lineNumber)
   {
      prevSelectedLine = selectedLine;
      selectedLine = lineNumber;
      if (prevSelectedLine != selectedLine)
        repaint();
   }   

   public void selectLines(int lineNumber1, int lineNumber2)
   {
      prevSelectedLine = selectedLine;
      selectedLine = lineNumber1;
      prevSelectedLine2 = selectedLine2;
      selectedLine2 = lineNumber2;
      if ((prevSelectedLine != selectedLine) || (prevSelectedLine2 != selectedLine2))
        repaint();
   }

   public void selectLines(int lineNumber1, int lineNumber2, int lineNumber3)
   {
      prevSelectedLine = selectedLine;
      selectedLine = lineNumber1;
      prevSelectedLine2 = selectedLine2;
      selectedLine2 = lineNumber2;
      prevSelectedLine3 = selectedLine3;
      selectedLine3 = lineNumber3;
      if ((prevSelectedLine != selectedLine) || (prevSelectedLine2 != selectedLine2) ||
          (prevSelectedLine3 != selectedLine3))
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
      g.setFont(font);
      g.setColor(SystemColor.control);
      g.fillRect(0, 0, width, height);

      for(int i = 0; i < algCode.length; i++)
         if (selectedLine == i)
         {
            g.setColor(Color.blue);
            g.fillRect(0, (LINE_HEIGHT * i) + 4, lineLength, LINE_HEIGHT + 1);
            g.setColor(Color.white);
            g.drawString(algCode[i], OFFSET, LINE_HEIGHT * (i + 1));
         }
         else if (selectedLine2 == i)
         {
            g.setColor(new Color(22, 107, 29));
            g.fillRect(0, (LINE_HEIGHT * i) + 4, lineLength, LINE_HEIGHT + 1);
            g.setColor(Color.white);
            g.drawString(algCode[i], OFFSET, LINE_HEIGHT * (i + 1));
         }
         else if (selectedLine3 == i)
         {
            g.setColor(new Color(128, 0, 64));
            g.fillRect(0, (LINE_HEIGHT * i) + 4, lineLength, LINE_HEIGHT + 1);
            g.setColor(Color.white);
            g.drawString(algCode[i], OFFSET, LINE_HEIGHT * (i + 1));
         }
         else
         {
            if ((prevSelectedLine == i) || (prevSelectedLine2 == i) ||
                (prevSelectedLine3 == i))
            {
               g.setColor(SystemColor.control);
               g.fillRect(0, (LINE_HEIGHT * i) + 4, lineLength, LINE_HEIGHT + 1);
            }
            g.setColor(Color.black);
            if (!algCode[i].equals("\n"))
              g.drawString(algCode[i], OFFSET, LINE_HEIGHT * (i + 1));
         }
   }

}
