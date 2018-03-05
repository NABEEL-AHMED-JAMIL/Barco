package com.ballistic.barco.domain;

import org.omg.CORBA.PUBLIC_MEMBER;

// Object: BidRequest
public interface IRtbRequest {

    // rtb-rtbrequest
    public final static String ID = "id";
    public final static String IMP = "imp";
    public final static String SITE = "site";
    public final static String APP = "app";
    public final static String DEVICE = "device";
    public final static String USER = "user";
    public final static String TEST = "test";
    public final static String AT = "at";
    public final static String TMAX = "tmax";
    public final static String WSEAT = "wseat";

    public final static String BSEAT = "bseat";
    public final static String ALLIMPS = "allimps";
    public final static String CUR = "cur";
    public final static String WLANG = "wlang";
    public final static String BCAT = "bcat";
    public final static String BADV = "badv";
    public final static String BAPP = "bapp";
    public final static String SOURCE = "source";
    public final static String REGS = "regs";
    public final static String EXT = "ext";

    public static final String METRIC = "metric";
    public static final String BANNER = "banner";
    public static final String VIDEO = "video";
    public static final String AUDIO = "audio";
    public static final String NATIVE = "native";
    public static final String PMP = "pmp";
    public static final String DISPLAYMANAGER = "displaymanager";
    public static final String DISPLAYMANAGERVER = "displaymanagerver";
    public static final String INSTAL = "instal";
    public static final String TAGID = "tagid";
    public static final String BIDFLOOR = "bidfloor";
    public static final String BIDFLOORCUR = "bidfloorcur";
    public static final String CLICKBROWSER = "clickbrowser";

    public static final String SECURE = "secure";
    public static final String IFRAMEBUSTER = "iframebuster";
    public static final String PUP = "pmp";
    public static final String EXP = "exp";
    public static final String TYPE = "type";
    public static final String VALUE = "value";
    public static final String VENDOR = "vendor";
    public static final String FORMAT = "format";
    public static final String W = "w";
    public static final String H = "H";
    public static final String WMAX = "wmax";

    public static final String HMAX = "hmax";
    public static final String WMIN = "wmin";
    public static final String HMIM = "hmin";
    public static final String BTYPE = "btype";
    public static final String BATTER = "batter";
    public static final String POS = "pos";
    public static final String MIMES = "mimes";
    public static final String MINDURATION = "minduration";
    public static final String MAXDURATION = "maxduration";
    public static final String PROTOCOLS = "protocols";
    public static final String PROTOCOL = "protocol";
    public static final String TOPFRAME = "topframe";
    public static final String STARTDELAY = "startdelay";
    public static final String PLACEMENT = "placement";

    public static final String LINEARITY = "linearity";
    public static final String SKIP = "skip";
    public static final String SKIPAFTER = "skipafter";
    public static final String SEQUENCE = "sequence";
    public static final String BATTR = "battr";
    public static final String MAXECTENDED = "maxectended";
    public static final String MINBITRATE = "minbitrate";
    public static final String MAXBITRATE = "maxbitrate";
    public static final String BOXINGALLOWED = "boxingallowed";
    public static final String PLAYBACKMETHOD = "playbackmethod";
    public static final String PLAYBACKEND = "playbackend";
    public static final String DELIVERY = "delivery";
    public static final String COMPAN = "pos";
    public static final String COMPANIONNTYPE = "companiontype";
    public static final String COMPANIONAD = "companionad";
    public static final String EXPDIR = "expdir";

    public static final String API = "api";
    public static final String MAXEXTENDED = "maxextended";
    public static final String VCM = "vcm";
    public final static String FD = "fd";
    public final static String TID = "tid";
    public final static String PCHAIN = "pchain";
    public final static String COPPA = "coppa";
    public final static String MAXSEQ = "maxseq";

    public final static String FEED = "feed";
    public final static String STITCHED = "stitched";
    public final static String NVOL = "nvol";
    public final static String REQUEST = "rtbrequest";
    public final static String VER = "ver";
    public final static String HRATIO = "wratio";
    public final static String WRATIO = "hratio";
    public final static String DEALS = "deals";
    public final static String PRIVATE_AUCTION = "private_auction";
    public final static String WADOMAIN = "wadomain";
    public final static String NAME = "name";
    public final static String DOMAIN = "domain";

    public final static String CAT = "cat";
    public final static String SECTIONCAT = "sectioncat";
    public final static String PAGECAT = "pagecat";
    public final static String PAGE = "page";
    public final static String REF = "ref";
    public final static String SEARCH = "search";
    public final static String MOBILE = "mobile";
    public final static String PRIVACYPOLICY = "privacypolicy";
    public final static String PUBLISHER = "publisher";
    public final static String CONTENT = "content";
    public final static String KEYWORDS = "keywords";

    public final static String BUNDLE = "domain";
    public final static String STOREURL = "storeurl";
    public final static String PAID = "paid";
    public final static String TITLE = "title";
    public final static String EPISODE = "episode";
    public final static String SERIES = "series";
    public final static String SEASON = "season";
    public final static String ARTIST = "artist";
    public final static String GENRE = "genre";

    public final static String ALBUM = "album";
    public final static String ISRC = "isrc";
    public final static String PRODUCER = "producer";
    public final static String URL = "url";
    public final static String PRODQ = "prodq";
    public final static String VIDEOQUALITY = "videoquality";
    public final static String CONTEXT = "context";
    public final static String CONTENTRATING = "contentrating";
    public final static String USERRATING = "storeurl";

    public final static String QAGMEDIARATING = "qagmediarating";
    public final static String LIVESTREAM = "livestream";
    public final static String SOURCERELATIONSHIP = "sourcerelationship";
    public final static String LANGUAGE = "language";
    public final static String LEN = "len";
    public final static String EMBEDDABLE = "embeddable";
    public final static String DATA = "data";
    public final static String UA = "ua";
    public final static String GEO = "geo";
    public final static String DNT = "dnt";
    public final static String LMT = "lmt";
    public final static String IP = "ip";

    public final static String IPV6 = "ipv6";
    public final static String DEVICETYPE = "devicetype";
    public final static String MAKE = "make";
    public final static String MODEL = "model";
    public final static String OS = "os";
    public final static String OSV = "osv";
    public final static String HWV = "hwv";
    public final static String PPI = "ppi";

    public final static String PXRATIO = "pxratio";
    public final static String JS = "js";
    public final static String GEOFETCH = "geofetch";
    public final static String FLASHVER = "flashver";
    public final static String CARRIER = "carrier";
    public final static String MCCMNC = "mccmnc";
    public final static String CONNECTIONTYPE = "connectiontype";
    public final static String IFA = "ifa";
    public final static String DIDMD5 = "didsha1";
    public final static String DPIDSHAL = "dpidmd5";
    public final static String MACSHAL1 = "macsha1";
    public final static String MACMD5 = "macmd5";
    public final static String LAT = "lat";
    public final static String LON = "LON";

    public final static String ACCURACY = "accuracy";
    public final static String LASTFIX = "lastfix";
    public final static String IPSERVICE = "ipservice";
    public final static String COUNTRY = "country";
    public final static String REGION = "region";
    public final static String REGIONFIPS104 = "regionfips104";
    public final static String METRO = "metro";
    public final static String CITY = "city";
    public final static String ZIP = "zip";
    public final static String UTCOFFSET = "utcoffset";
    public final static String BUYERUID = "buyeruid";
    public final static String YOB = "yob";
    public final static String GENDER = "gender";

    public final static String CUSTOMDATE = "customdate";
    public final static String SEGMENT = "segment";


}
