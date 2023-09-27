// ArrayCanvas.java
import java.awt.*;

public class ArrayCanvas extends Canvas
{
   public static final int NO_ARROW = -1, ARROW_UP = 0, ARROW_DOWN = 1;
   private int[] A, scratch, indexLength, pointerLength, statusArray, arrayPointersPos,
                 scratchStatusArray, scratchPointersPos;
   private String[] arrayPointers, scratchPointers;
   private Color[] colorArray;
   private String label1, label2;
   private int numOfElements, spacing, size, arrowStartPos = -1, arrowEndPos, arrowDir;
   private Font font = new Font("Monospaced", Font.PLAIN, 12);
   private ScrollPane arrayPane;
   private Image offscreenImage;

   public ArrayCanvas(){}

   public void setData(int[] _A, int[] _scratch, String[] _arrayPointers,
                       int[] _arrayPointersPos, Color[] _colorArray, ScrollPane _arrayPane)
   {
      A = _A;
      scratch = _scratch;
      arrayPointers = _arrayPointers;
      arrayPointersPos = _arrayPointersPos;
      for(int i = 0; i < arrayPointersPos.length; i++)
        arrayPointersPos[i] = -2;
      colorArray = _colorArray;
      arrayPane = _arrayPane;
      numOfElements = A.length;
      initStatusArrays();
      spacing = findMaxSpacing();
      size = (numOfElements + 2) * spacing;
      indexLength = new int[numOfElements];
      for(int i = 0; i < numOfElements; i++)
        indexLength[i] = getFontMetrics(font).stringWidth(Integer.toString(i));
      pointerLength = new int[arrayPointers.length];
      label1 = label2 = null;
      setSize(getPreferredSize());
      arrayPane.doLayout();
      repaint();
   }

   public void setExtendedData(String[] _scratchPointers, int[] _scratchPointersPos,
                               int[] _scratchStatusArray)
   {
      scratchPointers = _scratchPointers;
      scratchPointersPos = _scratchPointersPos;
      for(int i = 0; i < scratchPointersPos.length; i++)
        scratchPointersPos[i] = -2;
      scratchStatusArray = _scratchStatusArray;
   }

   public int getSpacing()
   {
      return spacing;
   }

   public void setArrow(int start, int end, int dir)
   {
      arrowStartPos = start;
      arrowEndPos = end;
      arrowDir = dir;
   }

   public void clearArrow()
   {
      arrowStartPos = -1;
   }

   public void setLabels(String _label1, String _label2)
   {
      label1 = _label1;
      label2 = _label2;
   }

   private int findMaxSpacing()
   {
      int maxOfValues, maxOfIndices;
      maxOfValues = maxOfIndices = Integer.MAX_VALUE * -1;
      for(int i = 0; i < numOfElements; i++)
      {
         int valueSpacing = getFontMetrics(font).stringWidth(Integer.toString(A[i]));
         int indexSpacing = getFontMetrics(font).stringWidth(Integer.toString(i));
         if (valueSpacing > maxOfValues)
           maxOfValues = valueSpacing;
         if (indexSpacing > maxOfIndices)
           maxOfIndices = indexSpacing;
      }
      if (maxOfValues > maxOfIndices)
        return maxOfValues + 10;
      else
        return maxOfIndices + 10;
   }

   private void initStatusArrays()
   {
      statusArray = new int[numOfElements];
      scratchStatusArray = new int[numOfElements];
      for(int i = 0; i < numOfElements; i++)
      {
         statusArray[i] = SortApp.UNSORTED;
         scratchStatusArray[i] = SortApp.UNSORTED;
      }
   }

   public Dimension getPreferredSize()
   {
      if (numOfElements == 0) 
         return new Dimension(0, 0);
      else if (size > arrayPane.getSize().width)
         return new Dimension(size, arrayPane.getSize().height - 20);
      else
         return new Dimension(arrayPane.getSize().width - 5, arrayPane.getSize().height - 16);
   }

   public void setStatus(int pos, int value)
   {
      statusArray[pos] = value;
   }

   public int getStatus(int pos)
   {
      return statusArray[pos];
   }

   public void setScratchStatus(int pos, int value)
   {
      scratchStatusArray[pos] = value;
   }

   public int getScratchStatus(int pos)
   {
      return scratchStatusArray[pos];
   }

   public void clear()
   {
      numOfElements = 0;
      label1 = label2 = null;
      clearArrow();
      setSize(getPreferredSize());
      arrayPane.doLayout();
      repaint();
   }

