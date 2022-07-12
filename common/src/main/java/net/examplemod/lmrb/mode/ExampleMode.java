package net.examplemod.lmrb.mode;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.sistr.littlemaidrebirth.api.mode.Mode;
import net.sistr.littlemaidrebirth.api.mode.ModeType;
import net.sistr.littlemaidrebirth.entity.FakePlayer;
import net.sistr.littlemaidrebirth.entity.LittleMaidEntity;

//1秒ごとに発動して、メインハンドに持ったアイテムをuse()するだけのモード
public class ExampleMode extends Mode {
    protected final LittleMaidEntity maid;

    protected ExampleMode(ModeType<? extends Mode> modeType, String name, LittleMaidEntity maid) {
        super(modeType, name);
        this.maid = maid;
    }

    @Override
    public boolean shouldExecute() {
        return this.maid.age % 20 == 0 && !this.maid.getMainHandStack().isEmpty();
    }

    @Override
    public boolean shouldContinueExecuting() {
        return false;
    }

    @Override
    public void startExecuting() {
        ItemStack stack = this.maid.getMainHandStack();
        FakePlayer fakePlayer = this.maid.getFakePlayer();
        stack.use(this.maid.world, fakePlayer, Hand.MAIN_HAND);
        this.maid.swingHand(Hand.MAIN_HAND);
    }
}
