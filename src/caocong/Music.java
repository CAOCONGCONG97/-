package caocong;

 import java.applet.AudioClip; 
import java.io.*; 
import java.applet.Applet;
import java.net.URI;
import java.net.URL;
import javax.swing.JFrame;
public class Music extends JFrame{ 
   File f;
   URI uri;
   URL url; 
 Music(){  
   try {      
       f = new File("1.wav"); 
       uri = f.toURI();
       url = uri.toURL();  //������ַ
       AudioClip aau; 
       aau = Applet.newAudioClip(url);
       aau.loop();  //ѭ������
   } catch (Exception e) 
   { e.printStackTrace();
   } 
 }

 }