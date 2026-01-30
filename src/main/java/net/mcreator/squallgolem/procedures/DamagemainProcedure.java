package net.mcreator.squallgolem.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.squallgolem.SquallGolemMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class DamagemainProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SquallGolemMod.LOGGER.warn("Failed to load dependency world for procedure Damagemain!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SquallGolemMod.LOGGER.warn("Failed to load dependency x for procedure Damagemain!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SquallGolemMod.LOGGER.warn("Failed to load dependency y for procedure Damagemain!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SquallGolemMod.LOGGER.warn("Failed to load dependency z for procedure Damagemain!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SquallGolemMod.LOGGER.warn("Failed to load dependency entity for procedure Damagemain!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double Zknockback = 0;
		double Yknockback = 0;
		double Xknockback = 0;
		double dis = 0;
		{
			List<Entity> _entfound = world
					.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(x - (6 / 2d), y - (6 / 2d), z - (6 / 2d), x + (6 / 2d), y + (6 / 2d), z + (6 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof LivingEntity) {
					if (!(entityiterator == entity)) {
						Xknockback = (entityiterator.getPosX() - entity.getPosX());
						Yknockback = (entityiterator.getPosY() - entity.getPosY());
						Zknockback = (entityiterator.getPosZ() - entity.getPosZ());
						dis = (Math.abs(Xknockback) + Math.abs(Yknockback) + Math.abs(Zknockback));
						if (dis != 0) {
							Xknockback = ((Xknockback / dis) * 3);
							Yknockback = Math.min((Yknockback / dis) * 3, 2);
							Zknockback = ((Zknockback / dis) * 3);
						} else {
							Xknockback = 0;
							Yknockback = 0;
							Zknockback = 0;
						}
						entityiterator.setMotion(Xknockback, Yknockback, Zknockback);
					}
				}
			}
		}
	}
}
