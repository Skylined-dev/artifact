package fr.skylined.artifact.init;

import fr.skylined.artifact.ARTIFACT;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class RandomArtifact extends Item {
    public RandomArtifact(Settings settings) {
        super(settings);
    }

    public static final Item RANDOM_ARTIFACT = new RandomArtifact(new Item.Settings().group(ARTIFACT.ARTIFACT_GROUP).maxCount(1));

    //@Override
    //public ActionResult useOnBlock(ItemUsageContext context) {
    //    if(context.getWorld().isClient()){
    //        PlayerEntity player = context.getPlayer();
    //       int itemNum = getRandomNumber(1, 4);
    //        assert player != null;
    //        if(itemNum == 1){
    //            ItemStack speedArtifact = new ItemStack(SpeedArtifact.SPEED_ARTIFACT);
    //            player.getInventory().setStack(player.getInventory().selectedSlot, speedArtifact);
    //        }else if(itemNum == 2){
    //           ItemStack resistanceArtifact = new ItemStack(ResistanceArtifact.RESISTANCE_ARTIFACT);
    //            player.getInventory().setStack(player.getInventory().selectedSlot, resistanceArtifact);
    //        } else if (itemNum == 3) {
    //            ItemStack strengthArtifact = new ItemStack(StrengthArtifact.STRENGTH_ARTIFACT);
    //            player.getInventory().setStack(player.getInventory().selectedSlot, strengthArtifact);
    //        }
    //    }
    //    return super.useOnBlock(context);
    //}

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world.isClient()){
            int itemNum = getRandomNumber(1, 4);
            assert user != null;
            if(itemNum == 1){
                ItemStack speedArtifact = new ItemStack(SpeedArtifact.SPEED_ARTIFACT);
                user.getInventory().setStack(user.getInventory().selectedSlot, speedArtifact);
                user.getInventory().updateItems();
            }else if(itemNum == 2){
                ItemStack resistanceArtifact = new ItemStack(ResistanceArtifact.RESISTANCE_ARTIFACT);
                user.getInventory().setStack(user.getInventory().selectedSlot, resistanceArtifact);
                user.getInventory().updateItems();
            } else if (itemNum == 3) {
                ItemStack strengthArtifact = new ItemStack(StrengthArtifact.STRENGTH_ARTIFACT);
                user.getInventory().setStack(user.getInventory().selectedSlot, strengthArtifact);
                user.getInventory().updateItems();
            }
        }
        return super.use(world, user, hand);
    }

    private int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }
}
