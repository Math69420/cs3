// BubbleSortApp.java
import java.awt.*;

public class BubbleSortApp extends SortApp
{
   public BubbleSortApp(SortStarter ss, boolean runsFromApplet, String _arrayString,
                        CompareTable table, int[] array)
   {    
      super(ss, runsFromApplet, SortStarter.BUBBLE, "Bubble Sort", table, array != null);
      arrayString = _arrayString;
      if (isSpecial)
      {
         A = array;
         AToCopy();
         copyToRandomCopy();
      }

      algCode = new String[10];
      algCode[0] = "BUBBLE_SORT (A)";
      algCode[1] = "1. pass <- 1";
      algCode[2] = "2. sorted <- false";
      algCode[3] = "3. while (not sorted) and (pass < n)";
      algCode[4] = "4.    do sorted <- true";
      algCode[5] = "5.       for i <- 0 to n-pass-1";
      algCode[6] = "6.          do if A[i] > A[i+1]";
      algCode[7] = "7.                then exchange A[i] <-> A[i+1]";
      algCode[8] = "8.                     sorted <- false";
      algCode[9] = "9.       pass <- pass + 1";

      program = new ProgramCanvas(algCode);

      Panel programPanel = new Panel();
      programPanel.setLayout(new GridBagLayout());
      gbc.insets = new Insets(0, 0, 0, 0);
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 0;
      gbc.weighty = 100;
      gbc.fill = GridBagConstraints.BOTH;
      programPanel.add(new Label(""), gbc);
      gbc.weighty = 0;
      programPanel.add(program, gbc);
      gbc.weighty = 100;
      programPanel.add(new Label(""), gbc);

      numOfVars = 4;
      labels = new Label[numOfVars];
      labels[0] = new Label("n: ", Label.RIGHT);
      labels[1] = new Label("pass: ", Label.RIGHT);
      labels[2] = new Label("i: ", Label.RIGHT);
      labels[3] = new Label("sorted: ", Label.RIGHT);
      variables = new TextField[numOfVars];
      variables[0] = new TextField(2);
      variables[1] = new TextField(2);
      variables[2] = new TextField(2);
      variables[3] = new TextField(5);
      arrayPointers = new String[2];
      arrayPointers[0] = "";
      arrayPointers[1] = "i";
      arrayPointersPos = new int[2];

      Panel variablesPanel = new Panel();
      variablesPanel.setLayout(new FlowLayout());
      for(int i = 0; i < numOfVars; i++)
      {
         variables[i].setEditable(false);
         variables[i].setBackground(Color.white);
         variablesPanel.add(labels[i]);
         variablesPanel.add(variables[i]);
      }

      Panel arrayVarPanel = new Panel();
      arrayVarPanel.setLayout(new GridBagLayout());
      gbc.insets = new Insets(0, 5, 0, 5);
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 100;
      gbc.weighty = 100;
      gbc.fill = GridBagConstraints.BOTH;
      arrayVarPanel.add(arrayPane, gbc);
      gbc.insets = new Insets(0, 0, 0, 0);
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 0;
      gbc.weighty = 0;
      gbc.fill = GridBagConstraints.NONE;
      arrayVarPanel.add(variablesPanel, gbc);

      setLayout(new GridBagLayout());

      gbc.insets = new Insets(0, 0, 0, 0);
      gbc.anchor = GridBagConstraints.NORTH;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 100;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      add(topPanel, gbc);

      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridwidth = 1;
      gbc.weightx = 0;
      gbc.fill = GridBagConstraints.BOTH;
      add(new Box(inputPanel, "Array Data", Box.LEFT), gbc);

      gbc.anchor = GridBagConstraints.EAST;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 100;
      gbc.fill = GridBagConstraints.BOTH;
      add(new Box(speedPanel, "Speed Controls", Box.LEFT), gbc);

      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = 1;
      gbc.weightx = 0;
      gbc.weighty = 100;
      gbc.fill = GridBagConstraints.BOTH;
      add(new Box(programPanel, algorithmName + " Algorithm", Box.LEFT), gbc);

      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 100;
      gbc.weighty = 100;
      gbc.fill = GridBagConstraints.BOTH;
      add(new Box(arrayVarPanel, "Array and Pointers", Box.LEFT), gbc);

      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridwidth = 1;
      gbc.weightx = 0;
      gbc.weighty = 0;
      gbc.fill = GridBagConstraints.BOTH;
      add(new Box(statsPanel, "Algorithm Statistics", Box.LEFT), gbc);

      gbc.anchor = GridBagConstraints.EAST;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 100;
      gbc.fill = GridBagConstraints.BOTH;
      add(new Box(buttonPanel, "User Options", Box.LEFT), gbc);

      validate();
      pack();
      Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
      Point p = new Point((int)((d.getWidth() - this.getWidth())/2),
                          (int)((d.getHeight() - this.getHeight())/2));
      setLocation(p);
      setVisible(true);
      if (arrayString != null)
        arrayLine.setText(arrayString);
   }

