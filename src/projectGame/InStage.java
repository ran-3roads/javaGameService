package projectGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InStage extends JPanel{
	private JLabel label;
	public JButton button1;
	public JButton button2;
	
	private ImageIcon icon = new ImageIcon("images/main.jpg");
	private Image img = icon.getImage();
	
	public InStage() {
		setLayout(null);
		
		label = new JLabel("환경보호 틀린그림찾기");
	    label.setLocation(100, 100);
	    label.setSize(500, 50);
	    label.setFont(new Font("Ariel", Font.BOLD, 40));
	    add(label);
	    
	    label = new JLabel("1771102 박성찬");
	    label.setLocation(400, 150);
	    label.setSize(450, 40);
	    label.setFont(new Font("Ariel", Font.PLAIN, 20));
	    add(label);
	    
	    button1 = new JButton("GameStart");
	    button1.setLocation(200, 350);
	    button1.setFont(new Font("Ariel", Font.PLAIN, 30));
	    button1.setSize(200, 45);
	    button1.setContentAreaFilled(false);
	    button1.setBorderPainted(false);
	    button1.setFocusPainted(false);
	    button1.addMouseListener(new MouseAdapter() {
	    	public void mouseEntered(MouseEvent e) {
	    		button1.setBorderPainted(true);
	    		}
	    	public void mouseExited(MouseEvent e) {
	    		button1.setBorderPainted(false);
	    		}
	    	});
	    
	    add(button1);
	    
	    
	    button2 = new JButton("Exit");
	    button2.setLocation(200, 395);
	    button2.setFont(new Font("Ariel", Font.PLAIN, 30));
	    button2.setSize(200, 45);
	    button2.setContentAreaFilled(false);
	    button2.setBorderPainted(false);
	    button2.setFocusPainted(false);
	    button2.addMouseListener(new MouseAdapter() {
	    	public void mouseEntered(MouseEvent e) {
	    		button2.setBorderPainted(true);
	    		}
	    	public void mouseExited(MouseEvent e) {
	            button2.setBorderPainted(false);
	            }
	      });
	    button2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		System.exit(0);
	    		}
	      });
	    add(button2);
	    
	}
	
	   public void paintComponent(Graphics g) { // 배경화면
		      super.paintComponent(g);
		      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		   }
}
