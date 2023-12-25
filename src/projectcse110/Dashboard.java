
package projectcse110;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Dashboard  extends JFrame implements ActionListener{
    
    private Container c;
    private JLabel label,label2, titleLabel,fnLabel,lnLable, phoneLabel,teamLabel,prizeLabel,dateLable;
    private JTextField fnTf,lnTf,phoneTf,prizeTf, dateTf,teamTf;
    private JButton addButton, updateButton, deleteButton;
    private Font  ftitle,f1,f2,f3;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scroll;
    
    private String[] col = {"Client's Name","Code","Number","Submited Time","Price"};
    private String[] row = new String[5];
    
    public Dashboard() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(80,10,1220,720);
        this.setTitle("Dashboard-Company Management System");
        ftitle = new Font("Serif",Font.ITALIC,27);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);
        
        label = new JLabel("Welcome to IT Company Management System");
        label.setBounds(330,20,540,60);
        label.setFont(ftitle);
        c.add(label);
        
        label2 = new JLabel("Total Company Information System");
        label2.setBounds(380,350,550,60);
        label2.setFont(ftitle);
        c.add(label2);
        
        information();
    }
    public void information(){
        f1 = new Font("Serif",Font.ITALIC,23);
        f2 = new Font("Serif",Font.BOLD,15);
        f3 = new Font("Serif",Font.PLAIN,12);
        titleLabel = new JLabel("Client & Service Details :");
        titleLabel.setBounds(50, 110, 300, 50);
        titleLabel.setFont(f1);
        c.add(titleLabel);
        
        fnLabel = new JLabel("Client's Name : ");
        fnLabel.setBounds(50, 170, 150, 50);
        fnLabel.setFont(f2);
        c.add(fnLabel);
        
        fnTf = new JTextField();
        fnTf.setBounds(170, 180, 170, 30);
        fnTf.setFont(f2);
        c.add(fnTf);
        
        addButton = new JButton("Add information");
        addButton.setBounds(800, 160, 160, 40);
        addButton.setFont(f2);
        c.add(addButton);
        
        lnLable = new JLabel("Product Code : ");
        lnLable.setBounds(50, 220, 150, 50);
        lnLable.setFont(f2);
        c.add(lnLable);
        
        lnTf = new JTextField();
        lnTf.setBounds(170, 230, 170, 30);
        lnTf.setFont(f2);
        c.add(lnTf);
        
        updateButton = new JButton("Update information");
        updateButton.setBounds(800, 210, 160, 40);
        updateButton.setFont(f2);
        c.add(updateButton);
        
        phoneLabel = new JLabel("Phone Number : ");
        phoneLabel.setBounds(50, 270, 150, 50);
        phoneLabel.setFont(f2);
        c.add(phoneLabel);
        
        phoneTf = new JTextField();
        phoneTf.setBounds(170, 280, 170, 30);
        phoneTf.setFont(f2);
        c.add(phoneTf);
        
        deleteButton = new JButton("Remove Data");
        deleteButton.setBounds(800, 260, 160, 40);
        deleteButton.setFont(f2);
        c.add(deleteButton);
        
        
        
        teamLabel = new JLabel("Team Leader :");
        teamLabel.setBounds(400, 170, 150, 50);
        teamLabel.setFont(f2);
        c.add(teamLabel);
        
        teamTf = new JTextField();
        teamTf.setBounds(520, 180, 150, 30);
        teamTf.setFont(f2);
        c.add(teamTf);
        
        dateLable = new JLabel("Submited Time :");
        dateLable.setBounds(400, 220, 150, 50);
        dateLable.setFont(f2);
        c.add(dateLable);
        
        dateTf = new JTextField();
        dateTf.setBounds(520, 230, 150, 30);
        dateTf.setFont(f2);
        c.add(dateTf);
        
        prizeLabel = new JLabel("Total Price : ");
        prizeLabel.setBounds(400, 270, 150, 50);
        prizeLabel.setFont(f2);
        c.add(prizeLabel);
        
        prizeTf = new JTextField();
        prizeTf.setBounds(520, 280, 150, 30);
        prizeTf.setFont(f2);
        c.add(prizeTf);
        
        
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(col);
        table.setModel(model);
        table.setFont(f3);
        table.setSelectionBackground(Color.LIGHT_GRAY);
        table.setBackground(Color.yellow);
        table.setRowHeight(20);
        
        
        scroll = new JScrollPane(table);
        scroll.setBounds(20, 430, 1150, 230);
        c.add(scroll);
        
        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        table.addMouseListener(new MouseAdapter(){
          
            public void mouseClicked(MouseEvent e){
              int num = table.getSelectedRow();
              
              String f1 = model.getValueAt(num,0).toString();
              String f2 = model.getValueAt(num,1).toString();
              String f3 = model.getValueAt(num,2).toString();
              String f4 = model.getValueAt(num,3).toString();
              String f5= model.getValueAt(num,4).toString();
              
              fnTf.setText(f1);
              lnTf.setText(f2);
              phoneTf.setText(f3);
              dateTf.setText(f4);
              prizeTf.setText(f4);
              
            }
        
        
        
        });
        
        
        
        
        
        
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
          if(e.getSource() == addButton){
            row[0] = fnTf.getText();
            row[1] = lnTf.getText();
            row[2] = phoneTf.getText();
            row[3] = dateTf.getText();
            row[4] = prizeTf.getText();
            model.addRow(row);
          }
         if(e.getSource() == deleteButton){
            int n = table.getSelectedRow();
            if(n>=0){
               model.removeRow(n);
            }
            else{
              JOptionPane.showMessageDialog(null, "Sorry, No Row Has Been Seleted.");
            }
          }


    }
    
    
    
    public static void main(String[] args) {
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
    }

    
}
