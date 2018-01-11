package com.ballistic.barco.service.qr_code;

import com.google.zxing.WriterException;
import org.springframework.util.concurrent.ListenableFuture;
import java.io.IOException;

/**
 * Created by Nabeel on 1/11/2018.
 */
public interface IQrCodeService {

    public byte[] generateQRCode(String text, int width, int height) throws WriterException, IOException;
    public ListenableFuture<byte[]> generateQRCodeAsync(String text, int width, int height) throws Exception;
    public void purgeCache();

}
