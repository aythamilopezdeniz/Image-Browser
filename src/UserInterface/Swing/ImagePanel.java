package UserInterface.Swing;

import Model.Image;
import UserInterface.ImageViewer;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class ImagePanel extends JPanel implements ImageViewer {
    private Image image;
    private int position;
    private int pressedX;

    public ImagePanel() {
        this.position = 0;
        this.hookEvents();
    }


    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void setImage(Image image) {
        this.image = image;
        repaint();
    }

    @Override
    public void paint(Graphics graphics) {
        if(image==null)return;
        super.paint(graphics);
        graphics.drawImage(getBufferedImage(image), position, 0, null);
        if(position==0)return;
        if(position<0)graphics.drawImage(getBufferedImage(image.getNext()), 
                image.getBitmap().getWidth()+position, 0, null);
        if(position>0)graphics.drawImage(getBufferedImage(image.getPrev()), 
                position-image.getBitmap().getHeight(), 0, null);
    }

    private BufferedImage getBufferedImage(Image image) {
        SwingBitmap swingBitmap=(SwingBitmap) image.getBitmap();
        return swingBitmap.getBufferedImage();
    }

    private void hookEvents() {
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                pressedX = me.getX();
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (position > image.getBitmap().getWidth() / 2)showPrevImage();
                else if (position < image.getBitmap().getWidth() / 2)showNextImage();
                position = 0;
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }

        });
        this.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent me) {
                position=me.getX()-pressedX;
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent me) {
            }
        });
    }

    @Override
    public void showNextImage() {
        image = image.getNext();
        repaint();
    }

    @Override
    public void showPrevImage() {
        image = image.getPrev();
        repaint();
    }
}
