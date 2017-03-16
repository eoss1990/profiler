package com.dee.profiler.instrument;

import com.dee.profiler.config.ProfFilter;
import com.dee.profiler.instrument.adapter.ProfAdapterVisitor;
import com.dee.profiler.instrument.flow.ProfFlowVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * Created by yangyu on 2017/3/16.
 */
public class ProfTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (ProfFilter.isIgnore(className))
            return classfileBuffer;

        if (ProfFilter.isFlow(className)){
            ClassReader cr = new ClassReader(classfileBuffer);
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
            ClassVisitor cv = new ProfFlowVisitor(cw);
            cr.accept(cv,0);
            return cw.toByteArray();
        }else if (ProfFilter.isAdapter(className)){
            ClassReader cr = new ClassReader(classfileBuffer);
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
            ClassVisitor cv = new ProfAdapterVisitor(cw);
            cr.accept(cv,0);
            return cw.toByteArray();
        }
        return classfileBuffer;
    }
}
