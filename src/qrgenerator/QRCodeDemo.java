/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrgenerator;

import com.barcodelib.barcode.QRCode;

/**
 *
 * @author pool
 */
public class QRCodeDemo {

    private static int uom = 0;        //  0 - Pixel, 1 - CM, 2 - Inch
    private static int resolution = 72;
    private static float leftMargin = 0.000f;
    private static float rightMargin = 0.000f;
    private static float topMargin = 0.000f;
    private static float bottomMargin = 0.000f;
    private static int rotate = 0;     //  0 - 0, 1 - 90, 2 - 180, 3 - 270
    private static float moduleSize = 5.000f;

    public static void main(String[] args) {
        try {

            QRCode barcode = new QRCode();
            barcode.setData("EL GERMAN LIVES!");
            barcode.setDataMode(QRCode.MODE_BYTE);

            barcode.setUOM(uom);
            barcode.setModuleSize(moduleSize);
            barcode.setLeftMargin(leftMargin);
            barcode.setRightMargin(rightMargin);
            barcode.setTopMargin(topMargin);
            barcode.setBottomMargin(bottomMargin);
            barcode.setResolution(resolution);
            barcode.setRotate(rotate);

            barcode.renderBarcode(System.getProperty("user.home")+"/qrcodeDemo.gif");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
