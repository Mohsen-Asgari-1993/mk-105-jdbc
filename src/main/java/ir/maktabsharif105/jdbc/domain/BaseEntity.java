package ir.maktabsharif105.jdbc.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(builderMethodName = "baseEntityBuilder", buildMethodName = "buildBaseEntity")
public abstract class BaseEntity<ID> {

    private ID id;

}
