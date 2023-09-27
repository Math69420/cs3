// SortApp.java
import java.awt.*;
import java.awt.event.*;

public abstract class SortApp extends Frame implements ActionListener, KeyListener,
                                                       Runnable
{ 
   public static final int UNSORTED = 0, SWAPPING = 1, DONE = 2, WORKING = 3,
                           PARTSORTED = 4, STRIDESORTED = 5;

   private Button about, legend, help, noGraphics;
   private Legend leg = null;
   private Label[] labelArray;
   private int typeOfSort;
   private HelpWindow helpWindow = null;
   private String product = "Sorting Demo v2.02";

   protected volatile boolean shouldRun, threadStarted;
   protected GridBagConstraints gbc = new GridBagConstraints();
   protected boolean runsFromApplet, isSpecial;
   protected SortStarter ss = null;
   protected Button ok, contPause, clear;
   protected ProgramCanvas program;
   protected Color[] colorArray;
   protected TextField[] variables;
   protected int[] A, copy, randomCopy, scratch, arrayPointersPos, scratchPointersPos, scratchStatusArray;
   protected int compCt, exchangeCt, numOfVars;
   protected ArrayCanvas arrayCanvas = new ArrayCanvas(),
                         scratchCanvas = new ArrayCanvas();
   protected StackArea stackArea;
   protected TextField compField, exchangeField, arrayLine;
   protected String[] algCode, arrayPointers, scratchPointers;
   protected Label[] labels;
   protected Slider slider;
   protected ScrollPane arrayPane, stackPane;
   protected Panel topPanel, inputPanel, statsPanel, speedPanel, buttonPanel;
   protected String algorithmName, arrayString;
   protected CompareTable table;
   protected Thread runner = null, thisThread;

   public SortApp(SortStarter _ss, boolean _runsFromApplet, int _typeOfSort,
                  String _algorithmName, CompareTable _table, boolean _isSpecial)
   {
      super(_algorithmName + " Demo");
      ss = _ss;
      runsFromApplet = _runsFromApplet;
      typeOfSort = _typeOfSort;
      algorithmName = _algorithmName;
      table = _table;
      isSpecial = _isSpecial;
      threadStarted = false;
      setBackground(SystemColor.control);

      colorArray = new Color[6];
      colorArray[UNSORTED] = Color.lightGray;
      colorArray[SWAPPING] = new Color(157, 19, 54);
      colorArray[DONE] = new Color(128, 255, 128);
      colorArray[WORKING] = new Color(0, 128, 192);
      colorArray[PARTSORTED] = new Color(233, 162, 251);
      colorArray[STRIDESORTED] = new Color(255, 177, 100);

      labelArray = new Label[colorArray.length];
      labelArray[0] = new Label("Unsorted");
      labelArray[1] = new Label("Exchanging / Copying");
      labelArray[2] = new Label("In place");
      labelArray[3] = new Label("Subarray being sorted");
      labelArray[4] = new Label("Sorted subarray");
      labelArray[5] = new Label("Sorted stride");
    
      Label title = new Label(algorithmName + " Demo", Label.CENTER);
      title.setFont(new Font("sansserif", Font.BOLD, 30));
      Panel titlePanel = new Panel();  
      titlePanel.setLayout(new FlowLayout()); 
      titlePanel.add(title);

      topPanel = new Panel();
      topPanel.setLayout(new BorderLayout());
      topPanel.add("Center", titlePanel);

      ok = new Button("Start");
      ok.addActionListener(this);
      arrayLine = new TextField(35);
      arrayLine.addKeyListener(this);
      Label helpLine = new Label("[ Enter up to " + SortStarter.MAXLENGTH + " integers, each followed by a space. ]",
         Label.CENTER);

      Panel arrayLinePanel = new Panel();
      arrayLinePanel.setLayout(new GridBagLayout());
      
      gbc.insets = new Insets(0, 5, 0, 7);
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = 1;
      gbc.weightx = 100;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      arrayLinePanel.add(arrayLine, gbc);
      gbc.insets = new Insets(0, 0, 0, 7);
      gbc.anchor = GridBagConstraints.EAST;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 0;
      gbc.fill = GridBagConstraints.NONE;
      arrayLinePanel.add(ok, gbc);
      gbc.insets = new Insets(0, 5, 0, 7);
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = 1;
      gbc.weightx = 0;
      gbc.fill = GridBagConstraints.NONE;
      arrayLinePanel.add(helpLine, gbc);

      inputPanel = new Panel();
      inputPanel.setLayout(new BorderLayout());
      inputPanel.add("North", new Label(""));
      inputPanel.add("Center", arrayLinePanel);

      compField = new TextField(6);
      compField.setEditable(false);
      compField.setBackground(Color.white);
      exchangeField = new TextField(6);
      exchangeField.setEditable(false);
      exchangeField.setBackground(Color.white);
      statsPanel = new Panel();
      statsPanel.setLayout(new FlowLayout());
      statsPanel.add(new Label("Comparisons: ", Label.RIGHT));
      statsPanel.add(compField);
      statsPanel.add(new Label("Exchanges: ", Label.RIGHT));
      statsPanel.add(exchangeField);

      contPause = new Button("  Pause  ");
      contPause.addActionListener(this);
      contPause.setEnabled(false);
      clear = new Button("  Clear  ");
      clear.addActionListener(this);
      clear.setEnabled(false);
      legend = new Button("    Legend    ");
      legend.addActionListener(this);
      help = new Button("      Help      ");
      help.addActionListener(this);
      about = new Button("     About     ");
      about.addActionListener(this);
      noGraphics = new Button("No Graphics");
      noGraphics.addActionListener(this);

      slider = new Slider("Delay in msec.", 500, 10, 20, 2010);

      Panel contPausePanel = new Panel();
      contPausePanel.setLayout(new GridBagLayout());
      gbc.insets = new Insets(0, 0, 0, 0);
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 0;
      gbc.weighty = 100;
      gbc.fill = GridBagConstraints.BOTH;
      contPausePanel.add(new Canvas(), gbc);
      gbc.insets = new Insets(0, 20, 0, 20);
      gbc.weighty = 0;
      contPausePanel.add(contPause, gbc);
      gbc.insets = new Insets(0, 0, 0, 0);
      gbc.weighty = 100;
      contPausePanel.add(new Canvas(), gbc);

      Panel clearPanel = new Panel();
      clearPanel.setLayout(new GridBagLayout());
      gbc.insets = new Insets(0, 0, 0, 0);
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 0;
      gbc.weighty = 100;
      gbc.fill = GridBagConstraints.BOTH;
      clearPanel.add(new Canvas(), gbc);
      gbc.insets = new Insets(0, 20, 0, 20);
      gbc.weighty = 0;
      clearPanel.add(clear, gbc);
      gbc.insets = new Insets(0, 0, 0, 0);
      gbc.weighty = 100;
      clearPanel.add(new Canvas(), gbc);

      speedPanel = new Panel();
      speedPanel.setLayout(new BorderLayout());
      speedPanel.add("West", contPausePanel);
      speedPanel.add("Center", slider);
      speedPanel.add("East", clearPanel);

      speedPanel = new Panel();
      speedPanel.setLayout(new GridBagLayout());
      gbc.insets = new Insets(0, 0, 0, 0);
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = 1;
      gbc.weightx = 0;
      gbc.fill = GridBagConstraints.NONE;
      speedPanel.add(contPausePanel, gbc);
      gbc.weightx = 100;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      speedPanel.add(slider, gbc);
      gbc.weightx = 0;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.fill = GridBagConstraints.NONE;
      speedPanel.add(clearPanel, gbc);

      buttonPanel = new Panel();
      buttonPanel.setLayout(new FlowLayout());
      buttonPanel.add(noGraphics);
      buttonPanel.add(legend);
      buttonPanel.add(help);
      buttonPanel.add(about);

      arrayPane = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
      arrayPane.setBackground(Color.white);
      arrayPane.add(arrayCanvas);
      arrayPane.setSize(390, 120);

      addWindowListener(new WindowAdapter()
      {     
         public void windowClosing(WindowEvent e)
         {  
            if (runsFromApplet)
            {
               if (runner != null)
                 runner.interrupt();
               stop();
               closeLegend();
               closeHelpWindow();
               ss.close();
            }
            else        
               System.exit(0);
         }
      });

      arrayLine.requestFocus();
   }

   protected void closeLegend()
   {
      if (leg != null)
      {
         leg.setVisible(false);
         leg.dispose();
         leg = null;
      }
   }

   protected void closeHelpWindow()
   {
      if (helpWindow != null)
      {
         helpWindow.setVisible(false);
         helpWindow.dispose();
         helpWindow = null;
      }
   }

   private void start()
   {
      shouldRun = true;
      if (runner == null)
      {
         threadStarted = true;
         runner = new Thread(this);
         runner.start();
      }
   }

   protected void stop()
   {
      shouldRun = false;
      runner = null;
   }

   protected void pause()
   {
      Thread t = Thread.currentThread();
      try
      {
         if (shouldRun)
           runner.sleep(slider.getValue());
         while ((!shouldRun) && (runner == t))
           runner.sleep(100);
      }
      catch (InterruptedException ie) {  }
   }

   private void clearTextFields()
   {
      for(int i = 0; i < numOfVars; i++)
        variables[i].setText("");
      compField.setText("");
      exchangeField.setText("");
   }

   private void stopAndClear()
   {
      stop();
      clearTextFields();
      program.clear();
      ok.setEnabled(true);
      contPause.setLabel("  Pause  ");
      contPause.setEnabled(false);
      clear.setEnabled(false);
      if ((typeOfSort == ss.QUICK) || (typeOfSort == ss.MERGE))
        stackArea.clear();
      if (threadStarted)
        arrayCanvas.clear();
      arrayLine.requestFocus();
   }

   public abstract void run();

   public abstract void noGraphics();

   protected void copyToRandomCopy()
   {
      randomCopy = new int[copy.length];
      for(int i = 0; i < copy.length; i++)
        randomCopy[i] = copy[i];
   }

   protected void AToCopy()
   {
      copy = new int[A.length];
      for(int i = 0; i < A.length; i++)
        copy[i] = A[i];
   }

   private void copyToA()
   {
      A = new int[copy.length];
      for(int i = 0; i < copy.length; i++)
        A[i] = copy[i];
   }

   private void randomCopyToA()
   {
      A = new int[randomCopy.length];
      for(int i = 0; i < randomCopy.length; i++)
        A[i] = randomCopy[i];
   }

   private void processCommand()
   {
      stop();
      arrayLine.requestFocus();
      String gottenText = arrayLine.getText().trim();
      arrayLine.setText(gottenText);
      arrayLine.selectAll();
      if (gottenText.equals(""))
      {
         MessageBox mb = new MessageBox(ss, this, "Error",
                         "Cannot sort array: no array entered.", "exclaim.gif");
      }
      else
      {
         CharArray dataLine = new CharArray(gottenText);
         boolean ok = true;
         if ((isSpecial) && ((gottenText.indexOf("rand") == 0) || (gottenText.indexOf("sorted") == 0) ||
             (gottenText.indexOf("reverse") == 0)) && (!gottenText.equals(arrayString)))
         {
            ok = false;
            YesNoBox ynb = new YesNoBox(ss, this, "Question",
                           "Special-case array illegally altered.  Revert to original?",
                           "questionMark.gif");
            if (ynb.getAnswer() == YesNoBox.YES)
            {
               arrayLine.setText(arrayString);
               arrayLine.selectAll();
               copy = new int[randomCopy.length];
               for(int i = 0; i < randomCopy.length; i++)
                 copy[i] = randomCopy[i];
               ok = true;
            }
         }
         else if (((gottenText.indexOf("rand") == 0) || (gottenText.indexOf("sorted") == 0) ||
                   (gottenText.indexOf("reverse") == 0)) && (gottenText.equals(arrayString)))
            isSpecial = true;
         else
            isSpecial = false;
         if (ok)
         {
            if (!isSpecial)
            {
               try
               {
                  A = dataLine.getBoundlessArray();
                  String s = "";
                  for(int i = 0; i < A.length; i++)
                    s += Integer.toString(A[i]) + " ";
                  arrayLine.setText(s.trim());
                  arrayLine.selectAll();
                  if (A.length > SortStarter.MAXLENGTH)
                  {
                     ok = false;
                     YesNoBox ynb = new YesNoBox(ss, this, "Question",
                                    "Array exceeds max length of " + ss.MAXLENGTH + " integers. Proceed without graphics?",
                                    "questionMark.gif");
                     if (ynb.getAnswer() == YesNoBox.YES)
                       prepareNoGraphics();
                  }
               }
               catch (ArrayException ae)
               {
                  ok = false;
                  MessageBox mb = new MessageBox(ss, this, "Error", ae.getMsg(), "exclaim.gif");
               }
            }
            else
            {
               copyToA();
               if (A.length > SortStarter.MAXLENGTH)
               {
                  ok = false;
                  YesNoBox ynb = new YesNoBox(ss, this, "Question",
                                 "Array exceeds max length of " + ss.MAXLENGTH + " integers. Proceed without graphics?",
                                 "questionMark.gif");
                  if (ynb.getAnswer() == YesNoBox.YES)
                    prepareNoGraphics();
               }
            }
         }
         if (ok)
         {
            AToCopy();
            if (typeOfSort == ss.MERGE)
            {
               scratch = new int[A.length];
               for(int i = 0; i < scratch.length; i++)
                 scratch[i] = Integer.MAX_VALUE;
               arrayCanvas.setExtendedData(scratchPointers, scratchPointersPos, scratchStatusArray);
            }
            else
               scratch = null;
            arrayCanvas.setData(A, scratch, arrayPointers, arrayPointersPos, colorArray, arrayPane);
            clearTextFields();
            this.ok.setEnabled(false);
            contPause.setEnabled(true);
            contPause.setLabel("  Pause  ");
            clear.setEnabled(true);
            if (typeOfSort == ss.QUICK)
              stackArea.clear();
            shouldRun = true;
            arrayLine.requestFocus();
            start();
         }
      }
   }

   private void prepareNoGraphics()
   {
      if (threadStarted)
         stopAndClear();
      else
         clearTextFields();
      arrayLine.requestFocus();
      String gottenText = arrayLine.getText().trim();
      arrayLine.setText(gottenText);
      arrayLine.selectAll();
      if (gottenText.equals(""))
      {
         arrayLine.setText("");
         MessageBox mb = new MessageBox(ss, this, "Error",
                         "Cannot sort array: no array entered.", "exclaim.gif");
      }
      else
      {
         CharArray dataLine = new CharArray(gottenText);
         boolean ok = true;
         if ((isSpecial) && ((gottenText.indexOf("rand") == 0) || (gottenText.indexOf("sorted") == 0) ||
             (gottenText.indexOf("reverse") == 0)) && (!gottenText.equals(arrayString)))
         {
            ok = false;
            YesNoBox ynb = new YesNoBox(ss, this, "Question",
                           "Special-case array illegally altered.  Revert to original?",
                           "questionMark.gif");
            if (ynb.getAnswer() == YesNoBox.YES)
            {
               arrayLine.setText(arrayString);
               arrayLine.selectAll();
               randomCopyToA();
               ok = true;
            }
         }
         else if (((gottenText.indexOf("rand") == 0) || (gottenText.indexOf("sorted") == 0) ||
                   (gottenText.indexOf("reverse") == 0)) && (gottenText.equals(arrayString)))
            isSpecial = true;
         else
            isSpecial = false;
         if (ok)
         {
            if (isSpecial)
            {
               copyToA();
               noGraphics();
            }
            else
            {
               try
               {
                  A = dataLine.getBoundlessArray();
                  AToCopy();
                  noGraphics();
               }
               catch (ArrayException are)
               {
                  MessageBox mb = new MessageBox(ss, this, "Error", are.getMsg(), "exclaim.gif");
               }
            }
         }
      }
   }

   public void actionPerformed(ActionEvent ae)
   {   
      if (ae.getSource() == ok)
         processCommand();
      else if (ae.getSource() == help)
         if ((helpWindow == null) || (!helpWindow.isVisible()))
         {
            String docTitles[] =
              {"About the Algorithms",
               "How to Operate " + '"' + "Sorting Demo" + '"'};
            String fileNames[] = 
              {"Algorithms.dat",
               "Operation.dat"};
            helpWindow = new HelpWindow(ss, this, product, docTitles, fileNames);
         }
         else
         {
            helpWindow.toFront();
            helpWindow.requestFocus();
         }
      else if (ae.getSource() == about)
      {
         AboutBox aboutBox = new AboutBox(ss, this, product,
                                 "Written by Brian S. Borowski",
                                 "Seton Hall University",
                                 "Dept. of Math and Computer Science",
                                 "© 1999-2002, 2006, 2008 Brian S. Borowski",
                                 "All Rights Reserved.",
                                 "information.gif");
      }
      else if (ae.getSource() == legend)
      {
         if ((leg == null) || (!leg.isVisible()))
            leg = new Legend(this, colorArray, labelArray);
         else
         {
            leg.toFront();
            leg.requestFocus();
         }
      }
      else if (ae.getSource() == contPause)
      {
         if (contPause.getLabel().equals("Continue"))
         {
            contPause.setLabel("  Pause  ");
            shouldRun = true;
         }
         else
         {
            contPause.setLabel("Continue");
            shouldRun = false;
         }
      }
      else if (ae.getSource() == noGraphics)
      {
         prepareNoGraphics();
      }
      else if (ae.getSource() == clear)
      {
         stopAndClear();
      }
   }

   public void keyPressed(KeyEvent ke)
   {
      if (ke.getKeyText(ke.getKeyCode()).equals("Enter"))
        processCommand();
   }

   public void keyReleased(KeyEvent ke){}

   public void keyTyped(KeyEvent ke){}

   public static void main(String args[]){}

}
