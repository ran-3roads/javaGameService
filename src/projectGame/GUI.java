package projectGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame {
	private InStage isp= new InStage();
	private JMenuBar mb = new JMenuBar();
	private GUI mainFrame = this;

	
	public GUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Save the Animal 틀린그림찾기");
		
		setSize(700,600);
		setLayout(null);
		
		setContentPane(isp);

		isp.button1.addActionListener(new ActionListener() { // gamestart
			@Override
			 public void actionPerformed(ActionEvent e) {
				new playgame();

             }
	      });
		
	    JMenu screenrestart = new JMenu("MENU");

	    mb.add(screenrestart);

	    JMenuItem mi = new JMenuItem("New Game");
	    screenrestart.add(mi);

	    JMenuItem ex = new JMenuItem("exit");
	    screenrestart.add(ex);
	    mi.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	setContentPane(isp);
	        setSize(700, 600);
	        }
	      });

	    ex.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	        System.exit(0);
	        }
	      });
	    setJMenuBar(mb);
	    setVisible(true);
	    }

}
