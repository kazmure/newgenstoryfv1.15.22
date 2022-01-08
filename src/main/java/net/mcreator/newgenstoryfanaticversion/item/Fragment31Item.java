
package net.mcreator.newgenstoryfanaticversion.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.newgenstoryfanaticversion.procedures.Fragment31ItemInInventoryTickProcedure;
import net.mcreator.newgenstoryfanaticversion.itemgroup.NewGenStoryItemGroup;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModElements;

import java.util.Collections;

@NewgenstoryFanaticVersionModElements.ModElement.Tag
public class Fragment31Item extends NewgenstoryFanaticVersionModElements.ModElement {
	@ObjectHolder("newgenstory_fanatic_version:fragment_31")
	public static final Item block = null;

	public Fragment31Item(NewgenstoryFanaticVersionModElements instance) {
		super(instance, 77);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(NewGenStoryItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
			setRegistryName("fragment_31");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			Fragment31ItemInInventoryTickProcedure.executeProcedure(Collections.EMPTY_MAP);
		}
	}
}
