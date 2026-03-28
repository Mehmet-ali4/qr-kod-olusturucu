package src;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class main {
    public static void main(String[] args) {
            new main();
            
    }
    public main(){
        JFrame pencere = new JFrame("QR KOD OLUŞTURUCU");
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pencere.setSize(700,400);
        pencere.setLayout(new FlowLayout());
        JTextField url = new JTextField(30);
        pencere.add(url);
        JButton tk = new JButton("Qr kodu oluştur");
        pencere.add(tk);
        JLabel qr = new JLabel();
        pencere.add(qr);
        
        tk.addActionListener(e -> {
             try{ 
                String link = url.getText();
                System.out.println("Link başarıyla alındı:)");
                QRCodeWriter nsn = new QRCodeWriter();
                BitMatrix matris =  nsn.encode(link, BarcodeFormat.QR_CODE, 200, 200);
               BufferedImage resim = MatrixToImageWriter.toBufferedImage(matris);
                qr.setIcon(new ImageIcon(resim));
                pencere.revalidate();
                pencere.repaint();


             } catch(Exception ex){ 
                System.err.println("bir hata oluştu "+ ex.getMessage());
                ex.printStackTrace();
                         };
                                 });
        pencere.setVisible(true);
    }

}
