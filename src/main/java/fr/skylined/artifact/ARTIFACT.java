package fr.skylined.artifact;

import fr.skylined.artifact.init.ResistanceArtifact;
import fr.skylined.artifact.init.SpeedArtifact;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ARTIFACT implements ModInitializer {

    public static final String MODID = "artifact";

    public static final ItemGroup ARTIFACT_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MODID, "artifact_group"),
            () -> new ItemStack(SpeedArtifact.SPEED_ARTIFACT));


    @Override
    public void onInitialize() {
        System.out.println("Artifact is on!");
        Registry.register(Registry.ITEM, new Identifier(ARTIFACT.MODID, "speed_artifact"), SpeedArtifact.SPEED_ARTIFACT);
        Registry.register(Registry.ITEM, new Identifier(ARTIFACT.MODID, "resistance_artifact"), ResistanceArtifact.RESISTANCE_ARTIFACT);
    }
}
