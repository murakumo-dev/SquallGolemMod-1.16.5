
package net.mcreator.squallgolem.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.Hand;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import net.mcreator.squallgolem.entity.SquallgolemEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class SquallgolemRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(SquallgolemEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelsquall_golem(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("squall_golem:textures/squall_golem.png");
					}
				};
			});
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn
					.getBuffer(RenderType.getEyes(new ResourceLocation("squall_golem:textures/squall_golem_glow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 4.2.4
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelsquall_golem extends EntityModel<Entity> {
		private final ModelRenderer all;
		private final ModelRenderer legs;
		private final ModelRenderer right_reg;
		private final ModelRenderer left_leg;
		private final ModelRenderer UpperBody;
		private final ModelRenderer head;
		private final ModelRenderer body;
		private final ModelRenderer others;
		private final ModelRenderer nazo_right;
		private final ModelRenderer uenotukuri_2;
		private final ModelRenderer cube_r1;
		private final ModelRenderer nazo_left;
		private final ModelRenderer uenotukuri;
		private final ModelRenderer cube_r2;
		private final ModelRenderer chest;
		private final ModelRenderer arms;
		private final ModelRenderer left_arm;
		private final ModelRenderer right_arm;

		public Modelsquall_golem() {
			textureWidth = 128;
			textureHeight = 128;
			all = new ModelRenderer(this);
			all.setRotationPoint(-1.0F, -9.0F, -1.0F);
			legs = new ModelRenderer(this);
			legs.setRotationPoint(1.0F, 34.0F, 1.0F);
			all.addChild(legs);
			right_reg = new ModelRenderer(this);
			right_reg.setRotationPoint(-7.0F, -15.0F, 0.0F);
			legs.addChild(right_reg);
			right_reg.setTextureOffset(92, 37).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 15.0F, 8.0F, 0.0F, false);
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(7.0F, -15.0F, 0.0F);
			legs.addChild(left_leg);
			left_leg.setTextureOffset(92, 37).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 15.0F, 8.0F, 0.0F, false);
			UpperBody = new ModelRenderer(this);
			UpperBody.setRotationPoint(1.0F, 17.0F, 1.0F);
			all.addChild(UpperBody);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -19.0F, -7.0F);
			UpperBody.addChild(head);
			head.setTextureOffset(77, 106).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 13.0F, 9.0F, 0.0F, false);
			head.setTextureOffset(54, 121).addBox(-1.0F, -8.0F, -10.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
			head.setTextureOffset(62, 118).addBox(-2.0F, 0.0F, -11.0F, 4.0F, 7.0F, 3.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			UpperBody.addChild(body);
			others = new ModelRenderer(this);
			others.setRotationPoint(-37.0F, 25.0F, 0.0F);
			body.addChild(others);
			nazo_right = new ModelRenderer(this);
			nazo_right.setRotationPoint(25.0F, -56.0F, -4.0F);
			others.addChild(nazo_right);
			nazo_right.setTextureOffset(112, 0).addBox(-2.0F, 4.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			uenotukuri_2 = new ModelRenderer(this);
			uenotukuri_2.setRotationPoint(0.0F, 0.0F, 0.0F);
			nazo_right.addChild(uenotukuri_2);
			uenotukuri_2.setTextureOffset(109, 19).addBox(0.0F, -5.0F, -5.0F, 0.0F, 8.0F, 4.0F, 0.0F, false);
			uenotukuri_2.setTextureOffset(120, 14).addBox(0.0F, -5.0F, 1.0F, 0.0F, 8.0F, 4.0F, 0.0F, false);
			uenotukuri_2.setTextureOffset(120, 6).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, -1.0F, 0.0F);
			uenotukuri_2.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
			cube_r1.setTextureOffset(108, 19).addBox(0.0F, -4.0F, 1.0F, 0.0F, 8.0F, 4.0F, 0.0F, false);
			cube_r1.setTextureOffset(109, 19).addBox(0.0F, -4.0F, -5.0F, 0.0F, 8.0F, 4.0F, 0.0F, false);
			nazo_left = new ModelRenderer(this);
			nazo_left.setRotationPoint(49.0F, -56.0F, -4.0F);
			others.addChild(nazo_left);
			setRotationAngle(nazo_left, 0.0F, -1.5708F, 0.0F);
			nazo_left.setTextureOffset(112, 0).addBox(-2.0F, 4.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			uenotukuri = new ModelRenderer(this);
			uenotukuri.setRotationPoint(0.0F, -1.0F, 0.0F);
			nazo_left.addChild(uenotukuri);
			uenotukuri.setTextureOffset(120, 6).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);
			uenotukuri.setTextureOffset(120, 14).addBox(0.0F, -4.0F, 1.0F, 0.0F, 8.0F, 4.0F, 0.0F, false);
			uenotukuri.setTextureOffset(109, 19).addBox(0.0F, -4.0F, -5.0F, 0.0F, 8.0F, 4.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
			uenotukuri.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, -1.5708F, 0.0F);
			cube_r2.setTextureOffset(109, 19).addBox(0.0F, -4.0F, -5.0F, 0.0F, 8.0F, 4.0F, 0.0F, false);
			cube_r2.setTextureOffset(108, 19).addBox(0.0F, -4.0F, 1.0F, 0.0F, 8.0F, 4.0F, 0.0F, false);
			chest = new ModelRenderer(this);
			chest.setRotationPoint(0.0F, 17.0F, 0.0F);
			body.addChild(chest);
			chest.setTextureOffset(0, 0).addBox(-15.0F, -43.0F, -7.0F, 30.0F, 22.0F, 14.0F, 0.0F, false);
			chest.setTextureOffset(1, 37).addBox(-8.0F, -21.0F, -4.0F, 16.0F, 5.0F, 8.0F, 0.0F, false);
			arms = new ModelRenderer(this);
			arms.setRotationPoint(-1.0F, -21.0F, 1.0F);
			UpperBody.addChild(arms);
			left_arm = new ModelRenderer(this);
			left_arm.setRotationPoint(18.0F, 0.3927F, 0.7544F);
			arms.addChild(left_arm);
			left_arm.setTextureOffset(0, 53).addBox(-2.0F, -1.0F, -5.0F, 6.0F, 35.0F, 9.0F, 0.0F, false);
			left_arm.setTextureOffset(0, 117).addBox(-2.0F, 30.0F, 4.0F, 6.0F, 4.0F, 7.0F, 0.0F, false);
			right_arm = new ModelRenderer(this);
			right_arm.setRotationPoint(-17.0F, 0.3927F, 0.7544F);
			arms.addChild(right_arm);
			right_arm.setTextureOffset(0, 53).addBox(-3.0F, -1.0F, -5.0F, 6.0F, 35.0F, 9.0F, 0.0F, false);
			right_arm.setTextureOffset(0, 117).addBox(-3.0F, 30.0F, 4.0F, 6.0F, 4.0F, 7.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			all.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		MobEntity entity = (MobEntity) e;
		float armSwing = (MathHelper.cos(f * 0.4f) - 1) * f1 / 3;
		float legSwing = MathHelper.cos(f * 0.4F) * 1.0F * f1 / 3;
		if (((e instanceof LivingEntity) ? ((LivingEntity) e).getHeldItemOffhand() : ItemStack.EMPTY)
		.getItem() == Blocks.AIR.asItem()) {
		this.arms.rotateAngleX = 0;
		/*this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);*/
			float rightarmidle = -armSwing;
			float rightwristidle = -armSwing;
					//+ (MathHelper.cos(f * speed / 2 + (float) Math.PI) - 1) * f1 * (0.15f + speed / 6.2f);
			float a = (0.5f - this.swingProgress) * 2;
			float MobSwingprogress = entity.swingProgress;
			a = a * a;
			a = a * a;
			a = 1.0F - a;
			float b = (1f - this.swingProgress) * 2;
			b = b * b;
			b = b * b;
			b = 1.0F - b;
			float num1 = f4 / (180F * 12 / (float) Math.PI);
			float bs1 = MathHelper.clamp(b * 2, 0, 1);
			float aa = a * 0.4f;
			float bb = 0.4f - MathHelper.sin(bs1 * 0.5f * (float) Math.PI) * 0.8f;
			float cc = -0.4f * (1 - MobSwingprogress) * 3.3f;
				if (entity.isSwingInProgress) {
				if (MobSwingprogress <= 0.5f) {
					//charge
					this.right_arm.rotateAngleX = (rightarmidle * (1 - a) - a * (float) Math.PI * 1.2f - num1 * 12);
					this.left_arm.rotateAngleX = (rightarmidle * (1 - a) - a * (float) Math.PI * 1.2f - num1 * 12);
					this.right_arm.rotateAngleY = -aa;
					this.left_arm.rotateAngleY = aa;
					this.UpperBody.rotateAngleX = (-a * 0.4f + num1 * 4);
				} else if (entity.swingProgress <= 0.7f) {//furiorosi
					this.right_arm.rotateAngleX = -(1.25f - bs1) * (float) Math.PI * 0.7f - num1 * 12;
					this.right_arm.rotateAngleY = -bb;
					this.left_arm.rotateAngleX = -(1.25f - bs1) * (float) Math.PI * 0.7f - num1 * 12;
					this.left_arm.rotateAngleY = bb;
					this.UpperBody.rotateAngleX = -0.4f + num1 * 4 + MathHelper.sin(bs1 * (float) Math.PI * 0.5f) * 1f;
				} else {//modosu
					this.right_arm.rotateAngleX = ((-0.25f * (float) Math.PI * 0.7f) * (1 - MobSwingprogress) * 3.3f - num1 * 12);
					this.right_arm.rotateAngleY = -cc;
					this.left_arm.rotateAngleX =  ((-0.25f * (float) Math.PI * 0.7f) * (1 - MobSwingprogress) * 3.3f - num1 * 12);
					this.left_arm.rotateAngleY = cc;
					this.UpperBody.rotateAngleX =  (num1 * 4 + 0.6f * (1 - MobSwingprogress) * 3.3f);
				}
			} else {
			this.UpperBody.rotateAngleX = (MathHelper.cos(f * 0.8F) + 2) * f1 / 6;
			this.right_arm.rotateAngleY = 0;
			this.left_arm.rotateAngleY = 0;
			this.right_arm.rotateAngleX = -armSwing;
			this.left_arm.rotateAngleX = armSwing;
			this.right_reg.rotateAngleX = -armSwing;
			this.left_leg.rotateAngleX = armSwing;
			}	
		}else{
			if (((e instanceof LivingEntity) ? ((LivingEntity) e).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == Items.IRON_INGOT) {
			this.UpperBody.rotateAngleX = 0.5236F;
			this.arms.rotateAngleX = -0.5672F;
			}
			if (((e instanceof LivingEntity) ? ((LivingEntity) e).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == Blocks.MAGMA_BLOCK.asItem()) {
			this.UpperBody.rotateAngleX = 0.5236F;
			this.arms.rotateAngleX = -0.5672F;
			}
			if (((e instanceof LivingEntity) ? ((LivingEntity) e).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == Blocks.OBSIDIAN.asItem()) {
			this.UpperBody.rotateAngleX = 0.4363F;
			this.arms.rotateAngleX = -0.4363F;
			}
			if (((e instanceof LivingEntity) ? ((LivingEntity) e).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == Blocks.CRYING_OBSIDIAN.asItem()) {
			this.UpperBody.rotateAngleX = 0.2618F;
			this.arms.rotateAngleX = -0.2618F;
			}
			if (((e instanceof LivingEntity) ? ((LivingEntity) e).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == Blocks.BLACKSTONE.asItem()) {
			this.UpperBody.rotateAngleX = 0.1745F;
			this.arms.rotateAngleX = -0.1745F;
			}
			if (((e instanceof LivingEntity) ? ((LivingEntity) e).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == Blocks.BLACKSTONE_STAIRS.asItem()) {
			this.UpperBody.rotateAngleX = 0.0873F;
			this.arms.rotateAngleX = -0.0873F;
			}
			if (((e instanceof LivingEntity) ? ((LivingEntity) e).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == Blocks.BLACKSTONE_WALL.asItem()) {
			this.UpperBody.rotateAngleX = 0.0873F;
			this.arms.rotateAngleX = -0.0873F;
				}
			}
		}
	}
}