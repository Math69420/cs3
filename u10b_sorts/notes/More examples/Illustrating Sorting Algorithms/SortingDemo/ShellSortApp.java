// ShellSortApp.java
import java.awt.*;

public class ShellSortApp extends SortApp
{
   public ShellSortApp(SortStarter ss, boolean runsFromApplet, String _arrayString,
                       CompareTable table, int[] array)
   {
      super(ss, runsFromApplet, SortStarter.SHELL, "Shellsort", table, array != null);
      arrayString = _arrayString;
      if (isSpecial)
      {
         A = array;
         AToCopy();
         copyToRandomCopy();
      }

      algCode = new String[15];
      algCode[0] =  "SHELLSORT (A)";
      algCode[1] =  " 1. k <- 1";
      algCode[2] =  " 2. repeat k <- k * 2 + 1";
      algCode[3] =  " 3. until k > n";
      algCode[4] =  " 4. repeat";
      algCode[5] =  " 5.    k <- k div 2";
      algCode[6] =  " 6.    for i <- k to n-1";
      algCode[7] =  " 7.       do j <- i - k";
      algCode[8] =  " 8.          found <- false";
      algCode[9] =  " 9.          while (j >= 0) and (not found)";
      algCode[10] = "10.             do if A[j] > A[j+k]";
      algCode[11] = "11.                   then exchange A[j] <-> A[j+k]";
      algCode[12] = "12.                        j <- j - k";
      algCode[13] = "13.                   else found <- true";
      algCode[14] = "14. until k = 1";

      program = new ProgramCanvas(algCode);

      Panel programPanel = new Panel();
      programPanel.setLayout(new GridBagLayout());
      gbc.insets = new Insets(0, 0, 0, 0);
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 0;
      gbc.weighty = 100;
      gbc.fill = GridBagConstraints.BOTH;
      programPanel.add(new Canvas(), gbc);
      gbc.weighty = 0;
      programPanel.add(program, gbc);
      gbc.weighty = 100;
      programPanel.add(new Canvas(), gbc);

      numOfVars = 5;
      labels = new Label[numOfVars];
      labels[0] = new Label("n: ", Label.RIGHT);
      labels[1] = new Label("k: ", Label.RIGHT);
      labels[2] = new Label("i: ", Label.RIGHT);
      labels[3] = new Label("j: ", Label.RIGHT);
      labels[4] = new Label("found: ", Label.RIGHT);
      variables = new TextField[numOfVars];
      variables[0] = new TextField(2);
      variables[1] = new TextField(2);
      variables[2] = new TextField(2);
      variables[3] = new TextField(2);
      variables[4] = new TextField(5);
      arrayPointers = new String[3];
      arrayPointers[0] = "";
      arrayPointers[1] = "j";
      arrayPointers[2] = "j+k";
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
      varPanel1.add(labels[2]);
      varPanel1.add(variables[2]);
      varPanel1.add(labels[3]);
      varPanel1.add(variables[3]);

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
      int n = A.length, j = 0, k = 1;
      if (runner == thisThread)
      {
         variables[0].setText(Integer.toString(n));
         compCt = exchangeCt = 0;
         compField.setText("0");
         exchangeField.setText("0");
         program.selectLine(1);
         variables[1].setText(Integer.toString(k));
         pause();
      }
      do
      {
         if (runner == thisThread)
         {
            program.selectLine(2);
            k = k * 2 + 1;
            variables[1].setText(Integer.toString(k));
            pause();
         }
         if (runner == thisThread)
         {
            program.selectLine(3);
            pause();
         }
      }
      while ((runner == thisThread) && (k <= n));
      do
      {
         if (runner == thisThread)
         {
            program.selectLine(4);
            pause();
         }
         if (runner == thisThread)
         {
            program.selectLine(5);
            k /= 2;
            variables[1].setText(Integer.toString(k));
            if (k == 1)
            {
               arrayCanvas.setStatus(0, PARTSORTED);
               arrayCanvas.repaint();
            }
            pause();
         }
         for(int i = k; i < n; i++)
         {
            if (runner != thisThread)
               break;
            if (runner == thisThread)
            {
               variables[2].setText(Integer.toString(i));
               program.selectLine(6);
               pause();
            }
            if (runner == thisThread)
            {
               program.selectLine(7);
               j = i - k;
               variables[3].setText(Integer.toString(j));
               arrayPointersPos[1] = j;
               arrayPointersPos[2] = j + k;
               arrayCanvas.repaint();
               pause();
            }
            boolean found = false;
            if (runner == thisThread)
            {
               program.selectLine(8);
               variables[4].setText("false");
               pause();
            }
            int max = j + k;
            while ((runner == thisThread) && (j >= 0) && (!found))
            {
               if (runner == thisThread)
               {
                  program.selectLine(9);
                  pause();
               }
               if (runner == thisThread)
               {
                  compCt++;
                  compField.setText(Integer.toString(compCt));
                  program.selectLine(10);
                  pause();
               }
               if (A[j] > A[j+k])
               {
                  if (runner == thisThread)
                  {
                     program.selectLine(11);
                     exchangeCt++;
                     exchangeField.setText(Integer.toString(exchangeCt));
                     arrayCanvas.setStatus(j, SWAPPING);
                     arrayCanvas.setStatus(j+k, SWAPPING);
                     arrayCanvas.repaint();
                     pause();
                  }
                  if (runner == thisThread)
                  {
                     int temp = A[j];
                     A[j] = A[j+k];
                     A[j+k] = temp;
                     arrayCanvas.repaint();
                     pause();
                  }
                  if (runner == thisThread)
                  {
                     program.selectLine(12);
                     if (k != 1)
                     {
                        arrayCanvas.setStatus(j, STRIDESORTED);
                        arrayCanvas.setStatus(j+k, STRIDESORTED);
                     }
                     else
                     {
                        arrayCanvas.setStatus(j, UNSORTED);
                        arrayCanvas.setStatus(j+k, UNSORTED);
                     }
                     j -= k;
                     variables[3].setText(Integer.toString(j));
                     if (j < 0)
                       arrayPointersPos[1] = -2;
                     else
                       arrayPointersPos[1] = j;
                     arrayPointersPos[2] = j + k;
                  }
               }
               else
               {
                  if (runner == thisThread)
                  {
                     program.selectLine(13);
                     found = true;
                     variables[4].setText("true");
                     if (k != 1)
                     {
                        int x = j;
                        while (x >= 0)
                        {
                           arrayCanvas.setStatus(x, STRIDESORTED);
                           arrayCanvas.setStatus(x+k, STRIDESORTED);
                           x -= k;
                        }
                        x = j;
                        while (x+k <= max)
                        {
                           if (A[x+k] > A[x])
                             arrayCanvas.setStatus(x+k, STRIDESORTED);
                           x += k;
                        }
                     }
                  }
               }
               if (runner == thisThread)
               {
                  arrayCanvas.repaint();
                  pause();
               }
               if (runner == thisThread)
               {
                  if (k != 1)
                    for(int x = 0; x < n; x++)
                      arrayCanvas.setStatus(x, UNSORTED);
               }
            }
            if (runner == thisThread)
            {
               if (k == 1)
               {
                  for(int x = 0; x <= i; x++)
                    arrayCanvas.setStatus(x, PARTSORTED);
                  arrayCanvas.repaint();
               }
               program.selectLine(9);
               pause();
            }
         }
         if (runner == thisThread)
         {
            program.selectLine(14);
            variables[2].setText("");
            variables[3].setText("");
            arrayPointersPos[1] = -2;
            arrayPointersPos[2] = -2;
            arrayCanvas.repaint();
            pause();
         }
      }
      while ((runner == thisThread) && (k > 1));
      if (runner == thisThread)
      {
         program.selectLine(-1);
         for(int i = 0; i < n; i++)
           arrayCanvas.setStatus(i, DONE);
         arrayCanvas.repaint();
         ok.setEnabled(true);
         contPause.setEnabled(false);
         clear.setEnabled(false);
         arrayLine.requestFocus();
         if (runsFromApplet)
         {
            if (isSpecial)
              ss.sortInfo[ss.SHELL].setData(arrayString, compCt, exchangeCt);
            else
              ss.sortInfo[ss.SHELL].setData(copy, compCt, exchangeCt);
            if (table != null)
              table.update(ss.SHELL, ss.sortInfo);
         }
         MessageBox mb = new MessageBox(ss, this, "Information",
                                        "Shellsort complete.", "information.gif");
      }
      stop();
   }

