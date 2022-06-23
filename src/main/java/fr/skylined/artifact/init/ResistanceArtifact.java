package fr.skylined.artifact.init;

import fr.skylined.artifact.ARTIFACT;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class ResistanceArtifact extends Item{

    public static final Item RESISTANCE_ARTIFACT = new ResistanceArtifact(new Item.Settings().group(ARTIFACT.ARTIFACT_GROUP).maxCount(1));

    public ResistanceArtifact(Settings settings) {
        super(settings);
    }
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()){
            if(entity instanceof PlayerEntity player){
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,100, 0, false, false));
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
