
package net.mcreator.newgenstoryfanaticversion.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.newgenstoryfanaticversion.itemgroup.NewGenStoryItemGroup;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModElements;

@NewgenstoryFanaticVersionModElements.ModElement.Tag
public class AwakenedRunikSwordItem extends NewgenstoryFanaticVersionModElements.ModElement {
	@ObjectHolder("newgenstory_fanatic_version:awakened_runik_sword")
	public static final Item block = null;

	public AwakenedRunikSwordItem(NewgenstoryFanaticVersionModElements instance) {
		super(instance, 60);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1958;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 24f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -2.5f, new Item.Properties().group(NewGenStoryItemGroup.tab)) {
		}.setRegistryName("awakened_runik_sword"));
	}
}
