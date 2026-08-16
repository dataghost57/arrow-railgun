package com.jacobray.arrowrailgun;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class ArrowRailgunItem extends Item {

    public ArrowRailgunItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {

        if (level.isClientSide()) {
            return InteractionResult.PASS;
        }

        EntityType<? extends Arrow> arrowType =
                (EntityType<? extends Arrow>) BuiltInRegistries.ENTITY_TYPE.getValueOrThrow(
                        ResourceKey.create(
                                Registries.ENTITY_TYPE,
                                Identifier.parse("minecraft:arrow")
                        )
                );

        for (int i = 0; i < 300; i++) {

            ArrowRailgunArrow arrow =
                    new ArrowRailgunArrow(arrowType, level);

            arrow.setOwner(player);

            arrow.setPos(
                    player.getX(),
                    player.getEyeY(),
                    player.getZ()
            );

            arrow.shootFromRotation(
                    player,
                    player.getXRot(),
                    player.getYRot(),
                    0.0F,
                    1500.0F,
                    0.15F
            );

            level.addFreshEntity(arrow);
        }

        return InteractionResult.SUCCESS;
    }
}