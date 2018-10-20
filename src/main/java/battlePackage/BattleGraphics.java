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

public class BattleGraphics extends JPanel{
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	private GridBagConstraints constraints;
	 
    BattleGraphics() {
    	//Get Image
    	try {
			this.image = ImageIO.read(new File("win.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

    	//Set up JPanel
    	this.setBackground(Color.BLACK);
        this.setOpaque(true);
        this.setLayout(new GridBagLayout());
        this.constraints = new GridBagConstraints();
        this.constraints.insets = new Insets(5,5,5,5);
        this.constraints.weightx = 1.0;
        this.constraints.weighty = 1.0;
    }
 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw image centered.
        int x = (getWidth() - this.image.getWidth())/2;
        int y = (getHeight() - this.image.getHeight())/2;
        g.drawImage(this.image, x, y, this);
    }
}
