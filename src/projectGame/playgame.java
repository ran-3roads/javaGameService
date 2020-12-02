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

	static boolean lifesensor=false; //게임시작 버튼 눌러야 시
	static int lifecount= 3; // 목숨
	
	private JLabel imgLifeLabel1; // life이미지 1
	private JLabel imgLifeLabel2; // life이미지 2
	private JLabel imgLifeLabel3; // life이미지 3
	
	public void lifesave() { // 잘못눌렀을 경우 호출 함수
		lifecount--;
		
		if(lifecount==2) {
			imgLifeLabel3.setSize(0, 0);
		}
		else if(lifecount==1) {
			imgLifeLabel2.setSize(0, 0);
		}
		else if(lifecount==0) {
			imgLifeLabel1.setSize(0,0);
			Gameover end=new Gameover();
			end.start();
		}
	}
	
	private ImageIcon lifeicon = new ImageIcon("images/heart.png"); // life 이미지불러오기 
	private Image lifeimg = lifeicon.getImage();
	
	public playgame() {
		  Container gc = getContentPane();
		  gc.setLayout(null);
		  
		  
		  MyMouseAdapter cma = new MyMouseAdapter ();
		  JButton btn=new JButton("시작");
		  btn.addActionListener(new MyActionListener());
		  
		  a.addMouseListener(cma);
		  a.setLocation(10, 10);
		  a.setSize(300,300);
		  b.addMouseListener(cma);
		  b.setLocation(390, 10);
		  b.setSize(300,300);
		  
		  add(a);
		  add(b);
	      btn.setLocation(310, 370);
	      btn.setFont(new Font("Ariel", Font.PLAIN, 23));
	      btn.setSize(120, 45);
	      gc.add(btn);
		  // life 이미지 호
	      imgLifeLabel1 = new JLabel(lifeicon);
	      imgLifeLabel1.setLocation(10,370);
	      imgLifeLabel1.setSize(lifeimg.getWidth(imgLifeLabel1), lifeimg.getHeight(imgLifeLabel1)); // 거리 유지 
	      add(imgLifeLabel1);

	      imgLifeLabel2 = new JLabel(lifeicon);
	      imgLifeLabel2.setLocation(10+lifeimg.getWidth(imgLifeLabel1),370);
	      imgLifeLabel2.setSize(lifeimg.getWidth(imgLifeLabel2), lifeimg.getHeight(imgLifeLabel2)); // 거리 유지
	      add(imgLifeLabel2);

	      imgLifeLabel3 = new JLabel(lifeicon);
	      imgLifeLabel3.setLocation(10+2*lifeimg.getWidth(imgLifeLabel1),370);
	      imgLifeLabel3.setSize(lifeimg.getWidth(imgLifeLabel3), lifeimg.getHeight(imgLifeLabel3)); // 거리 유지 
	      add(imgLifeLabel3);
	      
		  setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		  setBounds(400, 400, 700, 450);
		  setVisible(true);
		 }

	public boolean isRangeof(int index, Point p){
		  //x -> pointX 
		  int pointX = p.x;
	      //y -> pointY
		  int pointY = p.y;
		  //배열순번과 좌표 입력 반환
		  return (pointX >= X[index]-range) && (pointX <= X[index]+range)
		    && (pointY >= Y[index]-range) && (pointY <= Y[index]+range);
		 }
	class MyMouseAdapter extends MouseAdapter{
		  public void mouseReleased(MouseEvent e) {
		   // 마우스 해당 좌표를 가져옴
		   Point p = e.getPoint();
		   if (isRangeof(0,p)&&lifesensor==true) { // lifesensor 가true 되어있어야 게임 진행가능 
		    image.locate[0] = true;
		    a.repaint();
		    b.repaint(); //양쪽 다 동그라미 repaint

		   } else if (isRangeof(1,p)&&lifesensor==true) {
		    image.locate[1] = true;
		    a.repaint();
		    b.repaint();

		   } else if (isRangeof(2,p)&&lifesensor==true) {
		    image.locate[2] = true;
		    a.repaint();
		    b.repaint();

		   } else if (isRangeof(3,p)&&lifesensor==true) {
		    image.locate[3] = true;
		    a.repaint();
		    b.repaint();

		   } else if (isRangeof(4,p)&&lifesensor==true) {
		    image.locate[4]= true;
		    a.repaint();
		    b.repaint();  
		   }else if(lifesensor==true){
			   lifesave();
			   a.repaint();
			   b.repaint(); 
		   }else if(lifesensor==false) {
			   JOptionPane.showMessageDialog(null, "시작버튼을 누르세요");
		   }
		
		   //클리어
		   if (image.locate[0] == true && image.locate[1] == true && image.locate[2] == true && image.locate[3] == true && image.locate[4] == true) {
		    JOptionPane.showMessageDialog(null, "축하드립니다!!");
		    for(int i=0;i<5;i++) {
		    	image.locate[i]=false;
		    }
		    lifesensor=false;
		    a.repaint();
		    b.repaint();
		    dispose();
		   }
		  }
		 }
	private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource(); 
			if(btn.getText().equals("시작")) { //hint 
				btn.setText("hint : 3회");
				JOptionPane.showMessageDialog(null, "게임 시작합니다!!");
				lifesensor=true; // 이게 true되어있어야 화면 터치가능
			}
			else if(btn.getText().equals("hint : 3회")) {
				btn.setText("hint : 2회");
				String ans = JOptionPane.showInputDialog("현재 그림에서 바다거북이가 해파리로 착각하고 무엇을 먹고 있을가요?" 
						+ " A: 해파리 B: 쓰레기봉투 C: 자바"); //퀴즈 구현
				if(ans.equals("쓰레기봉투")||ans.equals("B")||ans.equals("b")) {
					for(int i=0;i<5;i++) {
						if(image.locate[i]!=true) {
							image.locate[i]=true;
						    a.repaint();
						    b.repaint();
						    break;
						    }
						}
					}
				else
					JOptionPane.showMessageDialog(null, "땡!!");
				
				if (image.locate[0] == true && image.locate[1] == true && image.locate[2] == true && image.locate[3] == true && image.locate[4] == true) {
				    JOptionPane.showMessageDialog(null, "축하드립니다!!");
				    for(int i=0;i<5;i++) {
				    	image.locate[i]=false;
				    }
				    lifesensor=false;
				    a.repaint();
				    b.repaint();
				    dispose();
				   }
			}
			else if(btn.getText().equals("hint : 2회")) {
				btn.setText("hint : 1회");
				String ans = JOptionPane.showInputDialog("바다 속에 버려진 쓰레기들이 바람과 해류의 순환으로 한 곳에 모이여서 무엇이 형성되었을까요?"
						+ " A: 쓰레기섬 B: 보물섬 C: 학점");
				if(ans.equals("쓰레기섬")||ans.equals("A")||ans.equals("a")) {
					for(int i=0;i<5;i++) {
						if(image.locate[i]!=true) {
							image.locate[i]=true;
						    a.repaint();
						    b.repaint();
						    break;
						    }
						}
					}
				else
					JOptionPane.showMessageDialog(null, "땡!!");
				if (image.locate[0] == true && image.locate[1] == true && image.locate[2] == true && image.locate[3] == true && image.locate[4] == true) {
				    JOptionPane.showMessageDialog(null, "축하드립니다!!");
				    for(int i=0;i<5;i++) {
				    	image.locate[i]=false;
				    }
				    lifesensor=false;
				    a.repaint();
				    b.repaint();
				    dispose();
				   }
			}
			else if(btn.getText().equals("hint : 1회")) {
				btn.setText("hint : 0회");
				String ans = JOptionPane.showInputDialog("일회용 플라스틱 사용을 줄이고자 전세계적으로 실천중인 챌린지는?"
						+ " A: 아무노래 챌린지 B: 성찬 챌린지 C: 플라스틱 프리 챌린지");
				if(ans.equals("플라스틱 프리 챌린지")||ans.equals("C")||ans.equals("c")) {
					for(int i=0;i<5;i++) {
						if(image.locate[i]!=true) {
							image.locate[i]=true;
						    a.repaint();
						    b.repaint();
						    break;
						    }
						}
					}
				else
					JOptionPane.showMessageDialog(null, "땡!!");
				if (image.locate[0] == true && image.locate[1] == true && image.locate[2] == true && image.locate[3] == true && image.locate[4] == true) {
				    JOptionPane.showMessageDialog(null, "축하드립니다!!");
				    for(int i=0;i<5;i++) {
				    	image.locate[i]=false;
				    }
				    lifesensor=false;
				    a.repaint();
				    b.repaint();
				    dispose();
				   }
			}
			else if(btn.getText().equals("hint : 0회")) {
				JOptionPane.showMessageDialog(null, "남은 힌트가 없습니다!");
				
			}
			
		}
	}

	public class Gameover extends Thread{ // 게임종료쓰레드 
		JLabel gameover = new JLabel("끝!");
		public void run() { 
			try {
				gameover.setSize(400, 300);
		        gameover.setLocation(330, 100);
		        gameover.setForeground(Color.RED);
		        gameover.setFont(new Font("Ariel", Font.PLAIN, 50));
		        add(gameover);
		        sleep(2000);
		        lifesensor=false;
		        dispose();
				}
			catch(InterruptedException e) {
				return;
			}
	}
	
	}
	
}
