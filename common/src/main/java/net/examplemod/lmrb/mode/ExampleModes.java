package net.examplemod.lmrb.mode;

import net.minecraft.item.Items;
import net.minecraft.item.SnowballItem;
import net.minecraft.util.Identifier;
import net.sistr.littlemaidrebirth.api.mode.ItemMatchers;
import net.sistr.littlemaidrebirth.api.mode.ModeManager;
import net.sistr.littlemaidrebirth.api.mode.ModeType;

import static net.examplemod.ExampleMod.MOD_ID;

public class ExampleModes {
    public static final ModeType<?> EXAMPLE_MODE = createExampleModeBuilder().build();

    public static void init() {
        var manager = ModeManager.INSTANCE;
        manager.register(new Identifier(MOD_ID, "example_mode"), EXAMPLE_MODE);
    }

    public static ModeType.Builder<ExampleMode> createExampleModeBuilder() {
        return ModeType.<ExampleMode>builder((type, maid) ->
                        new ExampleMode(type, "Example", maid))
                .addItemMatcher(ItemMatchers.clazz(SnowballItem.class))
                .addItemMatcher(ItemMatchers.name("ender"))//nameは今バグってて動作しない
                .addItemMatcher(ItemMatchers.item(Items.EXPERIENCE_BOTTLE));
    }

}
