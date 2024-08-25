package io.github.kydzombie.spyglass.mixin;

import io.github.kydzombie.spyglass.Spyglass;
import net.minecraft.block.Material;
import net.minecraft.class_555;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import org.lwjgl.input.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(class_555.class)
public class FOVChangeMixin {
    @Shadow
    private Minecraft field_2349;

    @Shadow
    private float field_2327;

    @Shadow
    private float field_2365;

    /**
     * @author KydZombie
     * @reason Temporary
     */
    @Overwrite
    private float method_1848(float f) {
        LivingEntity livingEntity = this.field_2349.field_2807;
        float f2 = 70.0f;
        if (livingEntity.isInFluid(Material.WATER)) {
            f2 *= (6f / 7f);
        }
        if (livingEntity.health <= 0) {
            float f3 = (float) livingEntity.field_1041 + f;
            f2 /= (1.0f - 500.0f / (f3 + 500.0f)) * 2.0f + 1.0f;
        }
        if (field_2349.player.getHand() != null &&
                field_2349.player.getHand().getItem() == Spyglass.spyglass &&
                Mouse.isButtonDown(1)) {
            f2 /= 3;
        }
        return f2 + this.field_2327 + (this.field_2365 - this.field_2327) * f;
    }
}
