package caocong;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class Set extends JFrame{
	 private JButton shezhi ;
	 private JComboBox<String> cb1; 
	 private JComboBox<String> cb2; 
    public Set(){
        Init();
    }
  public void Init()
  {
	  setTitle("ͣ������ϵͳ���ý���");
      shezhi = new JButton("����");
      shezhi.setSize(60, 25);
      shezhi.setLocation(135, 260);
      cb1 = new JComboBox<String>(); 
      cb1.addItem("��"); 
	  cb1.addItem("���Сʱ���"); 
	  cb1.addItem("һСʱ3Ԫ"); 
	  cb1.setBounds(150,300, 150, 50);
	  
	  cb2= new JComboBox<String>();
	  cb2.addItem("��"); 
	  cb2.addItem("���Сʱ���"); 
	  cb2.addItem("һСʱ3Ԫ"); 
	  cb2.setBounds(300,300, 150, 50);
      this.add(shezhi);
      this.add(cb1);
      this.add(cb2);
      this.setLocation(1000,500);    
      this.setLayout(null);
      this.setSize(500, 400);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
      
  }
  public void actionPerformed(ActionEvent e) {
  
}
}