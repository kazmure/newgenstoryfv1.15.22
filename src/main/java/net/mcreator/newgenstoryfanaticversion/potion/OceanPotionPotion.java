
package net.mcreator.newgenstoryfanaticversion.potion;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.potion.Potion;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;

import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModElements;

@NewgenstoryFanaticVersionModElements.ModElement.Tag
public class OceanPotionPotion extends NewgenstoryFanaticVersionModElements.ModElement {
	@ObjectHolder("newgenstory_fanatic_version:ocean_potion")
	public static final Potion potionType = null;
	public OceanPotionPotion(NewgenstoryFanaticVersionModElements instance) {
		super(instance, 86);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPotion(RegistryEvent.Register<Potion> event) {
		event.getRegistry().register(new PotionCustom());
	}
	public static class PotionCustom extends Potion {
		public PotionCustom() {
			super(new EffectInstance(Effects.DOLPHINS_GRACE, 3600, 0, false, true), new EffectInstance(Effects.SPEED, 3600, 0, false, true),
					new EffectInstance(Effects.HASTE, 3600, 0, false, true));
			setRegistryName("ocean_potion");
		}
	}
}
