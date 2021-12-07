package net.mcreator.newgenstoryfanaticversion.procedures;

import net.minecraftforge.registries.ForgeRegistries;
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
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;

import net.mcreator.newgenstoryfanaticversion.entity.FairyOldLololoshkaEntity;
import net.mcreator.newgenstoryfanaticversion.entity.FairyNewLololoshkaEntity;
import net.mcreator.newgenstoryfanaticversion.entity.FairyLololoshka21Entity;
import net.mcreator.newgenstoryfanaticversion.entity.Fairy21Entity;
import net.mcreator.newgenstoryfanaticversion.block.LoranBlock;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModVariables;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModElements;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionMod;

import java.util.Map;

@NewgenstoryFanaticVersionModElements.ModElement.Tag
public class FairyRightClickedOnEntityProcedure extends NewgenstoryFanaticVersionModElements.ModElement {
	public FairyRightClickedOnEntityProcedure(NewgenstoryFanaticVersionModElements instance) {
		super(instance, 49);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency entity for procedure FairyRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency sourceentity for procedure FairyRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency x for procedure FairyRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency y for procedure FairyRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency z for procedure FairyRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency world for procedure FairyRightClickedOnEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((sourceentity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NewgenstoryFanaticVersionModVariables.PlayerVariables())).EsterEgg21) == 0)) {
			if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Blocks.DANDELION.asItem())) {
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
									.getValue(new ResourceLocation("newgenstory_fanatic_version:vinks")),
							SoundCategory.HOSTILE, (float) 10, (float) 1);
				} else {
					world.getWorld().playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
									.getValue(new ResourceLocation("newgenstory_fanatic_version:vinks")),
							SoundCategory.HOSTILE, (float) 10, (float) 1, false);
				}
				if (sourceentity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Blocks.DANDELION);
					((PlayerEntity) sourceentity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
				if (!entity.world.isRemote)
					entity.remove();
				if (world instanceof World && !world.getWorld().isRemote) {
					Entity entityToSpawn = new FairyOldLololoshkaEntity.CustomEntity(FairyOldLololoshkaEntity.entity, world.getWorld());
					entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
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
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote) {
							((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent(
									"\u00A76<\u0421\u0438\u0441\u0442\u0435\u043C\u0430 \u043E\u043F\u043E\u0432\u0435\u0449\u0435\u043D\u0438\u044F \u0438\u0433\u0440\u043E\u043A\u043E\u0432> \u041F\u043E\u0437\u0434\u0440\u0430\u0432\u043B\u044F\u0435\u043C!"),
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
											"\u00A76<\u0421\u0438\u0441\u0442\u0435\u043C\u0430 \u043E\u043F\u043E\u0432\u0435\u0449\u0435\u043D\u0438\u044F \u0438\u0433\u0440\u043E\u043A\u043E\u0432> \u0412\u044B \u043E\u0431\u043D\u0430\u0440\u0443\u0436\u0438\u043B\u0438 \u0432\u0442\u043E\u0440\u0443\u044E \u043F\u0430\u0441\u0445\u0430\u043B\u043A\u0443!"),
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
													"\u00A76<\u0421\u0438\u0441\u0442\u0435\u043C\u0430 \u043E\u043F\u043E\u0432\u0435\u0449\u0435\u043D\u0438\u044F \u0438\u0433\u0440\u043E\u043A\u043E\u0432> \u0421\u043E\u0431\u0435\u0440\u0438\u0442\u0435 \u043A\u0430\u0436\u0434\u0443\u044E \u0438\u0437 \u043D\u0438\u0445, \u0447\u0442\u043E\u0431\u044B \u043F\u043E\u043B\u0443\u0447\u0438\u0442\u044C \u043A \u0441\u0435\u043A\u0440\u0435\u0442\u043D\u043E\u043C\u0443 \u0434\u043E\u043A\u0443\u043C\u0435\u043D\u0442\u0443"),
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
															"\u00A76<\u0421\u0438\u0441\u0442\u0435\u043C\u0430 \u043E\u043F\u043E\u0432\u0435\u0449\u0435\u043D\u0438\u044F \u0438\u0433\u0440\u043E\u043A\u043E\u0432> \u041F\u043E\u0434\u0441\u043A\u0430\u0437\u043A\u0430 \u21162 \u0413\u043E\u0440\u0431\u0430\u0442\u0438\u043A \u0438 \u041B\u0435\u0444\u0442\u0435\u0440\u0435\u043E\u043D \u0432\u0430\u0436\u043D\u044B\u0435 \u043F\u0435\u0440\u0441\u043E\u043D\u0430\u0436\u0438 \u0431\u0443\u0434\u044C \u0432\u043D\u0438\u043C\u0430\u0442\u0435\u043B\u044C\u043D\u0435\u0435"),
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
																	"kill @e[type=newgenstory_fanatic_version:fairy_old_lololoshka]");
														}
														{
															double _setval = (double) 2;
															sourceentity
																	.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY,
																			null)
																	.ifPresent(capability -> {
																		capability.EsterEgg21 = _setval;
																		capability.syncPlayerVariables(sourceentity);
																	});
														}
														MinecraftForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 1560);
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
					double _setval = (double) 1;
					sourceentity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.EsterEgg21 = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			}
		}
		if ((((sourceentity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NewgenstoryFanaticVersionModVariables.PlayerVariables())).EsterEgg21) == 0)) {
			if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Blocks.POPPY.asItem())) {
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
									.getValue(new ResourceLocation("newgenstory_fanatic_version:newproject21")),
							SoundCategory.HOSTILE, (float) 10, (float) 1);
				} else {
					world.getWorld().playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
									.getValue(new ResourceLocation("newgenstory_fanatic_version:newproject21")),
							SoundCategory.HOSTILE, (float) 10, (float) 1, false);
				}
				if (sourceentity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Blocks.POPPY);
					((PlayerEntity) sourceentity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
				if (!entity.world.isRemote)
					entity.remove();
				if (world instanceof World && !world.getWorld().isRemote) {
					Entity entityToSpawn = new FairyLololoshka21Entity.CustomEntity(FairyLololoshka21Entity.entity, world.getWorld());
					entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
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
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote) {
							((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent(
									"\u00A76<\u0421\u0438\u0441\u0442\u0435\u043C\u0430 \u043E\u043F\u043E\u0432\u0435\u0449\u0435\u043D\u0438\u044F \u0438\u0433\u0440\u043E\u043A\u043E\u0432> \u041F\u043E\u0437\u0434\u0440\u0430\u0432\u043B\u044F\u0435\u043C!"),
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
											"\u00A76<\u0421\u0438\u0441\u0442\u0435\u043C\u0430 \u043E\u043F\u043E\u0432\u0435\u0449\u0435\u043D\u0438\u044F \u0438\u0433\u0440\u043E\u043A\u043E\u0432> \u0412\u044B \u043E\u0431\u043D\u0430\u0440\u0443\u0436\u0438\u043B\u0438 \u0432\u0442\u043E\u0440\u0443\u044E \u043F\u0430\u0441\u0445\u0430\u043B\u043A\u0443!"),
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
													"\u00A76<\u0421\u0438\u0441\u0442\u0435\u043C\u0430 \u043E\u043F\u043E\u0432\u0435\u0449\u0435\u043D\u0438\u044F \u0438\u0433\u0440\u043E\u043A\u043E\u0432> \u0421\u043E\u0431\u0435\u0440\u0438\u0442\u0435 \u043A\u0430\u0436\u0434\u0443\u044E \u0438\u0437 \u043D\u0438\u0445, \u0447\u0442\u043E\u0431\u044B \u043F\u043E\u043B\u0443\u0447\u0438\u0442\u044C \u043A \u0441\u0435\u043A\u0440\u0435\u0442\u043D\u043E\u043C\u0443 \u0434\u043E\u043A\u0443\u043C\u0435\u043D\u0442\u0443"),
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
															"\u00A76<\u0421\u0438\u0441\u0442\u0435\u043C\u0430 \u043E\u043F\u043E\u0432\u0435\u0449\u0435\u043D\u0438\u044F \u0438\u0433\u0440\u043E\u043A\u043E\u0432> \u041F\u043E\u0434\u0441\u043A\u0430\u0437\u043A\u0430 \u21162 \u0413\u043E\u0440\u0431\u0430\u0442\u0438\u043A \u0438 \u041B\u0435\u0444\u0442\u0435\u0440\u0435\u043E\u043D \u0432\u0430\u0436\u043D\u044B\u0435 \u043F\u0435\u0440\u0441\u043E\u043D\u0430\u0436\u0438 \u0431\u0443\u0434\u044C \u0432\u043D\u0438\u043C\u0430\u0442\u0435\u043B\u044C\u043D\u0435\u0435"),
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
																	"kill @e[type=newgenstory_fanatic_version:fairy_lololoshka_21]");
														}
														{
															double _setval = (double) 2;
															sourceentity
																	.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY,
																			null)
																	.ifPresent(capability -> {
																		capability.EsterEgg21 = _setval;
																		capability.syncPlayerVariables(sourceentity);
																	});
														}
														MinecraftForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 1280);
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
					double _setval = (double) 1;
					sourceentity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.EsterEgg21 = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			}
		}
		if ((((sourceentity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NewgenstoryFanaticVersionModVariables.PlayerVariables())).EsterEgg21) == 0)) {
			if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == LoranBlock.block.asItem())) {
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
									.getValue(new ResourceLocation("newgenstory_fanatic_version:loran")),
							SoundCategory.HOSTILE, (float) 10, (float) 1);
				} else {
					world.getWorld().playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
									.getValue(new ResourceLocation("newgenstory_fanatic_version:loran")),
							SoundCategory.HOSTILE, (float) 10, (float) 1, false);
				}
				if (sourceentity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(LoranBlock.block);
					((PlayerEntity) sourceentity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
				if (!entity.world.isRemote)
					entity.remove();
				if (world instanceof World && !world.getWorld().isRemote) {
					Entity entityToSpawn = new FairyNewLololoshkaEntity.CustomEntity(FairyNewLololoshkaEntity.entity, world.getWorld());
					entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
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
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote) {
							((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent(
									"\u00A76<\u0421\u0438\u0441\u0442\u0435\u043C\u0430 \u043E\u043F\u043E\u0432\u0435\u0449\u0435\u043D\u0438\u044F \u0438\u0433\u0440\u043E\u043A\u043E\u0432> \u041F\u043E\u0437\u0434\u0440\u0430\u0432\u043B\u044F\u0435\u043C!"),
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
											"\u00A76<\u0421\u0438\u0441\u0442\u0435\u043C\u0430 \u043E\u043F\u043E\u0432\u0435\u0449\u0435\u043D\u0438\u044F \u0438\u0433\u0440\u043E\u043A\u043E\u0432> \u0412\u044B \u043E\u0431\u043D\u0430\u0440\u0443\u0436\u0438\u043B\u0438 \u0432\u0442\u043E\u0440\u0443\u044E \u043F\u0430\u0441\u0445\u0430\u043B\u043A\u0443!"),
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
													"\u00A76<\u0421\u0438\u0441\u0442\u0435\u043C\u0430 \u043E\u043F\u043E\u0432\u0435\u0449\u0435\u043D\u0438\u044F \u0438\u0433\u0440\u043E\u043A\u043E\u0432> \u0421\u043E\u0431\u0435\u0440\u0438\u0442\u0435 \u043A\u0430\u0436\u0434\u0443\u044E \u0438\u0437 \u043D\u0438\u0445, \u0447\u0442\u043E\u0431\u044B \u043F\u043E\u043B\u0443\u0447\u0438\u0442\u044C \u043A \u0441\u0435\u043A\u0440\u0435\u0442\u043D\u043E\u043C\u0443 \u0434\u043E\u043A\u0443\u043C\u0435\u043D\u0442\u0443"),
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
															"\u00A76<\u0421\u0438\u0441\u0442\u0435\u043C\u0430 \u043E\u043F\u043E\u0432\u0435\u0449\u0435\u043D\u0438\u044F \u0438\u0433\u0440\u043E\u043A\u043E\u0432> \u041F\u043E\u0434\u0441\u043A\u0430\u0437\u043A\u0430 \u21162 \u0413\u043E\u0440\u0431\u0430\u0442\u0438\u043A \u0438 \u041B\u0435\u0444\u0442\u0435\u0440\u0435\u043E\u043D \u0432\u0430\u0436\u043D\u044B\u0435 \u043F\u0435\u0440\u0441\u043E\u043D\u0430\u0436\u0438 \u0431\u0443\u0434\u044C \u0432\u043D\u0438\u043C\u0430\u0442\u0435\u043B\u044C\u043D\u0435\u0435"),
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
																	"kill @e[type=newgenstory_fanatic_version:fairy_new_lololoshka]");
														}
														{
															double _setval = (double) 2;
															sourceentity
																	.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY,
																			null)
																	.ifPresent(capability -> {
																		capability.EsterEgg21 = _setval;
																		capability.syncPlayerVariables(sourceentity);
																	});
														}
														MinecraftForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 3940);
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
					double _setval = (double) 1;
					sourceentity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.EsterEgg21 = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			}
		}
		if ((((sourceentity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NewgenstoryFanaticVersionModVariables.PlayerVariables())).EsterEgg21) == 0)) {
			if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Items.PUFFERFISH)) {
				if (!world.getWorld().isRemote) {
					world.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
									.getValue(new ResourceLocation("newgenstory_fanatic_version:newproject32")),
							SoundCategory.HOSTILE, (float) 10, (float) 1);
				} else {
					world.getWorld().playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
									.getValue(new ResourceLocation("newgenstory_fanatic_version:newproject32")),
							SoundCategory.HOSTILE, (float) 10, (float) 1, false);
				}
				if (sourceentity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Items.PUFFERFISH);
					((PlayerEntity) sourceentity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
				if (!entity.world.isRemote)
					entity.remove();
				if (world instanceof World && !world.getWorld().isRemote) {
					Entity entityToSpawn = new Fairy21Entity.CustomEntity(Fairy21Entity.entity, world.getWorld());
					entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
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
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent(
											"<\u0424\u0435\u044F> \u042F \u041D\u0415 \u0413\u041E\u0420\u0411\u0410\u0422\u0418\u041A!!!!!!"),
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
											"<\u0424\u0435\u044F> \u042F \u0421\u0418\u041B\u042C\u041D\u0410\u042F \u041D\u0415\u0417\u0410\u0412\u0418\u0421\u0418\u041C\u0410\u042F \u0424\u0415\u042F!!! \u0425\u0410\u0420\u0415 \u0421\u041F\u0406\u0412\u0410\u0422\u042C! \u041F\u041E\u041B\u0415\u0422\u0406\u041B\u0418 \u041E\u0422\u0421\u042E\u0414\u0410"),
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
													"\u00A76<\u0421\u0438\u0441\u0442\u0435\u043C\u0430 \u043E\u043F\u043E\u0432\u0435\u0449\u0435\u043D\u0438\u044F \u0438\u0433\u0440\u043E\u043A\u043E\u0432> \u041F\u043E\u0437\u0434\u0440\u0430\u0432\u043B\u044F\u0435\u043C!"),
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
															"\u00A76<\u0421\u0438\u0441\u0442\u0435\u043C\u0430 \u043E\u043F\u043E\u0432\u0435\u0449\u0435\u043D\u0438\u044F \u0438\u0433\u0440\u043E\u043A\u043E\u0432> \u0412\u044B \u043E\u0431\u043D\u0430\u0440\u0443\u0436\u0438\u043B\u0438 \u0432\u0442\u043E\u0440\u0443\u044E \u043F\u0430\u0441\u0445\u0430\u043B\u043A\u0443!"),
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
																	"\u00A76<\u0421\u0438\u0441\u0442\u0435\u043C\u0430 \u043E\u043F\u043E\u0432\u0435\u0449\u0435\u043D\u0438\u044F \u0438\u0433\u0440\u043E\u043A\u043E\u0432> \u0421\u043E\u0431\u0435\u0440\u0438\u0442\u0435 \u043A\u0430\u0436\u0434\u0443\u044E \u0438\u0437 \u043D\u0438\u0445, \u0447\u0442\u043E\u0431\u044B \u043F\u043E\u043B\u0443\u0447\u0438\u0442\u044C \u043A \u0441\u0435\u043A\u0440\u0435\u0442\u043D\u043E\u043C\u0443 \u0434\u043E\u043A\u0443\u043C\u0435\u043D\u0442\u0443"),
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
																			"\u00A76<\u0421\u0438\u0441\u0442\u0435\u043C\u0430 \u043E\u043F\u043E\u0432\u0435\u0449\u0435\u043D\u0438\u044F \u0438\u0433\u0440\u043E\u043A\u043E\u0432> \u041F\u043E\u0434\u0441\u043A\u0430\u0437\u043A\u0430 \u21162 \u0413\u043E\u0440\u0431\u0430\u0442\u0438\u043A \u0438 \u041B\u0435\u0444\u0442\u0435\u0440\u0435\u043E\u043D \u0432\u0430\u0436\u043D\u044B\u0435 \u043F\u0435\u0440\u0441\u043E\u043D\u0430\u0436\u0438 \u0431\u0443\u0434\u044C \u0432\u043D\u0438\u043C\u0430\u0442\u0435\u043B\u044C\u043D\u0435\u0435"),
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
																					new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z),
																							Vec2f.ZERO, (ServerWorld) world, 4, "",
																							new StringTextComponent(""), world.getWorld().getServer(),
																							null).withFeedbackDisabled(),
																					"kill @e[type=newgenstory_fanatic_version:fairy_21]");
																		}
																		{
																			double _setval = (double) 2;
																			sourceentity.getCapability(
																					NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY,
																					null).ifPresent(capability -> {
																						capability.EsterEgg21 = _setval;
																						capability.syncPlayerVariables(sourceentity);
																					});
																		}
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
					double _setval = (double) 1;
					sourceentity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.EsterEgg21 = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			}
		}
	}
}
