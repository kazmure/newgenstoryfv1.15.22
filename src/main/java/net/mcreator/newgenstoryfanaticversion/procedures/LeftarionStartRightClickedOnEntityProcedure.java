package net.mcreator.newgenstoryfanaticversion.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.newgenstoryfanaticversion.item.Paper32Item;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModVariables;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModElements;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionMod;

import java.util.Map;

@NewgenstoryFanaticVersionModElements.ModElement.Tag
public class LeftarionStartRightClickedOnEntityProcedure extends NewgenstoryFanaticVersionModElements.ModElement {
	public LeftarionStartRightClickedOnEntityProcedure(NewgenstoryFanaticVersionModElements instance) {
		super(instance, 44);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency sourceentity for procedure LeftarionStartRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency x for procedure LeftarionStartRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency y for procedure LeftarionStartRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency z for procedure LeftarionStartRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency world for procedure LeftarionStartRightClickedOnEntity!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((sourceentity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NewgenstoryFanaticVersionModVariables.PlayerVariables())).EnterPlayer) == 11)) {
			if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Paper32Item.block)) {
				if (sourceentity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Paper32Item.block);
					((PlayerEntity) sourceentity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
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
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote) {
							((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent(
									"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u041D\u0435\u0442... \u041D\u0435\u0442... \u041D\u0435 \u043C\u043E\u0436\u0435\u0442 \u0431\u044B\u0442\u044C!"),
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
								if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote) {
									((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent(
											"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u042D\u0442\u043E\u0433\u043E \u043F\u0440\u043E\u0441\u0442\u043E... \u043D\u0435 \u043C\u043E\u0436\u0435\u0442... \u0431\u044B\u0442\u044C..."),
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
										if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote) {
											((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent(
													"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u042F... \u042F \u0437\u043D\u0430\u044E, \u043A\u0442\u043E \u044D\u0442\u043E \u0441\u0434\u0435\u043B\u0430\u043B."),
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
												if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote) {
													((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent(
															"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u041E\u043D... \u041E\u043D \u0437\u0430\u043F\u043B\u0430\u0442\u0438\u0442!"),
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
														if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote) {
															((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent(
																	"<\u041B\u0435\u0444\u0442\u0430\u0440\u0438\u043E\u043D> \u042F \u0437\u0430\u0441\u0442\u0430\u0432\u043B\u044E \u0435\u0433\u043E \u0437\u0430\u043F\u043B\u0430\u0442\u0438\u0442\u044C..."),
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
																			new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO,
																					(ServerWorld) world, 4, "", new StringTextComponent(""),
																					world.getWorld().getServer(), null).withFeedbackDisabled(),
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
																			double _setval = (double) 14;
																			sourceentity.getCapability(
																					NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY,
																					null).ifPresent(capability -> {
																						capability.EnterPlayer = _setval;
																						capability.syncPlayerVariables(sourceentity);
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
				{
					double _setval = (double) 13;
					sourceentity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.EnterPlayer = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			}
		}
	}
}
