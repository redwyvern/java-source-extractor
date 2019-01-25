package com.redwyvern.javasource;

import com.google.common.collect.Range;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@RequiredArgsConstructor
@Getter
@ToString
public class Statement {
    private final Range<Integer> columnRange;
    private final Range<CodeLine> codeLineRange;

    public String getStatementCode() {
        StringBuilder statementBuilder = new StringBuilder();

        statementBuilder.append(codeLineRange.lowerEndpoint().getCode().substring(columnRange.lowerEndpoint()));

        List<CodeLine> methodCodeLines = codeLineRange.lowerEndpoint().getClassMethodCode().getCodeLines();
        final int lowerIndex = codeLineRange.lowerEndpoint().getIndex();
        final int upperIndex = codeLineRange.lowerEndpoint().getIndex();
        int i;
        System.out.println("XXXXXX " + codeLineRange.lowerEndpoint().getIndex());
        System.out.println("VVVVVV " + codeLineRange.upperEndpoint().getIndex());
        for(i = lowerIndex + 1; i < upperIndex; ++i) {
            statementBuilder.append(methodCodeLines.get(i).getCode());
        }
        if(i == upperIndex) {
            statementBuilder.append(methodCodeLines.get(upperIndex).getCode(), 0, columnRange.upperEndpoint());
        }
        return statementBuilder.toString();
    }
}
