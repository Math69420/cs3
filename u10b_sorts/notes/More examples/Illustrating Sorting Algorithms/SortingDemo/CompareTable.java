// CompareTable.java
import java.awt.*;
import java.awt.event.*;

public class CompareTable extends Frame implements ActionListener
{
   private SortStarter ss;
   private TextField[] arraysUsed, comparisons, exchanges;
   private SortInfo[] sortInfo;
   private Button clear, close;

   public CompareTable(SortStarter _ss, String[] sortNames, SortInfo[] _sortInfo)
   {
      super("Algorithm Comparison");
      ss = _ss;
      sortInfo = _sortInfo;
      setBackground(SystemColor.control);

      arraysUsed = new TextField[sortNames.length];
      comparisons = new TextField[sortNames.length];
      exchanges = new TextField[sortNames.length];
      for(int i = 0; i < arraysUsed.length; i++)
      {
         arraysUsed[i] = new TextField(40);
         arraysUsed[i].setEditable(false);
         arraysUsed[i].setBackground(Color.white);
         comparisons[i] = new TextField(8);
         comparisons[i].setEditable(false);
         comparisons[i].setBackground(Color.white);
         exchanges[i] = new TextField(8);
         exchanges[i].setEditable(false);
         exchanges[i].setBackground(Color.white);
      }

      clear = new Button("Clear");
      clear.addActionListener(this);
      close = new Button("Close");
      close.addActionListener(this);
      Panel buttonPanel = new Panel();
      buttonPanel.setLayout(new FlowLayout());
      buttonPanel.add(clear);
      buttonPanel.add(close);

      setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.insets = new Insets(0, 0, 0, 0);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridwidth = 1;
      gbc.weightx = 0;
      gbc.fill = GridBagConstraints.NONE;
      add(new Label(""), gbc);

      gbc.anchor = GridBagConstraints.CENTER;
      gbc.weightx = 100;
      add(new Label("Array Last Sorted", Label.CENTER), gbc);
      gbc.weightx = 0;
      add(new Label("Comparisons", Label.CENTER), gbc);
      gbc.insets = new Insets(0, 0, 0, 3);
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      add(new Label("Exchanges", Label.CENTER), gbc);

      for(int i = 0; i < sortNames.length; i++)
      {
         gbc.insets = new Insets(0, 0, 0, 0);
         gbc.anchor = GridBagConstraints.WEST;
         gbc.gridwidth = 1;
         gbc.weightx = 0;
         gbc.fill = GridBagConstraints.BOTH;
         add(new Label(sortNames[i]), gbc);

         gbc.anchor = GridBagConstraints.CENTER;
         gbc.weightx = 100;
         gbc.fill = GridBagConstraints.HORIZONTAL;
         add(arraysUsed[i], gbc);

         gbc.weightx = 0;
         gbc.fill = GridBagConstraints.NONE;
         add(comparisons[i], gbc);

         gbc.insets = new Insets(0, 0, 0, 3);
         gbc.gridwidth = GridBagConstraints.REMAINDER;
         add(exchanges[i], gbc);
      }

      gbc.insets = new Insets(0, 0, 0, 0);
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.gridwidth = GridBagConstraints.REMAINDER;
      gbc.weightx = 0;
      gbc.fill = GridBagConstraints.NONE;
      add(buttonPanel, gbc);

      addWindowListener(new WindowAdapter()
      {     
         public void windowClosing(WindowEvent e)
         {  
            ss.closeTable();
         }
      });

      validate();
      pack();
      Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
      Point p = new Point((int)((d.getWidth() - this.getWidth())/2),
                          (int)((d.getHeight() - this.getHeight())/2));
      setLocation(p);
      loadData(sortInfo);
      setVisible(true);
      close.requestFocus();
   }

   public void update(int pos, SortInfo[] sortInfo)
   {
      arraysUsed[pos].setText(sortInfo[pos].array);
      comparisons[pos].setText(sortInfo[pos].comparisons);
      exchanges[pos].setText(sortInfo[pos].exchanges);
   }

   private void loadData(SortInfo[] sortInfo)
   {
      for(int i = 0; i < arraysUsed.length; i++)
        if (sortInfo[i].array != null)
          update(i, sortInfo);
   }

   private void clearTable()
   {
      for(int i = 0; i < arraysUsed.length; i++)
        if (sortInfo[i].array != null)
        {
           sortInfo[i].array = null;
           sortInfo[i].comparisons = null;
           sortInfo[i].exchanges = null;
           arraysUsed[i].setText("");
           comparisons[i].setText("");
           exchanges[i].setText("");
        }
   }

   public void actionPerformed(ActionEvent ae)
   {
      if (ae.getSource() == clear)
        clearTable();
      else if (ae.getSource() == close)
        ss.closeTable();
   }

   public static void main(String args[]){}

}
