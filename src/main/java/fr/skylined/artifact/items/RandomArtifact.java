package fr.skylined.artifact.items;

import fr.skylined.artifact.ARTIFACT;
import fr.skylined.artifact.items.artifact.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class RandomArtifact extends Item {
    private int min;

    public RandomArtifact(Settings settings) {
        super(settings);
    }

    public static final Item RANDOM_ARTIFACT = new RandomArtifact(new Item.Settings().group(ARTIFACT.ARTIFACT_GROUP).maxCount(1));

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient()){
            int itemNum = getRandomNumber(1, 6);
            assert user != null;
            user.getInventory().removeStack(user.getInventory().selectedSlot);
            if(itemNum == 1){
                ItemStack speedArtifact = new ItemStack(SpeedArtifact.SPEED_ARTIFACT);
                //user.getInventory().setStack(user.getInventory().selectedSlot, speedArtifact);
                user.getInventory().insertStack(user.getInventory().selectedSlot, speedArtifact);
                user.getInventory().updateItems();
            }else if(itemNum == 2){
                ItemStack resistanceArtifact = new ItemStack(ResistanceArtifact.RESISTANCE_ARTIFACT);
                //user.getInventory().setStack(user.getInventory().selectedSlot, resistanceArtifact);
                user.getInventory().insertStack(user.getInventory().selectedSlot, resistanceArtifact);

                user.getInventory().updateItems();
            } else if (itemNum == 3) {
                ItemStack strengthArtifact = new ItemStack(StrengthArtifact.STRENGTH_ARTIFACT);
                //user.getInventory().setStack(user.getInventory().selectedSlot, strengthArtifact);
                user.getInventory().insertStack(user.getInventory().selectedSlot, strengthArtifact);

                user.getInventory().updateItems();
            }else if(itemNum == 4){
                ItemStack hasteArtifact = new ItemStack(HasteArtifact.HASTE_ARTIFACT);
                user.getInventory().insertStack(user.getInventory().selectedSlot, hasteArtifact);
                user.getInventory().updateItems();
            } else if (itemNum == 5) {
                ItemStack waterBreathingArtifact = new ItemStack(WaterBreathinArtifact.WATER_BEATHING_ARTIFACT);
                user.getInventory().insertStack(user.getInventory().selectedSlot, waterBreathingArtifact);
                user.getInventory().updateItems();
            } else if (itemNum == 6) {
                ItemStack fireResistanceArtifact = new ItemStack(FireResistanceArtifact.FIRE_RESISTANCE_ARTIFACT);
                user.getInventory().insertStack(user.getInventory().selectedSlot, fireResistanceArtifact);
                user.getInventory().updateItems();
            }
        }
        return super.use(world, user, hand);
    }

    private int getRandomNumber(int max) {
        return getRandomNumber(0, max);
    }

    private int getRandomNumber(int min, int max){
        int max2 = max+1;
        return (int) ((Math.random() * (max2 - min)) + min);
    }
}
