package source;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.Exchanger;

public class FrameStorage {

    /**
     * This class stores the Frames that will be used. Each frame takes in a
     * Screen from the enum class Screen, and an array of TextBoxes the TextBox
     * constructor is TextBox(int x, int y, int width, int height, image image,
     * text text, Screen screen) The image is the sprite that you want to use
     */
    
	
	/* 
	 * If you want to add a new font, use the sting parameter, but be sure to add Font= before you put your font. No spaces.
	 */
    public static Frame STARTINGSCREEN;
    public static Frame INTERNSCREEN;
    public static Frame WORKSHOPSCREEN;
    public static Frame SCREEN1;
    public static Frame SCREEN2;
    public static Frame SCREEN3;
    public static Frame SCREEN4;
    public static Frame SCREEN5;
    public static Frame SCREEN6;
    public static Frame SCREEN7;
    public static Frame SCREEN8;
    public static Frame SCREEN9;
    public static Frame SCREEN10;
    public static Frame SCREEN11;
    public static Frame SCREEN12;
    public static Frame SCREEN13;
    public static Frame SCREEN14;
    public static Frame SCREEN15;
    public static Frame SCREEN16;
    public static Frame SCREEN17;

    String[] stringStorage;
    Scanner scanner;
    //File file = new File("/Text.txt");

    public static final int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

