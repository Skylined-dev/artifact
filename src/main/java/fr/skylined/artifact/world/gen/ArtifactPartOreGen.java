package fr.skylined.artifact.world.gen;

import fr.skylined.artifact.init.ArtifactPart;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.Arrays;

public class ArtifactPartOreGen {
    public static ConfiguredFeature<?, ?> ARTIFACT_PART_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>(
            Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ArtifactPart.ARTIFACT_PART_ORE.getDefaultState(),5));

    public static PlacedFeature OVERWORLD_ARTIFACT_PART_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(ARTIFACT_PART_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(5), // number of veins per chunk
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(5))
            ));
}
