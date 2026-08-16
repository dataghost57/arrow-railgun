package com.jacobray.arrowrailgun;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import net.minecraft.world.level.Level;

public class ArrowRailgunArrow extends Arrow {

    public ArrowRailgunArrow(
            EntityType<? extends Arrow> entityType,
            Level level
    ) {
        super(entityType, level);
    }

    @Override
    public void playerTouch(Player player) {
        // Do nothing.
        // This prevents players from picking up Rail Gun arrows.
    }

    @Override
    public void tick() {
        super.tick();

        // 20 ticks per second × 5 seconds = 100 ticks.
        if (this.tickCount >= 100) {
            this.discard();
        }
    }
}