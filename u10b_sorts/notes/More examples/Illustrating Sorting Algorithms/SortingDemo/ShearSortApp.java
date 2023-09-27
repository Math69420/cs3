// ShearSortApp.java
import java.awt.*;

public class ShearSortApp extends SortApp
{
   private static final int logIndex = 0, iIndex = 1, loIndex = 2, powIndex = 3,
                            jIndex = 4, hiIndex = 5, rowsIndex = 6, kIndex = 7,
                            upIndex = 8, colsIndex = 9, nIndex = 10, offsetIndex = 11;
   private int line1;

   public ShearSortApp(SortStarter ss, boolean runsFromApplet, String _arrayString,
                       CompareTable table, int[] array)
   {
      super(ss, runsFromApplet, SortStarter.HEAP, "Shearsort", table, array != null);
      arrayString = _arrayString;
      if (isSpecial)
      {
         A = array;
         AToCopy();
         copyToRandomCopy();
      }

      algCode = new String[31];
      algCode[0]  = "SHEARSORT (A)";
      algCode[1]  = " 1. log <- 0, pow <- 1, rows <- 1";
      algCode[2]  = " 2. for i <- 1 to sqrt(length[A])";
      algCode[3]  = " 3.    do if length[A] % i = 0";
      algCode[4]  = " 4.          then rows <- i";
      algCode[5]  = " 5. cols <- length[A] / rows";
      algCode[6]  = " 6. while (pow <= rows)";
      algCode[7]  = " 7.    do pow <- pow * 2; log <- log + 1";
      algCode[8]  = " 8. for k <- 0 to log-1 do";
      algCode[9] = " 9.    for j <- 0 to col/2-1 do";
      algCode[10] = "10.       for i <- 0 to rows-1 do";
      algCode[11] = "11.          SORT(i*cols, (i+1)*cols, 0, 1, i%2==0)";
      algCode[12] = "12.       for i <- 0 to rows-1 do";
      algCode[13] = "13.          SORT(i*cols, (i+1)*cols, 1, 1, i%2==0)";
      algCode[14] = "14.    for j <- 0 to rows/2-1 do";
      algCode[15] = "15.       for i <- 0 to cols-1 do";
      algCode[16] = "16.          SORT(i, rows*cols+i, 0, cols, true)";
      algCode[17] = "17.       for i <- 0 to cols-1 do";
      algCode[18] = "18.          SORT(i, rows*cols+i, cols, cols, true)";
      algCode[19] = "19. for j <- 0 to cols/2 do";
      algCode[20] = "20.    for i <- 0 to rows-1 do";
      algCode[21] = "21.       SORT(i*cols, (i+1)*cols, 0, 1, true)";
      algCode[22] = "22.    for i <- 0 to rows-1 do";
      algCode[23] = "23.       SORT(i*cols, (i+1)*cols, 1, 1, true)";
      algCode[24] = "\n";
      algCode[25] = "SORT (lo, hi, offset, n, up)";
      algCode[26] = "1. j <- lo + offset";
      algCode[27] = "2. while (j+n < hi) do";
      algCode[28] = "3.    if up && A[j] > A[j+n] or !up && A[j] < A[j+n]";
      algCode[29] = "4.      then exchange A[j] <-> A[j+n]";
      algCode[30] = "5.    j <- j + 2 * n";

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

      numOfVars = 12;
      labels = new Label[numOfVars];
      labels[0] = new Label("log: ", Label.RIGHT);
      labels[1] = new Label("i: ", Label.RIGHT);
      labels[2] = new Label("lo: ", Label.RIGHT);
      labels[3] = new Label("pow:  ", Label.RIGHT);
      labels[4] = new Label("j:  ", Label.RIGHT);
      labels[5] = new Label("hi:  ", Label.RIGHT);
      labels[6] = new Label("rows:  ", Label.RIGHT);
      labels[7] = new Label("k:  ", Label.RIGHT);
      labels[8] = new Label("up:  ", Label.RIGHT);
      labels[9] = new Label("cols:  ", Label.RIGHT);
      labels[10] = new Label("n:  ", Label.RIGHT);
      labels[11] = new Label("offset:  ", Label.RIGHT);
      variables = new TextField[numOfVars];
      for(int i = 0; i < numOfVars; i++)
      {
         variables[i] = new TextField(2);
         variables[i].setEditable(false);
         variables[i].setBackground(Color.white);
      }        
      arrayPointers = new String[3];
      arrayPointers[0] = "";
      arrayPointers[1] = "j";
      arrayPointers[2] = "j+n";
      arrayPointersPos = new int[3];

      Panel varPanel1 = new Panel();
      varPanel1.setLayout(new GridLayout(3, 2));
      for(int i = 0; i < 3; i++)
      {
         varPanel1.add(labels[i]);
         varPanel1.add(variables[i]);
      }

      Panel varPanel2 = new Panel();
      varPanel2.setLayout(new GridLayout(3, 2));
      for(int i = 3; i < 6; i++)
      {
         varPanel2.add(labels[i]);
         varPanel2.add(variables[i]);
      }

      Panel varPanel3 = new Panel();
      varPanel3.setLayout(new GridLayout(3, 2));
      for(int i = 6; i < 9; i++)
      {
         varPanel3.add(labels[i]);
         varPanel3.add(variables[i]);
      }

      Panel varPanel4 = new Panel();
      varPanel4.setLayout(new GridLayout(3, 2));
      for(int i = 9; i < 12; i++)
      {
         varPanel4.add(labels[i]);
         varPanel4.add(variables[i]);
      }

      Panel variablesPanel = new Panel();
      variablesPanel.setLayout(new FlowLayout());
      variablesPanel.add(varPanel1);
      variablesPanel.add(varPanel2);
      variablesPanel.add(varPanel3);
      variablesPanel.add(varPanel4);

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

      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = 1;
      gbc.weightx = 0;
      gbc.weighty = 100;
      gbc.fill = GridBagConstraints.BOTH;
      add(new Box(programPanel, algorithmName + " Algorithm", Box.LEFT), gbc);

      Panel rightPanel = new Panel();
      rightPanel.setLayout(new GridBagLayout());
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 100;
      gbc.weighty = 0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      rightPanel.add(new Box(inputPanel, "Array Data", Box.LEFT), gbc);

      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 100;
      gbc.fill = GridBagConstraints.BOTH;
      rightPanel.add(new Box(speedPanel, "Speed Controls", Box.LEFT), gbc);

      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 100;
      gbc.weighty = 100;
      gbc.fill = GridBagConstraints.BOTH;
      rightPanel.add(new Box(arrayVarPanel, "Array and Pointers", Box.LEFT), gbc);

      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 100;
      gbc.weighty = 0;
      gbc.fill = GridBagConstraints.BOTH;
      rightPanel.add(new Box(statsPanel, "Algorithm Statistics", Box.LEFT), gbc);

      gbc.anchor = GridBagConstraints.EAST;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 100;
      gbc.weighty = 0;
      gbc.fill = GridBagConstraints.BOTH;
      rightPanel.add(new Box(buttonPanel, "User Options", Box.LEFT), gbc);

      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 100;
      gbc.weighty = 100;
      gbc.fill = GridBagConstraints.BOTH;
      add(rightPanel, gbc);

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

   private void sortWithGraphics(int lo, int hi, int offset, int n, boolean up, Thread thisThread)
   {
      int j = lo + offset;
      if (runner == thisThread)
      {
         program.selectLines(line1, 25);
         variables[loIndex].setText(Integer.toString(lo));
         variables[hiIndex].setText(Integer.toString(hi));
         variables[offsetIndex].setText(Integer.toString(offset));
         variables[nIndex].setText(Integer.toString(n));
         if (up)
           variables[upIndex].setText("true");
         else
           variables[upIndex].setText("false");
         pause();
      }
      if (runner == thisThread)
      {
         program.selectLines(line1, 26);
         variables[jIndex].setText(Integer.toString(j));
         arrayPointersPos[1] = j;
         arrayPointersPos[2] = j+n;
         arrayCanvas.repaint();
         pause();
      }
      while ((runner == thisThread) && (j+n < hi))
      {
         if (runner == thisThread)
         {
            program.selectLines(line1, 27);
            pause();
         }
         if (runner == thisThread)
         {
            program.selectLines(line1, 28);
            compCt++;
            compField.setText(Integer.toString(compCt));
            pause();
         }
         if ((runner == thisThread) && ((up && (A[j] > A[j+n])) || (!up && (A[j] < A[j+n]))))
         {
            if (runner == thisThread)
            {
               program.selectLines(line1, 29);
               exchangeCt++;
               exchangeField.setText(Integer.toString(exchangeCt));
               arrayCanvas.setStatus(j, SWAPPING);
               arrayCanvas.setStatus(j+n, SWAPPING);
               arrayCanvas.repaint();
               pause();
            }
            if (runner == thisThread)
            {
               int temp = A[j];
               A[j] = A[j+n];
               A[j+n] = temp;
               arrayCanvas.repaint();
               pause();
            }
            if (runner == thisThread)
            {
               arrayCanvas.setStatus(j, UNSORTED);
               arrayCanvas.setStatus(j+n, UNSORTED);
               arrayCanvas.repaint();
            }
         }
         if (runner == thisThread)
         {
            program.selectLines(line1, 30);
            j += 2*n;
            variables[jIndex].setText(Integer.toString(j));
            arrayPointersPos[1] = j;
            arrayPointersPos[2] = j+n;
            arrayCanvas.repaint();
            pause();
         }
      }
      if (runner == thisThread)
      {
         program.selectLines(line1, 27);
         pause();
      }
      if (runner == thisThread)
      {
         variables[loIndex].setText("");
         variables[hiIndex].setText("");
         variables[offsetIndex].setText("");
         variables[nIndex].setText("");
         variables[upIndex].setText("");
         arrayPointersPos[1] = -2;
         arrayPointersPos[2] = -2;
         arrayCanvas.repaint();
      }
   }

   public void run()
   {
      thisThread = Thread.currentThread();
      int log = 0, pow = 1, rows = 1, cols = 0;
      if (runner == thisThread)
      {
         compCt = exchangeCt = 0;
         compField.setText("0");
         exchangeField.setText("0");
         program.selectLine(1);
         variables[logIndex].setText(Integer.toString(log));
         variables[powIndex].setText(Integer.toString(pow));
         variables[rowsIndex].setText(Integer.toString(rows));
         pause();
      }
      for(int i = 1; i <= (int)Math.sqrt(A.length); i++)
      {
         if (runner != thisThread)
            break;
         if (runner == thisThread)
         {
            program.selectLine(2);
            variables[iIndex].setText(Integer.toString(i));
            pause();
         }
         if (runner == thisThread)
         {
            program.selectLine(3);
            pause();
         }
         if ((runner == thisThread) && (A.length % i == 0))
         {
            program.selectLine(4);
            rows = i;
            variables[rowsIndex].setText(Integer.toString(rows));
            pause();
         }
      }
      if (runner == thisThread)
      {
         variables[iIndex].setText("");
         program.selectLine(5);
         cols = A.length / rows;
         variables[colsIndex].setText(Integer.toString(cols));
         pause();
      }
      while ((runner == thisThread) && (pow <= rows))
      {
         if (runner == thisThread)
         {
            program.selectLine(6);
            pause();
         }
         if (runner == thisThread)
         {
            program.selectLine(7);
            pow *= 2;
            variables[powIndex].setText(Integer.toString(pow));
            log += 1;
            variables[logIndex].setText(Integer.toString(log));
            pause();
         }
      }
      if (runner == thisThread)
      {
         program.selectLine(6);
         pause();
      }
      for(int k = 0; k < log; k++)
      {
         if (runner != thisThread)
            break;
         if (runner == thisThread)
         {
            program.selectLines(8, -1);
            variables[kIndex].setText(Integer.toString(k));
            pause();
         }
         for(int j = 0; j < cols / 2; j++)
         {
            if (runner != thisThread)
               break;
            if (runner == thisThread)
            {
               program.selectLines(9, -1);
               variables[jIndex].setText(Integer.toString(j));
               pause();
            }
            for(int i = 0; i < rows; i++)
            {
               if (runner != thisThread)
                  break;
               if (runner == thisThread)
               {
                  program.selectLines(10, -1);
                  variables[iIndex].setText(Integer.toString(i));
                  variables[jIndex].setText(Integer.toString(j));
                  pause();
               }
               if (runner == thisThread)
               {
                  line1 = 11;
                  program.selectLines(line1, -1);
                  pause();
               }
               if (runner == thisThread)
                  sortWithGraphics(i*cols, (i+1)*cols, 0, 1, i % 2 == 0, thisThread);
            }
            for(int i = 0; i < rows; i++)
            {
               if (runner != thisThread)
                  break;
               if (runner == thisThread)
               {
                  program.selectLines(12, -1);
                  variables[iIndex].setText(Integer.toString(i));
                  variables[jIndex].setText(Integer.toString(j));
                  pause();
               }
               if (runner == thisThread)
               {
                  line1 = 13;
                  program.selectLines(line1, -1);
                  pause();
               }
               if (runner == thisThread)
                  sortWithGraphics(i*cols, (i+1)*cols, 1, 1, i % 2 == 0, thisThread);
            }
         }
         for(int j = 0; j < rows / 2; j++)
         {
            if (runner != thisThread)
               break;
            if (runner == thisThread)
            {
               program.selectLines(14, -1);
               variables[jIndex].setText(Integer.toString(j));
               pause();
            }
            for(int i = 0; i < cols; i++)
            {
               if (runner != thisThread)
                  break;
               if (runner == thisThread)
               {
                  program.selectLines(15, -1);
                  variables[iIndex].setText(Integer.toString(i));
                  variables[jIndex].setText(Integer.toString(j));
                  pause();
               }
               if (runner == thisThread)
               {
                  line1 = 16;
                  program.selectLines(line1, -1);
                  pause();
               }
               if (runner == thisThread)
                  sortWithGraphics(i, rows*cols+i, 0, cols, true, thisThread);
            }
            for(int i = 0; i < cols; i++)
            {
               if (runner != thisThread)
                  break;
               if (runner == thisThread)
               {
                  program.selectLines(17, -1);
                  variables[iIndex].setText(Integer.toString(i));
                  variables[jIndex].setText(Integer.toString(j));
                  pause();
               }
               if (runner == thisThread)
               {
                  line1 = 18;
                  program.selectLines(line1, -1);
                  pause();
               }
               if (runner == thisThread)
                  sortWithGraphics(i, rows*cols+i, cols, cols, true, thisThread);
            }
         }
         if (runner == thisThread)
            variables[jIndex].setText("");
      }
      if (runner == thisThread)
         variables[kIndex].setText("");
      int tempJ = 0;
      for(int j = 0; j <= cols / 2; j++)
      {
         if (runner != thisThread)
            break;
         if (runner == thisThread)
         {
            program.selectLines(19, -1);
            tempJ = j;
            variables[jIndex].setText(Integer.toString(j));
            pause();
         }
         for(int i = 0; i < rows; i++)
         {
            if (runner != thisThread)
               break;
            if (runner == thisThread)
            {
               program.selectLines(20, -1);
               variables[iIndex].setText(Integer.toString(i));
               variables[jIndex].setText(Integer.toString(j));
               pause();
            }
            if (runner == thisThread)
            {
               line1 = 21;
               program.selectLines(line1, -1);
               pause();
            }
            if (runner == thisThread)
               sortWithGraphics(i*cols, (i+1)*cols, 0, 1, true, thisThread);
         }
         for(int i=0; i < rows; i++)
         {
            if (runner != thisThread)
               break;
            if (runner == thisThread)
            {
               program.selectLines(22, -1);
               variables[iIndex].setText(Integer.toString(i));
               variables[jIndex].setText(Integer.toString(j));
               pause();
            }
            if (runner == thisThread)
            {
               line1 = 23;
               program.selectLines(line1, -1);
               pause();
            }
            if (runner == thisThread)
               sortWithGraphics(i*cols, (i+1)*cols, 1, 1, true, thisThread);
         }
      }
      if (runner == thisThread)
      {
         variables[jIndex].setText(Integer.toString(tempJ));
         for(int i = 0; i < A.length; i++)
           arrayCanvas.setStatus(i, DONE);
         arrayCanvas.repaint();
         program.selectLines(-1, -1);
         ok.setEnabled(true);
         contPause.setEnabled(false);
         clear.setEnabled(false);
         arrayLine.requestFocus();
         if (runsFromApplet)
         {
            if (isSpecial)
              ss.sortInfo[ss.SHEAR].setData(arrayString, compCt, exchangeCt);
            else
              ss.sortInfo[ss.SHEAR].setData(copy, compCt, exchangeCt);
            if (table != null)
              table.update(ss.SHEAR, ss.sortInfo);
         }
         MessageBox mb = new MessageBox(ss, this, "Information",
                                        "Shearsort complete.", "information.gif");
      }
      stop();
   }

   private void sort(int lo, int hi, int offset, int n, boolean up)
   {
      int j = lo + offset;
      while (j+n < hi)
      {
         compCt++;
         if ((up && (A[j] > A[j+n])) || (!up && (A[j] < A[j+n])))
         {
            exchangeCt++;
            int temp = A[j];
            A[j] = A[j+n];
            A[j+n] = temp;
         }
         j += 2*n;
      }
   }

   private void noGraphicsShearsort()
   {
      int log = 0, pow = 1, rows = 1, cols;
      for(int i = 1; i <= (int)Math.sqrt(A.length); i++)
        if (A.length % i == 0)
          rows = i;
      cols = A.length / rows;
      while (pow <= rows)
      {
         pow *= 2;
         log += 1;
      }
      for(int k = 0; k < log; k++)
      {
         for(int j = 0; j < cols / 2; j++)
         {
            for(int i = 0; i < rows; i++)
              sort(i*cols, (i+1)*cols, 0, 1, i % 2 == 0);
            for(int i = 0; i < rows; i++)
              sort(i*cols, (i+1)*cols, 1, 1, i % 2 == 0);
         }
         for(int j = 0; j < rows / 2; j++)
         {
            for(int i = 0; i < cols; i++)
              sort(i, rows*cols+i, 0, cols, true);
            for(int i = 0; i < cols; i++)
              sort(i, rows*cols+i, cols, cols, true);
         }
      }
      for(int j = 0; j <= cols / 2; j++)
      {
         for(int i = 0; i < rows; i++)
           sort(i*cols, (i+1)*cols, 0, 1, true);
         for(int i=0; i < rows; i++)
           sort(i*cols, (i+1)*cols, 1, 1, true);
      }
   }

   public void noGraphics()
   {
      int n = A.length;
      compCt = exchangeCt = 0;
      noGraphicsShearsort();
      if (runsFromApplet)
      {
         if (isSpecial)
           ss.sortInfo[ss.SHEAR].setData(arrayString, compCt, exchangeCt);
         else
           ss.sortInfo[ss.SHEAR].setData(copy, compCt, exchangeCt);
         if (table != null)
           table.update(ss.SHEAR, ss.sortInfo);
      }
      compField.setText(Integer.toString(compCt));
      exchangeField.setText(Integer.toString(exchangeCt));
      MessageBox mb = new MessageBox(ss, this, "Information",
                                     "Shearsort complete.", "information.gif");
   }

   public static void main(String[] args)
   {
      ShearSortApp ssa = new ShearSortApp(null, false, null, null, null);
   }

}
