
package net.mcreator.newgenstoryfanaticversion.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.newgenstoryfanaticversion.itemgroup.NewGenStoryItemGroup;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModElements;

@NewgenstoryFanaticVersionModElements.ModElement.Tag
public class Fragment32Item extends NewgenstoryFanaticVersionModElements.ModElement {
	@ObjectHolder("newgenstory_fanatic_version:fragment_32")
	public static final Item block = null;

	public Fragment32Item(NewgenstoryFanaticVersionModElements instance) {
		super(instance, 78);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(NewGenStoryItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
			setRegistryName("fragment_32");
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
	}
}
