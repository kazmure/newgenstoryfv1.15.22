package net.mcreator.newgenstoryfanaticversion.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.newgenstoryfanaticversion.entity.LeftarionStartEntity;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModVariables;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModElements;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionMod;

import java.util.Map;
import java.util.HashMap;

@NewgenstoryFanaticVersionModElements.ModElement.Tag
public class Leftarion3Procedure extends NewgenstoryFanaticVersionModElements.ModElement {
	public Leftarion3Procedure(NewgenstoryFanaticVersionModElements instance) {
		super(instance, 85);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency entity for procedure Leftarion3!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency x for procedure Leftarion3!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency y for procedure Leftarion3!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency z for procedure Leftarion3!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency world for procedure Leftarion3!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NewgenstoryFanaticVersionModVariables.PlayerVariables())).EnterPlayer) == 19)) {
			if (world instanceof World && !world.getWorld().isRemote) {
				Entity entityToSpawn = new LeftarionStartEntity.CustomEntity(LeftarionStartEntity.entity, world.getWorld());
				entityToSpawn.setLocationAndAngles(x, (y + 50), z, (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				entityToSpawn.setRotationYawHead((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;
				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
								"\u041D\u0430\u043C \u043D\u0430\u0434\u043E \u0432\u0441\u0442\u0440\u0435\u0442\u0438\u0442\u044C\u0441\u044F... \u0412\u043E\u0437\u044C\u043C\u0438."),
								(false));
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;
						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
								world.getWorld().getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
										"kill @e[type=newgenstory_fanatic_version:leftarion_start]");
							}
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private IWorld world;
								public void start(IWorld world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									{
										double _setval = (double) 21;
										entity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.ifPresent(capability -> {
													capability.EnterPlayer = _setval;
													capability.syncPlayerVariables(entity);
												});
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 40000);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 200);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 200);
			{
				double _setval = (double) 20;
				entity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.EnterPlayer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
