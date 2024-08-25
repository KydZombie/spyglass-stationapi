package io.github.kydzombie.spyglass.mixin;

import io.github.kydzombie.spyglass.Spyglass;
import net.minecraft.class_555;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(class_555.class)
public class FOVChangeMixin {
    @Shadow
    private Minecraft field_2349;

    @ModifyVariable(method = "method_1848", at = @At(value = "STORE"), ordinal = 1)
    private float method_1848(float value) {
        if (field_2349.player.getHand() != null &&
                field_2349.player.getHand().getItem() == Spyglass.spyglass &&
                Mouse.isButtonDown(1)) {
            return value / 3;
        }
        return value;
    }
}
