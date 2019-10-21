package teamview;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GetScreen implements Runnable {
	int port = 6677;
	int frame = 15;
	ServerSocket ser;
	JPanel panel;
	Image image;
	boolean run = true;

	public GetScreen(JPanel jp, Image im) {
		try {
			System.out.println("start");
			panel = jp;
			image = im;
			ser = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("loi port");
			e.printStackTrace();
		}
	}

	public void run() {
		int sleep = 1000 / frame;
		try {
			while (run) {
				Socket s = ser.accept();
				//System.out.println("co ket noi");
				ObjectInputStream cObjectInputStream = new ObjectInputStream(s.getInputStream());
				{
					ImageIcon imageIcon = (ImageIcon) cObjectInputStream.readObject();
					image = imageIcon.getImage();
					image = image.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
					Graphics graphics = panel.getGraphics();
					graphics.drawImage(image, 0, 0, panel.getWidth(), panel.getHeight(), panel);
					graphics.dispose();
					try {
						Thread.sleep(sleep);
					} catch (Exception e) {
					}
				}
				cObjectInputStream.close();
				s.close();
				
			}

		} catch (Exception e) {
			System.out.println("loi soc ket");
			e.printStackTrace();
		}
	}

}