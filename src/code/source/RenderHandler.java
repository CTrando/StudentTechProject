package source;

import java.awt.*;

import javax.swing.JPanel;

public class RenderHandler extends JPanel {

	public Controller controller;

	public RenderHandler(Controller controller) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(screenSize);
		this.controller = controller;
	}

	/*
	 * Add more cases to the switch statement underneath this to test for more
	 * screens and render more stuff
	 * 
	 * there is a long chain of render(Graphics g) methods that eventually leads
	 * to the textbox render method
	 */

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (controller.currentFrame != null) {
			controller.currentFrame.render(g); // render controller isBlownUp
		}
	}
	}


