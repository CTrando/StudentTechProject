package source;

import java.awt.*;
import java.awt.geom.Area;

public class Frame {

	Screen screen;
	TextBox[] textBoxes;
	
	boolean canScrollUp;
	
	Point absoluteHeight;

	Image backgroundImage;

	Area availibleArea;

	TextBox currentEmphasis;
	//perhaps parent child structure?

	static int screenWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	static int screenHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();

	FrameMode currentMode;

	public Frame(Screen screen, TextBox[] textBoxes) {
		this.screen = screen;
		this.textBoxes = textBoxes;
		this.backgroundImage = ImageLibrary.DEFAULTSCREENPIC2;
		currentMode = FrameMode.DEFAULT;

		absoluteHeight = new Point(0,0);
	}

	public Frame(Screen screen, Image backgroundImage, TextBox[] textBoxes) {
		this.screen = screen;
		this.textBoxes = textBoxes;
		this.backgroundImage = backgroundImage;
		currentMode = FrameMode.DEFAULT;


		absoluteHeight = new Point(0,0);
	}

	public void render(Graphics g) {
		g.drawImage(this.backgroundImage, 0, 0, null);

		//supposed to be for the logo
		g.setColor(Color.BLACK);
		g.fillRect(0,0, 100, 100);

		//if(emphasis != null)
		// draw textBox picture and make everything else dim

		for (int i = 0; i < textBoxes.length; i++) {
			textBoxes[i].render(g);
		}

		if(currentEmphasis != null)
		{
			currentEmphasis.renderEmphasis(g);
			availibleArea = currentEmphasis.screenArea;
		}
	}

	public boolean hasPoint(Point p) {
		for (int i = 0; i < textBoxes.length; i++) {
			if (textBoxes[i].hasPoint(p)) {
				return true;
			}
		}
		return false;
	}

	public TextBox getContainedTextBox(Point p) {
		for (int i = 0; i < textBoxes.length; i++) {
			if (textBoxes[i].contains(p)) {
				return textBoxes[i];
			}
		}
		return null;
	}
	
	public void offSet(int offSet)
	{
		if((int)absoluteHeight.getY() - offSet <= 0) {

			absoluteHeight.setLocation(0, (int) absoluteHeight.getY() - offSet);

			for (int i = 0; i < textBoxes.length; i++) {
				textBoxes[i].setBounds((int) textBoxes[i].getX(), (int) (textBoxes[i].getY() - offSet), (int) (textBoxes[i].getWidth()), (int) (textBoxes[i].getHeight()));
			}
		}
	}

	public void noHighlight()
	{
		for (int i = 0; i < textBoxes.length; i++) {
			textBoxes[i].noHighlight();
		}
	}

	public void placeEmphasis(TextBox textBox)
	{
		currentEmphasis = textBox;
		if(currentEmphasis != null)
			currentMode = FrameMode.BLOWUPMODE;
		else currentMode = FrameMode.DEFAULT;

	}

}
