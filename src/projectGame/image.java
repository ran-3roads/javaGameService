package projectGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class image extends JPanel{
	
	private JLabel img;
	static boolean[] locate = {false, false, false,false,false};
	
	public image(ImageIcon a) {
		img = new JLabel(a);
		add(img);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		  // 동그라미 빨강색
		g.setColor(Color.RED);
		  // 틀린부분에 동그라미
		if (locate[0] == true) {
			g.drawOval(7, 180, 40, 40); //등딱지 
			}
		if (locate[1] == true) {
			g.drawOval(240, 285, 30, 30);// 오른쪽 땅
		  }
		if (locate[2] == true) {
		    g.drawOval(100, 30, 50, 50);  //팔
		  }
		if (locate[3] == true) {
		    g.drawOval(118, 90, 50, 50); // 볼따구
		  }
		if (locate[4] == true) {
		    g.drawOval(175, 55, 50, 50);// 해파리
		  }
		 }
}
