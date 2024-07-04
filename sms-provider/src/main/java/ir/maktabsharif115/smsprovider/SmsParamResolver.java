package ir.maktabsharif115.smsprovider;

import ir.maktabsharif115.smsprovider.dto.SmsParam;
import ir.maktabsharif115.smsprovider.enumeration.SmsPurpose;

public interface SmsParamResolver {

    SmsParam getBySmsPurpose(SmsPurpose smsPurpose);
}
