package MainProgram;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class Method {
    public static void displayError(String message){
        JOptionPane.showMessageDialog(null,message,"Alert",JOptionPane.ERROR_MESSAGE);
    }

    public static void displayInfo(String message){
        JOptionPane.showMessageDialog(null,message,"Information",JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean isNumeric(String string) {
        int intValue;
        if(string == null || string.equals("")) {
            return false;
        }
        
        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {}
        return false;
    }

    public static void center_screen(JFrame parent){
        int lebar = parent.getWidth()/2;
        int tinggi = parent.getHeight()/2;
        int x = ( Toolkit.getDefaultToolkit().getScreenSize().width/2)-lebar;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height/2)-tinggi;
        parent.setLocation(x, y);
    }

    public static void Escape (JFrame parent){
        parent.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).
                put(KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0), "Cancel");

        parent.getRootPane().getActionMap().put("Cancel", new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
    }


    public static void setImgLabel (JFrame parent,JLabel label , String img_path){

        BufferedImage image = null;
        try
        {
            image = ImageIO.read(new File( parent.getClass().getResource( img_path ).toURI()));

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        ImageIcon imageIcon = new ImageIcon(fitimage(image, label.getWidth(), label.getHeight()));
        label.setIcon(imageIcon);
    }

    private static Image fitimage (Image img, int w, int h)
    {
        BufferedImage resizedimage = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedimage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 0, 0,w,h,null);
        g2.dispose();
        return resizedimage;
    }


}
