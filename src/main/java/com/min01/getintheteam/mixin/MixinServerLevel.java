package com.min01.getintheteam.mixin;

import java.lang.StackWalker.Option;
import java.util.Optional;
import java.util.function.Supplier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.min01.getintheteam.EventHandlerForge;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.storage.WritableLevelData;
import net.minecraft.world.scores.PlayerTeam;

@Mixin(ServerLevel.class)
public abstract class MixinServerLevel extends Level
{
	protected MixinServerLevel(WritableLevelData p_220352_, ResourceKey<Level> p_220353_, Holder<DimensionType> p_220354_, Supplier<ProfilerFiller> p_220355_, boolean p_220356_, boolean p_220357_, long p_220358_, int p_220359_)
	{
		super(p_220352_, p_220353_, p_220354_, p_220355_, p_220356_, p_220357_, p_220358_, p_220359_);
	}
	
	@Inject(at = @At("HEAD"), method = "addFreshEntity")
	private void addFreshEntity(Entity p_8837_, CallbackInfoReturnable<Boolean> ci)
	{
		Optional<?> walker = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).walk(frames -> frames.map(StackWalker.StackFrame::getDeclaringClass).skip(13).findFirst());
		Optional<?> walker2 = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).walk(frames -> frames.map(StackWalker.StackFrame::getDeclaringClass).skip(12).findFirst());
		Optional<?> walker3 = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).walk(frames -> frames.map(StackWalker.StackFrame::getDeclaringClass).skip(11).findFirst());
		Optional<?> walker4 = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).walk(frames -> frames.map(StackWalker.StackFrame::getDeclaringClass).skip(10).findFirst());
		Optional<?> walker5 = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).walk(frames -> frames.map(StackWalker.StackFrame::getDeclaringClass).skip(9).findFirst());
		Optional<?> walker6 = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).walk(frames -> frames.map(StackWalker.StackFrame::getDeclaringClass).skip(8).findFirst());
		Optional<?> walker7 = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).walk(frames -> frames.map(StackWalker.StackFrame::getDeclaringClass).skip(7).findFirst());
		Optional<?> walker8 = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).walk(frames -> frames.map(StackWalker.StackFrame::getDeclaringClass).skip(6).findFirst());
		Optional<?> walker9 = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).walk(frames -> frames.map(StackWalker.StackFrame::getDeclaringClass).skip(5).findFirst());
		Optional<?> walker10 = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).walk(frames -> frames.map(StackWalker.StackFrame::getDeclaringClass).skip(4).findFirst());
		Optional<?> walker11 = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).walk(frames -> frames.map(StackWalker.StackFrame::getDeclaringClass).skip(3).findFirst());
		Optional<?> walker12 = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).walk(frames -> frames.map(StackWalker.StackFrame::getDeclaringClass).skip(2).findFirst());
		Optional<?> walker13 = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).walk(frames -> frames.map(StackWalker.StackFrame::getDeclaringClass).skip(1).findFirst());
		Optional<?> walker14 = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE).walk(frames -> frames.map(StackWalker.StackFrame::getDeclaringClass).skip(0).findFirst());
		
		Entity entity = null;
		
		if(entity == null && walker.isPresent())
		{
			entity = (Entity) EventHandlerForge.ENTITY_MAP.get(walker.get());
			if(entity == null && walker2.isPresent())
			{
				entity = (Entity) EventHandlerForge.ENTITY_MAP.get(walker2.get());
				if(entity == null && walker3.isPresent())
				{
					entity = (Entity) EventHandlerForge.ENTITY_MAP.get(walker3.get());
					if(entity == null && walker4.isPresent())
					{
						entity = (Entity) EventHandlerForge.ENTITY_MAP.get(walker4.get());
						if(entity == null && walker5.isPresent())
						{
							entity = (Entity) EventHandlerForge.ENTITY_MAP.get(walker5.get());
							if(entity == null && walker6.isPresent())
							{
								entity = (Entity) EventHandlerForge.ENTITY_MAP.get(walker6.get());
								if(entity == null && walker7.isPresent())
								{
									entity = (Entity) EventHandlerForge.ENTITY_MAP.get(walker7.get());
									if(entity == null && walker8.isPresent())
									{
										entity = (Entity) EventHandlerForge.ENTITY_MAP.get(walker8.get());
										if(entity == null && walker9.isPresent())
										{
											entity = (Entity) EventHandlerForge.ENTITY_MAP.get(walker9.get());
											if(entity == null && walker10.isPresent())
											{
												entity = (Entity) EventHandlerForge.ENTITY_MAP.get(walker10.get());
												if(entity == null && walker11.isPresent())
												{
													entity = (Entity) EventHandlerForge.ENTITY_MAP.get(walker11.get());
													if(entity == null && walker12.isPresent())
													{
														entity = (Entity) EventHandlerForge.ENTITY_MAP.get(walker12.get());
														if(entity == null && walker13.isPresent())
														{
															entity = (Entity) EventHandlerForge.ENTITY_MAP.get(walker13.get());
															if(entity == null && walker14.isPresent())
															{
																entity = (Entity) EventHandlerForge.ENTITY_MAP.get(walker14.get());
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		if(entity != null && entity.getTeam() != null && entity.getServer() != null)
		{
			PlayerTeam team = entity.getServer().getScoreboard().getPlayerTeam(entity.getTeam().getName());
			entity.getServer().getScoreboard().addPlayerToTeam(p_8837_.getStringUUID(), team);
		}
	}
}