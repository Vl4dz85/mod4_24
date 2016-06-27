package models;

import javax.persistence.AttributeConverter;

/**
 * Created by Vlad on 20.06.16.
 */
public class IsMeterConverter implements AttributeConverter<IsMeter, Integer> {
    @Override
    public Integer convertToDatabaseColumn(IsMeter isMeter) {
        switch (isMeter) {
            case False:
                return 0;
            case True:
                return 1;
            default:
                return 0;
        }
    }

    @Override
    public IsMeter convertToEntityAttribute(Integer dbData) {
        switch (dbData) {
            case 0:
                return IsMeter.False;
            case 1:
                return IsMeter.True;
            default:
                return IsMeter.False;
        }
    }
}
