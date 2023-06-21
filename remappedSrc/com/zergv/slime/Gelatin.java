package com.zergv.slime;

import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.core.api.item.PolymerItemUtils;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class Gelatin extends Item implements PolymerItem {
    public Gelatin(Settings settings) {
        super(settings);
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return Items.SUGAR;
    }

    @Override
    public ItemStack getPolymerItemStack(ItemStack itemStack, TooltipContext context, ServerPlayerEntity player) {
        ItemStack out = PolymerItemUtils.createItemStack(itemStack, context, player);
        out.addEnchantment(Enchantments.LURE, 0);
        out.setCustomName(Text.translatable("item.slime.gelatin"));
        return out;
    }
}
