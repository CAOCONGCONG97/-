package caocong;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
public class Zhuce extends JFrame implements ActionListener {
	  private JLabel userLa;
	    private	JButton about;
	    private JLabel pwdLa;
	    private JLabel verCodeLa;//��֤��
	    private JTextField userTxt;
	    private JPasswordField pwdTxt;
	    private JTextField verCodeTxt;//��֤��
	    private JButton sureBt;
	    private JButton quitBt;
	    private Mypanel mp;
	    public Zhuce(){
	        Init();
	    }
	    public void Init(){
	    	setTitle("��ӭ����ע�����");
	        //���ñ��� 

	        //�û��ı�
	        userLa = new JLabel();
	        userLa.setText("�û�����");
	        userLa.setSize(60, 50);
	        userLa.setLocation(100, 80);
	 
	        //�����ı�
	        pwdLa = new JLabel();
	        pwdLa.setText("���룺");
	        pwdLa.setSize(50, 50);
	        pwdLa.setLocation(100, 120);

	        //�û������
	        userTxt = new JTextField();
	        userTxt.setSize(100, 20);
	        //this.setSize(width, height)
	        userTxt.setLocation(170, 95);

	        //���������
	        pwdTxt = new JPasswordField();
	        pwdTxt.setSize(100, 20);
	        pwdTxt.setLocation(170, 135);

	        //ȷ�ϰ�ť
	        sureBt = new JButton("�ύ");
	        sureBt.setSize(60, 25);
	        sureBt.setLocation(135, 260);

	        //�˳���ť
	        quitBt = new JButton("�˳�");
	        quitBt.setSize(60, 25);
	        quitBt.setLocation(240, 260);
	       
	     
	        
	        //���ڰ�ť
	        about = new JButton("����");
	        about.setSize(60,25);
	        about.setLocation(135,300);
	        
	        //��֤���ı�
	        verCodeLa = new JLabel();
	        verCodeLa.setText("��֤�룺");
	        verCodeLa.setSize(60, 50);
	        verCodeLa.setLocation(100,165);

	        //��֤���ı���
	        verCodeTxt = new JTextField();
	        verCodeTxt.setSize(100, 20);
	        verCodeTxt.setLocation(170, 180);

	        //��֤��
	        mp = new Mypanel();
	        mp.setSize(100, 30);
	        mp.setLocation(280, 175);




	        this.setLocation(1000,500);    
	        this.setLayout(null);
	        this.setSize(500, 400);
	        this.add(userLa);
	        this.add(pwdLa);
	        this.add(userTxt);
	        this.add(pwdTxt);
	        this.add(sureBt);
	        this.add(quitBt);
	        this.add(about);
	        this.add(verCodeLa);
	        this.add(verCodeTxt);
	        this.add(mp);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        sureBt.addActionListener(this);
	        quitBt.addActionListener(this);
	        about.addActionListener(this);
	        this.setVisible(true);
	        
	    }
	    
	    public void actionPerformed(ActionEvent e){
	         //��ȡ�����¼����¼�Դǿ��ת��
	         JButton bt = (JButton)e.getSource();
	         //��ȡ��ť����ʾ���ı�
	         String str = bt.getText();
	        if(str.equals("�ύ")){
	             if(!CheckIsNull()){
	                 //��ȡ�û���������û���
	                 String user = userTxt.getText().trim();//trim��ȥ����ͷ�ͽ�β�Ŀո�
	                 //��ȡ�û������������
	                 String pwd = pwdTxt.getText().trim();
	                 Jdbc q =new Jdbc();
	                 try {
						q.init();
						q.addUser(pwd, user);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                 
					}
	             }
	         
	        
	        
	         if(str.equals("����")){
	        	  /*JDialog dialogabout = new JDialog(this,true);
	        	  dialogabout.setTitle("����");*/
	        	 JOptionPane.showMessageDialog(null, "�������������1602,ͣ������ϵͳ-�γ����.", "����",JOptionPane.PLAIN_MESSAGE);
	         }
	         
	        
	         
	         if(str.equals("�˳�")) {
	             //����ϵͳ���е�һ�������˳�
	             System.exit(0);
	         }
	     }
	     
	     //�ж��Ƿ�Ϊ��
	     private boolean CheckIsNull() {
	         boolean flag = false;
	         if(userTxt.getText().trim().equals(" ")){
	             flag = true;
	         }
	         else{
	             if(pwdTxt.getText().trim().equals(" ")){
	                 flag = true;
	             }
	         }
	         return flag;
	     }
	     
	    
}