   public void noGraphics()
   {
      int n = A.length;
      compCt = exchangeCt = 0;
      int k = 1;
      do
      {
         k = k * 2 + 1;
      }
      while (k <= n);
      do
      {
         k /= 2;
         for(int i = k; i < n; i++)
         {
            int j = i - k;
            boolean found = false;
            while ((j >= 0) && (!found))
            {
               compCt++;
               if (A[j] > A[j+k])
               {
                  exchangeCt++;
                  int temp = A[j];
                  A[j] = A[j+k];
                  A[j+k] = temp;
                  j -= k;
               }
               else
                  found = true;
            }
         }
      }
      while (k > 1);
      if (runsFromApplet)
      {
         if (isSpecial)
           ss.sortInfo[ss.SHELL].setData(arrayString, compCt, exchangeCt);
         else
           ss.sortInfo[ss.SHELL].setData(copy, compCt, exchangeCt);
         if (table != null)
           table.update(ss.SHELL, ss.sortInfo);
      }
      compField.setText(Integer.toString(compCt));
      exchangeField.setText(Integer.toString(exchangeCt));
      MessageBox mb = new MessageBox(ss, this, "Information",
                                     "Shellsort complete.", "information.gif");
   }

   public static void main(String[] args)
   {
      ShellSortApp ssa = new ShellSortApp(null, false, null, null, null);
   }

}
