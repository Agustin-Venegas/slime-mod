package com.zergv.slime;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlimeInit implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("slime");

    public static final Item GELATIN = registerItem("gelatin", new Gelatin(
            new FabricItemSettings().food(FoodComponents.DRIED_KELP))
    );

    public static final Item AGAR = registerItem("agar", new Agar(
            new FabricItemSettings().food(FoodComponents.DRIED_KELP))
    );

    public static final Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier("slime", name), item);
    }

    public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(
            RegistryKeys.ITEM_GROUP,
            new Identifier("slime", "ingredients")
    );

    @Override
    public void onInitialize() {
        LOGGER.info("Loading Slime Mod Items");

        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP,
        FabricItemGroup.builder()
                .displayName(Text.literal("Ingredients"))
                .icon(() -> new ItemStack(Items.DIAMOND))
                .entries((enabledFeatures, entries) -> { entries.add(GELATIN); entries.add(AGAR);})
                .build()
        );
    }
}