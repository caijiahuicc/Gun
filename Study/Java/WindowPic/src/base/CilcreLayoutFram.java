package base;

import javax.swing.*;
import java.awt.*;

/**
 * @author cc
 * @create 2023/11/26
 * @description
 */
public class CilcreLayoutFram{
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->{
            CircleFrame circleFrame = new CircleFrame();
            circleFrame.setTitle("Swing组件测试");
            circleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            circleFrame.setVisible(true);
        });
    }
}

class CircleFrame extends JFrame{
    public CircleFrame(){
        setLayout(new CilcreLayout());
        add(new JButton("yellow"));
        add(new JButton("Blue"));
        add(new JButton("Green"));
        add(new JButton("Orange"));
        add(new JButton("Fuchsia"));
        add(new JButton("Indigo"));
        pack();
    }
}

class CilcreLayout implements LayoutManager {
    private int minWidth = 0;
    private int minHeight = 0;
    private int preferredWidth = 0;
    private int preferredHeight = 0;
    private boolean sizesSet = false;
    private int maxComponentWidth = 0;
    private int maxComponentHeight = 0;

    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        setSizes(parent);
        Insets insets = parent.getInsets();
        int width = preferredWidth + insets.left + insets.right;
        int height = preferredHeight + insets.top + insets.bottom;
        return new Dimension(width,height);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        setSizes(parent);
        Insets insets = parent.getInsets();
        int width = minWidth + insets.left + insets.right;
        int height = minHeight + insets.top + insets.bottom;
        return new Dimension(width,height);
    }

    @Override
    public void layoutContainer(Container parent) {
        setSizes(parent);
        Insets insets = parent.getInsets();
        int containerWidth = parent.getSize().width - insets.left - insets.right;
        int containerHeight = parent.getSize().height - insets.top - insets.bottom;

        int xcenter = insets.left + containerWidth / 2;
        int ycenter = insets.top + containerHeight / 2;

        int xradius = (containerWidth - maxComponentWidth) / 2;
        int yradius = (containerHeight - maxComponentHeight) / 2;
        int radius = Math.min(xradius,yradius);

        int n = parent.getComponentCount();
        for (int i = 0; i < n; i++) {
            Component c = parent.getComponent(i);
            if(c.isVisible()){
                double angle = 2 * Math.PI * i / n;
                int x = xcenter + (int)(Math.cos(angle) * radius);
                int y = ycenter + (int)(Math.sin(angle) * radius);

                Dimension d = c.getPreferredSize();
                c.setBounds(x - d.width / 2,y - d.width / 2,d.width,d.height);
            }
        }
    }

    public void setSizes(Container parent){
        if(sizesSet){
            return;
        }
        int n = parent.getComponentCount();

        preferredHeight = 0;
        preferredWidth = 0;
        minHeight = 0;
        minWidth = 0;
        preferredHeight = 0;
        preferredWidth = 0;

        for (int i = 0; i < n; i++) {
            Component c = parent.getComponent(i);
            if(c.isValid()){
                Dimension d = c.getPreferredSize();
               maxComponentWidth = (int) Math.max(maxComponentWidth, d.getWidth());
               maxComponentHeight = (int) Math.max(maxComponentHeight,d.getHeight());
               preferredWidth += d.width;
               preferredHeight += d.height;
            }
        }
        minWidth = preferredWidth / 2;
        minHeight = preferredHeight / 2;
        sizesSet = true;
    }
}
