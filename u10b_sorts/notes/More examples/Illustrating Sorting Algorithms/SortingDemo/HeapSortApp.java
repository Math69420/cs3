// HeapSortApp.java
import java.awt.*;

public class HeapSortApp extends SortApp
{
   private int heapSize, line1, line2, line3;

   public HeapSortApp(SortStarter ss, boolean runsFromApplet, String _arrayString,
                      CompareTable table, int[] array)
   {
      super(ss, runsFromApplet, SortStarter.HEAP, "Heapsort", table, array != null);
      arrayString = _arrayString;
      if (isSpecial)
      {
         A = array;
         AToCopy();
         copyToRandomCopy();
      }

      algCode = new String[23];
      algCode[0]  = "HEAPSORT (A)";
      algCode[1]  = "1. BUILD-HEAP (A)";
      algCode[2]  = "2. for k <- length[A] - 1 downto 1";
      algCode[3]  = "3.    do exchange A[0] <-> A[k]";
      algCode[4]  = "4.       heap-size[A] <- heap-size[A] - 1";
      algCode[5]  = "5.       HEAPIFY (A, 0)";
      algCode[6]  = "\n";
      algCode[7]  = "BUILD-HEAP (A)";
      algCode[8]  = "1. heap-size[A] <- length[A]";
      algCode[9]  = "2. for j <- (length[A] div 2) - 1 downto 0";
      algCode[10] = "3.    do HEAPIFY (A, j)";
      algCode[11] = "\n";
      algCode[12] = "HEAPIFY (A, i)";
      algCode[13] = " 1. l = 2 * i + 1";
      algCode[14] = " 2. r = 2 * i + 2";
      algCode[15] = " 3. if l < heap-size[A] and A[l] > A[i]";
      algCode[16] = " 4.    then max <- l";
      algCode[17] = " 5.    else max <- i";
      algCode[18] = " 6. if r < heap-size[A] and A[r] > A[max]";
      algCode[19] = " 7.    then max <- r";
      algCode[20] = " 8. if max <> i";
      algCode[21] = " 9.    then exchange A[i] <-> A[max]";
      algCode[22] = "10.         HEAPIFY (A, max)";

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

      numOfVars = 7;
      labels = new Label[numOfVars];
      labels[0] = new Label("heap-size[A]: ", Label.RIGHT);
      labels[1] = new Label("l: ", Label.RIGHT);
      labels[2] = new Label("k:  ", Label.RIGHT);
      labels[3] = new Label("r:  ", Label.RIGHT);
      labels[4] = new Label("j:  ", Label.RIGHT);
      labels[5] = new Label("i:  ", Label.RIGHT);
      labels[6] = new Label("max:  ", Label.RIGHT);
      variables = new TextField[numOfVars];
      for(int i = 0; i < numOfVars; i++)
      {
         variables[i] = new TextField(2);
         variables[i].setEditable(false);
         variables[i].setBackground(Color.white);
      }        
      arrayPointers = new String[4];
      arrayPointers[0] = "k";
      arrayPointers[1] = "i";
      arrayPointers[2] = "l";
      arrayPointers[3] = "r";
      arrayPointersPos = new int[4];

      Panel varPanel0 = new Panel();
      varPanel0.setLayout(new GridLayout(2, 1));
      varPanel0.add(labels[0]);
      varPanel0.add(labels[1]);

      Panel varPanel1 = new Panel();
      varPanel1.setLayout(new GridLayout(2, 1));
      varPanel1.add(variables[0]);
      varPanel1.add(variables[1]);

      Panel varPanel2 = new Panel();
      varPanel2.setLayout(new GridLayout(2, 2));
      for(int i = 2; i < 4; i++)
      {
         varPanel2.add(labels[i]);
         varPanel2.add(variables[i]);
      }

      Panel varPanel3 = new Panel();
      varPanel3.setLayout(new GridLayout(2, 2));
      for(int i = 4; i < 6; i++)
      {
         varPanel3.add(labels[i]);
         varPanel3.add(variables[i]);
      }

      Panel varPanel4 = new Panel();
      varPanel4.setLayout(new GridLayout(1, 2));
      varPanel4.add(labels[6]);
      varPanel4.add(variables[6]);

      Panel variablesPanel = new Panel();
      variablesPanel.setLayout(new FlowLayout());
      variablesPanel.add(varPanel0);
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

      Panel rightPanel = new Panel();
      rightPanel.setLayout(new GridBagLayout());
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

   private void clearHeapify()
   {
      arrayPointers[1] = "i";
      arrayPointers[2] = "l";
      arrayPointers[3] = "r";
      for(int x = 1; x < arrayPointersPos.length; x++)
        arrayPointersPos[x] = -2;
      variables[1].setText("");
      variables[3].setText("");
      variables[5].setText("");
      variables[6].setText("");
   }

   private void heapsort(Thread thisThread)
   {
      if (runner == thisThread)
      {
         line1 = 1;
         program.selectLines(line1, line2, line3);
         pause();
      }
      if (runner == thisThread)
         buildHeap(thisThread);
      for(int k = A.length - 1; k > 0; k--)
      {
         if (runner != thisThread)
            break;
         if (runner == thisThread)
         {
            line1 = 2;
            program.selectLines(line1, line2, line3);
            variables[2].setText(Integer.toString(k));
            arrayPointersPos[0] = k;
            arrayCanvas.repaint();
            pause();
         }
         if (runner == thisThread)
         {
            line1 = 3;
            program.selectLines(line1, line2, line3);
            exchangeCt++;
            exchangeField.setText(Integer.toString(exchangeCt));
            arrayCanvas.setStatus(0, SWAPPING);
            arrayCanvas.setStatus(k, SWAPPING);
            arrayCanvas.repaint();
            pause();
         }
         if (runner == thisThread)
         {
            int temp = A[0];
            A[0] = A[k];
            A[k] = temp;
            arrayCanvas.repaint();
            pause();
         }
         if (runner == thisThread)
         {
            arrayCanvas.setStatus(0, UNSORTED);
            arrayCanvas.setStatus(k, DONE);
            arrayCanvas.repaint();
            line1 = 4;
            program.selectLines(line1, line2, line3);
            heapSize--;
            variables[0].setText(Integer.toString(heapSize));
            pause();
         }
         if (runner == thisThread)
         {
            line1 = 5;
            program.selectLines(line1, line2, line3);
            pause();
         }
         if (runner == thisThread)
            heapify(0, thisThread);
      }
      if (runner == thisThread)
         arrayCanvas.setStatus(0, DONE);
   }

   private void buildHeap(Thread thisThread)
   {
      if (runner == thisThread)
      {
         line2 = 7;
         program.selectLines(line1, line2, line3);
         pause();
      }
      if (runner == thisThread)
      {
         line2 = 8;
         program.selectLines(line1, line2, line3);
         heapSize = A.length;
         variables[0].setText(Integer.toString(heapSize));
         pause();
      }
      for(int j = A.length / 2 - 1; j >= 0; j--)
      {
         if (runner != thisThread)
            break;
         if (runner == thisThread)
         {
            line2 = 9;
            program.selectLines(line1, line2, line3);
            variables[4].setText(Integer.toString(j));
            pause();
         }
         if (runner == thisThread)
         {
            line2 = 10;
            program.selectLines(line1, line2, line3);
            pause();
         }
         if (runner == thisThread)
            heapify(j, thisThread);
      }
      if (runner == thisThread)
      {
         line2 = -1;
         variables[4].setText("");
      }
   }

   private void heapify(int i, Thread thisThread)
   {
      int max = 0, l = 0, r = 0;
      if (runner == thisThread)
      {
         clearHeapify();
         variables[5].setText(Integer.toString(i));
         line3 = 12;
         program.selectLines(line1, line2, line3);
         arrayPointersPos[1] = i;
         arrayCanvas.repaint();
         pause();
      }
      if (runner == thisThread)
      {
         line3 = 13;
         program.selectLines(line1, line2, line3);
         l = 2 * i + 1;
         variables[1].setText(Integer.toString(l));
         if (l < A.length)
           arrayPointersPos[2] = l;
         else
           arrayPointersPos[2] = -2;
         arrayCanvas.repaint();
         pause();
      }
      if (runner == thisThread)
      {
         line3 = 14;
         program.selectLines(line1, line2, line3);
         r = 2 * i + 2;
         variables[3].setText(Integer.toString(r));
         if (r < A.length)
           arrayPointersPos[3] = r;
         else
           arrayPointersPos[3] = -2;
         arrayCanvas.repaint();
         pause();
      }
      if (runner == thisThread)
      {
         line3 = 15;
         program.selectLines(line1, line2, line3);
         compCt++;
         compField.setText(Integer.toString(compCt));
         pause();
      }
      if ((runner == thisThread) && (l < heapSize) && (A[l] > A[i]))
      {
         line3 = 16;
         program.selectLines(line1, line2, line3);
         max = l;
         variables[6].setText(Integer.toString(max));
         arrayPointers[2] = "max";
         arrayCanvas.repaint();
         pause();
      }
      else
      {
         if (runner == thisThread)
         {
            line3 = 17;
            program.selectLines(line1, line2, line3);
            max = i;
            variables[6].setText(Integer.toString(max));
            arrayPointers[1] = "max";
            arrayCanvas.repaint();
            pause();
         }
      }
      if (runner == thisThread)
      {
         line3 = 18;
         program.selectLines(line1, line2, line3);
         compCt++;
         compField.setText(Integer.toString(compCt));
         pause();
      }
      if ((runner == thisThread) && (r < heapSize) && (A[r] > A[max]))
      {
         line3 = 19;
         program.selectLines(line1, line2, line3);
         max = r;
         variables[6].setText(Integer.toString(max));
         arrayPointers[1] = "i";
         arrayPointers[2] = "l";
         arrayPointers[3] = "max";
         arrayCanvas.repaint();
         pause();
      }
      if (runner == thisThread)
      {
         line3 = 20;
         program.selectLines(line1, line2, line3);
         compCt++;
         compField.setText(Integer.toString(compCt));
         pause();
      }
      if (max != i)
      {
         if (runner == thisThread)
         {
            line3 = 21;
            program.selectLines(line1, line2, line3);
            exchangeCt++;
            exchangeField.setText(Integer.toString(exchangeCt));
            arrayCanvas.setStatus(i, SWAPPING);
            arrayCanvas.setStatus(max, SWAPPING);
            arrayCanvas.repaint();
            pause();
         }
         if (runner == thisThread)
         {
            int temp = A[i];
            A[i] = A[max];
            A[max] = temp;
            arrayCanvas.repaint();
            pause();
         }
         if (runner == thisThread)
         {
            arrayCanvas.setStatus(i, UNSORTED);
            arrayCanvas.setStatus(max, UNSORTED);
            arrayCanvas.repaint();
            line3 = 22;
            program.selectLines(line1, line2, line3);
            pause();
         }
         if (runner == thisThread)
            heapify(max, thisThread);
      }
      if (runner == thisThread)
      {
         line3 = -1;
         clearHeapify();
      }
   }

   public void run()
   {
      thisThread = Thread.currentThread();
      if (runner == thisThread)
      {
         line1 = line2 = line3 = -1;
         compCt = exchangeCt = 0;
         compField.setText("0");
         exchangeField.setText("0");
      }
      if (runner == thisThread)
         heapsort(thisThread);
      if (runner == thisThread)
      {
         arrayCanvas.repaint();
         program.selectLines(-1, -1, -1);
         ok.setEnabled(true);
         contPause.setEnabled(false);
         clear.setEnabled(false);
         arrayLine.requestFocus();
         if (runsFromApplet)
         {
            if (isSpecial)
              ss.sortInfo[ss.HEAP].setData(arrayString, compCt, exchangeCt);
            else
              ss.sortInfo[ss.HEAP].setData(copy, compCt, exchangeCt);
            if (table != null)
              table.update(ss.HEAP, ss.sortInfo);
         }
         MessageBox mb = new MessageBox(ss, this, "Information",
                                        "Heapsort complete.", "information.gif");
      }
      stop();
   }

   private void noGraphicsHeapsort()
   {
      noGraphicsBuildHeap();
      for(int k = A.length - 1; k > 0; k--)
      {
         exchangeCt++;
         int temp = A[0];
         A[0] = A[k];
         A[k] = temp;
         heapSize--;
         noGraphicsHeapify(0);
      }
   }

   private void noGraphicsBuildHeap()
   {
      heapSize = A.length;
      for(int j = A.length / 2 - 1; j >= 0; j--)
         noGraphicsHeapify(j);
   }

   private void noGraphicsHeapify(int i)
   {
      int l = 2 * i + 1;
      int r = 2 * i + 2;
      int max;
      compCt++;
      if ((l < heapSize) && (A[l] > A[i]))
        max = l;
      else
        max = i;
      compCt++;
      if ((r < heapSize) && (A[r] > A[max]))
        max = r;
      compCt++;
      if (max != i)
      {
         exchangeCt++;
         int temp = A[i];
         A[i] = A[max];
         A[max] = temp;
         noGraphicsHeapify(max);
      }
   }

   public void noGraphics()
   {
      int n = A.length;
      compCt = exchangeCt = 0;
      noGraphicsHeapsort();    
      if (runsFromApplet)
      {
         if (isSpecial)
           ss.sortInfo[ss.HEAP].setData(arrayString, compCt, exchangeCt);
         else
           ss.sortInfo[ss.HEAP].setData(copy, compCt, exchangeCt);
         if (table != null)
           table.update(ss.HEAP, ss.sortInfo);
      }
      compField.setText(Integer.toString(compCt));
      exchangeField.setText(Integer.toString(exchangeCt));
      MessageBox mb = new MessageBox(ss, this, "Information",
                                     "Heapsort complete.", "information.gif");
   }

   public static void main(String[] args)
   {
      HeapSortApp hsa = new HeapSortApp(null, false, null, null, null);
   }

}
