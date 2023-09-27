// SortStarter.java
// Class that allows the program to run under an applet.
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class SortStarter extends Applet implements ActionListener, ItemListener,
                                                   FocusListener
{
   public static final byte BUBBLE = 0, SELECT = 1, INSERT = 2, SHELL = 3,
                            QUICK = 4, MERGE = 5, HEAP = 6, OETRANS = 7,
                            SHEAR = 8;
   public static final int MAXLENGTH = 25;

   public SortInfo[] sortInfo;

   private String[] strChoices = {"Bubble Sort", "Selection Sort", "Insertion Sort",
                                  "Shellsort", "Quicksort", "Mergesort", "Heapsort",
                                  "O-E Transposition Sort", "Shearsort"},
                    lengthChoices = {"5", "10", "15", "20", "25", "50", "100", "200", "500", "1000", "2000"},
                    arrayChoices = {"Random", "Sorted", "Reverse sorted"};
   private static final byte RANDOM = 0, SORTED = 1, REVERSE = 2;
   private Button start, compare, generate;
   private Choice sortChoice, lengthChoice, arrayChoice;
   private Checkbox importBox, specialBox;
   private TextField arrayField;
   private BubbleSortApp bsa;
   private SelectionSortApp ssa;
   private InsertionSortApp isa;
   private ShellSortApp shsa;
   private QuickSortApp qsa;
   private MergeSortApp msa;
   private HeapSortApp hsa;
   private OETransSortApp oetsa;
   private ShearSortApp shrsa;
   private CompareTable table;
   private int typeOfSort;
   private int[] A = null, copySpecialArray = null;
   private String importStr, specialStr;

   public void init()
   {
      setBGColor(getParameter("background"));
      GridBagConstraints gbc = new GridBagConstraints();
      typeOfSort = BUBBLE;
      sortInfo = new SortInfo[strChoices.length];
      for(int i = 0; i < strChoices.length; i++)
        sortInfo[i] = new SortInfo();

      sortChoice = new Choice();
      sortChoice.addItemListener(this);
      for(int i = 0; i < strChoices.length; i++)
        sortChoice.add(strChoices[i]);

      lengthChoice = new Choice();
      lengthChoice.addItemListener(this);
      for(int i = 0; i < lengthChoices.length; i++)
        lengthChoice.add(lengthChoices[i]);
      lengthChoice.setEnabled(false);

      arrayChoice = new Choice();
      arrayChoice.addItemListener(this);
      for(int i = 0; i < arrayChoices.length; i++)
        arrayChoice.add(arrayChoices[i]);
      arrayChoice.setEnabled(false);

      start = new Button(" Start Sorting Demo ");
      start.addActionListener(this);
      compare = new Button("Compare Algorithms");
      compare.addActionListener(this);
      generate = new Button("   Regenerate Array   ");
      generate.addActionListener(this);
      generate.setEnabled(false);
    
      Panel topLeftPanel = new Panel();
      topLeftPanel.setLayout(new FlowLayout());
      topLeftPanel.add(sortChoice);

      CheckboxGroup cbGroup = new CheckboxGroup();
      importBox = new Checkbox("User-Defined", cbGroup, true);
      importBox.addItemListener(this);
      specialBox = new Checkbox("Special-Case", cbGroup, false);
      specialBox.addItemListener(this);
      Panel cbPanel = new Panel();
      cbPanel.setLayout(new FlowLayout());
      cbPanel.add(importBox);
      cbPanel.add(specialBox);

      Panel topPanel = new Panel();
      topPanel.setLayout(new GridLayout(1, 2));
      topPanel.add(new Box(topLeftPanel, "Featured Algorithms", Box.LEFT));
      topPanel.add(new Box(cbPanel, "Array Type", Box.LEFT));

      arrayField = new TextField(50);
      arrayField.addFocusListener(this);

      Panel centerPanel = new Panel();
      centerPanel.setLayout(new GridBagLayout());
      gbc.insets = new Insets(0, 0, 0, 0);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridwidth = 1;
      gbc.weightx = 0;
      gbc.fill = GridBagConstraints.NONE;
      centerPanel.add(new Label("Array:", Label.RIGHT), gbc);
      gbc.insets = new Insets(5, 5, 5, 10);
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 100;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      centerPanel.add(arrayField, gbc);
      gbc.insets = new Insets(5, 0, 10, 0);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridwidth = 1;
      gbc.weightx = 0;
      gbc.fill = GridBagConstraints.NONE;
      centerPanel.add(new Label("Type:", Label.RIGHT), gbc);
      gbc.insets = new Insets(5, 5, 10, 5);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridwidth = 1;
      gbc.weightx = 0;
      gbc.fill = GridBagConstraints.NONE;
      centerPanel.add(arrayChoice, gbc);
      gbc.insets = new Insets(5, 0, 10, 0);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridwidth = 1;
      gbc.weightx = 0;
      gbc.fill = GridBagConstraints.NONE;
      centerPanel.add(new Label("Length:", Label.RIGHT), gbc);
      gbc.insets = new Insets(5, 5, 10, 5);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridwidth = 1;
      gbc.weightx = 100;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      centerPanel.add(lengthChoice, gbc);
      gbc.insets = new Insets(5, 10, 10, 10);
      gbc.anchor = GridBagConstraints.EAST;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 0;
      gbc.fill = GridBagConstraints.NONE;
      centerPanel.add(generate, gbc);

      Panel bottomPanel = new Panel();
      bottomPanel.setLayout(new GridBagLayout());
      gbc.insets = new Insets(10, 0, 0, 5);
      gbc.anchor = GridBagConstraints.EAST;
      gbc.gridwidth = 1;
      gbc.weightx = 100;
      gbc.fill = GridBagConstraints.NONE;
      bottomPanel.add(start, gbc);
      gbc.insets = new Insets(10, 5, 0, 0);
      gbc.anchor = GridBagConstraints.EAST;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 0;
      gbc.fill = GridBagConstraints.NONE;
      bottomPanel.add(compare, gbc);

      Panel mainPanel = new Panel();
      mainPanel.setLayout(new BorderLayout());
      mainPanel.add("North", topPanel);
      mainPanel.add("Center", new Box(centerPanel, "Array Data", Box.LEFT));
      mainPanel.add("South", bottomPanel);

      Panel thePanel = new Panel();
      thePanel.setLayout(new GridBagLayout());
      thePanel.setBackground(SystemColor.control);
      gbc.insets = new Insets(0, 7, 7, 7);
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 100;
      gbc.fill = GridBagConstraints.NONE;
      thePanel.add(mainPanel, gbc);

      setLayout(new GridBagLayout());
      gbc.insets = new Insets(0, 0, 0, 0);
      gbc.anchor = GridBagConstraints.SOUTH;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 100;
      gbc.fill = GridBagConstraints.NONE;
      add(thePanel, gbc);
      validate();
   }

   public void close()
   {
      switch(typeOfSort)
      {
         case BUBBLE:
           bsa.setVisible(false);
           bsa.dispose();
           bsa = null;
           break;
         case SELECT:
           ssa.setVisible(false);
           ssa.dispose();
           ssa = null;
           break;
         case INSERT:
           isa.setVisible(false);
           isa.dispose();
           isa = null;
           break;
         case SHELL:
           shsa.setVisible(false);
           shsa.dispose();
           shsa = null;
           break;
         case QUICK:
           qsa.setVisible(false);
           qsa.dispose();
           qsa = null;
           break;
         case MERGE:
           msa.setVisible(false);
           msa.dispose();
           msa = null;
           break;
         case HEAP:
           hsa.setVisible(false);
           hsa.dispose();
           hsa = null;
           break;
         case OETRANS:
           oetsa.setVisible(false);
           oetsa.dispose();
           oetsa = null;
           break;
         case SHEAR:
           if (shrsa != null)
           {
              shrsa.setVisible(false);
              shrsa.dispose();
              shrsa = null;
           }
           break;
      }
      if (specialBox.getState())
      {
         arrayChoice.setEnabled(true);
         lengthChoice.setEnabled(true);
         if (arrayChoice.getSelectedIndex() == RANDOM)
            generate.setEnabled(true);
         arrayField.setEditable(false);
         arrayField.setBackground(SystemColor.control);
      }
      else if (importBox.getState())
      {
         arrayField.setEditable(true);
         arrayField.setBackground(Color.white);
      }
      arrayField.setEnabled(true);
      importBox.setEnabled(true);
      specialBox.setEnabled(true);
      sortChoice.setEnabled(true);
      start.setEnabled(true);
      compare.setEnabled(true);
      if (table != null)
        table.toFront();
      else
        sortChoice.requestFocus();
   }

   public void closeTable()
   {
      table.setVisible(false);
      table.dispose();
      table = null;
   }

   public void actionPerformed(ActionEvent ae)
   {
      String s = "";
      if (ae.getSource() == start)
      {
         sortChoice.requestFocus();
         start.setEnabled(false);
         sortChoice.setEnabled(false);
         importBox.setEnabled(false);
         arrayField.setEnabled(false);
         specialBox.setEnabled(false);
         arrayChoice.setEnabled(false);
         lengthChoice.setEnabled(false);
         generate.setEnabled(false);
         compare.setEnabled(false);
         if (importBox.getState())
         {
            CharArray dataLine = new CharArray(arrayField.getText().trim());
            if (dataLine.isExistence())
              try
              {
                 A = dataLine.getBoundlessArray();
                 importStr = "";
                 for(int i = 0; i < A.length; i++)
                   importStr += Integer.toString(A[i]) + " ";
                 importStr = importStr.trim();
                 arrayField.setText(importStr);
                 s = importStr;
                 A = null;
              }
              catch(ArrayException arrayExc){}
         }
         else if (specialBox.getState())
         {
            s = specialStr;           
         }
         switch(typeOfSort)
         {
            case BUBBLE:
              bsa = new BubbleSortApp(this, true, s, table, A);
              break;
            case SELECT:
              ssa = new SelectionSortApp(this, true, s, table, A);
              break;
            case INSERT:
              isa = new InsertionSortApp(this, true, s, table, A);
              break;
            case SHELL:
              shsa = new ShellSortApp(this, true, s, table, A);
              break;
            case QUICK:
              qsa = new QuickSortApp(this, true, s, table, A);
              break;
            case MERGE:
              msa = new MergeSortApp(this, true, s, table, A);
              break;
            case HEAP:
              hsa = new HeapSortApp(this, true, s, table, A);
              break;
            case OETRANS:
              oetsa = new OETransSortApp(this, true, s, table, A);
              break;
            case SHEAR:
              shrsa = new ShearSortApp(this, true, s, table, A);
              break;
          }
      }
      else if (ae.getSource() == compare)
      {
         if (table == null)
           table = new CompareTable(this, strChoices, sortInfo);
         else
           table.toFront();
      }
      else if (ae.getSource() == generate)
         makeAnArray();
   }

   private void makeRandomArray(int _highIndex)
   {
      int highIndex = _highIndex;
      A = new int[highIndex];
      copySpecialArray = new int[highIndex];
      specialStr = "rand(" + highIndex + "): ";
      for(int i = 0; i < highIndex; i++)
      {
         A[i] = (int)(Math.random() * 999);
         copySpecialArray[i] = A[i];
         if (i < MAXLENGTH)
           specialStr += Integer.toString(A[i]) + " ";
         else if (i == MAXLENGTH)
           specialStr += "...";
      }
      specialStr = specialStr.trim();
      arrayField.setText(specialStr);
   }

   private void makeSortedArray(int _highIndex)
   {
      int highIndex = _highIndex;
      A = new int[highIndex];
      copySpecialArray = new int[highIndex];
      specialStr = "sorted(" + highIndex + "): ";
      for(int i = 0; i < highIndex; i++)
      {
         A[i] = i + 1;
         copySpecialArray[i] = A[i];
         if (i < MAXLENGTH)
           specialStr += Integer.toString(A[i]) + " ";
         else if (i == MAXLENGTH)
           specialStr += "...";
      }
      specialStr = specialStr.trim();
      arrayField.setText(specialStr);
   }

   private void makeReverseArray(int _highIndex)
   {
      int highIndex = _highIndex;
      A = new int[highIndex];
      copySpecialArray = new int[highIndex];
      specialStr = "reverse(" + highIndex + "): ";
      for(int i = 0; i < highIndex; i++)
      {
         A[i] = highIndex - i;
         copySpecialArray[i] = A[i];
         if (i < MAXLENGTH)
           specialStr += Integer.toString(A[i]) + " ";
         else if (i == MAXLENGTH)
           specialStr += "...";
      }
      specialStr = specialStr.trim();
      arrayField.setText(specialStr);
   }

   private void makeAnArray()
   {
      if (arrayChoice.getSelectedIndex() == RANDOM)
        makeRandomArray(Integer.parseInt(lengthChoice.getSelectedItem().toString()));
      else if (arrayChoice.getSelectedIndex() == SORTED)
        makeSortedArray(Integer.parseInt(lengthChoice.getSelectedItem().toString()));
      else
        makeReverseArray(Integer.parseInt(lengthChoice.getSelectedItem().toString()));
   }

   public void focusGained(FocusEvent fe){}

   public void focusLost(FocusEvent fe)
   {
      if (fe.getSource() == importBox)
      {
         if (importBox.getState())
         {
            arrayField.selectAll();
            arrayField.requestFocus();
         }
      }
      else if (fe.getSource() == specialBox)
      {
         if (!specialBox.getState())
         {
            arrayChoice.setEnabled(false);
            lengthChoice.setEnabled(false);
         }
      }
      else
         arrayField.select(0, 0);
   }

   private void removeRand()
   {
      String a = arrayField.getText();
      int pos = a.indexOf(":");
      if (pos != -1)
         a = a.substring(pos + 2);
      arrayField.setText(a);
   }

   public void itemStateChanged(ItemEvent ie)
   {
      if (ie.getSource() == sortChoice)
        typeOfSort = sortChoice.getSelectedIndex();
      else if (ie.getSource() == importBox)
        if (importBox.getState())
        {
           removeRand();
           arrayChoice.setEnabled(false);
           lengthChoice.setEnabled(false);
           generate.setEnabled(false);
           arrayField.setEditable(true);
           arrayField.setBackground(Color.white);
           arrayField.requestFocus();
           arrayField.selectAll();
           A = null;
        }
        else
        {
           arrayField.select(0, 0);
           arrayField.setEditable(false);
           arrayField.setBackground(SystemColor.control);
        }
      else if (ie.getSource() == specialBox)
      {
         if (specialBox.getState())
         {
            arrayField.setEditable(false);
            arrayField.setBackground(SystemColor.control);
            arrayChoice.setEnabled(true);
            lengthChoice.setEnabled(true);
            if (arrayChoice.getSelectedIndex() == RANDOM)
               generate.setEnabled(true);
            arrayChoice.requestFocus();
            if (copySpecialArray == null)
               makeAnArray();
            else
            {
               A = copySpecialArray;
               String specialStr;
               if (arrayChoice.getSelectedIndex() == RANDOM)
                  specialStr = "rand(";
               else if (arrayChoice.getSelectedIndex() == SORTED)
                  specialStr = "sorted(";
               else
                  specialStr = "reverse(";
               specialStr += lengthChoice.getSelectedItem() + "): ";
               for(int i = 0; i < A.length; i++)
               {
                  if (i < MAXLENGTH)
                    specialStr += Integer.toString(A[i]) + " ";
                  else if (i == MAXLENGTH)
                    specialStr += "...";
               }
               specialStr = specialStr.trim();
               arrayField.setText(specialStr);
            }
         }
         else
         {
            arrayChoice.setEnabled(false);
            lengthChoice.setEnabled(false);
            generate.setEnabled(false);
            arrayField.setEditable(true);
            arrayField.setBackground(Color.white);
            A = null;
         }
      }
      else if (ie.getSource() == arrayChoice)
      {
         if (arrayChoice.getSelectedIndex() == RANDOM)
            generate.setEnabled(true);
         else
            generate.setEnabled(false);
         makeAnArray();
      }
      else if (ie.getSource() == lengthChoice)
         makeAnArray();
   }

   private void setBGColor(String background)
   {
      if ((background == null) || (background.length() != 7) ||
          (background.charAt(0) != '#'))
         setBackground(Color.white);
      else
      {
         String hexcolor, red, green, blue;
         hexcolor = background.substring(1, background.length());
         red = hexcolor.substring(0, 2);
         green = hexcolor.substring(2, 4);
         blue = hexcolor.substring(4, 6);
         setBackground(new Color(Integer.parseInt(red, 16),
                                 Integer.parseInt(green, 16),
                                 Integer.parseInt(blue, 16)));
      }
   }

}
