package com.pfc.revisiones.app.inventario.services;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
//import java.nio.file.Paths;
//import java.nio.file.Path;

@Service
public class QrCodeService {

    private static final int BARCODE_WIDTH = 300;
    private static final int BARCODE_HEIGHT = 150;
    private static final String IMAGE_FORMAT = "PNG";
    private static final String BUCKET_NAME = "s3-bucket-revisiones";

    private final S3Client s3Client;

    public QrCodeService() {
        this.s3Client = S3Client.builder()
                .region(Region.EU_WEST_2) // Ajusta a la región de tu bucket
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();
    }

    public String generateBarCode(String id) throws Exception {
        try {
            BitMatrix bitMatrix = new QRCodeWriter().encode(id, BarcodeFormat.QR_CODE, BARCODE_WIDTH, BARCODE_HEIGHT);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, IMAGE_FORMAT, os);
            byte[] byteArray = os.toByteArray();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);

            String key = "barcodes/" + id + ".png";
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(BUCKET_NAME)
                    .key(key)
                    .contentType("image/png")
                    .build();

            s3Client.putObject(putObjectRequest, software.amazon.awssdk.core.sync.RequestBody.fromInputStream(inputStream, byteArray.length));

            return key;
        } catch (S3Exception e) {
            throw new Exception("Error al subir el código de barras a S3", e);
        } catch (Exception e) {
            throw new Exception("Error al generar el código de barras", e);
        }
    }

    public BufferedImage generateBarCodeImage(String barCodeText) throws Exception {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(barCodeText, BarcodeFormat.QR_CODE, BARCODE_WIDTH, BARCODE_HEIGHT);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (Exception e) {
            throw new Exception("Error al generar la imagen del código QR", e);
        }
    }

/*  public String generateBarCode(String id) throws Exception {
        try {
            BitMatrix bitMatrix = new QRCodeWriter().encode(id, BarcodeFormat.QR_CODE, BARCODE_WIDTH, BARCODE_HEIGHT);
            Path path = Paths.get("src/main/resources/static/barcodes/" + id + ".png");
            MatrixToImageWriter.writeToPath(bitMatrix, IMAGE_FORMAT, path);
            return path.toString();
        } catch (Exception e) {
            throw new Exception("Error al generar el código de barras", e);
        }
    }

    public BufferedImage generateBarCodeImage(String barCodeText) throws Exception {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(barCodeText, BarcodeFormat.QR_CODE, BARCODE_WIDTH,
                    BARCODE_HEIGHT);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (Exception e) {
            throw new Exception("Error al generar la imagen del código QR", e);
        }
    }*/
    
}