   public void update(Graphics g)
   {
      int width = this.getSize().width, height = this.getSize().height;
      if ((offscreenImage == null) ||
          ((offscreenImage.getWidth(this) != width) || (offscreenImage.getHeight(this) != height)))
        offscreenImage = this.createImage(width, height);
      Graphics gr = offscreenImage.getGraphics();
      paint(gr);
      g.drawImage(offscreenImage, 0, 0, this);
   }

   private void drawArray(Graphics g, int[] array, String[] pointers, int[] pointersPos, 
                          int tempCoord, int[] status, int height, int y)
   {
      for(int i = 0; i < numOfElements; i++)
      {
         int coord = (i * spacing) + tempCoord;
         g.drawRect(coord, y, spacing, 20);
         g.setColor(colorArray[status[i]]);
         g.fillRect(coord + 1, y + 1, spacing - 1, 19);

         if ((status[i] == SortApp.SWAPPING) || 
             (status[i] == SortApp.WORKING))
           g.setColor(Color.white);
         else
           g.setColor(Color.black);

         if (array[i] == Integer.MAX_VALUE)
         {
            int length = getFontMetrics(font).stringWidth("-");
            g.drawString("-", coord + (spacing - length) / 2, y + 15);
         }
         else
         {
            int length = getFontMetrics(font).stringWidth(Integer.toString(array[i]));
            g.drawString(Integer.toString(array[i]), 
                         coord + (spacing - length) / 2, y + 15);
         }

         if (arrowStartPos == i)
         {
            int startPos = arrowStartPos * spacing + tempCoord + spacing / 2,
                endPos = arrowEndPos * spacing + tempCoord + spacing / 2,
                startHeight = height / 4,
                endHeight = height * 3/4;
            g.setColor(colorArray[SortApp.SWAPPING]);
            if (arrowDir == ARROW_DOWN)
            {
               g.drawLine(startPos, height / 4 + 53,
                          endPos, endHeight - 34);
               int[] xCoords = {endPos - 4, endPos, endPos + 4};
               int[] yCoords = {endHeight - 34, endHeight - 30, endHeight - 34};
               Polygon triangle = new Polygon(xCoords, yCoords, 3);
               g.fillPolygon(triangle);
            }
            else
            {
               g.drawLine(startPos, startHeight + 58,
                          endPos, endHeight - 30);
               int[] xCoords = {startPos - 5, startPos, startPos + 5};
               int[] yCoords = {startHeight + 58, startHeight + 53, startHeight + 58};
               Polygon triangle = new Polygon(xCoords, yCoords, 3);
               g.fillPolygon(triangle);
            }
         }
         g.setColor(Color.black);

         int indexCoord = coord + (spacing - indexLength[i]) / 2;
         g.drawString(Integer.toString(i), indexCoord, y - 5);

         int yHeight = y - 18;
         for(int j = 0; j < pointers.length; j++)
         {
            int baseWidth = spacing / 2 - pointerLength[j] / 2;
            if (pointersPos[j] == -1)
              g.drawString(pointers[j], baseWidth - 1 * spacing + tempCoord, yHeight);
            else if (pointersPos[j] == i)
              g.drawString(pointers[j], baseWidth + coord, yHeight);
            else if (pointersPos[j] == numOfElements)
              g.drawString(pointers[j], baseWidth + numOfElements * spacing + tempCoord,
                           yHeight);
            if (j == 0)
              yHeight = y + 33;
            else
              yHeight = y + 48;
         }
      }
   }

   private void drawExtraLabels(Graphics g, int width, int y, String label)
   {
      if (label != null)
      {
         int length = getFontMetrics(font).stringWidth(label);
         g.drawString(label, (width - length) / 2, y);
      }
   }

   public void paint(Graphics g)
   {
      int width = this.getSize().width, height = this.getSize().height;
      g.clearRect(0, 0, width, height);
      g.setFont(font);
      if (pointerLength != null)
        for(int i = 0; i < pointerLength.length; i++)
           pointerLength[i] = getFontMetrics(font).stringWidth(arrayPointers[i]);

      int tempCoord = (width - numOfElements * spacing) / 2, y;
      if (scratch == null)
        y = height * 2/5;
      else
        y = height * 1/4;

      drawArray(g, A, arrayPointers, arrayPointersPos, 
                tempCoord, statusArray, height, y);
      if (scratch != null)
      {
         drawExtraLabels(g, width, y - 33, label1);
         y = height * 3/4;
         drawArray(g, scratch, scratchPointers, scratchPointersPos,
                   tempCoord, scratchStatusArray, height, y);
         drawExtraLabels(g, width, y + 38, label2);
      }
   }
   
}
