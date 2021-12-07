package net.mcreator.newgenstoryfanaticversion.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.AdvancementEvent;
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
import net.minecraft.advancements.Advancement;

import net.mcreator.newgenstoryfanaticversion.entity.GorbaticStartEntity;
import net.mcreator.newgenstoryfanaticversion.entity.FairyEntity;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModVariables;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModElements;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionMod;

import java.util.Map;
import java.util.HashMap;

@NewgenstoryFanaticVersionModElements.ModElement.Tag
public class Gorbatic1Procedure extends NewgenstoryFanaticVersionModElements.ModElement {
	public Gorbatic1Procedure(NewgenstoryFanaticVersionModElements instance) {
		super(instance, 41);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency entity for procedure Gorbatic1!");
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
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency world for procedure Gorbatic1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NewgenstoryFanaticVersionModVariables.PlayerVariables())).EnterPlayer) == 7)) {
			if (world instanceof World && !world.getWorld().isRemote) {
				Entity entityToSpawn = new GorbaticStartEntity.CustomEntity(GorbaticStartEntity.entity, world.getWorld());
				entityToSpawn.setLocationAndAngles(x, y, (z + 5), (float) 0, (float) 0);
				entityToSpawn.setRenderYawOffset((float) 0);
				entityToSpawn.setRotationYawHead((float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.getWorld().isRemote) {
				Entity entityToSpawn = new FairyEntity.CustomEntity(FairyEntity.entity, world.getWorld());
				entityToSpawn.setLocationAndAngles(x, (y + 5), (z + 7), (float) 0, (float) 0);
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
							if (entity instanceof PlayerEntity && !entity.world.isRemote) {
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
									if (entity instanceof PlayerEntity && !entity.world.isRemote) {
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
											if (entity instanceof PlayerEntity && !entity.world.isRemote) {
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
													if (entity instanceof PlayerEntity && !entity.world.isRemote) {
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
															if (entity instanceof PlayerEntity && !entity.world.isRemote) {
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
																	if (entity instanceof PlayerEntity && !entity.world.isRemote) {
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
																			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
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
																					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
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
																									&& !entity.world.isRemote) {
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
																											&& !entity.world.isRemote) {
																										((PlayerEntity) entity).sendStatusMessage(
																												new StringTextComponent(
																														"<\u0413\u043E\u0440\u0431\u0430\u0442\u0438\u043A> *\u043F\u0443\u0444\u0444*"),
																												(false));
																									}
																									if (!world.getWorld().isRemote
																											&& world.getWorld().getServer() != null) {
																										world.getWorld().getServer()
																												.getCommandManager()
																												.handleCommand(new CommandSource(
																														ICommandSource.DUMMY,
																														new Vec3d(x, y, z),
																														Vec2f.ZERO,
																														(ServerWorld) world, 4, "",
																														new StringTextComponent(""),
																														world.getWorld().getServer(),
																														null).withFeedbackDisabled(),
																														"kill @e[type=newgenstory_fanatic_version:gorbatic_start]");
																									}
																									if (!world.getWorld().isRemote
																											&& world.getWorld().getServer() != null) {
																										world.getWorld().getServer()
																												.getCommandManager()
																												.handleCommand(new CommandSource(
																														ICommandSource.DUMMY,
																														new Vec3d(x, y, z),
																														Vec2f.ZERO,
																														(ServerWorld) world, 4, "",
																														new StringTextComponent(""),
																														world.getWorld().getServer(),
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
																												double _setval = (double) 9;
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
				double _setval = (double) 8;
				entity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.EnterPlayer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	@SubscribeEvent
	public void onAdvancement(AdvancementEvent event) {
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
		this.executeProcedure(dependencies);
	}
}