   public void run()
   {
      thisThread = Thread.currentThread();
      int n = A.length, pass = 1;
      boolean sorted = false;
      if (runner == thisThread)
      {        
         variables[0].setText(Integer.toString(n));
         compCt = exchangeCt = 0;
         compField.setText("0");
         exchangeField.setText("0");
         program.selectLine(1);
         variables[1].setText(Integer.toString(pass));
         pause();
      }
      if (runner == thisThread)
      {
         program.selectLine(2);
         variables[3].setText("false");
         pause();
      }
      while ((!sorted) && (pass < n) && (runner == thisThread))
      {
         if (runner == thisThread)
         {
            program.selectLine(3);
            pause();
         }
         if (runner == thisThread)
         {
            program.selectLine(4);
            sorted = true;
            variables[3].setText("true");
            pause();
         }
         for(int i = 0; i < n - pass; i++)
         {
            if (runner != thisThread)
               break;
            if (runner == thisThread)
            {
               variables[2].setText(Integer.toString(i));
               program.selectLine(5);
               arrayPointersPos[1] = i;
               arrayCanvas.repaint();
               pause();
            }
            if (runner == thisThread)
            {
               program.selectLine(6);
               compCt++;
               compField.setText(Integer.toString(compCt));
               pause();
            }
            if (A[i] > A[i+1])
            {
               if (runner == thisThread)
               {
                  program.selectLine(7);
                  exchangeCt++;
                  exchangeField.setText(Integer.toString(exchangeCt));
                  arrayCanvas.setStatus(i, SWAPPING);
                  arrayCanvas.setStatus(i+1, SWAPPING);
                  arrayCanvas.repaint();
                  pause();
               }
               if (runner == thisThread)
               {
                  int temp = A[i];
                  A[i] = A[i+1];
                  A[i+1] = temp;
                  arrayCanvas.repaint();
                  pause();
               }
               if (runner == thisThread)
               {
                  arrayCanvas.setStatus(i, UNSORTED);
                  arrayCanvas.setStatus(i+1, UNSORTED);
                  arrayCanvas.repaint();
                  program.selectLine(8);
                  sorted = false;
                  variables[3].setText("false");
                  pause();
               }
            }
         }
         if (runner == thisThread)
         {
            variables[2].setText("");
            arrayPointersPos[1] = -2;
            arrayCanvas.setStatus(n-pass, DONE);
            arrayCanvas.repaint();
            program.selectLine(9);
            pass++;
            variables[1].setText(Integer.toString(pass));
            pause();
         }
      }
      if (runner == thisThread)
      {
         program.selectLine(3);
         pause();
      }
      if (runner == thisThread)
      {
         int i = 0;
         while ((i < n) && (arrayCanvas.getStatus(i) != DONE))
         {
            arrayCanvas.setStatus(i, DONE);
            i++;
         }
         arrayCanvas.repaint();
         program.selectLine(-1);
         ok.setEnabled(true);
         contPause.setEnabled(false);
         clear.setEnabled(false);
         arrayLine.requestFocus();
         if (runsFromApplet)
         {
            if (isSpecial)
              ss.sortInfo[ss.BUBBLE].setData(arrayString, compCt, exchangeCt);
            else
              ss.sortInfo[ss.BUBBLE].setData(copy, compCt, exchangeCt);
            if (table != null)
              table.update(ss.BUBBLE, ss.sortInfo);
         }
         MessageBox mb = new MessageBox(ss, this, "Information",
                                        "Bubble Sort complete.", "information.gif");
      }
      stop();
   }

   public void noGraphics()
   {
      int n = A.length;
      compCt = exchangeCt = 0;
      int pass = 1;
      boolean sorted = false;
      while ((!sorted) && (pass < n))
      {
         sorted = true;
         for(int i = 0; i < n - pass; i++)
         {
            compCt++;
            if (A[i] > A[i+1])
            {
               exchangeCt++;
               int temp = A[i];
               A[i] = A[i+1];
               A[i+1] = temp;
               sorted = false;
            }
         }
         pass++;
      }
      if (runsFromApplet)
      {
         if (isSpecial)
           ss.sortInfo[ss.BUBBLE].setData(arrayString, compCt, exchangeCt);
         else
           ss.sortInfo[ss.BUBBLE].setData(copy, compCt, exchangeCt);
         if (table != null)
           table.update(ss.BUBBLE, ss.sortInfo);
      }
      compField.setText(Integer.toString(compCt));
      exchangeField.setText(Integer.toString(exchangeCt));
      MessageBox mb = new MessageBox(ss, this, "Information",
                                     "Bubble Sort complete.", "information.gif");
   }

   public static void main(String[] args)
   {
      BubbleSortApp bsa = new BubbleSortApp(null, false, null, null, null);
   }

}
