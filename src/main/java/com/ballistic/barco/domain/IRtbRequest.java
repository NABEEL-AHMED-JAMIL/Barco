package com.admaxim.mvc.mapping;

import org.omg.CORBA.PUBLIC_MEMBER;

// Object: BidRequest(2.3+2.5)
public interface IRtbRequest {

    // rtb-request
    public final static String RTB_R_ID = "id";
    public final static String RTB_R_IMP = "imp";
    public final static String RTB_R_SITE = "site";
    public final static String RTB_R_APP = "app";
    public final static String RTB_R_DEVICE = "device";
    public final static String RTB_R_USER = "user";
    public final static String RTB_R_TEST = "test";
    public final static String RTB_R_AT = "at";
    public final static String RTB_R_TMAX = "tmax";
    public final static String RTB_R_WSEAT = "wseat";
    public final static String RTB_R_ALLIMPS = "allimps";
    public final static String RTB_R_CUR = "cur";
    public final static String RTB_R_BSEAT = "bseat";
    public final static String RTB_R_WLANG = "wlang";
    public final static String RTB_R_BCAT = "bcat";
    public final static String RTB_R_BADV = "badv";
    public final static String RTB_R_BAPP = "bapp";
    public final static String RTB_R_SOURCE = "source";
    public final static String RTB_R_REGS = "regs";
    public final static String RTB_R_EXT = "ext";

    // Object:Source
    public final static String RTB_R_S_FD = "fd";
    public final static String RTB_R_S_TID = "tid";
    public final static String RTB_R_S_PCHAIN = "pchain";
    public final static String RTB_R_S_EXT = "ext";

    // Object:Regs
    public final static String RTB_R_R_EXT = "ext";
    public final static String RTB_R_R_COPPA = "coppa";

    // Object:Imp
    public static final String RTB_R_IMP_ID = "id";
    public static final String RTB_R_IMP_METRIC = "metric";
    public static final String RTB_R_IMP_BANNER = "banner";
    public static final String RTB_R_IMP_VIDEO = "video";
    public static final String RTB_R_IMP_AUDIO = "audio";
    public static final String RTB_R_IMP_NATIVE = "native";
    public static final String RTB_R_IMP_PMP = "pmp";
    public static final String RTB_R_IMP_DISPLAYMANAGER = "displaymanager";
    public static final String RTB_R_IMP_DISPLAYMANAGERVER = "displaymanagerver";
    public static final String RTB_R_IMP_INSTAL = "instal";
    public static final String RTB_R_IMP_TAGID = "tagid";
    public static final String RTB_R_IMP_BIDFLOOR = "bidfloor";
    public static final String RTB_R_IMP_BIDFLOORCUR = "bidfloorcur";
    public static final String RTB_R_IMP_CLICKBROWSER = "clickbrowser";
    public static final String RTB_R_IMP_SECURE = "secure";
    public static final String RTB_R_IMP_IFRAMEBUSTER = "iframebuster";
    public static final String RTB_R_IMP_PUP = "pmp";
    public static final String RTB_R_IMP_EXP = "exp";

    // Object:Matric
    public static final String RTB_R_MT_TYPE = "type";
    public static final String RTB_R_MT_VALUE = "value";
    public static final String RTB_R_MT_VENDOR = "vendor";
    public static final String RTB_R_MT_EXP = "exp";


    // Object: Banner
    public static final String RTB_R_BNR_ID = "id";
    public static final String RTB_R_BNR_FORMAT = "format";
    public static final String RTB_R_BNR_W = "w";
    public static final String RTB_R_BNR_H = "h";
    public static final String RTB_R_BNR_WMAX = "wmax";
    public static final String RTB_R_BNR_HMAX = "hmax";
    public static final String RTB_R_BNR_WMIN = "wmin";
    public static final String RTB_R_BNR_HMIM = "hmin";
    public static final String RTB_R_BNR_BTYPE = "btype";
    public static final String RTB_R_BNR_BATTER = "batter";
    public static final String RTB_R_BNR_POS = "pos";
    public static final String RTB_R_BNR_MIMES = "mimes";
    public static final String RTB_R_BNR_TOPFRAME = "topframe";
    public static final String RTB_R_BNR_EXPDIR = "expdir";
    public static final String RTB_R_BNR_API = "api";
    public static final String RTB_R_BNR_VCM = "vcm";
    public static final String RTB_R_BNR_EXP = "exp";

