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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		all.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.right_reg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}