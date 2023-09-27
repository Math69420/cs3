// OETransSortApp.java
import java.awt.*;

public class OETransSortApp extends SortApp
{
   public OETransSortApp(SortStarter ss, boolean runsFromApplet, String _arrayString,
                         CompareTable table, int[] array)
   {
      super(ss, runsFromApplet, SortStarter.OETRANS, "Odd-Even Transposition Sort", table, array != null);
      arrayString = _arrayString;
      if (isSpecial)
      {
         A = array;
         AToCopy();
         copyToRandomCopy();
      }

      algCode = new String[16];
      algCode[0]  = "ODD_EVEN_TRANS_SORT (A)";
      algCode[1]  = " 1. sorted <- false";
      algCode[2]  = " 2. while not sorted";
      algCode[3]  = " 3.   do j <- 0";
      algCode[4]  = " 4.      sorted <- true";
      algCode[5]  = " 5.      while j+1 < n";
      algCode[6]  = " 6.         do if A[j] > A[j+1]";
      algCode[7]  = " 7.               then exchange A[j] <-> A[j+1]";
      algCode[8]  = " 8.                    sorted <- false";
      algCode[9] =  " 9.            j <- j + 2";
      algCode[10] = "10.      j <- 1";
      algCode[11] = "11.      while j+1 < n";
      algCode[12] = "12.         do if A[j] > A[j+1]";
      algCode[13] = "13.               then exchange A[j] <-> A[j+1]";
      algCode[14] = "14.                    sorted <- false";
      algCode[15] = "15.            j <- j + 2";

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

      numOfVars = 3;
      labels = new Label[numOfVars];
      labels[0] = new Label("n: ", Label.RIGHT);
      labels[1] = new Label("j: ", Label.RIGHT);
      labels[2] = new Label("sorted: ", Label.RIGHT);
      variables = new TextField[numOfVars];
      variables[0] = new TextField(2);
      variables[1] = new TextField(2);
      variables[2] = new TextField(5);
      arrayPointers = new String[3];
      arrayPointers[0] = "";
      arrayPointers[1] = "j";
      arrayPointers[2] = "j+1";
      arrayPointersPos = new int[3];

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
      int n = A.length, j = 0;
      boolean sorted = false;
      if (runner == thisThread)
      {
         variables[0].setText(Integer.toString(n));
         compCt = exchangeCt = 0;
         compField.setText("0");
         exchangeField.setText("0");
         program.selectLine(1);
         variables[2].setText("false");
         pause();
      }
      while ((!sorted) && (runner == thisThread))
      {
         if (runner == thisThread)
         {
            program.selectLine(2);
            pause();
         }
         if (runner == thisThread)
         {
            program.selectLine(3);
            j = 0;
            variables[1].setText(Integer.toString(j));
            arrayPointersPos[1] = j;
            arrayPointersPos[2] = j+1;
            arrayCanvas.repaint();
            pause();
         }
         if (runner == thisThread)
         {
            program.selectLine(4);
            sorted = true;
            variables[2].setText("true");
            pause();
         }
         while ((runner == thisThread) && (j+1 < n))
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
            if ((runner == thisThread) && (A[j] > A[j+1]))
            {
               if (runner == thisThread)
               {
                  program.selectLine(7);
                  exchangeCt++;
                  exchangeField.setText(Integer.toString(exchangeCt));
                  arrayCanvas.setStatus(j, SWAPPING);
                  arrayCanvas.setStatus(j+1, SWAPPING);
                  arrayCanvas.repaint();
                  pause();
               }
               if (runner == thisThread)
               {
                  int temp = A[j];
                  A[j] = A[j+1];
                  A[j+1] = temp;
                  arrayCanvas.repaint();
                  pause();
               }
               if (runner == thisThread)
               {
                  program.selectLine(8);
                  arrayCanvas.setStatus(j, UNSORTED);
                  arrayCanvas.setStatus(j+1, UNSORTED);
                  arrayCanvas.repaint();
                  sorted = false;
                  variables[2].setText("false");
                  pause();
               }
            }
            if (runner == thisThread)
            {
               program.selectLine(9);
               j += 2;
               variables[1].setText(Integer.toString(j));
               arrayPointersPos[1] = j;
               arrayPointersPos[2] = j+1;
               arrayCanvas.repaint();
               pause();
            }
         }
         if (runner == thisThread)
         {
            program.selectLine(5);
            pause();
         }
         if (runner == thisThread)
         {
            program.selectLine(10);
            j = 1;
            variables[1].setText(Integer.toString(j));
            arrayPointersPos[1] = j;
            arrayPointersPos[2] = j+1;
            arrayCanvas.repaint();
            pause();
         }
         while ((runner == thisThread) && (j+1 < n))
         {
            if (runner == thisThread)
            {
               program.selectLine(11);
               pause();
            }
            if (runner == thisThread)
            {
               program.selectLine(12);
               compCt++;
               compField.setText(Integer.toString(compCt));
               pause();
            }
            if ((runner == thisThread) && (A[j] > A[j+1]))
            {
               if (runner == thisThread)
               {
                  program.selectLine(13);
                  exchangeCt++;
                  exchangeField.setText(Integer.toString(exchangeCt));
                  arrayCanvas.setStatus(j, SWAPPING);
                  arrayCanvas.setStatus(j+1, SWAPPING);
                  arrayCanvas.repaint();
                  pause();
               }
               if (runner == thisThread)
               {
                  int temp = A[j];
                  A[j] = A[j+1];
                  A[j+1] = temp;
                  arrayCanvas.repaint();
                  pause();
               }
               if (runner == thisThread)
               {
                  program.selectLine(14);
                  arrayCanvas.setStatus(j, UNSORTED);
                  arrayCanvas.setStatus(j+1, UNSORTED);
                  arrayCanvas.repaint();
                  sorted = false;
                  variables[2].setText("false");
                  pause();
               }
            }
            if (runner == thisThread)
            {
               program.selectLine(15);
               j += 2;
               variables[1].setText(Integer.toString(j));
               arrayPointersPos[1] = j;
               arrayPointersPos[2] = j+1;
               arrayCanvas.repaint();
               pause();
            }
         }
         if (runner == thisThread)
         {
            program.selectLine(12);
            pause();
         }
      }
      if (runner == thisThread)
      {
         program.selectLine(2);
         pause();
      }
      if (runner == thisThread)
      {
         for(int x = 0; x < A.length; x++)
           arrayCanvas.setStatus(x, DONE);
         arrayCanvas.repaint();
         program.selectLine(-1);
         ok.setEnabled(true);
         contPause.setEnabled(false);
         clear.setEnabled(false);
         arrayLine.requestFocus();
         if (runsFromApplet)
         {
            if (isSpecial)
              ss.sortInfo[ss.OETRANS].setData(arrayString, compCt, exchangeCt);
            else
              ss.sortInfo[ss.OETRANS].setData(copy, compCt, exchangeCt);
            if (table != null)
              table.update(ss.OETRANS, ss.sortInfo);
         }
         MessageBox mb = new MessageBox(ss, this, "Information",
                                        "Odd-Even Transposition Sort complete.", "information.gif");
      }
      stop();
   }

   public void noGraphics()
   {
      int n = A.length;
      compCt = exchangeCt = 0;
      boolean sorted = false;
      while (!sorted)
      {
         int j = 0;
         sorted = true;
         while (j+1 < n)
         {
            compCt++;
            if (A[j] > A[j+1])
            {
               exchangeCt++;
               int temp = A[j];
               A[j] = A[j+1];
               A[j+1] = temp;
               sorted = false;
            }
            j += 2;
         }
         j = 1;
         while (j+1 < n)
         {
            compCt++;
            if (A[j] > A[j+1])
            {
               exchangeCt++;
               int temp = A[j];
               A[j] = A[j+1];
               A[j+1] = temp;
               sorted = false;
            }
            j += 2;
         }
      }
      if (runsFromApplet)
      {
         if (isSpecial)
           ss.sortInfo[ss.OETRANS].setData(arrayString, compCt, exchangeCt);
         else
           ss.sortInfo[ss.OETRANS].setData(copy, compCt, exchangeCt);
         if (table != null)
           table.update(ss.OETRANS, ss.sortInfo);
      }
      compField.setText(Integer.toString(compCt));
      exchangeField.setText(Integer.toString(exchangeCt));
      MessageBox mb = new MessageBox(ss, this, "Information",
                                     "Odd-Even Transposition Sort complete.", "information.gif");
   }

   public static void main(String[] args)
   {
      OETransSortApp oetsa = new OETransSortApp(null, false, null, null, null);
   }

}
