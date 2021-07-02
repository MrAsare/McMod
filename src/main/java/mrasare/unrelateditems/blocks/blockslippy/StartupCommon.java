package mrasare.unrelateditems.blocks.blockslippy;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class StartupCommon
{
    public static BlockSlippy blockSlippy;  // this holds the unique instance of your block
    public static BlockItem itemBlockSimple;  // this holds the unique instance of the ItemBlock corresponding to your block

    @SubscribeEvent
    public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {
        blockSlippy = (BlockSlippy)(new BlockSlippy().setRegistryName("unrelateditems", "block_slippy"));
        blockRegisterEvent.getRegistry().register(blockSlippy);
    }

    @SubscribeEvent
    public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
        // We need to create a BlockItem so the player can carry this block in their hand and it can appear in the inventory
        final int MAXIMUM_STACK_SIZE = 20;  // player can only hold 20 of this block in their hand at once

        Item.Properties itemSimpleProperties = new Item.Properties()
                .maxStackSize(MAXIMUM_STACK_SIZE)
                .group(ItemGroup.BUILDING_BLOCKS);  // which inventory tab?
        itemBlockSimple = new BlockItem(blockSlippy, itemSimpleProperties);
        itemBlockSimple.setRegistryName(blockSlippy.getRegistryName());
        itemRegisterEvent.getRegistry().register(itemBlockSimple);
    }

    @SubscribeEvent
    public static void onCommonSetupEvent(FMLCommonSetupEvent event) {
        // not actually required for this example....
    }
}