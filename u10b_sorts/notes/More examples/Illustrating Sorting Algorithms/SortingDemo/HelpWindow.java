// HelpWindow.java
// Class that implements a non-modal help dialog box.
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.applet.*;

public class HelpWindow extends Frame implements ActionListener, KeyListener, 
                                                 ItemListener
{
   private Button closeButton;
   private TextArea helpArea;
   private Choice helpChoice;
   private Applet applet;
   private Frame parent;
   private boolean visible = false;
   private String[] fileNames;

   public HelpWindow(Applet _applet, Frame parent, String product,
                     String[] docTitles, String[] _fileNames)
   {
      super("Help - " + product);
      applet = _applet;
      setBackground(SystemColor.control);
      fileNames = _fileNames;

      helpArea = new TextArea("", 20, 72, TextArea.SCROLLBARS_VERTICAL_ONLY);
      helpArea.setFont(new Font("monospaced", Font.PLAIN, 12));   
      helpArea.setEditable(false);
      helpArea.setBackground(Color.white);
      helpArea.addKeyListener(this);

      helpChoice = new Choice();
      for(int i = 0; i < docTitles.length; i++)
        helpChoice.add(docTitles[i]);
      helpChoice.addKeyListener(this);
      helpChoice.addItemListener(this);

      Panel topPanel = new Panel();
      topPanel.setLayout(new FlowLayout());
      topPanel.add(new Label("Contents:", Label.RIGHT));
      topPanel.add(helpChoice);

      closeButton = new Button("Close");
      closeButton.addActionListener(this);
      closeButton.addKeyListener(this);

      Panel buttonPanel = new Panel();
      buttonPanel.setLayout(new FlowLayout());
      buttonPanel.add(closeButton); 

      setLayout(new BorderLayout());
      add("North", topPanel);
      add("Center", helpArea);
      add("South", buttonPanel);
       
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
      setResizable(false);
	  readFile(fileNames[0]);
      setVisible(true);
      helpArea.requestFocus();
      visible = true;
   }

   public boolean isVisible()
   {
      return visible;
   }

   private void readFile(String fileName)
   {
      helpArea.setText("");
      BufferedReader input;
      try
      {
         if (applet != null)
         {
            URL url = new URL(applet.getCodeBase(), fileName);
            input = new BufferedReader(new InputStreamReader(url.openStream()));
         }
         else
            input = new BufferedReader(new FileReader(fileName));
         StringBuffer text = new StringBuffer();
         String line = "";
         do
         {
            line = input.readLine();
            if (line != null)
            {
               text.append(line);
               text.append("\n");
            }
         }
         while (line != null);
         helpArea.setText(text.toString());
		 helpArea.setCaretPosition(0);
         input.close();
      }
      catch (IOException ie)
      {
         System.err.println("Error opening file: " + ie);
      }
   }

   public void close()
   {
      visible = false;
      setVisible(false);
      dispose();
   }

   public void keyPressed(KeyEvent ke)
   {  
      if (ke.getKeyText(ke.getKeyCode()).equals("Escape"))
        close();
      else if (ke.getKeyText(ke.getKeyCode()).equals("Tab"))
        closeButton.requestFocus();
   }

   public void keyReleased(KeyEvent ke){}

   public void keyTyped(KeyEvent ke){}

   public void actionPerformed(ActionEvent ae)
   {
      close();
   }

   public void itemStateChanged(ItemEvent ie)
   {
      readFile(fileNames[helpChoice.getSelectedIndex()]);
      helpArea.requestFocus();
   }

}
