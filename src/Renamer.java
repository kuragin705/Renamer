import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

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
    JButton browseBtn = new JButton("Выбрать папку...");

    JFileChooser chooser = new JFileChooser();
    JPanel browsePanel = new JPanel();

    int counter;
    String rmvPart;
    String newName;

    File defaultDir = new File(System.getProperty("user.dir"));


    File[] fileNames = defaultDir.listFiles();
    ArrayList<File> files = new ArrayList<File>();

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
        console.add(browseBtn);
        text.setFont(font);

        buttons.add(go);
        buttons.add(exit);

        go.setFocusable(false);
        exit.setFocusable(false);

        go.addActionListener(this);
        browseBtn.addActionListener(this);
        exit.addActionListener(this);

        contentPane.add("North", window);
        contentPane.add("Center", console);
        contentPane.add("South", buttons);
    }

    public void actionPerformed(ActionEvent e)
    {

        if (e.getSource() == browseBtn)
        {
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = chooser.showOpenDialog(browsePanel);
            if(result == JFileChooser.APPROVE_OPTION)
            {File chosenDir = new File(chooser.getSelectedFile().getAbsolutePath()); fileNames = chosenDir.listFiles();}
        }
        if (e.getSource() == go && !text.getText().isEmpty())
        {
            rmvPart = text.getText();

            for (int i = 0 ; i < fileNames.length ; i++)
            {File file = new File(String.valueOf(fileNames[i])); files.add(file);}

            for (int i = 0 ; i < fileNames.length ; i++ )
            {

                if(files.get(i).toString().contains(rmvPart))
                {
                   newName = files.get(i).toString();
                   newName = newName.replace(rmvPart,"");
                   File renamedFile = new File(newName);
                   files.get(i).renameTo(renamedFile);
                   counter ++ ;
                }
            }
            System.out.println(rmvPart + " " + newName);
            JOptionPane.showMessageDialog(this, "Переименовано файлов: " + counter,
            "Сообщение", JOptionPane.INFORMATION_MESSAGE); counter = 0;
        }
        if (e.getSource() == exit ){System.exit(0);}
    }

    public static void main(String[] args)
    {Renamer app = new Renamer();}
}
