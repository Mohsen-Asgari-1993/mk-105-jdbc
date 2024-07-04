package ir.maktabsharif115.smsprovider.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SmsResponseDTO {

    private Boolean isOk;

    private String message;

}
