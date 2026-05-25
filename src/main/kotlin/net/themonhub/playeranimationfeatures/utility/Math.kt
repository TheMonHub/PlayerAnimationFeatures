package net.themonhub.playeranimationfeatures.utility

import kotlin.math.*

object Math {
    class Vec3 internal constructor(var x: Double, var y: Double, var z: Double) {
        companion object {
            val ZERO = Vec3(0.0, 0.0, 0.0)
            val ONE = Vec3(1.0, 1.0, 1.0)
            val UNIT_X = Vec3(1.0, 0.0, 0.0)
            val UNIT_Y = Vec3(0.0, 1.0, 0.0)
            val UNIT_Z = Vec3(0.0, 0.0, 1.0)
        }

        fun add(v: Vec3): Vec3 {
            return Vec3(x + v.x, y + v.y, z + v.z)
        }

        fun multiply(s: Double): Vec3 {
            return Vec3(x * s, y * s, z * s)
        }

        fun dot(v: Vec3): Double {
            return x * v.x + y * v.y + z * v.z
        }

        fun cross(v: Vec3): Vec3 {
            return Vec3(
                y * v.z - z * v.y,
                z * v.x - x * v.z,
                x * v.y - y * v.x
            )
        }

        operator fun times(scale: Number): Vec3 {
            return Vec3(x * scale.toDouble(), y * scale.toDouble(), z * scale.toDouble())
        }

        fun length(): Double {
            return sqrt(x * x + y * y + z * z)
        }

        fun normalize(): Vec3 {
            val len = length()
            return Vec3(x / len, y / len, z / len)
        }

        fun clean() {
            val min = 1e-10
            if (abs(x) < min) {
                x = 0.0
            }
            if (abs(y) < min) {
                y = 0.0
            }
            if (abs(z) < min) {
                z = 0.0
            }
        }

        override fun toString(): String {
            clean()
            return "($x, $y, $z)"
        }
    }

    fun rotateAroundAxis(pivot: Vec3, axis: Vec3, angleRadians: Number): Vec3 {
        val normalizedAxis = axis.normalize()

        val cos: Double = cos(angleRadians.toDouble())
        val sin: Double = sin(angleRadians.toDouble())

        val term1 = pivot.multiply(cos)

        val term2 = normalizedAxis.cross(pivot).multiply(sin)

        val term3 = normalizedAxis.multiply(
            normalizedAxis.dot(pivot) * (1 - cos)
        )

        return term1.add(term2).add(term3)
    }

    fun toRadians(degree: Number): Number {
        if (degree is Float) {
            return degree * PI / 180.0f
        }
        return degree.toDouble() * PI / 180.0
    }
}