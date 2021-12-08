package net.mcreator.newgenstoryfanaticversion.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Block;

import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModElements;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionMod;

import java.util.Map;

@NewgenstoryFanaticVersionModElements.ModElement.Tag
public class DrilBlockDestroyedWithToolProcedure extends NewgenstoryFanaticVersionModElements.ModElement {
	public DrilBlockDestroyedWithToolProcedure(NewgenstoryFanaticVersionModElements instance) {
		super(instance, 55);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency entity for procedure DrilBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency x for procedure DrilBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency y for procedure DrilBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency z for procedure DrilBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency world for procedure DrilBlockDestroyedWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity.getHorizontalFacing()) == Direction.NORTH) || ((entity.getHorizontalFacing()) == Direction.SOUTH))) {
			if ((true)) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0))), world.getWorld(),
						new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0)));
				world.destroyBlock(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0)), false);
				(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).setDamage(
						(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getDamage())
								+ 1));
				if ((true)) {
					Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 0))), world.getWorld(),
							new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 0)));
					world.destroyBlock(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 0)), false);
					(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
							.setDamage((int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
									.getDamage()) + 1));
					if ((true)) {
						Block.spawnDrops(world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) (z + 0))), world.getWorld(),
								new BlockPos((int) (x - 1), (int) (y + 1), (int) (z + 0)));
						world.destroyBlock(new BlockPos((int) (x - 1), (int) (y + 1), (int) (z + 0)), false);
						(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).setDamage(
								(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
										.getDamage()) + 1));
						if ((true)) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + 0))), world.getWorld(),
									new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + 0)));
							world.destroyBlock(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + 0)), false);
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).setDamage(
									(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
											.getDamage()) + 1));
							if ((true)) {
								Block.spawnDrops(world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 0), (int) (z + 0))), world.getWorld(),
										new BlockPos((int) (x - 1), (int) (y + 0), (int) (z + 0)));
								world.destroyBlock(new BlockPos((int) (x - 1), (int) (y + 0), (int) (z + 0)), false);
								(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).setDamage(
										(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
												.getDamage()) + 1));
								if ((true)) {
									Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 0), (int) (y - 1), (int) (z + 0))), world.getWorld(),
											new BlockPos((int) (x + 0), (int) (y - 1), (int) (z + 0)));
									world.destroyBlock(new BlockPos((int) (x + 0), (int) (y - 1), (int) (z + 0)), false);
									(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
											.setDamage((int) (((((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)).getDamage()) + 1));
									if ((true)) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) (z + 0))),
												world.getWorld(), new BlockPos((int) (x + 1), (int) (y - 1), (int) (z + 0)));
										world.destroyBlock(new BlockPos((int) (x + 1), (int) (y - 1), (int) (z + 0)), false);
										(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
												.setDamage((int) (((((entity instanceof LivingEntity)
														? ((LivingEntity) entity).getHeldItemMainhand()
														: ItemStack.EMPTY)).getDamage()) + 1));
										if ((true)) {
											Block.spawnDrops(world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) (z + 0))),
													world.getWorld(), new BlockPos((int) (x - 1), (int) (y - 1), (int) (z + 0)));
											world.destroyBlock(new BlockPos((int) (x - 1), (int) (y - 1), (int) (z + 0)), false);
											(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
													.setDamage((int) (((((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)).getDamage()) + 1));
										}
									}
								}
							}
						}
					}
				}
			}
		} else if ((((entity.getHorizontalFacing()) == Direction.WEST) || ((entity.getHorizontalFacing()) == Direction.EAST))) {
			if ((true)) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0))), world.getWorld(),
						new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0)));
				world.destroyBlock(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0)), false);
				(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).setDamage(
						(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getDamage())
								+ 1));
				if ((true)) {
					Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 1))), world.getWorld(),
							new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 1)));
					world.destroyBlock(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 1)), false);
					(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
							.setDamage((int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
									.getDamage()) + 1));
					if ((true)) {
						Block.spawnDrops(world.getBlockState(new BlockPos((int) (x - 0), (int) (y + 1), (int) (z - 1))), world.getWorld(),
								new BlockPos((int) (x - 0), (int) (y + 1), (int) (z - 1)));
						world.destroyBlock(new BlockPos((int) (x - 0), (int) (y + 1), (int) (z - 1)), false);
						(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).setDamage(
								(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
										.getDamage()) + 1));
						if ((true)) {
							Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 0), (int) (y + 0), (int) (z + 1))), world.getWorld(),
									new BlockPos((int) (x + 0), (int) (y + 0), (int) (z + 1)));
							world.destroyBlock(new BlockPos((int) (x + 0), (int) (y + 0), (int) (z + 1)), false);
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).setDamage(
									(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
											.getDamage()) + 1));
							if ((true)) {
								Block.spawnDrops(world.getBlockState(new BlockPos((int) (x - 0), (int) (y + 0), (int) (z - 1))), world.getWorld(),
										new BlockPos((int) (x - 0), (int) (y + 0), (int) (z - 1)));
								world.destroyBlock(new BlockPos((int) (x - 0), (int) (y + 0), (int) (z - 1)), false);
								(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).setDamage(
										(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
												.getDamage()) + 1));
								if ((true)) {
									Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 0), (int) (y - 1), (int) (z + 0))), world.getWorld(),
											new BlockPos((int) (x + 0), (int) (y - 1), (int) (z + 0)));
									world.destroyBlock(new BlockPos((int) (x + 0), (int) (y - 1), (int) (z + 0)), false);
									(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
											.setDamage((int) (((((entity instanceof LivingEntity)
													? ((LivingEntity) entity).getHeldItemMainhand()
													: ItemStack.EMPTY)).getDamage()) + 1));
									if ((true)) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 0), (int) (y - 1), (int) (z + 1))),
												world.getWorld(), new BlockPos((int) (x + 0), (int) (y - 1), (int) (z + 1)));
										world.destroyBlock(new BlockPos((int) (x + 0), (int) (y - 1), (int) (z + 1)), false);
										(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
												.setDamage((int) (((((entity instanceof LivingEntity)
														? ((LivingEntity) entity).getHeldItemMainhand()
														: ItemStack.EMPTY)).getDamage()) + 1));
										if ((true)) {
											Block.spawnDrops(world.getBlockState(new BlockPos((int) (x - 0), (int) (y - 1), (int) (z - 1))),
													world.getWorld(), new BlockPos((int) (x - 0), (int) (y - 1), (int) (z - 1)));
											world.destroyBlock(new BlockPos((int) (x - 0), (int) (y - 1), (int) (z - 1)), false);
											(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
													.setDamage((int) (((((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY)).getDamage()) + 1));
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
