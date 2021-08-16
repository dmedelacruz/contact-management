package com.dmedelacruz.contactmanagement.mapper.valueFilter;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PreferredFilter {

    @Override
    public boolean equals(Object value) {
        if(value == null) {
            return true;
        }
        return !((Boolean) value);
    }

}
