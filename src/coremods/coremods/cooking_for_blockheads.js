"use strict";
Object.defineProperty(exports, "__esModule", {value: true});
var coremods_1 = require("../coremods");
function initializeCoreMod() {
    return {
        'CfB': {
            'target': {
                'type': 'METHOD',
                'class': 'net.blay09.mods.cookingforblockheads.tile.FridgeBlockEntity',
                'methodName': 'serverTick',
                'methodDesc': '(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lnet/blay09/mods/cookingforblockheads/tile/FridgeBlockEntity;)V'
            },
            'transformer': function (method) {
                var target = new coremods_1.InsnList();
                target.add(new coremods_1.VarInsnNode(coremods_1.Opcodes.ALOAD, 0));
                target.add(new coremods_1.VarInsnNode(coremods_1.Opcodes.ALOAD, 1));
                target.add(new coremods_1.VarInsnNode(coremods_1.Opcodes.ALOAD, 2));
                target.add(new coremods_1.VarInsnNode(coremods_1.Opcodes.ALOAD, 3));
                target.add(new coremods_1.MethodInsnNode(coremods_1.Opcodes.INVOKESTATIC, 'de/melanx/packessentials/compat/CookingForBlockheadsCompat', 'fridgeMakesSnow', '(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lnet/blay09/mods/cookingforblockheads/tile/FridgeBlockEntity;)V', false));
                method.instructions.insert(target);
                return method;
            }
        }
    };
}
