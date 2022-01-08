package net.mcreator.newgenstoryfanaticversion.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.advancements.Advancement;

import net.mcreator.newgenstoryfanaticversion.entity.GorbaticStartEntity;
import net.mcreator.newgenstoryfanaticversion.entity.FairyEntity;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModVariables;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionMod;

import java.util.Map;
import java.util.HashMap;

public class Gorbatic1Procedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onAdvancement(AdvancementEvent event) {
			PlayerEntity entity = event.getPlayer();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Advancement advancement = event.getAdvancement();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("advancement", advancement);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency world for procedure Gorbatic1!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency x for procedure Gorbatic1!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency y for procedure Gorbatic1!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency z for procedure Gorbatic1!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency entity for procedure Gorbatic1!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NewgenstoryFanaticVersionModVariables.PlayerVariables())).EnterPlayer == 7) {
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new GorbaticStartEntity.CustomEntity(GorbaticStartEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, (z + 5), (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				entityToSpawn.setRotationYawHead((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new FairyEntity.CustomEntity(FairyEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, (y + 5), (z + 7), (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				entityToSpawn.setRotationYawHead((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
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
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent("<\u0413\u043E\u0440\u0431\u0430\u0442\u0438\u043A> \u041A\u0443-\u043A\u0443...!"), (false));
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
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
										"<\u0413\u043E\u0440\u0431\u0430\u0442\u0438\u043A> \u041C-\u043C\u044B \u0442\u0435\u0431\u044F \u0432\u0438\u0434\u0435\u043B\u0438!"),
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
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
												"<\u0413\u043E\u0440\u0431\u0430\u0442\u0438\u043A> \u0414\u0430-\u0430, \u0432\u0438\u0434\u0435\u043B\u0438."),
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
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
														"<\u0413\u043E\u0440\u0431\u0430\u0442\u0438\u043A> \u0414-\u0434\u0440\u0430\u043A\u043E\u043D. \u0422\u044B \u0431\u044B\u043B, \u0434\u0430-\u0430, \u0431\u044B\u043B!"),
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
													if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
														((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
																"<\u0413\u043E\u0440\u0431\u0430\u0442\u0438\u043A> \u0418 \u043E\u043D \u0431-\u0431\u044B\u043B"),
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
															if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
																((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
																		"<\u0413\u043E\u0440\u0431\u0430\u0442\u0438\u043A> \u0410 \u0432\u0441\u0451 \u0436\u0435 \u0437\u0440\u044F. \u0414\u0430-\u0430, \u0437\u0440\u044F."),
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
																	if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
																		((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
																				"<\u0413\u043E\u0440\u0431\u0430\u0442\u0438\u043A> \u041D\u0435 \u0442\u043E\u0442 \u0437\u0430 \u043A\u043E\u0433\u043E \u0441\u0435\u0431\u044F \u0432\u044B\u0439\u0434\u0451\u0442..."),
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
																			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
																				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
																						"<\u0413\u043E\u0440\u0431\u0430\u0442\u0438\u043A> \u0414\u0430-\u0430.. \u043D\u0435 \u0442\u043E\u0442..."),
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
																					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
																						((PlayerEntity) entity).sendStatusMessage(
																								new StringTextComponent(
																										"<\u0424\u0435\u044F> \u042F \u043B\u044E\u0431\u043B\u044E \u043E\u0434\u0443\u0432\u0430\u043D\u0447\u0438\u043A\u0438"),
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
																							if (entity instanceof PlayerEntity
																									&& !entity.world.isRemote()) {
																								((PlayerEntity) entity).sendStatusMessage(
																										new StringTextComponent(
																												"<\u0413\u043E\u0440\u0431\u0430\u0442\u0438\u043A> \u041E\u0439, \u0447\u0442\u043E \u044D\u0442\u043E? \u0424\u0435\u044F?"),
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
																									if (entity instanceof PlayerEntity
																											&& !entity.world.isRemote()) {
																										((PlayerEntity) entity).sendStatusMessage(
																												new StringTextComponent(
																														"<\u0413\u043E\u0440\u0431\u0430\u0442\u0438\u043A> *\u043F\u0443\u0444\u0444*"),
																												(false));
																									}
																									if (world instanceof ServerWorld) {
																										((World) world).getServer()
																												.getCommandManager()
																												.handleCommand(new CommandSource(
																														ICommandSource.DUMMY,
																														new Vector3d(x, y, z),
																														Vector2f.ZERO,
																														(ServerWorld) world, 4, "",
																														new StringTextComponent(""),
																														((World) world).getServer(),
																														null).withFeedbackDisabled(),
																														"kill @e[type=newgenstory_fanatic_version:gorbatic_start]");
																									}
																									if (world instanceof ServerWorld) {
																										((World) world).getServer()
																												.getCommandManager()
																												.handleCommand(new CommandSource(
																														ICommandSource.DUMMY,
																														new Vector3d(x, y, z),
																														Vector2f.ZERO,
																														(ServerWorld) world, 4, "",
																														new StringTextComponent(""),
																														((World) world).getServer(),
																														null).withFeedbackDisabled(),
																														"kill @e[type=newgenstory_fanatic_version:fairy]");
																									}
																									new Object() {
																										private int ticks = 0;
																										private float waitTicks;
																										private IWorld world;

																										public void start(IWorld world,
																												int waitTicks) {
																											this.waitTicks = waitTicks;
																											MinecraftForge.EVENT_BUS.register(this);
																											this.world = world;
																										}

																										@SubscribeEvent
																										public void tick(
																												TickEvent.ServerTickEvent event) {
																											if (event.phase == TickEvent.Phase.END) {
																												this.ticks += 1;
																												if (this.ticks >= this.waitTicks)
																													run();
																											}
																										}

																										private void run() {
																											{
																												double _setval = 9;
																												entity.getCapability(
																														NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY,
																														null)
																														.ifPresent(capability -> {
																															capability.EnterPlayer = _setval;
																															capability
																																	.syncPlayerVariables(
																																			entity);
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
																					MinecraftForge.EVENT_BUS.unregister(this);
																				}
																			}.start(world, (int) 200);
																			MinecraftForge.EVENT_BUS.unregister(this);
																		}
																	}.start(world, (int) 200);
																	MinecraftForge.EVENT_BUS.unregister(this);
																}
															}.start(world, (int) 200);
															MinecraftForge.EVENT_BUS.unregister(this);
														}
													}.start(world, (int) 200);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 200);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 200);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 200);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 100);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 100);
			{
				double _setval = 8;
				entity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.EnterPlayer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
