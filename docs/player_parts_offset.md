Below are the **player model part offsets** from the shown `PlayerModel.createMesh(...)` code, including the usual base parts created by `HumanoidModel.createMesh(scale, 0.0F)`.

## Meaning of the offsets

There are two different “offset” concepts here:

1. **Part pivot / pose offset**  
   From `PartPose.offset(x, y, z)` — this is where the model part is attached relative to the root.

2. **Cube box offset**  
   From `.addBox(x, y, z, width, height, depth, scale)` — this is the cube’s local position relative to that part’s pivot.

---

## Root-level body parts

| Part name   |     PartPose offset |    Cube local offset |         Size |
|-------------|--------------------:|---------------------:|-------------:|
| `head`      |   `(0.0, 0.0, 0.0)` | `(-4.0, -8.0, -4.0)` |  `8 x 8 x 8` |
| `body`      |   `(0.0, 0.0, 0.0)` |  `(-4.0, 0.0, -2.0)` | `8 x 12 x 4` |
| `right_arm` |  `(-5.0, 2.0, 0.0)` | `(-3.0, -2.0, -2.0)` | `4 x 12 x 4` |
| `left_arm`  |   `(5.0, 2.0, 0.0)` | `(-1.0, -2.0, -2.0)` | `4 x 12 x 4` |
| `right_leg` | `(-1.9, 12.0, 0.0)` |  `(-2.0, 0.0, -2.0)` | `4 x 12 x 4` |
| `left_leg`  |  `(1.9, 12.0, 0.0)` |  `(-2.0, 0.0, -2.0)` | `4 x 12 x 4` |

---

## Slim arm offsets

When `slim == true`, both arms are replaced with 3-pixel-wide arms.

| Part name         |    PartPose offset |    Cube local offset |         Size |
|-------------------|-------------------:|---------------------:|-------------:|
| `right_arm`, slim | `(-5.0, 2.0, 0.0)` | `(-2.0, -2.0, -2.0)` | `3 x 12 x 4` |
| `left_arm`, slim  |  `(5.0, 2.0, 0.0)` | `(-1.0, -2.0, -2.0)` | `3 x 12 x 4` |

---

## Overlay / second-layer parts

These are child parts attached to their parent part with `PartPose.ZERO`.

## Texture offsets

These are the `texOffs(u, v)` values for each player-specific part.

| Part name                     | Texture offset |
|-------------------------------|---------------:|
| `left_arm`                    |     `(32, 48)` |
| `right_arm`, slim replacement |     `(40, 16)` |
| `left_sleeve`                 |     `(48, 48)` |
| `right_sleeve`                |     `(40, 32)` |
| `left_leg`                    |     `(16, 48)` |
| `left_pants`                  |      `(0, 48)` |
| `right_pants`                 |      `(0, 32)` |
| `jacket`                      |     `(16, 32)` |

Base humanoid texture offsets are usually:

| Part name   | Texture offset |
|-------------|---------------:|
| `head`      |       `(0, 0)` |
| `hat`       |      `(32, 0)` |
| `body`      |     `(16, 16)` |
| `right_arm` |     `(40, 16)` |
| `right_leg` |      `(0, 16)` |

## Wing part offsets

| Part         |    PartPose offset |             Rotation |   Cube local offset |          Size |     Texture offset |
|--------------|-------------------:|---------------------:|--------------------:|--------------:|-------------------:|
| `left_wing`  |  `(5.0, 0.0, 0.0)` | `(π/12, 0.0, -π/12)` | `(-10.0, 0.0, 0.0)` | `10 x 20 x 2` |          `(22, 0)` |
| `right_wing` | `(-5.0, 0.0, 0.0)` |  `(π/12, 0.0, π/12)` |   `(0.0, 0.0, 0.0)` | `10 x 20 x 2` | `(22, 0)` mirrored |

In degrees:

| Part         |  Rotation degrees |
|--------------|------------------:|
| `left_wing`  | `(15°, 0°, -15°)` |
| `right_wing` |  `(15°, 0°, 15°)` |

For this `cape` child part:

## Cape offsets

| Part   | Parent |   PartPose offset |        Rotation |   Cube local offset |          Size | Texture offset |
|--------|--------|------------------:|----------------:|--------------------:|--------------:|---------------:|
| `cape` | `body` | `(0.0, 0.0, 2.0)` | `(0.0, π, 0.0)` | `(-5.0, 0.0, -1.0)` | `10 x 16 x 1` |       `(0, 0)` |

In degrees:

| Part   | Rotation degrees |
|--------|-----------------:|
| `cape` | `(0°, 180°, 0°)` |
