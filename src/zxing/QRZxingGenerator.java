/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zxing;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.encoder.ByteMatrix;

import java.io.File;
import java.io.IOException;

public class QRZxingGenerator {
    // Image properties

    private static final String IMAGE_FORMAT = "gif";
    private static final String IMG_PATH = System.getProperty("user.home") + "/qrZxing4.gif";
    private static final int width = 500;
    private static final int height = 500;


    // Let's do it
    public static void main(String[] args) throws Exception {

        String datos = "Luis Manuel Navarro Rangel. PGJ.";

        BitMatrix bm;
        Writer writer = new QRCodeWriter();
        try {

            bm = writer.encode(datos, BarcodeFormat.QR_CODE, width, height);
            // Create buffered image to draw to
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            // Iterate through the matrix and draw the pixels to the image
            for (int y = 0; y < 500; y++) {
                for (int x = 0; x < 500; x++) {
                    int grayValue = (bm.get(x, y) ? 1 : 0) & 0xff;
                    image.setRGB(x, y, (grayValue == 0 ? 0 : 0xFFFFFF));
                }
            }

            // Write the image to a file
            FileOutputStream qrCode = new FileOutputStream(IMG_PATH);
            image = invertImage(image);
            ImageIO.write(image, IMAGE_FORMAT, qrCode);

            qrCode.close();

        } catch (WriterException e) {
            e.printStackTrace(System.err);
            return;
        }


    }

    private static  BufferedImage invertImage(BufferedImage image) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = image.getRGB(x, y);
                if (rgb == -16777216) {
                    image.setRGB(x, y, -1);
                } else {
                    image.setRGB(x, y, -16777216);
                }
            }
        }
        return image;
    }
}
