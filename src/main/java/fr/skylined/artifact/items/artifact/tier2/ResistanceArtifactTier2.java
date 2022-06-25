package fr.skylined.artifact.items.artifact.tier2;

import fr.skylined.artifact.ARTIFACT;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ResistanceArtifactTier2 extends Item{

    public static final Item RESISTANCE_ARTIFACT_TIER_2 = new ResistanceArtifactTier2(new Settings().group(ARTIFACT.ARTIFACT_GROUP).maxCount(1));

    public ResistanceArtifactTier2(Settings settings) {
        super(settings);
    }
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()){
            if(entity instanceof PlayerEntity player){
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,10, 1, false, false));
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
