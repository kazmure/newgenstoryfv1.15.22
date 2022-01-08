
package net.mcreator.newgenstoryfanaticversion.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.newgenstoryfanaticversion.item.DrilItem;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModElements;

@NewgenstoryFanaticVersionModElements.ModElement.Tag
public class NewGenStoryItemGroup extends NewgenstoryFanaticVersionModElements.ModElement {
	public NewGenStoryItemGroup(NewgenstoryFanaticVersionModElements instance) {
		super(instance, 56);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabnew_gen_story") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(DrilItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
