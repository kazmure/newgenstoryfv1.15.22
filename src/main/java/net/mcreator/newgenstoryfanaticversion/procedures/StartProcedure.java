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
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.newgenstoryfanaticversion.entity.LeftarionEntity;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModVariables;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModElements;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionMod;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

@NewgenstoryFanaticVersionModElements.ModElement.Tag
public class StartProcedure extends NewgenstoryFanaticVersionModElements.ModElement {
	public StartProcedure(NewgenstoryFanaticVersionModElements instance) {
		super(instance, 3);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency entity for procedure Start!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency x for procedure Start!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency y for procedure Start!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency z for procedure Start!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency world for procedure Start!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean test = false;
		if ((((entity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NewgenstoryFanaticVersionModVariables.PlayerVariables())).EnterPlayer) == 0)) {
			if (world instanceof World && !world.getWorld().isRemote) {
				Entity entityToSpawn = new LeftarionEntity.CustomEntity(LeftarionEntity.entity, world.getWorld());
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
								"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u041D\u0435\u0437\u043D\u0430\u043A\u043E\u043C\u0435\u0446!"),
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
										"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u0420\u0430\u043D\u044C\u0448\u0435 \u044F \u0442\u0435\u0431\u044F \u0437\u0434\u0435\u0441\u044C \u043D\u0435 \u0432\u0438\u0434\u0435\u043B, \u0430 \u044D\u0442\u043E \u043C\u043E\u0436\u0435\u0442 \u0437\u043D\u0430\u0447\u0438\u0442\u044C \u043B\u0438\u0448\u044C \u0442\u043E, \u0447\u0442\u043E..."),
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
												"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u041E \u0413\u043E\u0441\u043F\u043E\u0434\u0438, \u0433\u0434\u0435 \u0436\u0435 \u043C\u043E\u0438 \u043C\u0430\u043D\u0435\u0440\u044B... \u041C\u043E\u0451 \u0438\u043C\u044F - \u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D."),
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
														"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u0418 \u0440\u0430\u0437 \u0443\u0436 \u0442\u044B \u0437\u0434\u0435\u0441\u044C, \u043C\u043D\u0435 \u043D\u0435\u043E\u0431\u0445\u043E\u0434\u0438\u043C\u043E \u0442\u0435\u0431\u044F \u043F\u0440\u0435\u0434\u0443\u043F\u0440\u0435\u0434\u0438\u0442\u044C..."),
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
																"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u042D\u0442\u0438\u043C\u0438 \u043B\u0435\u0441\u0430\u043C\u0438 \u0438 \u043F\u043E\u043B\u044F\u043C\u0438 \u043F\u0440\u0430\u0432\u044F\u0442 \u043D\u043E\u0432\u044B\u0435 \u0431\u043E\u0433\u0438, \u0430 \u0432\u0440\u0430\u0442\u0430 \u0432 \u0438\u0437\u043C\u0435\u0440\u0435\u043D\u0438\u0435 \u043F\u043B\u0430\u043C\u0435\u043D\u0438 \u0431\u043E\u043B\u044C\u0448\u0435 \u043D\u0435 \u043E\u0442\u043A\u0440\u044B\u0442\u044C..."),
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
																		"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u0411\u043E\u043B\u044C\u0448\u0435\u0433\u043E \u044F \u0441\u043A\u0430\u0437\u0430\u0442\u044C \u043D\u0435 \u043C\u043E\u0433\u0443, \u0437\u0434\u0435\u0441\u044C \u043F\u043E\u0432\u0441\u044E\u0434\u0443 \u0447\u0443\u0436\u0438\u0435 \u0433\u043B\u0430\u0437\u0430 \u0438 \u0443\u0448\u0438..."),
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
																				"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u0417\u043D\u0430\u044E, \u0442\u0435\u043F\u0435\u0440\u044C \u0443 \u0442\u0435\u0431\u044F \u043F\u043E\u044F\u0432\u0438\u043B\u043E\u0441\u044C \u0442\u0430\u043A \u043C\u043D\u043E\u0433\u043E \u0432\u043E\u043F\u0440\u043E\u0441\u043E\u0432..."),
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
																						"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u0418\u0449\u0438 \u043C\u0435\u043D\u044F \u043D\u0430 \u0432\u0435\u0440\u0448\u0438\u043D\u0435 \u0433\u0438\u0433\u0430\u043D\u0442\u0441\u043A\u043E\u0439 \u0433\u043E\u0440\u044B, \u0435\u0441\u043B\u0438 \u0445\u043E\u0447\u0435\u0448\u044C \u0443\u0437\u043D\u0430\u0442\u044C \u043D\u0430 \u043D\u0438\u0445 \u043E\u0442\u0432\u0435\u0442..."),
																						(false));
																			}
																			if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
																				world.getWorld().getServer().getCommandManager()
																						.handleCommand(new CommandSource(ICommandSource.DUMMY,
																								new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world,
																								4, "", new StringTextComponent(""), world
																										.getWorld().getServer(),
																								null).withFeedbackDisabled(),
																								"kill @e[type=newgenstory_fanatic_version:leftarion]");
																			}
																			if (entity instanceof ServerPlayerEntity) {
																				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server)
																						.getAdvancementManager().getAdvancement(new ResourceLocation(
																								"newgenstory_fanatic_version:start_1"));
																				AdvancementProgress _ap = ((ServerPlayerEntity) entity)
																						.getAdvancements().getProgress(_adv);
																				if (!_ap.isDone()) {
																					Iterator _iterator = _ap.getRemaningCriteria().iterator();
																					while (_iterator.hasNext()) {
																						String _criterion = (String) _iterator.next();
																						((ServerPlayerEntity) entity).getAdvancements()
																								.grantCriterion(_adv, _criterion);
																					}
																				}
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
																						double _setval = (double) 2;
																						entity.getCapability(
																								NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY,
																								null).ifPresent(capability -> {
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
				double _setval = (double) 1;
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
