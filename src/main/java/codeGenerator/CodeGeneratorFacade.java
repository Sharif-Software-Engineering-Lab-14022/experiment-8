package codeGenerator;

import Log.Log;
import scanner.token.Token;

public class CodeGeneratorFacade {
    private final CodeGenerator cg = new CodeGenerator();

    public void printMemory() {
        cg.printMemory();
    }

    public void semanticFunction(int func, Token next) {
        try {
            cg.semanticFunction(func, next);
        } catch (Exception e) {
            Log.print("Code Genetator Error");
        }
    }
}
