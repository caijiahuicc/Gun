package base;

import javax.swing.*;
import java.awt.*;

/**
 * @author cc
 * @create 2023/11/26
 * @description
 */
public class AboutDialogs {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->{
            DialogFram dialogFram = new DialogFram();
            dialogFram.setTitle("Dialog 测试窗口");
            dialogFram.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            dialogFram.setVisible(true);
        });
    }
}

class DialogFram extends JFrame{
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;
    private AboutDialog dialog;

    public DialogFram(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(event ->{
            if(dialog == null){
                dialog = new AboutDialog(DialogFram.this);
                dialog.setVisible(true);
            }
        });
        fileMenu.add(aboutItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(event -> System.exit(0));
        fileMenu.add(exitItem);
    }
}

class AboutDialog extends JDialog{
    public AboutDialog(JFrame owner){
        super(owner,"About DialogTest",true);
        add(
                new JLabel(
                        "<html><h1><i>Core Java</i></h1><hr>By Cay Horstman</html>"
                )
                , BorderLayout.CENTER
        );
        JButton ok = new JButton("OK");
        ok.addActionListener(event -> setVisible(false));
        JPanel panel = new JPanel();
        panel.add(ok);
        add(panel,BorderLayout.SOUTH);
        pack();
    }
}
