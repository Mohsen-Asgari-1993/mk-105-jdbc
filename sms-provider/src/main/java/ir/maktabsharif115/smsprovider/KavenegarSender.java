package ir.maktabsharif115.smsprovider;

import ir.maktabsharif115.smsprovider.dto.SmsParam;
import ir.maktabsharif115.smsprovider.dto.SmsRequestDTO;
import ir.maktabsharif115.smsprovider.dto.SmsResponseDTO;

public class KavenegarSender extends AbstractSmsSender implements SmsSender {

    public KavenegarSender(SmsParamResolver smsParamResolver) {
        super(smsParamResolver);
    }

    @Override
    public SmsResponseDTO send(SmsRequestDTO dto) {
        SmsParam smsParam = getParam(dto);
        System.out.println(
                "send sms to " + dto.getMobileNumber() + " template id: " + smsParam.getTemplateId()
        );
        return new SmsResponseDTO(true, "ok");
    }
}