    public FrameStorage() {

        stringStorage = new String[100];
        try {
            scanner = new Scanner(this.getClass().getResourceAsStream("/Text.txt"));
            //scanner = new Scanner(file);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        int i =0;

        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            if(!line.startsWith("/"))
            {
                stringStorage[i] = line;
                System.out.println(line);
            }
            i++;
        }

        STARTINGSCREEN = new Frame(Screen.STARTINGSCREEN, ImageLibrary.DEFAULTSCREENPIC1,
                new TextBox[]{new TextBox((screenWidth/2)-200, (screenHeight/2)-200, 400, 50, null, stringStorage[0], null, "Font=TimesRoman,Size=50", true),
                        new TextBox((screenWidth/2) - 190, (screenHeight/2) - 140, 200, 25, null, stringStorage[1], Screen.INTERNSCREEN, "Font=TimesRoman,Size=20", true),
                        new TextBox((screenWidth/2) + 35, (screenHeight/2) - 140, 150, 25, null, stringStorage[2], Screen.WORKSHOPSCREEN, "Font=TimesRoman,Size=20", true)});

        INTERNSCREEN = new Frame(Screen.INTERNSCREEN, ImageLibrary.DEFAULTSCREENPIC1,
                new TextBox[]{new TextBox((screenWidth - 600)/2, (screenHeight/2), 100, 100, ImageLibrary.Java1s, ImageLibrary.Java1s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - 600)/2 + 200, (screenHeight/2), 400, 400, null, stringStorage[18], null, "Font=TimesRoman,Size=20", false),
                        new TextBox((screenWidth - 600)/2 +500, (screenHeight/2) + 400, 100, 100, ImageLibrary.Java1s, ImageLibrary.Java1s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - 600)/2, (screenHeight/2) + 400, 400, 500, null, stringStorage[19], null, "Font=TimesRoman,Size=20", false),
                        new TextBox((screenWidth - 600)/2, (screenHeight/2) + 1000, 100, 100, ImageLibrary.Java1s, ImageLibrary.Java1s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - 600)/2 + 200, (screenHeight/2) + 1000, 400, 200, null, stringStorage[20], null, "Font=TimesRoman,Size=20", false),
                        new TextBox((screenWidth - 600)/2 + 500, (screenHeight/2) + 1600, 100, 100, ImageLibrary.Java1s, ImageLibrary.Java1s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - 600)/2, (screenHeight/2) + 1600, 400, 200, null, stringStorage[21], null, "Font=TimesRoman,Size=20", false),
            new TextBox(screenWidth - 75, 0, 75, 25, null, "Home", Screen.STARTINGSCREEN, "Font=TimesRoman,Size=20", true)});

        WORKSHOPSCREEN = new Frame(Screen.WORKSHOPSCREEN, ImageLibrary.DEFAULTSCREENPIC1,
                new TextBox[]{new TextBox(screenWidth/2 - 200, screenHeight/2 - 450, 400, 50, null, "   Workshops", null, "Font=TimesRoman,Size=48", true),
                              new TextBox((screenWidth - (2*100) - 2*300)/2, (screenHeight - (3*100) - 400)/2, 120, 100, null, stringStorage[3], Screen.SCREEN1, "Font=TimesRoman,Size=20", true),
                              new TextBox((screenWidth - (2*100) - 2*100)/2, (screenHeight - (3*100) - 400)/2, 120, 100, null, stringStorage[4], Screen.SCREEN2, "Font=TimesRoman,Size=20", true),
                              new TextBox((screenWidth - (2*100) + 2*100)/2, (screenHeight - (3*100) - 400)/2, 120, 100, null, stringStorage[5], Screen.SCREEN3, "Font=TimesRoman,Size=20", true),
                              new TextBox((screenWidth - (2*100) + 2*300)/2, (screenHeight - (3*100) - 400)/2, 120, 100, null, stringStorage[6], Screen.SCREEN4, "Font=TimesRoman,Size=20", true),
                              new TextBox((screenWidth - (2*100) - 2*300)/2, (screenHeight - (3*100) - 150)/2, 120, 100, null, stringStorage[7], Screen.SCREEN5, "Font=TimesRoman,Size=20", true),
                              new TextBox((screenWidth - (2*100) - 2*100)/2, (screenHeight - (3*100) - 150)/2, 120, 100, null, stringStorage[8], Screen.SCREEN6, "Font=TimesRoman,Size=20", true),
                              new TextBox((screenWidth - (2*100) + 2*100)/2, (screenHeight - (3*100) - 150)/2, 120, 100, null, stringStorage[9], Screen.SCREEN7, "Font=TimesRoman,Size=20", true),
                              new TextBox((screenWidth - (2*100) + 2*300)/2, (screenHeight - (3*100) - 150)/2, 120, 100, null, stringStorage[10], Screen.SCREEN8, "Font=TimesRoman,Size=20", true),
                              new TextBox((screenWidth - (2*100) - 2*300)/2, (screenHeight - (3*100) + 150)/2, 120, 100, null, stringStorage[11], Screen.SCREEN9, "Font=TimesRoman,Size=20", true),
                              new TextBox((screenWidth - (2*100) - 2*100)/2, (screenHeight - (3*100) + 150)/2, 120, 100, null, stringStorage[12], Screen.SCREEN10, "Font=TimesRoman,Size=20", true),
                              new TextBox((screenWidth - (2*100) + 2*100)/2, (screenHeight - (3*100) + 150)/2, 120, 100, null, stringStorage[13], Screen.SCREEN11, "Font=TimesRoman,Size=20", true),
                              new TextBox((screenWidth - (2*100) + 2*300)/2, (screenHeight - (3*100) + 150)/2, 120, 100, null, stringStorage[14], Screen.SCREEN12, "Font=TimesRoman,Size=20", true),
                              new TextBox((screenWidth - (2*100) - 2*300)/2, (screenHeight - (3*100) + 400)/2, 120, 100, null, stringStorage[15], Screen.SCREEN13, "Font=TimesRoman,Size=20", true),
                              new TextBox((screenWidth - (2*100) - 2*100)/2, (screenHeight - (3*100) + 400)/2, 120, 100, null, stringStorage[16], Screen.SCREEN14, "Font=TimesRoman,Size=20", true),
                              new TextBox((screenWidth - (2*100) + 2*100)/2, (screenHeight - (3*100) + 400)/2, 120, 100, null, stringStorage[17], Screen.SCREEN15, "Font=TimesRoman,Size=20", true),
                              new TextBox(screenWidth - 75, 0, 75, 25, null, "Home", Screen.STARTINGSCREEN, "Font=TimesRoman,Size=20", true)});


        SCREEN1 = new Frame(Screen.SCREEN1, ImageLibrary.DEFAULTSCREENPIC1,
                new TextBox[]{new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, null, ImageLibrary.Java1s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, new TextBox(0,0,1000, 1000, ImageLibrary.Java1, null, "Font=TimesRoman",Color.RED)),
                              new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, null, ImageLibrary.Java2s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, null, ImageLibrary.Java3s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, null, ImageLibrary.Java4s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 100)/2, 100, 100, null, ImageLibrary.Java5s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, null, ImageLibrary.Java6s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox(screenWidth - 125, 0, 125, 25, null, "Workshops", Screen.WORKSHOPSCREEN, "Font=TimesRoman,Size=20", true)});

        SCREEN2 = new Frame(Screen.SCREEN2, ImageLibrary.DEFAULTSCREENPIC1,
                new TextBox[]{new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.app1s, ImageLibrary.app1s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.app2s, ImageLibrary.app2s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.app3s, ImageLibrary.app3s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.app4s, ImageLibrary.app4s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.app5s, ImageLibrary.app5s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.app6s, ImageLibrary.app6s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.app7s, ImageLibrary.app7s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.app8s, ImageLibrary.app8s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.app9s, ImageLibrary.app9s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.app10s, ImageLibrary.app10s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.app11s, ImageLibrary.app11s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.app12s, ImageLibrary.app12s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 800)/2, 100, 100, ImageLibrary.app13s, ImageLibrary.app13s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 800)/2, 100, 100, ImageLibrary.app14s, ImageLibrary.app14s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
            new TextBox(screenWidth - 125, 0, 125, 25, null, "Workshops", Screen.WORKSHOPSCREEN, "Font=TimesRoman,Size=20", true)});

        SCREEN3 = new Frame(Screen.SCREEN3, ImageLibrary.DEFAULTSCREENPIC1,
                new TextBox[]{new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.pro1s, ImageLibrary.pro1s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.pro2s, ImageLibrary.pro2s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.pro3s, ImageLibrary.pro3s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.pro4s, ImageLibrary.pro4s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.pro5s, ImageLibrary.pro5s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.pro6s, ImageLibrary.pro6s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.pro7s, ImageLibrary.pro7s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.pro8s, ImageLibrary.pro8s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.pro9s, ImageLibrary.pro9s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.pro10s, ImageLibrary.pro10s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.pro11s, ImageLibrary.pro11s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.pro12s, ImageLibrary.pro12s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 800)/2, 100, 100, ImageLibrary.pro13s, ImageLibrary.pro13s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 800)/2, 100, 100, ImageLibrary.pro14s, ImageLibrary.pro14s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
            new TextBox(screenWidth - 125, 0, 125, 25, null, "Workshops", Screen.WORKSHOPSCREEN, "Font=TimesRoman,Size=20", true)});

        SCREEN4 = new Frame(Screen.SCREEN4, ImageLibrary.DEFAULTSCREENPIC1,
                new TextBox[]{new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Scratch1s, ImageLibrary.Scratch1s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Scratch2s, ImageLibrary.Scratch2s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Scratch3s, ImageLibrary.Scratch3s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.Scratch4s, ImageLibrary.Scratch4s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.Scratch5s, ImageLibrary.Scratch5s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.Scratch6s, ImageLibrary.Scratch6s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
            new TextBox(screenWidth - 125, 0, 125, 25, null, "Workshops", Screen.WORKSHOPSCREEN, "Font=TimesRoman,Size=20", true)});

        SCREEN5 = new Frame(Screen.SCREEN5, ImageLibrary.DEFAULTSCREENPIC1,
                new TextBox[]{new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Code1s, ImageLibrary.Code1s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Code2s, ImageLibrary.Code2s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Code3s, ImageLibrary.Code3s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.Code4s, ImageLibrary.Code4s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.Code5s, ImageLibrary.Code5s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.Code6s, ImageLibrary.Code6s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
            new TextBox(screenWidth - 125, 0, 125, 25, null, "Workshops", Screen.WORKSHOPSCREEN, "Font=TimesRoman,Size=20", true)});

        SCREEN6 = new Frame(Screen.SCREEN6, ImageLibrary.DEFAULTSCREENPIC1,
                new TextBox[]{new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Biomes1s, ImageLibrary.Biomes1s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Biomes2s, ImageLibrary.Biomes2s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Biomes3s, ImageLibrary.Biomes3s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
            new TextBox(screenWidth - 125, 0, 125, 25, null, "Workshops", Screen.WORKSHOPSCREEN, "Font=TimesRoman,Size=20", true)});

        SCREEN7 = new Frame(Screen.SCREEN7, ImageLibrary.DEFAULTSCREENPIC1,
                new TextBox[]{new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Photo1s, ImageLibrary.Photo1s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Photo2s, ImageLibrary.Photo2s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Photo3s, ImageLibrary.Photo3s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.Photo4s, ImageLibrary.Photo4s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.Photo5s, ImageLibrary.Photo5s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.Photo6s, ImageLibrary.Photo6s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.Photo7s, ImageLibrary.Photo7s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.Photo8s, ImageLibrary.Photo8s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.Photo9s, ImageLibrary.Photo9s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.Photo10s, ImageLibrary.Photo10s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.Photo11s, ImageLibrary.Photo11s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.Photo12s, ImageLibrary.Photo12s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 800)/2, 100, 100, ImageLibrary.Photo13s, ImageLibrary.Photo13s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 800)/2, 100, 100, ImageLibrary.Photo14s, ImageLibrary.Photo14s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 800)/2, 100, 100, ImageLibrary.Photo15s, ImageLibrary.Photo15s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox(screenWidth - 125, 0, 125, 25, null, "Workshops", Screen.WORKSHOPSCREEN, "Font=TimesRoman,Size=20", true)});

        SCREEN8 = new Frame(Screen.SCREEN8, ImageLibrary.DEFAULTSCREENPIC1,
                new TextBox[]{new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Skateboard1s, ImageLibrary.Skateboard1s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Skateboard2s, ImageLibrary.Skateboard2s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Skateboard3s, ImageLibrary.Skateboard3s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.Skateboard4s, ImageLibrary.Skateboard4s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.Skateboard5s, ImageLibrary.Skateboard5s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.Skateboard6s, ImageLibrary.Skateboard6s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.Skateboard7s, ImageLibrary.Skateboard7s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.Skateboard8s, ImageLibrary.Skateboard8s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.Skateboard9s, ImageLibrary.Skateboard9s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.Skateboard10s, ImageLibrary.Skateboard10s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.Skateboard11s, ImageLibrary.Skateboard11s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.Skateboard12s, ImageLibrary.Skateboard12s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 800)/2, 100, 100, ImageLibrary.Skateboard13s, ImageLibrary.Skateboard13s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 800)/2, 100, 100, ImageLibrary.Skateboard14s, ImageLibrary.Skateboard14s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 800)/2, 100, 100, ImageLibrary.Skateboard15s, ImageLibrary.Skateboard15s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 1100)/2, 100, 100, ImageLibrary.Skateboard16s, ImageLibrary.Skateboard16s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 1100)/2, 100, 100, ImageLibrary.Skateboard17s, ImageLibrary.Skateboard17s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 1100)/2, 100, 100, ImageLibrary.Skateboard18s, ImageLibrary.Skateboard18s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 1400)/2, 100, 100, ImageLibrary.Skateboard19s, ImageLibrary.Skateboard19s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 1400)/2, 100, 100, ImageLibrary.Skateboard20s, ImageLibrary.Skateboard20s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 1400)/2, 100, 100, ImageLibrary.Skateboard21s, ImageLibrary.Skateboard21s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 1700)/2, 100, 100, ImageLibrary.Skateboard22s, ImageLibrary.Skateboard22s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 1700)/2, 100, 100, ImageLibrary.Skateboard23s, ImageLibrary.Skateboard23s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 1700)/2, 100, 100, ImageLibrary.Skateboard24s, ImageLibrary.Skateboard24s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 2000)/2, 100, 100, ImageLibrary.Skateboard25s, ImageLibrary.Skateboard25s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 2000)/2, 100, 100, ImageLibrary.Skateboard26s, ImageLibrary.Skateboard26s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 2000)/2, 100, 100, ImageLibrary.Skateboard27s, ImageLibrary.Skateboard27s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 2300)/2, 100, 100, ImageLibrary.Skateboard28s, ImageLibrary.Skateboard28s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 2300)/2, 100, 100, ImageLibrary.Skateboard29s, ImageLibrary.Skateboard29s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 2300)/2, 100, 100, ImageLibrary.Skateboard30s, ImageLibrary.Skateboard30s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 2600)/2, 100, 100, ImageLibrary.Skateboard31s, ImageLibrary.Skateboard31s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 2600)/2, 100, 100, ImageLibrary.Skateboard32s, ImageLibrary.Skateboard32s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 2600)/2, 100, 100, ImageLibrary.Skateboard33s, ImageLibrary.Skateboard33s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 2900)/2, 100, 100, ImageLibrary.Skateboard34s, ImageLibrary.Skateboard34s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 2900)/2, 100, 100, ImageLibrary.Skateboard35s, ImageLibrary.Skateboard35s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 2900)/2, 100, 100, ImageLibrary.Skateboard36s, ImageLibrary.Skateboard36s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 3200)/2, 100, 100, ImageLibrary.Skateboard37s, ImageLibrary.Skateboard37s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 3200)/2, 100, 100, ImageLibrary.Skateboard38s, ImageLibrary.Skateboard38s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 3200)/2, 100, 100, ImageLibrary.Skateboard39s, ImageLibrary.Skateboard39s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox(screenWidth - 125, 0, 125, 25, null, "Workshops", Screen.WORKSHOPSCREEN, "Font=TimesRoman,Size=20", true)});

        SCREEN9 = new Frame(Screen.SCREEN9, ImageLibrary.DEFAULTSCREENPIC1,
                new TextBox[]{new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.ROV1s, ImageLibrary.ROV1s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.ROV2s, ImageLibrary.ROV2s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.ROV3s, ImageLibrary.ROV3s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.ROV4s, ImageLibrary.ROV4s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.ROV5s, ImageLibrary.ROV5s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.ROV6s, ImageLibrary.ROV6s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.ROV7s, ImageLibrary.ROV7s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.ROV8s, ImageLibrary.ROV8s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.ROV9s, ImageLibrary.ROV9s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.ROV10s, ImageLibrary.ROV10s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.ROV11s, ImageLibrary.ROV11s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.ROV12s, ImageLibrary.ROV12s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 800)/2, 100, 100, ImageLibrary.ROV13s, ImageLibrary.ROV13s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 800)/2, 100, 100, ImageLibrary.ROV14s, ImageLibrary.ROV14s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 800)/2, 100, 100, ImageLibrary.ROV15s, ImageLibrary.ROV15s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 1100)/2, 100, 100, ImageLibrary.ROV16s, ImageLibrary.ROV16s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 1100)/2, 100, 100, ImageLibrary.ROV17s, ImageLibrary.ROV17s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 1100)/2, 100, 100, ImageLibrary.ROV18s, ImageLibrary.ROV18s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 1400)/2, 100, 100, ImageLibrary.ROV19s, ImageLibrary.ROV19s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 1400)/2, 100, 100, ImageLibrary.ROV20s, ImageLibrary.ROV20s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 1400)/2, 100, 100, ImageLibrary.ROV21s, ImageLibrary.ROV21s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 1700)/2, 100, 100, ImageLibrary.ROV22s, ImageLibrary.ROV22s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 1700)/2, 100, 100, ImageLibrary.ROV23s, ImageLibrary.ROV23s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 1700)/2, 100, 100, ImageLibrary.ROV24s, ImageLibrary.ROV24s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 2000)/2, 100, 100, ImageLibrary.ROV25s, ImageLibrary.ROV25s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 2000)/2, 100, 100, ImageLibrary.ROV26s, ImageLibrary.ROV26s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 2000)/2, 100, 100, ImageLibrary.ROV27s, ImageLibrary.ROV27s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 2300)/2, 100, 100, ImageLibrary.ROV28s, ImageLibrary.ROV28s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 2300)/2, 100, 100, ImageLibrary.ROV29s, ImageLibrary.ROV29s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 2300)/2, 100, 100, ImageLibrary.ROV30s, ImageLibrary.ROV30s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 2600)/2, 100, 100, ImageLibrary.ROV31s, ImageLibrary.ROV31s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 2600)/2, 100, 100, ImageLibrary.ROV32s, ImageLibrary.ROV32s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 2600)/2, 100, 100, ImageLibrary.ROV33s, ImageLibrary.ROV33s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 2900)/2, 100, 100, ImageLibrary.ROV34s, ImageLibrary.ROV34s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 2900)/2, 100, 100, ImageLibrary.ROV35s, ImageLibrary.ROV35s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 2900)/2, 100, 100, ImageLibrary.ROV36s, ImageLibrary.ROV36s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox(screenWidth - 125, 0, 125, 25, null, "Workshops", Screen.WORKSHOPSCREEN, "Font=TimesRoman,Size=20", true)});

        SCREEN10 = new Frame(Screen.SCREEN10, ImageLibrary.DEFAULTSCREENPIC1,
                new TextBox[]{new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robo1s, ImageLibrary.Robo1s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robo2s, ImageLibrary.Robo2s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robo3s, ImageLibrary.Robo3s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.Robo4s, ImageLibrary.Robo4s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.Robo5s, ImageLibrary.Robo5s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.Robo6s, ImageLibrary.Robo6s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.Robo7s, ImageLibrary.Robo7s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.Robo8s, ImageLibrary.Robo8s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.Robo9s, ImageLibrary.Robo9s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.Robo10s, ImageLibrary.Robo10s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.Robo11s, ImageLibrary.Robo11s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.Robo12s, ImageLibrary.Robo12s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 800)/2, 100, 100, ImageLibrary.Robo13s, ImageLibrary.Robo13s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 800)/2, 100, 100, ImageLibrary.Robo14s, ImageLibrary.Robo14s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 800)/2, 100, 100, ImageLibrary.Robo15s, ImageLibrary.Robo15s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 1100)/2, 100, 100, ImageLibrary.Robo16s, ImageLibrary.Robo16s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 1100)/2, 100, 100, ImageLibrary.Robo17s, ImageLibrary.Robo17s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 1100)/2, 100, 100, ImageLibrary.Robo18s, ImageLibrary.Robo18s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox(screenWidth - 125, 0, 125, 25, null, "Workshops", Screen.WORKSHOPSCREEN, "Font=TimesRoman,Size=20", true)});

        SCREEN11 = new Frame(Screen.SCREEN11, ImageLibrary.DEFAULTSCREENPIC1,
                new TextBox[]{new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.ScratchW1s, ImageLibrary.ScratchW1s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.ScratchW2s, ImageLibrary.ScratchW2s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.ScratchW3s, ImageLibrary.ScratchW3s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.ScratchW4s, ImageLibrary.ScratchW4s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.ScratchW5s, ImageLibrary.ScratchW5s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.ScratchW6s, ImageLibrary.ScratchW6s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.ScratchW7s, ImageLibrary.ScratchW7s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.ScratchW8s, ImageLibrary.ScratchW8s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.ScratchW9s, ImageLibrary.ScratchW9s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.ScratchW10s, ImageLibrary.ScratchW10s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.ScratchW11s, ImageLibrary.ScratchW11s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox(screenWidth - 125, 0, 125, 25, null, "Workshops", Screen.WORKSHOPSCREEN, "Font=TimesRoman,Size=20", true)});

        SCREEN12 = new Frame(Screen.SCREEN12, ImageLibrary.DEFAULTSCREENPIC1,
                new TextBox[]{new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Math1s, ImageLibrary.Math1s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Math2s, ImageLibrary.Math2s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Math3s, ImageLibrary.Math3s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox(screenWidth - 125, 0, 125, 25, null, "Workshops", Screen.WORKSHOPSCREEN, "Font=TimesRoman,Size=20", true)});

        SCREEN13 = new Frame(Screen.SCREEN13, ImageLibrary.DEFAULTSCREENPIC1,
                new TextBox[]{new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Art1s, ImageLibrary.Art1s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Art2s, ImageLibrary.Art2s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Art3s, ImageLibrary.Art3s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.Art4s, ImageLibrary.Art4s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.Art5s, ImageLibrary.Art5s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.Art6s, ImageLibrary.Art6s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox(screenWidth - 125, 0, 125, 25, null, "Workshops", Screen.WORKSHOPSCREEN, "Font=TimesRoman,Size=20", true)});

        SCREEN14 = new Frame(Screen.SCREEN14, ImageLibrary.DEFAULTSCREENPIC1,
                new TextBox[]{new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot1s, ImageLibrary.Robot1s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot2s, ImageLibrary.Robot2s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot3s, ImageLibrary.Robot3s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.Robot4s, ImageLibrary.Robot4s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.Robot5s, ImageLibrary.Robot5s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.Robot6s, ImageLibrary.Robot6s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.Robot7s, ImageLibrary.Robot7s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.Robot8s, ImageLibrary.Robot8s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.Robot9s, ImageLibrary.Robot9s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.Robot10s, ImageLibrary.Robot10s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.Robot11s, ImageLibrary.Robot11s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 500)/2, 100, 100, ImageLibrary.Robot12s, ImageLibrary.Robot12s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 800)/2, 100, 100, ImageLibrary.Robot13s, ImageLibrary.Robot13s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 800)/2, 100, 100, ImageLibrary.Robot14s, ImageLibrary.Robot14s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 800)/2, 100, 100, ImageLibrary.Robot15s, ImageLibrary.Robot15s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 1100)/2, 100, 100, ImageLibrary.Robot16s, ImageLibrary.Robot16s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 1100)/2, 100, 100, ImageLibrary.Robot17s, ImageLibrary.Robot17s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 1100)/2, 100, 100, ImageLibrary.Robot18s, ImageLibrary.Robot18s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 1400)/2, 100, 100, ImageLibrary.Robot19s, ImageLibrary.Robot19s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 1400)/2, 100, 100, ImageLibrary.Robot20s, ImageLibrary.Robot20s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 1400)/2, 100, 100, ImageLibrary.Robot21s, ImageLibrary.Robot21s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 1700)/2, 100, 100, ImageLibrary.Robot22s, ImageLibrary.Robot22s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 1700)/2, 100, 100, ImageLibrary.Robot23s, ImageLibrary.Robot23s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 1700)/2, 100, 100, ImageLibrary.Robot24s, ImageLibrary.Robot24s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 2000)/2, 100, 100, ImageLibrary.Robot25s, ImageLibrary.Robot25s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 2000)/2, 100, 100, ImageLibrary.Robot26s, ImageLibrary.Robot26s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 2000)/2, 100, 100, ImageLibrary.Robot27s, ImageLibrary.Robot27s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 2300)/2, 100, 100, ImageLibrary.Robot28s, ImageLibrary.Robot28s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 2300)/2, 100, 100, ImageLibrary.Robot29s, ImageLibrary.Robot29s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 2300)/2, 100, 100, ImageLibrary.Robot30s, ImageLibrary.Robot30s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 2600)/2, 100, 100, ImageLibrary.Robot31s, ImageLibrary.Robot31s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 2600)/2, 100, 100, ImageLibrary.Robot32s, ImageLibrary.Robot32s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 2600)/2, 100, 100, ImageLibrary.Robot33s, ImageLibrary.Robot33s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 2900)/2, 100, 100, ImageLibrary.Robot34s, ImageLibrary.Robot34s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 2900)/2, 100, 100, ImageLibrary.Robot35s, ImageLibrary.Robot35s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 2900)/2, 100, 100, ImageLibrary.Robot36s, ImageLibrary.Robot36s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 3200)/2, 100, 100, ImageLibrary.Robot37s, ImageLibrary.Robot37s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 3200)/2, 100, 100, ImageLibrary.Robot38s, ImageLibrary.Robot38s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) + 3200)/2, 100, 100, ImageLibrary.Robot39s, ImageLibrary.Robot39s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot40s, ImageLibrary.Robot40s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot41s, ImageLibrary.Robot41s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot42s, ImageLibrary.Robot42s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot43s, ImageLibrary.Robot43s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot44s, ImageLibrary.Robot44s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot45s, ImageLibrary.Robot45s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot46s, ImageLibrary.Robot46s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot47s, ImageLibrary.Robot47s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot48s, ImageLibrary.Robot48s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot49s, ImageLibrary.Robot49s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot50s, ImageLibrary.Robot50s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot51s, ImageLibrary.Robot51s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot52s, ImageLibrary.Robot52s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot53s, ImageLibrary.Robot53s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot54s, ImageLibrary.Robot54s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot55s, ImageLibrary.Robot55s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot56s, ImageLibrary.Robot56s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot57s, ImageLibrary.Robot57s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot58s, ImageLibrary.Robot58s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot59s, ImageLibrary.Robot59s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot60s, ImageLibrary.Robot60s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot61s, ImageLibrary.Robot61s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot62s, ImageLibrary.Robot62s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot63s, ImageLibrary.Robot63s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot64s, ImageLibrary.Robot64s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot65s, ImageLibrary.Robot65s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.Robot66s, ImageLibrary.Robot66s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox(screenWidth - 125, 0, 125, 25, null, "Workshops", Screen.WORKSHOPSCREEN, "Font=TimesRoman,Size=20", true)});

        SCREEN15 = new Frame(Screen.SCREEN15, ImageLibrary.DEFAULTSCREENPIC1,
                new TextBox[]{new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.AppW1s, ImageLibrary.AppW1s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.AppW2s, ImageLibrary.AppW2s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 400)/2, 100, 100, ImageLibrary.AppW3s, ImageLibrary.AppW3s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.AppW4s, ImageLibrary.AppW4s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.AppW5s, ImageLibrary.AppW5s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) + 2*200)/2, (screenHeight - (2*100) - 100)/2, 100, 100, ImageLibrary.AppW6s, ImageLibrary.AppW6s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*200)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.AppW7s, ImageLibrary.AppW7s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                        new TextBox((screenWidth - (3*100) - 2*0)/2, (screenHeight - (2*100) + 200)/2, 100, 100, ImageLibrary.AppW8s, ImageLibrary.AppW8s, null, null, "Font=TimesRoman", TextBoxAction.BLOWUPPICTURE, null),
                              new TextBox(screenWidth - 125, 0, 125, 25, null, "Workshops", Screen.WORKSHOPSCREEN, "Font=TimesRoman,Size=20", true)});


    }
}
