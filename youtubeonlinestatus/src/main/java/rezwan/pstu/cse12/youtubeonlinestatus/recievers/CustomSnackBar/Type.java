package rezwan.pstu.cse12.youtubeonlinestatus.recievers.CustomSnackBar;

public enum Type {
    SUCCESS, ERROR, UPDATE, WARNING, CUSTOM;

    public static int getColorCode(Type type){
        switch (type){
            case SUCCESS:
                return 0x49AE32; //green
            case ERROR:
                return 0x2821D8; //red
            case UPDATE:
                return 0xff676767;
            case WARNING:
                return 0xffffc107;
            case CUSTOM:
                return 0xff2195f3;
        }
        return 0x242424; //black
    }
}
