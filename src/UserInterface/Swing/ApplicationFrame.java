package UserInterface.Swing;

import UserInterface.ImageViewer;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {
    private ImageViewer imageViewer;
    private final ActionListenerFactory factory;

    public ApplicationFrame(ActionListenerFactory factory) {
        this.setTitle("Image Browser");
        this.factory=factory;
        this.setSize(400, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        createComponents();
        this.setLocationRelativeTo(null);
    }
    
    public ImageViewer getImageViewer(){
        return imageViewer;
    }

    private void createComponents() {
        this.add(createPanelButtons(), BorderLayout.SOUTH);
        this.add(createPanelImage());
    }

    private JPanel createPanelButtons() {
        JPanel panel=new JPanel();
        panel.add(createButtonPrev());
        panel.add(createButtonNext());
        return panel;
    }

    private JButton createButtonPrev() {
        JButton buttonPrev=new JButton();
        buttonPrev.addActionListener(factory.CreateAction("Prev"));
        return buttonPrev;
    }

    private JButton createButtonNext() {
        JButton buttonNext=new JButton();
        buttonNext.addActionListener(factory.CreateAction("Next"));
        return buttonNext;
    }

    private JPanel createPanelImage() {
        ImagePanel panel=new ImagePanel();
        imageViewer=panel;
        return panel;
    }
}