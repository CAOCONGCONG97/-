package caocong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SetParkUi extends JFrame  implements ActionListener{
    private JButton carinto ;
    private	JButton about;
    private	JButton info;
    private	JButton set;
    public SetParkUi(){
        Init();
    }
  public void Init()
  {
	  setTitle("ͣ������ϵͳ����");
	  //�������밴ť
	  carinto = new JButton("��������");
	  carinto.setSize(250,50);
	  carinto.setLocation(125, 30);
	  
	  //����
      set = new JButton("��������");
      set.setSize(250,50);
      set.setLocation(125, 100);
	  
      info = new JButton("��Ϣ��ѯ");
      info.setSize(250,50);
      info.setLocation(125, 170);
	  
      about= new JButton("����");
      about.setSize(250,50);
      about.setLocation(125, 240);
      
      this.add(carinto);
      this.add(about);
      this.add(info);
      this.add(set);
      
      this.setLocation(1000,500);    
      this.setLayout(null);
      this.setSize(500, 400);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      about.addActionListener(this);
      this.setVisible(true);
      
  }
@Override
public void actionPerformed(ActionEvent e) {
    JButton bt = (JButton)e.getSource();
    //��ȡ��ť����ʾ���ı�
    String str = bt.getText();
	// TODO Auto-generated method stub
    if(str.equals("����")){
    	
  	  /*JDialog dialogabout = new JDialog(this,true);
  	  dialogabout.setTitle("����");*/
  	 JOptionPane.showMessageDialog(null, "�������������1602,ͣ������ϵͳ-�γ����.", "����",JOptionPane.PLAIN_MESSAGE);
   }
    if(str.equals("��������")){
    	//
    }
}
}
