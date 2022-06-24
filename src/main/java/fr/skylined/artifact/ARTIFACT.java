package fr.skylined.artifact;

import fr.skylined.artifact.init.*;
import fr.skylined.artifact.world.gen.ArtifactPartOreGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;

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
        Registry.register(Registry.ITEM, new Identifier(ARTIFACT.MODID, "strength_artifact"), StrengthArtifact.STRENGTH_ARTIFACT);
        Registry.register(Registry.ITEM, new Identifier(ARTIFACT.MODID, "random_artifact"), RandomArtifact.RANDOM_ARTIFACT);
        Registry.register(Registry.ITEM, new Identifier(ARTIFACT.MODID, "artifact_part"), ArtifactPart.ARTIFACT_PART);
        Registry.register(Registry.ITEM, new Identifier(ARTIFACT.MODID, "haste_artifact"), HasteArtifact.HASTE_ARTIFACT);

        //Artifact ore
        Registry.register(Registry.BLOCK, new Identifier(ARTIFACT.MODID, "artifact_part_ore"), ArtifactPart.ARTIFACT_PART_ORE);
        Registry.register(Registry.ITEM, new Identifier(ARTIFACT.MODID, "artifact_part_ore"), new BlockItem(ArtifactPart.ARTIFACT_PART_ORE, new FabricItemSettings().group(ARTIFACT.ARTIFACT_GROUP)));
        //

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier(ARTIFACT.MODID, "artifact_part_ore"), ArtifactPartOreGen.ARTIFACT_PART_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(ARTIFACT.MODID, "artifact_part_ore"),ArtifactPartOreGen.OVERWORLD_ARTIFACT_PART_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(ARTIFACT.MODID, "artifact_part_ore")));
    }
}
