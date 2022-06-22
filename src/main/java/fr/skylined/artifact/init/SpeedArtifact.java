package fr.skylined.artifact.init;

import fr.skylined.artifact.ARTIFACT;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SpeedArtifact extends Item {
    public SpeedArtifact(Settings settings) {
        super(settings);
    }

    public static final Item SPEED_ARTIFACT = new Item(new Item.Settings().group(ARTIFACT.ARTIFACT_GROUP).maxCount(1));

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(entity instanceof PlayerEntity player){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,100, 0));
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
