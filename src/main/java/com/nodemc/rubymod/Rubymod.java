package com.nodemc.rubymod;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

// ---------------------------------------------------------------------
// ARCHIVO GENERADO AUTOMATICAMENTE por el motor de codegen de NodeMC.
// En la app real, este fichero se produce a partir del grafo de nodos.
// ---------------------------------------------------------------------
@Mod(Rubymod.MODID)
public class Rubymod
{
    public static final String MODID = "rubymod";

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // --- Bloques generados desde la definicion ---
    public static final DeferredBlock<Block> RUBY_BLOCK = BLOCKS.registerSimpleBlock("ruby_block", BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(5.0f, 6.0f));
    public static final DeferredItem<BlockItem> RUBY_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("ruby_block", RUBY_BLOCK);

    // --- Items generados desde la definicion ---
    public static final DeferredItem<Item> RUBY = ITEMS.registerSimpleItem("ruby", new Item.Properties());
    public static final DeferredItem<Item> RAW_RUBY = ITEMS.registerSimpleItem("raw_ruby", new Item.Properties());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register(
            "rubymod_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.rubymod"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> RUBY.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(RUBY.get());
                    }).build());

    public Rubymod(IEventBus modEventBus, ModContainer modContainer)
    {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
