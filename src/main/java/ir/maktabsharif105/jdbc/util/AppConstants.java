package ir.maktabsharif105.jdbc.util;

public class AppConstants {

    public static final String MALE = "male";
    public static final String FEMALE = "female";

    public static final String REJECTED = "rejected";
    public static final String ACCEPTED = "accepted";
    public static final String WAITING = "waiting";

    public static void main(String[] args) {

        SmsPurpose[] values = SmsPurpose.values();
        for (SmsPurpose value : values) {
//            check smsSetting
        }
        int templateId = SmsPurpose.OPT.getTemplateId();/*sms.ir*/
        sendSms("091212121212", templateId);
        String pattern = SmsPurpose.OPT.getPattern();/*meli.ir*/
        sendSms("091212121212", pattern.formatted("8496"));
    }

    public static void sendSms(String mobile, int templateId) {

    }

    public static void sendSms(String mobile, String message) {

    }

}

class SmsSetting {
    private SmsPurpose smsPurpose;
    private SmsProviders smsProviders;
}

enum RequestStatus {
    REJECTED,
    ACCEPTED,
    WAITING;

    public String toPersian() {
        return switch (this) {
            case WAITING -> "در انتظار بررسی";
            case ACCEPTED -> "تایید شده";
            case REJECTED -> "رد شده";
        };
    }
}

enum SmsProviders {
    SMS_IR, MELI, KAVENEGAR, FARA, ATIEH_DADE;
}

enum SmsPurpose {
    OPT, FORGET_PASS, NEW_TICKET;

    public int getTemplateId() {
        return switch (this) {
            case OPT -> 54984;
            case FORGET_PASS -> 98564;
            case NEW_TICKET -> 13566;
        };
    }

    public String getPattern() {
        return switch (this) {
            case OPT -> """
                    %s
                    رمز عبور شما برای ورود به سامانه
                    """;
            case FORGET_PASS -> """
                    %s عزیز
                    رمز عبور شما با موفقیت تغییر یافت
                    """;
            case NEW_TICKET -> """
                    %s عزیز
                    تیکت جدیدی با عنوان %s برای شما در سامانه مکتب ثبت شد.
                    """;
        };
    }
//    insert into %s(%s)
//    #param#
//    رمز عبور شما برای ورود به سامانه
}
