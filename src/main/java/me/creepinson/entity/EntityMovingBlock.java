package me.creepinson.entity;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityMovingBlock extends EntityCreature {
    private IBlockState fallTile;
    public NBTTagCompound tileEntityData;

    World world = null;

    public EntityMovingBlock(World worldIn) {
        super(worldIn);
        this.world = worldIn;

    }

    public void setState(IBlockState block) {

        this.fallTile = block;

    }

    public EntityMovingBlock(World worldIn, double x, double y, double z, IBlockState state) {
        super(worldIn);
        this.world = worldIn;
        this.setSize(3.98F, 3.98F);
        this.setPosition(x,y,z);
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
        experienceValue = 3;
        this.setState(state);
        setNoAI(false);
        this.tasks.addTask(2, new EntityAISwimming(this));
        this.tasks.addTask(9, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(7, new EntityAIWander(this, 1.2D));
        this.tasks.addTask(10, new EntityAIPanic(this, 1.2D));

    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
            this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(2, new EntityAISwimming(this));
        this.tasks.addTask(9, new EntityAIWander(this, 0.3D));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(7, new EntityAIWander(this, 0.3D));
        this.tasks.addTask(10, new EntityAIPanic(this, 0.3D));

        super.initEntityAI();
    }

    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {



        return super.onInitialSpawn(difficulty, livingdata);
    }

    @Override
    public boolean processInteract(EntityPlayer entity, EnumHand hand) {
        super.processInteract(entity, hand);
        int i = (int) this.posX;
        int j = (int) this.posY;
        int k = (int) this.posZ;

        return true;
    }

    @Override
    protected Item getDropItem() {
        return new ItemStack(this.fallTile.getBlock()).getItem();
    }

    protected void entityInit() {
        super.entityInit();
    }

    /**
     * Returns true if other Entities should be prevented from moving through
     * this Entity.
     */
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public void onLivingUpdate() {
//if(this.fallTile != null){
//		BlockPos below = this.getPosition().down(1);
//		IBlockState belowState = this.world.getBlockState(below);
//		this.setState(belowState);
        //}
        super.onLivingUpdate();
    }

    public void onUpdate() {

		
		/*
         * ticks++;
		 * 
		 * if (ticks == 40) { fallTile = Blocks.DIRT.getDefaultState(); } if
		 * (ticks == 80) { fallTile = Blocks.BONE_BLOCK.getDefaultState(); } if
		 * (ticks == 120) { fallTile = Blocks.EMERALD_BLOCK.getDefaultState();
		 * 
		 * } if (ticks == 160) {
		 * 
		 * ticks = 0;
		 * 
		 * }
		 */

        super.onUpdate();
    }

    @Override
    public boolean isAIDisabled() {

        return false;
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {

        return super.attackEntityAsMob(entityIn);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {

        return super.attackEntityFrom(source, amount);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        Block block = this.fallTile != null ? this.fallTile.getBlock() : Blocks.AIR;
        ResourceLocation resourcelocation = (ResourceLocation)Block.REGISTRY.getNameForObject(block);
        compound.setString("Block", resourcelocation == null ? "" : resourcelocation.toString());
        compound.setByte("Data", (byte)block.getMetaFromState(this.fallTile));

        if (this.tileEntityData != null)
        {
            compound.setTag("TileEntityData", this.tileEntityData);
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        int i = compound.getByte("Data") & 255;

        if (compound.hasKey("Block", 8))
        {
            this.fallTile = Block.getBlockFromName(compound.getString("Block")).getStateFromMeta(i);
        }
        else if (compound.hasKey("TileID", 99))
        {
            this.fallTile = Block.getBlockById(compound.getInteger("TileID")).getStateFromMeta(i);
        }
        else
        {
            this.fallTile = Block.getBlockById(compound.getByte("Tile") & 255).getStateFromMeta(i);
        }


        Block block = this.fallTile.getBlock();



        if (compound.hasKey("TileEntityData", 10))
        {
            this.tileEntityData = compound.getCompoundTag("TileEntityData");
        }

        if (block == null || block.getDefaultState().getMaterial() == Material.AIR)
        {
            this.fallTile = Blocks.STONE.getDefaultState();
        }
    }

    public void addEntityCrashInfo(CrashReportCategory category) {
        super.addEntityCrashInfo(category);

        if (this.fallTile != null) {
            Block block = this.fallTile.getBlock();
            category.addCrashSection("Immitating block ID", Integer.valueOf(Block.getIdFromBlock(block)));
            category.addCrashSection("Immitating block data", Integer.valueOf(block.getMetaFromState(this.fallTile)));
        }
    }

    @SideOnly(Side.CLIENT)
    public World getWorldObj() {
        return this.world;
    }

    /**
     * Return whether this entity should be rendered as on fire.
     */
    @SideOnly(Side.CLIENT)
    public boolean canRenderOnFire() {
        return false;
    }

    @Nullable
    public IBlockState getBlock() {
        return this.fallTile;
    }

    public boolean ignoreItemEntityData() {
        return true;
    }

}