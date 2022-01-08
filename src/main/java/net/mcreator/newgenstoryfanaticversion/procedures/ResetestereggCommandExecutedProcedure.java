package net.mcreator.newgenstoryfanaticversion.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionModVariables;
import net.mcreator.newgenstoryfanaticversion.NewgenstoryFanaticVersionMod;

import java.util.Map;

public class ResetestereggCommandExecutedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NewgenstoryFanaticVersionMod.LOGGER.warn("Failed to load dependency entity for procedure ResetestereggCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = 0;
			entity.getCapability(NewgenstoryFanaticVersionModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.EsterEgg21 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
