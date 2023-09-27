// SelectionSortApp.java
import java.awt.*;

public class SelectionSortApp extends SortApp
{
   public SelectionSortApp(SortStarter ss, boolean runsFromApplet, String _arrayString,
                           CompareTable table, int[] array)
   {
      super(ss, runsFromApplet, SortStarter.SELECT, "Selection Sort", table, array != null);
      arrayString = _arrayString;
      if (isSpecial)
      {
         A = array;
         AToCopy();
         copyToRandomCopy();
      }

      algCode = new String[7];
      algCode[0] = "SELECTION_SORT (A)";
      algCode[1] = "1. for i <- 0 to n-2";
      algCode[2] = "2.    do current <- i";
      algCode[3] = "3.       for k <- i+1 to n-1 do";
      algCode[4] = "4.          do if A[current] > A[k]";
      algCode[5] = "5.                then current <- k";
      algCode[6] = "6.       exchange A[i] <-> A[current]";

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
      labels[1] = new Label("i: ", Label.RIGHT);
      labels[2] = new Label("current: ", Label.RIGHT);
      labels[3] = new Label("k: ", Label.RIGHT);
      variables = new TextField[numOfVars];
      variables[0] = new TextField(2);
      variables[1] = new TextField(2);
      variables[2] = new TextField(2);
      variables[3] = new TextField(2);
      arrayPointers = new String[3];
      arrayPointers[0] = "cur";
      arrayPointers[1] = "i";
      arrayPointers[2] = "k";
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
      int n = A.length, current = 0;
      variables[0].setText(Integer.toString(n));
      compCt = exchangeCt = 0;
      compField.setText("0");
      exchangeField.setText("0");
      for(int i = 0; i < n - 1; i++)
      {
         if (runner != thisThread)
            break;
         if (runner == thisThread)
         {
            variables[1].setText(Integer.toString(i));
            program.selectLine(1);
            arrayPointersPos[1] = i;
            arrayCanvas.repaint();
            pause();
         }
         if (runner == thisThread)
         {
            program.selectLine(2);
            current = i;
            variables[2].setText(Integer.toString(current));
            arrayPointersPos[0] = current;
            arrayCanvas.repaint();
            pause();
         }
         for(int k = i + 1; k < n; k++)
         {
            if (runner != thisThread)
               break;
            if (runner == thisThread)
            {
               variables[3].setText(Integer.toString(k));
               program.selectLine(3);
               arrayPointersPos[2] = k;
               arrayCanvas.repaint();
               pause();
            }
            if (runner == thisThread)
            {
               program.selectLine(4);
               compCt++;
               compField.setText(Integer.toString(compCt));
               pause();
            }
            if ((A[current] > A[k]) && (runner == thisThread))
            {
               program.selectLine(5);
               current = k;           
               variables[2].setText(Integer.toString(current));
               arrayPointersPos[0] = current;
               arrayCanvas.repaint();
               pause();
            }
         }
         if (runner == thisThread)
         {
            variables[3].setText("");
            arrayPointersPos[2] = -2;
            arrayCanvas.repaint();
            program.selectLine(6);
            exchangeCt++;
            exchangeField.setText(Integer.toString(exchangeCt));
            arrayCanvas.setStatus(i, SWAPPING);
            arrayCanvas.setStatus(current, SWAPPING);
            arrayCanvas.repaint();
            pause();
         }
         if (i != current)
         {
            if (runner == thisThread)
            {
               int temp = A[i];
               A[i] = A[current];
               A[current] = temp;
               arrayCanvas.repaint();
               pause();
            }
            if (runner == thisThread)
               arrayCanvas.setStatus(current, UNSORTED);
         }
         if (runner == thisThread)
         {
            arrayCanvas.setStatus(i, DONE);
            arrayCanvas.repaint();
         }
      }
      if (runner == thisThread)
      {
         arrayCanvas.setStatus(n-1, DONE);
         arrayCanvas.repaint();
         program.selectLine(-1);
         ok.setEnabled(true);
         contPause.setEnabled(false);
         clear.setEnabled(false);
         arrayLine.requestFocus();
         if (runsFromApplet)
         {
            if (isSpecial)
              ss.sortInfo[ss.SELECT].setData(arrayString, compCt, exchangeCt);
            else
              ss.sortInfo[ss.SELECT].setData(copy, compCt, exchangeCt);
            if (table != null)
              table.update(ss.SELECT, ss.sortInfo);
         }
         MessageBox mb = new MessageBox(ss, this, "Information",
                                        "Selection Sort complete.", "information.gif");
      }
      stop();
   }

   public void noGraphics()
   {
      int n = A.length;
      compCt = exchangeCt = 0;
      for(int i = 0; i < n - 1; i++)
      {
         int current = i;
         for(int k = i + 1; k < n; k++)
         {
            compCt++;
            if (A[current] > A[k])
              current = k;           
         }
         exchangeCt++;
         int temp = A[i];
         A[i] = A[current];
         A[current] = temp;
      }
      if (runsFromApplet)
      {
         if (isSpecial)
           ss.sortInfo[ss.SELECT].setData(arrayString, compCt, exchangeCt);
         else
           ss.sortInfo[ss.SELECT].setData(copy, compCt, exchangeCt);
         if (table != null)
           table.update(ss.SELECT, ss.sortInfo);
      }
      compField.setText(Integer.toString(compCt));
      exchangeField.setText(Integer.toString(exchangeCt));
      MessageBox mb = new MessageBox(ss, this, "Information",
                                     "Selection Sort complete.", "information.gif");
   }

   public static void main(String[] args)
   {
      SelectionSortApp ssa = new SelectionSortApp(null, false, null, null, null);
   }

}
