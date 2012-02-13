/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrgenerator;

import com.barcodelib.barcode.QRCode;
import java.awt.Desktop;
import java.io.File;

/**
 *
 * @author pool
 */
public class QRGenerator {

    //unidad de medida. 0-pixeles,1-cm,2-pulgadas
    private static int udm = 0;
    //resolucion
    private static int resolucion = 72;
    //margenes
    private static float margenIzq = 0.000f;
    private static float margenDer = 0.000f;
    private static float margenSup = 0.000f;
    private static float margenInf = 0.000f;
    //° de rotación de la imagen
    private static int rotacion = 0;
    //tamaño de la imagen
    private static float tamanoModulo = 5.000f;

    public static void main(String[] args) {
        try {

            QRCode codigoQR = new QRCode();
            //La información que contendra el codigo
            codigoQR.setData("http://monillo007.blogspot.com");
            //Tipo de datos
            codigoQR.setDataMode(QRCode.MODE_BYTE);

            //Establecimiento de parametros
            codigoQR.setUOM(udm);
            codigoQR.setLeftMargin(margenIzq);
            codigoQR.setResolution(resolucion);
            codigoQR.setRightMargin(margenDer);
            codigoQR.setTopMargin(margenSup);
            codigoQR.setBottomMargin(margenInf);
            codigoQR.setRotate(rotacion);
            codigoQR.setModuleSize(tamanoModulo);

            //Generar a archivo en disco
            String archivo = System.getProperty("user.home") + "/qrcodeDemo.gif";
            codigoQR.renderBarcode(archivo);
            
            Desktop d = Desktop.getDesktop();
            d.open(new File(archivo));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
