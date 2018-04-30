import javax.swing.*;

public class Window extends JFrame {

  public Window() {
      setSize(400,400);
      setVisible(true);
     setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}

   public static void main (String[] args) {
       Window a = new Window();
    }
}

