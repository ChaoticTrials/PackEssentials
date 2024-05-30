import {InsnList, MethodInsnNode, MethodNode, Opcodes, VarInsnNode} from "../coremods";

function initializeCoreMod() {
    return {
        'CfB': {
            'target': {
                'type': 'METHOD',
                'class': 'net.blay09.mods.cookingforblockheads.tile.FridgeBlockEntity',
                'methodName': 'serverTick',
                'methodDesc': '(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lnet/blay09/mods/cookingforblockheads/tile/FridgeBlockEntity;)V'
            },
            'transformer': function (method: MethodNode) {
                let target = new InsnList();
                target.add(new VarInsnNode(Opcodes.ALOAD, 0));
                target.add(new VarInsnNode(Opcodes.ALOAD, 1));
                target.add(new VarInsnNode(Opcodes.ALOAD, 2));
                target.add(new VarInsnNode(Opcodes.ALOAD, 3));

                target.add(new MethodInsnNode(
                    Opcodes.INVOKESTATIC,
                    'de/melanx/packessentials/compat/CookingForBlockheadsCompat',
                    'fridgeMakesSnow',
                    '(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lnet/blay09/mods/cookingforblockheads/tile/FridgeBlockEntity;)V',
                    false
                ));

                method.instructions.insert(target);

                return method;
            }
        }
    }
}