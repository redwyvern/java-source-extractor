package com.redwyvern.javasource;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class ClassMethodCode {
    private final String returnType;
    private final String fullClassName;
    private final String methodName;
    private final String methodSignature;
    private final int methodIndent;
    private final List<CodeLine> codeLines = new ArrayList<>();
}
