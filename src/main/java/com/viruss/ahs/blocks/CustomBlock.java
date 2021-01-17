package com.viruss.ahs.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

public class CustomBlock extends Block
{
	public static final DirectionProperty rotation = HorizontalBlock.HORIZONTAL_FACING;	//Rotation
	
	private static final VoxelShape Shape_N = Stream.of(
			Block.makeCuboidShape(5, 3, 10, 11, 10, 11),
			Block.makeCuboidShape(11, 3, 4, 5, 4, 10),
			Block.makeCuboidShape(8, 0, 7, 9, 3, 10)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape Shape_W = Stream.of(
			Block.makeCuboidShape(9.5, 3, 5.833333333333332, 10.5, 10, 11.833333333333332),
			Block.makeCuboidShape(3.5, 3, 11.833333333333332, 9.5, 4, 5.833333333333332),
			Block.makeCuboidShape(6.5, 0, 7.833333333333332, 9.5, 3, 8.833333333333332)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape Shape_S = Stream.of(
			Block.makeCuboidShape(5.333333333333332, 3, 6.333333333333332, 11.333333333333332, 10, 7.333333333333332),
			Block.makeCuboidShape(11.333333333333332, 3, 7.333333333333332, 5.333333333333332, 4, 13.333333333333332),
			Block.makeCuboidShape(7.333333333333332, 0, 7.333333333333332, 8.333333333333332, 3, 10.333333333333332)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape Shape_E = Stream.of(
			Block.makeCuboidShape(5.833333333333332, 3, 5.5, 6.833333333333332, 10, 11.5),
			Block.makeCuboidShape(6.833333333333332, 3, 11.5, 12.833333333333332, 4, 5.5),
			Block.makeCuboidShape(6.833333333333332, 0, 8.5, 9.833333333333332, 3, 9.5)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

	public CustomBlock() 
	{
		super(Block.Properties.create(Material.IRON)
		.hardnessAndResistance(5.0f, 6.0f)		//hardness(Brake),resistance(Explosions)
		.sound(SoundType.METAL)
		.harvestLevel(2)
		.harvestTool(ToolType.PICKAXE)
		);
		this.setDefaultState(this.stateContainer.getBaseState().with(rotation, Direction.NORTH));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(rotation)) {
		case NORTH:
			return Shape_N;
		case SOUTH:
			return Shape_S;
		case EAST:
			return Shape_E;
		case WEST:
			return Shape_W;
		default:
			return Shape_N;
		}
	}
	
	//MOD_INTEGRATION
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context)
	{
		return this.getDefaultState().with(rotation, context.getPlacementHorizontalFacing().getOpposite());
	}
	@Override
	public BlockState rotate(BlockState state, Rotation rot)
	{
		return state.with(rotation, rot.rotate(state.get(rotation)));
	}
	@Override
	public BlockState mirror(BlockState state, Mirror mirror)
	{
		return state.rotate( mirror.toRotation(state.get(rotation)));
	}
	@Override
	protected void fillStateContainer(Builder<Block,BlockState> builder)
	{
		builder.add(rotation);
	}
	
	
	//Right_Click
	//@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult result) {
		if (!worldIn.isRemote()) {
			ServerWorld serverWorld = (ServerWorld) worldIn;
//			LightningBoltEntity entity = new LightningBoltEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), false);
//			serverWorld.addLightningBolt(entity);
		}
		return ActionResultType.SUCCESS;
	}
}
