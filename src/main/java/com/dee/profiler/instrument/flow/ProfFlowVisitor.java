package com.dee.profiler.instrument.flow;

import com.dee.profiler.config.ProfFilter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ASM4;

/**
 * Created by yangyu on 2017/3/16.
 */
public class ProfFlowVisitor extends ClassVisitor {

    public ProfFlowVisitor(ClassVisitor cv) {
        super(ASM4, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv =  super.visitMethod(access, name, desc, signature, exceptions);
        if (ProfFilter.isFlowExecute(name,desc))
            return new ProfFlowMethodVisitor(mv);
        return mv;
    }
}
