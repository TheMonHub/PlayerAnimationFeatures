package net.themonhub.playeranimationfeatures.constant

import net.themonhub.playeranimationfeatures.utility.Math

object PivotOffset {
    const val CROUCHING_OFFSET = -2.125f

    val headPivot = Math.Vec3.ZERO
    val bodyPivot = Math.Vec3.ZERO
    val leftArmPivot = Math.Vec3(5.0, 2.0, 0.0)
    val rightArmPivot = Math.Vec3(-5.0, 2.0, 0.0)
    val leftLegPivot = Math.Vec3(1.9, 12.0, 0.0)
    val rightLegPivot = Math.Vec3(-1.9, 12.0, 0.0)

    val ElytraLeftWingPivot = Math.Vec3(5.0, 0.0, 0.0)
    val ElytraRightWingPivot = Math.Vec3(-5.0, 0.0, 0.0)
}