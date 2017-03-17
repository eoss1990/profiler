package com.dee.profiler.instrument.flow;

import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

/**
 * Created by yangyu on 2017/3/16.
 */
public class ProfFlowMethodVisitor extends MethodVisitor {

    public ProfFlowMethodVisitor(MethodVisitor mv) {
        super(ASM4, mv);
    }

    /**
     * Flow的excute方法最前
     */
    @Override
    public void visitCode() {
        mv.visitMethodInsn(INVOKESTATIC, "com/dee/profiler/log/LoggerManager", "remove", "()V", false);
        mv.visitVarInsn(ALOAD, 0);
        mv.visitFieldInsn(GETFIELD, "com/seeyon/v3x/dee/context/Flow", "name", "Ljava/lang/String;");
        mv.visitMethodInsn(INVOKESTATIC, "com/dee/profiler/log/LoggerManager", "setName", "(Ljava/lang/String;)V", false);
        mv.visitMethodInsn(INVOKESTATIC, "com/dee/profiler/log/LoggerManager", "start", "()V", false);
        super.visitCode();
    }

    /**
     * Flow的excute方法返回或者抛异常
     * @param opcode
     */
    @Override
    public void visitInsn(int opcode) {
        if((opcode>=IRETURN&&opcode<=RETURN)||opcode==ATHROW){
            mv.visitMethodInsn(INVOKESTATIC, "com/dee/profiler/log/LoggerManager", "end", "()V", false);
            mv.visitMethodInsn(INVOKESTATIC, "com/dee/profiler/log/LoggerManager", "write", "()V", false);
        }
        super.visitInsn(opcode);
    }
}
