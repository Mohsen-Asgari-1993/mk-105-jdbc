package ir.maktabsharif115.smsprovider;

import ir.maktabsharif115.smsprovider.dto.SmsParam;
import ir.maktabsharif115.smsprovider.dto.SmsRequestDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractSmsSender implements SmsSender {

    protected final SmsParamResolver smsParamResolver;

    public SmsParam getParam(SmsRequestDTO dto) {
        return smsParamResolver.getBySmsPurpose(dto.getSmsPurpose());
    }
}
