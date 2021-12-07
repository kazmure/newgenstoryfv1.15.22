
package net.mcreator.newgenstoryfanaticversion.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.network.IPacket;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.newgenstoryfanaticversion.procedures.StartProcedureProcedure;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModElements;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@NewgenstoryFanaticVersionModElements.ModElement.Tag
public class ReterionEntity extends NewgenstoryFanaticVersionModElements.ModElement {
	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
			.size(7f, 2f)).build("reterion").setRegistryName("reterion");
	public ReterionEntity(NewgenstoryFanaticVersionModElements instance) {
		super(instance, 29);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelenderdragon(), 2f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("newgenstory_fanatic_version:textures/reatorion.png");
				}
			};
		});
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
			enablePersistence();
			this.moveController = new FlyingMovementController(this, 10, true);
			this.navigator = new FlyingPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 2, 20) {
				@Override
				protected Vec3d getPosition() {
					Random random = CustomEntity.this.getRNG();
					double dir_x = CustomEntity.this.getPosX() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_y = CustomEntity.this.getPosY() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_z = CustomEntity.this.getPosZ() + ((random.nextFloat() * 2 - 1) * 16);
					return new Vec3d(dir_x, dir_y, dir_z);
				}
			});
			this.goalSelector.addGoal(2, new TemptGoal(this, 1, Ingredient.fromItems(Blocks.AIR.asItem()), false));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean onLivingFall(float l, float d) {
			return false;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof ArrowEntity)
				return false;
			if (source.getImmediateSource() instanceof PlayerEntity)
				return false;
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			if (source.isExplosion())
				return false;
			if (source.getDamageType().equals("trident"))
				return false;
			if (source == DamageSource.ANVIL)
				return false;
			if (source == DamageSource.DRAGON_BREATH)
				return false;
			if (source == DamageSource.WITHER)
				return false;
			if (source.getDamageType().equals("witherSkull"))
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void onDeath(DamageSource source) {
			super.onDeath(source);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity sourceentity = source.getTrueSource();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				StartProcedureProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1000);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
			if (this.getAttribute(SharedMonsterAttributes.FLYING_SPEED) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.3);
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		public void livingTick() {
			super.livingTick();
			this.setNoGravity(true);
		}
	}

	// Made with Blockbench 4.0.3
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelenderdragon extends EntityModel<Entity> {
		private final ModelRenderer neck;
		private final ModelRenderer neck2;
		private final ModelRenderer neck3;
		private final ModelRenderer neck4;
		private final ModelRenderer neck5;
		private final ModelRenderer head;
		private final ModelRenderer jaw;
		private final ModelRenderer body;
		private final ModelRenderer wing;
		private final ModelRenderer wingtip;
		private final ModelRenderer wing1;
		private final ModelRenderer wingtip1;
		private final ModelRenderer rearleg;
		private final ModelRenderer rearlegtip;
		private final ModelRenderer rearfoot;
		private final ModelRenderer rearleg1;
		private final ModelRenderer rearlegtip1;
		private final ModelRenderer rearfoot1;
		private final ModelRenderer frontleg;
		private final ModelRenderer frontlegtip;
		private final ModelRenderer frontfoot;
		private final ModelRenderer frontleg1;
		private final ModelRenderer frontlegtip1;
		private final ModelRenderer frontfoot1;
		private final ModelRenderer tail;
		private final ModelRenderer tail2;
		private final ModelRenderer tail3;
		private final ModelRenderer tail4;
		private final ModelRenderer tail5;
		private final ModelRenderer tail6;
		private final ModelRenderer tail7;
		private final ModelRenderer tail8;
		private final ModelRenderer tail9;
		private final ModelRenderer tail10;
		private final ModelRenderer tail11;
		private final ModelRenderer tail12;
		public Modelenderdragon() {
			textureWidth = 256;
			textureHeight = 256;
			neck = new ModelRenderer(this);
			neck.setRotationPoint(0.0F, 17.0F, -8.0F);
			setRotationAngle(neck, -0.0873F, 0.0F, 0.0F);
			neck.setTextureOffset(192, 104).addBox(-5.0F, -5.0F, -10.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
			neck.setTextureOffset(48, 0).addBox(-1.0F, -9.0F, -8.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
			neck2 = new ModelRenderer(this);
			neck2.setRotationPoint(0.0F, 0.0F, -10.0F);
			neck.addChild(neck2);
			setRotationAngle(neck2, 0.0873F, 0.0F, 0.0F);
			neck2.setTextureOffset(192, 104).addBox(-5.0F, -5.0F, -10.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
			neck2.setTextureOffset(48, 0).addBox(-1.0F, -9.0F, -8.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
			neck3 = new ModelRenderer(this);
			neck3.setRotationPoint(0.0F, 0.0F, -10.0F);
			neck2.addChild(neck3);
			setRotationAngle(neck3, 0.0873F, 0.0F, 0.0F);
			neck3.setTextureOffset(192, 104).addBox(-5.0F, -5.0F, -10.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
			neck3.setTextureOffset(48, 0).addBox(-1.0F, -9.0F, -8.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
			neck4 = new ModelRenderer(this);
			neck4.setRotationPoint(0.0F, 0.0F, -10.0F);
			neck3.addChild(neck4);
			setRotationAngle(neck4, 0.0873F, 0.0F, 0.0F);
			neck4.setTextureOffset(192, 104).addBox(-5.0F, -5.0F, -10.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
			neck4.setTextureOffset(48, 0).addBox(-1.0F, -9.0F, -8.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
			neck5 = new ModelRenderer(this);
			neck5.setRotationPoint(0.0F, 0.0F, -10.0F);
			neck4.addChild(neck5);
			setRotationAngle(neck5, 0.0873F, 0.0F, 0.0F);
			neck5.setTextureOffset(192, 104).addBox(-5.0F, -5.0F, -10.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
			neck5.setTextureOffset(48, 0).addBox(-1.0F, -9.0F, -8.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 0.0F, -10.0F);
			neck5.addChild(head);
			setRotationAngle(head, 0.0873F, 0.0F, 0.0F);
			head.setTextureOffset(176, 44).addBox(-6.0F, -1.0F, -30.0F, 12.0F, 5.0F, 16.0F, 0.0F, false);
			head.setTextureOffset(112, 30).addBox(-8.0F, -8.0F, -16.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-5.0F, -12.0F, -10.0F, 2.0F, 4.0F, 6.0F, 0.0F, true);
			head.setTextureOffset(112, 0).addBox(-5.0F, -3.0F, -28.0F, 2.0F, 2.0F, 4.0F, 0.0F, true);
			head.setTextureOffset(0, 0).addBox(3.0F, -12.0F, -10.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
			head.setTextureOffset(112, 0).addBox(3.0F, -3.0F, -28.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			jaw = new ModelRenderer(this);
			jaw.setRotationPoint(0.0F, 4.0F, -13.0F);
			head.addChild(jaw);
			setRotationAngle(jaw, 0.2618F, 0.0F, 0.0F);
			jaw.setTextureOffset(176, 65).addBox(-6.0F, 0.0F, -17.0F, 12.0F, 4.0F, 16.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 4.0F, 8.0F);
			body.setTextureOffset(0, 0).addBox(-12.0F, 0.0F, -16.0F, 24.0F, 24.0F, 64.0F, 0.0F, false);
			body.setTextureOffset(220, 53).addBox(-1.0F, -6.0F, -10.0F, 2.0F, 6.0F, 12.0F, 0.0F, false);
			body.setTextureOffset(220, 53).addBox(-1.0F, -6.0F, 10.0F, 2.0F, 6.0F, 12.0F, 0.0F, false);
			body.setTextureOffset(220, 53).addBox(-1.0F, -6.0F, 30.0F, 2.0F, 6.0F, 12.0F, 0.0F, false);
			wing = new ModelRenderer(this);
			wing.setRotationPoint(-12.0F, 5.0F, 2.0F);
			setRotationAngle(wing, 0.0F, 0.1745F, 0.1745F);
			wing.setTextureOffset(112, 88).addBox(-56.0F, -4.0F, -4.0F, 56.0F, 8.0F, 8.0F, 0.0F, false);
			wing.setTextureOffset(-56, 88).addBox(-56.0F, 0.0F, 2.0F, 56.0F, 0.0F, 56.0F, 0.01F, false);
			wingtip = new ModelRenderer(this);
			wingtip.setRotationPoint(-56.0F, 0.0F, -2.0F);
			wing.addChild(wingtip);
			setRotationAngle(wingtip, 0.0F, 0.0F, -0.3491F);
			wingtip.setTextureOffset(112, 136).addBox(-56.0F, -2.0F, 0.0F, 56.0F, 4.0F, 4.0F, 0.0F, false);
			wingtip.setTextureOffset(-56, 144).addBox(-56.0F, 0.0F, 4.0F, 56.0F, 0.0F, 56.0F, 0.01F, false);
			wing1 = new ModelRenderer(this);
			wing1.setRotationPoint(12.0F, 5.0F, 2.0F);
			setRotationAngle(wing1, 0.0F, -0.1745F, -0.1745F);
			wing1.setTextureOffset(112, 88).addBox(0.0F, -4.0F, -4.0F, 56.0F, 8.0F, 8.0F, 0.0F, true);
			wing1.setTextureOffset(-56, 88).addBox(0.0F, 0.0F, 2.0F, 56.0F, 0.0F, 56.0F, 0.01F, true);
			wingtip1 = new ModelRenderer(this);
			wingtip1.setRotationPoint(56.0F, 0.0F, -2.0F);
			wing1.addChild(wingtip1);
			setRotationAngle(wingtip1, 0.0F, 0.0F, 0.3491F);
			wingtip1.setTextureOffset(112, 136).addBox(0.0F, -2.0F, 0.0F, 56.0F, 4.0F, 4.0F, 0.0F, true);
			wingtip1.setTextureOffset(-56, 144).addBox(0.0F, 0.0F, 4.0F, 56.0F, 0.0F, 56.0F, 0.01F, true);
			rearleg = new ModelRenderer(this);
			rearleg.setRotationPoint(-16.0F, 16.0F, 42.0F);
			setRotationAngle(rearleg, 1.0472F, 0.0F, 0.0F);
			rearleg.setTextureOffset(0, 0).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 32.0F, 16.0F, 0.0F, false);
			rearlegtip = new ModelRenderer(this);
			rearlegtip.setRotationPoint(0.0F, 28.0F, 1.0F);
			rearleg.addChild(rearlegtip);
			setRotationAngle(rearlegtip, 0.4363F, 0.0F, 0.0F);
			rearlegtip.setTextureOffset(196, 0).addBox(-6.0F, 0.0F, -7.0F, 12.0F, 32.0F, 12.0F, 0.0F, false);
			rearfoot = new ModelRenderer(this);
			rearfoot.setRotationPoint(0.0F, 32.0F, -2.0F);
			rearlegtip.addChild(rearfoot);
			setRotationAngle(rearfoot, 0.7854F, 0.0F, 0.0F);
			rearfoot.setTextureOffset(112, 0).addBox(-9.0F, 0.0F, -20.0F, 18.0F, 6.0F, 24.0F, 0.0F, false);
			rearleg1 = new ModelRenderer(this);
			rearleg1.setRotationPoint(16.0F, 16.0F, 42.0F);
			setRotationAngle(rearleg1, 1.0472F, 0.0F, 0.0F);
			rearleg1.setTextureOffset(0, 0).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 32.0F, 16.0F, 0.0F, true);
			rearlegtip1 = new ModelRenderer(this);
			rearlegtip1.setRotationPoint(0.0F, 28.0F, 1.0F);
			rearleg1.addChild(rearlegtip1);
			setRotationAngle(rearlegtip1, 0.4363F, 0.0F, 0.0F);
			rearlegtip1.setTextureOffset(196, 0).addBox(-6.0F, 0.0F, -7.0F, 12.0F, 32.0F, 12.0F, 0.0F, true);
			rearfoot1 = new ModelRenderer(this);
			rearfoot1.setRotationPoint(0.0F, 32.0F, -2.0F);
			rearlegtip1.addChild(rearfoot1);
			setRotationAngle(rearfoot1, 0.7854F, 0.0F, 0.0F);
			rearfoot1.setTextureOffset(112, 0).addBox(-9.0F, 0.0F, -20.0F, 18.0F, 6.0F, 24.0F, 0.0F, true);
			frontleg = new ModelRenderer(this);
			frontleg.setRotationPoint(-12.0F, 20.0F, 2.0F);
			setRotationAngle(frontleg, 1.1345F, 0.0F, 0.0F);
			frontleg.setTextureOffset(112, 104).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 24.0F, 8.0F, 0.0F, false);
			frontlegtip = new ModelRenderer(this);
			frontlegtip.setRotationPoint(0.0F, 20.0F, 0.0F);
			frontleg.addChild(frontlegtip);
			setRotationAngle(frontlegtip, -0.3491F, 0.0F, 0.0F);
			frontlegtip.setTextureOffset(226, 138).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 24.0F, 6.0F, 0.0F, false);
			frontfoot = new ModelRenderer(this);
			frontfoot.setRotationPoint(0.0F, 22.0F, 0.0F);
			frontlegtip.addChild(frontfoot);
			setRotationAngle(frontfoot, 0.7854F, 0.0F, 0.0F);
			frontfoot.setTextureOffset(144, 104).addBox(-4.0F, 0.0F, -12.0F, 8.0F, 4.0F, 16.0F, 0.0F, false);
			frontleg1 = new ModelRenderer(this);
			frontleg1.setRotationPoint(12.0F, 20.0F, 2.0F);
			setRotationAngle(frontleg1, 1.1345F, 0.0F, 0.0F);
			frontleg1.setTextureOffset(112, 104).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 24.0F, 8.0F, 0.0F, true);
			frontlegtip1 = new ModelRenderer(this);
			frontlegtip1.setRotationPoint(0.0F, 20.0F, 0.0F);
			frontleg1.addChild(frontlegtip1);
			setRotationAngle(frontlegtip1, -0.3491F, 0.0F, 0.0F);
			frontlegtip1.setTextureOffset(226, 138).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 24.0F, 6.0F, 0.0F, true);
			frontfoot1 = new ModelRenderer(this);
			frontfoot1.setRotationPoint(0.0F, 22.0F, 0.0F);
			frontlegtip1.addChild(frontfoot1);
			setRotationAngle(frontfoot1, 0.7854F, 0.0F, 0.0F);
			frontfoot1.setTextureOffset(144, 104).addBox(-4.0F, 0.0F, -12.0F, 8.0F, 4.0F, 16.0F, 0.0F, true);
			tail = new ModelRenderer(this);
			tail.setRotationPoint(0.0F, 10.0F, 56.0F);
			tail.setTextureOffset(192, 104).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
			tail.setTextureOffset(48, 0).addBox(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
			tail2 = new ModelRenderer(this);
			tail2.setRotationPoint(0.0F, 0.0F, 10.0F);
			tail.addChild(tail2);
			setRotationAngle(tail2, 0.0175F, 0.0F, 0.0F);
			tail2.setTextureOffset(192, 104).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
			tail2.setTextureOffset(48, 0).addBox(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
			tail3 = new ModelRenderer(this);
			tail3.setRotationPoint(0.0F, 0.0F, 10.0F);
			tail2.addChild(tail3);
			setRotationAngle(tail3, 0.0175F, 0.0F, 0.0F);
			tail3.setTextureOffset(192, 104).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
			tail3.setTextureOffset(48, 0).addBox(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
			tail4 = new ModelRenderer(this);
			tail4.setRotationPoint(0.0F, 0.0F, 10.0F);
			tail3.addChild(tail4);
			setRotationAngle(tail4, 0.0175F, 0.0F, 0.0F);
			tail4.setTextureOffset(192, 104).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
			tail4.setTextureOffset(48, 0).addBox(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
			tail5 = new ModelRenderer(this);
			tail5.setRotationPoint(0.0F, 0.0F, 10.0F);
			tail4.addChild(tail5);
			setRotationAngle(tail5, 0.0349F, 0.0F, 0.0F);
			tail5.setTextureOffset(192, 104).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
			tail5.setTextureOffset(48, 0).addBox(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
			tail6 = new ModelRenderer(this);
			tail6.setRotationPoint(0.0F, 0.0F, 10.0F);
			tail5.addChild(tail6);
			setRotationAngle(tail6, 0.0524F, 0.0F, 0.0F);
			tail6.setTextureOffset(192, 104).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
			tail6.setTextureOffset(48, 0).addBox(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
			tail7 = new ModelRenderer(this);
			tail7.setRotationPoint(0.0F, 0.0F, 10.0F);
			tail6.addChild(tail7);
			setRotationAngle(tail7, 0.0524F, 0.0F, 0.0F);
			tail7.setTextureOffset(192, 104).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
			tail7.setTextureOffset(48, 0).addBox(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
			tail8 = new ModelRenderer(this);
			tail8.setRotationPoint(0.0F, 0.0F, 10.0F);
			tail7.addChild(tail8);
			setRotationAngle(tail8, 0.0175F, 0.0F, 0.0F);
			tail8.setTextureOffset(192, 104).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
			tail8.setTextureOffset(48, 0).addBox(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
			tail9 = new ModelRenderer(this);
			tail9.setRotationPoint(0.0F, 0.0F, 10.0F);
			tail8.addChild(tail9);
			setRotationAngle(tail9, -0.0175F, 0.0F, 0.0F);
			tail9.setTextureOffset(192, 104).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
			tail9.setTextureOffset(48, 0).addBox(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
			tail10 = new ModelRenderer(this);
			tail10.setRotationPoint(0.0F, 0.0F, 10.0F);
			tail9.addChild(tail10);
			setRotationAngle(tail10, -0.0349F, 0.0F, 0.0F);
			tail10.setTextureOffset(192, 104).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
			tail10.setTextureOffset(48, 0).addBox(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
			tail11 = new ModelRenderer(this);
			tail11.setRotationPoint(0.0F, 0.0F, 10.0F);
			tail10.addChild(tail11);
			setRotationAngle(tail11, -0.0524F, 0.0F, 0.0F);
			tail11.setTextureOffset(192, 104).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
			tail11.setTextureOffset(48, 0).addBox(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
			tail12 = new ModelRenderer(this);
			tail12.setRotationPoint(0.0F, 0.0F, 10.0F);
			tail11.addChild(tail12);
			setRotationAngle(tail12, -0.0524F, 0.0F, 0.0F);
			tail12.setTextureOffset(192, 104).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
			tail12.setTextureOffset(48, 0).addBox(-1.0F, -9.0F, 2.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			neck.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			wing.render(matrixStack, buffer, packedLight, packedOverlay);
			wing1.render(matrixStack, buffer, packedLight, packedOverlay);
			rearleg.render(matrixStack, buffer, packedLight, packedOverlay);
			rearleg1.render(matrixStack, buffer, packedLight, packedOverlay);
			frontleg.render(matrixStack, buffer, packedLight, packedOverlay);
			frontleg1.render(matrixStack, buffer, packedLight, packedOverlay);
			tail.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.wing1.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
			this.wing.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}
}
