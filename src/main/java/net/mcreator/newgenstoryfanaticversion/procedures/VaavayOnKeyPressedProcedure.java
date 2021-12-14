package net.mcreator.newgenstoryfanaticversion.procedures;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.newgenstoryfanaticversion.gui.DialogGui;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModElements;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionMod;

import java.util.Map;

import io.netty.buffer.Unpooled;

@NewgenstoryFanaticVersionModElements.ModElement.Tag
public class VaavayOnKeyPressedProcedure extends NewgenstoryFanaticVersionModElements.ModElement {
	public VaavayOnKeyPressedProcedure(NewgenstoryFanaticVersionModElements instance) {
		super(instance, 86);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency entity for procedure VaavayOnKeyPressed!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency x for procedure VaavayOnKeyPressed!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency y for procedure VaavayOnKeyPressed!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency z for procedure VaavayOnKeyPressed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency world for procedure VaavayOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		{
			Entity _ent = entity;
			if (_ent instanceof ServerPlayerEntity) {
				BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
				NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return new StringTextComponent("Dialog");
					}

					@Override
					public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
						return new DialogGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
	}
}
