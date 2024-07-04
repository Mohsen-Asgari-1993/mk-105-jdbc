package ir.maktabsharif115.smsprovider;

import ir.maktabsharif115.smsprovider.dto.SmsRequestDTO;
import ir.maktabsharif115.smsprovider.dto.SmsResponseDTO;

public interface SmsSender {

    SmsResponseDTO send(SmsRequestDTO dto);

}
