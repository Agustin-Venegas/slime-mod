package com.zergv.slime;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlimeInit implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("slime");

    public static final Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier("gunpowder", name), item);
    }

    public static final Item GELATIN = registerItem("gelatin", new Gelatin(new FabricItemSettings()));

    @Override
    public void onInitialize() {
        LOGGER.info("Loading Slime Mod Items");

        ItemGroup ITEM_GROUP = FabricItemGroup.builder(
                        new Identifier("slime", "ingredients"))
                .displayName(Text.literal("Ingredients"))
                .icon(() -> new ItemStack(Items.DIAMOND))
                .entries((enabledFeatures, entries) -> { entries.add(GELATIN); })
                .build();
    }
}