    // Object: Video
    public static final String RTB_R_VID_MIMES = "mimes";
    public static final String RTB_R_VID_MINDURATION = "minduration";
    public static final String RTB_R_VID_MAXDURATION = "maxduration";
    public static final String RTB_R_VID_PROTOCOLS = "protocols";
    public static final String RTB_R_VID_PROTOCOL = "protocol";
    public static final String RTB_R_VID_W = "w";
    public static final String RTB_R_VID_H = "h";
    public static final String RTB_R_VID_STARTDELAY = "startdelay";
    public static final String RTB_R_VID_PLACEMENT = "placement";
    public static final String RTB_R_VID_LINEARITY = "linearity";
    public static final String RTB_R_VID_SKIP = "skip";
    public static final String RTB_R_VID_SKIPAFTER = "skipafter";
    public static final String RTB_R_VID_SEQUENCE = "sequence";
    public static final String RTB_R_VID_BATTR = "battr";
    public static final String RTB_R_VID_MAXECTENDED = "maxectended";
    public static final String RTB_R_VID_MINBITRATE = "minbitrate";
    public static final String RTB_R_VID_MAXBITRATE = "maxbitrate";
    public static final String RTB_R_VID_BOXINGALLOWED = "boxingallowed";
    public static final String RTB_R_VID_PLAYBACKMETHOD = "playbackmethod";
    public static final String RTB_R_VID_PLAYBACKEND = "playbackend";
    public static final String RTB_R_VID_DELIVERY = "delivery";
    public static final String RTB_R_VID_POS = "pos";
    public static final String RTB_R_VID_COMPANIONNTYPE = "companiontype";
    public static final String RTB_R_VID_COMPANIONAD = "companionad";
    public static final String RTB_R_VID_EXP = "exp";

    // Object: Audio
    public static final String RTB_R_AUD_MIMES = "mimes";
    public static final String RTB_R_AUD_MINDURATION = "minduration";
    public static final String RTB_R_AUD_MAXDURATION = "maxduration";
    public static final String RTB_R_AUD_PROTOCOLS = "protocols";
    public static final String RTB_R_AUD_STARTDELAY = "startdelay";
    public static final String RTB_R_AUD_SEQUENCE = "sequence";
    public static final String RTB_R_AUD_BATTR = "battr";
    public static final String RTB_R_AUD_MAXECTENDED = "maxectended";
    public static final String RTB_R_AUD_MINBITRATE = "minbitrate";
    public static final String RTB_R_AUD_MAXBITRATE = "maxbitrate";
    public static final String RTB_R_AUD_DELIVERY = "delivery";
    public static final String RTB_R_AUD_COMPANIONAD = "companionad";
    public static final String RTB_R_AUD_API = "api";
    public static final String RTB_R_AUD_COMPANIONNTYPE = "companiontype";
    public final static String RTB_R_AUD_MAXSQ = "maxsq";
    public final static String RTB_R_AUD_FEED = "feed";
    public final static String RTB_R_AUD_STITCHED = "stitched";
    public final static String RTB_R_AUD_NVOL = "nvol";
    public static final String RTB_R_AUD_EXP = "exp";

    // Object: Native
    public final static String RTB_R_NAV_REQUEST = "request";
    public final static String RTB_R_NAV_VER = "ver";
    public static final String RTB_R_NAV_API = "api";
    public static final String RTB_R_NAV_BATTR = "battr";
    public static final String RTB_R_NAV_EXP = "exp";

    // Object: Format
    public static final String RTB_R_FOM_W = "w";
    public static final String RTB_R_FOM_H = "h";
    public final static String RTB_R_FOM_HRATIO = "wratio";
    public final static String RTB_R_FOM_WRATIO = "hratio";
    public static final String RTB_R_FOM_WMIN = "wmin";
    public static final String RTB_R_FOM_EXP = "exp";

    // Object: Pmp
    public final static String RTB_R_PMP_DEALS = "deals";
    public final static String RTB_R_PMP_PRIVATE_AUCTION = "private_auction";
    public static final String RTB_R_PMP_EXP = "exp";

