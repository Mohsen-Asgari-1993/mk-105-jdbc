package ir.maktabsharif115.smsprovider.dto;

import ir.maktabsharif115.smsprovider.enumeration.SmsPurpose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashMap;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SmsRequestDTO {

    private String mobileNumber;

    private SmsPurpose smsPurpose;

    private LinkedHashMap<String, String> params;

}
