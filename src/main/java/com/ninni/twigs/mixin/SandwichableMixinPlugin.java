package com.ninni.twigs.mixin;


import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class SandwichableMixinPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String mixinPackage) {
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        tryMapInsertion(mixinClassName, "com.ninni.twigs.mixin.OxidizableMixin", "method_34740", targetClass,
                "com/ninni/twigs/init/TwigsBlocks", "OXIDIZABLES"
        );
    }

    public static void tryMapInsertion(String mixinCurrent, String mixinTarget, String methodName, ClassNode targetClass, String mapFieldClass, String mapField) {
        if (mixinTarget.equals(mixinCurrent)) {
            targetClass.methods.forEach(method -> {
                if (methodName.equals(method.name)) {
                    var before = method.instructions.get(method.instructions.size() - 6);
                    var insns = new InsnList();
                    insns.add(new FieldInsnNode(
                            Opcodes.GETSTATIC, mapFieldClass, mapField, "Lcom/google/common/collect/BiMap;")
                    );
                    insns.add(new MethodInsnNode(
                            Opcodes.INVOKEVIRTUAL,
                            "com/google/common/collect/ImmutableBiMap$Builder",
                            "putAll",
                            "(Ljava/util/Map;)Lcom/google/common/collect/ImmutableBiMap$Builder;")
                    );
                    method.instructions.insertBefore(before, insns);
                }
            });
        }
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }
}


//    MIT License
//
//    Copyright (c) 2020 FoundationGames
//
//        Permission is hereby granted, free of charge, to any person obtaining a copy
//        of this software and associated documentation files (the "Software"), to deal
//        in the Software without restriction, including without limitation the rights
//        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//        copies of the Software, and to permit persons to whom the Software is
//        furnished to do so, subject to the following conditions:
//
//        The above copyright notice and this permission notice shall be included in all
//        copies or substantial portions of the Software.
//
//        THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//        IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//        FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//        AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//        LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//        OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
//        SOFTWARE.
