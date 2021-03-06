package fr.skylined.artifact.items.artifact.tier1;

import fr.skylined.artifact.ARTIFACT;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class WaterBreathingArtifact extends Item {
    public WaterBreathingArtifact(Settings settings) {
        super(settings);
    }
    public static final Item WATER_BEATHING_ARTIFACT = new WaterBreathingArtifact(new Item.Settings().group(ARTIFACT.ARTIFACT_GROUP).maxCount(1));

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()){
            if(entity instanceof PlayerEntity player){
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING,10, 0, false, false));
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

}
