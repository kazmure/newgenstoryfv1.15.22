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
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.newgenstoryfanaticversion.item.Paper21Item;
import net.mcreator.newgenstoryfanaticversion.entity.LeftarionStartEntity;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModVariables;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModElements;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionMod;

import java.util.Map;
import java.util.HashMap;

@NewgenstoryFanaticVersionModElements.ModElement.Tag
public class Leftarion21Procedure extends NewgenstoryFanaticVersionModElements.ModElement {
	public Leftarion21Procedure(NewgenstoryFanaticVersionModElements instance) {
		super(instance, 7);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency entity for procedure Leftarion21!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency x for procedure Leftarion21!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency y for procedure Leftarion21!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency z for procedure Leftarion21!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency world for procedure Leftarion21!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity instanceof PlayerEntity) == (y >= 200))
				&& (((entity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NewgenstoryFanaticVersionModVariables.PlayerVariables())).EnterPlayer) == 4))) {
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
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent("<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u0410?"), (false));
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
										"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u041A\u0442\u043E \u0437\u0434\u0435\u0441\u044C?"),
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
												"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u041E\u0445, \u044D\u0442\u043E \u0442\u044B..."),
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
														"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u041F\u043E\u0434\u0445\u043E\u0434\u0438, \u043D\u0435 \u0431\u043E\u0439\u0441\u044F"),
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
																"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u0412\u0435\u0440\u043E\u044F\u0442\u043D\u043E \u0442\u044B \u0445\u043E\u0447\u0435\u0448\u044C \u0443\u0437\u043D\u0430\u0442\u044C, \u043A\u0442\u043E \u044F, \u0438 \u043F\u043E\u0447\u0435\u043C\u0443 \u0442\u0430\u043A \u043C\u043D\u043E\u0433\u043E \u0437\u043D\u0430\u044E..."),
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
																		"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u041F\u0440\u043E\u0441\u0442\u0438, \u043D\u043E \u043F\u043E\u043A\u0430 \u044F \u0432\u044B\u043D\u0443\u0436\u0434\u0435\u043D \u043C\u043E\u043B\u0447\u0430\u0442\u044C"),
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
																				"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u041F\u0440\u043E\u0432\u0435\u0440\u044C, \u0442\u0430\u043A \u0431\u0443\u0434\u0435\u0442 \u043B\u0443\u0447\u0448\u0435 \u0434\u043B\u044F \u043D\u0430\u0441 \u043E\u0431\u043E\u0438\u0445"),
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
																						"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u0412\u043E\u0442 \u0447\u0442\u043E. \u041C\u043E\u0436\u0435\u0442 \u0442\u044B \u043C\u043D\u0435 \u0438 \u043D\u0435 \u0434\u043E\u0432\u0435\u0440\u044F\u0435\u0448\u044C, \u043D\u043E \u043C\u043D\u0435 \u0431\u043E\u043B\u044C\u0448\u0435 \u043D\u0435 \u043A \u043A\u043E\u043C\u0443 \u043E\u0431\u0440\u0430\u0442\u0438\u0442\u044C\u0441\u044F..."),
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
																										"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u042F \u0438\u0449\u0443 \u0441\u0432\u043E\u0435\u0433\u043E \u0431\u0440\u0430\u0442\u0430 \u042F \u0447\u0443\u0432\u0441\u0442\u0432\u0443\u044E, \u0447\u0442\u043E \u0441 \u043D\u0438\u043C \u0447\u0442\u043E-\u0442\u043E \u0441\u043B\u0443\u0447\u0438\u043B\u043E\u0441\u044C"),
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
																												"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u041F\u0435\u0440\u0435\u0434 \u043D\u0430\u0448\u0435\u0439 \u0440\u0430\u0437\u043B\u0443\u043A\u043E\u0439, \u043E\u043D \u0441\u043A\u0430\u0437\u0430\u043B \u0438\u0441\u043A\u0430\u0442\u044C \u0435\u0433\u043E \u0432 \u043E\u0433\u043D\u0435..."),
																										(false));
																							}
																							if (!world.getWorld().isRemote) {
																								ItemEntity entityToSpawn = new ItemEntity(
																										world.getWorld(), x, y, z,
																										new ItemStack(Paper21Item.block));
																								entityToSpawn.setPickupDelay((int) 10);
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
																									if (entity instanceof PlayerEntity
																											&& !entity.world.isRemote) {
																										((PlayerEntity) entity).sendStatusMessage(
																												new StringTextComponent(
																														"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u0411\u043E\u044E\u0441\u044C, \u0432\u0441\u0451 \u044D\u0442\u043E \u0432\u0440\u0435\u043C\u044F \u043E\u043D \u0441\u043A\u0440\u044B\u0432\u0430\u043B\u0441\u044F \u0432 \u043D\u0435\u0434\u0440\u0430\u0445 \u043E\u0433\u043D\u0435\u043D\u043D\u043E\u0433\u043E \u043A\u043E\u0440\u043E\u043B\u0435\u0432\u0441\u0442\u0432\u0430..."),
																												(false));
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
																											if (entity instanceof PlayerEntity
																													&& !entity.world.isRemote) {
																												((PlayerEntity) entity)
																														.sendStatusMessage(
																																new StringTextComponent(
																																		"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u041A\u0443\u0434\u0430 \u043C\u043D\u0435 \u043D\u0438\u043A\u043E\u0433\u0434\u0430 \u043D\u0435 \u043F\u043E\u043F\u0430\u0441\u0442\u044C"),
																																(false));
																											}
																											new Object() {
																												private int ticks = 0;
																												private float waitTicks;
																												private IWorld world;
																												public void start(IWorld world,
																														int waitTicks) {
																													this.waitTicks = waitTicks;
																													MinecraftForge.EVENT_BUS
																															.register(this);
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
																													if (entity instanceof PlayerEntity
																															&& !entity.world.isRemote) {
																														((PlayerEntity) entity)
																																.sendStatusMessage(
																																		new StringTextComponent(
																																				"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u041A\u0430\u043A \u044F \u0443\u0436\u0435 \u0433\u043E\u0432\u043E\u0440\u0438\u043B, \u0432\u0441\u0435 \u0432\u0440\u0430\u0442\u0430 \u0432 \u044D\u0442\u043E\u0442 \u043C\u0438\u0440 \u043D\u044B\u043D\u0435 \u0437\u0430\u043A\u0440\u044B\u0442\u044B, \u043F\u043E\u0442\u043E\u043C\u0443 \u0442\u0435\u0431\u0435 \u043F\u0440\u0438\u0434\u0451\u0442\u0441\u044F \u0441\u0430\u043C\u043E\u043C\u0443 \u043F\u0440\u043E\u0431\u0438\u0442\u044C \u043D\u0435\u043F\u0440\u0435\u043E\u0434\u043E\u043B\u0438\u043C\u044B\u0439 \u0431\u0430\u0440\u044C\u0435\u0440 \u043C\u0435\u0436\u0434\u0443 \u043D\u0430\u0448\u0438\u043C \u043C\u0438\u0440\u043E\u043C \u0438 \u043A\u043E\u0440\u043E\u043B\u0435\u0432\u0441\u0442\u0432\u043E\u043C \u043F\u043B\u0430\u043C\u0435\u043D\u0438"),
																																		(false));
																													}
																													new Object() {
																														private int ticks = 0;
																														private float waitTicks;
																														private IWorld world;
																														public void start(
																																IWorld world,
																																int waitTicks) {
																															this.waitTicks = waitTicks;
																															MinecraftForge.EVENT_BUS
																																	.register(this);
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
																															if (entity instanceof PlayerEntity
																																	&& !entity.world.isRemote) {
																																((PlayerEntity) entity)
																																		.sendStatusMessage(
																																				new StringTextComponent(
																																						"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u0414\u0435\u0440\u0436\u0438. \u0418\u0437\u0433\u043E\u0442\u043E\u0432\u044C \u0431\u043E\u043C\u0431\u0443 \u0438\u0437 \u043C\u0430\u0442\u0435\u0440\u0438\u0430\u043B\u043E\u0432 \u0431\u0435\u0437\u0434\u043D\u044B, \u0432\u0437\u043E\u0440\u0432\u0438 \u0435\u0451 \u0442\u0430\u043A \u0433\u043B\u0443\u0431\u043E\u043A\u043E, \u043A\u0430\u043A \u0442\u043E\u043B\u044C\u043A\u043E \u0441\u043C\u043E\u0436\u0435\u0448\u044C. \u041F\u0440\u043E\u043D\u0438\u043A\u043D\u0438 \u0432 \u0430\u0434\u0441\u043A\u043E\u0435 \u043A\u043E\u0440\u043E\u043B\u0435\u0432\u0441\u0442\u0432\u043E \u0438 \u043D\u0430\u0439\u0434\u0438 \u043C\u043E\u0435\u0433\u043E \u0431\u0440\u0430\u0442\u0430. \u0421\u043A\u0430\u0436\u0438, \u0447\u0442\u043E \u043D\u0430\u043C \u043D\u0435\u043E\u0431\u0445\u043E\u0434\u0438\u043C\u043E \u0432\u0441\u0442\u0440\u0435\u0442\u0438\u0442\u044C\u0441\u044F"),
																																				(false));
																															}
																															new Object() {
																																private int ticks = 0;
																																private float waitTicks;
																																private IWorld world;
																																public void start(
																																		IWorld world,
																																		int waitTicks) {
																																	this.waitTicks = waitTicks;
																																	MinecraftForge.EVENT_BUS
																																			.register(
																																					this);
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
																																	if (entity instanceof PlayerEntity
																																			&& !entity.world.isRemote) {
																																		((PlayerEntity) entity)
																																				.sendStatusMessage(
																																						new StringTextComponent(
																																								"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u0423\u0434\u0430\u0447\u0438. \u042F \u0431\u0443\u0434\u0443 \u0436\u0434\u0430\u0442\u044C \u0442\u0432\u043E\u0435\u0433\u043E \u0432\u043E\u0437\u0440\u0430\u0449\u0435\u043D\u0438\u044F"),
																																						(false));
																																	}
																																	if (!world
																																			.getWorld().isRemote
																																			&& world.getWorld()
																																					.getServer() != null) {
																																		world.getWorld()
																																				.getServer()
																																				.getCommandManager()
																																				.handleCommand(
																																						new CommandSource(
																																								ICommandSource.DUMMY,
																																								new Vec3d(
																																										x,
																																										y,
																																										z),
																																								Vec2f.ZERO,
																																								(ServerWorld) world,
																																								4,
																																								"",
																																								new StringTextComponent(
																																										""),
																																								world.getWorld()
																																										.getServer(),
																																								null).withFeedbackDisabled(),
																																						"kill @e[type=newgenstory_fanatic_version:leftarion_start]");
																																	}
																																	{
																																		double _setval = (double) 7;
																																		entity.getCapability(
																																				NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY,
																																				null)
																																				.ifPresent(
																																						capability -> {
																																							capability.EnterPlayer = _setval;
																																							capability
																																									.syncPlayerVariables(
																																											entity);
																																						});
																																	}
																																	MinecraftForge.EVENT_BUS
																																			.unregister(
																																					this);
																																}
																															}.start(world, (int) 200);
																															MinecraftForge.EVENT_BUS
																																	.unregister(this);
																														}
																													}.start(world, (int) 200);
																													MinecraftForge.EVENT_BUS
																															.unregister(this);
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
			{
				double _setval = (double) 5;
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
