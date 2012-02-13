/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zxing;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.multi.qrcode.QRCodeMultiReader;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author pool
 */
public class QRCodeReader {

    public static void main(String[] args) {
        Reader reader = new MultiFormatReader();

        File imgLoc = new File(System.getProperty("user.home") + "/qrcodeDemo.gif");
        BufferedImage img;
        try {
            if(imgLoc.exists()){
                img = ImageIO.read(imgLoc);
                LuminanceSource source = new BufferedImageLuminanceSource(img);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

                Result result = reader.decode(bitmap);

                System.out.println("Resultado = "+result.getText());                
            }else{
                System.out.println("No se puede leer el archivo");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        
    }
}
