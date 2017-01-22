package source;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Controller implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {

    static JFrame mainFrame;

    static Frame currentFrame;
    static Frame previousFrame;

    static JPanel myPanel;

    final static int DEFAULT_MOUSE_X = -1;
    final static int DEFAULT_MOUSE_Y = -1;

    int mouseClickX = DEFAULT_MOUSE_X;
    int mouseClickY = DEFAULT_MOUSE_Y;

    int mouseCursorX;
    int mouseCursorY;

    int counter = 0;

    boolean isMousePressed;
    boolean isFullScreen;
    boolean mouse;
    boolean unlocked;

    ImageLibrary imageLibrary;
    FrameStorage frameStorage;

    MouseEvent currentMousePosition;

    GraphicsEnvironment graphicsEnvironment;
    GraphicsDevice graphicsDevice;

    public Controller() {
        imageLibrary = new ImageLibrary();
        frameStorage = new FrameStorage();

        graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();

        currentFrame = FrameStorage.STARTINGSCREEN;

        mainFrame = new JFrame();

        myPanel = new RenderHandler(this);

        mainFrame.add(myPanel);
        myPanel.addMouseListener(this);
        myPanel.addMouseMotionListener(this);
        myPanel.addMouseWheelListener(this);
        mainFrame.addKeyListener(this);

        mainFrame.setExtendedState(JFrame.NORMAL);
        mainFrame.setUndecorated(isFullScreen);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        graphicsDevice.setFullScreenWindow(mainFrame);

        mainFrame.pack();
    }

    public void update() {
        this.updateMouseClick();
        this.updateFrame();
        this.updateMouseSprite();

        mainFrame.revalidate();
        mainFrame.repaint();

        counter++;
        if (counter > 100) {
            counter = 101;
        }

    }

    public void updateFrame() {

        Point mouseCursor = new Point(mouseCursorX, mouseCursorY);
        currentFrame.noHighlight();

        if (currentFrame.hasPoint(mouseCursor)) {
            TextBox text = currentFrame.getContainedTextBox(mouseCursor);
            text.highlight();
        }

        if (isMousePressed && unlocked) {
            Point mouseClick = new Point(mouseClickX, mouseClickY);
            this.resetMouse();
            if (currentFrame.hasPoint(mouseClick) && currentFrame.currentEmphasis == null) {

                TextBox text = currentFrame.getContainedTextBox(mouseClick);
                if (text.action == TextBoxAction.NEXTSCREEN)
                    this.changeFrame(text.nextScreen);
                else if (text.action == TextBoxAction.BLOWUPPICTURE)
                    currentFrame.placeEmphasis(text);

                return;
            }

            if (currentFrame.availibleArea != null) {
                if (currentFrame.availibleArea.contains(mouseClick)) {
                    currentFrame.placeEmphasis(null);
                }
            }
        }

    }

    public void changeFrame(Screen nextScreen) {
        if (nextScreen != null) {
            previousFrame = currentFrame;
            switch (nextScreen) {
                case STARTINGSCREEN:
                    currentFrame = FrameStorage.STARTINGSCREEN;
                    break;

                case INTERNSCREEN:
                    currentFrame = FrameStorage.INTERNSCREEN;
                    break;

                case WORKSHOPSCREEN:
                    currentFrame = FrameStorage.WORKSHOPSCREEN;
                    break;

                case SCREEN1:
                    currentFrame = FrameStorage.SCREEN1;
                    break;

                case SCREEN2:
                    currentFrame = FrameStorage.SCREEN2;
                    break;

                case SCREEN3:
                    currentFrame = FrameStorage.SCREEN3;
                    break;

                case SCREEN4:
                    currentFrame = FrameStorage.SCREEN4;
                    break;

                case SCREEN5:
                    currentFrame = FrameStorage.SCREEN5;
                    break;

                case SCREEN6:
                    currentFrame = FrameStorage.SCREEN6;
                    break;

                case SCREEN7:
                    currentFrame = FrameStorage.SCREEN7;
                    break;

                case SCREEN8:
                    currentFrame = FrameStorage.SCREEN8;
                    break;

                case SCREEN9:
                    currentFrame = FrameStorage.SCREEN9;
                    break;
                case SCREEN10:
                    currentFrame = FrameStorage.SCREEN10;
                    break;

                case SCREEN11:
                    currentFrame = FrameStorage.SCREEN11;
                    break;

                case SCREEN12:
                    currentFrame = FrameStorage.SCREEN12;
                    break;

                case SCREEN13:
                    currentFrame = FrameStorage.SCREEN13;
                    break;

                case SCREEN14:
                    currentFrame = FrameStorage.SCREEN14;
                    break;

                case SCREEN15:
                    currentFrame = FrameStorage.SCREEN15;
                    break;

                case SCREEN16:
                    currentFrame = FrameStorage.SCREEN16;
                    break;

                case SCREEN17:
                    currentFrame = FrameStorage.SCREEN17;
                    break;
            }
        }
    }


    public void updateMouseSprite() {
        Point mousePoint = new Point(mouseCursorX, mouseCursorY);

        int currentCursor = Cursor.DEFAULT_CURSOR;

        if (currentFrame.hasPoint(mousePoint)) {
            currentCursor = Cursor.HAND_CURSOR;
        }

        if (currentFrame.currentEmphasis != null && currentFrame.availibleArea != null && currentFrame.availibleArea.contains(mousePoint)) {
            currentCursor = Cursor.HAND_CURSOR;
        }
        myPanel.setCursor(new Cursor(currentCursor));
    }

    public void updateMouseClick() {

        if (isMousePressed)
            unlocked = false;
        else unlocked = true;

        if (mouse) {
            isMousePressed = true;
        } else {
            isMousePressed = false;
            this.resetMouse();
        }
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        Timer timer = new Timer();
        timer.tick(controller);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(e.getY());
        currentMousePosition = e;
        mouse = true;

        mouseClickX = e.getX();
        mouseClickY = e.getY();

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        mouse = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        currentFrame.offSet(currentMousePosition.getY() - e.getY());

        mouseClickX = e.getX();
        mouseClickY = e.getY();

        currentMousePosition = e;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println(e.getX() + "," + e.getY());
        mouseCursorX = e.getX();
        mouseCursorY = e.getY();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        currentFrame.offSet(20 * e.getScrollAmount() * e.getWheelRotation());
    }

    public void resetMouse() {
        this.mouseClickX = DEFAULT_MOUSE_X;
        this.mouseClickY = DEFAULT_MOUSE_Y;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_F11 && counter > 100) {
            counter = 0;
            if (isFullScreen) {
                isFullScreen = false;
            } else isFullScreen = true;

            mainFrame.dispose();
            mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            mainFrame.setUndecorated(isFullScreen);

            graphicsDevice.setFullScreenWindow(mainFrame);

        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (currentFrame.currentEmphasis != null)
                currentFrame.placeEmphasis(null);
            else if (previousFrame != null)
                currentFrame = previousFrame;

        }

        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if (currentFrame.currentEmphasis != null)
                currentFrame.placeEmphasis(null);
            else if (previousFrame != null)
                currentFrame = previousFrame;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
