package projectGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class playgame extends JFrame {	
	private ImageIcon []animal = { 
			new ImageIcon("images/sea1.jpg"),
			new ImageIcon("images/sea2.jpg"),
	};
	Image img0=animal[0].getImage();
	Image img1=animal[1].getImage();
	Image Cimg0=img0.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
	Image Cimg1=img1.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
	ImageIcon Cicon0 = new ImageIcon(Cimg0);
	ImageIcon Cicon1 = new ImageIcon(Cimg1);

	final image a = new image(Cicon0);
	final image b = new image(Cicon1);
	//틀린 좌표값과 범위
	static int[] X = {17,250,110,128,185};
	static int[] Y = {193,298,50,103,68};
	static final int range = 15;
	
	public playgame() {

		  MyMouseAdapter cma = new MyMouseAdapter ();
		  a.addMouseListener(cma);
		  b.addMouseListener(cma);
		 
		  add(a, BorderLayout.WEST);
		  add(b, BorderLayout.EAST);
		  setDefaultCloseOperation(EXIT_ON_CLOSE);
		  setBounds(300, 300, 700, 350);
		  setVisible(true);
		 }

	public boolean isRangeof(int index, Point p){
		  //포인트 X좌표를 입력받아 pointX로 저장
		  int pointX = p.x;
		  //포인트 Y좌표를 입력받아 pointX로 저장
		  int pointY = p.y;
		  //배열순번과 해당좌표를 입력해 반환
		  return (pointX >= X[index]-range) && (pointX <= X[index]+range)
		    && (pointY >= Y[index]-range) && (pointY <= Y[index]+range);
		 }//isRangeof()
	class MyMouseAdapter extends MouseAdapter{
		  public void mouseReleased(MouseEvent e) {
		   // 마우스클릭한 곳의 x,y좌표값을 얻어와 Point 객체를 생성
		   Point p = e.getPoint();
		   if (isRangeof(0,p)) {
		    image.locate1 = true; //
		    a.repaint();
		    b.repaint(); //양쪽모두 동그라미 표시를 위한 repaint

		   } else if (isRangeof(1,p)) {
		    image.locate2 = true;
		    a.repaint();
		    b.repaint();

		   } else if (isRangeof(2,p)) {
		    image.locate3 = true;
		    a.repaint();
		    b.repaint();

		   } else if (isRangeof(3,p)) {
		    image.locate4 = true;
		    a.repaint();
		    b.repaint();

		   } else if (isRangeof(4,p)) {
		    image.locate5 = true;
		    a.repaint();
		    b.repaint();
		    
		   }
		
		   //클리어
		   if (image.locate1 == true && image.locate2 == true && image.locate3 == true && image.locate4 == true && image.locate5 == true) {
		    JOptionPane.showMessageDialog(null, "축하드립니다!!");
		    image.locate1 = false;
		    image.locate2 = false;
		    image.locate3 = false;
		    image.locate4 = false;
		    image.locate5 = false;
		    a.repaint();
		    b.repaint();
		   }
		  }// mouseReleased()
		 }
}
