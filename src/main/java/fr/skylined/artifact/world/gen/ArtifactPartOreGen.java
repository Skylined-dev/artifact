package fr.skylined.artifact.world.gen;

import fr.skylined.artifact.items.ArtifactPart;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.Arrays;

public class ArtifactPartOreGen {
    public static final RuleTest END_STONE = new BlockMatchRuleTest(Blocks.END_STONE);

    public static ConfiguredFeature<?, ?> ARTIFACT_PART_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ArtifactPart.ARTIFACT_PART_ORE.getDefaultState(),5, 0.0f));
    public static ConfiguredFeature<?, ?> TIER_TWO_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.NETHERRACK, ArtifactPart.TIER_TWO_ORE.getDefaultState(),3, 0.0f));
    public static ConfiguredFeature<?, ?> TIER_THREE_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(END_STONE, ArtifactPart.TIER_THREE_ORE.getDefaultState(),2, 0.0f));

    //ORE_ANCIENT_DEBRIS_LARGE = ConfiguredFeatures.register("ore_ancient_debris_large", Feature.SCATTERED_ORE, new OreFeatureConfig(BASE_STONE_NETHER, Blocks.ANCIENT_DEBRIS.getDefaultState(), 3, 1.0F));
    //ORE_NETHER_GOLD = ConfiguredFeatures.register("ore_nether_gold", Feature.ORE, new OreFeatureConfig(NETHERRACK, Blocks.NETHER_GOLD_ORE.getDefaultState(), 10));


    public static PlacedFeature OVERWORLD_ARTIFACT_PART_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(ARTIFACT_PART_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(5), // number of veins per chunk
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(6))
            ));

    public static PlacedFeature NETHER_TIER_TWO_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(TIER_TWO_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(5), // number of veins per chunk
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(128))
            ));

    public static PlacedFeature END_TIER_THREE_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(TIER_THREE_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(2), // number of veins per chunk
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())
            ));
}
