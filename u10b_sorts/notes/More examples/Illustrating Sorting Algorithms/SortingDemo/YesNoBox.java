// YesNoCancelBox.java
// Class that implements a modal message dialog box.
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;

public class YesNoBox extends Dialog implements ActionListener
{
   public static final int NO = 0, YES = 1;
   private Button yes, no;
   private int answer;

   public YesNoBox(Applet applet, Frame parent, String title, String messageString, 
                   String imageString)
   {
      super(parent, title, true);
      ImageCanvas image = null;
      try
      { 
         if (applet == null)
            image = new ImageCanvas("Images/" + imageString, ImageCanvas.ORIGINAL);
         else
         {
            URL url = new URL(applet.getCodeBase() + "Images/" + imageString);
            image = new ImageCanvas(url, ImageCanvas.ORIGINAL);
         }
      }
      catch(MalformedURLException murle)
      {
         image = null;
         System.err.println("Error opening image: " + murle); 
      }

      Label message = new Label(messageString);
      yes = new Button("  Yes  ");
      yes.addActionListener(this);
      no = new Button("  No  ");
      no.addActionListener(this);

      Panel imageMessagePanel = new Panel();
      imageMessagePanel.setLayout(new FlowLayout());
      imageMessagePanel.add(image); 
      imageMessagePanel.add(message); 

      Panel buttonPanel = new Panel();
      buttonPanel.setLayout(new FlowLayout());
      buttonPanel.add(yes);
      buttonPanel.add(no);

      setLayout(new GridLayout(2, 1));
      add(imageMessagePanel);
      add(buttonPanel);
       
      addWindowListener(new WindowAdapter()
      {
         public void windowClosing(WindowEvent e)
         {
            e.getWindow().setVisible(false);
            e.getWindow().dispose();
         }
      });

      validate();
      pack();
      if (parent.getTitle().equals(""))
         setBackground(SystemColor.control);
      else
      {
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
      }

      if (applet == null)
      {
         try
         {
            URL url = new URL("file:" + System.getProperty("user.dir") +
                              "/Audio/Chord.au");
            AudioClip aud = Applet.newAudioClip(url);
            aud.play();
         }
         catch (MalformedURLException murle)
         {
            System.err.println("Error opening audio clip: " + murle);
         }
      }
      else
      {
         AudioClip aud = applet.getAudioClip(applet.getCodeBase(), "Audio/Chord.au");
         aud.play();
      }
      setVisible(true);
   }

   public int getAnswer()
   {
      return answer;
   }

   public void actionPerformed(ActionEvent ae)
   {
      if (ae.getSource() == yes)
        answer = YES;
      else if (ae.getSource() == no)
        answer = NO;
      setVisible(false);
      dispose(); 
   }

}
