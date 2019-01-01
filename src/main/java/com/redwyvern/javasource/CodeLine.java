package com.redwyvern.javasource;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class CodeLine implements Comparable {
    private final ClassMethodCode classMethodCode;
    private final String code;
    private final int index;
    private final int lineNumber;
    private Statement statement;



    @Override
    public int compareTo(Object o) {

        if(!(o instanceof CodeLine)) {
            throw new RuntimeException("CodeLine is not comparable to class of type '" + o.getClass() + "'");
        }
        CodeLine rhs = (CodeLine) o;
        return index - rhs.index;
    }
}
