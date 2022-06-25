package fr.skylined.artifact.items;

import fr.skylined.artifact.ARTIFACT;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.Item;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import javax.tools.Tool;

public class  ArtifactPart{

    public static final Block ARTIFACT_PART_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3f,6f).requiresTool(), UniformIntProvider.create(3,7));
    public static final Block TIER_TWO_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3f, 6f).requiresTool(), UniformIntProvider.create(3,7));
    public static final Block TIER_THREE_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3f, 6f).requiresTool(), UniformIntProvider.create(3,7));

    public static final Item ARTIFACT_PART = new Item(new Item.Settings().group(ARTIFACT.ARTIFACT_GROUP).maxCount(64));
    public static final Item TIER_TWO_PART = new Item(new Item.Settings().group(ARTIFACT.ARTIFACT_GROUP).maxCount(64));
    public static final Item TIER_THREE_PART = new Item(new Item.Settings().group(ARTIFACT.ARTIFACT_GROUP).maxCount(64));

}
