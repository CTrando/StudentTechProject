package source;

import java.awt.*;
import java.awt.geom.Area;

public class TextBox extends Rectangle {

    private String text;
    private Image smallImage;
    private Image bigImage;
    private int yOffset;

    private int x;
    private int y;
    private int width;
    private int height;
    public Screen nextScreen;

    Color textColor;

    TextBoxAction action;
    Area screenArea;

    Font font;

    boolean isHighlighted;
    boolean canBeHighlighted;

    TextBox whenClicked;

    Color backgroundColor;

    int counter = 0;

    public TextBox(int x, int y, int width, int height, Image smallImage, String text, Screen nextScreen, String font, boolean canBeHighlighted) {
        super(x, y, width, height);
        this.smallImage = smallImage;
        if (this.smallImage != null)
            this.smallImage = this.smallImage.getScaledInstance(width, height, Image.SCALE_FAST);

        this.text = text;

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.nextScreen = nextScreen;
        this.action = TextBoxAction.NEXTSCREEN;
        this.whenClicked = null;

        int size = 40;
        String myFont = Font.SANS_SERIF;
        if (font.indexOf(",") == -1) {
            if (font.startsWith("Font=")) {
                myFont = font.substring(5, font.length());
            }
            size = 40;
        } else if (font.indexOf(",") != -1) {
            if (font.startsWith("Font=")) {
                myFont = font.substring(5, font.indexOf(","));
            }
            String sizeString = font.substring(font.indexOf(",") + 1, font.length());
            if (sizeString.startsWith("Size=")) {
                sizeString = sizeString.substring(5, sizeString.length());
                size = Integer.parseInt(sizeString);
            }
        }
        this.font = new Font(myFont, Font.BOLD, size);
        this.canBeHighlighted = canBeHighlighted;
    }


    public TextBox(int x, int y, Image smallImage, String text, Screen nextScreen, String font, TextBox whenClicked) {
        super(x, y, smallImage.getWidth(null), smallImage.getHeight(null));
        this.smallImage = smallImage.getScaledInstance(width, height, Image.SCALE_FAST);
        this.text = text;

        this.x = x;
        this.y = y;
        this.nextScreen = nextScreen;
        this.width = smallImage.getWidth(null);
        this.height = smallImage.getHeight(null);

        if (font.startsWith("Font=")) {
            String myFont = font.substring(5, font.length());//font.indexOf(","));
            this.font = new Font(myFont, Font.PLAIN, 40);
        }

        this.whenClicked = whenClicked;
        canBeHighlighted = true;
    }

    public TextBox(int x, int y, int width, int height, Image bigImage, Image smallImage, String text, Screen nextScreen, String font, TextBoxAction action, TextBox whenClicked) {
        this(x, y, width, height, smallImage, text, nextScreen, font, true);
        this.action = action;
        this.bigImage = bigImage;
        this.whenClicked = whenClicked;
        canBeHighlighted = true;
    }

    public TextBox(int x, int y, int width, int height, Image smallImage, String text, String font, Color backgroundColor)
    {
        this(x,y,width,height,smallImage,text,null,font, false);
        this.backgroundColor = backgroundColor;
        this.canBeHighlighted = false;
    }

    public void render(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.setColor(Color.WHITE);

        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);

        //textColor = isHighlighted?Color.BLACK:Color.WHITE;
        if(this.backgroundColor != null) {
            graphics2D.setColor(this.backgroundColor);
            graphics2D.fillRect((int) this.getX(), (int) this.getY(), (int) this.getWidth(), (int) this.getHeight());

        }
        if(canBeHighlighted && isHighlighted)
        {
            if(counter <255) {
                counter+=15;
            }
            else counter = 255;

            Color highlight = new Color(counter, counter, counter, counter);
            graphics2D.setColor(highlight);
            //graphics2D.fillRect((int) this.getX(), (int) this.getY(), (int) this.getWidth(), (int) this.getHeight());
            textColor = new Color(255-counter, 255-counter, 255-counter);
        }
        else{
            counter = 0;
            textColor = Color.WHITE;
        }

        yOffset = 0;
        if (smallImage != null) {
            graphics2D.drawImage(smallImage, (int) this.getX(), (int) this.getY(), null);
        }
        if (text != null) {
            graphics2D.setColor(textColor);
            graphics2D.setFont(font);
            FontMetrics measuredFont = graphics2D.getFontMetrics(font);
            yOffset += measuredFont.getAscent();
            this.formatString(measuredFont, text, graphics2D);
        }
        graphics2D.setColor(Color.WHITE);
  //      graphics2D.drawRect((int) this.getX(), (int) this.getY(), (int) this.getWidth(), (int) this.getHeight());

        graphics2D.setColor(Color.white);
    }

    public void formatString(FontMetrics measuredFont, String string, Graphics g) {
        boolean center = true;
        int xOffset = 0;

        String textToBePrinted = "";
        String[] textSplit = string.split(" ");
        int counter = 0;
        String temp = "";

        while (measuredFont.stringWidth(temp) < (int) this.getWidth()) {
            temp += textSplit[counter] + " ";
            if (measuredFont.stringWidth(temp) < (int) this.getWidth()) {
                textToBePrinted += textSplit[counter] + " ";
                textSplit[counter] = " ";
                counter++;
            }

            if (counter > textSplit.length - 1)
                break;
        }

        //need to include enumeration type here instead of boolean
        if(center)
        {
            xOffset = Math.abs(measuredFont.stringWidth(textToBePrinted) - (int) this.getWidth())/2;
        }

        g.drawString(textToBePrinted, (int) this.getX() + xOffset, (int) this.getY() + yOffset);

        if (counter < textSplit.length) {
            StringBuilder myStringBuilder = new StringBuilder();

            for (String stringChar : textSplit) {
                if (!stringChar.equals(" "))
                    myStringBuilder.append(stringChar + " ");
            }

            String nextText = myStringBuilder.toString();

            if (nextText.equals(string)) {
                if (nextText.indexOf(" ") != -1) {
                    nextText = nextText.substring(0, nextText.indexOf(" ") / 2) + " " + nextText.substring(nextText.indexOf(" ") / 2, nextText.length());
                } else
                    nextText = nextText.substring(0, nextText.length() / 2) + " " + nextText.substring(nextText.length() / 2, nextText.length());
            }
            if (textToBePrinted.length() > 0)
                yOffset += measuredFont.getAscent();
            this.formatString(measuredFont, nextText, g);
        }
    }


    public boolean hasPoint(Point p) {
        if (this.contains(p)) {
            return true;
        }
        return false;
    }

    public void renderEmphasis(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);

        screenArea = new Area(new Rectangle(0, 0, Frame.screenWidth, Frame.screenHeight));
        graphics2D.setColor(new Color(0, 0, 0, 192));
        graphics2D.fill(screenArea);

        Area imageArea = new Area(new Rectangle(100, 100, 400, 400));
        screenArea.subtract(imageArea);

        //graphics.drawImage(bigImage.getScaledInstance(400, 400, Image.SCALE_FAST), 100, 100, null);
        if(whenClicked != null) {
            if(whenClicked.backgroundColor != null)
                graphics.setColor(whenClicked.backgroundColor);
            whenClicked.render(graphics);
            screenArea.subtract(new Area(new Rectangle((int)whenClicked.getX(), (int)whenClicked.getY(), (int)whenClicked.getWidth(), (int)whenClicked.getHeight())));
        }

    }

    public void highlight()
    {
        isHighlighted = true;
    }

    public void noHighlight()
    {
        isHighlighted = false;
    }
}
