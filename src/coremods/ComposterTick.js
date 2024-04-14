"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var coremods_1 = require("coremods");
function initializeCoreMod() {
    return {
        'NoWaterlog': {
            'target': {
                'type': 'METHOD',
                'class': 'net.minecraft.world.level.block.ComposterBlock',
                'methodName': 'm_213897_',
                'methodDesc': '(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/util/RandomSource;)V'
            },
            'transformer': function (method) {
                var target = new coremods_1.InsnList();
                target.add(new coremods_1.VarInsnNode(coremods_1.Opcodes.ALOAD, 1));
                target.add(new coremods_1.VarInsnNode(coremods_1.Opcodes.ALOAD, 2));
                target.add(new coremods_1.VarInsnNode(coremods_1.Opcodes.ALOAD, 3));
                target.add(new coremods_1.VarInsnNode(coremods_1.Opcodes.ALOAD, 4));
                target.add(coremods_1.ASMAPI.buildMethodCall('de/melanx/packessentials/CoreUtil', 'tickComposter', '(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/util/RandomSource;)V', coremods_1.ASMAPI.MethodType.STATIC));
                for (var i = method.instructions.size() - 1; i >= 0; i--) {
                    var inst = method.instructions.get(i);
                    if (inst != null && inst.getOpcode() == coremods_1.Opcodes.RETURN) {
                        method.instructions.insertBefore(inst, target);
                        return method;
                    }
                }
                throw new Error("Failed to patch ComposterBlock.class");
            }
        }
    };
}
