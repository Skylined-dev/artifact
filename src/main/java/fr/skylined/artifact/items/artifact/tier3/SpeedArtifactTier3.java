package fr.skylined.artifact.items.artifact.tier3;

import fr.skylined.artifact.ARTIFACT;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SpeedArtifactTier3 extends Item {
    public SpeedArtifactTier3(Settings settings) {
        super(settings);
    }

    public static final Item SPEED_ARTIFACT_TIER_3 = new SpeedArtifactTier3(new Settings().group(ARTIFACT.ARTIFACT_GROUP).maxCount(1));
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()){
            if(entity instanceof PlayerEntity player){
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,10, 2, false, false));
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
