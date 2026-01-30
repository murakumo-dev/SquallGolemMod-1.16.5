package net.mcreator.squallgolem.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.squallgolem.block.ActiveresonancecrystalBlock;
import net.mcreator.squallgolem.SquallGolemMod;

import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Comparator;
import java.util.AbstractMap;

public class SquallgolemOnEntityTickUpdateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SquallGolemMod.LOGGER.warn("Failed to load dependency world for procedure SquallgolemOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SquallGolemMod.LOGGER.warn("Failed to load dependency x for procedure SquallgolemOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SquallGolemMod.LOGGER.warn("Failed to load dependency y for procedure SquallgolemOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SquallGolemMod.LOGGER.warn("Failed to load dependency z for procedure SquallgolemOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SquallGolemMod.LOGGER.warn("Failed to load dependency entity for procedure SquallgolemOnEntityTickUpdate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == Items.IRON_INGOT) {
			entity.rotationYaw = (float) (0);
			entity.setRenderYawOffset(entity.rotationYaw);
			entity.prevRotationYaw = entity.rotationYaw;
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
				((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
				((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
			}
			entity.rotationPitch = (float) (0);
			entity.setMotion(0, 0, 0);
			entity.setInvulnerable(true);
		} else {
			entity.setInvulnerable(false);
		}
		{
			List<Entity> _entfound = world
					.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (entityiterator == ((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null)) {
					if (!(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.IRON_INGOT)) {
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
								.getItem() == Blocks.AIR.asItem()) {
							if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
									.getItem() == Blocks.AIR.asItem()) {
								if (entity instanceof LivingEntity) {
									ItemStack _setstack = new ItemStack(Blocks.COAL_ORE);
									_setstack.setCount((int) 1);
									((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
									if (entity instanceof ServerPlayerEntity)
										((ServerPlayerEntity) entity).inventory.markDirty();
								}
								if (entity instanceof LivingEntity) {
									((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
								}
								if (world instanceof World && !world.isRemote()) {
									((World) world).playSound(null, new BlockPos(x, y, z),
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("squall_golem:squall_golem_attack")),
											SoundCategory.HOSTILE, (float) 2, (float) 1);
								} else {
									((World) world).playSound(x, y, z,
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("squall_golem:squall_golem_attack")),
											SoundCategory.HOSTILE, (float) 2, (float) 1, false);
								}
								new Object() {
									private int ticks = 0;
									private float waitTicks;
									private IWorld world;

									public void start(IWorld world, int waitTicks) {
										this.waitTicks = waitTicks;
										MinecraftForge.EVENT_BUS.register(this);
										this.world = world;
									}

									@SubscribeEvent
									public void tick(TickEvent.ServerTickEvent event) {
										if (event.phase == TickEvent.Phase.END) {
											this.ticks += 1;
											if (this.ticks >= this.waitTicks)
												run();
										}
									}

									private void run() {

										AttackprocedureProcedure.executeProcedure(Stream
												.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity),
														new AbstractMap.SimpleEntry<>("x", (entity.getPosX())),
														new AbstractMap.SimpleEntry<>("y", (entity.getPosY())),
														new AbstractMap.SimpleEntry<>("z", (entity.getPosZ())))
												.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private IWorld world;

											public void start(IWorld world, int waitTicks) {
												this.waitTicks = waitTicks;
												MinecraftForge.EVENT_BUS.register(this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(TickEvent.ServerTickEvent event) {
												if (event.phase == TickEvent.Phase.END) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												if (entity instanceof LivingEntity) {
													ItemStack _setstack = new ItemStack(Blocks.AIR);
													_setstack.setCount((int) 1);
													((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
													if (entity instanceof ServerPlayerEntity)
														((ServerPlayerEntity) entity).inventory.markDirty();
												}
												MinecraftForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 40);
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 13);
							}
						}
					}
				}
			}
		}
		sx = (-3);
		found = (false);
		for (int index0 = 0; index0 < (int) (6); index0++) {
			sy = (-3);
			for (int index1 = 0; index1 < (int) (6); index1++) {
				sz = (-3);
				for (int index2 = 0; index2 < (int) (6); index2++) {
					if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == ActiveresonancecrystalBlock.block) {
						found = (true);
					}
					sz = (sz + 1);
				}
				sy = (sy + 1);
			}
			sx = (sx + 1);
		}
		if (found == true) {
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == Items.IRON_INGOT) {
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Blocks.AIR);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
									.getValue(new ResourceLocation("squall_golem:squall_golem_power_on")),
							SoundCategory.HOSTILE, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
									.getValue(new ResourceLocation("squall_golem:squall_golem_power_on")),
							SoundCategory.HOSTILE, (float) 1, (float) 1, false);
				}
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;

					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(Blocks.MAGMA_BLOCK);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
						}
						new Object() {
							private int ticks = 0;
							private float waitTicks;
							private IWorld world;

							public void start(IWorld world, int waitTicks) {
								this.waitTicks = waitTicks;
								MinecraftForge.EVENT_BUS.register(this);
								this.world = world;
							}

							@SubscribeEvent
							public void tick(TickEvent.ServerTickEvent event) {
								if (event.phase == TickEvent.Phase.END) {
									this.ticks += 1;
									if (this.ticks >= this.waitTicks)
										run();
								}
							}

							private void run() {
								if (entity instanceof LivingEntity) {
									ItemStack _setstack = new ItemStack(Blocks.OBSIDIAN);
									_setstack.setCount((int) 1);
									((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
									if (entity instanceof ServerPlayerEntity)
										((ServerPlayerEntity) entity).inventory.markDirty();
								}
								new Object() {
									private int ticks = 0;
									private float waitTicks;
									private IWorld world;

									public void start(IWorld world, int waitTicks) {
										this.waitTicks = waitTicks;
										MinecraftForge.EVENT_BUS.register(this);
										this.world = world;
									}

									@SubscribeEvent
									public void tick(TickEvent.ServerTickEvent event) {
										if (event.phase == TickEvent.Phase.END) {
											this.ticks += 1;
											if (this.ticks >= this.waitTicks)
												run();
										}
									}

									private void run() {
										if (entity instanceof LivingEntity) {
											ItemStack _setstack = new ItemStack(Blocks.CRYING_OBSIDIAN);
											_setstack.setCount((int) 1);
											((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
											if (entity instanceof ServerPlayerEntity)
												((ServerPlayerEntity) entity).inventory.markDirty();
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private IWorld world;

											public void start(IWorld world, int waitTicks) {
												this.waitTicks = waitTicks;
												MinecraftForge.EVENT_BUS.register(this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(TickEvent.ServerTickEvent event) {
												if (event.phase == TickEvent.Phase.END) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												if (entity instanceof LivingEntity) {
													ItemStack _setstack = new ItemStack(Blocks.BLACKSTONE);
													_setstack.setCount((int) 1);
													((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
													if (entity instanceof ServerPlayerEntity)
														((ServerPlayerEntity) entity).inventory.markDirty();
												}
												new Object() {
													private int ticks = 0;
													private float waitTicks;
													private IWorld world;

													public void start(IWorld world, int waitTicks) {
														this.waitTicks = waitTicks;
														MinecraftForge.EVENT_BUS.register(this);
														this.world = world;
													}

													@SubscribeEvent
													public void tick(TickEvent.ServerTickEvent event) {
														if (event.phase == TickEvent.Phase.END) {
															this.ticks += 1;
															if (this.ticks >= this.waitTicks)
																run();
														}
													}

													private void run() {
														if (entity instanceof LivingEntity) {
															ItemStack _setstack = new ItemStack(Blocks.BLACKSTONE_STAIRS);
															_setstack.setCount((int) 1);
															((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
															if (entity instanceof ServerPlayerEntity)
																((ServerPlayerEntity) entity).inventory.markDirty();
														}
														new Object() {
															private int ticks = 0;
															private float waitTicks;
															private IWorld world;

															public void start(IWorld world, int waitTicks) {
																this.waitTicks = waitTicks;
																MinecraftForge.EVENT_BUS.register(this);
																this.world = world;
															}

															@SubscribeEvent
															public void tick(TickEvent.ServerTickEvent event) {
																if (event.phase == TickEvent.Phase.END) {
																	this.ticks += 1;
																	if (this.ticks >= this.waitTicks)
																		run();
																}
															}

															private void run() {
																if (entity instanceof LivingEntity) {
																	ItemStack _setstack = new ItemStack(Blocks.BLACKSTONE_WALL);
																	_setstack.setCount((int) 1);
																	((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
																	if (entity instanceof ServerPlayerEntity)
																		((ServerPlayerEntity) entity).inventory.markDirty();
																}
																new Object() {
																	private int ticks = 0;
																	private float waitTicks;
																	private IWorld world;

																	public void start(IWorld world, int waitTicks) {
																		this.waitTicks = waitTicks;
																		MinecraftForge.EVENT_BUS.register(this);
																		this.world = world;
																	}

																	@SubscribeEvent
																	public void tick(TickEvent.ServerTickEvent event) {
																		if (event.phase == TickEvent.Phase.END) {
																			this.ticks += 1;
																			if (this.ticks >= this.waitTicks)
																				run();
																		}
																	}

																	private void run() {
																		if (entity instanceof LivingEntity) {
																			ItemStack _setstack = new ItemStack(Blocks.AIR);
																			_setstack.setCount((int) 1);
																			((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
																			if (entity instanceof ServerPlayerEntity)
																				((ServerPlayerEntity) entity).inventory.markDirty();
																		}
																		MinecraftForge.EVENT_BUS.unregister(this);
																	}
																}.start(world, (int) 1);
																MinecraftForge.EVENT_BUS.unregister(this);
															}
														}.start(world, (int) 1);
														MinecraftForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 1);
												MinecraftForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 1);
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 1);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 1);
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 1);
			}
		}
	}
}
