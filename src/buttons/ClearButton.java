package buttons;

import tools.Color;
import tools.PaintingTool;

public class ClearButton extends SquareButton {
    private final PaintingTool paint = new PaintingTool();

    public ClearButton(int incomingX, int incomingY, int incomingSize, Color incomingColor) {
        super(incomingX, incomingY, incomingSize, incomingColor);
    }

    @Override
    public void drawSelf() {
        super.drawSelf();

        paint.setLineColor(tools.Color.RED);
        paint.drawLine(getLeftX(), getTopY() + getSize(), getLeftX() + getSize(), getTopY());
    }

    @Override
    public void performAction() {
        paint.setFillColor(Color.WHITE);
        paint.drawRect(30, 30, 540, 340);
    }
}
