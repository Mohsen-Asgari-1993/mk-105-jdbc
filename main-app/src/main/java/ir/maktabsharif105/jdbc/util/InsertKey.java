package ir.maktabsharif105.jdbc.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class InsertKey {

    private String columnName;

    private int paramIndex;

    public InsertKey(String columnName) {
        this.columnName = columnName;
    }
}
