// AboutBox.java
// Class that implements a modal message dialog box to display info about the program.
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;

public class AboutBox extends Dialog implements ActionListener,
                                                KeyListener
{
   private Button ok;

   public AboutBox(Applet applet, Frame parent, String title, 
                   String s0, String s1, String s2, String s3, String s4,
                   String imageString)
   {
      super(parent, "About...", true);
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
      catch (MalformedURLException murle)
      {
         image = null;
         System.err.println("Error opening image: " + murle);
      }

      Label st[] = new Label[5];
      st[0] = new Label(s0, Label.CENTER);
      st[1] = new Label(s1, Label.CENTER);
      st[2] = new Label(s2, Label.CENTER);
      st[3] = new Label(s3, Label.CENTER);
      st[4] = new Label(s4, Label.CENTER);

      Panel stPanel[] = new Panel[5];
      Panel stringPanel = new Panel();
      stringPanel.setLayout(new GridLayout(5, 1, 0, 0));
      for(int i = 0; i < 5; i++)
      {
         stPanel[i] = new Panel();
         stPanel[i].add(st[i]);
         stringPanel.add(stPanel[i]);
      }

      ok = new Button("OK");
      ok.addActionListener(this);
      ok.addKeyListener(this);

      Label titleLabel = new Label(title);
      titleLabel.setFont(new Font("sansserif", Font.BOLD, 16));

      Panel imageStringPanel = new Panel();
      imageStringPanel.setLayout(new FlowLayout());
      imageStringPanel.add(image); 
      imageStringPanel.add(titleLabel);

      Panel buttonPanel = new Panel();
      buttonPanel.setLayout(new FlowLayout());
      buttonPanel.add(ok); 

      setLayout(new BorderLayout());
      add("North", new Box(imageStringPanel, null, Box.LEFT));
      add("Center", new Box(stringPanel, null, Box.LEFT));
      add("South", buttonPanel);

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
   }

   public void keyPressed(KeyEvent ke)
   {
      if ((ke.getKeyText(ke.getKeyCode()).equals("Enter")) ||
          (ke.getKeyText(ke.getKeyCode()).equals("Escape")))
      {
         setVisible(false);
         dispose();
      } 
   }

   public void keyReleased(KeyEvent ke){}

   public void keyTyped(KeyEvent ke){}

   public void actionPerformed(ActionEvent ae)
   {
      setVisible(false);
      dispose(); 
   }

}
