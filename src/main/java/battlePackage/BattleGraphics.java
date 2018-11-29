package battlePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BattleGraphics extends JPanel {
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	private GridBagConstraints constraints;
	private String fileName = null;

	public BattleGraphics(String result) throws IOException{
		// Get Result type
		if (result.equals("win")) {
			this.fileName = "win.png";

		} else if (result.equals("retreat")) {
			this.fileName = "retreat.png";
		} else {
			this.fileName = "lose.png";
		}

		// Get Image
		//java.net.URL imageURL = BattleGraphics.class.getResource(fileName);
		
		this.image = ImageIO.read(new File(this.fileName));
		//this.image = (BufferedImage) imageURL.getContent();
		

		// Set Up JPanel
		this.setBackground(Color.BLACK);
		this.setOpaque(true);
		this.setLayout(new GridBagLayout());
		this.constraints = new GridBagConstraints();
		this.constraints.insets = new Insets(5, 5, 5, 5);
		this.constraints.weightx = 1.0;
		this.constraints.weighty = 1.0;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Draw Image
		int x = (getWidth() - this.image.getWidth()) / 2;
		int y = (getHeight() - this.image.getHeight()) / 2;
		g.drawImage(this.image, x, y, this);
	}
}
