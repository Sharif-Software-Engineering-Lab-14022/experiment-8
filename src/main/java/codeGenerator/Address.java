package codeGenerator;

import codeGenerator.typeAddress.Direct;
import codeGenerator.typeAddress.TypeAddress;

/**
 * Created by mohammad hosein on 6/28/2015.
 */

public class Address {
    public int num;
    public TypeAddress Type;
    public varType varType;

    public Address(int num, varType varType, TypeAddress Type) {
        this.num = num;
        this.varType = varType;
        this.Type = Type;
    }

    public Address(int num, varType varType) {
        this.num = num;
        this.varType = varType;
        this.Type = new Direct();
    }

    public String toString() {
        if (Type == null) {
            return num + "";
        }

        return Type.toString(num);
    }
}
