package com.min01.getintheteam;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Getintheteam.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandlerForge
{
	public static final Map<Class<? extends Entity>, Object> ENTITY_MAP = new HashMap<>();
	
	@SubscribeEvent
	public static void entityJoinLevel(EntityJoinLevelEvent event)
	{
		ENTITY_MAP.put(event.getEntity().getClass(), event.getEntity());
	}
}
