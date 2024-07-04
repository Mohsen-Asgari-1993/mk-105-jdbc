package ir.maktabsharif115.smsprovider;

import ir.maktabsharif115.smsprovider.dto.SmsParam;
import ir.maktabsharif115.smsprovider.dto.SmsRequestDTO;
import ir.maktabsharif115.smsprovider.dto.SmsResponseDTO;

public class MeliPayamakSender extends AbstractSmsSender implements SmsSender {


    public MeliPayamakSender(SmsParamResolver smsParamResolver) {
        super(smsParamResolver);
    }

    @Override
    public SmsResponseDTO send(SmsRequestDTO dto) {
//        patternId = templateId
//        message
        SmsParam smsParam = getParam(dto);
        System.out.println(
                "send sms to " + dto.getMobileNumber() + " message: " + smsParam.getMessage()
        );
        return new SmsResponseDTO(true, "ok");
    }
}
