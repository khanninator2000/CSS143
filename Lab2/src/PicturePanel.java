import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PicturePanel extends JPanel {
    private ObjectList objectList;

    PicturePanel() {
        objectList = new ObjectList();

        new Timer(1, e -> repaint()).start();

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

        g.setFont(new Font("default", Font.BOLD, 30));
        g.setColor(Color.WHITE);
        g.drawString("Krish", 0, 0);

        for (int i = 0; i < objectList.size(); i++) {
            g.setColor(new Color((int)(Math.random()*0xFF_FF_FF)));
            if (objectList.get(i) instanceof Square) {
                ((Square) objectList.get(i)).draw(g);
            }
            else if (objectList.get(i) instanceof Circle) {
                ((Circle) objectList.get(i)).draw(g);
            }
        }
    }
}
