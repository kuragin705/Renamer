import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Renamer extends JFrame implements ActionListener
{
    JPanel window = new JPanel();
    JPanel console = new JPanel();
    JPanel buttons = new JPanel();
    Container contentPane = getContentPane();

    JLabel lbl = new JLabel("Введите часть названия, которую нужно убрать из всех файлов папки, в поле ниже.");
    JTextField text = new JTextField( 20);
    Font font = new Font("Serif", Font.PLAIN, 16);
    JButton go = new JButton("Убрать");
    JButton exit = new JButton("Выйти");

    public Renamer()
    {
        super("Renamer");
        this.setSize(600,140);
        this.setResizable(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.add(window);
        window.add(lbl);
        lbl.setFont(font);
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);

        console.add(text);
        text.setFont(font);

        buttons.add(go);
        buttons.add(exit);

        go.setFocusable(false);
        exit.setFocusable(false);

        go.addActionListener(this);
        exit.addActionListener(this);

        contentPane.add("North", window);
        contentPane.add("Center", console);
        contentPane.add("South", buttons);
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == go ){}
        if (e.getSource() == exit ){System.exit(0);}
    }

    public static void main(String[] args)
    {Renamer app = new Renamer();}
}
