package com.ballistic.barco.util;

/**
 * Created by Nabeel on 1/13/2018.
 */
public class ContentPathUtill {

    // AUTHORIZATION CONTROLLER
    public static final String AUTH = "/oauth";
    public static final String REGISTER = "/register";
    public static final String ACTIVATED = "/activated";
    public static final String RESETPASSWORD = "/reset/password";
    public static final String LOSTPASSWORD = "/lost/password";

    // QR CONTROLLER
    public static final String QR_CODE = "/qr-code";
    public static final String GENERATE_QR = "/generate-qr";
    public static final String DECODE_QR = "/decode-qr";

    // IMAGE-SPRITE CONTROLLER
    public static final String SPRITE = "/sprite";

    // HTTP-SECURITY......
    public static final String API_DOCS = "/api-docs/**";
    public static final String ACTUATOR = "/actuator/**";
    public static final String QR_SECURE = "/qr-code/**";

    // LOGOUT
    public static final String LOGOUT = "/oauth/logout";
    public static final String AUTHORIZE = "/oauth/authorize";


    public static String getAUTH() { return AUTH; }
    public static String getREGISTER() {
        return REGISTER;
    }
    public static String getACTIVATED() {
        return ACTIVATED;
    }
    public static String getRESETPASSWORD() {
        return RESETPASSWORD;
    }
    public static String getLOSTPASSWORD() {
        return LOSTPASSWORD;
    }
    public static String getQrCode() {
        return QR_CODE;
    }
    public static String getGenerateQr() {
        return GENERATE_QR;
    }
    public static String getDecodeQr() {
        return DECODE_QR;
    }
    public static String getSPRITE() {
        return SPRITE;
    }
    public static String getApiDocs() {
        return API_DOCS;
    }
    public static String getACTUATOR() {
        return ACTUATOR;
    }
    public static String getQrSecure() {
        return QR_SECURE;
    }
    public static String getLOGOUT() {
        return LOGOUT;
    }
    public static String getAUTHORIZE() {
        return AUTHORIZE;
    }


}
