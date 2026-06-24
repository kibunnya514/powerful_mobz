package com.kingmobz;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class brake_block extends Goal {

    private final Mob mob;

    public brake_block (Mob mob) {
        this.mob = mob;
    }

    @Override
    public boolean canUse() {
       //条件
        return true;
    }
    @Override
    public void tick() {
        //ブロック破壊処理
        //ブロック置くときと同じようにプレイヤーとモブのY座標を比較して、上下の指定したブロックを破壊、
        // それにモブの向いている方向の縦２列のブロック破壊を組み合わせて
        // （近接モブの入れ替えた接近プログラムと合わせれば壁を破壊して直進できると思うから）実装する。
    }
}