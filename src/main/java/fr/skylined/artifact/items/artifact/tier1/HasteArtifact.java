package fr.skylined.artifact.items.artifact.tier1;

import fr.skylined.artifact.ARTIFACT;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class HasteArtifact extends Item {
    public HasteArtifact(Settings settings) {
        super(settings);
    }
    public static final Item HASTE_ARTIFACT = new HasteArtifact(new Item.Settings().group(ARTIFACT.ARTIFACT_GROUP).maxCount(1));

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if(!world.isClient()){
            if(entity instanceof PlayerEntity player){
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE,10, 0, false, false));
            }
        }
    }
}
