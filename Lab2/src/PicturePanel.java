import javax.swing.JPanel;
import java.awt.*;

public class PicturePanel extends JPanel {
    private ObjectList objectList;

    PicturePanel() {
        objectList = new ObjectList();

        setBackground(Color.BLACK);
    }

    void add(Circle shape) {
        objectList.add(shape);
    }

    void add(Square square) {
        objectList.add(square);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < objectList.size(); i++) {
            g.setColor(new Color((int)(Math.random()*0xFFFFF)));
            if (objectList.get(i) instanceof Square) {
                ((Square) objectList.get(i)).draw(g);
            }
            else if (objectList.get(i) instanceof Circle) {
                ((Circle) objectList.get(i)).draw(g);
            }
        }
    }
}
