package net.themonhub.playeranimationfeatures.mixin.animator;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.player.PlayerCapeModel;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.themonhub.playeranimationfeatures.pose.ResetPose;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerCapeModel.class)
public class CapeAnimator {

    @Shadow
    @Final
    private ModelPart cape;

    @Inject(at = @At("HEAD"), method = "setupAnim(Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;)V", cancellable = true)
    public void setupAnim(AvatarRenderState state, CallbackInfo ci) {
        ResetPose.INSTANCE.resetCapePose(cape, state);
        ci.cancel();
    }
}