    // Object: Deal
    public static final String RTB_R_DEL_ID = "id";
    public static final String RTB_R_DEL_BIDFLOOR = "bidfloor";
    public static final String RTB_R_DEL_BIDFLOORCUR = "bidfloorcur";
    public final static String RTB_R_DEL_AT = "at";
    public final static String RTB_R_DEL_WSEAT = "wseat";
    public final static String RTB_R_DEL_WADOMAIN = "wadomain";
    public static final String RTB_R_DEL_EXP = "exp";

    // Object: Site
    public static final String RTB_R_SITE_ID = "id";
    public final static String RTB_R_SITE_NAME = "name";
    public final static String RTB_R_SITE_DOMAIN = "domain";
    public final static String RTB_R_SITE_CAT = "cat";
    public final static String RTB_R_SITE_SECTIONCAT = "sectioncat";
    public final static String RTB_R_SITE_PAGECAT = "pagecat";
    public final static String RTB_R_SITE_PAGE = "page";
    public final static String RTB_R_SITE_REF = "ref";
    public final static String RTB_R_SITE_SEARCH = "search";
    public final static String RTB_R_SITE_MOBILE = "mobile";
    public final static String RTB_R_SITE_PRIVACYPOLICY = "privacypolicy";
    public final static String RTB_R_SITE_PUBLISHER = "publisher";
    public final static String RTB_R_SITE_CONTENT = "content";
    public final static String RTB_R_SITE_KEYWORDS = "keywords";
    public static final String RTB_R_SITE_EXP = "exp";

    // Object:App
    public static final String RTB_R_APP_ID = "id";
    public final static String RTB_R_APP_NAME = "name";
    public final static String RTB_R_APP_BUNDLE = "bundle";
    public final static String RTB_R_APP_DOMAIN = "domain";
    public final static String RTB_R_APP_STOREURL = "storeurl";
    public final static String RTB_R_APP_CAT = "cat";
    public final static String RTB_R_APP_SECTIONCAT = "sectioncat";
    public final static String RTB_R_APP_PAGECAT = "pagecat";
    public final static String RTB_R_APP_VER = "ver";
    public final static String RTB_R_APP_PRIVACYPOLICY = "privacypolicy";
    public final static String RTB_R_APP_PAID = "paid";
    public final static String RTB_R_APP_PUBLISHER = "publisher";
    public final static String RTB_R_APP_CONTENT = "content";
    public final static String RTB_R_APP_KEYWORDS = "keywords";
    public static final String RTB_R_APP_EXP = "exp";

    // Object:Publisher
    public static final String RTB_R_PUB_ID = "id";
    public final static String RTB_R_PUB_NAME = "name";
    public final static String RTB_R_PUB_DOMAIN = "domain";
    public final static String RTB_R_PUB_CAT = "cat";
    public static final String RTB_R_PUB_EXP = "exp";

    // Object:Content
    public static final String RTB_R_CONT_ID = "id";
    public final static String RTB_R_CONT_TITLE = "title";
    public final static String RTB_R_CONT_EPISODE = "episode";
    public final static String RTB_R_CONT_SERIES = "series";
    public final static String RTB_R_CONT_SEASON = "season";
    public final static String RTB_R_CONT_ARTIST = "artist";
    public final static String RTB_R_CONT_GENRE = "genre";
    public final static String RTB_R_CONT_ALBUM = "album";
    public final static String RTB_R_CONT_ISRC = "isrc";
    public final static String RTB_R_CONT_PRODUCER = "producer";
    public final static String RTB_R_CONT_URL = "url";
    public final static String RTB_R_CONT_CAT = "cat";
    public final static String RTB_R_CONT_PRODQ = "prodq";
    public final static String RTB_R_CONT_VIDEOQUALITY = "videoquality";
    public final static String RTB_R_CONT_CONTEXT = "context";
    public final static String RTB_R_CONT_CONTENTRATING = "contentrating";
    public final static String RTB_R_CONT_USERRATING = "storeurl";
    public final static String RTB_R_CONT_QAGMEDIARATING = "qagmediarating";
    public final static String RTB_R_CONT_KEYWORDS = "keywords";
    public final static String RTB_R_CONT_LIVESTREAM = "livestream";
    public final static String RTB_R_CONT_SOURCERELATIONSHIP = "sourcerelationship";
    public final static String RTB_R_CONT_LEN = "len";
    public final static String RTB_R_CONT_LANGUAGE = "language";
    public final static String RTB_R_CONT_EMBEDDABLE = "embeddable";
    public final static String RTB_R_CONT_DATA = "data";
    public static final String RTB_R_CONT_EXP = "exp";

