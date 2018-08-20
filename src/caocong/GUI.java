package caocong;
import java.awt.*;
import java.sql.SQLException;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener{
    private JLabel userLa;
    private JButton zhuce ;
    private	JButton about;
    private JLabel pwdLa;
    private JLabel verCodeLa;//��֤��
    private JTextField userTxt;
    private JPasswordField pwdTxt;
    private JTextField verCodeTxt;//��֤��
    private JButton sureBt;
    private JButton quitBt;
    private Mypanel mp;
    private JLabel j1;
    //���췽��
    public GUI(){
        Init();
    }
    public void Init(){
    	setTitle("ͣ������ϵͳ��¼����");
    	this.setIconImage(new ImageIcon("1.jpg").getImage());//����ͼ��
    	//��������
    	Music a =new Music();
        //���ñ��� 
    	j1 = new JLabel(); 
    	 Image img1 = new ImageIcon("2.jpg").getImage(); 
    	 j1.setIcon(new ImageIcon(img1)); 
    	 j1.setBounds(0, 0, 500, 350); 
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
        sureBt = new JButton("��¼");
        sureBt.setSize(60, 25);
        sureBt.setLocation(135, 260);

        //�˳���ť
        quitBt = new JButton("�˳�");
        quitBt.setSize(60, 25);
        quitBt.setLocation(240, 260);
       
        //ע�ᰴť
        zhuce = new JButton("ע��");
        zhuce.setSize(60, 25);
        zhuce.setLocation(240, 300);
        
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
        this.add(zhuce);
        this.add(about);
        this.add(verCodeLa);
        this.add(verCodeTxt);
        this.add(mp);
        this.add(j1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sureBt.addActionListener(this);
        quitBt.addActionListener(this);
        about.addActionListener(this);
        zhuce.addActionListener(this);
        this.setVisible(true);
        
    }
    
    
    
    //�����¼��Ĵ���
     public void actionPerformed(ActionEvent e){
         //��ȡ�����¼����¼�Դǿ��ת��
         JButton bt = (JButton)e.getSource();
         //��ȡ��ť����ʾ���ı�
         String str = bt.getText();
        if(str.equals("��¼")){
             if(!CheckIsNull()){
                 //��ȡ�û���������û���
                 String user = userTxt.getText().trim();//trim��ȥ����ͷ�ͽ�β�Ŀո�
                 //��ȡ�û������������
                 String pwd = pwdTxt.getText().trim();
                 try {
					if(checkUserAndPwd(user,pwd)){

					     //���ص�ǰ��¼����
					     this.setVisible(false);
					     //��֤�ɹ�����һ��������
					    SetParkUi frame = new SetParkUi();
					   
					 }
					 else{
					     //��������򵯳�һ����ʾ��
					     JOptionPane pane = new JOptionPane("�û����������");
					     JDialog dialog  = pane.createDialog(this,"����");
					     dialog.show();
					 }
				} catch (HeadlessException | SQLException e1) {
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
         
         if(str.equals("ע��")){
        	 Zhuce frame = new Zhuce();
        	 
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
     
     /* �ж������˺��Ƿ���ȷ
     	��һ������txt�����Ա�������  ���� ��������ȫ  ����mysql������ 
		������user������ݿ��б�����   user��id ��name ��password  
		������ѯ���Ϸ���Ŀǰ���ݿ��password�Ǿ�������ʵ��
		���ڱȽ��鷳����û�в������� ʹ�����Ľ��м���
		ϣ���ڿγ���ƽ������ټ���
		�ڶ��� ����жϵ�ʱ��  ʹ��if(user1==user)  ���ֲ���զ������ false
		����������  �����new������String�Ƚϱ���ʹ��equals���� 
		������Сbug  ����ÿ��ֻ�ܶ�ȡһ�������ʱ��  ����һ��˼·�����
		*/
     private boolean checkUserAndPwd(String user,String pwd) throws SQLException{
         boolean result = false;
         String password ;
        // String password;
         Jdbc j =new Jdbc();
         try {
        	 j.init();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         /*user1 =j.username();
         password = j.userpassword();
 		if(user1.equals(user)&&(password.equals(pwd))){								
         return true;
 		}*/
         password=j.userpassword(user);
         if(password.equals(pwd)){
        	 return true;
         }
 		
 		else {
        	return result;}
        }
     }

