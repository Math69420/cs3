// QuickSortApp.java
import java.awt.*;

public class QuickSortApp extends SortApp
{
   private Stack stack;

   public QuickSortApp(SortStarter ss, boolean runsFromApplet, String _arrayString,
                       CompareTable table, int[] array)
   {
      super(ss, runsFromApplet, SortStarter.QUICK, "Quicksort", table, array != null);
      arrayString = _arrayString;
      if (isSpecial)
      {
         A = array;
         AToCopy();
         copyToRandomCopy();
      }

      numOfVars = 4;
      labels = new Label[numOfVars];
      labels[0] = new Label("p..r: ", Label.RIGHT);
      labels[1] = new Label("piv: ", Label.RIGHT);
      labels[2] = new Label("i: ", Label.RIGHT);
      labels[3] = new Label("j: ", Label.RIGHT);
      variables = new TextField[numOfVars];
      variables[0] = new TextField(6);
      variables[1] = new TextField(5);
      variables[2] = new TextField(2);
      variables[3] = new TextField(2);
      arrayPointers = new String[3];
      arrayPointers[0] = "";
      arrayPointers[1] = "i";
      arrayPointers[2] = "j";
      arrayPointersPos = new int[3];

      algCode = new String[18];
      algCode[0]  = "QUICKSORT (A, p, r)";
      algCode[1]  = "1. if p < r";
      algCode[2]  = "2.    then q <- PARTITION (A, p, r)";
      algCode[3]  = "3.         QUICKSORT (A, p, q)";
      algCode[4]  = "4.         QUICKSORT (A, q+1, r)";
      algCode[5]  = "\n";
      algCode[6]  = "PARTITION (A, p, r)";
      algCode[7]  = " 1. piv <- A[p]";
      algCode[8]  = " 2. i <- p - 1";
      algCode[9]  = " 3. j <- r + 1";
      algCode[10] = " 4. while TRUE";
      algCode[11] = " 5.    do repeat j <- j - 1";
      algCode[12] = " 6.       until A[j] <= piv";
      algCode[13] = " 7.       repeat i <- i + 1";
      algCode[14] = " 8.       until A[i] >= piv";
      algCode[15] = " 9.       if i < j";
      algCode[16] = "10.          then exchange A[i] <-> A[j]";
      algCode[17] = "11.          else return j";

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

      stackArea = new StackArea();
      stackPane = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
      stackPane.setBackground(Color.white);
      stackPane.add(stackArea);
      stackPane.setSize(390, 120);
      stackArea.setPane(stackPane);

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
      gbc.insets = new Insets(5, 5, 0, 5);
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weighty = 0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      arrayVarPanel.add(stackPane, gbc);
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

   private int partition(int[] A, int p, int r, Thread thisThread)
   {
      int piv = 0, i = 0, j = 0;
      if (runner == thisThread)
      {
         variables[0].setText(p + ".." + r);
         program.selectLines(2, 7);
         piv = A[p];
         variables[1].setText(Integer.toString(piv));
         pause();
      }
      if (runner == thisThread)
      {
         program.selectLines(2, 8);  
         i = p - 1;
         variables[2].setText(Integer.toString(i));
         arrayPointersPos[1] = i;
         arrayCanvas.repaint();
         pause();
      }
      if (runner == thisThread)
      {
         program.selectLines(2, 9);
         j = r + 1;
         variables[3].setText(Integer.toString(j));
         arrayPointersPos[2] = j;
         arrayCanvas.repaint();
         pause();
      }
      while ((i < j) && (runner == thisThread))
      {
         if (runner == thisThread)
         {
            program.selectLines(2, 10);
            arrayCanvas.repaint();
            pause();
         }
         do
         {
            if (runner == thisThread)
            {
               program.selectLines(2, 11);
               j -= 1;
               variables[3].setText(Integer.toString(j));
               arrayPointersPos[2] = j;
               arrayCanvas.repaint();
               pause();
            }
            if (runner == thisThread)
            {
               program.selectLines(2, 12);
               pause();
            }
         }
         while ((runner == thisThread) && (A[j] > piv));
         do
         {
            if (runner == thisThread)
            {
               program.selectLines(2, 13);
               i += 1;
               variables[2].setText(Integer.toString(i));
               arrayPointersPos[1] = i;
               arrayCanvas.repaint();
               pause();
            }
            if (runner == thisThread)
            {
               program.selectLines(2, 14);
               pause();
            }
         }
         while ((runner == thisThread) && (A[i] < piv));
         if (runner == thisThread)
         {
            compCt++;
            compField.setText(Integer.toString(compCt));
            program.selectLines(2, 15);
            pause();
         }
         if (i < j)
         {
            if (runner == thisThread)
            {
               exchangeCt++;
               exchangeField.setText(Integer.toString(exchangeCt));
               program.selectLines(2, 16);
               arrayCanvas.setStatus(i, SWAPPING);
               arrayCanvas.setStatus(j, SWAPPING);
               arrayCanvas.repaint();
               pause();
            }
            if (runner == thisThread)
            {
               int temp = A[i];
               A[i] = A[j];
               A[j] = temp;
               arrayCanvas.repaint();
               pause();
            }
            if (runner == thisThread)
            {
               arrayCanvas.setStatus(i, WORKING);
               arrayCanvas.setStatus(j, WORKING);
               arrayCanvas.repaint();
               pause();
            }
         }
      }
      if (runner == thisThread)
      {
         program.selectLines(2, 17);
         pause();
      }
      if (runner == thisThread)
      {
         arrayPointersPos[1] = -2;
         arrayPointersPos[2] = -2;
         for(int k = 0; k < numOfVars; k++)
           variables[k].setText("");
         arrayCanvas.repaint();
      }
      return j;
   }

   private void quicksort(int[] A, int p, int r, Thread thisThread)
   {
      int q = 0;
      if (runner == thisThread)
      {
         program.selectLines(1, -1);
         for(int i = 0; i < p; i++)
           arrayCanvas.setStatus(i, DONE);
         for(int i = p; i <= r; i++)
           arrayCanvas.setStatus(i, WORKING);
         for(int i = r + 1; i < A.length; i++)
           arrayCanvas.setStatus(i, UNSORTED);
         arrayCanvas.repaint();
         compCt++;
         compField.setText(Integer.toString(compCt));
         pause();
      }
      if (p < r)
      {
         if (runner == thisThread)
         {
            program.selectLines(2, -1);
            pause();
         }
         if (runner == thisThread)
         {
            q = partition(A, p, r, thisThread);
         }
         if (runner == thisThread)
         {
            stack.push((q + 1) + ".." + r);
            stackArea.setData(stack);
            program.selectLines(3, -1);
            pause();
         }
         if (runner == thisThread)
         {
            quicksort(A, p, q, thisThread);
         }
         if (runner == thisThread)
         {
            String dummy;
            if (!stack.isEmpty())
              dummy = stack.pop();
            stackArea.setData(stack);
            program.selectLines(4, -1);
            pause();
         }
         if (runner == thisThread)
            quicksort(A, q + 1, r, thisThread);
      }
      if (runner == thisThread)
      {
         arrayCanvas.setStatus(r, DONE);
         arrayCanvas.repaint();
      }
   }

   public void run()
   {
      thisThread = Thread.currentThread();
      if (runner == thisThread)
      {
         compCt = exchangeCt = 0;
         compField.setText("0");
         exchangeField.setText("0");
         stack = new Stack();
      }
      if (runner == thisThread)
         quicksort(A, 0, A.length - 1, thisThread);
      if (runner == thisThread)
      {
         program.selectLines(-1, -1);
         ok.setEnabled(true);
         contPause.setEnabled(false);
         clear.setEnabled(false);
         arrayLine.requestFocus();
         if (runsFromApplet)
         {
            if (isSpecial)
              ss.sortInfo[ss.QUICK].setData(arrayString, compCt, exchangeCt);
            else
              ss.sortInfo[ss.QUICK].setData(copy, compCt, exchangeCt);
            if (table != null)
              table.update(ss.QUICK, ss.sortInfo);
         }
         MessageBox mb = new MessageBox(ss, this, "Information",
                                        "Quicksort complete.", "information.gif");
      }
      stop();
   }

   private int noGraphicsPartition(int[] A, int p, int r)
   {
      int piv = A[p];
      int i = p - 1;
      int j = r + 1;
      while (i < j)
      {
         do
         {
            j -= 1;
         }
         while (A[j] > piv);
         do
         {
            i += 1;
         }
         while (A[i] < piv);
         compCt++;
         if (i < j)
         {
            exchangeCt++;
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
         }
      }
      return j;
   }

   private void noGraphicsQuicksort(int[] A, int p, int r)
   {
      compCt++;
      if (p < r)
      {
         int q = noGraphicsPartition(A, p, r);
         noGraphicsQuicksort(A, p, q);
         noGraphicsQuicksort(A, q + 1, r);
      }
   }

   public void noGraphics()
   {
      compCt = exchangeCt = 0;
      noGraphicsQuicksort(A, 0, A.length - 1);
      if (runsFromApplet)
      {
         if (isSpecial)
           ss.sortInfo[ss.QUICK].setData(arrayString, compCt, exchangeCt);
         else
           ss.sortInfo[ss.QUICK].setData(copy, compCt, exchangeCt);
         if (table != null)
           table.update(ss.QUICK, ss.sortInfo);
      }
      compField.setText(Integer.toString(compCt));
      exchangeField.setText(Integer.toString(exchangeCt));
      MessageBox mb = new MessageBox(ss, this, "Information",
                                     "Quicksort complete.", "information.gif");
   }

   public static void main(String[] args)
   {
      QuickSortApp qsa = new QuickSortApp(null, false, null, null, null);
   }

}