    // Object:Producer
    public static final String RTB_R_PRD_ID = "id";
    public final static String RTB_R_PRD_NAME = "name";
    public final static String RTB_R_PRD_DOMAIN = "domain";
    public final static String RTB_R_PRD_CAT = "cat";
    public static final String RTB_R_PRD_EXP = "exp";

    // Object:Device
    public final static String RTB_R_DEV_UA = "ua";
    public final static String RTB_R_DEV_GEO = "geo";
    public final static String RTB_R_DEV_DNT = "dnt";
    public final static String RTB_R_DEV_LMT = "lmt";
    public final static String RTB_R_DEV_IP = "ip";
    public final static String RTB_R_DEV_IPV6 = "ipv6";
    public final static String RTB_R_DEV_DEVICETYPE = "devicetype";
    public final static String RTB_R_DEV_MAKE = "make";
    public final static String RTB_R_DEV_MODEL = "model";
    public final static String RTB_R_DEV_OS = "os";
    public final static String RTB_R_DEV_OSV = "osv";
    public final static String RTB_R_DEV_HWV = "hwv";
    public static final String RTB_R_DEVW = "w";
    public static final String RTB_R_DEV_H = "h";
    public final static String RTB_R_DEV_PPI = "ppi";
    public final static String RTB_R_DEV_PXRATIO = "pxratio";
    public final static String RTB_R_DEV_JS = "js";
    public final static String RTB_R_DEV_GEOFETCH = "geofetch";
    public final static String RTB_R_DEV_FLASHVER = "flashver";
    public final static String RTB_R_DEV_LANGUAGE = "language";
    public final static String RTB_R_DEV_CARRIER = "carrier";
    public final static String RTB_R_DEV_MCCMNC = "mccmnc";
    public final static String RTB_R_DEV_CONNECTIONTYPE = "connectiontype";
    public final static String RTB_R_DEV_IFA = "ifa";
    public final static String RTB_R_DEV_DIDMD5 = "didsha1";
    public final static String RTB_R_DEV_DPIDSHAL = "dpidmd5";
    public final static String RTB_R_DEV_MACSHAL1 = "macsha1";
    public final static String RTB_R_DEV_MACMD5 = "macmd5";
    public static final String RTB_R_DEV_EXP = "exp";

    // Object: Geo
    public final static String RTB_R_GEO_LAT = "lat";
    public final static String RTB_R_GEO_LON = "lon";
    public static final String RTB_R_GEO_TYPE = "type";
    public final static String RTB_R_GEO_ACCURACY = "accuracy";
    public final static String RTB_R_GEO_LASTFIX = "lastfix";
    public final static String RTB_R_GEO_IPSERVICE = "ipservice";
    public final static String RTB_R_GEO_COUNTRY = "country";
    public final static String RTB_R_GEO_REGION = "region";
    public final static String RTB_R_GEO_REGIONFIPS104 = "regionfips104";
    public final static String RTB_R_GEO_METRO = "metro";
    public final static String RTB_R_GEO_CITY = "city";
    public final static String RTB_R_GEO_ZIP = "zip";
    public final static String RTB_R_GEO_UTCOFFSET = "utcoffset";
    public static final String RTB_R_GEO_EXP = "exp";


    // Object: User
    public final static String RTB_R_USER_ID = "id";
    public final static String RTB_R_USER_BUYERUID = "buyeruid";
    public final static String RTB_R_USER_YOB = "yob";
    public final static String RTB_R_USER_GENDER = "gender";
    public final static String RTB_R_KEYWORDS_GENDER = "keywords";
    public final static String RTB_R_USER_CUSTOMDATE = "customdate";
    public final static String RTB_R_USER_GEO = "geo";
    public final static String RTB_R_USER_DATA = "data";
    public static final String RTB_R_USER_EXP = "exp";

    // Object: DATA
    public final static String RTB_R_DATA_ID = "id";
    public final static String RTB_R_DATA_NAME = "name";
    public static final String RTB_R_DATA_SEGMENT = "segment";
    public static final String RTB_R_DATA_EXP = "exp";

    // Object: Segment
    public final static String RTB_R_SEG_ID = "id";
    public final static String RTB_R_SEG_NAME = "name";
    public static final String RTB_R_SEG_VALUE = "value";
    public static final String RTB_R_SEG_EXP = "exp";


}
