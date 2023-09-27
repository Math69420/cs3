// Legend.java
// Class that implements a non-modal dialog box to display info about the color coding system.
import java.awt.*;
import java.awt.event.*;

public class Legend extends Frame
{
   private boolean visible = false;

   public Legend(Frame parent, Color[] colorArray,
                 Label[] labelArray)
   {
      super("Legend");
      setBackground(parent.getBackground());
      int numOfLabels = labelArray.length;

      ColorButton[] button = new ColorButton[numOfLabels];
      Panel[] buttonPanel = new Panel[numOfLabels];

      setLayout(new GridLayout(numOfLabels, 1));

      for(int i = 0; i < numOfLabels; i++)
      {
         button[i] = new ColorButton(colorArray[i]);
         buttonPanel[i] = new Panel();
         buttonPanel[i].setLayout(new FlowLayout(FlowLayout.LEFT));
         buttonPanel[i].add(button[i]);
         buttonPanel[i].add(new Label(""));
         buttonPanel[i].add(labelArray[i]);
         add("Center", buttonPanel[i]);
      }

      addWindowListener(new WindowAdapter()
      {
         public void windowClosing(WindowEvent e)
         {
            visible = false;
            e.getWindow().setVisible(false);
            e.getWindow().dispose();
         }
      });

      validate();
      pack();
      Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
      int screenWidth = d.getSize().width,
          screenHeight = d.getSize().height - 27,
          parentWidth = parent.getSize().width,
          parentHeight = parent.getSize().height,
          w = this.getSize().width,
          h = this.getSize().height;
      Point p = parent.getLocation(), setp = parent.getLocation();
      if (p.x < 0)
         setp.x = (parentWidth + p.x - w) / 2;
      else if (p.x + parentWidth > screenWidth)
         setp.x = p.x + (screenWidth - p.x - w) / 2;
      else
         setp.x = p.x + (parentWidth - w) / 2;

      if (p.y < 0)
         setp.y = (parentHeight + p.y - h) / 2;
      else if (p.y + parentHeight > screenHeight)
         setp.y = p.y + (screenHeight - p.y - h) / 2;
      else
         setp.y = p.y + (parentHeight - h) / 2;

      if (setp.x < 0)
         setp.x = 0;
      else if (setp.x + w > screenWidth)
         setp.x = screenWidth - w;

      if (setp.y < 0)
         setp.y = 0;
      else if (p.y + h > screenHeight)
         setp.y = screenHeight - h;
      setLocation(setp);
      setVisible(true);
      visible = true;
   }

   public boolean isVisible()
   {
      return visible;
   }

} 
