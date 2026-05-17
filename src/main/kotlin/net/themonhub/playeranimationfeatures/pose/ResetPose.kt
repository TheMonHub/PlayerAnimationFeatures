package net.themonhub.playeranimationfeatures.pose

import net.minecraft.client.model.geom.ModelPart
import net.minecraft.client.renderer.entity.state.AvatarRenderState
import net.minecraft.client.renderer.entity.state.HumanoidRenderState
import net.themonhub.playeranimationfeatures.constant.PivotOffset
import net.themonhub.playeranimationfeatures.utility.Math
import net.themonhub.playeranimationfeatures.utility.Math.rotateAroundAxis

object ResetPose {
    private fun ModelPart.resetPose(pivot: Math.Vec3, bodyRot: Float, isCrouching: Boolean) {
        this.resetPose()
        val modelPartPos = rotateAroundAxis(pivot, Math.Vec3.UNIT_Y, -bodyRot)
        this.setPos(modelPartPos.x.toFloat(), modelPartPos.y.toFloat(), modelPartPos.z.toFloat())
        this.yRot = -bodyRot
        if (isCrouching) {
            this.y += PivotOffset.CROUCHING_OFFSET
        }
    }

    fun resetPlayerPose(bodyParts: List<ModelPart>, state: AvatarRenderState) {
        val head = bodyParts[0]
        val body = bodyParts[1]
        val leftArm = bodyParts[2]
        val rightArm = bodyParts[3]
        val leftLeg = bodyParts[4]
        val rightLeg = bodyParts[5]


        val bodyRot = Math.toRadians(state.bodyRot).toFloat()
        val isCrouching = state.isCrouching

        head.resetPose(PivotOffset.headPivot, bodyRot, isCrouching)
        body.resetPose(PivotOffset.bodyPivot, bodyRot, isCrouching)
        leftArm.resetPose(PivotOffset.leftArmPivot, bodyRot, isCrouching)
        rightArm.resetPose(PivotOffset.rightArmPivot, bodyRot, isCrouching)
        leftLeg.resetPose(PivotOffset.leftLegPivot, bodyRot, isCrouching)
        rightLeg.resetPose(PivotOffset.rightLegPivot, bodyRot, isCrouching)
    }

    fun resetElytraPose(rightWing: ModelPart, leftWing: ModelPart, state: HumanoidRenderState) {
        val bodyRot = Math.toRadians(state.bodyRot).toFloat()
        val isCrouching = state.isCrouching

        rightWing.resetPose(PivotOffset.ElytraRightWingPivot, bodyRot, isCrouching)
        leftWing.resetPose(PivotOffset.ElytraLeftWingPivot, bodyRot, isCrouching)
    }

    fun resetCapePose(cape: ModelPart, state: HumanoidRenderState) {
        val bodyRot = Math.toRadians(state.bodyRot).toFloat()
        val isCrouching = state.isCrouching

        cape.resetPose(Math.Vec3.ZERO, bodyRot, isCrouching)
    }
}