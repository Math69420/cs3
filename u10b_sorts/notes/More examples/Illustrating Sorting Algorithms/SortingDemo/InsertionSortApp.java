// InsertionSortApp.java
import java.awt.*;

public class InsertionSortApp extends SortApp
{
   public InsertionSortApp(SortStarter ss, boolean runsFromApplet, String _arrayString,
                           CompareTable table, int[] array)
   {
      super(ss, runsFromApplet, SortStarter.INSERT, "Insertion Sort", table, array != null);
      arrayString = _arrayString;
      if (isSpecial)
      {
         A = array;
         AToCopy();
         copyToRandomCopy();
      }

      algCode = new String[10];
      algCode[0] =  "INSERTION_SORT (A)";
      algCode[1] =  "1. for k <- 1 to n-1";
      algCode[2] =  "2.    do x <- A[k]";
      algCode[3] =  "3.       i <- k - 1";
      algCode[4] =  "4.       found <- false";
      algCode[5] =  "5.       while (not found) and (i >= 0)";
      algCode[6] =  "6.          do if A[i] > x";
      algCode[7] =  "7.                then exchange A[i+1] <-> A[i]";
      algCode[8] =  "8.                     i <- i - 1";
      algCode[9] =  "9.                else found <- true";

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

      numOfVars = 5;
      labels = new Label[numOfVars];
      labels[0] = new Label("n: ", Label.RIGHT);
      labels[1] = new Label("k: ", Label.RIGHT);
      labels[2] = new Label("i: ", Label.RIGHT);
      labels[3] = new Label("x: ", Label.RIGHT);
      labels[4] = new Label("found: ", Label.RIGHT);
      variables = new TextField[numOfVars];
      variables[0] = new TextField(2);
      variables[1] = new TextField(2);
      variables[2] = new TextField(2);
      variables[3] = new TextField(5);
      variables[4] = new TextField(5);
      arrayPointers = new String[3];
      arrayPointers[0] = "";
      arrayPointers[1] = "k";
      arrayPointers[2] = "i";
      arrayPointersPos = new int[3];

      for(int i = 0; i < numOfVars; i++)
      {
         variables[i].setEditable(false);
         variables[i].setBackground(Color.white);
      }
    
      Panel varPanel0 = new Panel();
      varPanel0.setLayout(new GridLayout(2, 2));
      varPanel0.add(labels[0]);
      varPanel0.add(variables[0]);
      varPanel0.add(labels[1]);
      varPanel0.add(variables[1]);

      Panel varPanel1 = new Panel();
      varPanel1.setLayout(new GridLayout(2, 2));
      varPanel1.add(labels[3]);
      varPanel1.add(variables[3]);
      varPanel1.add(labels[2]);
      varPanel1.add(variables[2]);

      Panel varPanel2 = new Panel();
      varPanel2.setLayout(new GridLayout(1, 2));
      varPanel2.add(labels[4]);
      varPanel2.add(variables[4]);

      Panel variablesPanel = new Panel();
      variablesPanel.setLayout(new FlowLayout());
      variablesPanel.add(varPanel0);
      variablesPanel.add(varPanel1);
      variablesPanel.add(varPanel2);

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
      int n = A.length, x = 0, i = 0;
      boolean found = false;
      if (runner == thisThread)
      {
         variables[0].setText(Integer.toString(n));
         compCt = exchangeCt = 0;
         compField.setText("0");
         exchangeField.setText("0");
         arrayCanvas.setStatus(0, PARTSORTED);
         arrayCanvas.repaint();
      }
      for(int k = 1; k < n; k++)
      {
         if (runner != thisThread)
            break;
         if (runner == thisThread)
         {
            variables[1].setText(Integer.toString(k));
            program.selectLine(1);
            arrayPointersPos[1] = k;
            arrayCanvas.repaint();
            pause();
         }
         if (runner == thisThread)
         {
            program.selectLine(2);
            x = A[k];
            variables[3].setText(Integer.toString(x));
            pause();
         }
         if (runner == thisThread)
         {
            program.selectLine(3);
            i = k - 1;
            variables[2].setText(Integer.toString(i));
            arrayPointersPos[2] = i;
            arrayCanvas.repaint();
            pause();
         }
         if (runner == thisThread)
         {
            program.selectLine(4);
            found = false;
            variables[4].setText("false");
            pause();
         }
         while ((!found) && (i >= 0) && (runner == thisThread))
         {
            if (runner == thisThread)
            {
               program.selectLine(5);
               pause();
            }
            if (runner == thisThread)
            {
               program.selectLine(6);
               compCt++;
               compField.setText(Integer.toString(compCt));
               pause();
            }
            if (A[i] > x)
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
                  i--;
                  variables[2].setText(Integer.toString(i));
                  arrayPointersPos[2] = i;
                  arrayCanvas.repaint();
                  pause();
               }
            }
            else
            {
               if (runner == thisThread)
               {
                  program.selectLine(9);
                  found = true;
                  variables[4].setText("true");
                  pause();
               }
            }
         }
         if (runner == thisThread)
         {
            program.selectLine(5);
            pause();
         }
         if (runner == thisThread)
         {
            for(int j = 0; j <= k; j++)
              arrayCanvas.setStatus(j, PARTSORTED);
            arrayCanvas.repaint();
            pause();
         }
      }
      if (runner == thisThread)
      {
         for(int j = 0; j < n; j++)
           arrayCanvas.setStatus(j, DONE);
         arrayCanvas.repaint();
         program.selectLine(-1);
         ok.setEnabled(true);
         contPause.setEnabled(false);
         clear.setEnabled(false);
         arrayLine.requestFocus();
         if (runsFromApplet)
         {
            if (isSpecial)
              ss.sortInfo[ss.INSERT].setData(arrayString, compCt, exchangeCt);
            else
              ss.sortInfo[ss.INSERT].setData(copy, compCt, exchangeCt);
            if (table != null)
              table.update(ss.INSERT, ss.sortInfo);
         }
         MessageBox mb = new MessageBox(ss, this, "Information",
                                        "Insertion Sort complete.", "information.gif");
      }
      stop();
   }

   public void noGraphics()
   {
      int n = A.length;
      compCt = exchangeCt = 0;
      for(int k = 1; k < n; k++)
      {
         int x = A[k];
         int i = k - 1;
         boolean found = false;
         while ((!found) && (i >= 0))
         {
            compCt++;
            if (A[i] > x)
            {
               exchangeCt++;
               int temp = A[i];
               A[i] = A[i+1];
               A[i+1] = temp;
               i--;
            }
            else
               found = true;
         }
      }
      if (runsFromApplet)
      {
         if (isSpecial)
           ss.sortInfo[ss.INSERT].setData(arrayString, compCt, exchangeCt);
         else
           ss.sortInfo[ss.INSERT].setData(copy, compCt, exchangeCt);
         if (table != null)
           table.update(ss.INSERT, ss.sortInfo);
      }
      compField.setText(Integer.toString(compCt));
      exchangeField.setText(Integer.toString(exchangeCt));
      MessageBox mb = new MessageBox(ss, this, "Information",
                                     "Insertion Sort complete.", "information.gif");
   }

   public static void main(String[] args)
   {
      InsertionSortApp isa = new InsertionSortApp(null, false, null, null, null);
   }

}
