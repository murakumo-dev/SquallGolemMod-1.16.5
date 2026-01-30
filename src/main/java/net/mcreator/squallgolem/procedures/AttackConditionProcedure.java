package net.mcreator.squallgolem.procedures;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.squallgolem.SquallGolemMod;

import java.util.Map;

public class AttackConditionProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SquallGolemMod.LOGGER.warn("Failed to load dependency entity for procedure AttackCondition!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return !(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == Items.IRON_INGOT);
	}
}
