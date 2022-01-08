package net.mcreator.newgenstoryfanaticversion.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.newgenstoryfanaticversion.item.Paper21Item;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionMod;

import java.util.Map;

public class Paper21RightClickedOnBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency entity for procedure Paper21RightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof ServerPlayerEntity) {
			((ServerPlayerEntity) entity).unlockRecipes(new ResourceLocation[]{new ResourceLocation("newgenstory_fanatic_version:mt_craft")});
		}
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(Paper21Item.block);
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
					((PlayerEntity) entity).container.func_234641_j_());
		}
	}
}
