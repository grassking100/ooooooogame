import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class T04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new T04().main();
	}
	int X=1000;
	int Y=500;
	
	JButton [] jButtons;
	
	void main(){
		jButtons=new JButton[8];
		JFrame frame=new JFrame();
		H h=new H(frame);
		for(int i=0;i<jButtons.length;i++){
			jButtons[i]=new JButton((i+2)+"");
			
			jButtons[i].addMouseListener(h);;
		}
		
		frame.setSize(X, Y);
		//JTextArea textArea=new JTextArea();
		
		JPanel panel=new JPanel();
		panel.setLayout(new FlowLayout(0,0,0));
		//panel.setPreferredSize(new Dimension(X, Y/10));
		panel.add(jButtons[7]);
		panel.add(jButtons[6]);
		//frame.add(textArea, BorderLayout.CENTER);
		frame.add(new Image());
		frame.add(panel,BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel pp=new JPanel();
		
		pp.setLayout(new BoxLayout(pp, BoxLayout.Y_AXIS));
		
		for(int i=0;i<3;i++)p2.add(jButtons[i]);
		for(int i=3;i<6;i++)p3.add(jButtons[i]);
		pp.add(p2);
		pp.add(p3);
		panel.add(pp);
		int tmpx=X;
		for(int i=6;i<=7;i++){
			jButtons[i].setPreferredSize(new Dimension(X/3, Y/6));
			tmpx-=X/3;
			tmpx-=X/3;
		}
		pp.setPreferredSize(new Dimension(X/3-15, Y/6));
		
		frame.setVisible(true);
		
	}
	
	String drawstr="0";
	
	class Image extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			Dimension dimension=getSize();
			
			g.setColor(Color.GREEN);
			for(int i=0;i<dimension.
					getWidth();i++){
				for(int j=0;j<dimension.getHeight();j++){
					g.drawRect(i, j, 1, 1);
				}
			}
			g.setColor(Color.BLACK);
			g.setFont(new Font(null, 0, 50));
			g.drawString(drawstr, 100, 100);
			
			
			try {
				BufferedImage img=ImageIO.read(new File("C:\\Users\\ASUS\\Desktop\\Taiwan.jpg"));
				g.drawImage(img,0,0,X,Y,null);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			g.setColor(Color.BLACK);
			g.setFont(new Font(null, 0, 50));
			g.drawString(drawstr, 100, 100);
			
			
			//g.setColor(Color.BLACK);
			//g.drawOval(0, 0, 100, 100);
		}
	}
	
	class H extends MouseAdapter{
		JFrame frame;
		H(JFrame frame){
			this.frame=frame;
		}
		
		public void mouseEntered0(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseEntered(e);
			System.out.println("aaa");
			JButton b=(JButton)e.getComponent();
			drawstr=b.getText();
			frame.repaint();
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseClicked(e);
			JButton b=(JButton)e.getComponent();
			drawstr="screen "+b.getText()+": mouse click";
			frame.repaint();
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseReleased(e);
			JButton b=(JButton)e.getComponent();
			drawstr="screen "+b.getText()+": mouse release";
			frame.repaint();
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mousePressed(e);
			JButton b=(JButton)e.getComponent();
			drawstr="screen "+b.getText()+": mouse press";
			frame.repaint();
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseDragged(e);
			JButton b=(JButton)e.getComponent();
			drawstr="screen "+b.getText()+": mouse drag";
			frame.repaint();
		}
	}
}
