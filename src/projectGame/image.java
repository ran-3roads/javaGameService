package projectGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class image extends JPanel{
	
	private JLabel img;
	
	static boolean locate1 = false;
	static boolean locate2 = false;
	static boolean locate3 = false;
	static boolean locate4 = false;
	static boolean locate5 = false;
	public image(ImageIcon a) {
		img = new JLabel(a);
		add(img);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		  // 동그라미 색깔 빨강으로 표시
		g.setColor(Color.RED);
		  // 틀린그림부분에 동그라미 그리기
		if (locate1 == true) {
			g.drawOval(7, 180, 40, 40); //등딱지 
			}
		if (locate2 == true) {
			g.drawOval(240, 285, 30, 30);// 오른쪽 땅
		  }
		if (locate3 == true) {
		    g.drawOval(100, 30, 50, 50);  //팔
		  }
		if (locate4 == true) {
		    g.drawOval(118, 90, 50, 50); // 볼따구
		  }
		if (locate5 == true) {
		    g.drawOval(175, 55, 50, 50);// 해파리
		  }
		 }
}
