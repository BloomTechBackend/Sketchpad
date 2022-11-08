package buttons;
import tools.Color;
import tools.PaintingTool;

public class PenColorButton extends SquareButton {
    private final PaintingTool paint = new PaintingTool();

    public PenColorButton(int incomingX, int incomingY, int incomingSize, Color incomingColor) {
        super(incomingX, incomingY, incomingSize, incomingColor);
    }

    @Override
    public void performAction() {
        paint.setLineColor(getColor());
    }
}
