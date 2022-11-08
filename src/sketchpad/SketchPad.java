package sketchpad;

import buttons.*;
import tools.*;

public class SketchPad {
    private final Screen screen = new Screen();
    private final MouseInfo mouseInfo = new MouseInfo();
    private final PaintingTool paint = new PaintingTool();

    // TODO 2.1 add variables for the last coordinates
    private int lastMouseX;
    private int lastMouseY;

    // TODO 5
    // private buttons.Button clearButton = new buttons.Button(5, 5, 20, tools.Color.WHITE, this);

    // TODO 6
    private SquareButton clearButton = new ClearButton(5, 5, 20, Color.WHITE);
//    private buttons.PenColorButton colorButton1 = new buttons.PenColorButton(50, 5, 20, tools.Color.RED);
//    private buttons.PenColorButton colorButton2 = new buttons.PenColorButton(70, 5, 20, tools.Color.BLUE);

    // TODO 7
    private SquareButton[] penColorButtons = new PenColorButton[24];

    public void initialLaunch() {
        // TODO 0.1 Change the background color
        screen.setBackgroundColor(Color.LIGHT_GRAY);

        // TODO 0.2 Identify the corners
        paint.setFillColor(Color.RED);
        paint.drawCircle(0, 0, 20);

        paint.setFillColor(Color.GREEN);
        paint.drawCircle(0, 400, 20);

        paint.setFillColor(Color.BLUE);
        paint.drawCircle(600, 0, 20);

        paint.setFillColor(Color.MAGENTA);
        paint.drawCircle(600, 400, 20);

        // TODO 4.1 Generate a few random circles
        // int x = tools.Generator.randomInt(600);
        // int y = tools.Generator.randomInt(400);
        // int radius = tools.Generator.randomInt(10, 30);
        // int r = tools.Generator.randomInt(255);
        // int g = tools.Generator.randomInt(255);
        // int b = tools.Generator.randomInt(255);
        // paint.setFillColor(r, g, b);
        // paint.drawCircle(x, y, radius);


        // TODO 4.2 Generate many random circles
        for (int circleNumber = 0; circleNumber < 500; circleNumber++) {
            // This should be a random circle generator method...
            int x = Generator.randomInt(600);
            int y = Generator.randomInt(400);
            int radius = Generator.randomInt(10, 30);
            int r = Generator.randomInt(255);
            int g = Generator.randomInt(255);
            int b = Generator.randomInt(255);
            paint.setFillColor(r, g, b);
            paint.drawCircle(x, y, radius);
        }


        // TODO 0.3 Draw an interior surface
        paint.setFillColor(Color.WHITE);
        paint.drawRect(30, 30, 540, 340);

        // TODO 5
        clearButton.drawSelf();

        // TODO 6
//        colorButton1.drawSelf();
//        colorButton2.drawSelf();

        // TODO 7
        int startX = screen.getWidth() / 2 - penColorButtons.length / 2 * 20;
        penColorButtons[0] = new PenColorButton(startX, 5, 20, Color.BLACK);
        penColorButtons[0].drawSelf();
        for (int i = 1; i < penColorButtons.length; i++) {
            float hue = 1f / penColorButtons.length * i;
            penColorButtons[i] = new PenColorButton(i * 20 + startX, 5, 20, new Color(hue));
            penColorButtons[i].drawSelf();
        }
    }

    public void update() {
//        // TODO 1.1 Draw a line anywhere
//        paint.setLineColor(tools.Color.CYAN);
//        // paint.drawLine(0, 0, 600, 400);
//
//        // TODO 1.2 Generate random color values from 0 to 255 for red, green, and blue lines.
//        paint.setLineColor(
//                tools.Generator.randomInt(255),
//                tools.Generator.randomInt(255),
//                tools.Generator.randomInt(255)
//        );

        // TODO 1.3 Use the x and y coordinates of the mouse
        // paint.drawLine(mouseInfo.getX(), mouseInfo.getY(), 0, 0);

        // TODO 1.4 Use the very center of the screen
        // paint.drawLine(mouseInfo.getX(), mouseInfo.getY(), 300, 200);

        // TODO 1.5 Use the center of the screen without using the actual coordinates
        // paint.drawLine(mouseInfo.getX(), mouseInfo.getY(), screen.getWidth() / 2, screen.getHeight() / 2);

        // TODO 2.2 Use the current and last locations of the mouse to draw the lines
        // paint.drawLine(mouseInfo.getX(), mouseInfo.getY(), lastMouseX, lastMouseY);

        // TODO 2.3 Update the last location values of the mouse
        // lastMouseX = mouseInfo.getX();
        // lastMouseY = mouseInfo.getY();

        // TODO 3.1 Update lastMouseX and lastMouseY when the mouse is pressed
        if (mouseInfo.isMousePressed()) {
            lastMouseX = mouseInfo.getX();
            lastMouseY = mouseInfo.getY();
        }

        // TODO 3.2 Restrict the drawing to only when the mouse is dragged
        // if (mouseInfo.isMouseDragged()) {
        //    paint.drawLine(mouseInfo.getX(), mouseInfo.getY(), lastMouseX, lastMouseY);
        //    lastMouseX = mouseInfo.getX();
        //    lastMouseY = mouseInfo.getY();
        // }

        // TODO 3.3 Restrict the drawing to only when the mouse is dragged and inside the border
        if (mouseInfo.isMouseDragged() &&
            mouseInfo.getX() >= 30 &&
            mouseInfo.getX() <= 570 &&
            mouseInfo.getY() >= 30 &&
            mouseInfo.getY() <= 370) {

            paint.drawLine(mouseInfo.getX(), mouseInfo.getY(), lastMouseX, lastMouseY);
            lastMouseX = mouseInfo.getX();
            lastMouseY = mouseInfo.getY();
        }

        // TODO 5
        clearButton.update();

        // TODO 6
        // colorButton1.update();
        // colorButton2.update();

        // TODO 7
        for (SquareButton button : penColorButtons) {
            button.update();
        }
    }
}
