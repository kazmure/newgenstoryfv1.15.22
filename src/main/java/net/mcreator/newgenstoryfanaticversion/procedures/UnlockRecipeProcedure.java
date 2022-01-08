package net.mcreator.newgenstoryfanaticversion.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModVariables;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionMod;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class UnlockRecipeProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			Entity entity = event.getPlayer();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", entity.getPosX());
			dependencies.put("y", entity.getPosY());
			dependencies.put("z", entity.getPosZ());
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency entity for procedure UnlockRecipe!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NewgenstoryFanaticVersionModVariables.PlayerVariables())).Recipe == 0) {
			new Object() {
				public void removeRecipe(Entity _ent, ResourceLocation recipe) {
					if (_ent instanceof ServerPlayerEntity)
						((ServerPlayerEntity) _ent).world.getRecipeManager().getRecipe(recipe)
								.ifPresent(_rec -> ((ServerPlayerEntity) _ent).resetRecipes(Collections.singleton(_rec)));
				}
			}.removeRecipe(entity, new ResourceLocation("newgenstory_fanatic_version:mt_craft"));
			{
				double _setval = 1;
				entity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Recipe = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
