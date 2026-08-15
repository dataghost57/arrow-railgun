package com.jacobray.arrowrailgun;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItems {

    public static final ResourceKey<Item> ARROW_RAILGUN = ResourceKey.create(
            Registries.ITEM,
            Identifier.fromNamespaceAndPath(ArrowRailgun.MOD_ID, "arrow_railgun")
    );

    public static final Item ARROW_RAILGUN_ITEM = Registry.register(
            BuiltInRegistries.ITEM,
            ARROW_RAILGUN,
            new ArrowRailgunItem(new Item.Properties().setId(ARROW_RAILGUN))
    );

    public static void initialize() {
    }
}