package com.dee.profiler.instrument.adapter;

import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;
import static org.objectweb.asm.Opcodes.ATHROW;

/**
 * Created by yangyu on 2017/3/16.
 */
public class ProfAdapterMethodVisitor extends MethodVisitor{

    public ProfAdapterMethodVisitor(MethodVisitor mv) {
        super(ASM4, mv);
    }

    @Override
    public void visitCode() {
        mv.visitMethodInsn(INVOKESTATIC, "com/dee/profiler/log/LoggerManager", "start", "()V", false);
        super.visitCode();
    }

    @Override
    public void visitInsn(int opcode) {
        if((opcode>=IRETURN&&opcode<=RETURN)||opcode==ATHROW){
            mv.visitMethodInsn(INVOKESTATIC, "com/dee/profiler/log/LoggerManager", "end", "()V", false);
        }
        super.visitInsn(opcode);
    }
}
