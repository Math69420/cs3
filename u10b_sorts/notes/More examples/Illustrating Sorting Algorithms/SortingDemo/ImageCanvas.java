// ImageCanvas.java
import java.awt.*;
import java.net.*;

public class ImageCanvas extends Canvas
{  
   public static final int ORIGINAL = 1, CENTER = 2, FULL = 3;
   private MediaTracker tracker = null;
   private Image image = null;
   private int alignment = CENTER;

   public ImageCanvas(String imageName, int _alignment)
   {
      super(); 
      trackImage(getToolkit().getImage(imageName));
      alignment = _alignment;
   }

   public ImageCanvas(URL imageURL, int _alignment)
   {
      super();
      trackImage(getToolkit().getImage(imageURL));
      alignment = _alignment;
   }

   private void trackImage(Image _image)
   {
      image = _image;
      tracker = new MediaTracker(this);
      tracker.addImage(image, 0);
      try
      {  
         tracker.waitForAll();
      }
      catch(InterruptedException ie)
      { 
         System.err.println("Image loading interrupted: " + ie);
      }
   }

   public void paint(Graphics g)
   {  
      if (tracker.isErrorAny())
      {
         g.setColor(Color.red);
         g.fillRect(0, 0, getSize().width, getSize().height);
         g.setColor(Color.black); 
         g.drawLine(0, 0, getSize().width, getSize().height);
         g.drawLine(getSize().width, 0, 0, getSize().height);
      }
      else 
      { 
         if (alignment == ORIGINAL)
            g.drawImage(image, 0, 0, this);
         else if (alignment == FULL)
            g.drawImage(image, 10, 10, getSize().width, getSize().height,
                        this);
         else
         {
            int x = Math.max((getSize().width - image.getWidth(this))/2, 0);
            int y = Math.max((getSize().height - image.getHeight(this))/2, 0);
            g.drawImage(image, x, y, this);
         }
      }
   }

   public Dimension getPreferredSize()
   {
      if (tracker.isErrorAny())
        return new Dimension(40, 40); 
      else
        return new Dimension(image.getWidth(this), image.getHeight(this));
   }

}
