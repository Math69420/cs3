// MergeSortApp.java
import java.awt.*;

public class MergeSortApp extends SortApp
{
   private Stack stack;

   public MergeSortApp(SortStarter ss, boolean runsFromApplet, String _arrayString,
                       CompareTable table, int[] array)
   {
      super(ss, runsFromApplet, SortStarter.MERGE, "Mergesort", table, array != null);
      arrayString = _arrayString;
      if (isSpecial)
      {
         A = array;
         AToCopy();
         copyToRandomCopy();
      }

      algCode = new String[15];
      algCode[0]  = "MERGESORT (A, lo, hi)";
      algCode[1]  = " 1. if lo < hi then";
      algCode[2]  = " 2.    mid = (lo + hi) / 2";
      algCode[3]  = " 3.    MERGESORT (A, lo, mid)";
      algCode[4]  = " 4.    MERGESORT (A, mid+1, hi)";
      algCode[5]  = " 5.    L = lo";
      algCode[6]  = " 6.    H = mid + 1";
      algCode[7]  = " 7.    for k <- lo to hi";
      algCode[8]  = " 8.       do if L <= mid and (H > hi or A[L] < A[H])";
      algCode[9]  = " 9.             then scratch[k] = A[L]";
      algCode[10] = "10.                  L <- L + 1";
      algCode[11] = "11.             else scratch[k] = A[H]";
      algCode[12] = "12.                  H <- H + 1";
      algCode[13] = "13.    for k <- lo to hi";
      algCode[14] = "14.       do A[k] <- scratch[k]";

      program = new ProgramCanvas(algCode);

      stackArea = new StackArea();
      stackPane = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
      stackPane.setBackground(Color.white);
      stackPane.add(stackArea);
      stackPane.setSize(300, 100);
      stackArea.setPane(stackPane);

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

      Panel leftPanel = new Panel();
      leftPanel.setLayout(new GridBagLayout());
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 100;
      gbc.weighty = 100;
      gbc.fill = GridBagConstraints.BOTH;
      leftPanel.add(new Box(programPanel, algorithmName + " Algorithm", Box.LEFT), gbc);
      gbc.insets = new Insets(5, 0, 0, 0);
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weighty = 0;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      leftPanel.add(stackPane, gbc);

      numOfVars = 6;
      labels = new Label[numOfVars];
      labels[0] = new Label("lo: ", Label.RIGHT);
      labels[1] = new Label("L: ", Label.RIGHT);
      labels[2] = new Label("mid: ", Label.RIGHT);
      labels[3] = new Label("k: ", Label.RIGHT);
      labels[4] = new Label("hi: ", Label.RIGHT);
      labels[5] = new Label("H: ", Label.RIGHT);
      variables = new TextField[numOfVars];
      for(int i = 0; i < numOfVars; i++)
      {
         variables[i] = new TextField(2);
         variables[i].setEditable(false);
         variables[i].setBackground(Color.white);
      }
      arrayPointers = new String[3];
      arrayPointers[0] = "k";
      arrayPointers[1] = "L";
      arrayPointers[2] = "H";
      arrayPointersPos = new int[3];
      scratchPointers = new String[1];
      scratchPointers[0] = "k";
      scratchPointersPos = new int[1];

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

      Panel variablesPanel = new Panel();
      variablesPanel.setLayout(new FlowLayout());
      variablesPanel.add(varPanel0);
      variablesPanel.add(varPanel1);
      variablesPanel.add(varPanel2);
      variablesPanel.add(varPanel3);

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
      add(leftPanel, gbc);



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

   private void mergesort(int lo, int hi, Thread thisThread)
   {
      int mid = 0, tempHi = 0, tempLo = 0;
      if (runner == thisThread)
      {
         program.selectLine(1);
         compCt++;
         compField.setText(Integer.toString(compCt));
      }
      if (lo < hi)
      {
         if (runner == thisThread)
            pause();
         if (runner == thisThread)
         {
            program.selectLine(2);
             mid = (lo + hi) / 2;
            variables[2].setText(Integer.toString(mid));
            pause();
         }
         if (runner == thisThread)
         {
            stack.push((mid + 1) + ".." + hi);
            stackArea.setData(stack);
            program.selectLine(3);
            variables[0].setText(Integer.toString(lo));
            variables[2].setText("");
            variables[4].setText(Integer.toString(mid));
            for(int i = lo; i <= mid; i++)
              arrayCanvas.setStatus(i, WORKING);
            for(int i = mid + 1; i < A.length; i++)
              arrayCanvas.setStatus(i, UNSORTED);
            arrayCanvas.repaint();
            pause();
         }
         if (runner == thisThread)
            mergesort(lo, mid, thisThread);
         if (runner == thisThread)
         {
            String dummy;
            if (!stack.isEmpty())
              dummy = stack.pop();
            stackArea.setData(stack);
            program.selectLine(4);
            variables[0].setText(Integer.toString(mid + 1));
            variables[2].setText("");
            variables[4].setText(Integer.toString(hi));
            for(int i = mid+1; i <= hi; i++)
              arrayCanvas.setStatus(i, WORKING);
            for(int i = hi + 1; i < A.length; i++)
              arrayCanvas.setStatus(i, UNSORTED);
            arrayCanvas.repaint();
            pause();
         }
         if (runner == thisThread)
            mergesort(mid + 1, hi, thisThread);
         if (runner == thisThread)
         {
            program.selectLine(5);
            variables[0].setText(Integer.toString(lo));
            variables[2].setText(Integer.toString(mid));
            variables[4].setText(Integer.toString(hi));
            tempLo = lo;
            variables[1].setText(Integer.toString(tempLo));
            arrayPointersPos[1] = tempLo;
            for(int i = lo; i <= hi; i++)
              arrayCanvas.setStatus(i, WORKING);
            arrayCanvas.repaint();
            pause();
         }
         if (runner == thisThread)
         {
            program.selectLine(6);
            tempHi = mid + 1;
            variables[5].setText(Integer.toString(tempHi));
            arrayPointersPos[2] = tempHi;
            arrayCanvas.repaint();
            pause();
         }
         if (runner == thisThread)
            arrayCanvas.setLabels("Merging", null);
         for(int k = lo; k <= hi; k++)
         {
            if (runner != thisThread)
               break;
            if (runner == thisThread)
            {
               program.selectLine(7);
               variables[3].setText(Integer.toString(k));
               scratchPointersPos[0] = k;
               arrayCanvas.repaint();
               pause();
            }
            if (runner == thisThread)
            {
               program.selectLine(8);
               compCt++;
               compField.setText(Integer.toString(compCt));
               pause();
            }
            if ((tempLo <= mid) && ((tempHi > hi) || (A[tempLo] < A[tempHi])))
            {
               if (runner == thisThread)
               {
                  program.selectLine(9);
                  exchangeCt++;
                  exchangeField.setText(Integer.toString(exchangeCt));
                  arrayCanvas.setScratchStatus(k, SWAPPING);
                  arrayCanvas.setArrow(tempLo, k, arrayCanvas.ARROW_DOWN);
                  arrayCanvas.repaint();
                  pause();
               }
               if (runner == thisThread)
               {
                  scratch[k] = A[tempLo];
                  arrayCanvas.repaint();
                  pause();
               }
               if (runner == thisThread)
               {
                  arrayCanvas.setScratchStatus(k, UNSORTED);
                  arrayCanvas.clearArrow();
                  arrayCanvas.repaint();
                  program.selectLine(10);
                  tempLo++;
                  variables[1].setText(Integer.toString(tempLo));
                  arrayPointersPos[1] = tempLo;
                  arrayCanvas.repaint();
                  pause();
               }
            }
            else
            {
               if (runner == thisThread)
               {
                  program.selectLine(11);
                  exchangeCt++;
                  exchangeField.setText(Integer.toString(exchangeCt));
                  arrayCanvas.setScratchStatus(k, SWAPPING);
                  arrayCanvas.setArrow(tempHi, k, arrayCanvas.ARROW_DOWN);
                  arrayCanvas.repaint();
                  pause();
               }
               if (runner == thisThread)
               {
                  scratch[k] = A[tempHi];
                  arrayCanvas.repaint();
                  pause();
               }
               if (runner == thisThread)
               {
                  arrayCanvas.setScratchStatus(k, UNSORTED);
                  arrayCanvas.clearArrow();
                  arrayCanvas.repaint();
                  program.selectLine(12);
                  tempHi++;
                  variables[5].setText(Integer.toString(tempHi));
                  arrayPointersPos[2] = tempHi;
                  arrayCanvas.repaint();
                  pause();
               }
            }
         }
         if (runner == thisThread)
            arrayCanvas.setLabels(null, "Copying Back");
         for(int k = lo; k <= hi; k++)
         {
            if (runner != thisThread)
               break;
            if (runner == thisThread)
            {
               program.selectLine(13);
               variables[3].setText(Integer.toString(k));
               arrayPointersPos[0] = k;
               scratchPointersPos[0] = k;
               arrayCanvas.repaint();
               pause();
            }
            if (runner == thisThread)
            {
               program.selectLine(14);
               exchangeCt++;
               exchangeField.setText(Integer.toString(exchangeCt));
               arrayCanvas.setStatus(k, SWAPPING);
               arrayCanvas.setArrow(k, k, arrayCanvas.ARROW_UP);
               arrayCanvas.repaint();
               pause();
            }
            if (runner == thisThread)
            {
               A[k] = scratch[k];
               arrayCanvas.repaint();
               pause();
            }
            if (runner == thisThread)
            {
               if ((lo == 0) && (hi == A.length - 1))
                 arrayCanvas.setStatus(k, DONE);
               else
                 arrayCanvas.setStatus(k, PARTSORTED);
               arrayCanvas.clearArrow();
               arrayCanvas.repaint();
            }
         }
         if (runner == thisThread)
         {
            variables[3].setText("");
            arrayPointersPos[0] = -2;
            scratchPointersPos[0] = -2;
            arrayCanvas.setLabels(null, null);
            arrayCanvas.repaint();
         }
      }
      else
      {
         if (runner == thisThread)
         {
            for(int i = 0; i < lo; i++)
              arrayCanvas.setStatus(i, UNSORTED);
            arrayCanvas.setStatus(lo, PARTSORTED);
            arrayCanvas.repaint();
            pause();
         }
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
         variables[0].setText(Integer.toString(0));
         variables[2].setText("");
         variables[4].setText(Integer.toString(A.length-1));
         arrayCanvas.clearArrow();
         for(int i = 0; i < A.length; i++)
           arrayCanvas.setStatus(i, WORKING);
         arrayCanvas.repaint();
      }
      if (runner == thisThread)
         mergesort(0, A.length-1, thisThread);
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
              ss.sortInfo[ss.MERGE].setData(arrayString, compCt, exchangeCt);
            else
              ss.sortInfo[ss.MERGE].setData(copy, compCt, exchangeCt);
            if (table != null)
              table.update(ss.MERGE, ss.sortInfo);
         }
         MessageBox mb = new MessageBox(ss, this, "Information",
                                        "Mergesort complete.", "information.gif");
      }
      stop();
   }

   private void noGraphicsMergesort(int lo, int hi)
   {
      compCt++;
      if (lo < hi)
      {
         int mid = (lo + hi) / 2;
         noGraphicsMergesort(lo, mid);
         noGraphicsMergesort(mid + 1, hi);
         int tempLo = lo;
         int tempHi = mid + 1;
         for(int k = lo; k <= hi; k++)
         {
            compCt++;
            if ((tempLo <= mid) && ((tempHi > hi) || (A[tempLo] < A[tempHi])))
            {
               exchangeCt++;
               scratch[k] = A[tempLo];
               tempLo++;
            }
            else
            {
               exchangeCt++;
               scratch[k] = A[tempHi];
               tempHi++;
            }
         }
         for(int k = lo; k <= hi; k++)
         {
            exchangeCt++;
            A[k] = scratch[k];
         }
      }
   }

   public void noGraphics()
   {
      compCt = exchangeCt = 0;
      scratch = new int[A.length];
      noGraphicsMergesort(0, A.length-1);
      if (runsFromApplet)
      {
         if (isSpecial)
           ss.sortInfo[ss.MERGE].setData(arrayString, compCt, exchangeCt);
         else
           ss.sortInfo[ss.MERGE].setData(copy, compCt, exchangeCt);
         if (table != null)
           table.update(ss.MERGE, ss.sortInfo);
      }
      compField.setText(Integer.toString(compCt));
      exchangeField.setText(Integer.toString(exchangeCt));
      MessageBox mb = new MessageBox(ss, this, "Information",
                                     "Mergesort complete.", "information.gif");
   }

   public static void main(String[] args)
   {
      MergeSortApp msa = new MergeSortApp(null, false, null, null, null);
   }

}
