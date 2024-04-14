import {
    AbstractInsnNode,
    ASMAPI,
    CoreMods,
    InsnList,
    JumpInsnNode,
    LabelNode,
    MethodInsnNode,
    MethodNode,
    Opcodes,
    VarInsnNode
} from "coremods";

function initializeCoreMod(): CoreMods {
    return {
        'NoWaterlog': {
            'target': {
                'type': 'METHOD',
                'class': 'net.minecraft.world.level.block.ComposterBlock',
                'methodName': 'm_213897_',
                'methodDesc': '(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/util/RandomSource;)V'
            },
            'transformer': function (method: MethodNode) {
                const target = new InsnList();
                target.add(new VarInsnNode(Opcodes.ALOAD, 1));
                target.add(new VarInsnNode(Opcodes.ALOAD, 2));
                target.add(new VarInsnNode(Opcodes.ALOAD, 3));
                target.add(new VarInsnNode(Opcodes.ALOAD, 4));
                target.add(ASMAPI.buildMethodCall(
                    'de/melanx/packessentials/CoreUtil',
                    'tickComposter', '(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/util/RandomSource;)V',
                    ASMAPI.MethodType.STATIC
                ));

                for (let i = method.instructions.size() - 1; i >= 0; i--) {
                  const inst = method.instructions.get(i);
                  if (inst != null && inst.getOpcode() == Opcodes.RETURN) {
                    method.instructions.insertBefore(inst, target)
                    return method;
                  }
                }
                throw new Error("Failed to patch ComposterBlock.class");
            }
        }
    }
}
