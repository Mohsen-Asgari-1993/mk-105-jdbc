package ir.maktabsharif115.smsprovider;

import ir.maktabsharif115.smsprovider.dto.SmsParam;
import ir.maktabsharif115.smsprovider.dto.SmsRequestDTO;
import ir.maktabsharif115.smsprovider.dto.SmsResponseDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class KavenegarSender implements SmsSender {

    private final SmsParamResolver paramResolver;

    @Override
    public SmsResponseDTO send(SmsRequestDTO dto) {
        SmsParam smsParam = paramResolver.getBySmsPurpose(dto.getSmsPurpose());
        System.out.println(
                "send sms to " + dto.getMobileNumber() + " template id: " + smsParam.getTemplateId()
        );
        return new SmsResponseDTO(true, "ok");
    }
}
